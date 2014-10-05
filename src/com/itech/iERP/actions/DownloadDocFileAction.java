package com.itech.iERP.actions;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.forms.DocDownloadForm;
import com.itech.iERP.forms.LoginForm;

public class DownloadDocFileAction extends Action
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		
		DocDownloadForm docDownloadForm = (DocDownloadForm)form;
		
		String file1 = docDownloadForm.getFilename();
		//file1 = leavemoduleform.getDocname2();
		String userid = docDownloadForm.getUserid();
		String filetype = docDownloadForm.getFiletype();
		//return an application file instead of html page
        response.setContentType("application/octet-stream");
       
        response.setHeader("Content-Disposition","attachment;filename=" +file1);
        HttpSession session = request.getSession();
        try 
    	{
        	//Get it from file system
        	//URL url = getServlet().getServletContext().getResource("docfiles/doc3/demo8.txt");
        	Long test = ((LoginForm) session.getAttribute("userDetail")).getUserId();		
	        if (test != null) {
	        //String filename =  "C:\\Documents and Settings\\sys\\Desktop\\shastrogyan\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Hayagriva\\files\\" +file;	
        	String filename1 = getServlet().getServletContext().getRealPath("\\")+filetype+"\\"+file1;
        	File fileToDownload1 = new File(filename1);
        	FileInputStream in = new FileInputStream(fileToDownload1);
        	
        	
        	
        	
        	//Get it from web path
        	//jndi:/localhost/StrutsExample/upload/superfish.zip
        	//URL url = getServlet().getServletContext().getResource("upload/superfish.zip");
        	//InputStream in = url.openStream();
        	
        	//Get it from bytes array
        	//byte[] bytes = new byte[4096];
        	//InputStream in = new ByteArrayInputStream(bytes);

        	ServletOutputStream out = response.getOutputStream();
        	 
        	byte[] outputByte = new byte[4096];
        	//copy binary contect to output stream
        	while(in.read(outputByte, 0, 4096) != -1)
        	{
        		out.write(outputByte, 0, 4096);
        	}
        	
        	in.close();
        	
        	out.flush();
        	out.close();
        	
        	return null;
	        } 
	         else
	        	return mapping.findForward("session");
    	 } 
        catch(Exception e)
        {
    	   e.printStackTrace();
    	   return mapping.findForward("session");
    	}
		}
	
	
}
