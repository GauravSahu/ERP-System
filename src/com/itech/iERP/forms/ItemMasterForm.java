package com.itech.iERP.forms;

import org.apache.struts.action.ActionForm;

public class ItemMasterForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int categoryid;
	private String itemname;
	private boolean active;
	private int itemmasterid;
	private String categoryname;
	
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public boolean  isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public int getItemmasterid() {
		return itemmasterid;
	}
	public void setItemmasterid(int itemmasterid) {
		this.itemmasterid = itemmasterid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	

}
