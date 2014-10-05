package com.itech.iERP.actions;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.itech.iERP.forms.CityForm;
import com.itech.iERP.forms.ContryForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.StateForm;
import com.itech.iERP.handler.CityHandler;
import com.itech.iERP.handler.CountryHandler;
import com.itech.iERP.handler.StateHandler;

public class CityMasterAction extends BaseAction 
{
	CountryHandler handler = new CountryHandler();
	StateHandler handler1 = new StateHandler();
	CityHandler handler2 = new CityHandler();
	public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	 {
	  System.out.println("inside the list method of city action");
	  CityForm cityForm = (CityForm) form;
	  HttpSession session = request.getSession();
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
	  List<ContryForm> countryList = handler.active(getDataSource(request));
	  System.out.println("active country list "+countryList);
	  request.setAttribute("countryList", countryList);
	  System.out.println("Country Id "+cityForm.getCountryid());
      List<StateForm> stateList = handler1.listactive(cityForm.getCountryid(),getDataSource(request));
	  System.out.println("active state List "+stateList);
	  request.setAttribute("stateList", stateList);
	  System.out.println("stateId "+cityForm.getStateid());
	  List<CityForm> cityList = handler2.list(cityForm.getStateid(),cityForm.getCountryid(),compid,getDataSource(request));
	  request.setAttribute("cityList", cityList);
	  System.out.println("City List "+cityList);
	  return mapping.findForward("city");
     }
	
	   public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	   {
		   System.out.println("inside the add method");
		   CityForm cityForm = (CityForm) form;
		   HttpSession session=request.getSession();
		   long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		   if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
		   request.setAttribute("status",handler2.addCity(compid,cityForm,getDataSource(request)));
			   else
				   request.setAttribute("status", "You are not authorised to add");	
			}
		   return list(mapping, form, request, response);
	   }
	   
	   public ActionForward changestatus(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception
	   {
		    CityForm cityForm = (CityForm) form;
		    cityForm.setCountryid(Long.valueOf(request.getParameter("countryid")));
		    System.out.println(request.getParameter("countryid"));
			cityForm.setStateid(Long.valueOf(request.getParameter("stateid")));
			System.out.println();
			cityForm.setCityid(Long.valueOf(request.getParameter("cityid")));
			cityForm.setActive(Boolean.parseBoolean(request.getParameter("Active")));
			HttpSession session=request.getSession();
			if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
			request.setAttribute("status",handler2.changeCity(cityForm,getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to change the status");	
			}
		  return list(mapping, form, request, response);
	   }
	   
	   public ActionForward update(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception
	   {
			
		   System.out.println("inside the update method");
		   CityForm cityForm = (CityForm) form;
		   HttpSession session=request.getSession();
	       if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
				if(access==1)
			request.setAttribute("status", handler2.updateCity(cityForm, getDataSource(request)));
				else
					request.setAttribute("status", "You are not authorised to update ");	
			}
			return list(mapping, form, request, response);

		}
		
	   
	   public ActionForward reset(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception
	    {
		   CityForm cityForm = (CityForm) form;
		   List<CityForm> cityList = new ArrayList<CityForm>();
		   cityForm.setCityid(0);
		   cityForm.setCityname("");
		   cityForm.setStateid(0);
		   cityList.add(cityForm);
		   request.setAttribute("cityList", cityList);
		   return list(mapping, form, request, response);
	    }
}
