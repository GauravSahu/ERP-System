package com.itech.iERP.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class PaymentTransacation extends BaseAction 
{
  public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  System.out.println("Payment page ");
	  return mapping.findForward("payment");
  }
  public ActionForward addPayment(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  System.out.println("inside add payment method");
	  return mapping.findForward("payment");
  }
}
