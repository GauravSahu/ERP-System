package com.itech.iERP.handler;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.ForgotPasswordDaoImpl;
import com.itech.iERP.forms.ForgotPasswordForm;

public class ForgotPasswordHandler 
{
	ForgotPasswordDaoImpl impl = new ForgotPasswordDaoImpl();
	public String forgotPassword(ForgotPasswordForm forgotPasswordForm,
			DataSource ds) {

		return impl.sendmail(forgotPasswordForm, ds);
	}
}
