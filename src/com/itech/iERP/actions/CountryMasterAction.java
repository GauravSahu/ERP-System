package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.ContryForm;
import com.itech.iERP.handler.CountryHandler;

public class CountryMasterAction extends BaseAction 
{
	CountryHandler handler = new CountryHandler();
  public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  System.out.println("Inside the Contry master action");
	  List<ContryForm> countryList = handler.list(getDataSource(request));
	  request.setAttribute("countryList",countryList);
	  System.out.println("CountryList "+countryList);
	  String filePath = 
          getServlet().getServletContext().getRealPath("/")+"downloadxls";
		 System.out.println("filePath--------->>>>>>>"+filePath);
		boolean result=handler.excelexport(getDataSource(request),filePath);
		System.out.println("result->"+result);
	  return mapping.findForward("country");
  }
  
  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  System.out.println("Inside the add method");
	  String status=null;
	  ContryForm countryForm = (ContryForm)form;
	  HttpSession session=request.getSession();
	   if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
		   if(access==1)
		   {
	        status = handler.add(countryForm,getDataSource(request));
	        request.setAttribute("status", status);
		   }
	     else 
	    	 request.setAttribute("status", "You are not authorised to add");	
		}
	  System.out.println("result "+status);
	  return list(mapping, form, request, response);
  }
  
  public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  ContryForm countryForm = (ContryForm)form;
	  countryForm.setCountryid(Integer.parseInt(request.getParameter("countryid").trim()));
	  countryForm.setActive(Boolean.parseBoolean(request.getParameter("active")));
	  HttpSession session=request.getSession();
		if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
	  request.setAttribute("status",handler.changeStatus(countryForm,getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to change the status");	
		}
	  return list(mapping, form, request, response);
  }
  
  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  ContryForm countryForm = (ContryForm)form;
	  HttpSession session=request.getSession();
	     if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
      request.setAttribute("status", handler.updateCountry(countryForm,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to update ");	
			}
				return list(mapping, form, request, response);
  }
}
