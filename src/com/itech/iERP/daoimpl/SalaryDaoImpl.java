package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;

import com.itech.iERP.forms.SalaryForm;

public class SalaryDaoImpl 
{

	public List<SalaryForm> listAll(DataSource dataSource)
	{
		
		List<SalaryForm> list = new ArrayList<SalaryForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalaryForm countryForm = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM professionalmaster ORDER BY BASIC";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   countryForm = new SalaryForm();
			   countryForm.setSalaryId(rs.getInt("PROFESSIONID"));
			   countryForm.setBasic(rs.getLong("BASIC"));
			   countryForm.setNetSal(rs.getLong("NETAMT"));
			   countryForm.setTax(rs.getLong("PROFESSIONTAX"));
			   countryForm.setActive(rs.getBoolean("ACTIVE"));
			   list.add(countryForm);
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

	public String add(SalaryForm salaryForm, DataSource dataSource) 
	{
	String result = iERPConstants.FAILURE_MESSAGE;
	Connection con = null;
	PreparedStatement pstmt = null;
	try
	{
		con=dataSource.getConnection();
		String sql = "select * from professionalmaster where BASIC=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, salaryForm.getBasic());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			result=iERPConstants.DUPLICATE_NAME_MESSAGE;
		else
		{
			if(salaryForm.getBasic()!=0 && salaryForm.getNetSal()!=0 && salaryForm.getTax()!=0){
				sql = "insert into professionalmaster (PROFESSIONID,BASIC,NETAMT,PROFESSIONTAX,ACTIVE) values (?,?,?,?,?)";
				if(pstmt!=null)
					pstmt.close();
				pstmt = con.prepareStatement(sql);
				pstmt.setLong(1, salaryForm.getSalaryId());
				pstmt.setLong(2, salaryForm.getBasic());
				pstmt.setLong(3, salaryForm.getNetSal());
				pstmt.setLong(4, salaryForm.getTax());
				pstmt.setBoolean(5, true);
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

	public String changeStatus(SalaryForm salaryForm, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "update professionalmaster set active = ? where PROFESSIONID=?";
		   pstmt=con.prepareStatement(sql);
		   pstmt.setBoolean(1,salaryForm.isActive());
		   pstmt.setLong(2, salaryForm.getSalaryId());
		   System.out.println("salary id is"+salaryForm.getSalaryId());
		   pstmt.executeUpdate();
		   result=iERPConstants.REC_STATUS_CHANGED;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return result;
	}

	public String update(SalaryForm salaryForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("HI");
		try
		{
			con = dataSource.getConnection();
		
			System.out.println("bas value"+salaryForm.getBasic());
	
			//pstmt.setLong(1,salaryForm.getBasic());
		
			    if(salaryForm.getBasic()!=0 && salaryForm.getNetSal()!=0 && salaryForm.getTax()!=0)
			    {
				
					String sql="UPDATE professionalmaster SET BASIC='"+salaryForm.getBasic()+"' ,NETAMT='"+salaryForm.getNetSal()+"' , PROFESSIONTAX = '"+salaryForm.getTax()+"' WHERE PROFESSIONID='"+salaryForm.getSalaryId()+"'";
					System.out.println("Sql statemement "+sql);
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
//					pstmt.setLong(1, salaryForm.getBasic());
//					pstmt.setLong(2, salaryForm.getNetSal());
//					pstmt.setLong(3, salaryForm.getTax());
//					pstmt.setLong(4, salaryForm.getSalaryId());
					System.out.println(sql);
					pstmt.executeUpdate();
					if(rs!=null)rs.close();
		    		result=iERPConstants.REC_UPDATED;
					
		       }
			    else
			    {
			    	result = iERPConstants.FAILURE_MESSAGE;
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
  
	
}
