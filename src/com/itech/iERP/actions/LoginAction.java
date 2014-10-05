package com.itech.iERP.actions;

/*
 * author vani
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cete.dynamicpdf.text.l;
import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.daoimpl.PrevilegeDaoImpl;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.PrevilegeForm;

import com.itech.iERP.handler.LoginHandler;
import com.itech.iERP.handler.PageHandler;

/*
 * This class check the user name and password entered by the user.
 * if it matches then he can access the application or software
 */
public class LoginAction extends BaseAction {
	
	LoginHandler loghandler = new LoginHandler();
	PageHandler paghandler = new PageHandler();
 
	/*
	 * It gives an option to enter user name and password.
	 */
	public ActionForward home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward(paghandler.page(iERPConstants.HOME_PAGE,
				getDataSource(request)));
	}

	/*
	 * Checks the username and password entered by the user with the existing
	 * one which is present in database.
	 */
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
			{
		try{
		LoginForm loginform = (LoginForm) form;
		String username = loginform.getUsername();
		String password = loginform.getPassword();
		LoginForm userDetail = loghandler.loginValidation(username, password,getDataSource(request));
		HttpSession session = request.getSession();
		session.setAttribute("userDetail", userDetail);
		session.setAttribute("userName", loginform.getUsername());
		session.setAttribute("logo", userDetail.getCompany());
		session.setAttribute("userid  ",loginform.getUserId());
		//session.setAttribute("compid",loginform.getCompid());
		int i = userDetail.getCompany();
		String img = userDetail.getCompanylogo();
        System.out.println("Blank "+userDetail);
        long role = userDetail.getRole();
        System.out.println("role "+role);
        Long masterData=0l;
		
		if (userDetail != null) 
		{
			if (userDetail.getRole() == 1)
			{
				
				session.setAttribute("username", userDetail.getUsername());
				long roleId=userDetail.getRole();
				System.out.println("roleid "+roleId);
				List<PrevilegeForm> previlegeDetail=PrevilegeDaoImpl.listAllRoleFn(roleId,getDataSource(request));
				System.out.println("Previleg detail "+previlegeDetail);
				for(PrevilegeForm pform: previlegeDetail)
				{
					if(pform.getFunctionId()==1)
					
						System.out.println(" Accees codse "+pform.getAccess());
						masterData=pform.getAccess();
				}
				System.out.println("Master data value "+masterData);
				session.setAttribute("masterData", masterData);
				return mapping.findForward(paghandler.page(
						iERPConstants.ADMIN_PAGE, getDataSource(request)));
			} 
			else if (userDetail.getRole() == 2) 
			{
				session.setAttribute("username", userDetail.getUsername());
				return mapping.findForward(paghandler.page(
						iERPConstants.ADMIN_PAGE, getDataSource(request)));
			}
			else if (userDetail.getRole() == 3) 
			{
				session.setAttribute("username", userDetail.getUsername());
				return mapping.findForward(paghandler.page(
						iERPConstants.ADMIN_PAGE, getDataSource(request)));
			}
		
		 else 
		 {
//			System.out.println("Fail");
//			String failure = "Username or password is invalid";
//			request.setAttribute("loginfailure", failure);
			return mapping.findForward(paghandler.page(iERPConstants.HOME_PAGE,
					getDataSource(request)));
		}
	
		}
		else
		{
			System.out.println("Fail");
			String failure = "Username or password is invalid";
			request.setAttribute("loginfailure", failure);
			return mapping.findForward(paghandler.page(iERPConstants.HOME_PAGE,
					getDataSource(request)));
		}
		}catch (NullPointerException e) 
		{
			e.printStackTrace();
			String failure = "Username or password is invalid";
			request.setAttribute("loginfailure", failure);
			return mapping.findForward(paghandler.page(iERPConstants.HOME_PAGE,
					getDataSource(request)));
			// TODO: handle exception
		}
		
	}
	public ActionForward home1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	{
		
		LoginForm loginform = (LoginForm) form; 
		String userName = loginform.getScode();
	    
		System.out.println(userName);
		LoginForm userDetail1 = loghandler.scode1(userName,getDataSource(request));
		System.out.println("userdetail1 "+userDetail1);
		
		if(userDetail1 != null)
		{
			if(userDetail1.getScodeId() == 1)
			{
				return mapping.findForward("payroll");
			}
			else if(userDetail1.getScodeId() == 2)
			{
				return mapping.findForward("inventory");
			}
			else if(userDetail1.getScodeId() == 3)
			{
				return mapping.findForward("accounting");
			}
			else if(userDetail1.getScodeId() == 4)
			{
				return mapping.findForward("settings");
			}
			else if(userDetail1.getScodeId() == 5)
			{
				return mapping.findForward("sales");
			}
			else if(userDetail1.getScodeId() == 6)
			{
				return mapping.findForward("reports");
			}
			else if(userDetail1.getScodeId() == 7)
			{
				return mapping.findForward("masterdata");
			}
			else
			{
				return mapping.findForward(paghandler.page(iERPConstants.HOME_PAGE,
						getDataSource(request)));
			}
		}
		else
		{
			return mapping.findForward(paghandler.page(
					iERPConstants.ADMIN_PAGE, getDataSource(request)));
		}
		
	}

	

}
