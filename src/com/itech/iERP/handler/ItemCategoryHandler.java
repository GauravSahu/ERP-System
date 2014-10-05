package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.ItemCategoryDaoImpl;
import com.itech.iERP.forms.ItemCategoryForm;

public class ItemCategoryHandler {
     ItemCategoryDaoImpl impl= new ItemCategoryDaoImpl();
	public List<ItemCategoryForm> list(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.listAll(dataSource);
	}

	public String add(ItemCategoryForm itemcategoryform, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.add(itemcategoryform,dataSource);
	}

	public Object changeStatus(ItemCategoryForm itemcategoryform,
			DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeStatus(itemcategoryform,dataSource);
	}

	public Object update(ItemCategoryForm itemcategoryform,
			DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.update(itemcategoryform,dataSource);
	}
	public List<ItemCategoryForm> active(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.activeList(dataSource);
	}


}
