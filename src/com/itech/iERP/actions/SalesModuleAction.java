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
import org.apache.struts.upload.FormFile;

import com.itech.iERP.forms.ContryForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.SalesModuleForm;
import com.itech.iERP.forms.UserForm;
import com.itech.iERP.handler.SalesModuleHandler;
import com.itech.iERP.utils.Util;

public class SalesModuleAction extends BaseAction
{ 
   SalesModuleHandler handler = new SalesModuleHandler();
   public ActionForward addEnquiry(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   HttpSession session = request.getSession();
	   long test = 0;
	   try{
	   test = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	   }catch (NullPointerException e) {
		   return mapping.findForward("session");
	   }
	   long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	   SalesModuleForm salesmoduleform = (SalesModuleForm)form;
	   String status = handler.addEnquiry(salesmoduleform,userid,getDataSource(request));
	   request.setAttribute("status",status);
	   if(test!=0)
	   return mapping.findForward("addenquiry");
	   else
		   return mapping.findForward("session");   
   }

   public ActionForward Followup(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   System.out.println("Inside the follow up method");
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   System.out.println("Enquiry list "+enquiryList);
	   List<SalesModuleForm> userList = handler.activeUserList(getDataSource(request));
	   request.setAttribute("userList",userList);
	   System.out.println("userList  "+userList);
	   return mapping.findForward("followup");
   }
   
   public ActionForward addFollowup(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception 
   { 
	   Timestamp ftimets = null;
	   System.out.println("Inside the add follow up method");
	   HttpSession session = request.getSession();
	   long test = 0;
	   try{
	   test = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	   }catch (NullPointerException e) {
		   return mapping.findForward("session");
	   }
	   long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	   SalesModuleForm salesmoduleform = (SalesModuleForm)form;
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   System.out.println("Enquiry list "+enquiryList);
	   List<SalesModuleForm> userList = handler.activeUserList(getDataSource(request));
	   request.setAttribute("userList",userList);
	   
	   String ftime = request.getParameter("fdate").trim();
	   System.out.println("Before Timestamp "+ftime);
	   DateFormat fformatter = new SimpleDateFormat("dd/MM/yyyy");
	   java.util.Date fdate = (java.util.Date) fformatter.parse(ftime);
	   ftimets = new Timestamp(fdate.getTime());
	   System.out.println(ftimets);
	   
	   
	    
	   
	   System.out.println("bhgbfhgh"+salesmoduleform.getEnquiryid());
	   System.out.println("userid "+salesmoduleform.getUserid());
	   String status = handler.addFollowup(salesmoduleform,userid,ftimets,getDataSource(request));
	   request.setAttribute("status",status);
	   
	   
	   return mapping.findForward("followup");
   }
   
   public ActionForward appointment(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   SalesModuleForm salesmoduleform = (SalesModuleForm)form;
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   List<SalesModuleForm> userList = handler.activeUserList(getDataSource(request));
	   request.setAttribute("userList",userList);
	  return mapping.findForward("appointment");   
   }
   
   public ActionForward addappointment(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Timestamp ftimets = null;
	   HttpSession session = request.getSession();
	   long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	   SalesModuleForm salesmoduleform = (SalesModuleForm)form;
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   List<SalesModuleForm> userList = handler.activeUserList(getDataSource(request));
	   request.setAttribute("userList",userList);
	   String ftime = request.getParameter("fdate").trim();
	   System.out.println("Before Timestamp "+ftime);
	   DateFormat fformatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	   java.util.Date fdate = (java.util.Date) fformatter.parse(ftime);
	   ftimets = new Timestamp(fdate.getTime());
	   System.out.println(ftimets);
	   System.out.println("bhgbfhgh"+salesmoduleform.getEnquiryid());
	   System.out.println("enquiryid "+salesmoduleform.getEnquiryid());
	   
	   String status = handler.addAppointment(salesmoduleform,userid,ftimets,getDataSource(request));
	   request.setAttribute("status",status);
	   return mapping.findForward("appointment"); 
   }
   
   public ActionForward quotation(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	 return mapping.findForward("quotation");   
   }
   
   public ActionForward addQuatation(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   SalesModuleForm salesmoduleform = (SalesModuleForm)form;
	   HttpSession session = request.getSession();
	   long userid = ((LoginForm)session.getAttribute("userDetail")).getUserId();
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   FormFile myfile = salesmoduleform.getFileupload();
	   String fileName = myfile.getFileName();
	   System.out.println("File Name "+fileName);
       String filePath = getServlet().getServletContext().getRealPath("/")+ "quotation\\";
       Util.audioFolder(myfile, filePath, fileName);
	   String status = handler.saveQuotation(salesmoduleform,userid,fileName,getDataSource(request));
	   request.setAttribute("status",status);
	   return mapping.findForward("quotation");
   }  
   
   public ActionForward enquiryReports(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   System.out.println("inside the enquiry reports");
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   List<SalesModuleForm> enquiryList1 = handler.activeEnquiryList1(getDataSource(request));
	   request.setAttribute("enquiryList1",enquiryList1);
	   return mapping.findForward("enquiryreports");
   }
   
   public ActionForward enquiryRepResults(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   Timestamp ftimets = null;
		Timestamp ttimets = null;
		SalesModuleForm salesmodform = (SalesModuleForm)form;
	   System.out.println("inside the enquiry reports");
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   List<SalesModuleForm> enquiryList1 = handler.activeEnquiryList1(getDataSource(request));
	   request.setAttribute("enquiryList1",enquiryList1);
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
			
		   List<SalesModuleForm> enquiryreports = handler.getenquiryreports(ftimets,ttimets,salesmodform,getDataSource(request));
		   System.out.println(enquiryreports);
		   request.setAttribute("enquiryreports",enquiryreports);
		   
	   }
	   else if((salesmodform.getEnquiryid()!=-1) && (salesmodform.getEnquiryid()!=-1))
	   {
		  
		   List<SalesModuleForm> enquiryreports = handler.getenquiryrepsales(salesmodform,getDataSource(request));
		   System.out.println(enquiryreports);
		   request.setAttribute("enquiryreports",enquiryreports);
	   }
	   else
	   {	
		   List<SalesModuleForm> enquiryreports = handler.getenquiryrepgen(salesmodform,getDataSource(request));
		   System.out.println(enquiryreports);
		   request.setAttribute("enquiryreports",enquiryreports);
	   }
	   return mapping.findForward("enquiryreports");
   }
   
