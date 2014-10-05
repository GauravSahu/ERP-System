package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.OrderDaoImpl;
import com.itech.iERP.forms.OrderModuleForm;

public class OrderModuleHandler
{
	OrderDaoImpl impl = new OrderDaoImpl();

	public List<OrderModuleForm> itemlist(long userid, long compid,
			DataSource dataSource) 
			{
		return impl.itemlist(userid,compid,dataSource);
	}

	public List<OrderModuleForm> venderList(long userid, long compid,
			DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.venderList(userid,compid,dataSource);
	}

	public List<OrderModuleForm> vendoritemdetails(long userid, long compid,
			DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.vendoritemdetails(userid,compid,dataSource);
	}

	public List<OrderModuleForm> pricedetails(long userid, long compid,
			DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.pricedetails(userid,compid,dataSource);
	}

	public String addpurchaserequition(long userid, long compid,
			OrderModuleForm ordermodule, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.addpurchaserequition(userid,compid,ordermodule,dataSource);
	}
  
}
