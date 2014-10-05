package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.CityForm;

public class CityDaoImpl 
{

	public List<CityForm> listAll(long stateid, long countryid,
			long compid, DataSource dataSource)
	{
		List<CityForm> cityList = new ArrayList<CityForm>();
		CityForm cityform = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "SELECT * FROM citymaster where stateid=? and compid = '"+compid+"'ORDER BY cityname ASC";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,stateid);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				cityform = new CityForm();
				cityform.setCityid(rs.getLong("CITYID"));
				cityform.setStateid(rs.getLong("STATEID"));
				cityform.setCityname(rs.getString("CITYNAME"));
				cityform.setActive(rs.getBoolean("ACTIVE"));
				cityList.add(cityform);
				
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
				e2.printStackTrace();
			}
		}
		return cityList;
	}

	public String add(long compid, CityForm cityForm, DataSource dataSource)
	{
	    String result = iERPConstants.FAILURE_MESSAGE;
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    try
	    {
	    	con = dataSource.getConnection();
	    	String sql = "SELECT * FROM citymaster WHERE cityname=? and stateid=(select stateid  from statemaster where stateid=?) and compid = '"+compid+"'";
	    	pstmt = con.prepareStatement(sql);
	    	pstmt.setString(1, cityForm.getCityname());
	    	pstmt.setLong(2, cityForm.getStateid());
	    	ResultSet rs = pstmt.executeQuery();
	    	if(rs.next())
	    		result = iERPConstants.DUPLICATE_NAME_MESSAGE;
	    	else
	    	{
	    		if(!cityForm.getCityname().equalsIgnoreCase("") && !cityForm.getCityname().equalsIgnoreCase(null))
	    		{
	    		sql = "insert into citymaster(stateid,cityname,Active,compid) values (?,?,?,?)";
	    		if(pstmt!=null)
	    			pstmt.close();
	    		pstmt=con.prepareStatement(sql);
	    		pstmt.setLong(1, cityForm.getStateid());
	    		pstmt.setString(2, cityForm.getCityname());
	    		pstmt.setBoolean(3, true);
	    		pstmt.setLong(4,compid);
	    		pstmt.executeUpdate();
	    		if(rs!=null)
	    			rs.close();
	    		result = iERPConstants.REC_ADDED;
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
	    	catch (Exception e2) 
	    	{
				e2.printStackTrace();
			}
	    
	    }
		return result;
	}

	public String changeStatus(CityForm cityForm, DataSource dataSource)
    {
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "UPDATE citymaster SET Active=? WHERE cityid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1,cityForm.isActive());
			pstmt.setLong(2, cityForm.getCityid());
			pstmt.executeUpdate();
			result = iERPConstants.REC_STATUS_CHANGED;
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
			   e2.printStackTrace();
			}
		}
		return result;
	}

	public String update(CityForm cityForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM citymaster WHERE cityname COLLATE latin1_general_cs LIKE ? " ;
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);			
			pstmt.setString(1, cityForm.getCityname());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result= iERPConstants.No_Change;
			else{
				sql="UPDATE citymaster SET cityname=? WHERE cityid=?";
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, cityForm.getCityname());				
				pstmt.setLong(2, cityForm.getCityid());
				pstmt.executeUpdate();
				result=iERPConstants.REC_UPDATED;
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

}
