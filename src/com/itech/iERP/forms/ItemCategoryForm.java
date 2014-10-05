package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class ItemCategoryForm extends ValidatorForm {
	private int categoryid;
	private String categoryname;
	private boolean active;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	

}
