package com.itech.iERP.forms;

import org.apache.struts.action.ActionForm;

public class PaymentTransactionForm extends ActionForm 
{
   private String fdate;
   private String vendorid;
   private String vendorname;
public String getFdate() {
	return fdate;
}
public void setFdate(String fdate) {
	this.fdate = fdate;
}
public String getVendorid() {
	return vendorid;
}
public void setVendorid(String vendorid) {
	this.vendorid = vendorid;
}
public String getVendorname() {
	return vendorname;
}
public void setVendorname(String vendorname) {
	this.vendorname = vendorname;
}
   
   
}
