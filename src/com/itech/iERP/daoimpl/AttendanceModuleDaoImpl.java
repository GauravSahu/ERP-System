package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.AttendanceModuleForm;
import com.itech.iERP.forms.LeaveModuleForm;
import com.itech.iERP.forms.UserForm;
import com.itech.iERP.utils.Util;

public class AttendanceModuleDaoImpl 
{

	public String addatte(AttendanceModuleForm attmodform, long userid,
			long compid, DataSource dataSource) 
	{
		java.sql.Timestamp ts = new java.sql.Timestamp(System
				.currentTimeMillis());
		ts.setHours(00);
		ts.setMinutes(00);
		ts.setSeconds(00);
		String result=null;
	
		Connection con=null;
		String l = null;
		PreparedStatement  pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT AttLateCutOffTime FROM companymaster WHERE COMPANYID='"+compid+"'";
			System.out.println("sql statement "+sql);
			pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				attmodform = new AttendanceModuleForm();
				attmodform.setAttLateCutOffTime(rs.getString("AttLateCutOffTime"));
			} 
			String s1 = attmodform.getAttLateCutOffTime();
			String s2 = Util.getCurrentTime();
			System.out.println("s2 string "+s2);
		    sql="SELECT SignInTime FROM attendance where DATED='"+ts+"'";
		    pstmt=con.prepareStatement(sql);
		    rs=pstmt.executeQuery();
			while(rs.next())
			{
				attmodform = new AttendanceModuleForm();
				 l = attmodform.getSignIn();
			}
			
