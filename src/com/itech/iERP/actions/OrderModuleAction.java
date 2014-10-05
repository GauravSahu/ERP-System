package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.AccountMasterForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.OrderModuleForm;
import com.itech.iERP.forms.PriceMasterForm;
import com.itech.iERP.handler.OrderModuleHandler;


public class OrderModuleAction extends BaseAction 
{ 
	
  OrderModuleHandler handler = new OrderModuleHandler();
  public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	    HttpSession session = request.getSession();
	    long compid=((LoginForm)session.getAttribute("userDetail")).getCompany();
		long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	    
		 List<OrderModuleForm> itemmasterlist = handler.itemlist(userid,compid,getDataSource(request));
		 request.setAttribute("itemmasterlist",itemmasterlist);
		  
		  
		  List<OrderModuleForm> venderList=handler.venderList(userid,compid,getDataSource(request));
		  request.setAttribute("venderList", venderList);
		  
		  
			
	  return mapping.findForward("order");     
    }
  
  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse  response)throws Exception
  {
	  HttpSession session = request.getSession();
	//  long compid=((LoginForm)session.getAttribute("userDetail")).getCompany();
		long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
			OrderModuleForm ordermodule = (OrderModuleForm)form;
		 List<OrderModuleForm> itemmasterlist = handler.itemlist(userid,compid,getDataSource(request));
		 request.setAttribute("itemmasterlist",itemmasterlist);
		  
		  
		  List<OrderModuleForm> venderList=handler.venderList(userid,compid,getDataSource(request));
		  request.setAttribute("venderList", venderList);
		  
		  String status = handler.addpurchaserequition(userid,compid,ordermodule,getDataSource(request));
		  request.setAttribute("status",status);
	  return mapping.findForward("order");
  }
  
  public ActionForward pricecomparision(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)throws Exception
  {
	  System.out.println("price comparision ");
	  HttpSession session = request.getSession();
	  long compid=((LoginForm)session.getAttribute("userDetail")).getCompid();
	  long compid1 = ((LoginForm) session.getAttribute("userDetail")).getCompany();
	  System.out.println("company id "+compid);
	  System.out.println("company id1 "+compid1);
	  long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	  List<OrderModuleForm> pricedetails = handler.pricedetails(userid,compid,getDataSource(request));
	  request.setAttribute("pricedetails",pricedetails);
	  return mapping.findForward("pricecomparision");
  }
}
