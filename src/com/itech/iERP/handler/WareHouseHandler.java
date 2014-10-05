package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import org.apache.struts.action.ActionForward;
import com.itech.iERP.daoimpl.WareHouseDaoImpl;
import com.itech.iERP.forms.WareHouseForm;

public class WareHouseHandler
{
	WareHouseDaoImpl  dao=new WareHouseDaoImpl ();
	
	public List<WareHouseForm> vendorList(long compid, DataSource dataSource,WareHouseForm vform) {
		return dao.listVendor(compid,dataSource,vform);
	}

	public String addVendor(WareHouseForm vform, long compid, DataSource ds) {
		return dao.add(vform,compid,ds);
	}

	public Object changeVendor(WareHouseForm vform, DataSource dataSource) {
		return dao.changeStatus(vform, dataSource);
	}

	public Object updateVendor(WareHouseForm vform, DataSource dataSource) {
		return dao.update(vform, dataSource);
	}

	public List<WareHouseForm> listAllcity(DataSource dataSource,
			long stateid) {
		// TODO Auto-generated method stub
		return dao.listallvcity(dataSource, stateid);
	}

//	public List<WareHouseForm> listallArea(DataSource dataSource, long cityid) {
//		// TODO Auto-generated method stub
//		return dao.listallArea(dataSource, cityid);
//	}

	public List<WareHouseForm> listAllStates(DataSource dataSource) {
		// TODO Auto-generated method stub
		return dao.listAllStates(dataSource);
	}
	
  
}
