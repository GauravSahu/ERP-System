package com.itech.iERP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import COM.rsa.jsafe.da;

import com.cete.dynamicpdf.text.m;
import com.itech.iERP.daoimpl.PayslipDaoImpl;
import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.forms.PayslipForm;

public class PayslipHandler 
{
    PayslipDaoImpl impl = new PayslipDaoImpl();
	public List<PayslipForm> listEmp(long userid, DataSource dataSource) 
	{
		
		return impl.listEmp(userid,dataSource);
	}
	public List<PayslipForm> listcomp(long userid, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listComp(userid,dataSource);
	}
	public List<PayslipForm> listuseinfo(long userid1, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listuseinfo(userid1,dataSource);
	}
	
	public List<PayslipForm> salarysave(PayslipForm payslip, long userid,
			DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.salarysave(payslip,userid,dataSource);
	    }
	public String addRole(Object attribute,Object attribute1,PayslipForm payslip, long userid,
			DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.addsal(attribute,attribute1,payslip,userid,dataSource);
	}
	public List<PayslipForm> modsalary(PayslipForm payslip,
			DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.modsalary(payslip,dataSource);
	}
	
	public String addfinsalary(PayslipForm payslip,long userid,Object ctc, Object id1,
			long compid,String sal, String basic, String da,
			String pa, String oa, String lb, String pt,String sp,
			DataSource dataSource)
	 {
		// TODO Auto-generated method stub
		return impl.addfinsalary(payslip,userid,ctc,id1,compid,sal,basic,da,pa,oa,lb,pt,sp,dataSource);
	}
	public List<PayslipForm> listEmp(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listComp(dataSource);
	}
	public List<PayslipForm> listEmp1(long userid,DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.listEmp2(userid,dataSource);
	}
	public String printpdf(DataSource ds) {
		return impl.printpdf(ds);
	}
	
	public PayslipForm genePayslip(PayslipForm payform, String mon, String yr,
			String uid, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.gePayslip(payform,mon,yr,uid,dataSource);
	}
	public String printpdf(PayslipForm payslip, int pt,DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.printpdf(payslip,pt,dataSource);
	}
	public List<PayslipForm> listcompallo(long userid, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.listcompallo(userid,dataSource);
	}
	public List<PayslipForm> listallcomponent(long userid, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.listallcomponent(userid,dataSource);
	}
	public String savesalaries(long userid, String componentname, String componentid,
			String value, String componenttype, PayslipForm payform,
			DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.savesalaries(userid,componentname, componentid,value,componenttype,payform,dataSource);
	}
	public List<PayslipForm> listAllComponentValues(long userid,
			HttpServletRequest request, DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.listAllComponentValues(userid,request,dataSource);
	}
	public String savesalariesjain(long userid, String uniqueuserid,
			String mon, String yr, String[] compo, String[] values,
			DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.savesalariesjain(userid, uniqueuserid, mon, yr, compo, values, dataSource);
	}
	public List<PayslipForm> listallUserIds(long userid, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.listallUserIds(userid, dataSource);
	}
	public List<PayslipForm> componentwithvalues(long userid,
			PayslipForm payform, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.componentwithvalues(userid,payform,dataSource);
	}
	public List<PayslipForm> componentwithvaluesforemployees(long userid,
			String month, String year, PayslipForm payform, DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.componentwithvaluesforemployees(userid,month,year,payform,dataSource);
	}
	public String postsalaries(String year, String month, long userid,
			String componentname, String componentid, String value, String componenttype,
			PayslipForm payform, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.postsalaries(year,month,userid,componentname,componentid,value,componenttype,payform,dataSource);
	}
//	public List<PayslipForm> componentforpayslip(long userid, long compid, String month,
//			String year, PayslipForm payform, HttpServletRequest request, DataSource dataSource) 
//	{
//		// TODO Auto-generated method stub
//		return impl.componentforpayslip(userid,compid,month,year,payform,request,dataSource);
//	}
	public String generatepayslip(long userid, long compid, String month,
			String year,int startrange,int endrange, PayslipForm payform, HttpServletRequest request,
			DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.generatepayslip(userid,compid,month,year,startrange,endrange,payform,request,dataSource);
	}
	public String postupdatedsalaries(String year, String month, long userid,
			String string, String string2, String string3, String string4,
			PayslipForm payform, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	public List<PayslipForm> listComponent(long userid, PayslipForm payform,
			DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.listComponent(userid,payform,dataSource);
	}
	public String updateSalary(long userid, String componentname, String componentid,
			String value, String componenttype, PayslipForm payform,
			DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.updateSalary(userid,componentname,componentid,value,componenttype,payform,dataSource);
	}
	public List<PayslipForm> fromUserList(long compid, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.fromUserList(compid,dataSource);
	}
	public List<PayslipForm> toUserList(long compid, DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.toUserList(compid,dataSource);
	}
	
	
	
	
	
}
