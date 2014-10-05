package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class RoleForm extends ValidatorForm
{
	private int roleid;
	private String rolename;
	private boolean active;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
