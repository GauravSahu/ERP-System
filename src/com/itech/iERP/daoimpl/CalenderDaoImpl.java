package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.AttendanceStatusForm;
import com.itech.iERP.forms.CalenderTypeForm;

public class CalenderDaoImpl 
{

	public List<CalenderTypeForm> listAll(DataSource dataSource) 
	{
		
		List<CalenderTypeForm> list = new  ArrayList<CalenderTypeForm>();
		CalenderTypeForm statusForm = null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "select * from CalendarDayTypemaster order by CalDayTypeName ASC";
		   pstmt = con.prepareStatement(sql);
		   rs = pstmt.executeQuery();
		   while(rs.next())
		   {
			   statusForm = new CalenderTypeForm();
			   statusForm.setCalendertypeId(rs.getInt("CalDayTypeID"));
			   statusForm.setCalendertypeName(rs.getString("CalDayTypeName"));
			   statusForm.setActive(rs.getBoolean("ACTIVE"));
			   list.add(statusForm);
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

	public String add(CalenderTypeForm astatusform, DataSource dataSource)
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;

		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM CalendarDayTypemaster WHERE CalDayTypeName=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, astatusform.getCalendertypeName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else{
				if(!astatusform.getCalendertypeName().equalsIgnoreCase("")&&!astatusform.getCalendertypeName().equalsIgnoreCase(null))
				{
				sql="INSERT INTO CalendarDayTypemaster (CalDayTypeID,CalDayTypeName,ACTIVE) VALUES (?,?,?)";
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, astatusform.getCalendertypeId());
				pstmt.setString(2,astatusform.getCalendertypeName());
				pstmt.setBoolean(3, true);
				pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result=iERPConstants.REC_ADDED;
				}
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

	public String changeStatus(CalenderTypeForm astatusform,
			DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE CalendarDayTypemaster SET ACTIVE=? WHERE CalDayTypeID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1,astatusform.isActive());
			pstmt.setInt(2, astatusform.getCalendertypeId());
			pstmt.executeUpdate();
			result=iERPConstants.REC_STATUS_CHANGED;
			System.out.println(result+ "Hi");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	public String update(CalenderTypeForm astatusform, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM CalendarDayTypemaster WHERE CalDayTypeName COLLATE latin1_general_cs LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,astatusform.getCalendertypeName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.No_Change;
			else{
				if(!astatusform.getCalendertypeName().equalsIgnoreCase("")&&!astatusform.getCalendertypeName().equalsIgnoreCase(null))
				{
					 sql="UPDATE CalendarDayTypemaster SET CalDayTypeName=? WHERE CalDayTypeID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, astatusform.getCalendertypeName());
					pstmt.setLong(2, astatusform.getCalendertypeId());
					pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result=iERPConstants.REC_UPDATED;
				}
			}
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
