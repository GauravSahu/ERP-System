package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

import com.mysql.jdbc.Blob;

public class VendorMasterForm extends ValidatorForm
{
	private int vendorid;
	private String teleno;
	private int areaid;
	private long stateid;
	private long cityid;
	private String mobileno;
	private String statename;
	private String cityname;
	private String firstname;
	private String dfirstname;
	private String lastname;
	private String vendorname;
	private String address;
	private String emailid1;
	private String emailid2;
	private String website;
	private String areaname;
    private String discount;
    private String tax;
	private boolean active;
	private Blob logo;
	
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public String getTeleno() {
		return teleno;
	}
	public void setTeleno(String teleno) {
		this.teleno = teleno;
	}
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public long getStateid() {
		return stateid;
	}
	public void setStateid(long stateid) {
		this.stateid = stateid;
	}
	public long getCityid() {
		return cityid;
	}
	public void setCityid(long cityid) {
		this.cityid = cityid;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getDfirstname() {
		return dfirstname;
	}
	public void setDfirstname(String dfirstname) {
		this.dfirstname = dfirstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailid1() {
		return emailid1;
	}
	public void setEmailid1(String emailid1) {
		this.emailid1 = emailid1;
	}
	public String getEmailid2() {
		return emailid2;
	}
	public void setEmailid2(String emailid2) {
		this.emailid2 = emailid2;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Blob getLogo() {
		return logo;
	}
	public void setLogo(Blob logo) {
		this.logo = logo;
	}
	
	
	
	
}
