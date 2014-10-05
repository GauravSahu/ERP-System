package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class PriceMasterForm extends ValidatorForm{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int price;
private int itemid;
private int venderid;
private String vendername;
private String itemname;

public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getItemid() {
	return itemid;
}
public void setItemid(int itemid) {
	this.itemid = itemid;
}
public int getVenderid() {
	return venderid;
}
public void setVenderid(int venderid) {
	this.venderid = venderid;
}
public String getVendername() {
	return vendername;
}
public void setVendername(String vendername) {
	this.vendername = vendername;
}
public String getItemname() {
	return itemname;
}
public void setItemname(String itemname) {
	this.itemname = itemname;
}
}
