package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.BankDaoImpl;
import com.itech.iERP.daoimpl.DesignationDaoImpl;
import com.itech.iERP.forms.BankForm;

public class BankHandler 
{
	BankDaoImpl impl = new BankDaoImpl();
	public List<BankForm> list(long compid, DataSource dataSource) throws Exception
	{
		// TODO Auto-generated method stub
		return impl.listAll(compid,dataSource);
	}
	public String addRole(long compid, BankForm roleForm, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.add(compid,roleForm,dataSource);
	}
	public String changeRole(BankForm roleForm, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.changeStatus(roleForm,dataSource);
	}
	public String updateRole(BankForm roleForm, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.update(roleForm,dataSource);
	}
  
}
