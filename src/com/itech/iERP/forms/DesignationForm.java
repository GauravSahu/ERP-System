package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class DesignationForm extends ValidatorForm 
{
	private int desid;
	private String desname;
	private boolean active;
	public int getDesid() {
		return desid;
	}
	public void setDesid(int desid) {
		this.desid = desid;
	}
	public String getDesname() {
		return desname;
	}
	public void setDesname(String desname) {
		this.desname = desname;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
