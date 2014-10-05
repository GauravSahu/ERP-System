package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.DesignationForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.RoleForm;
import com.itech.iERP.handler.DesignationHandler;

public class DesignationAction extends BaseAction
{
	DesignationHandler handler = new DesignationHandler();
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		List<DesignationForm> roleList=handler.list(compid,getDataSource(request));
		request.setAttribute("roleList",roleList);	
	    System.out.println("RoleList "+roleList);
		System.out.println("inside the list method");
		return mapping.findForward("desi");
	}	
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{ 
		try
		{
		DesignationForm roleForm =(DesignationForm)form;
		 HttpSession session=request.getSession();
		 
	       long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
	       //long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	        System.out.println("Current company id "+compid);
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
		       request.setAttribute("status",handler.addRole(roleForm,compid,getDataSource(request)));
			   else
			   request.setAttribute("status", "You are not authorised to add");	
			}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list(mapping, form, request, response);
	}
	
	public ActionForward changestatus(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		DesignationForm roleForm=(DesignationForm)form;
		roleForm.setDesid(Integer.parseInt(request.getParameter("desid").trim()));
		roleForm.setActive(Boolean.parseBoolean(request.getParameter("active").trim()));
		HttpSession session=request.getSession();
		if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
		request.setAttribute("status",handler.changeRole(roleForm, getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to change the status");	
		}
			return list(mapping, form, request, response);
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		DesignationForm roleForm=(DesignationForm)form;
		HttpSession session=request.getSession();
	     if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		request.setAttribute("status",handler.updateRole(roleForm, getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to update ");	
			}
				return list(mapping, form, request, response);
	}	
}
            