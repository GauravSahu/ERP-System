package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.StockUpdateForm;
import com.itech.iERP.handler.StockUpdateHandler;

public class StockUpdateAction extends BaseAction{

	StockUpdateHandler handler = new StockUpdateHandler();
	
	 public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		 List<StockUpdateForm> itemmasterlist = handler.itemlist(getDataSource(request));
		  request.setAttribute("itemmasterlist",itemmasterlist);
		  
		  
		  List<StockUpdateForm> vendorList=handler.vendorList(getDataSource(request));
			request.setAttribute("vendorList", vendorList);
		  
		  
		  List<StockUpdateForm> stockupdatelist = handler.stockupdatelist(getDataSource(request));
		  request.setAttribute("stockupdatelist",stockupdatelist);
		
		  return mapping.findForward("stockupdate");
	  }
	  
	  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		
		  
		  StockUpdateForm stockupdateform = (StockUpdateForm)form;
		  HttpSession session=request.getSession();
		  long compid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		  System.out.println("company id"+compid);
		    String status = handler.add(stockupdateform,getDataSource(request),compid);
		    request.setAttribute("result", status);
		
		  return list(mapping, form, request, response);
	  }
	  
	 
	  
	  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  StockUpdateForm stockupdateform = (StockUpdateForm)form;
		  HttpSession session=request.getSession();
		  long compid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		  System.out.println("company id"+compid);
		  request.setAttribute("status", handler.updatestock(stockupdateform,getDataSource(request),compid));
				
					return list(mapping, form, request, response);
	  }


	  
	  public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  StockUpdateForm stockupdateform = (StockUpdateForm)form;
		  stockupdateform.setStockupdateid(Integer.parseInt(request.getParameter("stockupdateid").trim()));
		  stockupdateform.setActive(Boolean.parseBoolean(request.getParameter("active")));
		
			
		  request.setAttribute("status",handler.changeRole(stockupdateform,getDataSource(request)));
			
		  return list(mapping, form, request, response);
	  }
}





