package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.itech.iERP.handler.CountryHandler;
import com.itech.iERP.handler.StateHandler;
import com.itech.iERP.forms.ContryForm;
import com.itech.iERP.forms.StateForm;
public class StateMasterAction extends BaseAction 
{  
	
   CountryHandler handler = new CountryHandler();
   StateHandler handler1 = new StateHandler();
   public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   try {
	   System.out.println("Inside state Master action method");
	   //Countrylist contains all the active countries
	   List<ContryForm> countryList = handler.active(getDataSource(request));
	   System.out.println("active country list "+countryList);
	   request.setAttribute("countryList", countryList);
       StateForm stateForm = (StateForm)form;
       System.out.println("Contry Id"+stateForm.getCountryid());
       List<StateForm> stateList = handler1.list(stateForm.getCountryid(),getDataSource(request));
	   System.out.println("StateList "+stateList);
       request.setAttribute("stateList", stateList);
       System.out.println("state Id "+stateForm.getStateid());
	   }
	   catch (Exception e) {
		e.printStackTrace();
	}
	   return mapping.findForward("state");
   }
   
   public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   try {
		
		   System.out.println("Inside the add method");
	   StateForm stateForm = (StateForm)form;
	   HttpSession session=request.getSession();
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
		
			  
	          request.setAttribute("status",handler1.addState(stateForm,getDataSource(request)));
			 
			   else
				   request.setAttribute("status", "You are not authorised to add");
			}
	   }
	   catch (Exception e) {
			e.printStackTrace();
		}
			
	   return list(mapping, form, request, response);
   }
   
   public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   StateForm stateForm = (StateForm)form;
	   stateForm.setStateid(Long.valueOf(request.getParameter("stateid")));
		stateForm.setCountryid(Long.valueOf(request.getParameter("countryid")));
		stateForm.setActive(Boolean.parseBoolean(request.getParameter("active")));
		HttpSession session=request.getSession();
		if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
		request.setAttribute("status", handler1.changeState(stateForm, getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to change the status");	
		}
			return list(mapping, form, request, response);
   }
   
   public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   StateForm stateForm = (StateForm)form;
	   HttpSession session=request.getSession();
	     if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
	   request.setAttribute("status",handler1.updateState(stateForm, getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to update ");	
			}
	   return list(mapping, form, request, response);
   }
   
   
   
}
