package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.AttendanceStatusForm;
import com.itech.iERP.forms.CalenderTypeForm;
import com.itech.iERP.handler.CalenderTypeHandler;

public class CalendarDayTypeAction extends BaseAction
{
	CalenderTypeHandler handler = new CalenderTypeHandler();
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	   System.out.println("Inside the list method of attendance status");
	   List<CalenderTypeForm> cstatusList = handler.list(getDataSource(request));
	   request.setAttribute("cstatusList",cstatusList);
	   System.out.println("calender status List "+cstatusList);
	   return mapping.findForward("Calender");
	}
   public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	   CalenderTypeForm astatusform = (CalenderTypeForm)form;
	   HttpSession session=request.getSession();
	   if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
		   if(access==1)
	       request.setAttribute("status",handler.addAttendance(astatusform, getDataSource(request)));
		   else
			   request.setAttribute("status", "You are not authorised to add");	
		}
	   return list(mapping, form, request, response);
	}
   public ActionForward changestatus(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	   CalenderTypeForm astatusform = (CalenderTypeForm)form;
	   astatusform.setCalendertypeId(Integer.parseInt(request.getParameter("calendertypeId")));
       astatusform.setActive(Boolean.parseBoolean(request.getParameter("active")));
       HttpSession session=request.getSession();
       if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
		request.setAttribute("status",handler.changeRole(astatusform, getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to change the status");	
		}
	   return list(mapping, form, request, response);
	}
   public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{

	   CalenderTypeForm astatusform = (CalenderTypeForm)form;
	   HttpSession session=request.getSession();
       if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
		request.setAttribute("status",handler.updateRole(astatusform, getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to update ");	
		}
		return list(mapping, form, request, response);
	}	
}
