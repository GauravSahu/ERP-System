package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.RoleForm;

public class RoleDaoImpl 
{

	public List<RoleForm> listAll(long compid, DataSource dataSource) 
	{
		List<RoleForm> list= new ArrayList<RoleForm>();
		RoleForm roleForm=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM ROLEMASTER where compid = '"+compid+"' ORDER BY rolename ASC";
			System.out.println("inside the sql "+sql);
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				roleForm= new RoleForm();
				roleForm.setRoleid(rs.getInt("roleid"));
				roleForm.setRolename(rs.getString("rolename"));
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

	public String add(long compid, RoleForm roleForm, DataSource dataSource) 
	{
		
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;

		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM ROLEMASTER WHERE ROLENAME=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, roleForm.getRolename());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else{
				if(!roleForm.getRolename().equalsIgnoreCase("")&&!roleForm.getRolename().equalsIgnoreCase(null))
				{
				sql="INSERT INTO ROLEMASTER (ROLEID,ROLENAME,ACTIVE,compid) VALUES (?,?,?,?)";
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, roleForm.getRoleid());
				pstmt.setString(2, roleForm.getRolename());
				pstmt.setBoolean(3, true);
				pstmt.setLong(4,compid);
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

	public String changeStatus(RoleForm roleForm, DataSource dataSource)
	{
		
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE ROLEMASTER SET ACTIVE=? WHERE ROLEID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, roleForm.isActive());
			pstmt.setInt(2, roleForm.getRoleid());
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

	public String update(RoleForm roleForm, DataSource dataSource)
	{
		
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM ROLEMASTER WHERE ROLENAME COLLATE latin1_general_cs LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, roleForm.getRolename());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.No_Change;
			else{
				if(!roleForm.getRolename().equalsIgnoreCase("")&&!roleForm.getRolename().equalsIgnoreCase(null))
				{
					 sql="UPDATE ROLEMASTER SET ROLENAME=? WHERE ROLEID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, roleForm.getRolename());
					pstmt.setLong(2, roleForm.getRoleid());
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
