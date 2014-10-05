package com.itech.iERP.actions;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.itech.iERP.forms.AttendanceModuleForm;
import com.itech.iERP.forms.LeaveModuleForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.RoleForm;
import com.itech.iERP.handler.LeaveModuleHandler;
import com.itech.iERP.utils.FuctionMailClass;
import com.itech.iERP.utils.Util;

public class LeaveModuleAction extends BaseAction
{
	LeaveModuleHandler handler = new LeaveModuleHandler();
	public ActionForward leaveRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("Leave Request Module");
		HttpSession session = request.getSession();
        long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
        System.out.println("session userid "+userid);
        String approver=handler.getApprover(getDataSource(request),userid);
        request.setAttribute("approver", approver);
        System.out.println("approver "+approver);
        List<LeaveModuleForm> userList = handler.listEmp(getDataSource(request));
    	request.setAttribute("userList",userList);
    	System.out.println(userList);
		return mapping.findForward("leave");
	}
	
	public ActionForward leaveRequest1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		HttpSession session = request.getSession();
        long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
		long diffInMillisec=0;
        long diffInDays=0;
        Timestamp ftimets = null;
		Timestamp ttimets = null;
		System.out.println("Hi "+leavemoduleform.getfDate());
		System.out.println(leavemoduleform.gettDate());
		System.out.println("Leave Request Module");
		try
		{
		String dt = leavemoduleform.getfDate().substring(0,10);
		String dateParts[]=dt.split("/");
		String day = dateParts[0];
		String month = dateParts[1];
		String year = dateParts[2];
		String allfiles = null;
		String allfiles1 = null;
		String allfiles2 = null;
		String allfiles3 = null;
		String allfiles4 = null;
		String allfiles5 = null;
		String allfiles6 = null;
		
		String dt1 = leavemoduleform.gettDate().substring(0, 10);
		String dateParts1[] = dt1.split("/");
		String day1 = dateParts1[0];
		String month1 =dateParts1[1];
		String year1=dateParts1[2];
		
		Calendar firstDate =null;
        Calendar secondDate =null;
        firstDate = Calendar.getInstance();
        secondDate = Calendar.getInstance();
        firstDate.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        secondDate.set(Integer.parseInt(year1), Integer.parseInt(month1), Integer.parseInt(day1));
        diffInMillisec = secondDate.getTimeInMillis() - firstDate.getTimeInMillis();
        diffInDays = diffInMillisec / (24 * 60 * 60 * 1000); 
        diffInDays=diffInDays+1;
        request.setAttribute("diff",diffInDays);
       
       List<LeaveModuleForm> userList = handler.listEmp(getDataSource(request));
 	   request.setAttribute("userList",userList);
 	   
		String ftime = request.getParameter("fDate").trim();
		   System.out.println("Before Timestamp "+ftime);
		   DateFormat fformatter = new SimpleDateFormat("dd/MM/yyyy");
		   java.util.Date fdate = (java.util.Date) fformatter.parse(ftime);
		   ftimets = new Timestamp(fdate.getTime());
		   System.out.println(ftimets);
		   
		   String ttime = request.getParameter("tDate").trim();
		   System.out.println("Before timestamp "+ttime);
		   DateFormat tformatter = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date tdate = (java.util.Date) tformatter.parse(ttime);
			ttimets = new Timestamp(tdate.getTime());
			int approverId=handler.getApproverid(getDataSource(request),userid);
			String approver=handler.getApprover(getDataSource(request),userid);
	        request.setAttribute("approver", approver);
	        
	        //Retrieving multiple photo's and name.
	        
	        FormFile file1 = leavemoduleform.getDoc1();
	        String fname1 = file1.getFileName();
	        System.out.println("fname1 "+fname1);
	        
	        FormFile file2 = leavemoduleform.getDoc2();
	        String fname2 = file2.getFileName();
	        
	        FormFile file3 = leavemoduleform.getDoc3();
	        String fname3 = file3.getFileName();
	        
	        FormFile file4 = leavemoduleform.getDoc4();
	        String fname4 = file4.getFileName();
	        
	        FormFile file5 = leavemoduleform.getDoc5();
	        String fname5 = file5.getFileName();
	        
	        FormFile file6 = leavemoduleform.getDoc6();
	        String fname6 = file6.getFileName();
	        
//	        ArrayList<FormFile> filenames = new ArrayList<FormFile>();
//	        filenames.add(file1);
	        
	        if(!fname1.equals(" ") && !fname1.equals(null) && fname1.length() != 0)
            {
               allfiles1 = userid+fname1;
               System.out.println("all file 1 "+allfiles1);
            }    
	        else
	        {
	        	allfiles1 = " ";
	        }
	        //Concatenate all files along with the userid, store "," seperated values in database
	        
	        if(!fname2.equals(" ") && !fname2.equals(null) && fname2.length() != 0)
            {
               allfiles2 = userid+fname2;
            }    
	        else
	        {
	        	allfiles2 = " ";
	        }
	        
	        if(!fname3.equals(" ") && !fname3.equals(null) && fname3.length() != 0)
            {
               allfiles3 = userid+fname3;
            }    
	        else
	        {
	        	allfiles3 = " ";
	        }
	        
	        if(!fname4.equals(" ") && !fname4.equals(null) && fname4.length() != 0)
            {
               allfiles4 = userid+fname4;
            }    
	        else
	        {
	        	allfiles4 = " ";
	        }
	        
	        if(!fname5.equals(" ") && !fname5.equals(null) && fname5.length() != 0)
            {
               allfiles5 = userid+fname5;
            }    
	        else
	        {
	        	allfiles5 = " ";
	        }
	        
	        if(!fname6.equals(" ") && !fname6.equals(null) && fname6.length() != 0)
            {
               allfiles6 = userid+fname6;
            }    
	        else
	        {
	        	allfiles6 = " ";
	        }
	        
	        
	      
	        allfiles = allfiles1+","+allfiles2+","+allfiles3+","+allfiles4+","+allfiles5+","+allfiles6;
	     
	 
            
            String filepath = getServlet().getServletContext().getRealPath("/")
    		+ "leavedocs";

            if(file1 != null)
            {
            Util.audioFolder(file1, filepath, userid+fname1);
            }
            if(file2 != null)
            {
            Util.audioFolder(file2, filepath, userid+fname2);
            }
            if(file3 != null)
            {
            Util.audioFolder(file3, filepath, userid+fname3);
            }
            if(file4 != null)
            {
            Util.audioFolder(file4, filepath, userid+fname4);
            }
            if(file5 != null)
            {
            Util.audioFolder(file5, filepath, userid+fname5);
            }
            if(!file6.equals(" ") || !file6.equals(null))
            {
            Util.audioFolder(file6, filepath, userid+fname6);
            }          
            
          
                 
	        request.setAttribute("status",handler.addRole(leavemoduleform,ftimets,ttimets,userid,approverId,allfiles,getDataSource(request)));
 	        String mailId = handler.getApproverMailId(getDataSource(request),approverId);
 	        System.out.println("Approver mail id " +mailId);
 	        
 	        String mailId1 = handler.getNotifyMailId(getDataSource(request),leavemoduleform.getUserId1());
 	        System.out.println("Notify mail id1 "+mailId1);
 	        
 	        String name = handler.name(getDataSource(request),userid);
 	        System.out.println("name is "+ name);
 	      
			String toAddress="vani@itechsolutions.in";
			try
			{
			   String subject = "Leave Application ";
			   String message = "Hi, this mail from iERP Web Application : Mr. & Mrs. "+name + " Applied leave from "+leavemoduleform.getfDate().substring(1,10)+" to "+leavemoduleform.gettDate().substring(1, 10)+ " Reason is  "+leavemoduleform.getReason();
			   try
			   {
				   FuctionMailClass mailClient = new FuctionMailClass();
				   mailClient.postMail(new String[] { mailId }, subject, message,
							toAddress);
				   mailClient.postMail(new String[] { mailId1 }, subject, message,
							toAddress);
			   }
			   catch (Exception e)
			   {
				 System.out.println(e);			
			   }
			   }
			catch (Exception e) 
			{
				System.out.println(e);
			}
 	 
		}
		catch (NumberFormatException e) 
		{
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
        catch (NullPointerException e) 
        {
			// TODO: handle exception
        	e.printStackTrace();
		}
        return mapping.findForward("leave");
	}
	
	public ActionForward fetchLeaveRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("Inside the fetch leave request method");
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		HttpSession session = request.getSession();
        long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
        List<LeaveModuleForm> leaveApproval = handler.leaveRequests(userid,getDataSource(request));
        request.setAttribute("leaveApproval", leaveApproval);
        System.out.println("Leaveapprovallist "+leaveApproval);
		return mapping.findForward("approval");
	}
	public ActionForward changestatus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("inside the change status method");
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		//roleForm.setRoleid(Integer.parseInt(request.getParameter("roleid")));
		int l = 0;
		String m = null;
		try
		{
		    l=Integer.parseInt(request.getParameter("leaveAppId"));
		    m = (request.getParameter("leaveAppId"));
		    System.out.println("m value "+m);
			System.out.println("l value "+l);
		}
		catch (NumberFormatException e) 
		{
		  e.printStackTrace();
		}
	
		request.setAttribute("status",handler.changeRole(l,leavemoduleform, getDataSource(request)));
		return fetchLeaveRequest(mapping, form, request, response);
		//return mapping.findForward("approval");
	}
	public ActionForward changestatus1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		try
		{
		int l =0;
		l=Integer.parseInt(request.getParameter("id"));
		
	    request.getParameter("rejection");
	    System.out.println(request.getParameter("rejection"));
	    System.out.println(leavemoduleform.getRejection());
		request.setAttribute("status",handler.changeRole1(l,leavemoduleform, getDataSource(request)));
		System.out.println("l value "+l);
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		return fetchLeaveRequest(mapping, form, request, response);
		//return mapping.findForward("approval");
	}
	
	public ActionForward leavestatus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("inside the leave status method");
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		HttpSession session = request.getSession();
        long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
        String username=((LoginForm)session.getAttribute("userDetail")).getUsername();
        request.setAttribute("username",username);
        int bal = handler.listbal(getDataSource(request),userid);
        if(bal>=20)
        {
        	bal=0;
        }
        else
        {
        	bal=bal;
        }
        
        request.setAttribute("bal",bal);
        int bal1 = handler.listbal(getDataSource(request),userid);
        request.setAttribute("bal1",bal1);
		
        int app = handler.listapp(getDataSource(request),userid);
        request.setAttribute("app",app);
        
        int rej = handler.listrej(getDataSource(request),userid);
        request.setAttribute("rej",rej);
        
		return mapping.findForward("status");
	}
	public ActionForward reports(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("inside the reports module");
		List<LeaveModuleForm> userList = handler.listEmp(getDataSource(request));
		request.setAttribute("userList",userList);
    	System.out.println(userList);
		
    	List<LeaveModuleForm> userList1 = handler.listEmp1(getDataSource(request));
		request.setAttribute("userList1",userList1);
    	System.out.println(userList1);
    	
		return mapping.findForward("reports");
	}
	
	public ActionForward leavereports(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		  Timestamp ftimets = null;
		  Timestamp ttimets = null;
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		List<LeaveModuleForm> userList = handler.listEmp(getDataSource(request));
		request.setAttribute("userList",userList);
		List<LeaveModuleForm> userList1 = handler.listEmp1(getDataSource(request));
		request.setAttribute("userList1",userList1);
		 if(!request.getParameter("fDate").equals("")&& !request.getParameter("tDate").equals(""))
		   {
			   String ftime = request.getParameter("fDate").trim();
			   System.out.println("Before Timestamp "+ftime);
			   DateFormat fformatter = new SimpleDateFormat("dd/MM/yyyy");
			   java.util.Date fdate = (java.util.Date) fformatter.parse(ftime);
			   ftimets = new Timestamp(fdate.getTime());
			   
			   String ttime = request.getParameter("tDate").trim();
			    System.out.println("Before timestamp "+ttime);
			    DateFormat tformatter = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date tdate = (java.util.Date) tformatter.parse(ttime);
				ttimets = new Timestamp(tdate.getTime());
				System.out.println("datetimes=" + ftimets);
				System.out.println("datetimes1=" + ttimets);
				 List<LeaveModuleForm> AttList = handler.listLeaveList(ftimets,ttimets,leavemoduleform,getDataSource(request));
				 request.setAttribute("AttList",AttList);
				   System.out.println("AttList "+AttList);
				
		   } 
		 else
		 {
			 
			 List<LeaveModuleForm> AttList = handler.listLeaveList1(leavemoduleform,getDataSource(request));
			 request.setAttribute("AttList",AttList);
			 System.out.println("AttList1 "+AttList);
		 }
		return mapping.findForward("reports");
	}
	public ActionForward leaveHistory(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("Inside the history method ");
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		HttpSession session = request.getSession();
        long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
		
		String username=((LoginForm)session.getAttribute("userDetail")).getUsername();
		List<LeaveModuleForm> Atthist = handler.listLeaveHist(userid,username,getDataSource(request));
		request.setAttribute("AttList",Atthist);	
		return mapping.findForward("history");
	}
	
	public ActionForward download1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = leavemoduleform.getDocname1();
		//file1 = leavemoduleform.getDocname2();
		
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
        	String filename1 = getServlet().getServletContext().getRealPath("\\")+"leavedocs\\"+file1;
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
	
	public ActionForward download2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = leavemoduleform.getDocname2();
		//file1 = leavemoduleform.getDocname2();
		
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
        	String filename1 = getServlet().getServletContext().getRealPath("\\")+"leavedocs\\"+file1;
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
	
	public ActionForward download3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = leavemoduleform.getDocname3();
		//file1 = leavemoduleform.getDocname2();
		
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
        	String filename1 = getServlet().getServletContext().getRealPath("\\")+"leavedocs\\"+file1;
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
	
	public ActionForward download4(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = leavemoduleform.getDocname4();
		//file1 = leavemoduleform.getDocname2();
		
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
        	String filename1 = getServlet().getServletContext().getRealPath("\\")+"leavedocs\\"+file1;
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
	
	public ActionForward download5(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = leavemoduleform.getDocname5();
		//file1 = leavemoduleform.getDocname2();
		
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
        	String filename1 = getServlet().getServletContext().getRealPath("\\")+"leavedocs\\"+file1;
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
	
	public ActionForward download6(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		
		LeaveModuleForm leavemoduleform = (LeaveModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = leavemoduleform.getDocname6();
		//file1 = leavemoduleform.getDocname2();
		
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
        	String filename1 = getServlet().getServletContext().getRealPath("\\")+"leavedocs\\"+file1;
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
