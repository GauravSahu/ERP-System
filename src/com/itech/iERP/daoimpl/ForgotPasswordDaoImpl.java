package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.itech.iERP.forms.ForgotPasswordForm;
import com.itech.iERP.utils.EncryptUtil;

public class ForgotPasswordDaoImpl 
{

	public String sendmail(ForgotPasswordForm forgotPasswordForm, DataSource ds)
	{
		String pass = null;
		System.out.println("Inside forgot password action");
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = ds.getConnection();
			if(forgotPasswordForm.getEmail()!= null)
			{
				String sql = "select password from usermaster where EMAILID = '"+forgotPasswordForm.getEmail()+"'";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					pass = EncryptUtil.decrypt(rs.getString("password"));
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return pass;
	}

}
