package com.itech.iERP.daoimpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.BankForm;
import com.itech.iERP.forms.CompanyForm;

public class CompanyDaoImpl {

	public String add(CompanyForm compForm, String fileName,
			DataSource dataSource) throws FileNotFoundException,Exception
	{
		
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		 FileInputStream inputStream = null;
		  File image = new File("C:/"+fileName);
		  inputStream = new FileInputStream(image);
		
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from companymaster where COMPANYNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, compForm.getCompanyName());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				if(!compForm.getCompanyName().equalsIgnoreCase("")&&!compForm.getCompanyName().equalsIgnoreCase(null))
				{
					//sql = "insert into companymaster (COMPANYID,COMPANYNAME,COMPANYLOGO,ADDRESS,EMAILID1,EMAILID2,CONTACT NUMBER,ACTIVE) values (?,?,?,?,?,?,?,?)";
					  sql = "insert into companymaster (COMPANYID,COMPANYNAME,ADDRESS,EMAILID1,EMAILID2,CONTACTNUMBER,COMPANYLOGO,AttLateCutOffTime,ACTIVE) values (?,?,?,?,?,?,?,?,?)";
					  System.out.println(sql);
					  if(pstmt!=null)
						pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setLong(1, compForm.getCompanyId());
					pstmt.setString(2, compForm.getCompanyName());
					//pstmt.setBinaryStream(3, (InputStream)inputStream,(int)(image.length()));
    				pstmt.setString(3, compForm.getAddress());
     				pstmt.setString(4,compForm.getEmailId1());
 					pstmt.setString(5,compForm.getEmailId2());
					pstmt.setString(6,compForm.getContactNo());
					pstmt.setBinaryStream(7, (InputStream)inputStream,(int)(image.length()));
					pstmt.setString(8,compForm.getALCutOff());
					pstmt.setBoolean(9, true);
					pstmt.executeUpdate();
					if(rs!=null)
						rs.close();
					result=iERPConstants.REC_ADDED;
			}	
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<CompanyForm> listAll(DataSource dataSource) 
	{
		List<CompanyForm> list= new ArrayList<CompanyForm>();
		CompanyForm roleForm=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM companymaster ORDER BY COMPANYNAME ASC";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				roleForm= new CompanyForm();
				roleForm.setCompanyId(rs.getInt("COMPANYID"));
				roleForm.setCompanyName(rs.getString("COMPANYNAME"));
				roleForm.setEmailId1(rs.getString("EMAILID1"));
				roleForm.setEmailId2(rs.getString("EMAILID2"));
				roleForm.setContactNo(rs.getString("CONTACTNUMBER"));
				roleForm.setALCutOff(rs.getString("AttLateCutOffTime"));
				roleForm.setActive(rs.getBoolean("active"));
			    list.add(roleForm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return list;
	}

	public String changeStatus(CompanyForm compForm, DataSource dataSource)
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE companymaster SET ACTIVE=? WHERE COMPANYID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, compForm.isActive());
			pstmt.setInt(2,compForm.getCompanyId());
			pstmt.executeUpdate();
			result=iERPConstants.REC_STATUS_CHANGED;
			System.out.println(result+ "Hi");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	public String update(CompanyForm compForm,String fileName,DataSource dataSource) throws FileNotFoundException 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		FileInputStream inputStream = null;
		  File image = new File("C:/"+fileName);
		  inputStream = new FileInputStream(image);
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM companymaster WHERE COMPANYNAME AND EMAILID1 AND EMAILID2 AND CONTACTNUMBER AND AttLateCutOffTime  LIKE ? ";
			//String sql = "SELECT * FROM usermaster WHERE USERNAME AND PASSWORD AND FIRSTNAME AND LASTNAME AND PHONE1 AND PHONE2 AND EMAILID AND SSN  LIKE ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, compForm.getCompanyName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.No_Change;
			else{
				if(!compForm.getCompanyName().equalsIgnoreCase("")&&!compForm.getCompanyName().equalsIgnoreCase(null))
				{
					 sql="UPDATE companymaster SET COMPANYNAME=?,COMPANYLOGO=?,ADDRESS=?,EMAILID1=?,EMAILID2=?,CONTACTNUMBER=?,AttLateCutOffTime=? WHERE COMPANYID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, compForm.getCompanyName());
					pstmt.setBinaryStream(2, (InputStream)inputStream,(int)(image.length()));
					pstmt.setString(3,compForm.getAddress());
					pstmt.setString(4,compForm.getEmailId1());
					pstmt.setString(5,compForm.getEmailId2());
					pstmt.setString(6, compForm.getContactNo());
					pstmt.setString(7, compForm.getALCutOff());
					pstmt.setLong(8, compForm.getCompanyId());
					pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result=iERPConstants.REC_UPDATED;
				}
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

}
