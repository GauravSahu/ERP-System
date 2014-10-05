package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class StateForm extends ValidatorForm
{
	/**
	 * 
	 **/
	private static final long serialVersionUID = 1L;
	private long stateid;
	private String statename;
	private boolean active;
	private long countryid;
	public long getStateid() {
		return stateid;
	}
	public void setStateid(long stateid) {
		this.stateid = stateid;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public long getCountryid() {
		return countryid;
	}
	public void setCountryid(long countryid) {
		this.countryid = countryid;
	}
	
	
}
