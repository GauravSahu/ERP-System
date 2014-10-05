package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.StateDaoImpl;
import com.itech.iERP.forms.StateForm;

public class StateHandler 
{

	StateDaoImpl impl = new StateDaoImpl();
	public List<StateForm> list(long countryid, DataSource dataSource)
	{
		
		return impl.listAll(countryid,dataSource);
	}
	public String addState(StateForm stateForm, DataSource dataSource) {
		System.out.println("Handler");
		return impl.add(stateForm,dataSource);
	}
	public String changeState(StateForm stateForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeStatus(stateForm,dataSource);
	}
	public String updateState(StateForm stateForm, DataSource dataSource) 
	{
		return impl.update(stateForm,dataSource);
	}
	public List<StateForm> listactive(long countryid, DataSource dataSource)
	{
		return impl.listactive(countryid,dataSource);
	}

}
