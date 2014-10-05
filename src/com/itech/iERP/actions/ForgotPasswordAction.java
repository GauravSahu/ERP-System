package com.itech.iERP.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.itech.iERP.forms.ForgotPasswordForm;
import com.itech.iERP.handler.ForgotPasswordHandler;
import  com.itech.iERP.utils.*;
public class ForgotPasswordAction extends DispatchAction
{
	ForgotPasswordHandler handler = new ForgotPasswordHandler();
	
	
	public ActionForward sendmail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("Inside the send mail method ");	
		ForgotPasswordForm forgotPasswordForm = (ForgotPasswordForm) form;
		String result = handler.forgotPassword(forgotPasswordForm, getDataSource(request));
		System.out.println(result);
		if(result != null)
		{
			String email = forgotPasswordForm.getEmail();
			String toAddress="vani@itechsolutions.in";
			try
			{
			   String subject = "Password Recovery Mail";
			   String message = "Hi, this mail from iERp: "+result;
			   try
			   {
				   FuctionMailClass mailClient = new FuctionMailClass();
				   mailClient.postMail(new String[] { email }, subject, message,
							toAddress);
			   }
			   catch (Exception e)
			   {
				 System.out.println(e);			
			   }
			   }
			catch (Exception e) 
			{
				System.out.println(e);
			}
			request.setAttribute("success", "Please check your mail");
			return mapping.findForward("forgotpassword");
		}
		System.out.println("Fail");
		String failure="Please enter correct email id";
		request.setAttribute("loginfailure", failure);
	return mapping.findForward("forgotpassword");
	}
	
	  
}
