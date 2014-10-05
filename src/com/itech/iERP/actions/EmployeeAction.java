package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.BankForm;
import com.itech.iERP.forms.DesignationForm;
import com.itech.iERP.forms.EmployeeForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.QualificationForm;
import com.itech.iERP.forms.VendorMasterForm;
import com.itech.iERP.handler.BankHandler;
import com.itech.iERP.handler.DesignationHandler;
import com.itech.iERP.handler.EmployeeHandler;
import com.itech.iERP.handler.QualificationHandler;

public class EmployeeAction extends BaseAction
{
	EmployeeHandler handler = new EmployeeHandler();
	BankHandler handler1= new BankHandler();
	QualificationHandler handler2 = new QualificationHandler();
	DesignationHandler handler3 = new DesignationHandler();
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
			{
		HttpSession session = request.getSession();
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		       System.out.println("Inside the Employee action list method");
		       List<EmployeeForm> employeeList = handler.listAll(getDataSource(request));
		       request.setAttribute("employeeList",employeeList);
		       System.out.println("Employee list "+employeeList);
		       List<BankForm> roleList=handler1.list(compid,getDataSource(request));
			   request.setAttribute("roleList",roleList);	
			   List<QualificationForm> qualificationList = handler2.list(getDataSource(request));
				  request.setAttribute("qualificationList",qualificationList);
				  List<DesignationForm> roleList1=handler3.list(compid,getDataSource(request));
					request.setAttribute("roleList1",roleList1);	
		       return mapping.findForward("employee");             
			}
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		EmployeeForm employeeForm = (EmployeeForm)form;
		 HttpSession session=request.getSession();
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
		request.setAttribute("status",handler.addRole(employeeForm, getDataSource(request)));
			   else
				   request.setAttribute("status", "You are not authorised to add");
			}
		System.out.println("Inside the add method");
		System.out.println("first name "+employeeForm.getDayOfJoining());
	
		
		return list(mapping, form, request, response);
	}
	public ActionForward changestatus(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		EmployeeForm employeeForm = (EmployeeForm)form;
		employeeForm.setEmpNo(Integer.parseInt(request.getParameter("empNo").trim()));
		employeeForm.setActive(Boolean.parseBoolean(request.getParameter("active").trim()));
		HttpSession session=request.getSession();
		if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
		request.setAttribute("status",handler.changeRole(employeeForm, getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to change the status");	
		}
			return list(mapping, form, request, response);
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception 
			{
		
		EmployeeForm employeeForm = (EmployeeForm)form;
		System.out.println("Inside the update methodemplotee");
		HttpSession session=request.getSession();
	     if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		request.setAttribute("status", handler.update(employeeForm,
				getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to update ");	
			}
		//vform.setVendorid(-1);
		return list(mapping, form, request, response);
	}
}
