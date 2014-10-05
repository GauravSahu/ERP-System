package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;


import com.itech.iERP.daoimpl.LeavetypeDaoImpl;

import com.itech.iERP.forms.LeavetypeForm;

public class LeavetypeHandler {


	LeavetypeDaoImpl  impl = new LeavetypeDaoImpl();
	public List<LeavetypeForm> list(DataSource dataSource)
	{
		
		return impl.listAll(dataSource);
	}
	public String add(LeavetypeForm leavetypeForm, DataSource dataSource) 
	{
		
		return impl.add(leavetypeForm,dataSource);
	}
	public String changeStatus(LeavetypeForm leavetypeForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeStatus(leavetypeForm,dataSource);
	}
	public String updateLeavetype(LeavetypeForm leavetypeForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.update(leavetypeForm,dataSource);
	}
	public List<LeavetypeForm> active(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.activeList(dataSource);
	}
  

}
