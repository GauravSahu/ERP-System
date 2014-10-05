package com.itech.iERP.actions;


import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.PayslipForm;
import com.itech.iERP.handler.PayslipHandler;

public class PayslipAction extends BaseAction
{
	PayslipHandler handler = new PayslipHandler();
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
	    long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		System.out.println("Inside the payslip action list method"+userid);
		List<PayslipForm> userList = handler.listEmp(userid,getDataSource(request));
		request.setAttribute("userList",userList);
	    return mapping.findForward("setting");
	}
	
	public ActionForward userName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		PayslipForm payslip = (PayslipForm)form;
		HttpSession session = request.getSession();
	    long userid = ((LoginForm) session.getAttribute("userDetail")).getCompany();
		List<PayslipForm> userList = handler.listEmp(userid,getDataSource(request));
	    request.setAttribute("userList",userList);
	    
	    List<PayslipForm> componentList = handler.listcomp(userid,getDataSource(request));
	    request.setAttribute("componentList",componentList);
	    
	    System.out.println("Component List "+componentList);
	    long userid1 = ((LoginForm) session.getAttribute("userDetail")).getUserId();
	    System.out.println("Compid "+userid1);
	    List<PayslipForm> userinfo = handler.listuseinfo(userid1,getDataSource(request));
	    request.setAttribute("userinfo",userinfo);
	    System.out.println("userinfo "+userinfo);
	   // List<PayslipForm> salaryset = handler.listuseinfo(userid1,getDataSource(request));
	    
	    System.out.println("userid selected "+payslip.getUserId());
	    session.setAttribute("id1", payslip.getUserId());
	    System.out.println("entered CTC : "+payslip.getCtc());
	    session.setAttribute("ctc", payslip.getCtc());
	    List<PayslipForm> salarysave = handler.salarysave(payslip,userid,getDataSource(request));
	    request.setAttribute("salarysave",salarysave);
	    System.out.println("salarysave "+salarysave);
		return mapping.findForward("salAllo");
	}
	
	public ActionForward savesalary(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		PayslipForm payslip = (PayslipForm)form;
		HttpSession session = request.getSession();
		long userid = ((LoginForm) session.getAttribute("userDetail")).getCompany();
		request.setAttribute("status",handler.addRole(session.getAttribute("ctc"),session.getAttribute("id1"),payslip,userid, getDataSource(request)));
		return mapping.findForward("setting2");
	}
	
	public ActionForward setsalary(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return mapping.findForward("setsalry");
	}
	
	public ActionForward salarymod(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		 long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		 PayslipForm payslip = (PayslipForm)form;
		 List<PayslipForm> modsalary = handler.modsalary(payslip,getDataSource(request));
		 request.setAttribute("modsalary",modsalary);
		 return mapping.findForward("modsalary");
	}
	
	public ActionForward savefinalsal(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		
		PayslipForm payslip = (PayslipForm)form;
		try
		{
		String[] sal= request.getParameterValues("userId");
	
		String[] da = request.getParameterValues("da");
		String[] pa = request.getParameterValues("pa");
		String[] oa = request.getParameterValues("oa");
		String[] lb = request.getParameterValues("lb");
		String[] pt = request.getParameterValues("pt");
		String[] sp = request.getParameterValues("salarypay");
		String[] basic = request.getParameterValues("basic");
		List<PayslipForm> modsalary = handler.modsalary(payslip,getDataSource(request));
		request.setAttribute("modsalary",modsalary);
		
		for(int i=0;i<sal.length;i++)
		{
			
			long compid = ((LoginForm) session.getAttribute("userDetail")).getCompany();
			long userid = ((LoginForm)session.getAttribute("userDetail")).getUserId();
			String status = handler.addfinsalary(payslip,userid,session.getAttribute("ctc"),session.getAttribute("id1"),compid,sal[i],basic[i],da[i],pa[i],oa[i],lb[i],pt[i],sp[i],getDataSource(request));
			request.setAttribute("status",status);
		}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}		
		return mapping.findForward("");
	}
