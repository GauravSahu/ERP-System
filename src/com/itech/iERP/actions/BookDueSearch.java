package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.LibraryModuleForm;
import com.itech.iERP.handler.LibraryModuleHandler;
import com.itech.iERP.utils.Util;

public class BookDueSearch  extends BaseAction {
	LibraryModuleHandler handler = new LibraryModuleHandler();
//	public ActionForward bookduesearch(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
//	  {
//		
//		 /*List<LibraryModuleForm> bookcatList = handler.booklist(getDataSource(request));
//		  request.setAttribute("bookcatList",bookcatList);
//		  
//		  List<LibraryModuleForm> employeelist = handler.employeelist(getDataSource(request));
//		  request.setAttribute("employeelist",employeelist);
//		  
//		 */ 
//		 LibraryModuleForm bookrequestform = (LibraryModuleForm)form;
//		 
//
//		  bookrequestform.setTakendate(Util.getCurrentDate());
//		  bookrequestform.setTakentime(Util.getCurrentTime());
//		  bookrequestform.setReturndate(Util.AddDate(15));
//		  List<LibraryModuleForm> bookduesearchlist = handler.bookduesearchlist(getDataSource(request));
//		  request.setAttribute("bookduesearchlist",bookduesearchlist);
//		  return mapping.findForward("bookrequest");
//	  }
//	  
//	 
}
