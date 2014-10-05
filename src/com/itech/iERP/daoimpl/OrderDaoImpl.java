package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.OrderModuleForm;

public class OrderDaoImpl 
{

	public List<OrderModuleForm> itemlist(long userid, long compid,
			DataSource dataSource)
    {
		List<OrderModuleForm> list = new ArrayList<OrderModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderModuleForm pricemasterform = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM itemmaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   pricemasterform = new OrderModuleForm();
			  
			   pricemasterform.setItemname(rs.getString("ITEMNAME"));
			   pricemasterform.setItemtid(rs.getInt("ITEMMASTERID"));
			   
			   list.add(pricemasterform);
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

	public List<OrderModuleForm> venderList(long userid, long compid,
			DataSource dataSource)
			{
		List<OrderModuleForm> list= new ArrayList<OrderModuleForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		OrderModuleForm pricemasterform=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM vendormaster ORDER BY FIRSTNAME ASC";
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);		
			rs=pstmt.executeQuery();
			while(rs.next()){
				pricemasterform= new OrderModuleForm();				
				pricemasterform.setVendorid(rs.getInt("VENDORID"));
				pricemasterform.setVendorname(rs.getString("FIRSTNAME")+" "+rs.getString("LASTNAME"));
				list.add(pricemasterform);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return list;
	}

	public List<OrderModuleForm> vendoritemdetails(long userid, long compid,
			DataSource dataSource) 
			{
		List<OrderModuleForm> list= new ArrayList<OrderModuleForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		OrderModuleForm pricemasterform=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM vendormaster ORDER BY FIRSTNAME ASC";
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);		
			rs=pstmt.executeQuery();
			while(rs.next()){
				pricemasterform= new OrderModuleForm();				
				pricemasterform.setVendorid(rs.getInt("VENDORID"));
				pricemasterform.setVendorname(rs.getString("FIRSTNAME")+" "+rs.getString("LASTNAME"));
				list.add(pricemasterform);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return list;
	}

	public List<OrderModuleForm> pricedetails(long userid, long compid,
			DataSource dataSource)
			{
		List<OrderModuleForm> list= new ArrayList<OrderModuleForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		OrderModuleForm pricemasterform=null;
		try {
			con=dataSource.getConnection();
			String sql="select Firstname,ITEMNAME,PRICE from vendormaster,itemmaster,pricemaster order by vendormaster.FIRSTNAME asc";
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);		
			rs=pstmt.executeQuery();
			while(rs.next()){
				pricemasterform= new OrderModuleForm();				
				pricemasterform.setVendorname(rs.getString("FIRSTNAME"));
				pricemasterform.setItemname(rs.getString("ITEMNAME"));
				pricemasterform.setPrice(rs.getInt("PRICE"));
				list.add(pricemasterform);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return list;
	}

	public String addpurchaserequition(long userid, long compid,
			OrderModuleForm ordermodule, DataSource dataSource)
	{
		java.sql.Timestamp ts = new java.sql.Timestamp(System
				.currentTimeMillis());
		
	
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
	    String  price = null;
		OrderModuleForm pricemasterform=null;
		try {
			 con=dataSource.getConnection();
			 String sql1 = "select price from pricemaster where VENDERID = '"+ordermodule.getVendorid()+"' and ITEMID = '"+ordermodule.getItemtid()+"';  ";
			 pstmt=con.prepareStatement(sql1);		
				rs=pstmt.executeQuery();
				while(rs.next()){
					pricemasterform= new OrderModuleForm();				
					price = rs.getString("price");
					System.out.println("price is "+price);
				
				}
			   
				
				String sql="INSERT INTO purchaserequition(ITEMID,VENDERID,PRICE,compid,quantity,ACTIVE,userid,requesteddate) VALUES (?,?,?,?,?,?,?,?)";
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setLong(1,ordermodule.getItemtid());
				pstmt.setInt(2,ordermodule.getVendorid());
				pstmt.setString(3,price);
				pstmt.setLong(4,compid);
				pstmt.setInt(5,ordermodule.getQty());
				pstmt.setBoolean(6, true);
				pstmt.setLong(7,userid);
				pstmt.setTimestamp(8,ts);
				pstmt.executeUpdate();
				if(rs!=null)
					rs.close();
	    		result=iERPConstants.REC_ADDED;
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	}
  
