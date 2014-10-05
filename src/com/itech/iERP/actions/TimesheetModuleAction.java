package com.itech.iERP.actions;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.LeaveModuleForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.TimesheetModuleForm;
import com.itech.iERP.handler.TimesheetModuleHandler;

public class TimesheetModuleAction extends BaseAction
{
	TimesheetModuleHandler handler = new TimesheetModuleHandler();
	public ActionForward timeSheet(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
			{
		       TimesheetModuleForm timesheet = (TimesheetModuleForm)form;
		       HttpSession session = request.getSession();
		        long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
		       System.out.println("Task List "+timesheet.getTimesheet());
		       System.out.println("inside the timesheet method ");
		       request.setAttribute("status",handler.addtimesheet(timesheet,userid,getDataSource(request)));
		       return mapping.findForward("timesheet");
			}
	
	public ActionForward reports(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
			{
		        System.out.println("Inside the reports module");
		        List<TimesheetModuleForm> userList = handler.listEmp(getDataSource(request));
				request.setAttribute("userList",userList);
		    	System.out.println(userList);
				
		    	List<TimesheetModuleForm> userList1 = handler.listEmp1(getDataSource(request));
				request.setAttribute("userList1",userList1);
		    	System.out.println(userList1);
		       return mapping.findForward("reports");
			}
	public ActionForward reports1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
			{
		         Timestamp ftimets = null;
		         Timestamp ttimets = null;
		         HttpSession session = request.getSession();
			        long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
		         TimesheetModuleForm timesheet = (TimesheetModuleForm)form;
		         System.out.println("inside the reports1 module ");
		         List<TimesheetModuleForm> userList = handler.listEmp(getDataSource(request));
				 request.setAttribute("userList",userList);
			     System.out.println(userList);
					
			    List<TimesheetModuleForm> userList1 = handler.listEmp1(getDataSource(request));
				request.setAttribute("userList1",userList1);
			    System.out.println(userList1);
			    	
			    if(!request.getParameter("fDate").equals("")&& !request.getParameter("tDate").equals(""))
				   {
			    	
			    	 String name = handler.name(getDataSource(request),userid);
				     System.out.println("name is "+ name);
				     request.setAttribute("name", name);
			    	  
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
						System.out.println("datetimes=" + ftimets);
						System.out.println("datetimes1=" + ttimets);
						List<TimesheetModuleForm> AttList = handler.listLeaveList(ftimets,ttimets,timesheet,getDataSource(request));
						request.setAttribute("AttList",AttList);
						System.out.println("AttList "+AttList);
						
				   } 
				 else
				 {
					 String name = handler.name(getDataSource(request),userid);
				     System.out.println("name is "+ name);
				     request.setAttribute("name", name);
					 List<TimesheetModuleForm> AttList = handler.listLeaveList1(timesheet,getDataSource(request));
					 request.setAttribute("AttList",AttList);
					 System.out.println("AttList1 "+AttList);
				 }
		         return mapping.findForward("reports");
			}
}