//	public ActionForward postsalary(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
//	{	
//		List<PayslipForm> userList = handler.listEmp(getDataSource(request));
//		request.setAttribute("userList1",userList);
//		List<PayslipForm> userList1 = handler.listEmp1(getDataSource(request));
//		request.setAttribute("userList2",userList1);
//		return mapping.findForward("postsalry");
//	}
	
	public ActionForward generatePayslip(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		try
		{
		PayslipForm payform = (PayslipForm)form;
		String mon= payform.getMonth1();
		String yr = payform.getYear1();
		String uid = payform.getUserId1();
		PayslipForm payslip = handler.genePayslip(payform,mon,yr,uid,getDataSource(request));
		int pt = payslip.getPt();
	
		String pdf = handler.printpdf(payslip,pt,getDataSource(request));
		request.setAttribute("status", pdf);
		
		}
		catch (NullPointerException e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return mapping.findForward("payslip");
	}
	
//	public ActionForward generatePayslip1(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
//	{
//		List<PayslipForm> userList = handler.listEmp(getDataSource(request));
//		request.setAttribute("userList1",userList);
//		List<PayslipForm> userList1 = handler.listEmp1(getDataSource(request));
//		request.setAttribute("userList2",userList1);
//		return mapping.findForward("postsalry");
//	}
	
	public ActionForward salacknowledgement(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("inside the salary acknowledgement method ");
		
		return mapping.findForward("salack");
	}
	
	public ActionForward jsalset(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("Inside the j sal setting");
		HttpSession session = request.getSession();
	    long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		System.out.println("Inside the payslip action list method"+userid);
		List<PayslipForm> userList = handler.listEmp(userid,getDataSource(request));
		request.setAttribute("userList",userList);
		List<PayslipForm> complist = handler.listallcomponent(userid,getDataSource(request));
	    System.out.println(complist);
	    
	    request.setAttribute("complist",complist);
		return mapping.findForward("jsalsett");
	}
	
	public ActionForward savesalaries(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("inside the save salary method");
		HttpSession session = request.getSession();
	    long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		PayslipForm payform = (PayslipForm)form;
		List<PayslipForm> userList = handler.listEmp(userid,getDataSource(request));
		request.setAttribute("userList",userList);
		List<PayslipForm> complist = handler.listallcomponent(userid,getDataSource(request));
	    System.out.println(complist);
	    request.setAttribute("complist",complist);
	    String componentname[] = request.getParameterValues("componentName");
	    String componentid[]=request.getParameterValues("componentid");
	    System.out.println("first........."+componentid);
	    String comp[]=request.getParameterValues("componentid");
	    String value[] = request.getParameterValues("value");
	    String componenttype[]=request.getParameterValues("componenttype");
	    
	    for(int i =0,j=0;i<componentname.length;i++,j++)
	    {
	    	
	    	System.out.println("inside for loop "+request.getParameterValues("componentid"));
	    	System.out.println("new "+comp[i]);
	    	String status=handler.savesalaries(userid,componentname[i],componentid[i],value[i],componenttype[i],payform,getDataSource(request));
	    	request.setAttribute("status",status);
	    }
		return mapping.findForward("jsalsett");
	}
	
	public ActionForward postfinalsalary(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("inside the post final salry method ");
		PayslipForm payform = (PayslipForm)form;
		HttpSession session = request.getSession();
	    long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		List<PayslipForm> complist = handler.listallcomponent(userid,getDataSource(request));
		 request.setAttribute("complist",complist);
		 
		 //List<PayslipForm> userIdList = handler.listallUserIds(userid,getDataSource(request));
		 //request.setAttribute("userIdList", userIdList);
		// request.setAttribute("complist",complist);
		 String month = payform.getMonth1();
		 String year = payform.getYear1();
		 System.out.println("++++++++++++++++++++  ....."+month+" "+year);
		 List<PayslipForm> userList = handler.listEmp(userid,getDataSource(request));
    	 request.setAttribute("userList1",userList);
    	 System.out.println(userList);
    	 List<PayslipForm> userList1 = handler.listEmp1(userid,getDataSource(request));
   	     request.setAttribute("userList2",userList1);
   	   
   	  List<PayslipForm> componentwithvalues = handler.componentwithvaluesforemployees(userid,month,year,payform,getDataSource(request));
      request.setAttribute("componentwithvalues",componentwithvalues);
	 System.out.println("component with values"+ componentwithvalues);
		return mapping.findForward("postfinalsalaryjain");
	}
	
	public ActionForward savefinalsalary(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		try
		{
		System.out.println("inside the savefinalsary method ");
		HttpSession session = request.getSession();
		long userid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		PayslipForm payform = (PayslipForm)form;
		List<PayslipForm> complist = handler.listallcomponent(userid,getDataSource(request));
		 request.setAttribute("complist",complist);
		List<PayslipForm> compvalues = handler.listAllComponentValues(userid,request,getDataSource(request));
	    request.setAttribute("compvalues",compvalues);
	  //  System.out.println("component Size "+complist.size());
	    String value[] = request.getParameterValues("value");
	    String[] compo = new String[complist.size()] ;
	    String[] values = new String[compvalues.size()];
	   // System.out.println("is it converted "+complist);
	 // String uniqueuserid1 = request.getParameter("uniqueuserid");
	   //System.out.println("uvhbf"+uniqueuserid1);
	   // Iterator<PayslipForm> it = complist.iterator();
	        System.out.println("dsff"+compvalues.toString());
	        System.out.println("33443"+compvalues.toArray().toString() );
	        String mon= null;
			String yr = null; 
	    	String uniqueuserid = null;
	        
	        int i = 0;
	        for (PayslipForm payslipForm : compvalues)
	        {
				
			System.out.println("compp"+payslipForm.getComponentName());
			System.out.println("vallllll"+payslipForm.getValue());
	        compo[i] = payslipForm.getComponentName();
	        values[i] = payslipForm.getValue();
	        i++;
	    	 mon= payform.getMonth1();
			 yr = payform.getYear1(); 
	    	 uniqueuserid = request.getParameter("uniqueuserid");
	    	
	    	System.out.println("uniqueuserid "+uniqueuserid);
	    	
	        
	        }
	        
	      String status=handler.savesalariesjain(userid,uniqueuserid,mon,yr,compo,values,getDataSource(request));
	      request.setAttribute("status",status);
	        
	        System.out.println(Arrays.asList(compo));
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return mapping.findForward("postfinalsalaryjain");
	}
	
	
	/*public ActionForward savesalarywithcomponent(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		PayslipForm payform = (PayslipForm)form;
		HttpSession session = request.getSession();
		 long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
	List<PayslipForm> userList = handler.listEmp(userid,getDataSource(request));
  	   request.setAttribute("userList1",userList);
  	   System.out.println(userList);
  	   List<PayslipForm> userList1 = handler.listEmp1(userid,getDataSource(request));
 	       request.setAttribute("userList2",userList1);
	   
 	      List<PayslipForm> complist = handler.listallcomponent(userid,getDataSource(request));
 		  System.out.println(complist);
 		  request.setAttribute("complist",complist);   
	      String month = payform.getMonth1();
		  String year = payform.getYear1();
		 
		 System.out.println(month+" "+year);
		 System.out.println("first"+payform.getUserId1());
		 System.out.println("second"+payform.getUserId2());
		 
		 List<PayslipForm> componentwithvalues = handler.componentwithvaluesforemployees(userid,payform,getDataSource(request));
	       request.setAttribute("componentwithvalues",componentwithvalues);
		 System.out.println("component with values"+ componentwithvalues);
			return mapping.findForward("salarysettingwithcomponent");
	}*/
	
	public ActionForward postsalry(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("its about posting a salry to employees ");
		PayslipForm payform = (PayslipForm)form;
		HttpSession session = request.getSession();
	    long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		List<PayslipForm> complist = handler.listallcomponent(userid,getDataSource(request));
		request.setAttribute("complist",complist);
		 
		 String month = payform.getMonth();
		 String year = payform.getYear1();
		 System.out.println("+++++++++++++++++"+month+" "+year+"-----------");
		 List<PayslipForm> userList = handler.listEmp(userid,getDataSource(request));
    	 request.setAttribute("userList1",userList);
    	 System.out.println(userList);
    	 List<PayslipForm> userList1 = handler.listEmp1(userid,getDataSource(request));
   	     request.setAttribute("userList2",userList1);
   	   
      	  List<PayslipForm> componentwithvalues = handler.componentwithvaluesforemployees(userid,month,year,payform,getDataSource(request));
      request.setAttribute("componentwithvalues",componentwithvalues);
	 System.out.println("component with values"+ componentwithvalues);
	 
	 String componentname[] = request.getParameterValues("componentName");
	    String componentid[]=request.getParameterValues("componentid");
	    System.out.println("first........."+componentid);
	    String comp[]=request.getParameterValues("componentid");
	    String value[] = request.getParameterValues("value");
	    String componenttype[]=request.getParameterValues("componenttype");
	    
	    for(int i =0,j=0;i<componentname.length;i++,j++)
	    {
	    	System.out.println("inside for loop "+request.getParameterValues("componentid"));
	    	System.out.println("new "+comp[i]);
	    	System.out.println("mmmmmmmmm+++++++"+month);
	    	String status=handler.postsalaries(year,month,userid,componentname[i],componentid[i],value[i],componenttype[i],payform,getDataSource(request));
	    	request.setAttribute("status",status);
	    }
		
		return mapping .findForward("postfinalsalaryjain");
	}
	
	public ActionForward generatepayslip(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("inside the generate payslip method ");
		return mapping.findForward("payslip");
	}
	
	public ActionForward viewPayslip(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		
		System.out.println("inside the view payslip method");
		PayslipForm payform = (PayslipForm)form;
		HttpSession session = request.getSession();
		long compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
		long userid = ((LoginForm)session.getAttribute("userDetail")).getUserId();
		String month = payform.getMonth1();
		String year = payform.getYear1();
		int startrange = payform.getStartrange();
		int endrange = payform.getEndrange();
		System.out.println("cccccc"+compid+"uuuuuuuu"+userid);
		System.out.println("mmmmmmm"+month+"yyyyyy"+year);
		
    	//List<PayslipForm> viewpayslipcomponent = handler.componentforpayslip(userid,compid,month,year,payform,request,getDataSource(request));
        //request.setAttribute("viewpayslipcomponent",viewpayslipcomponent);
        //System.out.println("vvfjkgfgfgfgf "+viewpayslipcomponent);
		
		String result = handler.generatepayslip(userid,compid,month,year,startrange,endrange,payform,request,getDataSource(request));
		request.setAttribute("result",result);
		session.setAttribute("compid",compid);
		
		return mapping.findForward("viewpayslip");
	}
	public ActionForward updateEmployeeSalary(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("inside the post final salry method ");
		PayslipForm payform = (PayslipForm)form;
		HttpSession session = request.getSession();
	    long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
	    List<PayslipForm> userList = handler.listEmp(userid,getDataSource(request));
   	    request.setAttribute("userList1",userList);
		return mapping.findForward("updatesalary");
	}
	
	public ActionForward updatesalaries(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("inside the update salaries method");
		PayslipForm payform = (PayslipForm)form;
		HttpSession session = request.getSession();
	    long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		List<PayslipForm> userList = handler.listEmp(userid,getDataSource(request));
	   	request.setAttribute("userList1",userList);
	   	List<PayslipForm> componentwithvalues = handler.listComponent(userid,payform,getDataSource(request));
	    request.setAttribute("componentwithvalues",componentwithvalues);
		System.out.println("component with values"+ componentwithvalues);
		return mapping.findForward("updatesalary");
	}
	
	public ActionForward updateSalary(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("inside the update salaries method");
		PayslipForm payform = (PayslipForm)form;
		HttpSession session = request.getSession();
	    long userid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		List<PayslipForm> userList = handler.listEmp(userid,getDataSource(request));
	   	request.setAttribute("userList1",userList);
	   	List<PayslipForm> componentwithvalues = handler.listComponent(userid,payform,getDataSource(request));
	    request.setAttribute("componentwithvalues",componentwithvalues);
		System.out.println("component with values"+ componentwithvalues);
		
		String componentname[] = request.getParameterValues("componentName");
	    String componentid[]=request.getParameterValues("componentid");
	    String comp[]=request.getParameterValues("componentid");
	    String value[] = request.getParameterValues("value");
	    String componenttype[]=request.getParameterValues("componenttype");
	    
	    for(int i =0,j=0;i<componentname.length;i++,j++)
	    {
	    
	    	String status=handler.updateSalary(userid,componentname[i],componentid[i],value[i],componenttype[i],payform,getDataSource(request));
	    	request.setAttribute("status",status);
	    }
		
		return mapping.findForward("updatesalary");
	}
	
	public ActionForward updategeneratesalary(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		System.out.println("inside the update and generate payslip method ");
		PayslipForm payform = (PayslipForm)form;
		HttpSession session = request.getSession();
		long compid = 0;
		long test = 0;
		try {
			test = ((LoginForm) session.getAttribute("userDetail")).getUserId();
			compid = ((LoginForm) session.getAttribute("userDetail")).getCompid();
		   }
		catch (NullPointerException e) {
			return mapping.findForward("session");
		}
		
		try
		{
			List<PayslipForm> fromUserlist = handler.fromUserList(compid,getDataSource(request));
			request.setAttribute("fromUserlist",fromUserlist);
			
			List<PayslipForm> toUserlist = handler.toUserList(compid,getDataSource(request));
			request.setAttribute("toUserlist",toUserlist);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	    return mapping.findForward("updategeneratesalary");	
	}
}
