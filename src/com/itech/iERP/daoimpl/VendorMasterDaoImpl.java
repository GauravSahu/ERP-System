package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.forms.VendorMasterForm;

public class VendorMasterDaoImpl 
{
	public List<VendorMasterForm> listAllStates(DataSource ds) {
		System.out.println("My Impl");
		List<VendorMasterForm> list= new ArrayList<VendorMasterForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		VendorMasterForm state=null;
		try {
			con=ds.getConnection();
			String sql="SELECT * FROM statemaster ORDER BY STATENAME ASC";
			pstmt=con.prepareStatement(sql);		
			rs=pstmt.executeQuery();
			while(rs.next()){
				state= new VendorMasterForm();				
				state.setStateid(rs.getInt("STATEID"));
				state.setStatename(rs.getString("STATENAME"));
				state.setActive(rs.getBoolean("active"));
				list.add(state);
				
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
public List<VendorMasterForm> listallvcity(DataSource ds,Long stateid) {
		List<VendorMasterForm> list= new ArrayList<VendorMasterForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		VendorMasterForm city=null;
		try {
			con=ds.getConnection();
			String sql="SELECT * FROM citymaster where  stateid="+stateid+"";
			pstmt=con.prepareStatement(sql);	
			System.out.println(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				city= new VendorMasterForm();				
				city.setCityid(rs.getInt("cityid"));
				city.setCityname(rs.getString("cityname"));
				//city.setStateid(rs.getInt("stateid"));
				city.setActive(rs.getBoolean("active"));
				list.add(city);
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

//public List<VendorMasterForm> listallArea(DataSource ds,Long city) {
//		List<VendorMasterForm> list= new ArrayList<VendorMasterForm>();
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		VendorMasterForm area=null;
//		try {
//			con=ds.getConnection();
//			String sql="SELECT * FROM areamaster where cityid="+city+" ";
//			pstmt=con.prepareStatement(sql);		
//			rs=pstmt.executeQuery();
//			while(rs.next()){
//				area= new VendorMasterForm();				
//				area.setAreaid(rs.getInt("areaid"));
//				area.setAreaname(rs.getString("areaname"));	
//				area.setActive(rs.getBoolean("active"));
//				area.setStateid(area.getStateid());
//				list.add(area);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			try {
//				if(con!=null)con.close();
//			} catch (Exception e2) {}
//		}
//		return list;
//}
	
	

	public List<VendorMasterForm> listVendor(DataSource dataSource,VendorMasterForm vform) {
		List<VendorMasterForm> list= new ArrayList<VendorMasterForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//VendorMasterForm vform=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM vendormaster ORDER BY FIRSTNAME ASC";
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);		
			rs=pstmt.executeQuery();
			while(rs.next()){
				vform= new VendorMasterForm();				
				vform.setVendorid(rs.getInt("VENDORID"));
				vform.setFirstname(rs.getString("FIRSTNAME"));
				vform.setLastname(rs.getString("LASTNAME"));
				vform.setAddress(rs.getString("ADDRESS"));
				System.out.println("Address="+vform.getAddress());
				vform.setTeleno(rs.getString("TELNO"));
				vform.setMobileno(rs.getString("MOBNO"));
				vform.setEmailid1(rs.getString("EMAILID1"));
				vform.setEmailid2(rs.getString("EMAILID2"));
				vform.setWebsite(rs.getString("WEBSITE"));
				vform.setDiscount(rs.getString("Discount"));
				vform.setTax(rs.getString("Tax"));
				//vform.setLogo(rs.getBlob("LOGO"));
				vform.setVendorname(rs.getString("FIRSTNAME")+" "+rs.getString("LASTNAME"));
				vform.setActive(rs.getBoolean("Active"));
				list.add(vform);
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
	
	public String add(VendorMasterForm vform, long compid, DataSource ds) {
		String result="fail";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			System.out.println("try-----"+vform.getFirstname());
			
			con=ds.getConnection();
			String sql="SELECT * FROM vendormaster WHERE FIRSTNAME=? ";
			pstmt=con.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, vform.getFirstname());
			//pstmt.setLong(2,vform.getAreaid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result="Duplicate";
			else
			{
				if(!vform.getFirstname().equalsIgnoreCase("")&&!vform.getFirstname().equalsIgnoreCase(null))
				{
				sql="INSERT INTO vendormaster (FIRSTNAME,LASTNAME,TELNO,ADDRESS,MOBNO,EMAILID1,EMAILID2,WEBSITE,Active,CITY,STATE,Discount,Tax,compid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				System.out.println(sql);
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				//pstmt.setLong(1, clinicForm.getCityid());
				pstmt.setString(1, vform.getFirstname());
				pstmt.setString(2, vform.getLastname());
				pstmt.setString(3, vform.getTeleno());
				pstmt.setString(4, vform.getAddress());
				pstmt.setString(5, vform.getMobileno());
				pstmt.setString(6, vform.getEmailid1());		
				pstmt.setString(7, vform.getEmailid2());		
				pstmt.setString(8, vform.getWebsite());		
				pstmt.setBoolean(9, true);
				//pstmt.setString(10, vform.getStatename());
				//pstmt.setString(11, vform.getCityname());
				pstmt.setLong(10, vform.getCityid());
				pstmt.setLong(11,vform.getStateid());
				pstmt.setString(12,vform.getDiscount());
				pstmt.setString(13,vform.getTax());
				pstmt.setLong(14,compid);
				pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result="success";
			} 
			}		
		}catch (NullPointerException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	public String changeStatus(VendorMasterForm vForm, DataSource ds) {
		String result="fail";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=ds.getConnection();
			String sql="UPDATE vendormaster SET ACTIVE=? WHERE VENDORID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, vForm.isActive());
			pstmt.setLong(2, vForm.getVendorid());
			System.out.println(vForm.isActive());
			pstmt.executeUpdate();
			result="success";
			System.out.println(result+ "\nHi");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	public String update(VendorMasterForm vform, DataSource ds) {
		String result="fail";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=ds.getConnection();
			String sql="";
			
			//if(rs.next())result=Common.DUPLICATE_NAME_MESSAGE;
			//else{
				if(!vform.getFirstname().equalsIgnoreCase("")&&!vform.getFirstname().equalsIgnoreCase(null))
				{
					 sql="UPDATE vendormaster SET FIRSTNAME=? , LASTNAME=? , ADDRESS=?, TELNO=? , MOBNO = ? ,EMAILID1=?,EMAILID2=?, WEBSITE=?,Discount=?,Tax=? WHERE VENDORID=?";
					 System.out.println(sql);
					 pstmt=con.prepareStatement(sql);			
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, vform.getFirstname());
			
					pstmt.setString(2, vform.getLastname());

					pstmt.setString(3, vform.getAddress());
			
					pstmt.setString(4, vform.getTeleno());
			
					pstmt.setString(5, vform.getMobileno());
				
					pstmt.setString(6, vform.getEmailid1());
				
					pstmt.setString(7, vform.getEmailid2());
				
					pstmt.setString(8, vform.getWebsite());
					pstmt.setString(9,vform.getDiscount());
				
					pstmt.setString(10,vform.getTax());
					pstmt.setLong(11, vform.getVendorid());
					pstmt.executeUpdate(); 
	    		result="success";
				}
			//}
		}
		 catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

}
