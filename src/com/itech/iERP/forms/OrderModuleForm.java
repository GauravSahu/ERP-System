package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class OrderModuleForm extends ValidatorForm
{
   private int itemtid;
   private String itemname;
   private int vendorid;
   private String vendorname;
   private String remarks;
   private int price;
   private int qty;
   
   
   
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getItemtid() {
	return itemtid;
}
public void setItemtid(int itemtid) {
	this.itemtid = itemtid;
}
public String getItemname() {
	return itemname;
}
public void setItemname(String itemname) {
	this.itemname = itemname;
}
public int getVendorid() {
	return vendorid;
}
public void setVendorid(int vendorid) {
	this.vendorid = vendorid;
}
public String getVendorname() {
	return vendorname;
}
public void setVendorname(String vendorname) {
	this.vendorname = vendorname;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
}
