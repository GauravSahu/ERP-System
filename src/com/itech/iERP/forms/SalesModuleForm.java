package com.itech.iERP.forms;



import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.cete.dynamicpdf.imaging.tiff.f;

public class SalesModuleForm extends ActionForm
{
   private int enquiryid;
   private String enquiryname;
   private String emailid;
   private String altemailid;
   private String mobilenumber;
   private String landlinenumber;
   private String altmobilenumber;
   private String userid;
   private String companyname;
   private String firstname;
   private String lastname;
   private String reference;
   private String servicetype;
   private String address;
   private String requirements;
   private String username;
   private String followupdetails;
   private String assignedto;
   private String fdate;
   private String followupid;
   private int altuserid;
   private String appdetails;
   private int appointmentid;
   private int price;
   private FormFile fileupload;
   private int quotationid;
   private String qdetails;
   private int enqid2;
   private Timestamp dated;
   private String fname;
   
   
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public Timestamp getDated() {
	return dated;
}
public void setDated(Timestamp dated) {
	this.dated = dated;
}
public int getEnqid2() {
	return enqid2;
}
public void setEnqid2(int enqid2) {
	this.enqid2 = enqid2;
}
public String getQdetails() {
	return qdetails;
}
public void setQdetails(String qdetails) {
	this.qdetails = qdetails;
}
public int getQuotationid() {
	return quotationid;
}
public void setQuotationid(int quotationid) {
	this.quotationid = quotationid;
}
public FormFile getFileupload() {
	return fileupload;
}
public void setFileupload(FormFile fileupload) {
	this.fileupload = fileupload;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getAppointmentid() {
	return appointmentid;
}
public void setAppointmentid(int appointmentid) {
	this.appointmentid = appointmentid;
}
public String getAppdetails() {
	return appdetails;
}
public void setAppdetails(String appdetails) {
	this.appdetails = appdetails;
}
public int getAltuserid() {
	return altuserid;
}
public void setAltuserid(int altuserid) {
	this.altuserid = altuserid;
}
public String getFollowupid() {
	return followupid;
}
public void setFollowupid(String followupid) {
	this.followupid = followupid;
}
public String getFollowupdetails() {
	return followupdetails;
}
public void setFollowupdetails(String followupdetails) {
	this.followupdetails = followupdetails;
}
public String getAssignedto() {
	return assignedto;
}
public void setAssignedto(String assignedto) {
	this.assignedto = assignedto;
}
public String getFdate() {
	return fdate;
}
public void setFdate(String fdate) {
	this.fdate = fdate;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getLandlinenumber() {
	return landlinenumber;
}
public void setLandlinenumber(String landlinenumber) {
	this.landlinenumber = landlinenumber;
}
public String getAltmobilenumber() {
	return altmobilenumber;
}
public void setAltmobilenumber(String altmobilenumber) {
	this.altmobilenumber = altmobilenumber;
}
public String getMobilenumber() {
	return mobilenumber;
}
public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getRequirements() {
	return requirements;
}
public void setRequirements(String requirements) {
	this.requirements = requirements;
}
public String getServicetype() {
	return servicetype;
}
public void setServicetype(String servicetype) {
	this.servicetype = servicetype;
}
public String getReference() {
	return reference;
}
public void setReference(String reference) {
	this.reference = reference;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public int getEnquiryid() {
	return enquiryid;
}
public void setEnquiryid(int enquiryid) {
	this.enquiryid = enquiryid;
}
public String getEnquiryname() {
	return enquiryname;
}
public void setEnquiryname(String enquiryname) {
	this.enquiryname = enquiryname;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getAltemailid() {
	return altemailid;
}
public void setAltemailid(String altemailid) {
	this.altemailid = altemailid;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getCompanyname() 
{
	return companyname;
}
public void setCompanyname(String companyname)
{
	this.companyname = companyname;
}
}
