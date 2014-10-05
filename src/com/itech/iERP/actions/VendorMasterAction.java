package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.VendorMasterForm;
import com.itech.iERP.handler.CityHandler;
import com.itech.iERP.handler.StateHandler;
import com.itech.iERP.handler.VendorMasterHandler;

public class VendorMasterAction extends BaseAction
{
	VendorMasterHandler handler = new VendorMasterHandler();
	StateHandler shandler=new StateHandler();
	CityHandler chandler=new CityHandler();
	//AreaMasterHandler ahandler=new AreaMaster Handler();
		
		public ActionForward list(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception 
		{
			
			System.out.println("--vender list--");
			VendorMasterForm vform=(VendorMasterForm)form;
			try{
			//StateMasterForm sform=(StateMasterForm)form;
			//CityMasterForm cform=(CityMasterForm)form;
			//AreaMasterForm aform=(AreaMasterForm)form;
			System.out.println("my action start");
			List<VendorMasterForm> stateList = handler.listAllStates(getDataSource(request));
			request.setAttribute("stateList", stateList);
			//System.out.println("state Id for fetch="+request.getParameter("cityid"));
			//vform.setStateid(Long.parseLong(request.getParameter("cityid")));
			//vform.setStateList(stateList);	
			List<VendorMasterForm> cityList = handler.listAllcity(getDataSource(request),vform.getStateid());
			//vform.setCityList(cityList);
			request.setAttribute("cityList", cityList);
			//List<VendorMasterForm> areaList = handler.listallArea(getDataSource(request),vform.getCityid());
			//request.setAttribute("areaList", areaList);
			
			
			//vform.setAreaList(areaList);
			
			List<VendorMasterForm> vendorList=handler.vendorList(getDataSource(request),vform);
			request.setAttribute("vendorList", vendorList);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
			catch (ClassCastException e) {
				e.printStackTrace();
			}
			catch (NullPointerException e) {
				e.printStackTrace();
			}
			return mapping.findForward("vendorlist");
		}

		public ActionForward add(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception 
		{
			try{
				
				System.out.println("---add edit-----");
				VendorMasterForm vForm = (VendorMasterForm) form;
				vForm.setFirstname(request.getParameter("firstname"));
				vForm.setLastname(request.getParameter("lastname"));
				vForm.setTeleno(request.getParameter("teleno"));
				vForm.setMobileno(request.getParameter("mobileno"));
				vForm.setEmailid1(request.getParameter("emailid1"));
				vForm.setEmailid2(request.getParameter("emailid2"));
				vForm.setWebsite(request.getParameter("website"));
				vForm.setDiscount(request.getParameter("discount"));
				vForm.setTax(request.getParameter("tax"));
				HttpSession session=request.getSession();
				long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
				  if(session.getAttribute("masterData")!=null)
					{
					   long access= (Long) session.getAttribute("masterData");
					   if(access==1)
			request.setAttribute("status", handler.addVendor(vForm,compid,
					getDataSource(request)));
					   else
						   request.setAttribute("status", "You are not authorised to add");
					}
			}catch (NumberFormatException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			//clinicForm.setCityid(-1); 
			return list(mapping, form, request, response);

		}
		
		public ActionForward changestatus(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
				System.out.println("fsdfkf" + Integer.parseInt(request.getParameter("vendorid")));
				VendorMasterForm vform=(VendorMasterForm)form;
				vform.setVendorid(Integer.parseInt(request.getParameter("vendorid")));
				vform.setActive(Boolean.parseBoolean(request.getParameter("active")));
				HttpSession session=request.getSession();
				if(session.getAttribute("masterData")!=null)
				{
				   long access= (Long) session.getAttribute("masterData");
					if(access==1)
				request.setAttribute("status", handler.changeVendor(vform,getDataSource(request)));
				}
			return list(mapping, vform, request, response);
		}

		public ActionForward update(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("----update----");
			VendorMasterForm vform=(VendorMasterForm)form;
			HttpSession session=request.getSession();
		     if(session.getAttribute("masterData")!=null)
				{
				   long access= (Long) session.getAttribute("masterData");
					if(access==1)
			request.setAttribute("status", handler.updateVendor(vform,
					getDataSource(request)));
					else
						request.setAttribute("status", "You are not authorised to update ");	
				}
			vform.setVendorid(-1);
			return list(mapping, form, request, response);
		}
		
		
}
