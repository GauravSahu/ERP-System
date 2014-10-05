package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class ForgotPasswordForm extends ValidatorForm
{
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
