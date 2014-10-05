package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class BookCatForm extends ValidatorForm{

	private static final long serialVersionUID = 1L;
	private int bookcatid;
	private String catname;
	private boolean active;

	
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	
	public int getBookcatid() {
		return bookcatid;
	}
	public void setBookcatid(int bookcatid) {
		this.bookcatid = bookcatid;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}