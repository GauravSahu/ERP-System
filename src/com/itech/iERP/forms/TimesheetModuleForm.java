package com.itech.iERP.forms;

import org.apache.struts.action.ActionForm;

public class TimesheetModuleForm extends ActionForm
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
    private String timesheet;
    private String userId1;
    private String userId2;
    private String username;
    private String applied;
    private String firstName;
    
    
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getApplied() {
		return applied;
	}
	public void setApplied(String applied) {
		this.applied = applied;
	}
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(String timesheet) {
		this.timesheet = timesheet;
	}
    
    
}
