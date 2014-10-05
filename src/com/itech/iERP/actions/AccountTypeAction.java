package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.AccountMasterForm;
import com.itech.iERP.handler.AccountMasterHandler;

public class AccountTypeAction extends BaseAction
{
  /*
   * BaseAction is the user defined class. which extends the dispatchaction and calls the list method by default
   */
	AccountMasterHandler handler = new AccountMasterHandler();
	
	/* retrieve all the account type from database and store it in list */
	public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		//long compid = 
		List<AccountMasterForm> accountmastertype = handler.list(getDataSource(request));
		request.setAttribute("accounttype",accountmastertype);
		System.out.println("account master "+accountmastertype);
		return mapping.findForward("accounttype");
	}
	public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		AccountMasterForm accountmaster = (AccountMasterForm)form;
		request.setAttribute("status",handler.addaccounts(accountmaster,getDataSource(request)));
		return list(mapping, form, request, response);
	}
	public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("inside the changestatus method");
		AccountMasterForm accountmaster = (AccountMasterForm)form;
		accountmaster.setAccountno((request.getParameter("accountno")));
		String i = request.getParameter("accountno");
		String b = request.getParameter("active");
		System.out.println("values are "+i +"and "+b);
		accountmaster.setActive(Boolean.parseBoolean(request.getParameter("active")));
		request.setAttribute("status",handler.changestatus(accountmaster,getDataSource(request)));
		return list(mapping, form, request, response);
	}
}