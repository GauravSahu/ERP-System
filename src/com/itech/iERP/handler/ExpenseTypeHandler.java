package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.ExpenseDaoImpl;
import com.itech.iERP.forms.ExpenseTypeMasterForm;
import com.itech.iERP.forms.RoleForm;

public class ExpenseTypeHandler
{
    ExpenseDaoImpl impl = new ExpenseDaoImpl();
	public List<ExpenseTypeMasterForm> list(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listAll(dataSource);
	}
	public String addRole(String l,ExpenseTypeMasterForm expense, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.add(l,expense,dataSource);
	}
	public String changestatus(ExpenseTypeMasterForm expense,
			DataSource dataSource)
    {
		// TODO Auto-generated method stub
		return impl.changestatus(expense,dataSource);
	}
	public String updatexpense(String r,ExpenseTypeMasterForm expense,
			DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.updatexpense(r,expense,dataSource);
	}
	
   
}
