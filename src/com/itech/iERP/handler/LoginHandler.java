package com.itech.iERP.handler;

import javax.sql.DataSource;

import org.apache.struts.action.ActionForward;

import com.itech.iERP.daoimpl.LoginDaoImpl;
import com.itech.iERP.forms.LoginForm;

public class LoginHandler {
	LoginDaoImpl impl = new LoginDaoImpl();
	
	public LoginForm loginValidation(String userName, String password,DataSource ds)
	{
		return impl.login(userName,password,ds);
	}
 
	public LoginForm scode1(String userName, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.scode(userName,dataSource);
	}
    
	
}
