package com.itech.iERP.handler;

import java.io.FileNotFoundException;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.CompanyDaoImpl;
import com.itech.iERP.forms.CompanyForm;

public class CompanyHandler 
{
	CompanyDaoImpl impl = new CompanyDaoImpl();
	public String add(CompanyForm compForm, String fileName,DataSource dataSource) throws Exception
	{
       
		return impl.add(compForm,fileName,dataSource);
      
	}
	public List<CompanyForm> list(DataSource dataSource) 
	{
		return impl.listAll(dataSource);
	}
	public String changeRole(CompanyForm compForm, DataSource dataSource) 
	{
		
		return impl.changeStatus(compForm,dataSource);
	}
	public String updateRole(CompanyForm compForm,String fileName,DataSource dataSource) throws FileNotFoundException 
	{
		// TODO Auto-generated method stub
		return impl.update(compForm,fileName,dataSource);
	}
}


