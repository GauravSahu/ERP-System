package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.ItemCategoryForm;
import com.itech.iERP.forms.ItemMasterForm;

public class ItemMasterDeoImpl {

	public String add(ItemMasterForm itemmasterform, DataSource dataSource) {
		
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from itemmaster  where CATEGORYID=? and itemname=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, itemmasterform.getCategoryid());
			pstmt.setString(2, itemmasterform.getItemname());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_ITEM_MESSAGE;
			else
			{
				if(!itemmasterform.getItemname().equalsIgnoreCase("") && !itemmasterform.getItemname().equalsIgnoreCase(null))
				{
					sql = "insert into ITEMMASTER (CATEGORYID,ITEMNAME,ACTIVE) values (?,?,?)";
					if(pstmt!=null)
						pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setLong(1,itemmasterform.getCategoryid());
					pstmt.setString(2,itemmasterform.getItemname());
					pstmt.setBoolean(3,true);
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

	public String changeStatus(ItemMasterForm itemmasterform,DataSource dataSource) {
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			
		   con = dataSource.getConnection();
		   String sql = "update itemmaster set active = ? where itemmasterid=?";
		   pstmt=con.prepareStatement(sql);
		   pstmt.setBoolean(1,itemmasterform.isActive());
		   pstmt.setInt(2, itemmasterform.getItemmasterid());
		   pstmt.executeUpdate();
		   result=iERPConstants.REC_STATUS_CHANGED;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return result;
	}

	public String update(ItemMasterForm itemmasterform, DataSource dataSource) {
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
	
		try
		{
			con=dataSource.getConnection();
		
		String sql = "select * from itemmaster  where CATEGORYID=? and itemname=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, itemmasterform.getCategoryid());
		pstmt.setString(2, itemmasterform.getItemname());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			result=iERPConstants.DUPLICATE_ITEM_MESSAGE;
		else
		{
			
				if(!itemmasterform.getItemname().equalsIgnoreCase("") && !itemmasterform.getItemname().equalsIgnoreCase(null))
				{ 
					 sql="UPDATE itemmaster SET ITEMNAME=?,CATEGORYID=? WHERE  itemmasterid=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
//					
					pstmt.setString(1, itemmasterform.getItemname());
					pstmt.setInt(2, itemmasterform.getCategoryid());
					pstmt.setInt(3, itemmasterform.getItemmasterid());
					pstmt.executeUpdate();
					
					result=iERPConstants.REC_UPDATED;
				
			}
		}}
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

	public List<ItemMasterForm> listAll(DataSource dataSource) {
	
		
			List<ItemMasterForm> list = new ArrayList<ItemMasterForm>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ItemMasterForm itemmasterform = null;
			
			try
			{
			   con = dataSource.getConnection();
			   String sql = "SELECT * FROM itemmaster";
			   pstmt=con.prepareStatement(sql);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   itemmasterform = new ItemMasterForm();
				   itemmasterform.setCategoryid(rs.getInt("CATEGORYID"));
				   itemmasterform.setItemname(rs.getString("ITEMNAME"));
				   itemmasterform.setItemmasterid(rs.getInt("ITEMMASTERID"));
				   itemmasterform.setActive(rs.getBoolean("ACTIVE"));
				   list.add(itemmasterform);
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

	public List<ItemMasterForm> itemlsist(DataSource dataSource) {
		List<ItemMasterForm> list = new ArrayList<ItemMasterForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemMasterForm itemmasterform = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM itemcategorymaster ORDER BY categoryname ASC";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   itemmasterform = new ItemMasterForm();
			   itemmasterform.setCategoryid(rs.getInt("CATEGORYID"));
			   itemmasterform.setCategoryname(rs.getString("CATEGORYNAME"));
			   
			   list.add(itemmasterform);
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
	
}



