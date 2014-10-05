package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class SalaryForm extends ValidatorForm 
{
   private int salaryId;
   private long basic;
   private long netSal;
   private long tax;
   public long getTax() {
	return tax;
}
public void setTax(long tax) {
	this.tax = tax;
}
private boolean active;
   
public long getSalaryId() {
	return salaryId;
}

public void setSalaryId(int salaryId) {
	this.salaryId = salaryId;
}
public long getBasic() {
	return basic;
}
public void setBasic(long basic) {
	this.basic = basic;
}
public long getNetSal() {
	return netSal;
}
public void setNetSal(long netSal) {
	this.netSal = netSal;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
   
   
}
