package com.itech.iERP.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.validator.ValidatorForm;

public class ContryForm extends ValidatorForm
{
	private int countryid;
	private String countryname;
	private boolean active;
	
	
	public int getCountryid() {
		return countryid;
	}
	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
