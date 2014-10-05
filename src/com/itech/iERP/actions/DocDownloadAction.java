package com.itech.iERP.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.DocDownloadForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.handler.DocDownloadHandler;

public class DocDownloadAction extends BaseAction
{
	DocDownloadHandler handler = new DocDownloadHandler();
	public ActionForward filedownload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		    
		DocDownloadForm docDownloadForm = (DocDownloadForm)form;
		HttpSession session=request.getSession();
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		long userid = ((LoginForm)session.getAttribute("userDetail")).getUserId();
		List<DocDownloadForm> Userlist = handler.allActiveUsers(compid,getDataSource(request));
		request.setAttribute("Userlist", Userlist);			
		List<DocDownloadForm> docList=handler.allDocList(getDataSource(request));
		request.setAttribute("docList",docList);
		
		if(userid!=0){
			return mapping.findForward("audiodownload");
	    }
		else
	    	return mapping.findForward("session");	
	}
}
