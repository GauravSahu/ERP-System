package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;
import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.CustomerForm;

import com.itech.iERP.utils.EncryptUtil;


public class CustomerDaoImpl 
{

	public List<CustomerForm> listAll(DataSource dataSource) 
	{
		List<CustomerForm> list = new ArrayList<CustomerForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerForm customerForm = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM customermaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   customerForm = new CustomerForm();
			   customerForm.setCustomerid(rs.getInt("CUSTOMERID"));
			   customerForm.setCustomername(rs.getString("CUSTOMERNAME"));
			   customerForm.setCustomer_accno(rs.getString("CUSTOMER_ACCNO"));
		//	   customerForm.setUserid(rs.getInt("USERID"));
			   customerForm.setAddress1(rs.getString("ADDRESS1"));
			   customerForm.setAddress2(rs.getString("ADDRESS2"));
			   customerForm.setCountryid(rs.getInt("COUNTRYID"));
			   customerForm.setStateid(rs.getInt("STATEID"));
			   customerForm.setCityid(rs.getInt("CITYID"));
			   customerForm.setPhone1(rs.getString("PHONE1"));
			   customerForm.setPhone2(rs.getString("PHONE2"));
			   customerForm.setEmailid(rs.getString("EMAILID"));
			   customerForm.setZip(rs.getString("ZIP"));
			   customerForm.setFax(rs.getString("FAX"));
			   customerForm.setActive(rs.getBoolean("ACTIVE"));
			   list.add(customerForm);
		   }
		}
		catch (Exception e) 
		{
		   System.out.println("Exception is "+e);
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
			  System.out.println(e2);
			}
		}
		return list;
	}

	public String add(CustomerForm customerForm, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from customermaster where CUSTOMERNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customerForm.getCustomername());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				if(!customerForm.getCustomername().equalsIgnoreCase("") && !customerForm.getCustomername().equalsIgnoreCase(null))
				{
					sql = "insert into customermaster(CUSTOMERID,CUSTOMERNAME,CUSTOMER_ACCNO,ADDRESS1,ADDRESS2,COUNTRYID,STATEID,CITYID,PHONE1,PHONE2,EMAILID,ZIP,FAX,ACTIVE) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					if(pstmt!=null)
					pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1,customerForm.getCustomerid());
					pstmt.setString(2, customerForm.getCustomername());
					pstmt.setString(3, customerForm.getCustomer_accno());
			//		pstmt.setInt(4,customerForm.getUserid());
					pstmt.setString(4, customerForm.getAddress1());
					pstmt.setString(5, customerForm.getAddress2());
					pstmt.setInt(6,customerForm.getCountryid());
					pstmt.setInt(7,customerForm.getStateid());
					pstmt.setInt(8,customerForm.getCityid());
					pstmt.setString(9, customerForm.getPhone1());
					pstmt.setString(10, customerForm.getPhone2());
					pstmt.setString(11, customerForm.getEmailid());
					pstmt.setString(12, customerForm.getZip());
					pstmt.setString(13, customerForm.getFax());
					pstmt.setBoolean(14, true);
					pstmt.executeUpdate();
					if(rs!=null)
						rs.close();
					result=iERPConstants.REC_ADDED;
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public String changeStatus(CustomerForm customerForm, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "update customermaster set active = ? where CUSTOMERID=?";
		   pstmt=con.prepareStatement(sql);
		   pstmt.setBoolean(1,customerForm.isActive());
		   pstmt.setInt(2, customerForm.getCustomerid());
		   pstmt.executeUpdate();
		   result=iERPConstants.REC_STATUS_CHANGED;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return result;
	}

	public String update(CustomerForm customerForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM customermaster WHERE CUSTOMERNAME AND CUSTOMER_ACCNO AND ADDRESS1 AND ADDRESS2 AND PHONE1 AND PHONE2 AND EMAILID AND ZIP AND FAX LIKE ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,customerForm.getCustomername());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.No_Change;
			else
			{
				if(!customerForm.getCustomername().equalsIgnoreCase("") && !customerForm.getCustomername().equalsIgnoreCase(null))
				{
					sql="UPDATE customermaster SET CUSTOMERNAME=?,CUSTOMER_ACCNO=?,ADDRESS1=?,ADDRESS2=?,COUNTRYID=?,STATEID=?,CITYID=?,PHONE1=?,PHONE2=?,EMAILID=?,ZIP=?,FAX=? WHERE CUSTOMERID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
				
					pstmt.setString(1, customerForm.getCustomername());
					pstmt.setString(2, customerForm.getCustomer_accno());
			//		pstmt.setInt(3,customerForm.getUserid());
					pstmt.setString(3, customerForm.getAddress1());
					pstmt.setString(4, customerForm.getAddress2());
					pstmt.setInt(5,customerForm.getCountryid());
					pstmt.setInt(6,customerForm.getStateid());
					pstmt.setInt(7,customerForm.getCityid());
					pstmt.setString(8, customerForm.getPhone1());
					pstmt.setString(9, customerForm.getPhone2());
					pstmt.setString(10, customerForm.getEmailid());
					pstmt.setString(11, customerForm.getZip());
					pstmt.setString(12, customerForm.getFax());
					pstmt.setInt(13,customerForm.getCustomerid());
					pstmt.executeUpdate();
					if(rs!=null)
						rs.close();
					result=iERPConstants.REC_UPDATED;
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		return result;
	}

	public List<CustomerForm> activeList(DataSource dataSource) 
	{
		List<CustomerForm> list = new ArrayList<CustomerForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerForm customerForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from usermaster where active = true";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				customerForm = new CustomerForm();
				 customerForm.setCustomerid(rs.getInt("CUSTOMERID"));
				   customerForm.setCustomername(rs.getString("CUSTOMERNAME"));
				   customerForm.setCustomer_accno(rs.getString("CUSTOMER_ACCNO"));
			//	   customerForm.setUserid(rs.getInt("USERID"));
				   customerForm.setAddress1(rs.getString("ADDRESS1"));
				   customerForm.setAddress2(rs.getString("ADDRESS2"));
				   customerForm.setCountryid(rs.getInt("COUNTRYID"));
				   customerForm.setStateid(rs.getInt("STATEID"));
				   customerForm.setCityid(rs.getInt("CITYID"));
				   customerForm.setPhone1(rs.getString("PHONE1"));
				   customerForm.setPhone2(rs.getString("PHONE2"));
				   customerForm.setEmailid(rs.getString("EMAILID"));
				   customerForm.setZip(rs.getString("ZIP"));
				   customerForm.setFax(rs.getString("FAX"));
				   customerForm.setActive(rs.getBoolean("ACTIVE"));
				   list.add(customerForm);
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
	}


	public List<CustomerForm> countryList(DataSource dataSource) {


		List<CustomerForm> list = new ArrayList<CustomerForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerForm customerForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from countrymaster where active = true";
			pstmt = con.prepareStatement(sql);
		
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				customerForm = new CustomerForm();
				customerForm.setCountryid(rs.getInt("COUNTRYID"));
				customerForm.setCountryname(rs.getString("COUNTRYNAME"));
				   list.add(customerForm);
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
		
	
	}

	public List<CustomerForm> cityList(DataSource dataSource,int stateid) {



		List<CustomerForm> list = new ArrayList<CustomerForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerForm customerForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from citymaster where STATEID=? AND active = true ORDER BY CITYNAME ASC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stateid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				customerForm = new CustomerForm();
				customerForm.setCityid(rs.getInt("CITYID"));
				customerForm.setCityname(rs.getString("CITYNAME"));
				   list.add(customerForm);
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
		
	
	
	}

	public List<CustomerForm> stateList(DataSource dataSource, int countryid) {




		List<CustomerForm> list = new ArrayList<CustomerForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerForm customerForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from statemaster where COUNTRYID=? AND active = true ORDER BY STATENAME ASC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, countryid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				customerForm = new CustomerForm();
				customerForm.setStateid(rs.getInt("STATEID"));
				customerForm.setStatename(rs.getString("STATENAME"));
				list.add(customerForm);
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
		
	
	
	
	}
   
	
}
