package com.itech.iERP.actions;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.bsf.util.event.adapters.java_awt_event_ActionAdapter;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.AttendanceModuleForm;
import com.itech.iERP.forms.LeaveModuleForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.UserForm;
import com.itech.iERP.handler.AttendanceModuleHandler;
import com.itech.iERP.handler.UserHandler;

public class AttendanceModuleAction extends BaseAction
{
   AttendanceModuleHandler handler = new AttendanceModuleHandler();
   UserHandler handler1 = new UserHandler();
   
   public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
			{
	           
	            HttpSession session = request.getSession();
	    		long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	    		long roleid = ((LoginForm) session.getAttribute("userDetail")).getRole();
	    		long compid=((LoginForm)session.getAttribute("userDetail")).getCompany();
	    		System.out.println("user id "+userid);
	    		System.out.println("role id "+roleid);
	    		System.out.println("comapny id "+compid);
	    		AttendanceModuleForm attmodform = (AttendanceModuleForm)form;
	    		request.setAttribute("status",handler.addAtte(attmodform,userid,compid,getDataSource(request)));
	    		//System.out.println(" Result "+handler.addAtte(attmodform,userid,compid,getDataSource(request)));
	    		System.out.println("Cut off "+attmodform.getAttLateCutOffTime());
	    		//request.setAttribute("status", "added successfully");	
	    		
	            return mapping.findForward("attmod");
            }
   public ActionForward login1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
			{
	   AttendanceModuleForm attmodform = (AttendanceModuleForm)form;
	   String s = request.getParameter("reason");
	   System.out.println(s);
	   System.out.println("reason  "+attmodform.getReason());
	   HttpSession session = request.getSession();
		long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
		//long roleid = ((LoginForm) session.getAttribute("userDetail")).getRole();
		long compid=((LoginForm)session.getAttribute("userDetail")).getCompany();
		request.setAttribute("status",handler.addAtte1(attmodform,s,userid,compid,getDataSource(request)));
	   return mapping.findForward("attmod");
			}
   public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
			{
	         AttendanceModuleForm attmodform = (AttendanceModuleForm)form;
	         HttpSession session = request.getSession();
	         long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	         long compid=((LoginForm)session.getAttribute("userDetail")).getCompany();
	        // String signin = handler.addLogout(attmodform,userid,compid,getDataSource(request));
	         request.setAttribute("status",handler.addLogout(attmodform,userid,compid,getDataSource(request)));
	         return mapping.findForward("attmod");
			}
   public ActionForward reports(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
			{
	            //AttendanceModuleForm attmodform = (AttendanceModuleForm)form; 
	            System.out.println("Reports module");
	            List<AttendanceModuleForm> userList = handler.listEmp(getDataSource(request));
	      	   request.setAttribute("userList",userList);
	      	   System.out.println(userList);
	      	   List<AttendanceModuleForm> userList1 = handler.listEmp1(getDataSource(request));
	     	   request.setAttribute("userList1",userList1);
	     	   System.out.println(userList1);
	            return mapping.findForward("reports");
            }
   
   public ActionForward AttrReports(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
			{
	   Timestamp ftimets = null;
		Timestamp ttimets = null;
	   AttendanceModuleForm attmodform = (AttendanceModuleForm)form; 
	   List<AttendanceModuleForm> userList = handler.listEmp(getDataSource(request));
 	   request.setAttribute("userList",userList);
 	   System.out.println(userList);
 	   List<AttendanceModuleForm> userList1 = handler.listEmp1(getDataSource(request));
	   request.setAttribute("userList1",userList1);
	   
	 
	   if(!request.getParameter("fDate").equals("")&& !request.getParameter("tDate").equals(""))
	   {
		   String ftime = request.getParameter("fDate").trim();
		   System.out.println("Before Timestamp "+ftime);
		   DateFormat fformatter = new SimpleDateFormat("dd/MM/yyyy");
		   java.util.Date fdate = (java.util.Date) fformatter.parse(ftime);
		   ftimets = new Timestamp(fdate.getTime());
		   
		   String ttime = request.getParameter("tDate").trim();
		   System.out.println("Before timestamp "+ttime);
		   DateFormat tformatter = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date tdate = (java.util.Date) tformatter.parse(ttime);
			ttimets = new Timestamp(tdate.getTime());
            System.out.println(attmodform.getUsername());
			System.out.println("datetimes=" + ftimets);
			System.out.println("datetimes1=" + ttimets);
			List<AttendanceModuleForm> AttList = handler.listAttList(ftimets,ttimets,attmodform,getDataSource(request));
			request.setAttribute("AttList",AttList);
			System.out.println("AttList "+AttList);
	   }
	   else
	   {
		   HttpSession session = request.getSession();
		   long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
		   String name = handler.name(getDataSource(request),userid);
		   System.out.println("name "+name);
		   List<AttendanceModuleForm> AttList = handler.listLeaveList1(attmodform,name,getDataSource(request));
		   request.setAttribute("AttList",AttList);
		   System.out.println("AttList1 "+AttList);
	   }
	   return mapping.findForward("reports");
	}
  
}
