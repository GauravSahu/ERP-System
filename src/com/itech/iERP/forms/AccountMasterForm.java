package com.itech.iERP.forms;

import org.apache.struts.action.ActionForm;

import com.itech.iERP.actions.BaseAction;
/*
 * create the getter and setter method for the parameters which belongs accountmaster data
 */
public class AccountMasterForm extends ActionForm
{
  private String accountno;
  private String accountname;
  private String accounttype;
  private boolean active;
public String getAccountno() {
	return accountno;
}
public void setAccountno(String accountno) {
	this.accountno = accountno;
}
public String getAccountname() {
	return accountname;
}
public void setAccountname(String accountname) {
	this.accountname = accountname;
}
public String getAccounttype() {
	return accounttype;
}
public void setAccounttype(String accounttype) {
	this.accounttype = accounttype;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
}
