package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.StateForm;

public class StateDaoImpl {

	public List<StateForm> listAll(long countryid, DataSource dataSource) 
	{
		List<StateForm> stateList = new ArrayList<StateForm>();
		StateForm stateform = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM statemaster where countryid=? ORDER BY statename ASC";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, countryid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				stateform = new StateForm();
				stateform.setStateid(rs.getLong("STATEID"));
				stateform.setCountryid(rs.getLong("COUNTRYID"));
				stateform.setStatename(rs.getString("STATENAME"));
				stateform.setActive(rs.getBoolean("ACTIVE"));
				stateList.add(stateform);
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
		return stateList;
	}

	public String add(StateForm stateForm, DataSource dataSource) 
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		System.out.println(result);
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from statemaster WHERE statename=? and countryid='"+stateForm.getCountryid()+"'";
			System.out.println("inside state add"+sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stateForm.getStatename());
		//	pstmt.setLong(2,stateForm.getCountryid());
			System.out.println("inside the DAOIMPL"+stateForm.getCountryid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result = iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				if(!stateForm.getStatename().equalsIgnoreCase("") && !stateForm.getStatename().equalsIgnoreCase(null))
				{
				sql = "insert into statemaster(countryid,statename,Active) VALUES (?,?,?)";
				System.out.println(sql);
			
				pstmt=con.prepareStatement(sql);
				pstmt.setLong(1,stateForm.getCountryid());
				System.out.println(" hi hi "+stateForm.getCountryid());
				pstmt.setString(2, stateForm.getStatename());
				pstmt.setBoolean(3,true);
				pstmt.executeUpdate();
				if(rs!= null)
					rs.close();
				result =iERPConstants.REC_ADDED;
				}
			}
		}
		catch (Exception e2)
		{
		  System.out.println(e2);
		}
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e3) 
			{
				System.out.println(e3);
			}
		}
		return result;
	}

	public String changeStatus(StateForm stateForm, DataSource dataSource) 
	{
		
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE statemaster SET Active=? WHERE stateid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setBoolean(1, stateForm.isActive());
			pstmt.setLong(2, stateForm.getStateid());
			pstmt.executeUpdate();
			result = iERPConstants.REC_STATUS_CHANGED;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}

	public String update(StateForm stateForm, DataSource dataSource) 
	{
		
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM statemaster WHERE statename COLLATE latin1_general_cs LIKE ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stateForm.getStatename());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				result = iERPConstants.No_Change;
			else {
				sql = "UPDATE statemaster SET statename=? WHERE stateid=?";
				if (pstmt != null)
					pstmt.close();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, stateForm.getStatename());
				pstmt.setLong(2, stateForm.getStateid());
				pstmt.executeUpdate();
				result = iERPConstants.REC_UPDATED;
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
		return result;
	}

	public List<StateForm> listactive(long countryid, DataSource dataSource)
	{
		List<StateForm> stateList = new ArrayList<StateForm>();
		StateForm stateform = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
		  con = dataSource.getConnection();
		  String sql = "SELECT * FROM statemaster where COUNTRYID=? and Active=true ORDER BY statename ASC";
		  pstmt=con.prepareStatement(sql);
		  pstmt.setLong(1, countryid);
		  rs=pstmt.executeQuery();
		  while(rs.next())
		  {
			  stateform = new StateForm();
			  stateform.setStateid(rs.getLong("stateid"));
			  stateform.setCountryid(rs.getLong("COUNTRYID"));
			  stateform.setStatename(rs.getString("STATENAME"));
			  stateform.setActive(rs.getBoolean("Active"));
			  stateList.add(stateform);
		  }
		}
		catch (Exception e)
		{
		  System.out.println(e);
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
		return stateList;
	}

}
