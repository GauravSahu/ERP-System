package com.itech.iERP.actions;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.itech.iERP.forms.CalenderForm;
import com.itech.iERP.forms.UserForm;
import com.itech.iERP.handler.CalenderHandler;



public class CalenderAction extends BaseAction {


	CalenderHandler handler = new CalenderHandler();
	
	 public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the Calender Master action");
		  List<CalenderForm> cstatusList = handler.cstatusList(getDataSource(request));
		  request.setAttribute("cstatusList",cstatusList);
		  
		  List<CalenderForm> companyList = handler.companyList(getDataSource(request));
		  request.setAttribute("companyList",companyList);
		  
		  List<CalenderForm> calenderList = handler.list(getDataSource(request));
		  request.setAttribute("calenderList",calenderList);
		  System.out.println("calenderList "+calenderList);
		  return mapping.findForward("calendertype");
	  }
	  
	  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  
		  System.out.println("Inside the add method");
		  System.out.println(request.getParameter("date"));
		  String date = request.getParameter("date");
		  System.out.println("Befor TimeStamp"+date);
		  DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		  java.util.Date date1 = (java.util.Date)formatter.parse(date);
		  Timestamp timets = new Timestamp(date1.getTime()); 
		  
		  CalenderForm calenderForm =(CalenderForm)form;
		  String status = handler.add(calenderForm,getDataSource(request),timets);
		  request.setAttribute("result", status);
		  System.out.println("result "+status);
		  calenderForm.setCompanyid("-1");
		  calenderForm.setDate("");
		  calenderForm.setDay("-1");
		  calenderForm.setCaldayid("-1");
		  return list(mapping, form, request, response);
	  }
	  
/*	  public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  CalenderForm calenderForm = (CalenderForm)form;
		  calenderForm.setCompanyid(request.getParameter("companyid").trim());
		  calenderForm.setActive(Boolean.parseBoolean(request.getParameter("active")));
		  request.setAttribute("status",handler.changeStatus(calenderForm,getDataSource(request)));
		  return list(mapping, form, request, response);
	  }
	  */
	  public ActionForward dtypelist(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  CalenderForm cform=(CalenderForm)form;
	
		  List<CalenderForm> cstatusList = handler.cstatusList(getDataSource(request));
		  request.setAttribute("cstatusList",cstatusList);
		  System.out.println("CID1 "+request.getParameter("cid"));
		  cform.setDcompanyid(request.getParameter("cid"));
		  return mapping.findForward("updateType");
	  }
	  
  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
	  		System.out.println("CID "+request.getParameter("cid"));
		  CalenderForm calenderForm = (CalenderForm)form;
		  request.setAttribute("status", handler.updateDaytype(calenderForm,getDataSource(request)));
		 
		  return  dtypelist(mapping, calenderForm, request, response);
	  }

}
