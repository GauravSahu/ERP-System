package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class UserForm extends ValidatorForm {
	
	private int userid;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String phone1;
	private String phone2;
	private String emailid;
	private String ssn;
	private int roleid;
	private String rolename;
	private int userId1;
	private int userId2;
	private String approver;
	private int appId;
	private String dob;
	private int age;
	private String fathername;
	private String mothername;
	private String doj;
	private String salaryaccountnumber;
	private String emercontnumber;
	private String presentadd;
	private String permadd;
	private String desiid;
	private String desiname;
	private String bankid;
	private String bankname;
	private String gender;
	private String spousename;
	private String spouseage;
	private String spouseeducadet;
	private String spousejobdetails;
	private String childdetails;
	private String depeparentdetails;
    private String age1;
    private String myDate;
    private String employeeid;
    private String pancardnumber;
    private String pfdetails;
    private String bloodgroup;
    
    
    
    
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getPancardnumber() {
		return pancardnumber;
	}
	public void setPancardnumber(String pancardnumber) {
		this.pancardnumber = pancardnumber;
	}
	public String getPfdetails() {
		return pfdetails;
	}
	public void setPfdetails(String pfdetails) {
		this.pfdetails = pfdetails;
	}
	public String getAge1() {
		return age1;
	}
	public void setAge1(String age1) {
		this.age1 = age1;
	}
	public String getMyDate() {
		return myDate;
	}
	public void setMyDate(String myDate) {
		this.myDate = myDate;
	}
	public String getSpousename() {
		return spousename;
	}
	public void setSpousename(String spousename) {
		this.spousename = spousename;
	}
	public String getSpouseage() {
		return spouseage;
	}
	public void setSpouseage(String spouseage) {
		this.spouseage = spouseage;
	}
	public String getSpouseeducadet() {
		return spouseeducadet;
	}
	public void setSpouseeducadet(String spouseeducadet) {
		this.spouseeducadet = spouseeducadet;
	}
	public String getSpousejobdetails() {
		return spousejobdetails;
	}
	public void setSpousejobdetails(String spousejobdetails) {
		this.spousejobdetails = spousejobdetails;
	}
	public String getChilddetails() {
		return childdetails;
	}
	public void setChilddetails(String childdetails) {
		this.childdetails = childdetails;
	}
	public String getDepeparentdetails() {
		return depeparentdetails;
	}
	public void setDepeparentdetails(String depeparentdetails) {
		this.depeparentdetails = depeparentdetails;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getDesiid() {
		return desiid;
	}
	public void setDesiid(String desiid) {
		this.desiid = desiid;
	}
	public String getDesiname() {
		return desiname;
	}
	public void setDesiname(String desiname) {
		this.desiname = desiname;
	}
	public String getPermadd() {
		return permadd;
	}
	public void setPermadd(String permadd) {
		this.permadd = permadd;
	}
	public String getPresentadd() {
		return presentadd;
	}
	public void setPresentadd(String presentadd) {
		this.presentadd = presentadd;
	}
	public String getEmercontnumber() {
		return emercontnumber;
	}
	public void setEmercontnumber(String emercontnumber) {
		this.emercontnumber = emercontnumber;
	}
	public String getSalaryaccountnumber() {
		return salaryaccountnumber;
	}
	public void setSalaryaccountnumber(String salaryaccountnumber) {
		this.salaryaccountnumber = salaryaccountnumber;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public int getUserId1() {
		return userId1;
	}
	public void setUserId1(int userId1) {
		this.userId1 = userId1;
	}
	public int getUserId2() {
		return userId2;
	}
	public void setUserId2(int userId2) {
		this.userId2 = userId2;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	private int companyid;
	private String companyname;
	private boolean active;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
}
