package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.CityDaoImpl;
import com.itech.iERP.forms.CityForm;

public class CityHandler 
{

	CityDaoImpl impl = new CityDaoImpl();
	public List<CityForm> list(long stateid, long countryid,long compid, DataSource dataSource) 
	{
		return impl.listAll(stateid,countryid,compid,dataSource);
	}
	public String addCity(long compid, CityForm cityForm, DataSource dataSource)
	{
		return impl.add(compid,cityForm,dataSource);
	}
	public String changeCity(CityForm cityForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeStatus(cityForm,dataSource);
	}
	public String updateCity(CityForm cityForm, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.update(cityForm,dataSource);
	}
  
}
