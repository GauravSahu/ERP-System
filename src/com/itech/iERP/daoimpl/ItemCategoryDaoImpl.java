package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.ItemCategoryForm;;

public class ItemCategoryDaoImpl {
	public List<ItemCategoryForm> listAll(DataSource dataSource) {
		// TODO Auto-generated method stub
		
		List<ItemCategoryForm> list = new ArrayList<ItemCategoryForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemCategoryForm itemcategoryForm = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM itemcategorymaster ORDER BY categoryname ASC";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   itemcategoryForm = new ItemCategoryForm();
			   itemcategoryForm.setCategoryid(rs.getInt("CATEGORYID"));
			   itemcategoryForm.setCategoryname(rs.getString("CATEGORYNAME"));
			   itemcategoryForm.setActive(rs.getBoolean("ACTIVE"));
			   list.add(itemcategoryForm);
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
	

	public String add(ItemCategoryForm itemcategoryform, DataSource dataSource) {
		// TODO Auto-generated method stub
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from itemcategorymaster where CATEGORYNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, itemcategoryform.getCategoryname());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				if(!itemcategoryform.getCategoryname().equalsIgnoreCase("") && !itemcategoryform.getCategoryname().equalsIgnoreCase(null))
				{
					sql = "insert into itemcategorymaster (CATEGORYNAME,ACTIVE) values (?,?)";
					if(pstmt!=null)
						pstmt.close();
					pstmt = con.prepareStatement(sql);
				
					pstmt.setString(1, itemcategoryform.getCategoryname());
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
		
	public Object changeStatus(ItemCategoryForm itemcategoryform,DataSource dataSource) {
		// TODO Auto-generated method stub
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "update itemcategorymaster set active = ? where CATEGORYID=?";
		   pstmt=con.prepareStatement(sql);
		   pstmt.setBoolean(1,itemcategoryform.isActive());
		   pstmt.setInt(2, itemcategoryform.getCategoryid());
		   pstmt.executeUpdate();
		   result=iERPConstants.REC_STATUS_CHANGED;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return result;
	}

	
	public Object update(ItemCategoryForm itemcategoryform,DataSource dataSource) {
		// TODO Auto-generated method stub
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM itemcategorymaster WHERE CATEGORYNAME COLLATE latin1_general_cs LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,itemcategoryform.getCategoryname());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.No_Change;
			else
			{
				if(!itemcategoryform.getCategoryname().equalsIgnoreCase("") && !itemcategoryform.getCategoryname().equalsIgnoreCase(null))
				{
					sql="UPDATE itemcategorymaster SET CATEGORYNAME=? WHERE CATEGORYID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, itemcategoryform.getCategoryname());
					pstmt.setLong(2, itemcategoryform.getCategoryid());
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


	public List<ItemCategoryForm> activeList(DataSource dataSource) {
		// TODO Auto-generated method stub
		List<ItemCategoryForm> list = new ArrayList<ItemCategoryForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemCategoryForm itemcategoryForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from itemcategorymaster where active = true order by CATEROGYNAME ASC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				itemcategoryForm = new ItemCategoryForm();
				itemcategoryForm.setCategoryid(rs.getInt("CATEGORYID"));
				itemcategoryForm.setCategoryname(rs.getString("CATEGORYNAME"));
				itemcategoryForm.setActive(rs.getBoolean("active"));
				list.add(itemcategoryForm);
				
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
