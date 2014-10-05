package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.DesignationDaoImpl;
import com.itech.iERP.forms.DesignationForm;

public class DesignationHandler 
{
	DesignationDaoImpl impl = new DesignationDaoImpl();
	public List<DesignationForm> list(long compid, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.listAll(compid,dataSource);
	}
	public String addRole(DesignationForm roleForm, long compid, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.add(roleForm,compid,dataSource);
	}
	public String changeRole(DesignationForm roleForm, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.changeStatus(roleForm,dataSource);
	}
	public String updateRole(DesignationForm roleForm, DataSource dataSource) 
	{

		return impl.update(roleForm,dataSource);
	}
   
	
}
