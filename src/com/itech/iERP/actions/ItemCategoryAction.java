package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.ItemCategoryForm;
import com.itech.iERP.handler.ItemCategoryHandler;

public class ItemCategoryAction extends BaseAction {
	ItemCategoryHandler handler= new ItemCategoryHandler();
	public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the ItemCategory master action");
		  List<ItemCategoryForm> itemcategorylist = handler.list(getDataSource(request));
		  request.setAttribute("itemcategorylist",itemcategorylist);
		  return mapping.findForward("itemcat");
	  }
	  
	  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  System.out.println("Inside the add method");
		  ItemCategoryForm itemcategoryform = (ItemCategoryForm)form;
		  String status=null;
		  HttpSession session=request.getSession();
		  if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
			   {
		  status = handler.add(itemcategoryform,getDataSource(request));
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
		  ItemCategoryForm itemcategoryform = (ItemCategoryForm)form;
		  itemcategoryform.setCategoryid(Integer.parseInt(request.getParameter("categoryid").trim()));
		  itemcategoryform.setActive(Boolean.parseBoolean(request.getParameter("active")));
		  HttpSession session=request.getSession();
			if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		  request.setAttribute("status",handler.changeStatus(itemcategoryform,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to change the status");	
			}
				return list(mapping, form, request, response);
	  }
	  
	  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  ItemCategoryForm itemcategoryform = (ItemCategoryForm)form;
		  HttpSession session=request.getSession();
		     if(session.getAttribute("masterData")!=null)
				{
				   long access= (Long) session.getAttribute("masterData");
					if(access==1)
		  request.setAttribute("status", handler.update(itemcategoryform,getDataSource(request)));
					else
						request.setAttribute("status", "You are not authorised to update ");	
				}
					return list(mapping, form, request, response);
	  }

}
