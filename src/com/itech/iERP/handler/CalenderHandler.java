package com.itech.iERP.handler;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.Calender1DaoImpl;
import com.itech.iERP.forms.CalenderForm;
import com.itech.iERP.forms.UserForm;


public class CalenderHandler {

	Calender1DaoImpl  impl = new Calender1DaoImpl();
	public List<CalenderForm> list(DataSource dataSource)
	{
		
		return impl.listAll(dataSource);
	}
	public String add(CalenderForm calenderForm, DataSource dataSource, Timestamp timets) 
	{
		
		return impl.add(calenderForm,dataSource,timets);
	}
	public List<CalenderForm> cstatusList(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.cstatusList(dataSource);
	}
	public List<CalenderForm> companyList(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.companyList(dataSource);
	}
	public String updateDaytype(CalenderForm calenderForm, DataSource dataSource ) {
		return impl.updateDaytype(calenderForm, dataSource);
	}
}
