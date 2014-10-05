package com.itech.iERP.actions;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;



import com.itech.iERP.forms.LibraryModuleForm;
import com.itech.iERP.handler.AttendanceModuleHandler;
import com.itech.iERP.handler.LibraryModuleHandler;
import com.itech.iERP.utils.Util;

public class LibraryModuleAction extends BaseAction {
	LibraryModuleHandler handler = new LibraryModuleHandler();
	
	 AttendanceModuleHandler userhandle = new AttendanceModuleHandler();
	public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		
		 	List<LibraryModuleForm> bookcatList = handler.booklist(getDataSource(request));
		  request.setAttribute("bookcatList",bookcatList);
		  
		  List<LibraryModuleForm> employeelist = handler.employeelist(getDataSource(request));
		  request.setAttribute("employeelist",employeelist);
		  
		  
		  List<LibraryModuleForm> bookrequestlist = handler.bookrequestlist(getDataSource(request));
		  request.setAttribute("bookrequestlist",bookrequestlist);
		  return mapping.findForward("bookrequest");
		  
		 
	  }
	
	public ActionForward bookduelist(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  List<LibraryModuleForm> employeelist = handler.employeelist(getDataSource(request));
		  request.setAttribute("employeelist",employeelist);
		  return mapping.findForward("bookduesearch1");
	 }
	  
	  public ActionForward addbookrequest(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  String status = null;
		  List<LibraryModuleForm> employeelist = handler.employeelist(getDataSource(request));
		  request.setAttribute("employeelist",employeelist);
		  LibraryModuleForm bookrequestform = (LibraryModuleForm)form;
	
		  
		  int datainsert_status = handler.add(bookrequestform,getDataSource(request));
		 if(datainsert_status==2){
		  
		  String email=handler.mailbooklist(bookrequestform,getDataSource(request));
		status ="Added Successfully & "+email;
		 }
		 else  if(datainsert_status==1){
			 status ="Book Already Taken By this Employee";
		 }else{
				 status ="Process Filed";
		
		 }
		 request.setAttribute("status",status);
		   return list(mapping, form, request, response);
	  }
	
	  
	  
	  
	  
	  
	  public ActionForward bookduesearch(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		
		  List<LibraryModuleForm> employeelist = handler.employeelist(getDataSource(request));
		  request.setAttribute("employeelist",employeelist);
		   LibraryModuleForm bookrequestform = (LibraryModuleForm)form;
		   
		   
		   
		  if(!request.getParameter("takendate").equals("")&& !request.getParameter("returndate").equals("")){
			 
			
			  String takendate = Util.formatSqlDate(bookrequestform.getTakendate());
			  String returndate=Util.formatSqlDate(bookrequestform.getReturndate());
			  
			  List<LibraryModuleForm> bookduesearchlist = handler.bookduesearchlist(getDataSource(request), takendate ,returndate);
			  request.setAttribute("bookduesearchlist",bookduesearchlist);
			  return mapping.findForward("bookduesearch");
		  }
		  else{
			  int emp1 = bookrequestform.getEmployeeid();
			  int emp2=bookrequestform.getEmployeeid1();
			
			  List<LibraryModuleForm> bookduesearchlist = handler.empbookduesearchlist(getDataSource(request), emp1 ,emp2);
		  request.setAttribute("bookduesearchlist",bookduesearchlist);
		  return mapping.findForward("bookduesearch1");
			  
	  }
	  }
	  
	
}






	