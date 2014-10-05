package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.itech.iERP.forms.SalaryForm;
import com.itech.iERP.handler.SalaryHandler;



public class SalaryComponentMaster extends BaseAction 
{
	SalaryHandler handler = new SalaryHandler();
	public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	 {
		System.out.println("Inside the salary component master");
		List<SalaryForm> salaryList = handler.list(getDataSource(request));
		request.setAttribute("salaryList",salaryList);
		System.out.println("salaryList "+salaryList);
		return mapping.findForward("salary");
	 }
	
	public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		System.out.println("Inside the add method of salary component master");
		SalaryForm salaryForm = (SalaryForm)form;
		 HttpSession session=request.getSession();
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
			   {
		String status = handler.add(salaryForm,getDataSource(request));
		 request.setAttribute("status", status);
			   }
			   else
				   request.setAttribute("status", "You are not authorised to add");
			}
	
		
		return list(mapping, form, request, response);
	  }
	
	public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		System.out.println("inside the change status of salary component");
		SalaryForm salaryForm = (SalaryForm)form;
		salaryForm.setSalaryId(Integer.parseInt(request.getParameter("salaryId").trim()));
		///salaryForm.setSalaryId(Long.parseLong(request.getParameter("salaryId")));
		//salaryForm.setActive(Boolean.parseBoolean(request.getParameter("active")));
		int i = Integer.parseInt(request.getParameter("salaryId"));
		System.out.println("i value "+i);
		HttpSession session=request.getSession();
		if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
		request.setAttribute("status",handler.changeStatus(salaryForm,getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to change the status");	
		}
			return list(mapping, form, request, response);
	  }
	
	public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		SalaryForm salaryForm = (SalaryForm)form;
		System.out.println("Inside the update method of salary");
		salaryForm.setSalaryId(Integer.parseInt(request.getParameter("salaryId").trim()));
		 HttpSession session=request.getSession();
	     if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		request.setAttribute("status", handler.updateCountry(salaryForm,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to update ");	
			}
				return list(mapping, form, request, response);
	  }
}
