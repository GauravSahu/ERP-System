package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.GoodsResivedForm;
import com.itech.iERP.handler.GoodResivedHandler;
import com.itech.iERP.utils.Util;

public class GoodsResivedAction extends BaseAction{
	GoodResivedHandler handler = new GoodResivedHandler();
	
	 public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  List<GoodsResivedForm>goodsresivedlist = handler.list(getDataSource(request));
		  request.setAttribute("goodsresivedlist",goodsresivedlist);
		 
		  List<GoodsResivedForm> vendorList=handler.vendorList(getDataSource(request));
			request.setAttribute("vendorList", vendorList);
			 return mapping.findForward("goodsresived");
	  }
	  
	  public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  
		  GoodsResivedForm goodsresivedform = (GoodsResivedForm)form;
		  String[] sid= request.getParameterValues("stockupdateid");
		  String[] iid = request.getParameterValues("itemid");
			String[] vid = request.getParameterValues("vendorid");
			String[] pri = request.getParameterValues("price");
			String[] aq = request.getParameterValues("acceptqty");
			String[] rq = request.getParameterValues("rejectqty");
			String[] ci = request.getParameterValues("compid");
			String[] remark = request.getParameterValues("remark");
			String date=Util.getCurrentDate();
			for(int i=0;i<sid.length;i++){
		    String status = handler.add(goodsresivedform,getDataSource(request),iid[i],vid[i],pri[i],aq[i],rq[i],ci[i],date,remark[i]);
		    request.setAttribute("result", status);
		  
			}
			  return list(mapping, form, request, response);
	  }
	  
	 
	  
//	  public ActionForward update(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
//	  {
//		  GoodsResivedForm goodsresivedform = (GoodsResivedForm)form;
//		  HttpSession session=request.getSession();
//		  
//		     if(session.getAttribute("masterData")!=null)
//				{
//				   long access= (Long) session.getAttribute("masterData");
//					if(access==1)
//		  request.setAttribute("status", handler.update(goodsresivedform,getDataSource(request)));
//					else
//						request.setAttribute("status", "You are not authorised to update ");	
//				}
//		    
//					return list(mapping, form, request, response);
//	  }
	  
	  
	  
	 /* public ActionForward changestatus(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	  {
		  GoodsResivedForm goodsresivedform = (GoodsResivedForm)form;
		  goodsresivedform.setBookcatid(Integer.parseInt(request.getParameter("bookcatid").trim()));
		  goodsresivedform.setActive(Boolean.parseBoolean(request.getParameter("active")));
		  HttpSession session=request.getSession();
			if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
		  request.setAttribute("status",handler.changeRole(goodsresivedform,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to change the status");	
			}
		  return list(mapping, form, request, response);
	  }*/
	  
//}



}
