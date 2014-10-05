package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.ExpenseTypeMasterForm;
import com.itech.iERP.forms.RoleForm;
import com.itech.iERP.handler.ExpenseTypeHandler;

public class ExpenseTypeMaster extends BaseAction
{
  ExpenseTypeHandler handler = new ExpenseTypeHandler();
  public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  System.out.println("Inside the list method");
	  List<ExpenseTypeMasterForm> expenseList = handler.list(getDataSource(request));
	  request.setAttribute("expenseList", expenseList);
	  System.out.println(expenseList);
	  return mapping.findForward("home");
  }
  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  ExpenseTypeMasterForm expense = new ExpenseTypeMasterForm();
	  System.out.println("Inside the add method");
	  System.out.println(expense.getExpensename());
	  String l = request.getParameter("expensename");
	  System.out.println("L value "+l);
	  HttpSession session=request.getSession();
	  if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
		   System.out.println("access value "+access);
		   if(access==1)
			   request.setAttribute("status",handler.addRole(l,expense, getDataSource(request)));
		   else
			   request.setAttribute("status", "You are not authorised to add");
		}
	  return list(mapping, form, request, response);
  }
  
  public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  System.out.println("Inside the change status method");
	  ExpenseTypeMasterForm expense = new ExpenseTypeMasterForm();
	  HttpSession session = request.getSession();
	  expense.setExpenseId(Integer.parseInt(request.getParameter("expenseId").trim()));
	  expense.setActive(Boolean.parseBoolean(request.getParameter("active").trim()));
	  if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
	request.setAttribute("status",handler.changestatus(expense, getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to change the status");	
		}
	  return list(mapping, form, request, response);
  }
  
  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  ExpenseTypeMasterForm expense = new ExpenseTypeMasterForm();
	  HttpSession session = request.getSession();
	  String r = request.getParameter("expensename");
	  expense.setExpenseId(Integer.parseInt(request.getParameter("expenseId").trim()));
	  System.out.println("r value "+r);
      if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
	request.setAttribute("status",handler.updatexpense(r,expense,getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to update ");	
		}
	  return list(mapping, form, request, response);
  }
  
}
