package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.CustomerForm;
import com.itech.iERP.handler.CustomerHandler;



public class CustomerMasterAction extends BaseAction{

	CustomerHandler handler = new CustomerHandler();
	
	 public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the Customer Master action");
		//  List<CustomerForm> userList = handler.userList(getDataSource(request));
		//  request.setAttribute("userList",userList);
		  CustomerForm customerForm = (CustomerForm) form;
		  List<CustomerForm> countryList = handler.countryList(getDataSource(request));
		  request.setAttribute("countryList",countryList);
		  
		  List<CustomerForm> stateList = handler.stateList(getDataSource(request),customerForm.getCountryid());
		  request.setAttribute("stateList",stateList);
		  
		  
		  List<CustomerForm> cityList = handler.cityList(getDataSource(request),customerForm.getStateid());
		  request.setAttribute("cityList",cityList);
		  
		  List<CustomerForm> customerList = handler.list(getDataSource(request));
		  request.setAttribute("customerList",customerList);
		  System.out.println("customerList "+customerList);
		  return mapping.findForward("customerMaster");
	  }
	  
	  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the add method");
		  CustomerForm customerForm = (CustomerForm)form;
		  HttpSession session=request.getSession();
		  
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
			   {
		    String status = handler.add(customerForm,getDataSource(request));
		    request.setAttribute("result", status);
			   }
		    else 
		    	 request.setAttribute("status", "You are not authorised to add");	
			   }
		  customerForm.setCustomername("");
		  customerForm.setCustomer_accno("");
		  customerForm.setAddress1("");
		  customerForm.setAddress2("");
		  customerForm.setCountryid(-1);
		  customerForm.setStateid(-1);
		  customerForm.setCityid(-1);
		  customerForm.setPhone1("");
		  customerForm.setPhone2("");
		  customerForm.setEmailid("");
		  customerForm.setZip("");
		  customerForm.setFax("");
		  
		  return list(mapping, form, request, response);
	  }
	  
	  public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  CustomerForm customerForm = (CustomerForm)form;
		  customerForm.setCustomerid(Integer.parseInt(request.getParameter("customerid").trim()));
		  customerForm.setActive(Boolean.parseBoolean(request.getParameter("active")));
		  HttpSession session=request.getSession();
			if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		  request.setAttribute("status",handler.changeStatus(customerForm,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to change the status");	
			}
				return list(mapping, form, request, response);
	  }
	  
	  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  CustomerForm customerForm = (CustomerForm)form;
		  HttpSession session=request.getSession();
		  
		     if(session.getAttribute("masterData")!=null)
				{
				   long access= (Long) session.getAttribute("masterData");
					if(access==1)
		  request.setAttribute("status", handler.updateCustomer(customerForm,getDataSource(request)));
					else
						request.setAttribute("status", "You are not authorised to update ");	
				}
		     customerForm.setCustomername("");
		     customerForm.setCustomer_accno("");
			  customerForm.setAddress1("");
			  customerForm.setAddress2("");
			  customerForm.setCountryid(-1);
			  customerForm.setStateid(-1);
			  customerForm.setCityid(-1);
			  customerForm.setPhone1("");
			  customerForm.setPhone2("");
			  customerForm.setEmailid("");
			  customerForm.setZip("");
			  customerForm.setFax("");
					return list(mapping, form, request, response);
	  }
}
