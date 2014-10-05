package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.CustomerDaoImpl;
import com.itech.iERP.forms.CustomerForm;




public class CustomerHandler {

	
	CustomerDaoImpl  impl = new CustomerDaoImpl();
	public List<CustomerForm> list(DataSource dataSource)
	{
		
		return impl.listAll(dataSource);
	}
	public String add(CustomerForm customerForm, DataSource dataSource) 
	{
		
		return impl.add(customerForm,dataSource);
	}
	public String changeStatus(CustomerForm customerForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeStatus(customerForm,dataSource);
	}
	public String updateCustomer(CustomerForm customerForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.update(customerForm,dataSource);
	}
	public List<CustomerForm> active(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.activeList(dataSource);
	}
/*	public List<CustomerForm> userList(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.userList(dataSource);
	}*/
	public List<CustomerForm> countryList(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.countryList(dataSource);
	}
	public List<CustomerForm> cityList(DataSource dataSource, int stateid) {
		// TODO Auto-generated method stub
		return impl.cityList(dataSource, stateid);
	}
	public List<CustomerForm> stateList(DataSource dataSource, int countryid) {
		// TODO Auto-generated method stub
		return impl.stateList(dataSource, countryid);
	}
  

}
