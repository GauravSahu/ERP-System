package com.itech.iERP.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.UserForm;
import com.itech.iERP.handler.UserHandler;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class UserMasterAction extends BaseAction{

	UserHandler handler = new UserHandler();
	
	 public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the User Master action");
		  HttpSession session = request.getSession();
		  long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		  List<UserForm> roleList = handler.roleList(compid,getDataSource(request));
		  request.setAttribute("roleList",roleList);
//		  List<UserForm> companyList = handler.companyList(getDataSource(request));
//		  request.setAttribute("companyList",companyList);
		  List<UserForm> approveList = handler.ApproveList(compid,getDataSource(request));
		  request.setAttribute("approveList",approveList);
		  System.out.println("Approve "+approveList);
		 
		  List<UserForm> desilist = handler.desiList(compid,getDataSource(request));
		  System.out.println(desilist);
		  request.setAttribute("desilist",desilist);
		  
		  List<UserForm> banklist = handler.banklist(compid,getDataSource(request));
		  System.out.println(banklist);
		  request.setAttribute("banklist",banklist);
 		  
		  List<UserForm> userList = handler.list(compid,getDataSource(request));
		  request.setAttribute("userList",userList);
		  
		  System.out.println("userList "+userList);
		  
		  return mapping.findForward("userMaster");
	  }
	  
	  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  Timestamp dob = null;
		  Timestamp doj = null;
		  UserForm userForm = (UserForm)form;
		  HttpSession session=request.getSession();
		  long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		  
          String ftime = request.getParameter("myDate").trim();
          DateFormat fformatter = new SimpleDateFormat("dd/MM/yyyy");
          java.util.Date fdate = (java.util.Date) fformatter.parse(ftime);
          dob = new Timestamp(fdate.getTime());
          System.out.println("dob "+dob);
          
          String ttime = request.getParameter("doj").trim();
          fformatter = new SimpleDateFormat("dd/MM/yyyy");
          java.util.Date tdate = (java.util.Date) fformatter.parse(ttime);
          doj = new Timestamp(tdate.getTime());
          System.out.println("doj "+doj);
          
          System.out.println("design id "+userForm.getDesiid());
		  
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
			   {
		  String status = handler.add(compid,dob,doj,userForm,getDataSource(request));
		  request.setAttribute("result", status);
		  System.out.println("syso "+status);
			 
			   }
			   else
				   request.setAttribute("status", "You are not authorised to add");  
			}

		  userForm.setUsername("");
		  userForm.setPassword("");
		  userForm.setFirstname("");
		  userForm.setLastname("");
		  userForm.setPhone1("");
		  userForm.setPhone2("");
		  userForm.setEmailid("");
		  userForm.setSsn("");
		  userForm.setRoleid(-1);
		  userForm.setCompanyid(-1);
		  return list(mapping, form, request, response);
	  }
	  
	  public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  UserForm userForm = (UserForm)form;
		  userForm.setUserid(Integer.parseInt(request.getParameter("userid").trim()));
		  userForm.setActive(Boolean.parseBoolean(request.getParameter("active")));
		  HttpSession session=request.getSession();
			if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		  request.setAttribute("status",handler.changeStatus(userForm,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to change the status");	
			}
         return list(mapping, form, request, response);
	  }
	  
	  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  UserForm userForm = (UserForm)form;
		  HttpSession session=request.getSession();
		  
		     if(session.getAttribute("masterData")!=null)
				{
				   long access= (Long) session.getAttribute("masterData");
					if(access==1)
		  request.setAttribute("status", handler.updateUser(userForm,getDataSource(request)));
					else
						request.setAttribute("status", "You are not authorised to update ");	
				}
		     userForm.setUsername("");
			  userForm.setPassword("");
			  userForm.setFirstname("");
			  userForm.setLastname("");
			  userForm.setPhone1("");
			  userForm.setPhone2("");
			  userForm.setEmailid("");
			  userForm.setSsn("");
			  userForm.setRoleid(-1);
			  userForm.setCompanyid(-1);
					return list(mapping, form, request, response);
	  }
}