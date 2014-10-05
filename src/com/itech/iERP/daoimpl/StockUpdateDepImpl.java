package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itech.iERP.constants.iERPConstants;

import com.itech.iERP.forms.ContryForm;
import com.itech.iERP.forms.PriceMasterForm;
import com.itech.iERP.forms.StockUpdateForm;

public class StockUpdateDepImpl {

	public List<StockUpdateForm> vendorlist(DataSource dataSource) {
		List<StockUpdateForm> list = new ArrayList<StockUpdateForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StockUpdateForm stockupdateform = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT VENDORID,concat(firstname,' ',lastname) as vendorname FROM vendormaster ORDER BY FIRSTNAME ASC";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stockupdateform = new StockUpdateForm();
				stockupdateform.setVendorid(rs.getInt("VENDORID"));
				stockupdateform.setVendorname(rs.getString("vendorname"));
				list.add(stockupdateform);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
			}
		}
		return list;
	}

	public String add(StockUpdateForm stockupdateform, DataSource dataSource, long compid) {
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "select * from stockupdation where ITEMID=? and VENDORID=? and PRICE=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, stockupdateform.getItemid());
			pstmt.setInt(2, stockupdateform.getVendorid());
			pstmt.setInt(3, stockupdateform.getPrice());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				result = iERPConstants.DUPLICATE_ITEM_MESSAGE;
			else {
				if (stockupdateform.getPrice() != 0) {
					sql = "insert into stockupdation(ITEMID,VENDORID,PRICE,QTY,compid,date,remarks) values (?,?,?,?,?,?,?)";
					if (pstmt != null)
						pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, stockupdateform.getItemid());
					pstmt.setInt(2, stockupdateform.getVendorid());
					pstmt.setInt(3, stockupdateform.getPrice());
					pstmt.setInt(4, stockupdateform.getQty());
					System.out.println("Company ID deo: "+compid);
					pstmt.setLong(5,compid);
					pstmt.setString(6, stockupdateform.getDate());
					pstmt.setString(7, stockupdateform.getRemark());

					pstmt.executeUpdate();
					if (rs != null)
						rs.close();
					result = iERPConstants.REC_ADDED;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<StockUpdateForm> stockupdatelist(DataSource dataSource) {
		List<StockUpdateForm> list = new ArrayList<StockUpdateForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StockUpdateForm stockupdateform = null;

		try {
			con = dataSource.getConnection();
			String sql = "select * FROM purchaseorder where  ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stockupdateform = new StockUpdateForm();
				stockupdateform.setPurchaseOrderID(rs.getInt("purchaseOrderID"));
				stockupdateform.setStockupdateid(rs.getInt("ITEMMASTERID"));
				stockupdateform.setItemid(rs.getInt("ITEMMASTERID"));
				stockupdateform.setItemname(rs.getString("it.itemname"));
				stockupdateform.setVendorname(rs.getString("vendorname"));
				stockupdateform.setPrice(rs.getInt("price"));
				stockupdateform.setQty(rs.getInt("quantity"));
				stockupdateform.setCompid(rs.getInt("compid"));
				stockupdateform.setDate(rs.getString("date"));
				stockupdateform.setRemark(rs.getString("remarks"));
				stockupdateform.setItemid(rs.getInt("su.itemid"));
				stockupdateform.setVendorid(rs.getInt("vendorid"));
				list.add(stockupdateform);
			}
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		return list;
	}

	public String updatestock(StockUpdateForm stockupdateform,DataSource dataSource, long compid) {
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
//			String sql = "select * from stockupdation where ITEMID=? and VENDORID=? and PRICE=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, stockupdateform.getItemid());
//			pstmt.setInt(2, stockupdateform.getVendorid());
//			pstmt.setInt(3, stockupdateform.getPrice());
//			ResultSet rs = pstmt.executeQuery();
//			if (rs.next())
//				result = iERPConstants.DUPLICATE_ITEM_MESSAGE;
//			else {
				if (stockupdateform.getPrice()!= 0) {
					String sql = "UPDATE stockupdation SET ITEMID=?,VENDORID=?,PRICE=?,QTY=?,compid=?,date=?,remarks=? WHERE stockupdateID=?";
					if (pstmt != null)
						pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, stockupdateform.getItemid());
					pstmt.setInt(2, stockupdateform.getVendorid());
					pstmt.setInt(3, stockupdateform.getPrice());
					pstmt.setInt(4, stockupdateform.getQty());
					System.out.println("Company ID deo: "+compid);
					pstmt.setLong(5,compid);
					pstmt.setString(6, stockupdateform.getDate());
					pstmt.setString(7, stockupdateform.getRemark());
					pstmt.setInt(8, stockupdateform.getStockupdateid());
					pstmt.executeUpdate();
//					if (rs != null)
//						rs.close();
					result = iERPConstants.REC_UPDATED;
				}

//			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return result;
	}

	public List<StockUpdateForm> itemlist(DataSource dataSource) {
		List<StockUpdateForm> list = new ArrayList<StockUpdateForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StockUpdateForm stockupdateform = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM itemmaster";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   stockupdateform = new StockUpdateForm();
			   stockupdateform.setItemname(rs.getString("ITEMNAME"));
			   stockupdateform.setItemid(rs.getInt("ITEMMASTERID"));
			   list.add(stockupdateform);
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
	
	public String changeStatus(StockUpdateForm stockupdateform, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "update stockupdation set active = ? where stockupdateID=?";
		   pstmt=con.prepareStatement(sql);
		   pstmt.setBoolean(1,stockupdateform.isActive());
		   pstmt.setInt(2, stockupdateform.getStockupdateid());
		   pstmt.executeUpdate();
		   result=iERPConstants.REC_STATUS_CHANGED;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return result;
	}
	  
}

