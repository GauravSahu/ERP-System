package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.CountryDaoImpl;
import com.itech.iERP.forms.ContryForm;

public class CountryHandler 
{
	CountryDaoImpl  impl = new CountryDaoImpl ();
	public List<ContryForm> list(DataSource dataSource)
	{
		
		return impl.listAll(dataSource);
	}
	public String add(ContryForm countryForm, DataSource dataSource) 
	{
		
		return impl.add(countryForm,dataSource);
	}
	public String changeStatus(ContryForm countryForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeStatus(countryForm,dataSource);
	}
	public String updateCountry(ContryForm countryForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.update(countryForm,dataSource);
	}
	public List<ContryForm> active(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.activeList(dataSource);
	}
	public boolean excelexport(DataSource dataSource, String filePath) {
		
		return impl.excelexport(dataSource,filePath);
	}
  
}
