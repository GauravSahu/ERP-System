package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.DocDownloadDaoImpl;
import com.itech.iERP.forms.DocDownloadForm;

public class DocDownloadHandler
{
	DocDownloadDaoImpl impl = new DocDownloadDaoImpl();

	public List<DocDownloadForm> allActiveUsers(long compid, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.allActiveUsers(compid,dataSource);
	}

	public List<DocDownloadForm> allDocList(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.allDocList(dataSource);
	}
  
}
