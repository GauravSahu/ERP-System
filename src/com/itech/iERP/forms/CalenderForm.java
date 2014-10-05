package com.itech.iERP.forms;

import java.sql.Date;
import java.sql.Timestamp;

import org.apache.struts.validator.ValidatorForm;
import org.apache.taglibs.bsf.scriptlet;

import antlr.collections.List;

public class CalenderForm extends ValidatorForm{
	
	private String companyid;
	private String dcompanyid;
	private long caldaytypeid;
	private String caldaytypename;
	private String date;
	private Timestamp date1;
	private String day;
	private String caldayid;
	private String calendername;
	private String companyname;
	
	
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	public String getCompanyid() {
		return companyid;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	public String getDay() {
		return day;
	}
	public void setCaldayid(String caldayid) {
		this.caldayid = caldayid;
	}
	public String getCaldayid() {
		return caldayid;
	}
	public void setCalendername(String calendername) {
		this.calendername = calendername;
	}
	public String getCalendername() {
		return calendername;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCaldaytypeid(long caldaytypeid) {
		this.caldaytypeid = caldaytypeid;
	}
	public long getCaldaytypeid() {
		return caldaytypeid;
	}
	public void setCaldaytypename(String caldaytypename) {
		this.caldaytypename = caldaytypename;
	}
	public String getCaldaytypename() {
		return caldaytypename;
	}
	
	public void setDate1(Timestamp date1) {
		this.date1 = date1;
	}
	public Timestamp getDate1() {
		return date1;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setDcompanyid(String dcompanyid) {
		this.dcompanyid = dcompanyid;
	}
	public String getDcompanyid() {
		return dcompanyid;
	}
	
	
}
