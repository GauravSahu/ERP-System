package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.GoodsResivedDeoImpl;
import com.itech.iERP.forms.GoodsResivedForm;
import com.itech.iERP.forms.PriceMasterForm;

public class GoodResivedHandler {
GoodsResivedDeoImpl impl = new GoodsResivedDeoImpl();
	public List<GoodsResivedForm> list(DataSource dataSource) {
		return impl.list(dataSource);
	}
	public String add(GoodsResivedForm goodsresivedform, DataSource dataSource, String iid, String vid, String pri, String aq, String rq, String ci, String date, String remark) {
		return impl.add(goodsresivedform,dataSource,iid,vid,pri,aq,rq,ci,date,remark);
	}
	public List<GoodsResivedForm> vendorList(DataSource dataSource) {
		return impl.vendorlist(dataSource);
	}	

}
