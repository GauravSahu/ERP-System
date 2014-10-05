package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.ItemMasterDeoImpl;
import com.itech.iERP.forms.ItemMasterForm;

public class ItemMasterHandler {
	ItemMasterDeoImpl impl=new ItemMasterDeoImpl();

	public String add(ItemMasterForm itemmasterform, DataSource dataSource) {
		return impl.add(itemmasterform,dataSource);
	}

	public String changeStatus(ItemMasterForm itemmasterform,DataSource dataSource) {
		
		
			return impl.changeStatus(itemmasterform,dataSource);
		}

	public String update(ItemMasterForm itemmasterform, DataSource dataSource) {
		return impl.update(itemmasterform,dataSource);
	}

	public List<ItemMasterForm> list(DataSource dataSource) {
		return impl.listAll(dataSource);
	}

	public List<ItemMasterForm> itemlist(DataSource dataSource) {
		return impl.itemlsist(dataSource);
	}
	}