			System.out.println("L value"+ attmodform.getSignIn());
			if(s1.compareTo(s2) > 0 )
			{
				 result="enter reason first";
			}
			else if(l!=null )
			{
				 result="you have all ready entered the login ";
			}
			else
			{
				result="Proceed with attendance";
				sql = "insert into attendance (DATED,COMPANYID,USERID,SignInTime) values (?,?,?,?)";
				if(pstmt!=null)
					pstmt.close();
				pstmt = con.prepareStatement(sql);
				//pstmt.setInt(1, qualificationform.getQualificationid());
				pstmt.setTimestamp(1,ts);
				pstmt.setLong(2,compid); 
				pstmt.setLong(3,userid);
				
				pstmt.setString(4, Util.getCurrentTime());
			
				pstmt.executeUpdate();
				if(rs!=null)
					rs.close();
				result=iERPConstants.REC_ADDED;
			}
			

		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e);
		}
			
		return result;
	}

	public String addatte1(AttendanceModuleForm attmodform,String s, long userid,
			long compid, DataSource dataSource) {
		// TODO Auto-generated method stub
		java.sql.Timestamp ts = new java.sql.Timestamp(System
				.currentTimeMillis());
		String sql=null;
		ts.setHours(00);
		ts.setMinutes(00);
		ts.setSeconds(00);
		String result=null;
	    String l = null;
		Connection con=null;
        ResultSet rs = null;
		PreparedStatement  pstmt=null;
		try {
			con=dataSource.getConnection();
			  sql="SELECT SignInTime FROM attendance where DATED='"+ts+"'";
			    pstmt=con.prepareStatement(sql);
			    rs=pstmt.executeQuery();
			    while(rs.next())
				{
					attmodform = new AttendanceModuleForm();
					 l = attmodform.getSignIn();
				}
			    if(l!=null )
				{
					 result="you have all ready entered the login ";
				}
				else
		
			    {
				result="Proceed with attendance";
				 sql = "insert into attendance (DATED,COMPANYID,USERID,SignInTime,LateReason) values (?,?,?,?,?)";
				if(pstmt!=null)
					pstmt.close();
				pstmt = con.prepareStatement(sql);
				//pstmt.setInt(1, qualificationform.getQualificationid());
				pstmt.setTimestamp(1,ts);
				pstmt.setLong(2,compid);
				pstmt.setLong(3,userid);
				
				pstmt.setString(4, Util.getCurrentTime());
				pstmt.setString(5,s);
			
				pstmt.executeUpdate();
				if(rs!=null)
					rs.close();
				result=iERPConstants.REC_ADDED;
			}
			

		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e);
		}
			
		return result;
	}

	public String addLogout(AttendanceModuleForm attmodform, long userid,
			long compid, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		java.sql.Timestamp ts = new java.sql.Timestamp(System
				.currentTimeMillis());
		
		ts.setHours(00);
		ts.setMinutes(00);
		ts.setSeconds(00);
		//System.out.println("ts.getdate "+ts.getTimezoneOffset());
		String result=null;
		Connection con=null;
		PreparedStatement  pstmt=null;
		try
		{
			con=dataSource.getConnection();
			String sql="SELECT SignInTime FROM attendance WHERE COMPANYID='"+compid+"' and USERID='"+userid+"' and DATED='"+ts+"' ";
			System.out.println("sql statement "+sql);
			pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				attmodform = new AttendanceModuleForm();
				attmodform.setSignIn(rs.getString("SignInTime"));
				
			} 
			System.out.println("sign in"+attmodform.getSignIn());
			sql="UPDATE attendance SET SignOutTime=? WHERE SignInTime='"+ attmodform.getSignIn()+"' and COMPANYID='"+compid+"' and USERID='"+userid+"'";
			if(pstmt!=null)pstmt.close();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, Util.getCurrentTime());
			
			pstmt.executeUpdate();
			if(rs!=null)
				rs.close();
			result=iERPConstants.REC_UPDATED;
			
			
		}
		catch (Exception e) 
		{
			System.out.println("Exception is "+e);
		}
		return result;
	}

	public List<AttendanceModuleForm> listEmp(DataSource dataSource)
	{
		List<AttendanceModuleForm> list = new ArrayList<AttendanceModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttendanceModuleForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new AttendanceModuleForm();
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
	
	public List<AttendanceModuleForm> listEmp1(DataSource dataSource)
	{
		List<AttendanceModuleForm> list = new ArrayList<AttendanceModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttendanceModuleForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new AttendanceModuleForm();
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

	public List<AttendanceModuleForm> listAttList(
			AttendanceModuleForm attmodform, DataSource dataSource) 
			{
		
		        List<AttendanceModuleForm> list = new ArrayList<AttendanceModuleForm>();
		        Connection con = null;
			    PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    AttendanceModuleForm attform = null;
			    String sql=null;
			    try
			    {
			    	con = dataSource.getConnection();
			        if(!attmodform.getUserId1().equalsIgnoreCase("")&&!attmodform.getUserId2().equalsIgnoreCase(""))
			        {
			        sql = "select * from attendance where ";
			        }
			        else
			        {
			        	
			        }
			    }
			    catch (Exception e) 
			    {
					e.printStackTrace();
				}
			    return list;
	       }

	public List<AttendanceModuleForm> listAttRep(Timestamp ftimets,
			Timestamp ttimets, AttendanceModuleForm attmodform,
			DataSource dataSource) 
			{
		List<AttendanceModuleForm> list = new ArrayList<AttendanceModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	    AttendanceModuleForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from attendance as a, usermaster u where(u.USERID=a.USERID) and DATED between '"+ftimets+"' and '"+ttimets+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new AttendanceModuleForm();
				vform.setUserid(rs.getString("a.USERID"));
				vform.setReason(rs.getString("a.LateReason"));
				vform.setDated(rs.getTimestamp("a.DATED"));
				vform.setSignIn(rs.getString("a.SignInTime"));
				vform.setSignOut(rs.getString("a.SignOutTime"));
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

	public List<AttendanceModuleForm> listLeaveList1(
			AttendanceModuleForm attmodform,String name, DataSource dataSource) 
			{
		List<AttendanceModuleForm> list = new ArrayList<AttendanceModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AttendanceModuleForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from attendance  where USERID between '"+attmodform.getUserId1()+"' and '"+attmodform.getUserId2()+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new AttendanceModuleForm();
				vform.setUserid(rs.getString("USERID"));
				vform.setReason(rs.getString("LateReason"));
				vform.setDated(rs.getTimestamp("DATED"));
				vform.setSignIn(rs.getString("SignInTime"));
				vform.setSignOut(rs.getString("SignOutTime"));
				vform.setUsername(name);
				list.add(vform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
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
				ps=con.prepareStatement("select USERNAME from usermaster where userid='"+userid+"'");
				rs=ps.executeQuery();
				if(rs.next())
				{
					existName = rs.getString("USERNAME");
					 
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return existName;
	}
             
}
