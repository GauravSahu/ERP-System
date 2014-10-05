package com.itech.iERP.actions;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.cete.dynamicpdf.imaging.tiff.c;
import com.itech.iERP.forms.BankForm;
import com.itech.iERP.forms.CompanyForm;
import com.itech.iERP.handler.CompanyHandler;
import com.itech.iERP.utils.Util;

public class CompanyAction extends BaseAction
{
	CompanyHandler handler = new CompanyHandler();
	public ActionForward list(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	 {
		List<CompanyForm> compList=handler.list(getDataSource(request));
		request.setAttribute("compList",compList);	
	    System.out.println("CompList "+compList);
		return mapping.findForward("companyMaster");
	 }
	
	public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	 {
		System.out.println("Inside the add method");
		CompanyForm compForm = (CompanyForm)form;
		String status=null;
		//FormFile formFile = null;
		try
		{
			FormFile myfile = compForm.getFileName();//bean as filename
            InputStream ii= myfile.getInputStream();
            System.out.println(myfile.getInputStream());
			String fileName = myfile.getFileName();
			System.out.println(fileName);
		//FormFile formFile = compForm.getFile();
		System.out.println("Comp name"+compForm.getCompanyName());
	//	String path = getServlet().getServletContext().getRealPath("")+"/"+formFile.getFileName();
		//String Address=request.getParameter("Address");
		System.out.println("Address "+request.getParameter("Address"));
		String filePath = getServlet().getServletContext().getRealPath("\\")+"/"+fileName;
		//Util.audioFolder(myfile, path, fileName);
		HttpSession session=request.getSession();
		   if(session.getAttribute("masterData")!=null)
			{
			   long access= (Long) session.getAttribute("masterData");
			   if(access==1)
		 status = handler.add(compForm,fileName,getDataSource(request));
			   else
				   request.setAttribute("status", "You are not authorised to add");	
			}
			   
		System.out.println("Image path "+filePath);
		System.out.println("Address "+compForm.getAddress());
		System.out.println("Emailid1 "+compForm.getEmailId1());
		System.out.println("Emailid2 "+compForm.getContactNo());
		System.out.println("AttendaneCutOffTime "+compForm.getALCutOff());
		System.out.println("pAddress"+compForm.getPermAddress());
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list(mapping, form, request, response);
	 }
	
	public ActionForward changestatus(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		CompanyForm compForm = (CompanyForm)form;
		compForm.setCompanyId(Integer.parseInt(request.getParameter("companyId").trim()));
		compForm.setActive(Boolean.parseBoolean(request.getParameter("active").trim()));
		HttpSession session=request.getSession();
		if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
		request.setAttribute("status",handler.changeRole(compForm, getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to change the status");	
		}
		return list(mapping, form, request, response);
	}
	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		CompanyForm compForm = (CompanyForm)form;
		System.out.println("Inside the update method");
		FormFile myfile = compForm.getFileName();//bean as filename
        InputStream ii= myfile.getInputStream();
        System.out.println(myfile.getInputStream());
		String fileName = myfile.getFileName();
		System.out.println(fileName);
	//FormFile formFile = compForm.getFile();
	System.out.println("Comp name"+compForm.getCompanyName());
//	String path = getServlet().getServletContext().getRealPath("")+"/"+formFile.getFileName();
	
	String filePath = getServlet().getServletContext().getRealPath("\\")+"/"+fileName;
	 HttpSession session=request.getSession();
     if(session.getAttribute("masterData")!=null)
		{
		   long access= (Long) session.getAttribute("masterData");
			if(access==1)
		request.setAttribute("status",handler.updateRole(compForm,fileName, getDataSource(request)));
			else
				request.setAttribute("status", "You are not authorised to update ");	
		}
		return list(mapping, form, request, response);
	}	
}

