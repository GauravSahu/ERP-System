package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.CompanyForm;
import com.itech.iERP.forms.ComponentTypeMasterForm;

public class ComponentDaoImpl
{

	public List<ComponentTypeMasterForm> listAll(DataSource dataSource, long userid)
	{
		List<ComponentTypeMasterForm> list= new ArrayList<ComponentTypeMasterForm>();
		ComponentTypeMasterForm roleForm=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM componentmaster where COMPANYID='"+userid+"'";
			System.out.println("sql statement "+sql);
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				roleForm= new ComponentTypeMasterForm();
				//roleForm.setCompanyId(rs.getInt("COMPANYID"));
				roleForm.setComponentId(rs.getInt("COMPONENTID"));
				roleForm.setComponentName(rs.getString("COMPONENTNAME"));
				roleForm.setComponentType(rs.getString("COMPONENTTYPE"));
				roleForm.setValue(rs.getInt("VALUE"));
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

	public String add(ComponentTypeMasterForm roleForm, long userid,
			DataSource dataSource)
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;

		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM componentmaster WHERE COMPONENTNAME='"+roleForm.getComponentName()+"' and COMPANYID='"+userid+"' ";
			System.out.println("sql quert "+sql);
			pstmt=con.prepareStatement(sql);
			
			//pstmt.setString(1, roleForm.getComponentName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else{
				if(!roleForm.getComponentName().equalsIgnoreCase("")&&!roleForm.getComponentName().equalsIgnoreCase(null))
				{
				sql="INSERT INTO componentmaster(COMPANYID,COMPONENTID,COMPONENTNAME,COMPONENTTYPE,VALUE,ACTIVE) VALUES (?,?,?,?,?,?)";
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setLong(1, userid);
				pstmt.setInt(2, roleForm.getComponentId());
				pstmt.setString(3, roleForm.getComponentName());
				pstmt.setString(4, roleForm.getComponentType());
				pstmt.setInt(5, roleForm.getValue());
				pstmt.setBoolean(6, true);
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public String changeStatus(ComponentTypeMasterForm roleForm,
			DataSource dataSource)
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE componentmaster SET ACTIVE=? WHERE COMPONENTID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, roleForm.isActive());
			pstmt.setInt(2, roleForm.getComponentId());
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

	public String update(ComponentTypeMasterForm roleForm,long userid, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM componentmaster WHERE COMPONENTNAME='"+roleForm.getComponentName()+"' and COMPANYID='"+userid+"' ";
			pstmt=con.prepareStatement(sql);
			//pstmt.setString(1, roleForm.getBankName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.No_Change;
			else{
				if(!roleForm.getComponentName().equalsIgnoreCase("")&&!roleForm.getComponentName().equalsIgnoreCase(null))
				{
					 sql="UPDATE componentmaster SET COMPONENTNAME=?,COMPONENTTYPE=?,VALUE=? WHERE COMPONENTID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, roleForm.getComponentName());
					pstmt.setString(2,roleForm.getComponentType());
					pstmt.setInt(3,roleForm.getValue());
					pstmt.setLong(4, roleForm.getComponentId());
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
