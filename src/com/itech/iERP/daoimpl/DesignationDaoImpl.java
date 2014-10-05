package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.DesignationForm;
import com.itech.iERP.forms.RoleForm;

public class DesignationDaoImpl 
{

	public List<DesignationForm> listAll(long compid, DataSource dataSource) 
	{
		List<DesignationForm> list= new ArrayList<DesignationForm>();
		DesignationForm roleForm=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM designationmaster where compid = '"+compid+"' ORDER BY designationname ASC";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				roleForm= new DesignationForm();
				roleForm.setDesid(rs.getInt("desgid"));
				roleForm.setDesname(rs.getString("designationname"));
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

	public String add(DesignationForm roleForm, long compid, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM designationmaster WHERE designationname=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, roleForm.getDesname());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				result="Designation already exist, please enter some other name";
			else{
				if(!roleForm.getDesname().equalsIgnoreCase("")&&!roleForm.getDesname().equalsIgnoreCase(null))
				{
				sql="INSERT INTO designationmaster (desgid,designationname,ACTIVE,compid) VALUES ('"+roleForm.getDesid()+"','"+roleForm.getDesname()+"','"+1+"','"+compid+"') ";
				System.out.println("Sql new query "+sql);
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				//pstmt.setInt(1, roleForm.getDesid());
				//pstmt.setString(2, roleForm.getDesname());
				//pstmt.setBoolean(3, true);
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

	public String changeStatus(DesignationForm roleForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE designationmaster SET ACTIVE=? WHERE desgid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, roleForm.isActive());
			pstmt.setInt(2, roleForm.getDesid());
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

	public String update(DesignationForm roleForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM designationmaster WHERE designationname COLLATE latin1_general_cs LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, roleForm.getDesname());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.No_Change;
			else{
				if(!roleForm.getDesname().equalsIgnoreCase("")&&!roleForm.getDesname().equalsIgnoreCase(null))
				{
					 sql="UPDATE designationmaster SET designationname=? WHERE desgid=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, roleForm.getDesname());
					pstmt.setLong(2, roleForm.getDesid());
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
