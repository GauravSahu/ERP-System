package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.itech.iERP.forms.WareHouseForm;


public class WareHouseDaoImpl 
{

	public List<WareHouseForm> listAllStates(DataSource ds) {
		List<WareHouseForm> list= new ArrayList<WareHouseForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		WareHouseForm state=null;
		try {
			con=ds.getConnection();
			String sql="SELECT * FROM statemaster ORDER BY STATENAME ASC";
			pstmt=con.prepareStatement(sql);		
			rs=pstmt.executeQuery();
			while(rs.next()){
				state= new WareHouseForm();				
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
public List<WareHouseForm> listallvcity(DataSource ds,Long stateid) {
		List<WareHouseForm> list= new ArrayList<WareHouseForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		WareHouseForm city=null;
		try {
			con=ds.getConnection();
			String sql="SELECT * FROM citymaster where  active = true and compid = 33";
			pstmt=con.prepareStatement(sql);	
			System.out.println(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				city= new WareHouseForm();				
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

	public List<WareHouseForm> listVendor(long compid, DataSource dataSource,WareHouseForm vform) {
		List<WareHouseForm> list= new ArrayList<WareHouseForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//WareHouseForm vform=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM warehousemaster where compid = '"+compid+"' ORDER BY warehousename ASC";
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);		
			rs=pstmt.executeQuery();
			while(rs.next()){
				vform= new WareHouseForm();				
				vform.setVendorid(rs.getInt("warehouseID"));
				vform.setFirstname(rs.getString("warehousename"));
				//vform.setLastname(rs.getString("LASTNAME"));
				vform.setAddress(rs.getString("ADDRESS"));
				//System.out.println("Address="+vform.getAddress());
				vform.setTeleno(rs.getString("TELNO"));
				vform.setMobileno(rs.getString("MOBNO"));
				vform.setEmailid1(rs.getString("EMAILID1"));
				vform.setEmailid2(rs.getString("EMAILID2"));
				vform.setWebsite(rs.getString("WEBSITE"));
				//vform.setLogo(rs.getBlob("LOGO"));
				//vform.setVendorname(rs.getString("FIRSTNAME")+" "+rs.getString("LASTNAME"));
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
	
	public String add(WareHouseForm vform, long compid, DataSource ds) {
		String result="fail";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			System.out.println("try-----"+vform.getFirstname());
			
			con=ds.getConnection();
			String sql="SELECT * FROM warehousemaster WHERE warehousename=? and compid = '"+compid+"' ";
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
				sql="INSERT INTO warehousemaster (warehousename,TELNO,ADDRESS,MOBNO,EMAILID1,EMAILID2,WEBSITE,Active,CITY,compid) VALUES (?,?,?,?,?,?,?,?,?,?)";
				System.out.println(sql);
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				//pstmt.setLong(1, clinicForm.getCityid());
				pstmt.setString(1, vform.getFirstname());
				//pstmt.setString(2, vform.getLastname());
				pstmt.setString(2, vform.getTeleno());
				pstmt.setString(3, vform.getAddress());
				pstmt.setString(4, vform.getMobileno());
				pstmt.setString(5, vform.getEmailid1());		
				pstmt.setString(6, vform.getEmailid2());		
				pstmt.setString(7, vform.getWebsite());		
				pstmt.setBoolean(8, true);
				//pstmt.setString(10, vform.getStatename());
				//pstmt.setString(11, vform.getCityname());
				pstmt.setLong(9, vform.getCityid());
				//pstmt.setLong(10,vform.getStateid());
			
				pstmt.setLong(10,compid);
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

	public String changeStatus(WareHouseForm vForm, DataSource ds) {
		String result="fail";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=ds.getConnection();
			String sql="UPDATE warehousemaster SET ACTIVE=? WHERE VENDORID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1,vForm.isActive());
			pstmt.setLong(2,vForm.getVendorid());
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

	public String update(WareHouseForm vform, DataSource ds) {
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
					 sql="UPDATE warehousemaster SET warehousename=? , ADDRESS=?, TELNO=? , MOBNO = ? ,EMAILID1=?,EMAILID2=?, WEBSITE=?, city = ? WHERE warehouseID=?";
					 System.out.println(sql);
					 pstmt=con.prepareStatement(sql);			
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, vform.getFirstname());
			


					pstmt.setString(2, vform.getAddress());
			
					pstmt.setString(3, vform.getTeleno());
			
					pstmt.setString(4, vform.getMobileno());
				
					pstmt.setString(5, vform.getEmailid1());
				
					pstmt.setString(6, vform.getEmailid2());
				
					pstmt.setString(7, vform.getWebsite());
					pstmt.setLong(8,vform.getCityid());
					pstmt.setLong(9, vform.getVendorid());
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
