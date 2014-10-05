package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.AttendanceModuleForm;
import com.itech.iERP.forms.ContryForm;
import com.itech.iERP.forms.SalesModuleForm;
import com.itech.iERP.utils.EncryptUtil;

public class SalesModuleDaoImpl 
{

	public String addEnquiry(SalesModuleForm salesmoduleform,long userid,
			DataSource dataSource)
	{
		java.sql.Timestamp ts = new java.sql.Timestamp(System
				.currentTimeMillis());
		ts.setHours(00);
		ts.setMinutes(00);
		ts.setSeconds(00);
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "insert into enquirymaster(ENQUIRYID,ENQUIRYNAME,EMAILID,ALTEMAILID,MOBILENUMBER,LANDLINENUMBER,ALTMOBILENUMBER,USERID,COMPANYNAME,REQUIREMENTS,ADDRESS,SERVICETYPE,REFERENCE,DATED) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,salesmoduleform.getEnquiryid());
			pstmt.setString(2, salesmoduleform.getFirstname());
			pstmt.setString(3, salesmoduleform.getEmailid());
			pstmt.setString(4, salesmoduleform.getAltemailid());
			pstmt.setString(5, salesmoduleform.getMobilenumber());
			pstmt.setString(6,salesmoduleform.getLandlinenumber());
			pstmt.setString(7,salesmoduleform.getAltmobilenumber());
			pstmt.setLong(8,userid);
			pstmt.setString(9,salesmoduleform.getCompanyname());
			pstmt.setString(10, salesmoduleform.getRequirements());
			pstmt.setString(11,salesmoduleform.getAddress());
			pstmt.setString(12,salesmoduleform.getServicetype());
			pstmt.setString(13,salesmoduleform.getReference());
			pstmt.setTimestamp(14,ts);
			pstmt.executeUpdate();
			result=iERPConstants.REC_ADDED;
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

	public List<SalesModuleForm> enquiryList(DataSource dataSource) 
	{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm salesmoduleform = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from enquirymaster";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				salesmoduleform = new SalesModuleForm();
				salesmoduleform.setEnquiryid((rs.getInt("ENQUIRYID")));
				salesmoduleform.setEnquiryname(rs.getString("ENQUIRYNAME"));
				list.add(salesmoduleform);
				
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
	
	
	public List<SalesModuleForm> enquiryList1(DataSource dataSource) 
	{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm salesmoduleform = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from enquirymaster";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				salesmoduleform = new SalesModuleForm();
				salesmoduleform.setEnqid2((rs.getInt("ENQUIRYID")));
				salesmoduleform.setEnquiryname(rs.getString("ENQUIRYNAME"));
				list.add(salesmoduleform);
				
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


	public List<SalesModuleForm> userList(DataSource dataSource) 
	{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm salesmoduleform = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from usermaster where ACTIVE=1";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				salesmoduleform = new SalesModuleForm();
				salesmoduleform.setUserid((rs.getString("USERID")));
				salesmoduleform.setUsername(rs.getString("USERNAME"));
				list.add(salesmoduleform);
				
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
		return list;
	}

	public String addFollowup(SalesModuleForm salesmoduleform, long userid,Timestamp ftimets,
			DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "insert into followup(ENQUIRYID,FDATE,USERID,DETAILS,ASSIGNEDTO) values (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,salesmoduleform.getEnquiryid());
			pstmt.setTimestamp(2,ftimets);
			pstmt.setLong(3,userid);
			pstmt.setString(4, salesmoduleform.getFollowupdetails());
			pstmt.setString(5,salesmoduleform.getUserid());
			pstmt.executeUpdate();
			result=iERPConstants.REC_ADDED;
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

	public String addAppointment(SalesModuleForm salesmoduleform, long userid,
			Timestamp ftimets, DataSource dataSource)
	{
		java.sql.Timestamp ts = new java.sql.Timestamp(System
				.currentTimeMillis());
		String sql=null;
		ts.setHours(00);
		ts.setMinutes(00);
		ts.setSeconds(00);
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
		    sql = "insert into appointment(APPOINTMENTID,APPDATE,USERID,DETAILS,ASSIGNEDTO,DATE,place,ENQUIRYID) values (?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,salesmoduleform.getAppointmentid());
			pstmt.setTimestamp(2,ftimets);
			pstmt.setLong(3,userid);
			pstmt.setString(4, salesmoduleform.getAppdetails());
			pstmt.setString(5,salesmoduleform.getUserid());
			pstmt.setTimestamp(6,ts);
			pstmt.setString(7, salesmoduleform.getAddress());
			pstmt.setInt(8,salesmoduleform.getEnquiryid());
			pstmt.executeUpdate();
			result=iERPConstants.REC_ADDED;
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

	public String saveQuotation(SalesModuleForm salesmoduleform, long userid,
			String fileName, DataSource dataSource)
	{
		java.sql.Timestamp ts = new java.sql.Timestamp(System
				.currentTimeMillis());
		String sql=null;
		ts.setHours(00);
		ts.setMinutes(00);
		ts.setSeconds(00);
		Connection con = null;
		PreparedStatement pstmt = null;
		SalesModuleForm salesmodform = null;
		String result = iERPConstants.FAILURE_MESSAGE;
		try {
			con = dataSource.getConnection();
		    sql = "insert into quotation(QUATATIONID,FDATE,USERID,DETAILS,PROPOSALDOC,cost) values(?,?,?,?,?,?)";
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,salesmoduleform.getQuotationid());
				pstmt.setTimestamp(2,ts);
				pstmt.setLong(3,userid);
				pstmt.setString(4, salesmoduleform.getQdetails());
				pstmt.setString(5,fileName);
				pstmt.setInt(6,salesmoduleform.getPrice());
				pstmt.executeUpdate();
				result =iERPConstants.REC_ADDED;
				
			}


		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return result;
	}

	public List<SalesModuleForm> getenquiryreports(Timestamp ftimets,
			Timestamp ttimets, SalesModuleForm salesmodform,
			DataSource dataSource)
			{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm sform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from enquirymaster as e, usermaster u where(u.USERID=e.USERID) and DATED between '"+ftimets+"' and '"+ttimets+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				sform = new SalesModuleForm();
				sform.setUserid(rs.getString("e.USERID"));
				sform.setEnquiryname(rs.getString("e.ENQUIRYNAME"));
				sform.setDated(rs.getTimestamp("e.DATED"));
				sform.setRequirements(rs.getString("e.REQUIREMENTS"));
				sform.setServicetype(rs.getString("e.SERVICETYPE"));
				sform.setUsername(rs.getString("u.USERNAME"));
				list.add(sform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return list;
	}

	public List<SalesModuleForm> getenquiryrepsales(
			SalesModuleForm salesmodform, DataSource dataSource) 
			{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm sform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from enquirymaster as e, usermaster u where(u.USERID=e.USERID) and DATED between '"+salesmodform.getEnquiryid()+"' and '"+salesmodform.getEnqid2()+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				sform = new SalesModuleForm();
				sform.setUserid(rs.getString("e.USERID"));
				sform.setEnquiryname(rs.getString("e.ENQUIRYNAME"));
				sform.setDated(rs.getTimestamp("e.DATED"));
				sform.setRequirements(rs.getString("e.REQUIREMENTS"));
				sform.setServicetype(rs.getString("e.SERVICETYPE"));
				sform.setUsername(rs.getString("u.USERNAME"));
				list.add(sform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return list;
	}

	public List<SalesModuleForm> getenquiryrepgen(SalesModuleForm salesmodform,
			DataSource dataSource)
	{
	List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	SalesModuleForm sform = null;
	String sql = null;
	try
	{
		con = dataSource.getConnection();
		sql = "select * from enquirymaster as e, usermaster as u where (u.USERID=e.USERID) ";
		System.out.println(sql);
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			sform = new SalesModuleForm();
			sform.setUserid(rs.getString("e.USERID"));
			sform.setEnquiryname(rs.getString("e.ENQUIRYNAME"));
			sform.setDated(rs.getTimestamp("e.DATED"));
			sform.setRequirements(rs.getString("e.REQUIREMENTS"));
			sform.setServicetype(rs.getString("e.SERVICETYPE"));
			sform.setUsername(rs.getString("u.USERNAME"));
			list.add(sform);
		}
	}catch (SQLException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	catch (Exception e) 
	{e.printStackTrace();
		// TODO: handle exception
	}finally {
		try {
			if (con != null)
				con.close();
		} catch (Exception e2) 
		{
			e2.printStackTrace();
		}
	}
	return list;
	}

	public List<SalesModuleForm> getfollowupreports(Timestamp ftimets,
			Timestamp ttimets, SalesModuleForm salesmodform,
			DataSource dataSource)
			{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm sform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from enquirymaster as e, usermaster as u, followup as f where(u.USERID=e.USERID)  and FDATE between '"+ftimets+"' and '"+ttimets+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				sform = new SalesModuleForm();
				sform.setUserid(rs.getString("e.USERID"));
				sform.setEnquiryname(rs.getString("e.ENQUIRYNAME"));
				sform.setDated(rs.getTimestamp("e.DATED"));
				sform.setRequirements(rs.getString("e.REQUIREMENTS"));
				sform.setServicetype(rs.getString("e.SERVICETYPE"));
				sform.setUsername(rs.getString("u.USERNAME"));
				
				list.add(sform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return list;
	}

	public List<SalesModuleForm> getfollowuprepsales(
			SalesModuleForm salesmodform, DataSource dataSource)
			{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm sform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from enquirymaster as e, usermaster u where(u.USERID=e.USERID) and DATED between '"+salesmodform.getEnquiryid()+"' and '"+salesmodform.getEnqid2()+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				sform = new SalesModuleForm();
				sform.setUserid(rs.getString("e.USERID"));
				sform.setEnquiryname(rs.getString("e.ENQUIRYNAME"));
				sform.setDated(rs.getTimestamp("e.DATED"));
				sform.setRequirements(rs.getString("e.REQUIREMENTS"));
				sform.setServicetype(rs.getString("e.SERVICETYPE"));
				sform.setUsername(rs.getString("u.USERNAME"));
				list.add(sform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return list;
	}

	public List<SalesModuleForm> getfollowuprepgen(
			SalesModuleForm salesmodform, DataSource dataSource) 
			{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm sform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from enquirymaster as e, usermaster as u where (u.USERID=e.USERID) ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				sform = new SalesModuleForm();
				sform.setUserid(rs.getString("e.USERID"));
				sform.setEnquiryname(rs.getString("e.ENQUIRYNAME"));
				sform.setDated(rs.getTimestamp("e.DATED"));
				sform.setRequirements(rs.getString("e.REQUIREMENTS"));
				sform.setServicetype(rs.getString("e.SERVICETYPE"));
				sform.setUsername(rs.getString("u.USERNAME"));
				list.add(sform);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) 
		{e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return list;
	}

	public List<SalesModuleForm> getquotationreports(Timestamp ftimets,
			Timestamp ttimets, SalesModuleForm salesmodform,
			DataSource dataSource)
			{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm sform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from enquirymaster as e, usermaster as u, quotation as q where(u.USERID=e.USERID)  and FDATE between '"+ftimets+"' and '"+ttimets+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				sform = new SalesModuleForm();
				sform.setUserid(rs.getString("e.USERID"));
				sform.setEnquiryname(rs.getString("e.ENQUIRYNAME"));
				sform.setDated(rs.getTimestamp("e.DATED"));
				sform.setRequirements(rs.getString("e.REQUIREMENTS"));
				sform.setServicetype(rs.getString("e.SERVICETYPE"));
				sform.setUsername(rs.getString("u.USERNAME"));
				sform.setFname(rs.getString("q.PROPOSALDOC"));
				sform.setPrice(rs.getInt("q.cost"));
				list.add(sform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return list;
	}

	public List<SalesModuleForm> getquotationrepsales(
			SalesModuleForm salesmodform, DataSource dataSource)
			{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm sform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from enquirymaster as e, usermaster u , quotation as q where(u.USERID=e.USERID) and DATED between '"+salesmodform.getEnquiryid()+"' and '"+salesmodform.getEnqid2()+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				sform = new SalesModuleForm();
				sform.setUserid(rs.getString("e.USERID"));
				sform.setEnquiryname(rs.getString("e.ENQUIRYNAME"));
				sform.setDated(rs.getTimestamp("e.DATED"));
				sform.setRequirements(rs.getString("e.REQUIREMENTS"));
				sform.setServicetype(rs.getString("e.SERVICETYPE"));
				sform.setUsername(rs.getString("u.USERNAME"));
				sform.setFname(rs.getString("q.PROPOSALDOC"));
				list.add(sform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return list;
	}

	public List<SalesModuleForm> getquotationrepgen(
			SalesModuleForm salesmodform, DataSource dataSource)
			{
		List<SalesModuleForm> list = new ArrayList<SalesModuleForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SalesModuleForm sform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from enquirymaster as e, usermaster as u , quotation as q  where (u.USERID=e.USERID) ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				sform = new SalesModuleForm();
				sform.setUserid(rs.getString("e.USERID"));
				sform.setEnquiryname(rs.getString("e.ENQUIRYNAME"));
				sform.setDated(rs.getTimestamp("e.DATED"));
				sform.setRequirements(rs.getString("e.REQUIREMENTS"));
				sform.setServicetype(rs.getString("e.SERVICETYPE"));
				sform.setUsername(rs.getString("u.USERNAME"));
				sform.setFname(rs.getString("q.PROPOSALDOC"));
				list.add(sform);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) 
		{e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return list;
	}
  
	
	
}
