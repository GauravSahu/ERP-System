package com.itech.iERP.handler;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.LibraryModuleDeoImpl;
import com.itech.iERP.forms.LibraryModuleForm;

public class LibraryModuleHandler {
	LibraryModuleDeoImpl impl= new LibraryModuleDeoImpl();
	
	public List<LibraryModuleForm> booklist(DataSource dataSource) {
	return impl.booklist(dataSource);
	}
	
	public List<LibraryModuleForm> bookrequestlist(DataSource dataSource) {
		return impl.bookrequestlist(dataSource);
	}
	
	public int add(LibraryModuleForm bookrequestform, DataSource dataSource) {
		
		return impl.bookrequestadd(bookrequestform, dataSource);
	}

	public List<LibraryModuleForm> employeelist(DataSource dataSource) {
		return impl.employeelist(dataSource);
		
	}

	public List<LibraryModuleForm> bookduesearchlist(DataSource dataSource, String takendate, String returndate) {
		return impl.bookduesearchlist(dataSource,takendate,returndate);
	}

	public String mailbooklist(LibraryModuleForm bookrequestform,DataSource dataSource) {
		
		return impl.mailbooklist(bookrequestform,dataSource);
	}

	public List<LibraryModuleForm> empbookduesearchlist(DataSource dataSource,	int empid, int empid1) {
		return impl.empbookduesearchlist(dataSource,empid,empid1);
	}
	
//	public List<LibraryModuleForm> emailemployeelist(DataSource dataSource,	int employeeid) {
//		return impl.emailemployeelist(dataSource,employeeid);
//	}

}



