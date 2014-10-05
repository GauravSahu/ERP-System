package com.itech.iERP.forms;

import org.apache.struts.validator.ValidatorForm;

public class DocDownloadForm extends ValidatorForm
{
    private String userid;
    private String username;
    private String filename;
    private int fid;
    private String filetype;
    
    
    
    
    
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
    
    
}
