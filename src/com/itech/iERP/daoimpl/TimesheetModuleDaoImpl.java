package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.LeaveModuleForm;
import com.itech.iERP.forms.TimesheetModuleForm;
import com.sun.java_cup.internal.internal_error;

public class TimesheetModuleDaoImpl
{

	public String timesheet(TimesheetModuleForm timesheet, long userid,DataSource dataSource) 
	{
		java.sql.Timestamp ts = new java.sql.Timestamp(System
				.currentTimeMillis());
		String result=iERPConstants.FAILURE_MESSAGE;
		String sql=null;
		Connection con=null;
        ResultSet rs = null;
		PreparedStatement pstmt=null;
		try {
			
			   con = dataSource.getConnection();
				sql="INSERT INTO timesheet(USERID,timesheet,applieddate) VALUES (?,?,?)";
				System.out.println(sql);
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setLong(1,userid);
				
				pstmt.setString(2,timesheet.getTimesheet());
				
				pstmt.setTimestamp(3,ts);
				pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result=iERPConstants.REC_ADDED;
	    		System.out.println("result is : "+result);
				
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return result;
	}

	public List<TimesheetModuleForm> listEmp(DataSource dataSource) 
	{
		List<TimesheetModuleForm> list = new ArrayList<TimesheetModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TimesheetModuleForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new TimesheetModuleForm();
			   attmodform.setUserId1(rs.getString("USERID"));
			   attmodform.setUsername(rs.getString("USERNAME"));
			   list.add(attmodform);
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

	public List<TimesheetModuleForm> listEmp1(DataSource dataSource)
	{
		List<TimesheetModuleForm> list = new ArrayList<TimesheetModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TimesheetModuleForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new TimesheetModuleForm();
			   attmodform.setUserId2(rs.getString("USERID"));
			   attmodform.setUsername(rs.getString("USERNAME"));
			   list.add(attmodform);
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

	public List<TimesheetModuleForm> listleave(Timestamp ftimets,
			Timestamp ttimets, TimesheetModuleForm timesheet,
			DataSource dataSource) 
			{
		List<TimesheetModuleForm> list = new ArrayList<TimesheetModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TimesheetModuleForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from timesheet as a, usermaster u where(u.USERID=a.USERID) and applieddate between '"+ftimets+"' and '"+ttimets+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new TimesheetModuleForm();
				vform.setUserId1(rs.getString("a.USERID"));
				vform.setApplied(rs.getString("a.applieddate").substring(0,10));
				vform.setTimesheet(rs.getString("a.timesheet"));
				
				vform.setUsername(rs.getString("u.USERNAME"));
				list.add(vform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		return list;
	        }

	public List<TimesheetModuleForm> listLeaveList1(
			TimesheetModuleForm timesheet, DataSource dataSource) 
			{
		List<TimesheetModuleForm> list = new ArrayList<TimesheetModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TimesheetModuleForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from timesheet where USERID between '"+timesheet.getUserId1()+"' and '"+timesheet.getUserId2()+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new TimesheetModuleForm();
				//vform.setUserId1(rs.getString("a.USERID"));
				vform.setApplied(rs.getString("applieddate").substring(0,10));
				vform.setTimesheet(rs.getString("timesheet"));
				
		
				list.add(vform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e);
		}
		return list;
	       }

	public String getName(DataSource dataSource, long userid)
	{
		 String existName="";
			
			Connection con = null;
			PreparedStatement ps= null;
			ResultSet rs = null;
			try
			{
				con=dataSource.getConnection();
				ps=con.prepareStatement("select FIRSTNAME from usermaster where userid='"+userid+"'");
				rs=ps.executeQuery();
				if(rs.next())
				{
					existName = rs.getString("FIRSTNAME");
					 
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return existName;
	}

}
