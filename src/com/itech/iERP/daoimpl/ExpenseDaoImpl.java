package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.ExpenseTypeMasterForm;

public class ExpenseDaoImpl 
{

	public List<ExpenseTypeMasterForm> listAll(DataSource dataSource)
	{
		List<ExpenseTypeMasterForm> list= new ArrayList<ExpenseTypeMasterForm>();
		ExpenseTypeMasterForm roleForm=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM expensetypemaster ORDER BY EXPENSETYPENAME ASC";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				roleForm= new ExpenseTypeMasterForm();
				roleForm.setExpenseId(rs.getInt("EXPENSETYPEID"));
				roleForm.setExpensename(rs.getString("EXPENSETYPENAME"));
				roleForm.setActive(rs.getBoolean("active"));
			    list.add(roleForm);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return list;
		
	}

	public String add(String l,ExpenseTypeMasterForm expense, DataSource dataSource) 
	{
		
	    String result = iERPConstants.FAILURE_MESSAGE;
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    try
	    {
	    	con=dataSource.getConnection();
	    	String sql="select * from expensetypemaster where EXPENSETYPENAME=?";
	    	pstmt=con.prepareStatement(sql);
	    	pstmt.setString(1,l);
	    	ResultSet rs = pstmt.executeQuery();
	    	if(rs.next())
	    		result=iERPConstants.DUPLICATE_NAME_MESSAGE;
	    	else
	    	{
	    		
	    			sql="insert into expensetypemaster (EXPENSETYPEID,EXPENSETYPENAME,ACTIVE) values (?,?,?)";
	    			if(pstmt!=null)
	    				pstmt.close();
	    			pstmt=con.prepareStatement(sql);
	    			pstmt.setInt(1, expense.getExpenseId());
	    			pstmt.setString(2,l);
	    			pstmt.setBoolean(3,true);
	    			pstmt.executeUpdate();
	    			if(rs!=null)
	    				rs.close();
	    			result=iERPConstants.REC_ADDED;
	    		
	    	}
	    	}
	    	catch (Exception e) 
	    	{
				// TODO: handle exception
	    		e.printStackTrace();
			}
	    	finally{
	    		try
	    		{
	    			if(con!=null)
	    				con.close();
	    		}
	    		catch (Exception e2) 
	    		{
					// TODO: handle exception
	    			e2.printStackTrace();
				}
	    	}
	    	return result;
	
	}

	public String changestatus(ExpenseTypeMasterForm expense,
			DataSource dataSource) 
	{
		
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE expensetypemaster SET ACTIVE=? WHERE EXPENSETYPEID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, expense.isActive());
			pstmt.setInt(2, expense.getExpenseId());
			pstmt.executeUpdate();
			result=iERPConstants.REC_STATUS_CHANGED;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	public String updatexpense(String r,ExpenseTypeMasterForm expense,
			DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM expensetypemaster WHERE EXPENSETYPENAME COLLATE latin1_general_cs LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,r);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.No_Change;
			else{
				
					 sql="UPDATE expensetypemaster SET EXPENSETYPENAME='"+r+"' WHERE EXPENSETYPEID='"+expense.getExpenseId()+"'";
					 System.out.println("sql value "+sql);
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					
					pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result=iERPConstants.REC_UPDATED;
				
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	
	
}
