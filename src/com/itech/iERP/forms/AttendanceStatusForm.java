package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class AttendanceStatusForm extends ValidatorForm
{
   private int astatusId;
   private String astatusName;
   private boolean active;
public int getAstatusId() {
	return astatusId;
}
public void setAstatusId(int astatusId) {
	this.astatusId = astatusId;
}
public String getAstatusName() {
	return astatusName;
}
public void setAstatusName(String astatusName) {
	this.astatusName = astatusName;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
   
   
}
