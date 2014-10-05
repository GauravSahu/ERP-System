package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.QualifiactionDaoImpl;
import com.itech.iERP.forms.ContryForm;
import com.itech.iERP.forms.QualificationForm;

public class QualificationHandler {
	QualifiactionDaoImpl impl= new QualifiactionDaoImpl();

	public List<QualificationForm> list(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.listAll(dataSource);
	}

	public String add(QualificationForm qualificationform, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.add(qualificationform,dataSource);
	}

	public Object changeStatus(QualificationForm qualificationform,
			DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeStatus(qualificationform,dataSource);
	}

	public Object update(QualificationForm qualificationform,
			DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.update(qualificationform,dataSource);
	}
	public List<QualificationForm> active(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.activeList(dataSource);
	}

	
}
