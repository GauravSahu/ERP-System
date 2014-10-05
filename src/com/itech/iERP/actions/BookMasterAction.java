package com.itech.iERP.actions;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.BookMasterForm;
import com.itech.iERP.handler.BookMasterHandler;

public class BookMasterAction  extends BaseAction{

	BookMasterHandler handler = new BookMasterHandler();
	
	 public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		 List<BookMasterForm> bookcatList = handler.bootcatlist(getDataSource(request));
		  request.setAttribute("bookcatList",bookcatList);
		  
		  
		  List<BookMasterForm> bookmasterlist = handler.list(getDataSource(request));
		  request.setAttribute("bookmasterlist",bookmasterlist);
		
		  return mapping.findForward("Bookmaster");
	  }
	  
	  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the add method");
		  BookMasterForm bookmasterForm = (BookMasterForm)form;
		  HttpSession session=request.getSession();
		  
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
			   {
		    String status = handler.add(bookmasterForm,getDataSource(request));
		    request.setAttribute("result", status);
			   }
		    else 
		    	 request.setAttribute("status", "You are not authorised to add");	
			   }
		
		  return list(mapping, form, request, response);
	  }
	  
	 
	  
	  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  BookMasterForm bookmasterForm = (BookMasterForm)form;
		  HttpSession session=request.getSession();
		  
		     if(session.getAttribute("masterData")!=null)
				{
				   long access= (Long) session.getAttribute("masterData");
					if(access==1)
		  request.setAttribute("status", handler.updateBookMaster(bookmasterForm,getDataSource(request)));
					else
						request.setAttribute("status", "You are not authorised to update ");	
				}
		    
					return list(mapping, form, request, response);
	  }
}



