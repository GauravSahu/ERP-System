package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.AccountMasterForm;

public class AccountMasterDaoImpl 
{

	public List<AccountMasterForm> listallaccounttype(DataSource dataSource)
	{
		List<AccountMasterForm> list = new ArrayList<AccountMasterForm>();
		AccountMasterForm accountmaster = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from accountmaster";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				accountmaster = new AccountMasterForm();
				accountmaster.setAccountno(rs.getString("accountno"));
				accountmaster.setAccountname(rs.getString("accountname"));
				accountmaster.setAccounttype(rs.getString("type"));
				accountmaster.setActive(rs.getBoolean("active"));
				list.add(accountmaster);
			}
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
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
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return list;
	}

	public String changestatus(AccountMasterForm accountmaster,
			DataSource dataSource)
	{
		String status = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
		  con = dataSource.getConnection();
		  String sql = "update accountmaster set active = ? where accountno = ?";
		  pstmt=con.prepareStatement(sql);
		  pstmt.setBoolean(1,accountmaster.isActive()); 
		  System.out.println(accountmaster.isActive()+" "+accountmaster.getAccountno());
		  pstmt.setString(2,accountmaster.getAccountno());
		  pstmt.executeUpdate();
		  status=iERPConstants.REC_UPDATED;
		  System.out.println("result "+status);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try
			{
			  if(con != null)
				  con.close();
			}
			catch (Exception e)
			{
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("result "+status);
		return status;
	}

	public String addaccounts(AccountMasterForm accountmaster,
			DataSource dataSource) 
	{
	
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from accountmaster where accountno = '"+accountmaster.getAccountno()+"'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
		    result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				if(!accountmaster.getAccountname().equalsIgnoreCase("")&&!accountmaster.getAccountname().equalsIgnoreCase(null))
				{
				sql="INSERT INTO accountmaster (accountno,accountname,type,ACTIVE) VALUES (?,?,?,?)";
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,accountmaster.getAccountno());
				pstmt.setString(2,accountmaster.getAccountname());
				pstmt.setString(3,accountmaster.getAccounttype());
				pstmt.setBoolean(4, true);
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
	
	
}
