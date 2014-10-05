package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class PrevilegeForm extends ValidatorForm
{
	private Long userId;
	private Long roleId;
	private Long previlegeId;
	private Long functionId;
	private Long access;
	private String[] accessArr;
	private String functionName;
	private int[] access_admin;
	private String[] admin;
	private int[] access_agm;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getPrevilegeId() {
		return previlegeId;
	}
	public void setPrevilegeId(Long previlegeId) {
		this.previlegeId = previlegeId;
	}
	public Long getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}
	public Long getAccess() {
		return access;
	}
	public void setAccess(Long access) {
		this.access = access;
	}
	public String[] getAccessArr() {
		return accessArr;
	}
	public void setAccessArr(String[] accessArr) {
		this.accessArr = accessArr;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public int[] getAccess_admin() {
		return access_admin;
	}
	public void setAccess_admin(int[] accessAdmin) {
		access_admin = accessAdmin;
	}
	public String[] getAdmin() {
		return admin;
	}
	public void setAdmin(String[] admin) {
		this.admin = admin;
	}
	public int[] getAccess_agm() {
		return access_agm;
	}
	public void setAccess_agm(int[] accessAgm) {
		access_agm = accessAgm;
	}
	
	
	
}
