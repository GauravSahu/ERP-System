package com.itech.iERP.forms;

import org.apache.struts.action.ActionForm;

public class ScodeMasterForm extends ActionForm 
{
   private String scode;
   private int roleId;
public String getScode() {
	return scode;
}
public void setScode(String scode) {
	this.scode = scode;
}
public int getRoleId() {
	return roleId;
}
public void setRoleId(int roleId) {
	this.roleId = roleId;
}  
}
