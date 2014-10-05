package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.RoleDaoImpl;
import com.itech.iERP.forms.RoleForm;

public class RoleHandler {

	RoleDaoImpl impl = new RoleDaoImpl();
	public List<RoleForm> list(long compid, DataSource dataSource) 
	{
		
		return impl.listAll(compid,dataSource);
	}
	public String addRole(RoleForm roleForm, long compid, DataSource dataSource)
	{
		
		return impl.add(compid,roleForm,dataSource);
	}
	public String changeRole(RoleForm roleForm, DataSource dataSource)
	{
		return impl.changeStatus(roleForm,dataSource);
	}
	public String updateRole(RoleForm roleForm, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.update(roleForm,dataSource);
	}

}
