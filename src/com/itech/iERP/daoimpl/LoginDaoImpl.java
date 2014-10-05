package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.itech.iERP.forms.LoginForm;
import com.itech.iERP.utils.EncryptUtil;

public class LoginDaoImpl {

	public LoginForm login(String username, String password, DataSource ds) {
		// TODO Auto-generated method stub
		LoginForm loginform=null;
    	Connection con=null;
    	PreparedStatement pstmt=null;
    	ResultSet rs=null;
    	
    	try 
    	{
    		con=ds.getConnection();
    		//String sql="select username,password,roleid,companylogo from usermaster,companymaster where (usermaster.companyid = companymaster.companyid) where username=? and password=? and Active=true ";
    		String sql="select * from usermaster,companymaster where (usermaster.companyid = companymaster.companyid) and  username=? and password=?";
    		pstmt=con.prepareStatement(sql);
    		pstmt.setString(1, username);
    		System.out.println("inside logindaoimpl" +username);
    		System.out.println("log"+password);
    		pstmt.setString(2, EncryptUtil.encrypt(password));
    		
    		System.out.println(EncryptUtil.encrypt(password)+ "inside");
    		
    		rs=pstmt.executeQuery();
    		String imgLen = "";
    		while(rs.next())
    		{
    			loginform=new LoginForm();
    			loginform.setUserId(rs.getInt("userid"));
    			loginform.setUsername(rs.getString("username"));
    			loginform.setPassword(rs.getString("password"));
    			loginform.setFirstname(rs.getString("firstname"));
    			loginform.setLastname(rs.getString("lastname"));
    			loginform.setRole(rs.getInt("roleid"));
    			loginform.setCompid((rs.getLong("companyid")));
    			System.out.println("company id"+rs.getInt("companyid"));
    		    loginform.setCompanylogo(rs.getString("companylogo"));
    		}
    		
		} catch (Exception e) 
		{
			loginform=null;
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(con!=null)
				con.close();
			}
			catch (Exception e2) {}
		}
		return loginform;
    }

	public LoginForm scode(String userName, DataSource dataSource) {
		// TODO Auto-generated method stub
		LoginForm loginform=null;
    	Connection con=null;
    	PreparedStatement pstmt=null;
    	ResultSet rs=null;
    	try 
    	{
    		con=dataSource.getConnection();
    		String sql="select * from scodemaster where SCODENAME=? ";
    		pstmt=con.prepareStatement(sql);
    		pstmt.setString(1, userName);
    		System.out.println(sql);
    		rs=pstmt.executeQuery();
    		while(rs.next())
    		{
    			loginform=new LoginForm();
    			
    			
    			
    			loginform.setScodeId(rs.getInt("SCODEID"));
    			loginform.setScode(rs.getString("SCODENAME"));
    			loginform.setRole(rs.getInt("roleid"));
    			
    		}
    	}
    	catch (Exception e) 
    	{
			System.out.println(e);
		}
    	return loginform;
    	
	}	

	}
  

