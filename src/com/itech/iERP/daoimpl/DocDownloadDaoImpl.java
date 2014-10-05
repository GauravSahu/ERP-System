package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.itech.iERP.forms.DocDownloadForm;
import com.itech.iERP.forms.PayslipForm;

public class DocDownloadDaoImpl 
{

	public List<DocDownloadForm> allActiveUsers(long compid, DataSource ds)
	{
		List<DocDownloadForm> list = new ArrayList<DocDownloadForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DocDownloadForm attmodform = null;
		try
		{
		   con = ds.getConnection();
		   String sql = "SELECT * FROM usermaster where COMPANYID='"+compid+"' and active = 1";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new DocDownloadForm();
			   attmodform.setUserid(rs.getString("USERID"));
			   attmodform.setUsername(rs.getString("USERNAME"));
			   list.add(attmodform);
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

	public List<DocDownloadForm> allDocList(DataSource ds)
	{
		List<DocDownloadForm> list= new ArrayList<DocDownloadForm>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DocDownloadForm downloadForm=null;
		
		try {
			con=ds.getConnection();
				String sql="SELECT f.*, u.USERID,u.FIRSTNAME, u.LASTNAME FROM filemanager f, " +
						"usermaster u where (f.USERID=u.USERID)  " +
						" AND u.ACTIVE=TRUE ORDER BY  u.FIRSTNAME ASC";
			pstmt=con.prepareStatement(sql);
			System.out.println(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				downloadForm= new DocDownloadForm();				
				downloadForm.setFid(rs.getInt("f.fileid"));
				downloadForm.setFilename(rs.getString("f.filename"));
				downloadForm.setUserid(rs.getString("u.USERID"));
				downloadForm.setUsername(rs.getString("u.FIRSTNAME")+" "+rs.getString("u.LASTNAME"));
				downloadForm.setFiletype(rs.getString("f.filetype"));
				System.out.println(rs.getString("u.FIRSTNAME")+" "+rs.getString("u.LASTNAME"));
				list.add(downloadForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally
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
