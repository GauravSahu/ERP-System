package com.itech.iERP.handler;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.UserDaoImpl;
import com.itech.iERP.forms.UserForm;


public class UserHandler {


	UserDaoImpl  impl = new UserDaoImpl();
	public List<UserForm> list(long compid, DataSource dataSource)
	{
		
		return impl.listAll(compid,dataSource);
	}
	public String add(long compid, Timestamp dob, Timestamp doj, UserForm userForm, DataSource dataSource) 
	{
		
		return impl.add(compid,dob,doj,userForm,dataSource);
	}
	public String changeStatus(UserForm userForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeStatus(userForm,dataSource);
	}
	public String updateUser(UserForm userForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.update(userForm,dataSource);
	}
	public List<UserForm> active(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.activeList(dataSource);
	}
	public List<UserForm> roleList(long compid, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.roleList(compid,dataSource);
	}
	public List<UserForm> companyList(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.companyList(dataSource);
	}
	public List<UserForm> ApproveList(long compid, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.ApproveList(compid,dataSource);
	}
	public List<UserForm> desiList(long compid, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.desiList(compid,dataSource);
	}
	public List<UserForm> banklist(long compid, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.banklist(compid,dataSource);
	}
  

}
