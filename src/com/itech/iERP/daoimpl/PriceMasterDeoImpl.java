package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.ItemMasterForm;
import com.itech.iERP.forms.PriceMasterForm;
import com.itech.iERP.forms.VendorMasterForm;

public class PriceMasterDeoImpl {

	public List<PriceMasterForm> list(DataSource dataSource) {
		List<PriceMasterForm> list = new ArrayList<PriceMasterForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PriceMasterForm pricemasterform = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM pricemaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   pricemasterform = new PriceMasterForm();
			   pricemasterform.setItemid(rs.getInt("itemid"));
			   pricemasterform.setVenderid(rs.getInt("venderid"));
			   pricemasterform.setPrice(rs.getInt("price"));
		
			  
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

	public String add(PriceMasterForm pricemasterform, DataSource dataSource) {
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from PRICEMASTER where ITEMID=? and VENDERID=? and PRICE=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,pricemasterform.getItemid());
			pstmt.setInt(2, pricemasterform.getVenderid());
			pstmt.setInt(3,pricemasterform.getPrice());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_ITEM_MESSAGE;
			else
			{
				if(pricemasterform.getPrice()!=0)
				{
					sql = "insert into PRICEMASTER(ITEMID,VENDERID,PRICE) values (?,?,?)";
					if(pstmt!=null)
					pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1,pricemasterform.getItemid());
					pstmt.setInt(2, pricemasterform.getVenderid());
					pstmt.setInt(3,pricemasterform.getPrice());
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

	public String update(PriceMasterForm pricemasterform, DataSource dataSource) {
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from PRICEMASTER where ITEMID=? and VENDERID=? and PRICE=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,pricemasterform.getItemid());
			pstmt.setInt(2, pricemasterform.getVenderid());
			pstmt.setInt(3,pricemasterform.getPrice());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_ITEM_MESSAGE;
			else
			{
				if(pricemasterform.getPrice()!=0)
				{
					 sql="UPDATE PRICEMASTER SET ITEMID=?,VENDERID=?,PRICE=? WHERE ITEMID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1,pricemasterform.getItemid());
					pstmt.setInt(2, pricemasterform.getVenderid());
					pstmt.setInt(3,pricemasterform.getPrice());
					pstmt.setInt(4,pricemasterform.getItemid());
					
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

	public List<PriceMasterForm> itemlist(DataSource dataSource) {
		List<PriceMasterForm> list = new ArrayList<PriceMasterForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PriceMasterForm pricemasterform = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM itemmaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   pricemasterform = new PriceMasterForm();
			  
			   pricemasterform.setItemname(rs.getString("ITEMNAME"));
			   pricemasterform.setItemid(rs.getInt("ITEMMASTERID"));
			   
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

	public List<PriceMasterForm> vebderlist(DataSource dataSource) {
		List<PriceMasterForm> list= new ArrayList<PriceMasterForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PriceMasterForm pricemasterform=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM vendormaster ORDER BY FIRSTNAME ASC";
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);		
			rs=pstmt.executeQuery();
			while(rs.next()){
				pricemasterform= new PriceMasterForm();				
				pricemasterform.setVenderid(rs.getInt("VENDORID"));
				pricemasterform.setVendername(rs.getString("FIRSTNAME")+" "+rs.getString("LASTNAME"));
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
	}



