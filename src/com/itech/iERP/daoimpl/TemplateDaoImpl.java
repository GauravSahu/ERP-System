package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.TemplateForm;

public class TemplateDaoImpl {

	public List<TemplateForm> listAll(DataSource dataSource) 
	{
		List<TemplateForm> list = new ArrayList<TemplateForm>();
		TemplateForm tempform = null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from templatemaster order by TEMPLATENAME ASC";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				tempform = new TemplateForm();
				tempform.setTempId(rs.getInt("TEMPLATEID"));
				tempform.setTempName(rs.getString("TEMPLATENAME"));
				tempform.setActive(rs.getBoolean("ACTIVE"));
				list.add(tempform);
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
				// TODO: handle exception
			}
		}
		return list;
	}

	public String addTemplate(TemplateForm tempForm, DataSource dataSource)
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;

		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM templatemaster WHERE TEMPLATENAME=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, tempForm.getTempName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else{
				if(!tempForm.getTempName().equalsIgnoreCase("")&&!tempForm.getTempName().equalsIgnoreCase(null))
				{
				sql="INSERT INTO templatemaster (TEMPLATEID,TEMPLATENAME,ACTIVE) VALUES (?,?,?)";
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, tempForm.getTemplateId());
				pstmt.setString(2, tempForm.getTempName());
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

	public String changeTemp(TemplateForm tempForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="UPDATE templatemaster SET ACTIVE=? WHERE TEMPLATEID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setBoolean(1, tempForm.isActive());
			pstmt.setInt(2, tempForm.getTempId());
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

	public String update(TemplateForm tempForm, DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM templatemaster WHERE TEMPLATENAME COLLATE latin1_general_cs LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, tempForm.getTempName());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())result=iERPConstants.No_Change;
			else{
				if(!tempForm.getTempName().equalsIgnoreCase("")&&!tempForm.getTempName().equalsIgnoreCase(null))
				{
					 sql="UPDATE templatemaster SET TEMPLATENAME=? WHERE TEMPLATEID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, tempForm.getTempName());
					pstmt.setLong(2, tempForm.getTempId());
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
