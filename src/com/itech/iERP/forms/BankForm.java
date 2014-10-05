package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class BankForm extends ValidatorForm 
{
	private int bankId;
	private String bankName;
	private boolean active;
	private long compid;
	
	
	
	public long getCompid() {
		return compid;
	}
	public void setCompid(long compid) {
		this.compid = compid;
	}
	public int getBankId() 
	{
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
