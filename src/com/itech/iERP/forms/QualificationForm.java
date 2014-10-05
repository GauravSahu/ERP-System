package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class QualificationForm extends ValidatorForm{
	private int qualificationid;
	private String qualificationname;
	private boolean active;
	public int getQualificationid() {
		return qualificationid;
	}
	public void setQualificationid(int qualificationid) {
		this.qualificationid = qualificationid;
	}
	public String getQualificationname() {
		return qualificationname;
	}
	public void setQualificationname(String qualificationname) {
		this.qualificationname = qualificationname;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

}
