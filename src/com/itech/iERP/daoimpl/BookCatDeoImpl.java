package com.itech.iERP.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.BookCatForm;

public class BookCatDeoImpl {
	
	public List<BookCatForm> listAll(DataSource dataSource) 
	{
		
		List<BookCatForm> list = new ArrayList<BookCatForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookCatForm bookcatForm = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM bookcategary";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   bookcatForm = new BookCatForm();
			   bookcatForm.setBookcatid(rs.getInt("BOOKCATID"));
			   bookcatForm.setCatname(rs.getString("CATNAME"));
			   bookcatForm.setActive(rs.getBoolean("ACTIVE"));
		
			  
			    list.add(bookcatForm);
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

	
	public String add(BookCatForm bookcatForm, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from bookcategary where BOOKCATID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookcatForm.getBookcatid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				if(!bookcatForm.getCatname().equalsIgnoreCase("") && !bookcatForm.getCatname().equalsIgnoreCase(null))
				{
					sql = "insert into bookcategary(BOOKCATID,CATNAME,ACTIVE) values (?,?,?)";
					if(pstmt!=null)
					pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1,bookcatForm.getBookcatid());
					pstmt.setString(2, bookcatForm.getCatname());
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
	
public String update(BookCatForm bookcatForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
		
			con = dataSource.getConnection();
			String sql = "SELECT * FROM bookcategary WHERE  CATNAME  LIKE ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bookcatForm.getBookcatid());
		
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.No_Change;
			else
			{
				if(!bookcatForm.getCatname().equalsIgnoreCase("") && !bookcatForm.getCatname().equalsIgnoreCase(null))
				{
					sql="UPDATE bookcategary SET CATNAME=? WHERE BOOKCATID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,bookcatForm.getCatname());
					pstmt.setInt(2,bookcatForm.getBookcatid());
					
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

public String changeStatus(BookCatForm bookcatForm, DataSource dataSource) 
{
	String result = iERPConstants.FAILURE_MESSAGE;
	Connection con = null;
	PreparedStatement pstmt = null;
	try
	{
	   con = dataSource.getConnection();
	   String sql = "update bookcategary set active = ? where BOOKCATID=?";
	   pstmt=con.prepareStatement(sql);
	   pstmt.setBoolean(1,bookcatForm.isActive());
	   pstmt.setInt(2, bookcatForm.getBookcatid());
	   pstmt.executeUpdate();
	   result=iERPConstants.REC_STATUS_CHANGED;
	}
	catch (Exception e) 
	{
		System.out.println(e);
	}
	return result;
}

	
}

	
