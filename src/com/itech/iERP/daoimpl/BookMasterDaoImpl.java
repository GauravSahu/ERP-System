package com.itech.iERP.daoimpl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.BookMasterForm;

public class BookMasterDaoImpl {
	
	
	public List<BookMasterForm> listAll(DataSource dataSource) 
	{
		
		List<BookMasterForm> list = new ArrayList<BookMasterForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookMasterForm bookmasterForm = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM bookmaster bm inner join  bookcategary bc on bc.bookcatid=bm.bookcatid where bc.active=1";
		   pstmt=con.prepareStatement(sql);
		  
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   bookmasterForm = new BookMasterForm();
			   bookmasterForm.setBookid(rs.getInt("BOOKID"));
			   bookmasterForm.setBooktitle(rs.getString("BOOKTITLE"));
			   bookmasterForm.setAuthor(rs.getString("AUTHOR"));
			   bookmasterForm.setAccessionno(rs.getInt("ACCESSIONNO"));
			   bookmasterForm.setBookcatid(rs.getInt("BOOKCATID"));
			  
			    list.add(bookmasterForm);
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

	
	public String add(BookMasterForm bookmasterForm, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select ACCESSIONNO,BOOKTITLE,AUTHOR from bookmaster where ACCESSIONNO=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookmasterForm.getAccessionno());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				if(!bookmasterForm.getBooktitle().equalsIgnoreCase("") && !bookmasterForm.getBooktitle().equalsIgnoreCase(null))
				{
					sql = "insert into bookmaster(BOOKTITLE,AUTHOR,ACCESSIONNO,BOOKCATID) values (?,?,?,?)";
					if(pstmt!=null)
					pstmt.close();
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, bookmasterForm.getBooktitle());
					pstmt.setString(2, bookmasterForm.getAuthor());
		
					pstmt.setInt(3, bookmasterForm.getAccessionno());
					pstmt.setInt(4, bookmasterForm.getBookcatid());
					
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
	
	public String update(BookMasterForm bookmasterForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM bookmaster WHERE BOOKTITLE AND AUTHOR AND ACCESSIONNO AND BOOKCATID  LIKE ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,bookmasterForm.getBooktitle());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.No_Change;
			else
			{
				if(!bookmasterForm.getBooktitle().equalsIgnoreCase("") && !bookmasterForm.getBooktitle().equalsIgnoreCase(null))
				{
					sql="UPDATE bookmaster SET BOOKTITLE=?,AUTHOR=?,ACCESSIONNO=?,BOOKCATID=? WHERE BOOKID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
				
					pstmt = con.prepareStatement(sql);
				
					pstmt.setString(1, bookmasterForm.getBooktitle());
					pstmt.setString(2, bookmasterForm.getAuthor());
					pstmt.setInt(3, bookmasterForm.getAccessionno());
					pstmt.setInt(4, bookmasterForm.getBookcatid());
					pstmt.setInt(5,bookmasterForm.getBookid());
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


	public List<BookMasterForm> bookcatlist(DataSource dataSource) {
		List<BookMasterForm> list = new ArrayList<BookMasterForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookMasterForm bookmasterForm = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT BOOKCATID,CATNAME FROM bookcategary where active = true";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   bookmasterForm = new BookMasterForm();
			   bookmasterForm.setBookcatid(rs.getInt("BOOKCATID"));
			   bookmasterForm.setBookcatname(rs.getString("CATNAME"));
			 
			  
			    list.add(bookmasterForm);
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
