package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class BaseForm extends ValidatorForm
{
	public String id;
	private String formName;
	private boolean active;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
