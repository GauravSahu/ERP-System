package com.itech.iERP.handler;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.SalesModuleDaoImpl;
import com.itech.iERP.forms.SalesModuleForm;

public class SalesModuleHandler
{
    SalesModuleDaoImpl impl = new SalesModuleDaoImpl();
	public String addEnquiry(SalesModuleForm salesmoduleform,long userid,DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.addEnquiry(salesmoduleform,userid,dataSource);
	}
	public List<SalesModuleForm> activeEnquiryList(DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.enquiryList(dataSource);
	}
	public List<SalesModuleForm> activeUserList(DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.userList(dataSource);
	}
	public String addFollowup(SalesModuleForm salesmoduleform, long userid,Timestamp ftimets,
			DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.addFollowup(salesmoduleform,userid,ftimets,dataSource);
	}
	public String addAppointment(SalesModuleForm salesmoduleform, long userid,
			Timestamp ftimets, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.addAppointment(salesmoduleform,userid,ftimets,dataSource);
	}
	public String saveQuotation(SalesModuleForm salesmoduleform, long userid,
			String fileName, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.saveQuotation(salesmoduleform,userid,fileName,dataSource);
	}
	public List<SalesModuleForm> activeEnquiryList1(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.enquiryList1(dataSource);
	}
	public List<SalesModuleForm> getenquiryreports(Timestamp ftimets,
			Timestamp ttimets, SalesModuleForm salesmodform,
			DataSource dataSource)
	{
		return impl.getenquiryreports(ftimets,ttimets,salesmodform,dataSource);
	}
	public List<SalesModuleForm> getenquiryrepsales(
			SalesModuleForm salesmodform, DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.getenquiryrepsales(salesmodform,dataSource);
	}
	public List<SalesModuleForm> getenquiryrepgen(SalesModuleForm salesmodform,
			DataSource dataSource) 
			{
		return impl.getenquiryrepgen(salesmodform,dataSource);
	}
	public List<SalesModuleForm> getfollowupreports(Timestamp ftimets,
			Timestamp ttimets, SalesModuleForm salesmodform,
			DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.getfollowupreports(ftimets,ttimets,salesmodform,dataSource);
	}
	public List<SalesModuleForm> getfollowuprepsales(
			SalesModuleForm salesmodform, DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.getfollowuprepsales(salesmodform,dataSource);
	}
	public List<SalesModuleForm> getfollowuprepgen(
			SalesModuleForm salesmodform, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.getfollowuprepgen(salesmodform,dataSource);
	}
	public List<SalesModuleForm> getquotationreports(Timestamp ftimets,
			Timestamp ttimets, SalesModuleForm salesmodform,
			DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.getquotationreports(ftimets,ttimets,salesmodform,dataSource);
	}
	public List<SalesModuleForm> getquotationrepsales(
			SalesModuleForm salesmodform, DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.getquotationrepsales(salesmodform,dataSource);
	}
	public List<SalesModuleForm> getquotationrepgen(
			SalesModuleForm salesmodform, DataSource dataSource)
	    {
		// TODO Auto-generated method stub
		return impl.getquotationrepgen(salesmodform,dataSource);
	}
	
	

}
