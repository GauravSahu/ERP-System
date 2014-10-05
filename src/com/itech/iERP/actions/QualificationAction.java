package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.QualificationForm;
import com.itech.iERP.handler.QualificationHandler;

public class QualificationAction extends BaseAction{
	QualificationHandler handler = new QualificationHandler();
	  public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the Contry master action");
		  List<QualificationForm> qualificationList = handler.list(getDataSource(request));
		  request.setAttribute("qualificationList",qualificationList);
		  System.out.println("CountryList "+qualificationList);
		  return mapping.findForward("qualification");
	  }
	  
	  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the add method");
		  QualificationForm qualificationform = (QualificationForm)form;
		  HttpSession session=request.getSession();
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
			   {
		  String status = handler.add(qualificationform,getDataSource(request));
		  request.setAttribute("result", status);
			   }
			   else
				   request.setAttribute("status", "You are not authorised to add");
			}
		  return list(mapping, form, request, response);
	  }
	  
	  public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  QualificationForm qualificationform = (QualificationForm)form;
		  qualificationform.setQualificationid(Integer.parseInt(request.getParameter("qualificationid").trim()));
		  qualificationform.setActive(Boolean.parseBoolean(request.getParameter("active")));
		  HttpSession session=request.getSession();
			if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		  request.setAttribute("status",handler.changeStatus(qualificationform,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to change the status");	
			}
				return list(mapping, form, request, response);
	  }
	  
	  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  QualificationForm qualificationform = (QualificationForm)form;
		  HttpSession session=request.getSession();
		     if(session.getAttribute("masterData")!=null)
				{
				   long access= (Long) session.getAttribute("masterData");
					if(access==1)
		  request.setAttribute("status", handler.update(qualificationform,getDataSource(request)));
					else
						request.setAttribute("status", "You are not authorised to update ");	
				}
					return list(mapping, form, request, response);
	  }
	}


