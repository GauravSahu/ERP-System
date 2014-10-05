package com.itech.iERP.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BaseAction extends DispatchAction
{
	protected ActionForward dispatchMethod(ActionMapping arg0,ActionForm arg1,HttpServletRequest arg2,HttpServletResponse arg3,String arg4) throws Exception
	  {
		  try
		  {
			  super.getMethod(arg4);
		  }
		  catch (Exception e) {
			// TODO: handle exception
			  arg4="list";
		}
		  return super.dispatchMethod(arg0, arg1, arg2, arg3, arg4);
	  }
}
