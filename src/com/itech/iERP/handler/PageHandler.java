package com.itech.iERP.handler;

import com.itech.iERP.daoimpl.PageDaoImpl;

import javax.sql.DataSource;
public class PageHandler 
{
	PageDaoImpl impl = new 	PageDaoImpl();
	
	public String page(String id,DataSource ds){
		
			
			return impl.pageAccess(id,ds);
		}

}
