package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.ContryForm;
import com.itech.iERP.forms.LeavetypeForm;
import com.itech.iERP.handler.LeavetypeHandler;

public class LeavetypeAction extends BaseAction{

	LeavetypeHandler handler = new LeavetypeHandler();
	
	 public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the LeaveType Master action");
		  List<LeavetypeForm> leavetypeList = handler.list(getDataSource(request));
		  request.setAttribute("leavetypeList",leavetypeList);
		  System.out.println("leavetypeList "+leavetypeList);
		  return mapping.findForward("leaveType");
	  }
	  
	  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the add method");
		  LeavetypeForm leavetypeForm = (LeavetypeForm)form;
		  HttpSession session=request.getSession();
		 
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
			   {
		  String status = handler.add(leavetypeForm,getDataSource(request));
		  request.setAttribute("result", status);
			   }
			   else
				   request.setAttribute("status", "You are not authorised to add");
			}
		  leavetypeForm.setLeavename("");
		  return list(mapping, form, request, response);
	  }
	  
	  public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  LeavetypeForm leavetypeForm = (LeavetypeForm)form;
		  leavetypeForm.setLeavetypeid(Integer.parseInt(request.getParameter("leavetypeid").trim()));
		  leavetypeForm.setActive(Boolean.parseBoolean(request.getParameter("active")));
		  HttpSession session=request.getSession();
			if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		  request.setAttribute("status",handler.changeStatus(leavetypeForm,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to change the status");	
			}
				return list(mapping, form, request, response);
	  }
	  
	  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  LeavetypeForm leavetypeForm = (LeavetypeForm)form;
		  HttpSession session=request.getSession();
		 
		     if(session.getAttribute("masterData")!=null)
				{
				   long access= (Long) session.getAttribute("masterData");
					if(access==1)
		  request.setAttribute("status", handler.updateLeavetype(leavetypeForm,getDataSource(request)));
					else
						request.setAttribute("status", "You are not authorised to update ");	
				}
		     leavetypeForm.setLeavename("");
					return list(mapping, form, request, response);
	  }
}
