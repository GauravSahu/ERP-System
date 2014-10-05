package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.BookMasterDaoImpl;
import com.itech.iERP.forms.BookMasterForm;

public class BookMasterHandler {
	BookMasterDaoImpl impl=new BookMasterDaoImpl();
	
	public List<BookMasterForm> list(DataSource dataSource) {
	
		return impl.listAll(dataSource);
	}
	
	public String add(BookMasterForm bookmasterForm, DataSource dataSource) 
	{
		
		return impl.add(bookmasterForm,dataSource);
	}

	public String updateBookMaster(BookMasterForm bookmasterform,DataSource dataSource) {
		return impl.update(bookmasterform,dataSource);
	}

	public List<BookMasterForm> bootcatlist(DataSource dataSource) {
		return impl.bookcatlist(dataSource);
	}
	
}
