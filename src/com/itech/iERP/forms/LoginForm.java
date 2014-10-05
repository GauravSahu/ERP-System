package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class LoginForm extends ValidatorForm
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  private long userId;
  private String password;
  private String username;
  private String firstname;
  private String lastname;
  private int role;
  private int company;
  private String  companylogo;
  private String scode;
  private int scodeId;
  private long compid;
  
  
  


public long getCompid() {
	return compid;
}
public void setCompid(long compid) {
	this.compid = compid;
}
public int getScodeId() {
	return scodeId;
}
public void setScodeId(int scodeId) {
	this.scodeId = scodeId;
}
public String getScode() {
	return scode;
}
public void setScode(String scode) {
	this.scode = scode;
}
public String getCompanylogo() {
	return companylogo;
}
public void setCompanylogo(String companylogo) {
	this.companylogo = companylogo;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
private boolean active;

public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
public int getCompany() {
	return company;
}
public void setCompany(int company) {
	this.company = company;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
  
  
}
