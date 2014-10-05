package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.AttendanceStatusForm;

public class AttenDapImpl 
{

	public List<AttendanceStatusForm> listAll(DataSource dataSource) 
	{
		List<AttendanceStatusForm> list = new  ArrayList<AttendanceStatusForm>();
		AttendanceStatusForm statusForm = null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "select * from attendancestatusmaster order by AttStatusName ASC";
		   pstmt = con.prepareStatement(sql);
		   rs = pstmt.executeQuery();
		   while(rs.next())
		   {
			   statusForm = new AttendanceStatusForm();
			   statusForm.setAstatusId(rs.getInt("AttStatusID"));
			   statusForm.setAstatusName(rs.getString("AttStatusName"));
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

	public String add(AttendanceStatusForm astatusform, DataSource dataSource)
	{
		

		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;

		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM attendancestatusmaster WHERE AttStatusName=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, astatusform.getAstatusName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else{
				if(!astatusform.getAstatusName().equalsIgnoreCase("")&&!astatusform.getAstatusName().equalsIgnoreCase(null))
				{
				sql="INSERT INTO attendancestatusmaster (AttStatusID,AttStatusName,ACTIVE) VALUES (?,?,?)";
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, astatusform.getAstatusId());
				pstmt.setString(2,astatusform.getAstatusName());
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

	public String changeStatus(AttendanceStatusForm astatusform,
			DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE attendancestatusmaster SET ACTIVE=? WHERE AttStatusID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1,astatusform.isActive());
			pstmt.setInt(2, astatusform.getAstatusId());
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

	public String update(AttendanceStatusForm astatusform, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM attendancestatusmaster WHERE AttStatusName COLLATE latin1_general_cs LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,astatusform.getAstatusName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.No_Change;
			else{
				if(!astatusform.getAstatusName().equalsIgnoreCase("")&&!astatusform.getAstatusName().equalsIgnoreCase(null))
				{
					 sql="UPDATE attendancestatusmaster SET AttStatusName=? WHERE AttStatusID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, astatusform.getAstatusName());
					pstmt.setLong(2, astatusform.getAstatusId());
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
