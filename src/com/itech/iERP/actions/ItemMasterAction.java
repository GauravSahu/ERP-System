package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.ItemCategoryForm;
import com.itech.iERP.forms.ItemMasterForm;
import com.itech.iERP.handler.ItemCategoryHandler;
import com.itech.iERP.handler.ItemMasterHandler;

public class ItemMasterAction extends BaseAction {
	ItemMasterHandler handler=new ItemMasterHandler();
	ItemCategoryHandler handlercat= new ItemCategoryHandler();
	public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  List<ItemMasterForm> itemcategorylist = handler.itemlist(getDataSource(request));
		  request.setAttribute("itemcategorylist",itemcategorylist);
		 
		  
		  List<ItemMasterForm> itemmasterlist = handler.list(getDataSource(request));
		  request.setAttribute("itemmasterlist",itemmasterlist);
		  
		  return mapping.findForward("itemmasterlist");
	  }
	 public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		
		  ItemMasterForm itemmasterform = (ItemMasterForm)form; 
		 
		  String status=null;
		  HttpSession session=request.getSession();
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
			   {
		  status = handler.add(itemmasterform,getDataSource(request));
		  request.setAttribute("result", status);
			   }
		  else
			   request.setAttribute("status", "You are not authorised to add");
			}
		  System.out.println("result "+status);
		  return list(mapping, form, request, response);
	  }
	  public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  ItemMasterForm itemmasterform = (ItemMasterForm)form;
		  itemmasterform.setItemmasterid(Integer.parseInt(request.getParameter("itemmasterid").trim()));
		  itemmasterform.setActive(Boolean.parseBoolean(request.getParameter("active")));
		  HttpSession session=request.getSession();
			if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		  request.setAttribute("status",handler.changeStatus(itemmasterform,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to change the status");	
			}
				return list(mapping, form, request, response);
	  }
	  
	  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  ItemMasterForm itemmasterform = (ItemMasterForm)form;
		  HttpSession session=request.getSession();
		     if(session.getAttribute("masterData")!=null)
				{
				   long access= (Long) session.getAttribute("masterData");
					if(access==1)
		  request.setAttribute("status", handler.update(itemmasterform,getDataSource(request)));
					else
						request.setAttribute("status", "You are not authorised to update ");	
				}
					return list(mapping, form, request, response);
	  }

}


