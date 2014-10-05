package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.BankForm;
import com.itech.iERP.forms.DesignationForm;

public class BankDaoImpl 
{

	public List<BankForm> listAll(long compid, DataSource dataSource) throws Exception
	{
		List<BankForm> list= new ArrayList<BankForm>();
		BankForm roleForm=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM bankmaster where compid = '"+compid+"' ORDER BY BANKNAME ASC";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				roleForm= new BankForm();
				roleForm.setBankId(rs.getInt("BANKID"));
				roleForm.setBankName(rs.getString("BANKNAME"));
				roleForm.setActive(rs.getBoolean("active"));
			    list.add(roleForm);
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
		return list;
		
	}

	public String add(long compid, BankForm roleForm, DataSource dataSource)
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;

		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM bankmaster WHERE BANKNAME=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, roleForm.getBankName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result="Bank name already exists, Please try with other names";
			else{
				if(!roleForm.getBankName().equalsIgnoreCase("")&&!roleForm.getBankName().equalsIgnoreCase(null))
				{
				sql="INSERT INTO bankmaster (BANKID,BANKNAME,ACTIVE,compid) VALUES (?,?,?,?)";
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, roleForm.getBankId());
				pstmt.setString(2, roleForm.getBankName());
				pstmt.setBoolean(3, true);
				pstmt.setLong(4, compid);
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

	public String changeStatus(BankForm roleForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE bankmaster SET ACTIVE=? WHERE BANKID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, roleForm.isActive());
			pstmt.setInt(2, roleForm.getBankId());
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

	public String update(BankForm roleForm, DataSource dataSource)
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM bankmaster WHERE BANKNAME COLLATE latin1_general_cs LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, roleForm.getBankName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.No_Change;
			else{
				if(!roleForm.getBankName().equalsIgnoreCase("")&&!roleForm.getBankName().equalsIgnoreCase(null))
				{
					 sql="UPDATE bankmaster SET BANKNAME=? WHERE BANKID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, roleForm.getBankName());
					pstmt.setLong(2, roleForm.getBankId());
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
