package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.RoleForm;
import com.itech.iERP.forms.TemplateForm;
import com.itech.iERP.handler.TemplateHandler;

public class TemplateAction extends BaseAction 
{
	TemplateHandler handler = new TemplateHandler();
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("inside the template master");
		List<TemplateForm> template = handler.list(getDataSource(request));
		request.setAttribute("templateList",template);	
		System.out.println("Template list "+template);
		return mapping.findForward("TemplateMaster");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		TemplateForm tempForm =(TemplateForm)form;
		HttpSession session=request.getSession();
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
		
		request.setAttribute("status",handler.addTemplate(tempForm, getDataSource(request)));
			   else
				   request.setAttribute("status", "You are not authorised to add");
			}
		return list(mapping, form, request, response);
	}
	
	public ActionForward changestatus(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		TemplateForm tempForm =(TemplateForm)form;
		tempForm.setTempId(Integer.parseInt(request.getParameter("tempId")));
		tempForm.setActive(Boolean.parseBoolean(request.getParameter("active")));
		 HttpSession session=request.getSession();
			if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		request.setAttribute("status",handler.changeTemp(tempForm, getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to change the status");	
			}
				return list(mapping, form, request, response);
	}
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		TemplateForm tempForm =(TemplateForm)form;
		HttpSession session=request.getSession();
	     if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		request.setAttribute("status",handler.updateTemp(tempForm, getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to update ");	
			}
				return list(mapping, form, request, response);
	}	
}
