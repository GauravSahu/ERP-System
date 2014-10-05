package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class CalenderTypeForm extends ValidatorForm
{
  private int calendertypeId;
  private String calendertypeName;
  private boolean active;
public int getCalendertypeId() {
	return calendertypeId;
}
public void setCalendertypeId(int calendertypeId) {
	this.calendertypeId = calendertypeId;
}
public String getCalendertypeName() {
	return calendertypeName;
}
public void setCalendertypeName(String calendertypeName) {
	this.calendertypeName = calendertypeName;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
  
  
}
