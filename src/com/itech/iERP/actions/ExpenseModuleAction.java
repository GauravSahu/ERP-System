package com.itech.iERP.actions;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.itech.iERP.forms.ExpenseModuleForm;
import com.itech.iERP.forms.LeaveModuleForm;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.handler.ExpenseModuleHandler;
import com.itech.iERP.utils.Util;

public class ExpenseModuleAction extends BaseAction 
{
	ExpenseModuleHandler handler =  new ExpenseModuleHandler();
  public ActionForward req(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  System.out.println("inside the req method");
	  List<ExpenseModuleForm> expenseList = handler.expenseList(getDataSource(request));
	  request.setAttribute("expenseList",expenseList);
	  System.out.println(expenseList);
		HttpSession session = request.getSession();
        long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
        System.out.println("session userid "+userid);
        String approver=handler.getApprover(getDataSource(request),userid);
        request.setAttribute("approver", approver);
        System.out.println("approver "+approver);
	  return mapping.findForward("request");
  }
  
  public ActionForward expreq(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  System.out.println("inside the expense request method ");
	  List<ExpenseModuleForm> expenseList = handler.expenseList(getDataSource(request));
	  request.setAttribute("expenseList",expenseList);
	  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
	  HttpSession session = request.getSession();
	  Timestamp ftimets = null;
      long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
      String approver=handler.getApprover(getDataSource(request),userid);
      request.setAttribute("approver", approver);
      System.out.println("approver "+approver);
      FormFile file1 = expMod.getDoc1();
      String fname1 = file1.getFileName();
  	String allfiles = null;
	String allfiles1 = null;
	String allfiles2 = null;
	String allfiles3 = null;
	String allfiles4 = null;
	String allfiles5 = null;
	String allfiles6 = null;
      System.out.println("fname1 "+fname1);
      
      FormFile file2 = expMod.getDoc2();
      String fname2 = file2.getFileName();
      
      FormFile file3 = expMod.getDoc3();
      String fname3 = file3.getFileName();
      
      FormFile file4 = expMod.getDoc4();
      String fname4 = file4.getFileName();
      
      FormFile file5 = expMod.getDoc5();
      String fname5 = file5.getFileName();
      
      FormFile file6 = expMod.getDoc6();
      String fname6 = file6.getFileName();
      
//      ArrayList<FormFile> filenames = new ArrayList<FormFile>();
//      filenames.add(file1);
      
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
		+ "expdocs";

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
      
	  int approverId=handler.getApproverid(getDataSource(request),userid);
	  System.out.println("Approver Id "+approverId);
	  System.out.println(expMod.getfDate());
	  System.out.println(expMod.getExpenseid1());
	  System.out.println(expMod.getFirstName());
	  System.out.println(expMod.getReason());
	  System.out.println(expMod.getAmount());
	  String ftime = request.getParameter("fDate").trim();
	   System.out.println("Before Timestamp "+ftime);
	   DateFormat fformatter = new SimpleDateFormat("dd/MM/yyyy");
	   java.util.Date fdate = (java.util.Date) fformatter.parse(ftime);
	   ftimets = new Timestamp(fdate.getTime());
	   System.out.println(ftimets);
	   request.setAttribute("status",handler.addRole(expMod, ftimets,userid,approverId,allfiles,getDataSource(request)));
	  return mapping.findForward("request");
  }
 
