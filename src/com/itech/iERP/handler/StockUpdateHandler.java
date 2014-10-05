package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.StockUpdateDepImpl;
import com.itech.iERP.forms.StockUpdateForm;

public class StockUpdateHandler {
StockUpdateDepImpl impl =new StockUpdateDepImpl();
	public List<StockUpdateForm> stockupdatelist(DataSource dataSource) {
		return impl.stockupdatelist(dataSource);
	}

	public String add(StockUpdateForm stockupdateform, DataSource dataSource, long compid) {
		return impl.add(stockupdateform,dataSource,compid);
		
	}

	public List<StockUpdateForm> vendorList(DataSource dataSource) {
		return impl.vendorlist(dataSource);
	}

	public String updatestock(StockUpdateForm stockupdateform,DataSource dataSource, long compid) {
		return impl.updatestock(stockupdateform,dataSource,compid);
	}

	public List<StockUpdateForm> itemlist(DataSource dataSource) {
	
			return impl.itemlist(dataSource);
		}

	public String changeRole(StockUpdateForm stockupdateform,DataSource dataSource) {
		return impl.changeStatus(stockupdateform,dataSource);
	}

	

}
