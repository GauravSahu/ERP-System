package com.itech.iERP.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;


public class CompanyForm extends ActionForm
{
  private String companyName;
  private FormFile file;
  private int companyId;
  private String Address;
  private String emailId1;
  private String emailId2;
  private String contactNo;
  private String ALCutOff;
  private String PermAddress;
  
  
	public String getPermAddress() {
	return PermAddress;
}
public void setPermAddress(String permAddress) {
	PermAddress = permAddress;
}
	private FormFile fileName;
	private boolean active;
  
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public FormFile getFile() {
	return file;
}
public void setFile(FormFile file) {
	this.file = file;
}
public int getCompanyId() {
	return companyId;
}
public void setCompanyId(int companyId) {
	this.companyId = companyId;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getEmailId1() {
	return emailId1;
}
public void setEmailId1(String emailId1) {
	this.emailId1 = emailId1;
}
public String getEmailId2() {
	return emailId2;
}
public void setEmailId2(String emailId2) {
	this.emailId2 = emailId2;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getALCutOff() {
	return ALCutOff;
}
public void setALCutOff(String aLCutOff) {
	ALCutOff = aLCutOff;
}
public void setFileName(FormFile fileName) {
	this.fileName = fileName;
}
public FormFile getFileName() {
	return fileName;
}
public void setActive(boolean active) {
	this.active = active;
}
public boolean isActive() {
	return active;
}
  
  
}