  public ActionForward expeAppr(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
  {
	  System.out.println("inside the expense approve method");
	  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
	  HttpSession session = request.getSession();
      long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
      List<ExpenseModuleForm> ExpenseApproval = handler.expensearrove(userid,getDataSource(request));
      request.setAttribute("ExpenseApproval", ExpenseApproval);
      System.out.println("Expense Approval "+ExpenseApproval);
	  return mapping.findForward("approve");
  }
  
  public ActionForward changestatus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception
	{
	  System.out.println("inside the change status method");
	  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
	  int l =0;
	  l=Integer.parseInt(request.getParameter("expenseid"));
	  System.out.println("l value "+l);
	  request.setAttribute("status",handler.changeexp(l,expMod, getDataSource(request)));
	  return expeAppr(mapping, form, request, response);
	}
  public ActionForward changestatus1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception
	{
	  System.out.println("Inside the change status 1 method ");
	  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
	  try
		{
		int l =0;
		l=Integer.parseInt(request.getParameter("id"));
		
	    request.getParameter("rejection");
	    System.out.println(request.getParameter("rejection"));
	    System.out.println(expMod.getRejection());
		request.setAttribute("status",handler.changeRej(l,expMod, getDataSource(request)));
		System.out.println("l value "+l);
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		return expeAppr(mapping, form, request, response);
	
	}
  
  public ActionForward expensestatus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception
	{
	  System.out.println("inside the expense status method ");
	  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
	  HttpSession session = request.getSession();
      long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
      String username=((LoginForm)session.getAttribute("userDetail")).getUsername();
      System.out.println(username);
      
      String name = handler.name(getDataSource(request),userid);
       System.out.println("name is "+ name);
       request.setAttribute("name", name);
      List<ExpenseModuleForm> ExpenseApproval1 = handler.expensestatus(userid,getDataSource(request));
      request.setAttribute("ExpenseApproval1", ExpenseApproval1);
      System.out.println("Expense Approval1 "+ExpenseApproval1);
	  return mapping.findForward("status");
	}
  public ActionForward reports(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	  System.out.println("Inside the reports module");
	  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
	  List<ExpenseModuleForm> userList = handler.listEmp(getDataSource(request));
		request.setAttribute("userList",userList);
  	System.out.println(userList);
		
  	List<ExpenseModuleForm> userList1 = handler.listEmp1(getDataSource(request));
		request.setAttribute("userList1",userList1);
  	System.out.println(userList1);
	  return mapping.findForward("reports");
	}
  public ActionForward reports1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
  {
	  Timestamp ftimets = null;
		Timestamp ttimets = null;
		 HttpSession session = request.getSession();
	      long userid = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	  System.out.println("This is to generate the reports");
	  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
	  List<ExpenseModuleForm> userList = handler.listEmp(getDataSource(request));
		request.setAttribute("userList",userList);
  	System.out.println(userList);
		
  	List<ExpenseModuleForm> userList1 = handler.listEmp1(getDataSource(request));
		request.setAttribute("userList1",userList1);
  	System.out.println(userList1);
  	
  	if(!request.getParameter("fDate").equals("")&& !request.getParameter("tDate").equals(""))
	   {
  		   
		   String ftime = request.getParameter("fDate").trim();
		   System.out.println("Before Timestamp "+ftime);
		   DateFormat fformatter = new SimpleDateFormat("dd/MM/yyyy");
		   java.util.Date fdate = (java.util.Date) fformatter.parse(ftime);
		   ftimets = new Timestamp(fdate.getTime());
		   String name = handler.name(getDataSource(request),userid);
	       System.out.println("name is "+ name);
	       request.setAttribute("name", name);
		   String ttime = request.getParameter("tDate").trim();
		    System.out.println("Before timestamp "+ttime);
		    DateFormat tformatter = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date tdate = (java.util.Date) tformatter.parse(ttime);
			ttimets = new Timestamp(tdate.getTime());
			System.out.println("datetimes=" + ftimets);
			System.out.println("datetimes1=" + ttimets);
			List<ExpenseModuleForm> AttList = handler.listLeaveList(ftimets,ttimets,expMod,getDataSource(request));
			request.setAttribute("AttList",AttList);
			System.out.println("AttList "+AttList);
			
	   } 
	 else
	 {
		 String name = handler.name(getDataSource(request),userid);
	       System.out.println("name is "+ name);
	       request.setAttribute("name", name);
		 List<ExpenseModuleForm> AttList = handler.listLeaveList1(expMod,getDataSource(request));
		 request.setAttribute("AttList",AttList);
		 System.out.println("AttList1 "+AttList);
	 }
	  return mapping.findForward("reports");
  }
  
  public ActionForward download1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		
	  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = expMod.getDocname1();
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
      	String filename1 = getServlet().getServletContext().getRealPath("\\")+"expdocs\\"+file1;
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
		
		  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = expMod.getDocname2();
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
      	String filename1 = getServlet().getServletContext().getRealPath("\\")+"expdocs\\"+file1;
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
		
		  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = expMod.getDocname3();
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
      	String filename1 = getServlet().getServletContext().getRealPath("\\")+"expdocs\\"+file1;
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
		
		  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = expMod.getDocname4();
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
      	String filename1 = getServlet().getServletContext().getRealPath("\\")+"expdocs\\"+file1;
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
		
		  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = expMod.getDocname5();
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
      	String filename1 = getServlet().getServletContext().getRealPath("\\")+"expdocs\\"+file1;
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
		
		  ExpenseModuleForm expMod =(ExpenseModuleForm)form;
		System.out.println("file ownload inside the leavemoduleaction ");
		String file1 = expMod.getDocname6();
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
      	String filename1 = getServlet().getServletContext().getRealPath("\\")+"expdocs\\"+file1;
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
