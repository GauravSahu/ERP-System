package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class LibraryModuleForm extends ValidatorForm{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int bookid;
		private String booktitle;
		
		private int employeeid;
		private int employeeid1;
	
		private String employeename;
		private String takendate;
		private String takentime;
		private String returndate;
		private String remark;
		private String email;
		private String employeename2;
 		
	
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		
		public String getBooktitle() {
			return booktitle;
		}
		public void setBooktitle(String booktitle) {
			this.booktitle = booktitle;
		}
		
		public int getEmployeeid() {
			return employeeid;
		}
		public String getEmployeename2() {
			return employeename2;
		}
		public void setEmployeename2(String employeename2) {
			this.employeename2 = employeename2;
		}
		public void setEmployeeid(int employeeid) {
			this.employeeid = employeeid;
		}
		
		
		public String getTakendate() {
			return takendate;
		}
		public void setTakendate(String takendate) {
			this.takendate = takendate;
		}
		
		
		public String getReturndate() {
			return returndate;
		}
		public void setReturndate(String returndate) {
			this.returndate = returndate;
		}
		

		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		
		public String getTakentime() {
			return takentime;
		}
		public void setTakentime(String takentime) {
			this.takentime = takentime;
		}
		public String getEmployeename() {
			return employeename;
		}
		public void setEmployeename(String employeename) {
			this.employeename = employeename;
		}
	
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getEmployeeid1() {
			return employeeid1;
		}
		public void setEmployeeid1(int employeeid1) {
			this.employeeid1 = employeeid1;
		}
}



