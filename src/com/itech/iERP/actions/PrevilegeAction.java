package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.daoimpl.PrevilegeDaoImpl;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.PrevilegeForm;

public class PrevilegeAction extends BaseAction
{
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		List<PrevilegeForm> previlegeList = PrevilegeDaoImpl.listAll(getDataSource(request));
		request.setAttribute("previlegeList",previlegeList);
		HttpSession session = request.getSession();
		Long test = ((LoginForm) session.getAttribute("userDetail")).getUserId();		
		if (test!=null) {
			return mapping.findForward("home");
		} else
			return mapping.findForward("session");	
				
	    }
	
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{ 
		PrevilegeForm pForm=(PrevilegeForm)form;
		String[] admin=pForm.getAdmin();
		boolean result1=PrevilegeDaoImpl.updateAccess(admin, 1l, getDataSource(request));
		if(result1 )		
		{
			request.setAttribute("msg", "Updated Successfully");
		}
		return list(mapping,form,request, response);
	}
	
}
