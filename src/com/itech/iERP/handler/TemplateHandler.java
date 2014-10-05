package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.TemplateDaoImpl;
import com.itech.iERP.forms.TemplateForm;

public class TemplateHandler 
{
	TemplateDaoImpl impl = new TemplateDaoImpl();

	public List<TemplateForm> list(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listAll(dataSource);
	}

	public String addTemplate(TemplateForm tempForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.addTemplate(tempForm,dataSource);
	}

	public String changeTemp(TemplateForm tempForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeTemp(tempForm,dataSource);
	}

	public String updateTemp(TemplateForm tempForm, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.update(tempForm,dataSource);
	}

	
 
}
