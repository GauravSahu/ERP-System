package com.itech.iERP.handler;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.ExpenseModuleDaoImpl;
import com.itech.iERP.forms.ExpenseModuleForm;
import com.itech.iERP.forms.LeaveModuleForm;

public class ExpenseModuleHandler 
{
    ExpenseModuleDaoImpl impl = new ExpenseModuleDaoImpl();
	public List<ExpenseModuleForm> expenseList(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.expenseList(dataSource);
	}
	public String getApprover(DataSource dataSource, long userid)
	{
		return impl.getApprover(dataSource,userid);
	}
	public int getApproverid(DataSource dataSource, long userid)
	{
		// TODO Auto-generated method stub
		return impl.getApproverId(dataSource, userid);
	}
	public String addRole(ExpenseModuleForm expMod, Timestamp ftimets,
			long userid, int approverId, String allfiles, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.addexpense(expMod,ftimets,userid,approverId,allfiles,dataSource);
	}
	public List<ExpenseModuleForm> expensearrove(long userid,
			DataSource dataSource) 
			{
		
		return impl.expenseapprove(userid,dataSource);
	        }
	public String changeexp(int l, ExpenseModuleForm expMod,
			DataSource dataSource)
	{
		// TODO Auto-generated method stub
		
		return impl.changeRole(l,expMod,dataSource);
	}
	public String changeRej(int l, ExpenseModuleForm expMod,
			DataSource dataSource) 
	{
		
		return impl.reject(l,expMod,dataSource);
	}
	public List<ExpenseModuleForm> expensestatus(long userid,
			DataSource dataSource)
			{
	
		return impl.expensestatus(userid,dataSource);
	      }
	public String name(DataSource dataSource, long userid) 
	{
		// TODO Auto-generated method stub
		return impl.getName(dataSource, userid);
	}
	public List<ExpenseModuleForm> listEmp(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listemp(dataSource);
	}
	public List<ExpenseModuleForm> listEmp1(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listEmp1(dataSource);
	}
	public List<ExpenseModuleForm> listLeaveList(Timestamp ftimets,
			Timestamp ttimets, ExpenseModuleForm expMod, DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.listleave(ftimets,ttimets,expMod,dataSource);
	      }
	public List<ExpenseModuleForm> listLeaveList1(ExpenseModuleForm expMod,
			DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.listLeaveList1(expMod,dataSource);
	   }
	 
}
