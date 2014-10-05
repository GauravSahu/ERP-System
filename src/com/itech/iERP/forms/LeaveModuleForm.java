package com.itech.iERP.forms;

import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class LeaveModuleForm extends ActionForm
{
	private String fDate;
	   private String tDate;
	   private String diff;
	   private int userid;
	   private String approveri;
	   private int adds;
	   
	   private String username;
	   private String userId1;
	   private String reason;
	   private int leaveAppId;
	   private String rejection;
	   private String userId2;
	   private Timestamp applieddate;
	   private String status;
	   private String leaveType;
	   private String mailId;
	   private FormFile doc1;
	   private FormFile doc2;
	   private FormFile doc3;
	   private FormFile doc4;
	   private FormFile doc5;
	   private FormFile doc6;
	   private String documents;
	   private String docname1;
	   private String docname2;
	   private String docname3;
	   private String docname4;
	   private String docname5;
	   private String docname6;
	   
	   
	   
	   
	    	    
	public String getDocname1() {
		return docname1;
	}
	public void setDocname1(String docname1) {
		this.docname1 = docname1;
	}
	public String getDocname2() {
		return docname2;
	}
	public void setDocname2(String docname2) {
		this.docname2 = docname2;
	}
	public String getDocname3() {
		return docname3;
	}
	public void setDocname3(String docname3) {
		this.docname3 = docname3;
	}
	public String getDocname4() {
		return docname4;
	}
	public void setDocname4(String docname4) {
		this.docname4 = docname4;
	}
	public String getDocname5() {
		return docname5;
	}
	public void setDocname5(String docname5) {
		this.docname5 = docname5;
	}
	public String getDocname6() {
		return docname6;
	}
	public void setDocname6(String docname6) {
		this.docname6 = docname6;
	}
	public String getDocuments() {
		return documents;
	}
	public void setDocuments(String documents) {
		this.documents = documents;
	}
	public FormFile getDoc1() {
		return doc1;
	}
	public void setDoc1(FormFile doc1) {
		this.doc1 = doc1;
	}
	public FormFile getDoc2() {
		return doc2;
	}
	public void setDoc2(FormFile doc2) {
		this.doc2 = doc2;
	}
	public FormFile getDoc3() {
		return doc3;
	}
	public void setDoc3(FormFile doc3) {
		this.doc3 = doc3;
	}
	public FormFile getDoc4() {
		return doc4;
	}
	public void setDoc4(FormFile doc4) {
		this.doc4 = doc4;
	}
	public FormFile getDoc5() {
		return doc5;
	}
	public void setDoc5(FormFile doc5) {
		this.doc5 = doc5;
	}
	public FormFile getDoc6() {
		return doc6;
	}
	public void setDoc6(FormFile doc6) {
		this.doc6 = doc6;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getApplieddate() {
		return applieddate;
	}
	public void setApplieddate(Timestamp applieddate) {
		this.applieddate = applieddate;
	}
	public String getUserId2() {
		return userId2;
	}
	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}
	public String getRejection() {
		return rejection;
	}
	public void setRejection(String rejection) {
		this.rejection = rejection;
	}
	public int getLeaveAppId() {
		return leaveAppId;
	}
	public void setLeaveAppId(int leaveAppId) {
		this.leaveAppId = leaveAppId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserId1() {
		return userId1;
	}
	public void setUserId1(String userId1) {
		this.userId1 = userId1;
	}
	
	public int getAdds() {
		return adds;
	}
	public void setAdds(int adds) {
		this.adds = adds;
	}
	private String firstName;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getApproveri() {
		return approveri;
	}
	public void setApproveri(String approveri) {
		this.approveri = approveri;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getfDate() {
		return fDate;
	}
	public void setfDate(String fDate) {
		this.fDate = fDate;
	}
	public String gettDate() {
		return tDate;
	}
	public void settDate(String tDate) {
		this.tDate = tDate;
	}
	public String getDiff() {
		return diff;
	}
	public void setDiff(String diff) {
		this.diff = diff;
	}   
}
