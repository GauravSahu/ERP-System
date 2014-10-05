package com.itech.iERP.forms;

import java.sql.Timestamp;

import org.apache.struts.validator.ValidatorForm;

public class AttendanceModuleForm extends ValidatorForm
{
   private Timestamp dated;
   private String compId;
   private String userid;
//   private Timestamp signIn;
//   private Timestamp signOut;
   private String reason;
   private String AttLateCutOffTime;
   private String signIn;
   private String signOut;
   private long userId;
   private int company;
   
   private String fDate;
   private String tDate;
   private String fname;
   private String tname;
   private String userId1;
	private String userId2;

	public String getUserId1() {
		return userId1;
	}
	public void setUserId1(String userId1) {
		this.userId1 = userId1;
	}
	public String getUserId2() {
		return userId2;
	}
	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}
	//  private int userid;
	private String username;
   
public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
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
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public int getCompany() {
	return company;
}
public void setCompany(int company) {
	this.company = company;
}
public String getAttLateCutOffTime() {
	return AttLateCutOffTime;
}
public void setAttLateCutOffTime(String attLateCutOffTime) {
	AttLateCutOffTime = attLateCutOffTime;
}
public Timestamp getDated() {
	return dated;
}
public void setDated(Timestamp dated) {
	this.dated = dated;
}
public String getCompId() {
	return compId;
}
public void setCompId(String compId) {
	this.compId = compId;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
//public Timestamp getSignIn() {
//	return signIn;
//}
//public void setSignIn(Timestamp signIn) {
//	this.signIn = signIn;
//}
//public Timestamp getSignOut() {
//	return signOut;
//}
//public void setSignOut(Timestamp signOut) {
//	this.signOut = signOut;
//}
public String getReason() {
	return reason;
}
public String getSignIn() {
	return signIn;
}
public void setSignIn(String signIn) {
	this.signIn = signIn;
}
public String getSignOut() {
	return signOut;
}
public void setSignOut(String signOut) {
	this.signOut = signOut;
}
public void setReason(String reason) {
	this.reason = reason;
}
}
