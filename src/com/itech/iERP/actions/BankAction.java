package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cete.dynamicpdf.imaging.tiff.c;
import com.itech.iERP.forms.BankForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.handler.BankHandler;



public class BankAction extends BaseAction 
{
	BankHandler handler = new BankHandler();
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		try
		{
		HttpSession session = request.getSession();
		//long compid = 33;
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		System.out.println("inside bank ation "+compid);
		List<BankForm> roleList=handler.list(compid,getDataSource(request));
		request.setAttribute("roleList",roleList);	
	    System.out.println("RoleList "+roleList);
		System.out.println("inside the list method");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return mapping.findForward("bank");
	}	
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		BankForm roleForm =(BankForm)form;
		HttpSession session=request.getSession();
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		if(session.getAttribute("masterData")!=null)
		{
			long access= (Long) session.getAttribute("masterData");
			if(access==1)
				request.setAttribute("status",handler.addRole(compid,roleForm, getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to add");
		}
		
		return list(mapping, form, request, response);
	}
	
	public ActionForward changestatus(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		BankForm roleForm=(BankForm)form;
		HttpSession session=request.getSession();
		roleForm.setBankId(Integer.parseInt(request.getParameter("bankId").trim()));
		roleForm.setActive(Boolean.parseBoolean(request.getParameter("active").trim()));
	       if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		request.setAttribute("status",handler.changeRole(roleForm, getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to change the status");	
			}
		return list(mapping, form, request, response);
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		BankForm roleForm=(BankForm)form;
		 HttpSession session=request.getSession();
	       if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		request.setAttribute("status",handler.updateRole(roleForm, getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to update ");	
			}
		return list(mapping, form, request, response);
	}	
}
