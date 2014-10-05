package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.QualificationForm;

public class QualifiactionDaoImpl {

	public List<QualificationForm> listAll(DataSource dataSource) {
		// TODO Auto-generated method stub
		
		List<QualificationForm> list = new ArrayList<QualificationForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QualificationForm qualificationForm = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM qualificationmaster ORDER BY qualificationname ASC";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   qualificationForm = new QualificationForm();
			   qualificationForm.setQualificationid(rs.getInt("QUALIFICATIONID"));
			   qualificationForm.setQualificationname(rs.getString("QUALIFICATIONNAME"));
			   qualificationForm.setActive(rs.getBoolean("ACTIVE"));
			   list.add(qualificationForm);
		   }
		}
		catch (Exception e) 
		{
		   System.out.println("Exception is "+e);
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
			  System.out.println(e2);
			}
		}
		return list;
	}
	

	public String add(QualificationForm qualificationform, DataSource dataSource) {
		// TODO Auto-generated method stub
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from qualificationmaster where QUALIFICATIONNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qualificationform.getQualificationname());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				if(!qualificationform.getQualificationname().equalsIgnoreCase("") && !qualificationform.getQualificationname().equalsIgnoreCase(null))
				{
					sql = "insert into qualificationmaster (QUALIFICATIONNAME,ACTIVE) values (?,?)";
					if(pstmt!=null)
						pstmt.close();
					pstmt = con.prepareStatement(sql);
					//pstmt.setInt(1, qualificationform.getQualificationid());
					pstmt.setString(1, qualificationform.getQualificationname());
					pstmt.setBoolean(2, true);
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
		
	public Object changeStatus(QualificationForm qualificationform,DataSource dataSource) {
		// TODO Auto-generated method stub
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "update qualificationmaster set active = ? where QUALIFICATIONID=?";
		   pstmt=con.prepareStatement(sql);
		   pstmt.setBoolean(1,qualificationform.isActive());
		   pstmt.setInt(2, qualificationform.getQualificationid());
		   pstmt.executeUpdate();
		   result=iERPConstants.REC_STATUS_CHANGED;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return result;
	}

	
	public Object update(QualificationForm qualificationform,DataSource dataSource) {
		// TODO Auto-generated method stub
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM qualificationmaster WHERE QUALIFICATIONNAME COLLATE latin1_general_cs LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,qualificationform.getQualificationname());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.No_Change;
			else
			{
				if(!qualificationform.getQualificationname().equalsIgnoreCase("") && !qualificationform.getQualificationname().equalsIgnoreCase(null))
				{
					sql="UPDATE QUALIFICATIONMASTER SET QUALIFICATIONNAME=? WHERE QUALIFICATIONID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, qualificationform.getQualificationname());
					pstmt.setLong(2, qualificationform.getQualificationid());
					pstmt.executeUpdate();
					if(rs!=null)
						rs.close();
					result=iERPConstants.REC_UPDATED;
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
				System.out.println(e);
			}
		}
		return result;
	}


	public List<QualificationForm> activeList(DataSource dataSource) {
		// TODO Auto-generated method stub
		List<QualificationForm> list = new ArrayList<QualificationForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QualificationForm qualificationForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from qualificationmaster where active = true order by QUALIFICATIONNAME ASC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				qualificationForm = new QualificationForm();
				qualificationForm.setQualificationid(rs.getInt("QUALIFICATIONID"));
				qualificationForm.setQualificationname(rs.getString("QUALIFICATIONNAME"));
				qualificationForm.setActive(rs.getBoolean("active"));
				list.add(qualificationForm);
				
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
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
	}
	
	
}
