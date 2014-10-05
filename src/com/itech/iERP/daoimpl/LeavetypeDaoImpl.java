package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.LeavetypeForm;

public class LeavetypeDaoImpl 
{

	public List<LeavetypeForm> listAll(DataSource dataSource) 
	{
		List<LeavetypeForm> list = new ArrayList<LeavetypeForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LeavetypeForm leavetypeForm = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM leavetypemaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   leavetypeForm = new LeavetypeForm();
			   leavetypeForm.setLeavetypeid(rs.getInt("LEAVETYPEID"));
			   leavetypeForm.setLeavename(rs.getString("LEAVENAME"));
			   leavetypeForm.setEntitlement(rs.getInt("entitlement"));
			   leavetypeForm.setActive(rs.getBoolean("ACTIVE"));
			   list.add(leavetypeForm);
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

	public String add(LeavetypeForm leavetypeForm, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from leavetypemaster where LEAVENAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, leavetypeForm.getLeavename());
			//pstmt.setInt(2,leavetypeForm.getEntitlement());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				System.out.println(leavetypeForm.getEntitlement());
				System.out.println(leavetypeForm.getLeavename());
				if(!leavetypeForm.getLeavename().equalsIgnoreCase("") && !leavetypeForm.getLeavename().equalsIgnoreCase(null))
				{
					sql = "insert into leavetypemaster (LEAVETYPEID,LEAVENAME,entitlement,ACTIVE) values (?,?,?,?)";
					if(pstmt!=null)
						pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, leavetypeForm.getLeavetypeid());
					pstmt.setString(2, leavetypeForm.getLeavename());
					pstmt.setInt(3, leavetypeForm.getEntitlement());
					pstmt.setBoolean(4, true);
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

	public String changeStatus(LeavetypeForm leavetypeForm, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "update leavetypemaster set active = ? where LEAVETYPEID=?";
		   pstmt=con.prepareStatement(sql);
		   pstmt.setBoolean(1,leavetypeForm.isActive());
		   pstmt.setInt(2, leavetypeForm.getLeavetypeid());
		   pstmt.executeUpdate();
		   result=iERPConstants.REC_STATUS_CHANGED;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return result;
	}

	public String update(LeavetypeForm leavetypeForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM leavetypemaster WHERE LEAVENAME AND entitlement LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,leavetypeForm.getLeavename());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.No_Change;
			else
			{
				if(!leavetypeForm.getLeavename().equalsIgnoreCase("") && !leavetypeForm.getLeavename().equalsIgnoreCase(null))
				{
					sql="UPDATE leavetypemaster SET LEAVENAME=?, entitlement=? WHERE LEAVETYPEID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, leavetypeForm.getLeavename());
					pstmt.setInt(2, leavetypeForm.getEntitlement());
					pstmt.setInt(3, leavetypeForm.getLeavetypeid());
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

	public List<LeavetypeForm> activeList(DataSource dataSource) 
	{
		List<LeavetypeForm> list = new ArrayList<LeavetypeForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LeavetypeForm leavetypeForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from leavetypemaster where active = true";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				leavetypeForm = new LeavetypeForm();
				leavetypeForm.setLeavetypeid(rs.getInt("LEAVETYPEID"));
				leavetypeForm.setLeavename(rs.getString("LEAVENAME"));
				leavetypeForm.setEntitlement(rs.getInt("entitlement"));
				leavetypeForm.setActive(rs.getBoolean("active"));
				list.add(leavetypeForm);
				
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
