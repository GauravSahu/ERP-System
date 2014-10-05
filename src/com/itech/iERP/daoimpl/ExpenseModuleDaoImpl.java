package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.ExpenseModuleForm;
import com.itech.iERP.forms.LeaveModuleForm;
import com.sun.org.apache.regexp.internal.recompile;

public class ExpenseModuleDaoImpl
{

	public List<ExpenseModuleForm> expenseList(DataSource dataSource) 
	{
		List<ExpenseModuleForm> list = new ArrayList<ExpenseModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExpenseModuleForm expform = null;
		try
		{
			con=dataSource.getConnection();
			String sql="select * from expensetypemaster where ACTIVE=true";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				expform = new ExpenseModuleForm();
				expform.setExpenseid1(rs.getInt("EXPENSETYPEID"));
				expform.setExpensename(rs.getString("EXPENSETYPENAME"));
				list.add(expform);
				
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
			}finally{
				try {
					if(con!=null)con.close();
				} catch (Exception e2) {}
			}
		}
		return list;
	}

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
		}finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return existName;
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
		}finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return id;
		
	}

	public String addexpense(ExpenseModuleForm expMod, Timestamp ftimets,
			long userid, int approverId, String allfiles, DataSource dataSource)
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
				sql="INSERT INTO employeeexpenses(expenseID,applieddate,expensedate,EXPENSETYPEID,USERID,reportingmanagerid,reason,status,amount,documentnames) VALUES (?,?,?,?,?,?,?,?,?,?)";
				System.out.println(sql);
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,expMod.getExpenseid());
				pstmt.setTimestamp(2,ts);
				pstmt.setTimestamp(3,ftimets);
				pstmt.setInt(4,expMod.getExpenseid1());
				pstmt.setLong(5, userid);
				pstmt.setInt(6,approverId);
				pstmt.setString(7,expMod.getReason());
				pstmt.setString(8,"open");		
				pstmt.setInt(9,expMod.getAmount());
				pstmt.setString(10, allfiles);
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

	public List<ExpenseModuleForm> expenseapprove(long userid,
			DataSource dataSource) 
			{
		List<ExpenseModuleForm> list = new ArrayList<ExpenseModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExpenseModuleForm attmodform = null;
		try
		{
		   con=dataSource.getConnection();
		   String sql = "select * from employeeexpenses as a, usermaster u where(u.USERID=a.USERID) and reportingmanagerid='"+userid+"' and status='open'";
		   System.out.println(sql);
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				attmodform = new ExpenseModuleForm();
				attmodform.setUserid(rs.getInt("a.USERID"));
				attmodform.setReason(rs.getString("a.reason"));
				attmodform.setfDate(rs.getString("a.expensedate").substring(0,10));;
				attmodform.setApplieddate(rs.getString("a.applieddate").substring(0,10));
				attmodform.setUsername(rs.getString("u.USERNAME"));
				attmodform.setExpenseid(rs.getInt("a.expenseID"));
				String docnames = rs.getString("a.documentnames");
				attmodform.setAmount(rs.getInt("a.amount"));
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
			e.printStackTrace();
		}
		return list;
		}
	      

	public String changeRole(int l, ExpenseModuleForm expMod,
			DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE employeeexpenses SET status=? WHERE expenseID='"+l+"'";
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

	public String reject(int l, ExpenseModuleForm expMod, DataSource dataSource)
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE employeeexpenses SET status=?,reasonforrejection=? WHERE expenseID='"+l+"'";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,"rejected");
			pstmt.setString(2,expMod.getRejection());
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

	public List<ExpenseModuleForm> expensestatus(long userid,
			DataSource dataSource)
			{
	
		List<ExpenseModuleForm> list = new ArrayList<ExpenseModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExpenseModuleForm attmodform = null;
		try
		{
		   con=dataSource.getConnection();
		   String sql = "select * from employeeexpenses where USERID='"+userid+"'";
		   System.out.println(sql);
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				attmodform = new ExpenseModuleForm();
				attmodform.setUserid(rs.getInt("USERID"));
				attmodform.setReason(rs.getString("reason"));
				attmodform.setfDate(rs.getString("expensedate").substring(0,10));;
				attmodform.settDate(rs.getString("applieddate").substring(0,10));
				//attmodform.setUsername(rs.getString("USERNAME"));
				
				attmodform.setExpenseid(rs.getInt("expenseID"));
				attmodform.setAmount(rs.getInt("amount"));
				attmodform.setStatus(rs.getString("status"));
				attmodform.setRejection(rs.getString("reasonforrejection"));
				System.out.println("Rejection ghd"+rs.getString("reasonforrejection"));
				list.add(attmodform);
				
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
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
		finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return existName;
	}

	public List<ExpenseModuleForm> listemp(DataSource dataSource) 
	{

		List<ExpenseModuleForm> list = new ArrayList<ExpenseModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExpenseModuleForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new ExpenseModuleForm();
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

	public List<ExpenseModuleForm> listEmp1(DataSource dataSource) 
	{
		List<ExpenseModuleForm> list = new ArrayList<ExpenseModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExpenseModuleForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new ExpenseModuleForm();
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

	public List<ExpenseModuleForm> listleave(Timestamp ftimets,
			Timestamp ttimets, ExpenseModuleForm expMod, DataSource dataSource)
			{
		List<ExpenseModuleForm> list = new ArrayList<ExpenseModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExpenseModuleForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from employeeexpenses as a, usermaster u where(u.USERID=a.USERID) and applieddate between '"+ftimets+"' and '"+ttimets+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new ExpenseModuleForm();
				vform.setUserid(rs.getInt("a.USERID"));
				vform.setfDate(rs.getString("a.expensedate").substring(0,10));
				vform.settDate(rs.getString("a.applieddate").substring(0,10));
				
				vform.setRejection(rs.getString("a.reasonforrejection"));
				vform.setAmount(rs.getInt("a.amount"));
				vform.setReason(rs.getString("a.reason"));
				vform.setStatus(rs.getString("a.status"));
				
				list.add(vform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return list;
         	}

	public List<ExpenseModuleForm> listLeaveList1(ExpenseModuleForm expMod,
			DataSource dataSource) 
			{
		List<ExpenseModuleForm> list = new ArrayList<ExpenseModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ExpenseModuleForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from employeeexpenses as a where USERID between '"+expMod.getUserId1()+"' and '"+expMod.getUserId2()+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new ExpenseModuleForm();
				vform.setUserid(rs.getInt("a.USERID"));
				vform.setfDate(rs.getString("a.expensedate").substring(0,10));
				vform.settDate(rs.getString("a.applieddate").substring(0,10));
				vform.setRejection(rs.getString("a.reasonforrejection"));
				vform.setAmount(rs.getInt("a.amount"));
				vform.setReason(rs.getString("a.reason"));
				vform.setStatus(rs.getString("a.status"));
				
				list.add(vform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return list;
	}
	
	
}
