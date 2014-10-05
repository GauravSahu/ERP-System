package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.hssf.record.formula.functions.Request;
import org.apache.struts.taglib.html.RewriteTag;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.CalenderForm;
import com.itech.iERP.forms.UserForm;
import com.itech.iERP.utils.Util;

public class Calender1DaoImpl {
	public List<CalenderForm> listAll(DataSource dataSource) 
	{
		List<CalenderForm> list = new ArrayList<CalenderForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CalenderForm calenderForm = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT c.COMPANYID, a.COMPANYNAME, c.CALDAYTYPEID, c.DATE, c.DAY, b.CALDAYTYPENAME from calender c, companymaster a, calendardaytypemaster b where c.companyid=a.companyid and c.caldaytypeid=b.caldaytypeid";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		//   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		   while(rs.next())
		   {
			   calenderForm = new CalenderForm();
			   calenderForm.setCompanyid(rs.getString("c.COMPANYID"));
			   calenderForm.setCompanyname(rs.getString("a.COMPANYNAME"));
			   calenderForm.setDate(rs.getString("c.DATE").substring(0, 10));
			   calenderForm.setDay(rs.getString("c.DAY"));
			   calenderForm.setCaldayid(rs.getString("c.CALDAYTYPEID"));
			   calenderForm.setCaldaytypename(rs.getString("b.CALDAYTYPENAME"));
		
			   list.add(calenderForm);
		   }
		}
		catch (ClassCastException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch(NullPointerException ne){
			ne.printStackTrace();
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

	public String add(CalenderForm calenderForm, DataSource dataSource, Timestamp timets)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("Date :--"+calenderForm.getDate1());
		
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from calender where companyid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, calenderForm.getCompanyid());
			//pstmt.setString(1, leavetypeForm.getLeavename());
			//pstmt.setInt(2,leavetypeForm.getEntitlement());
			 rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				
				if(!calenderForm.getDate().equals("") && !calenderForm.getDate().equals(null))
				{
					sql = "insert into calender (COMPANYID,DATE,DAY,CALDAYTYPEID) values (?,?,?,?)";
					if(pstmt!=null)
						pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, calenderForm.getCompanyid());
					pstmt.setTimestamp(2,timets);
					pstmt.setString(3, calenderForm.getDay());
					pstmt.setString(4, calenderForm.getCaldayid());
					
					pstmt.executeUpdate();
					if(rs!=null)
						rs.close();
					result=iERPConstants.REC_ADDED;
				}
			}
		}
		catch(NullPointerException ne){
			ne.printStackTrace();
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

	public List<CalenderForm> cstatusList(DataSource dataSource) {
		List<CalenderForm> list = new ArrayList<CalenderForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CalenderForm calenderForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from calendardaytypemaster where active=true";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				calenderForm = new CalenderForm();
				calenderForm.setCaldayid(rs.getString("CALDAYTYPEID"));
				calenderForm.setCalendername(rs.getString("CALDAYTYPENAME"));
				list.add(calenderForm);
				
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
	public List<CalenderForm> companyList(DataSource dataSource) {
		List<CalenderForm> list = new ArrayList<CalenderForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CalenderForm calenderForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from companymaster where active = true";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				calenderForm = new CalenderForm();
				
				calenderForm.setCompanyid(rs.getString("companyid"));
				calenderForm.setCompanyname(rs.getString("companyname"));
				   
				   list.add(calenderForm);
				
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

	public String updateDaytype(CalenderForm calenderForm, DataSource dataSource) {
		
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = dataSource.getConnection();
		//	if(!calenderForm.getCompanyid().equalsIgnoreCase("") && !calenderForm.getCompanyid().equalsIgnoreCase(null))
		//	{
				System.out.println("--Before updating--");
				System.out.println("company "+calenderForm.getCompanyid());
				System.out.println("cal "+calenderForm.getCaldayid());
				String sql="UPDATE calender SET CALDAYTYPEID='"+calenderForm.getCaldayid()+"' WHERE COMPANYID='" +calenderForm.getDcompanyid()+"'";
				System.out.println("Updated SQL Stmt :----" + sql) ;
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				//pstmt.setString(1,calenderForm.getCaldayid());
			//	pstmt.setString(2, calenderForm.getDcompanyid());
				
				pstmt.executeUpdate();
				System.out.println(sql);
				if(rs!=null)
					rs.close();
				result=iERPConstants.REC_UPDATED;
				System.out.println("--After updating--");
				System.out.println("company "+calenderForm.getCompanyid());
				System.out.println("cal "+calenderForm.getCaldayid());
			//}
		}catch (Exception e) 
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
}
