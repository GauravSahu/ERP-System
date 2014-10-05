package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.VendorMasterDaoImpl;
import com.itech.iERP.forms.VendorMasterForm;

public class VendorMasterHandler 
{

	VendorMasterDaoImpl dao=new VendorMasterDaoImpl();
	
	public List<VendorMasterForm> vendorList(DataSource dataSource,VendorMasterForm vform) {
		return dao.listVendor(dataSource,vform);
	}

	public String addVendor(VendorMasterForm vform, long compid, DataSource ds) {
		return dao.add(vform,compid,ds);
	}

	public Object changeVendor(VendorMasterForm vform, DataSource dataSource) {
		return dao.changeStatus(vform, dataSource);
	}

	public Object updateVendor(VendorMasterForm vform, DataSource dataSource) {
		return dao.update(vform, dataSource);
	}

	public List<VendorMasterForm> listAllcity(DataSource dataSource,
			long stateid) {
		// TODO Auto-generated method stub
		return dao.listallvcity(dataSource, stateid);
	}

//	public List<VendorMasterForm> listallArea(DataSource dataSource, long cityid) {
//		// TODO Auto-generated method stub
//		return dao.listallArea(dataSource, cityid);
//	}

	public List<VendorMasterForm> listAllStates(DataSource dataSource) {
		// TODO Auto-generated method stub
		return dao.listAllStates(dataSource);
	}

}
