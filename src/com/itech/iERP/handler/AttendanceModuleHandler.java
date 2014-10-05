package com.itech.iERP.handler;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.AttendanceModuleDaoImpl;
import com.itech.iERP.forms.AttendanceModuleForm;

public class AttendanceModuleHandler {

	AttendanceModuleDaoImpl impl = new  AttendanceModuleDaoImpl();
	public String addAtte(AttendanceModuleForm attmodform, long userid,
			long compid, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.addatte(attmodform,userid,compid,dataSource);
	}
	public String addAtte1(AttendanceModuleForm attmodform,String s, long userid,
			long compid, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.addatte1(attmodform,s,userid,compid,dataSource);
	}
	public String addLogout(AttendanceModuleForm attmodform, long userid,
			long compid, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.addLogout(attmodform,userid,compid,dataSource);
	}
	public List<AttendanceModuleForm> listEmp(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listEmp(dataSource);
	}
	public List<AttendanceModuleForm> listEmp1(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listEmp1(dataSource);
	}
	public List<AttendanceModuleForm> listAttList(Timestamp ftimets,
			Timestamp ttimets, AttendanceModuleForm attmodform,
			DataSource dataSource) 
			{
		
		// TODO Auto-generated method stub
		return impl.listAttRep(ftimets,ttimets,attmodform,dataSource);
	}
	public List<AttendanceModuleForm> listLeaveList1(
			AttendanceModuleForm attmodform,String name, DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.listLeaveList1(attmodform,name,dataSource);
	      }
	public String name(DataSource dataSource, long userid) 
	{
		// TODO Auto-generated method stub
		return impl.getName(dataSource,userid);
	}
	
}
