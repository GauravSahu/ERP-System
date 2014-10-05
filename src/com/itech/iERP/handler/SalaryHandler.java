package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.SalaryDaoImpl;
import com.itech.iERP.forms.SalaryForm;

public class SalaryHandler 
{
	SalaryDaoImpl impl = new  SalaryDaoImpl();
	public List<SalaryForm> list(DataSource dataSource) 
	{
	  	// TODO Auto-generated method stub
		return impl.listAll(dataSource);
	}
	public String add(SalaryForm salaryForm, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.add(salaryForm,dataSource);
	}
	public String changeStatus(SalaryForm salaryForm, DataSource dataSource) {
		
		return impl.changeStatus(salaryForm,dataSource);
	}
	public String updateCountry(SalaryForm salaryForm, DataSource dataSource)
	{
		// TODO Auto-generated method stubSyso
		System.out.println("jijjj");
		return impl.update(salaryForm,dataSource);
	}
   
}
