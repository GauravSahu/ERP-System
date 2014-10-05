package com.itech.iERP.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.itech.iERP.forms.ComponentTypeMasterForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.handler.ComponentHandler;

public class ComponentAction extends BaseAction
{ 
  ComponentHandler handler = new ComponentHandler();
  public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	  System.out.println("Inside the component action");
	  
		HttpSession session=request.getSession();
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();

      System.out.println("Compid "+compid);
	  List<ComponentTypeMasterForm> componentList = handler.list(getDataSource(request),compid);
	  request.setAttribute("componentList",componentList);	
	  System.out.println("CompList "+componentList);
	  return mapping.findForward("component");
	}
  
  public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	  ComponentTypeMasterForm roleForm =(ComponentTypeMasterForm)form;
		HttpSession session=request.getSession();
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		if(session.getAttribute("masterData")!=null)
		{
			long access= (Long) session.getAttribute("masterData");
			if(access==1)
				request.setAttribute("status",handler.addRole(roleForm,compid, getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to add");
		}
	
		return list(mapping, form, request, response);
	}
  public ActionForward changestatus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	  System.out.println("Inside the changestatus method");
	  ComponentTypeMasterForm roleForm =(ComponentTypeMasterForm)form;
		HttpSession session=request.getSession();
		roleForm.setComponentId(Integer.parseInt(request.getParameter("componentId").trim()));
		roleForm.setActive(Boolean.parseBoolean(request.getParameter("active").trim()));
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

	  ComponentTypeMasterForm roleForm =(ComponentTypeMasterForm)form;
		 HttpSession session=request.getSession();
		 long userid = ((LoginForm) session.getAttribute("userDetail")).getCompany();
	       if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		request.setAttribute("status",handler.updateRole(roleForm, userid,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to update ");	
			}
		return list(mapping, form, request, response);
	}	
  
}
