package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.CalenderDaoImpl;
import com.itech.iERP.forms.CalenderTypeForm;

public class CalenderTypeHandler 
{

	CalenderDaoImpl impl = new CalenderDaoImpl();
	public List<CalenderTypeForm> list(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listAll(dataSource);
	}
	public String addAttendance(CalenderTypeForm astatusform,
			DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.add(astatusform,dataSource);
	}
	public String changeRole(CalenderTypeForm astatusform, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeStatus(astatusform,dataSource);
	}
	public String updateRole(CalenderTypeForm astatusform, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.update(astatusform,dataSource);
	}
  
}
