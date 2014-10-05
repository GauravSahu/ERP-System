package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class LeavetypeForm extends ValidatorForm{
	
	private int leavetypeid;
	private String leavename;
	private int entitlement;
	private boolean active;
	
	
	public int getLeavetypeid() {
		return leavetypeid;
	}
	public void setLeavetypeid(int leavetypeid) {
		this.leavetypeid = leavetypeid;
	}
	public String getLeavename() {
		return leavename;
	}
	public void setLeavename(String leavename) {
		this.leavename = leavename;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public void setEntitlement(int entitlement) {
		this.entitlement = entitlement;
	}
	public int getEntitlement() {
		return entitlement;
	}
	
	

}
