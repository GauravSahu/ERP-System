package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class EmployeeForm extends ValidatorForm
{
	private int empNo;
	private String dayOfJoining;
	private String designationId;
	private String qualificationId;
	private String qualificationid;
	public String getQualificationid() {
		return qualificationid;
	}
	public void setQualificationid(String qualificationid) {
		this.qualificationid = qualificationid;
	}
	private String bankId;
	private String bankAccountNo;
	private String pf_N0;
	private String firstName;
	private String lastName;
	private String maritalStatus;
	private String dayOfBirth;
	private String gender;
	private String permanentAddress;
	private String persentAddress;
	private String email;
	private String mobile;
	private String alternateNum;
	private String cityId;
	private String stateId;
	private String countryId;
	private String passportNo;
	private String panNum;
	private String userName;
	private String password;
	private String confirmPassword;
	private String pinCode;
	private boolean active;
	private String empNum;
	
	private String desid;
	
//	public String getEmpNo() {
//		return empNo;
//	}
//	public void setEmpNo(String empNo) {
//		this.empNo = empNo;
//	}
	
	
	public String getDesid() {
		return desid;
	}
	public void setDesid(String desid) {
		this.desid = desid;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getDayOfJoining() {
		return dayOfJoining;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public void setDayOfJoining(String dayOfJoining) {
		this.dayOfJoining = dayOfJoining;
	}
	public String getDesignationId() {
		return designationId;
	}
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}
	public String getQualificationId() {
		return qualificationId;
	}
	public void setQualificationId(String qualificationId) {
		this.qualificationId = qualificationId;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getPf_N0() {
		return pf_N0;
	}
	public void setPf_N0(String pfN0) {
		pf_N0 = pfN0;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPersentAddress() {
		return persentAddress;
	}
	public void setPersentAddress(String persentAddress) {
		this.persentAddress = persentAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAlternateNum() {
		return alternateNum;
	}
	public void setAlternateNum(String alternateNum) {
		this.alternateNum = alternateNum;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getPanNum() {
		return panNum;
	}
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