   public ActionForward followupreports(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   System.out.println("inside the enquiry reports");
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   List<SalesModuleForm> enquiryList1 = handler.activeEnquiryList1(getDataSource(request));
	   request.setAttribute("enquiryList1",enquiryList1);
	   return mapping.findForward("followupreports");
   }

   public ActionForward followupresults(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   
	   Timestamp ftimets = null;
		Timestamp ttimets = null;
		SalesModuleForm salesmodform = (SalesModuleForm)form;
	   System.out.println("inside the enquiry reports");
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   List<SalesModuleForm> enquiryList1 = handler.activeEnquiryList1(getDataSource(request));
	   request.setAttribute("enquiryList1",enquiryList1);
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
			
		   List<SalesModuleForm> followupreports = handler.getfollowupreports(ftimets,ttimets,salesmodform,getDataSource(request));
		   System.out.println(followupreports);
		   request.setAttribute("followupreports ",followupreports);
		   
	   }
	   else if((salesmodform.getEnquiryid()!=-1) && (salesmodform.getEnquiryid()!=-1))
	   {
		  
		   List<SalesModuleForm> followupreports = handler.getfollowuprepsales(salesmodform,getDataSource(request));
		   System.out.println(followupreports);
		   request.setAttribute("followupreports",followupreports);
	   }
	   else
	   {	
		   List<SalesModuleForm> followupreports = handler.getfollowuprepgen(salesmodform,getDataSource(request));
		   System.out.println(followupreports);
		   request.setAttribute("followupreports",followupreports);
	   }
	   
	   return mapping.findForward("followupreports");
   }
   
   public ActionForward quotationreports(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   System.out.println("inside the enquiry reports");
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   List<SalesModuleForm> enquiryList1 = handler.activeEnquiryList1(getDataSource(request));
	   request.setAttribute("enquiryList1",enquiryList1);
	   return mapping.findForward("quotationreports");
   }
   
   public ActionForward quotationresults(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   
	   Timestamp ftimets = null;
		Timestamp ttimets = null;
		SalesModuleForm salesmodform = (SalesModuleForm)form;
	   System.out.println("inside the enquiry reports");
	   List<SalesModuleForm> enquiryList = handler.activeEnquiryList(getDataSource(request));
	   request.setAttribute("enquiryList",enquiryList);
	   List<SalesModuleForm> enquiryList1 = handler.activeEnquiryList1(getDataSource(request));
	   request.setAttribute("enquiryList1",enquiryList1);
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
			
		   List<SalesModuleForm> quotationreports = handler.getquotationreports(ftimets,ttimets,salesmodform,getDataSource(request));
		   System.out.println(quotationreports);
		   request.setAttribute("quotationreports ",quotationreports);
		   
	   }
	   else if((salesmodform.getEnquiryid()!=-1) && (salesmodform.getEnquiryid()!=-1))
	   {
		  
		   List<SalesModuleForm> quotationreports = handler.getquotationrepsales(salesmodform,getDataSource(request));
		   System.out.println(quotationreports);
		   request.setAttribute("quotationreports",quotationreports);
	   }
	   else
	   {	
		   List<SalesModuleForm> quotationreports = handler.getquotationrepgen(salesmodform,getDataSource(request));
		   System.out.println(quotationreports);
		   request.setAttribute("quotationreports",quotationreports);
	   }
	   return mapping.findForward("quotationreports");
   }
   public ActionForward apppointmentreports(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
   {
	   return mapping.findForward("appointmentreports");
   }
}
