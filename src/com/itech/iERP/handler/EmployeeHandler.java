package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.EmployeeDaoImpl;
import com.itech.iERP.forms.EmployeeForm;

public class EmployeeHandler 
{

	EmployeeDaoImpl impl = new EmployeeDaoImpl();
	public List<EmployeeForm> listAll(DataSource dataSource)
	{
		
		return impl.listAll(dataSource);
	}
	public String changeRole(EmployeeForm employeeForm, DataSource dataSource) 
	{
		return impl.changeStatus(employeeForm,dataSource);
	}
	public String addRole(EmployeeForm employeeForm, DataSource dataSource) 
	{
		
		return impl.add(employeeForm,dataSource);
	}
	public String update(EmployeeForm employeeForm, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.update(employeeForm, dataSource);
	}
	
	
  
}
