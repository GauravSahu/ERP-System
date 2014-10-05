package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.PriceMasterDeoImpl;
import com.itech.iERP.forms.PriceMasterForm;

public class PriceMasterHandler {
	
PriceMasterDeoImpl impl = new PriceMasterDeoImpl();
	
public List<PriceMasterForm> list(DataSource dataSource) {
		
		return impl.list(dataSource);
	}

public String add(PriceMasterForm pricemasterform, DataSource dataSource) {
	return impl.add(pricemasterform,dataSource);
}

public String update(PriceMasterForm pricemasterform, DataSource dataSource) {
	return impl.update(pricemasterform,dataSource);
}

public List<PriceMasterForm> itemlist(DataSource dataSource) {
	return impl.itemlist(dataSource);
}

public List<PriceMasterForm> venderList(DataSource dataSource) {
	return impl.vebderlist(dataSource);
}


}
	


