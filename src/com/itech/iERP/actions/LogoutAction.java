package com.itech.iERP.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.itech.iERP.handler.PageHandler;
import com.itech.iERP.constants.iERPConstants;

public class LogoutAction extends Action
{
	PageHandler paghandler = new PageHandler();
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		try{
			
		Object o=session.getAttribute("userName").toString();
		
		
		if(o!=null){
			
			session.removeAttribute("userName");
			session.invalidate();
			
			return mapping.findForward(paghandler.page(iERPConstants.HOME_PAGE, getDataSource(request)));
		}else{
			
			
			return mapping.findForward(paghandler.page(iERPConstants.HOME_PAGE, getDataSource(request)));
		}
		
	
		}
		catch (NullPointerException e)
		{
			return mapping.findForward(paghandler.page(iERPConstants.HOME_PAGE, getDataSource(request)));
		}
		
	}
}
