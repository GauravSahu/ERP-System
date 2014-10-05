package com.itech.iERP.handler;

import java.util.List;


import javax.sql.DataSource;

import com.itech.iERP.daoimpl.BookCatDeoImpl;
import com.itech.iERP.forms.BookCatForm;

public class BookCategoryHandler {
BookCatDeoImpl impl=new BookCatDeoImpl();
	
	public List<BookCatForm> list(DataSource dataSource) {
	
		return impl.listAll(dataSource);
	}
	
	public String add(BookCatForm bookcatForm, DataSource dataSource) 
	{
		
		return impl.add(bookcatForm,dataSource);
	}

	public String update(BookCatForm bookcatform,DataSource dataSource) {
		return impl.update(bookcatform,dataSource);
	}

	public String changeRole(BookCatForm bookcatform, DataSource dataSource) {
		return impl.changeStatus(bookcatform,dataSource);
	}
	
}
