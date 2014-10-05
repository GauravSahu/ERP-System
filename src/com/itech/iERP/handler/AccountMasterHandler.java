package com.itech.iERP.handler;

import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.daoimpl.AccountMasterDaoImpl;
import com.itech.iERP.forms.AccountMasterForm;

public class AccountMasterHandler
{
    AccountMasterDaoImpl impl = new AccountMasterDaoImpl();
	public List<AccountMasterForm> list(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listallaccounttype(dataSource);
	}
	public String changestatus(AccountMasterForm accountmaster,
			DataSource dataSource)
	{
		// TODO Auto-generated method stub
		return impl.changestatus(accountmaster,dataSource);
	}
	public String addaccounts(AccountMasterForm accountmaster,
			DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.addaccounts(accountmaster,dataSource);
	}
	
	
  
}
