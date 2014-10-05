package com.itech.iERP.handler;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.TimesheetModuleDaoImpl;
import com.itech.iERP.forms.TimesheetModuleForm;

public class TimesheetModuleHandler 
{

	TimesheetModuleDaoImpl impl = new TimesheetModuleDaoImpl();
	public String addtimesheet(TimesheetModuleForm timesheet, long userid,
			DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.timesheet(timesheet,userid,dataSource);
	}
	public List<TimesheetModuleForm> listEmp(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listEmp(dataSource);
	}
	public List<TimesheetModuleForm> listEmp1(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listEmp1(dataSource);
	}
	public List<TimesheetModuleForm> listLeaveList(Timestamp ftimets,
			Timestamp ttimets, TimesheetModuleForm timesheet,
			DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.listleave(ftimets,ttimets,timesheet,dataSource);
	       }
	
	public List<TimesheetModuleForm> listLeaveList1(
			TimesheetModuleForm timesheet, DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.listLeaveList1(timesheet,dataSource);
	       }
	public String name(DataSource dataSource, long userid) 
	{
		// TODO Auto-generated method stub
		return impl.getName(dataSource, userid);
	}
	
  
}
