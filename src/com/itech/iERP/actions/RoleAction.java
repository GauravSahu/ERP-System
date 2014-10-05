package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.RoleForm;
import com.itech.iERP.handler.RoleHandler;

public class RoleAction extends BaseAction
{
	RoleHandler handler = new RoleHandler();
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{   
		HttpSession session = request.getSession();
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		System.out.println("company id in list method "+compid);
		List<RoleForm> roleList=handler.list(compid,getDataSource(request));
		request.setAttribute("roleList",roleList);	
		return mapping.findForward("role");
	}	
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		RoleForm roleForm =(RoleForm)form;
		 HttpSession session=request.getSession();
		// long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		 long compid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		 System.out.println("company Id "+compid);
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
		 request.setAttribute("status",handler.addRole(roleForm,compid,getDataSource(request)));
			   else
				   request.setAttribute("status", "You are not authorised to add");
			}
		return list(mapping, form, request, response);
	}
	
	public ActionForward changestatus(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		RoleForm roleForm=(RoleForm)form;
		roleForm.setRoleid(Integer.parseInt(request.getParameter("roleid")));
		roleForm.setActive(Boolean.parseBoolean(request.getParameter("active")));
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

		RoleForm roleForm=(RoleForm)form;
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
