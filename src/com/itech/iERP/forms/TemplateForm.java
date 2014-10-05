package com.itech.iERP.forms;

import org.apache.struts.action.ActionForm;


public class TemplateForm extends ActionForm
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int TemplateId;
	private int tempId;
	public int getTempId() {
		return tempId;
	}
	public void setTempId(int tempId) {
		this.tempId = tempId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String TemplateName;
	private String tempName;
	public String getTempName() {
		return tempName;
	}
	public void setTempName(String tempName) {
		this.tempName = tempName;
	}
	private boolean active;
	public int getTemplateId() {
		return TemplateId;
	}
	public void setTemplateId(int templateId) {
		TemplateId = templateId;
	}
	public String getTemplateName() {
		return TemplateName;
	}
	public void setTemplateName(String templateName) {
		TemplateName = templateName;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
