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
import com.itech.iERP.forms.RoleForm;

public class LeaveModuleDaoImpl 
{

	

	public String getApprover(DataSource dataSource, long userid) 
	{
		String existName="";
		int id =0;
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try
		{
			con=dataSource.getConnection();
			ps=con.prepareStatement("select APPROVER,FIRSTNAME from usermaster where userid='"+userid+"'");
			rs=ps.executeQuery();
			if(rs.next())
			{
				existName = rs.getString("FIRSTNAME");
				 id = rs.getInt("APPROVER");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace(); 
		}
		return existName;
		
	}

	public List<LeaveModuleForm> listEmp(DataSource dataSource) 
	{
		List<LeaveModuleForm> list = new ArrayList<LeaveModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LeaveModuleForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new LeaveModuleForm();
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

	public String add(LeaveModuleForm leavemoduleform,Timestamp ftimets,Timestamp ttimets, long userid,int approverId,String allfiles, DataSource dataSource) throws NullPointerException
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		java.sql.Timestamp ts = new java.sql.Timestamp(System
				.currentTimeMillis());
		String sql=null;
		ts.setHours(00);
		ts.setMinutes(00);
		ts.setSeconds(00);
		Connection con=null;
        ResultSet rs = null;
		PreparedStatement pstmt=null;
	 
		try {
			
			   con = dataSource.getConnection();
				sql="INSERT INTO employeeleaverequest(leaveId,applieddate,fromdate,todate,USERID,reportingmanagerid,reason,notifyid,status,noofdays,documentnames,uploaddate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
				System.out.println(sql);
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, leavemoduleform.getLeaveAppId());
				pstmt.setTimestamp(2,ts);
				pstmt.setTimestamp(3,ftimets);
				pstmt.setTimestamp(4,ttimets);
				pstmt.setLong(5, 1);
				pstmt.setInt(6,approverId);
				pstmt.setString(7,leavemoduleform.getReason());
				pstmt.setString(8,leavemoduleform.getUserId1());
				pstmt.setString(9,"Open");
				pstmt.setInt(10,leavemoduleform.getAdds());
				pstmt.setString(11,allfiles);
				pstmt.setTimestamp(12,ts);
				pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result=iERPConstants.REC_ADDED;
				
		
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

	public int getApproverId(DataSource dataSource, long userid)
	{
	
		int id =0;
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try
		{
			con=dataSource.getConnection();
			ps=con.prepareStatement("select APPROVER,FIRSTNAME from usermaster where userid='"+userid+"'");
			rs=ps.executeQuery();
			if(rs.next())
			{
				
				 id = rs.getInt("APPROVER");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return id;
		
	}

	public List<LeaveModuleForm> leaveRequests(long userid,
			DataSource dataSource)
			{
		List<LeaveModuleForm> list = new ArrayList<LeaveModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LeaveModuleForm attmodform = null;
		try
		{
		   con=dataSource.getConnection();
		   String sql = "select * from employeeleaverequest as a, usermaster u where(u.USERID=a.USERID) and reportingmanagerid='"+userid+"' and status='Open'";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				attmodform = new LeaveModuleForm();
				attmodform.setUserid(rs.getInt("a.USERID"));
				attmodform.setReason(rs.getString("a.reason"));
				attmodform.setfDate(rs.getString("a.fromdate").substring(0,10));;
				attmodform.settDate(rs.getString("a.todate").substring(0,10));
				attmodform.setUsername(rs.getString("u.USERNAME"));
				attmodform.setLeaveAppId(rs.getInt("a.leaveId"));
				attmodform.setDocuments(rs.getString("a.documentnames"));
				String docnames = rs.getString("a.documentnames");
				System.out.println("document names  "+docnames);	
				String appliedid = rs.getString("a.USERID");
				System.out.println("Appled id "+appliedid);
				
				try
				{
			    String[] temp;
				String delimiter = ",";
				temp = docnames.split(delimiter);
				attmodform.setDocname1(temp[0]);
				attmodform.setDocname2(temp[1]);
				attmodform.setDocname3(temp[2]);
				attmodform.setDocname4(temp[3]);
				attmodform.setDocname5(temp[4]);
			    attmodform.setDocname6(temp[5]);                				 
				list.add(attmodform);
				}
				catch (NumberFormatException e) 
				{
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		return list;
		}

	public String changeRole(int l, LeaveModuleForm leavemoduleform,
			DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE employeeleaverequest SET status=? WHERE leaveId='"+l+"'";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,"approved");
			pstmt.executeUpdate();
			result=iERPConstants.REC_STATUS_CHANGED;
			System.out.println(result+ "Hi");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}
		
	public String changeRole1(int l, LeaveModuleForm leavemoduleform,
			DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE employeeleaverequest SET status=?,reasonforrejection=? WHERE leaveId='"+l+"'";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,"rejected");
			pstmt.setString(2,leavemoduleform.getRejection());
			pstmt.executeUpdate();
			result=iERPConstants.REC_STATUS_CHANGED;
			System.out.println(result+ "Hi");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	public List<LeaveModuleForm> listEmp1(DataSource dataSource) 
	{
		List<LeaveModuleForm> list = new ArrayList<LeaveModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LeaveModuleForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new LeaveModuleForm();
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

	public List<LeaveModuleForm> listleave(Timestamp ftimets,
			Timestamp ttimets, LeaveModuleForm leavemoduleform,
			DataSource dataSource) 
			{
		List<LeaveModuleForm> list = new ArrayList<LeaveModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	    LeaveModuleForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from employeeleaverequest as a, usermaster u where(u.USERID=a.USERID) and applieddate between '"+ftimets+"' and '"+ttimets+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new LeaveModuleForm();
				vform.setUserid(rs.getInt("a.USERID"));
				vform.setfDate(rs.getString("a.fromdate").substring(1,10));
				vform.settDate(rs.getString("a.todate").substring(1,10));
				vform.setStatus(rs.getString("a.status"));
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

	public List<LeaveModuleForm> listLeaveList1(
			LeaveModuleForm leavemoduleform, DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		List<LeaveModuleForm> list = new ArrayList<LeaveModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	    LeaveModuleForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from employeeleaverequest as a, usermaster u where(u.USERID=a.USERID) and notifyid between '"+leavemoduleform.getUserId1()+"' and '"+leavemoduleform.getUserId2()+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new LeaveModuleForm();
				vform.setUserid(rs.getInt("a.USERID"));
				vform.setfDate(rs.getString("a.fromdate").substring(1,10));
				vform.settDate(rs.getString("a.todate").substring(1,10));
				vform.setStatus(rs.getString("a.status"));
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

	

	public List<LeaveModuleForm> listLeaveHist(long userid, String username,
			DataSource dataSource) 
			{
		List<LeaveModuleForm> list = new ArrayList<LeaveModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	    LeaveModuleForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from employeeleaverequest  where USERID='"+userid+"'";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new LeaveModuleForm();
				vform.setUserid(rs.getInt("USERID"));
				vform.setRejection(rs.getString("reasonforrejection"));
				vform.setfDate(rs.getString("fromdate").substring(0,10));
				vform.settDate(rs.getString("todate").substring(0,10));
				vform.setStatus(rs.getString("status"));
				vform.setLeaveType("paid leave");
				vform.setUsername(username);
				list.add(vform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return list;
	      }

	public List<LeaveModuleForm> listLeavestat(long userid, String username,
			DataSource dataSource) 
			{
		List<LeaveModuleForm> list = new ArrayList<LeaveModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	    LeaveModuleForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from employeeleaverequest where USERID='"+userid+"'";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new LeaveModuleForm();
				vform.setUserid(rs.getInt("USERID"));
				vform.setRejection(rs.getString("reasonforrejection"));
				vform.setfDate(rs.getString("fromdate").substring(0,10));
				vform.settDate(rs.getString("todate").substring(0,10));
				vform.setStatus(rs.getString("status"));
				vform.setLeaveType("paid leave");
				vform.setUsername(username);
				list.add(vform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return list;
	     }

	public int listbal(DataSource dataSource, long userid) 
	{
		int id =0;
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try
		{
			con=dataSource.getConnection();
			ps=con.prepareStatement("select sum(noofdays) as days from employeeleaverequest where userid='"+userid+"'");
			rs=ps.executeQuery();
			if(rs.next())
			{
				
				 id = rs.getInt("days");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return id;
	}

	public int listapp(DataSource dataSource, long userid)
	{
		int id =0;
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try
		{
			con=dataSource.getConnection();
			ps=con.prepareStatement("select count(status) as days from employeeleaverequest where userid='"+userid+"' and status='approved' ");
			rs=ps.executeQuery();
			if(rs.next())
			{
				
				 id = rs.getInt("days");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return id;
	}

	public int listrej(DataSource dataSource, long userid) 
	{
		int id =0;
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try
		{
			con=dataSource.getConnection();
			ps=con.prepareStatement("select count(status) as days from employeeleaverequest where userid='"+userid+"' and status='rejected' ");
			rs=ps.executeQuery();
			if(rs.next())
			{
				
				 id = rs.getInt("days");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return id;
	}

	public String getApproverMailId(DataSource dataSource, int approverId)
	{
		String existName="";
		
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try
		{
			con=dataSource.getConnection();
			ps=con.prepareStatement("select EMAILID from usermaster where userid='"+approverId+"'");
			rs=ps.executeQuery();
			if(rs.next())
			{
				existName = rs.getString("EMAILID");
				 
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return existName;
	}

	public String getNotifyMailId(DataSource dataSource, String userId1) 
	{
       String existName="";
		
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		try
		{
			con=dataSource.getConnection();
			ps=con.prepareStatement("select EMAILID from usermaster where userid='"+userId1+"'");
			rs=ps.executeQuery();
			if(rs.next())
			{
				existName = rs.getString("EMAILID");
				 
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return existName;
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
