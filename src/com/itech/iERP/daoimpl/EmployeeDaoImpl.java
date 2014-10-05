package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.EmployeeForm;

public class EmployeeDaoImpl {

	public List<EmployeeForm> listAll( DataSource dataSource) 
	{
	    List<EmployeeForm> list = new ArrayList<EmployeeForm>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    EmployeeForm employeeform = null;
	    try
	    {
	    	con = dataSource.getConnection();
	    	String sql = "select* from empmaster";
	    	pstmt = con.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
	    	while(rs.next())
	    	{
	    		employeeform = new EmployeeForm();
	    		employeeform.setEmpNo(rs.getInt("empid"));
	    		employeeform.setFirstName(rs.getString("firstname"));
	    		employeeform.setLastName(rs.getString("lastname"));
	    		employeeform.setEmail(rs.getString("email"));
	    		employeeform.setMobile(rs.getString("mobno"));
	    		employeeform.setAlternateNum(rs.getString("alternateno"));
	    		employeeform.setDayOfJoining(rs.getString("doj"));
	    		employeeform.setDayOfBirth(rs.getString("dob"));
	    		employeeform.setPassportNo(rs.getString("passportno"));
	    		employeeform.setBankAccountNo(rs.getString("bankaccno"));
	    		employeeform.setPersentAddress(rs.getString("presentaddress"));
	    		employeeform.setPermanentAddress(rs.getString("permanentddress"));
	    		employeeform.setActive(rs.getBoolean("active"));
	    		list.add(employeeform);
	    	}
	    	
	    }
	    catch (Exception e)
	    {
			e.printStackTrace();
		}
	    
	    
	    
		return list;
	}

	public String changeStatus(EmployeeForm employeeForm, DataSource dataSource) 
	{
	    
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE empmaster SET ACTIVE=? WHERE empid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, employeeForm.isActive());
			pstmt.setInt(2, employeeForm.getEmpNo());
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

	public String add(EmployeeForm employeeForm, DataSource dataSource) 
	{
		java.sql.Timestamp ts = new java.sql.Timestamp(System
				.currentTimeMillis());
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM empmaster WHERE firstname=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, employeeForm.getFirstName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else{
				if(!employeeForm.getFirstName().equalsIgnoreCase("")&&!employeeForm.getFirstName().equalsIgnoreCase(null))
				{
				sql="INSERT INTO empmaster (empid,firstname,lastname,email,maritalstatus,doj,gender,qualid,mobno,alternateno,desgid,dob,passportno,bankid,bankaccno,presentaddress,permanentddress,ACTIVE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, employeeForm.getEmpNo());
				pstmt.setString(2, employeeForm.getFirstName());
				pstmt.setString(3, employeeForm.getLastName());
				pstmt.setString(4, employeeForm.getEmail());
				pstmt.setString(5, employeeForm.getMaritalStatus());
				pstmt.setString(6, employeeForm.getDayOfJoining());
				pstmt.setString(7, employeeForm.getGender());
                pstmt.setString(8, employeeForm.getQualificationid());
                pstmt.setString(9, employeeForm.getMobile());
                pstmt.setString(10, employeeForm.getAlternateNum());
                pstmt.setString(11,employeeForm.getDesid());
                pstmt.setString(12, employeeForm.getDayOfBirth());
                pstmt.setString(13,employeeForm.getPassportNo());
                pstmt.setString(14,employeeForm.getBankId());
                pstmt.setString(15, employeeForm.getBankAccountNo());
                pstmt.setString(16, employeeForm.getPersentAddress());
                pstmt.setString(17, employeeForm.getPermanentAddress());
				pstmt.setBoolean(18, true);
				pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result=iERPConstants.REC_ADDED;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	public String update(EmployeeForm employeeForm, DataSource dataSource) 
	{
		String result="fail";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="";
			
			//if(rs.next())result=Common.DUPLICATE_NAME_MESSAGE;
			//else{
				if(!employeeForm.getFirstName().equalsIgnoreCase("")&&!employeeForm.getFirstName().equalsIgnoreCase(null))
				{
					// sql="UPDATE empmaster SET FIRSTNAME=? , LASTNAME=? , ADDRESS=?, TELNO=? , MOBNO = ? ,EMAILID1=?,EMAILID2=?, WEBSITE=? WHERE VENDORID=?";
					sql="UPDATE empmaster SET firstname=? , lastname=? , email=?,dob=?,gender=?,qualid=?,mobno=?, alternateno=?, desgid=?,doj=?,passportno=?,bankaccno=?,permanentddress=?,presentaddress=? WHERE empid=?";
					System.out.println(sql);
					 pstmt=con.prepareStatement(sql);			
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,employeeForm.getFirstName());
					pstmt.setString(2,employeeForm.getLastName());
					pstmt.setString(3,employeeForm.getEmail());
                    //pstmt.setString(4,employeeForm.getMaritalStatus());
                    pstmt.setString(4,employeeForm.getDayOfBirth());
                    pstmt.setString(5,employeeForm.getGender());
                    pstmt.setString(6,employeeForm.getQualificationid());
                    pstmt.setString(7,employeeForm.getMobile());
                    pstmt.setString(8,employeeForm.getAlternateNum());
                    pstmt.setString(9,employeeForm.getDesid());
                    pstmt.setString(10,employeeForm.getDayOfJoining());
                    pstmt.setString(11,employeeForm.getPassportNo());
                    pstmt.setString(12,employeeForm.getBankAccountNo());
                    pstmt.setString(13,employeeForm.getPermanentAddress());
                    pstmt.setString(14,employeeForm.getPersentAddress());
                    
					pstmt.setLong(15, employeeForm.getEmpNo());
					
					pstmt.executeUpdate();
				
	    		result="success";
				}
			//}
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
