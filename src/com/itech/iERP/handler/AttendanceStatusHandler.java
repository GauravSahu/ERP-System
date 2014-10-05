package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.AttenDapImpl;
import com.itech.iERP.forms.AttendanceStatusForm;

public class AttendanceStatusHandler 
{

	AttenDapImpl impl = new AttenDapImpl();
	public List<AttendanceStatusForm> list(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listAll(dataSource);
	}
	public String addAttendance(AttendanceStatusForm astatusform,
			DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.add(astatusform,dataSource);
	}
	public String  changeRole(AttendanceStatusForm astatusform,
			DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeStatus(astatusform,dataSource);
	}
	public String updateRole(AttendanceStatusForm astatusform,
			DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.update(astatusform,dataSource);
	}
	
	
	
   
}
