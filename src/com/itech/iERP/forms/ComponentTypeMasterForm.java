package com.itech.iERP.forms;

import org.apache.struts.action.ActionForm;

public class ComponentTypeMasterForm extends ActionForm
{
  private String componentName;
  private int componentId;
  private String componentType;
  private int value;
  private boolean active;
  private int compid;
  private int userid;
  
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getComponentName() {
	return componentName;
}
public void setComponentName(String componentName) {
	this.componentName = componentName;
}

public int getComponentId() {
	return componentId;
}
public void setComponentId(int componentId) {
	this.componentId = componentId;
}
public String getComponentType() {
	return componentType;
}
public void setComponentType(String componentType) {
	this.componentType = componentType;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
public int getCompid() {
	return compid;
}
public void setCompid(int compid) {
	this.compid = compid;
}
  
  
  
}
