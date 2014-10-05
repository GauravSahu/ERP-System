package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.ComponentDaoImpl;
import com.itech.iERP.forms.ComponentTypeMasterForm;

public class ComponentHandler 
{
    ComponentDaoImpl impl = new ComponentDaoImpl();
	public List<ComponentTypeMasterForm> list(DataSource dataSource, long userid)
	{
	
		return impl.listAll(dataSource,userid);
	}
	public String addRole(ComponentTypeMasterForm roleForm, long userid,
			DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.add(roleForm,userid,dataSource);
	}
	public String changeRole(ComponentTypeMasterForm roleForm,
			DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.changeStatus(roleForm,dataSource);
	}
	public String updateRole(ComponentTypeMasterForm roleForm, long userid,
			DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.update(roleForm,userid,dataSource);
	}
  
}
