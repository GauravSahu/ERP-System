package com.itech.iERP.daoimpl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.AttendanceModuleForm;
import com.itech.iERP.forms.LibraryModuleForm;
import com.itech.iERP.utils.BookReqMail;
import com.itech.iERP.utils.Util;

public class LibraryModuleDeoImpl {
	
	public List<LibraryModuleForm> booklist(DataSource dataSource) {
		List<LibraryModuleForm> list = new ArrayList<LibraryModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LibraryModuleForm bookrequestform = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT BOOKID,BOOKTITLE FROM bookmaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   bookrequestform = new LibraryModuleForm();
			   bookrequestform.setBookid(rs.getInt("BOOKID"));
			   bookrequestform.setBooktitle(rs.getString("BOOKTITLE"));
			   list.add(bookrequestform);
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
	
	
	public List<LibraryModuleForm> employeelist(DataSource dataSource) {
		List<LibraryModuleForm> list = new ArrayList<LibraryModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LibraryModuleForm bookrequestform = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT EMPID,FIRSTNAME,LASTNAME FROM empmaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   bookrequestform = new LibraryModuleForm();
			   bookrequestform.setEmployeeid(rs.getInt("EMPID"));
			   bookrequestform.setEmployeename((rs.getString("FIRSTNAME")+" "+rs.getString("LASTNAME")));
			   System.out.println(bookrequestform.getEmployeename());
			   list.add(bookrequestform);
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


	public List<LibraryModuleForm> bookrequestlist(DataSource dataSource) {
		
		List<LibraryModuleForm> list = new ArrayList<LibraryModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LibraryModuleForm bookrequestform = null;
		
		try {
		   con = dataSource.getConnection();
		   String sql = "select br.remark, br.takendate,br.returndate,bm.booktitle,concat(em.firstname,em.lastname) as EmployeeName from bookmaster bm inner join bookrequest br on br.bookid=bm.bookid inner join empmaster em on br.employeeid=em.empid order by br.TAKENDATE";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   bookrequestform = new LibraryModuleForm();
			   bookrequestform.setBooktitle(rs.getString("booktitle"));
			   bookrequestform.setEmployeename(rs.getString("EmployeeName"));
			   bookrequestform.setTakendate(rs.getString("takendate"));
			   bookrequestform.setReturndate(rs.getString("returndate"));
			   bookrequestform.setRemark(rs.getString("remark"));
			    list.add(bookrequestform);
			 
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

	public int bookrequestadd(LibraryModuleForm bookrequestform,DataSource dataSource) {
		{
			int result = 0;
			Connection con = null;
			PreparedStatement pstmt = null;
			bookrequestform.setTakendate( Util.getCurrentDate());
			bookrequestform.setReturndate(Util.AddDate(2));
			
			try
			{
				 con = dataSource.getConnection();
				String sql = "SELECT EMPLOYEEID FROM bookrequest where BOOKID=? AND EMPLOYEEID=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bookrequestform.getBookid());
				pstmt.setInt(2, bookrequestform.getEmployeeid());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
					result=1;
				else
				{
					if(!bookrequestform.getTakendate().equalsIgnoreCase("") && !bookrequestform.getTakendate().equalsIgnoreCase(null))
					{
						sql = "insert into bookrequest(BOOKID,EMPLOYEEID,TAKENDATE,RETURNDATE,REMARK) values (?,?,?,?,?)";
						if(pstmt!=null)
						pstmt.close();
						pstmt = con.prepareStatement(sql);
						
						pstmt.setInt(1, bookrequestform.getBookid());
						pstmt.setInt(2, bookrequestform.getEmployeeid());
						pstmt.setString(3, bookrequestform.getTakendate());
						pstmt.setString(4, bookrequestform.getReturndate());
						pstmt.setString(5, bookrequestform.getRemark());
						
						pstmt.executeUpdate();
						if(rs!=null)
							rs.close();
						result=2;
						
						
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
}
	
	public String mailbooklist(LibraryModuleForm bookrequestform,DataSource dataSource) {
		     String result="Failed to send mail";
		    Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String rdate= bookrequestform.getTakendate().toString().substring(0,bookrequestform.getTakendate().toString().lastIndexOf(" "));
			 String employeename=null;
			 String booktitle=null;
			 String email=null;
				
			try {
		   con = dataSource.getConnection();
			   String sql = "select bm.booktitle,bm.author,em.email,em.firstname,em.lastname  from bookmaster bm,empmaster em where bm.bookid=? and em.empid=?";
			   pstmt=con.prepareStatement(sql);
			   pstmt.setInt(1,bookrequestform.getBookid());
				pstmt.setInt(2,bookrequestform.getEmployeeid());
				rs=pstmt.executeQuery();
			   while(rs.next())
			   { employeename=  rs.getString("em.firstname")+" "+ rs.getString("em.lastname");
				  booktitle=rs.getString("bm.booktitle");
				  email=  rs.getString("em.email");
				 
				}
			  
			  BookReqMail.bookmail(employeename, booktitle,rdate , bookrequestform.getReturndate().toString(), bookrequestform.getRemark(),email);
			  if(rs!=null)
					rs.close();
			result = "Mail is Sended to "+email;
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
			return result;
		}
	
	public List<LibraryModuleForm> bookduesearchlist(DataSource dataSource , String takendate, String returndate) {
		List<LibraryModuleForm> list = new ArrayList<LibraryModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LibraryModuleForm bookrequestform = null;
		
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "select br.remark, br.takendate,br.returndate,bm.booktitle,concat(em.firstname,em.lastname) as EmployeeName from bookmaster bm inner join bookrequest br on br.bookid=bm.bookid inner join empmaster em on br.employeeid=em.empid where  br.takendate>='"+takendate+"' and br.returndate <='"+returndate+"'";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   bookrequestform = new LibraryModuleForm();
			   bookrequestform.setBooktitle(rs.getString("booktitle"));
			   bookrequestform.setEmployeename(rs.getString("EmployeeName"));
			   bookrequestform.setTakendate(rs.getString("takendate"));
			   bookrequestform.setReturndate(rs.getString("returndate"));
			   bookrequestform.setRemark(rs.getString("remark"));
			    list.add(bookrequestform);
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
	

	
	

	
public List<LibraryModuleForm> empbookduesearchlist(DataSource dataSource,	int	empid, int empid1) {
	
	List<LibraryModuleForm> list = new ArrayList<LibraryModuleForm>();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	LibraryModuleForm bookrequestform = null;
	try
	{
	   con = dataSource.getConnection();
	  
	   String sql = "select br.remark, br.takendate,br.returndate,bm.booktitle,concat(em.firstname,em.lastname) as EmployeeName from bookmaster bm inner join bookrequest br on br.bookid=bm.bookid inner join empmaster em on br.employeeid=em.empid where em.empid  between '"+empid+"' and '"+empid1+"'";
	   pstmt=con.prepareStatement(sql);
	   rs=pstmt.executeQuery();
	  System.out.println(rs.next());
	   while(rs.next())
	   {
		   System.out.println(empid);
			System.out.println(empid1);
		   bookrequestform = new LibraryModuleForm();
		   bookrequestform.setBooktitle(rs.getString("booktitle"));
		   bookrequestform.setEmployeename(rs.getString("EmployeeName"));
		   bookrequestform.setTakendate(rs.getString("takendate"));
		   bookrequestform.setReturndate(rs.getString("returndate"));
		   bookrequestform.setRemark(rs.getString("remark"));
		    list.add(bookrequestform);
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






