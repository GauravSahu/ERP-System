package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.GoodsResivedForm;
import com.itech.iERP.forms.PriceMasterForm;

public class GoodsResivedDeoImpl {

	public List<GoodsResivedForm> list(DataSource dataSource) {
		{
			
			List<GoodsResivedForm> list = new ArrayList<GoodsResivedForm>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			GoodsResivedForm goodsresivedform = null;
			
			try
			{
			   con = dataSource.getConnection();
			   String sql = "select it.itemname ,concat(vm.firstname,' ',vm.lastname) as vendorname ,su.stockupdateid,su.vendorid,su.itemid,su.price,su.qty,su.compid, su.date, su.remarks from itemmaster it inner join stockupdation su on su.itemid=it.itemmasterid inner join vendormaster  vm on su.vendorid = vm.vendorid ";
			   pstmt=con.prepareStatement(sql);
			  
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   goodsresivedform = new GoodsResivedForm();
				   goodsresivedform.setStockupdateid(rs.getInt("su.stockupdateid"));
				   goodsresivedform.setVendorid(rs.getInt("su.vendorid"));
				   goodsresivedform.setItemid(rs.getInt("su.ITEMID"));
				   goodsresivedform.setPrice(rs.getInt("su.price"));
				   goodsresivedform.setAcceptqty(rs.getInt("su.qty"));
				   goodsresivedform.setCompid(rs.getInt("su.compid"));
				   goodsresivedform.setDate(rs.getString("su.date"));
				   goodsresivedform.setRemark(rs.getString("su.remarks"));
				   goodsresivedform.setItemname(rs.getString("it.itemname"));
				   goodsresivedform.setVendorname(rs.getString("vendorname"));
				  
				    list.add(goodsresivedform);
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

	}

	public String add(GoodsResivedForm goodsresivedform, DataSource dataSource, String iid, String vid, String pri, String aq, String rq, String ci, String date, String remark) {
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
//			String sql = "select * from stockupdation where ITEMID=? and VENDORID=? and PRICE=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, goodsresivedform.getItemid());
//			pstmt.setInt(2, goodsresivedform.getVendorid());
//			pstmt.setInt(3, goodsresivedform.getPrice());
//			ResultSet rs = pstmt.executeQuery();
//			if (rs.next())
//				result = iERPConstants.DUPLICATE_ITEM_MESSAGE;
//			else {
				if (goodsresivedform.getPrice() != 0) {
					String	sql = "insert into goodsreceived(ITEMID,VENDORID,PRICE,acceQTY,rejectqty,compid,date,remarks) values (?,?,?,?,?,?,?,?)";
					if (pstmt != null)
						pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,iid);
					pstmt.setString(2,vid);
					pstmt.setString(3,pri);
					pstmt.setString(4, aq);
					pstmt.setString(5,rq);
					pstmt.setString(6,ci);
					pstmt.setString(7,date);
					pstmt.setString(8, remark);

					pstmt.executeUpdate();
//					if (rs != null)
//						rs.close();
					result = iERPConstants.REC_ADDED;
				}
//			}
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

	public List<GoodsResivedForm> vendorlist(DataSource dataSource) {
		List<GoodsResivedForm> list= new ArrayList<GoodsResivedForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		GoodsResivedForm goodsresivedform=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM vendormaster ORDER BY FIRSTNAME ASC";
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);		
			rs=pstmt.executeQuery();
			while(rs.next()){
				goodsresivedform= new GoodsResivedForm();				
				goodsresivedform.setVendorid(rs.getInt("VENDORID"));
				goodsresivedform.setVendorname(rs.getString("FIRSTNAME")+" "+rs.getString("LASTNAME"));
				list.add(goodsresivedform);
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
	
