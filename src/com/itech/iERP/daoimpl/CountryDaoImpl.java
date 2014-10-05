package com.itech.iERP.daoimpl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.ContryForm;

public class CountryDaoImpl 
{

	public List<ContryForm> listAll(DataSource dataSource) 
	{
		List<ContryForm> list = new ArrayList<ContryForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContryForm countryForm = null;
		
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM countrymaster ORDER BY countryname ASC";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   countryForm = new ContryForm();
			   countryForm.setCountryid(rs.getInt("COUNTRYID"));
			   countryForm.setCountryname(rs.getString("COUNTRYNAME"));
			   countryForm.setActive(rs.getBoolean("ACTIVE"));
			   list.add(countryForm);
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

	public String add(ContryForm countryForm, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con=dataSource.getConnection();
			String sql = "select * from countrymaster where COUNTRYNAME=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, countryForm.getCountryname());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			else
			{
				if(!countryForm.getCountryname().equalsIgnoreCase("") && !countryForm.getCountryname().equalsIgnoreCase(null))
				{
					sql = "insert into countrymaster (COUNTRYID,COUNTRYNAME,ACTIVE) values (?,?,?)";
					if(pstmt!=null)
						pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, countryForm.getCountryid());
					pstmt.setString(2, countryForm.getCountryname());
					pstmt.setBoolean(3, true);
					pstmt.executeUpdate();
					if(rs!=null)
						rs.close();
					result=iERPConstants.REC_ADDED;
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
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public String changeStatus(ContryForm countryForm, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "update countrymaster set active = ? where COUNTRYID=?";
		   pstmt=con.prepareStatement(sql);
		   pstmt.setBoolean(1,countryForm.isActive());
		   pstmt.setInt(2, countryForm.getCountryid());
		   pstmt.executeUpdate();
		   result=iERPConstants.REC_STATUS_CHANGED;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return result;
	}

	public String update(ContryForm countryForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM COUNTRYMASTER WHERE COUNTRYNAME COLLATE latin1_general_cs LIKE ? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,countryForm.getCountryname());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.No_Change;
			else
			{
				if(!countryForm.getCountryname().equalsIgnoreCase("") && !countryForm.getCountryname().equalsIgnoreCase(null))
				{
					sql="UPDATE COUNTRYMASTER SET COUNTRYNAME=? WHERE COUNTRYID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, countryForm.getCountryname());
					pstmt.setLong(2, countryForm.getCountryid());
					pstmt.executeUpdate();
					if(rs!=null)
						rs.close();
					result=iERPConstants.REC_UPDATED;
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
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		return result;
	}

	public List<ContryForm> activeList(DataSource dataSource) 
	{
		List<ContryForm> list = new ArrayList<ContryForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContryForm countryForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from countrymaster where active = true order by COUNTRYNAME ASC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				countryForm = new ContryForm();
				countryForm.setCountryid(rs.getInt("COUNTRYID"));
				countryForm.setCountryname(rs.getString("COUNTRYNAME"));
				countryForm.setActive(rs.getBoolean("active"));
				list.add(countryForm);
				
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

	public boolean excelexport(DataSource dataSource, String filePath) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List details = null;
		String query;
		int numberOfColumns = 0;
		ResultSetMetaData rsmd;
		Label lbl;
		Iterator itr;
		File file;
		String data=filePath;
	//String path="D:\\back up dj/exportIntoExcel.xls";
		String path=filePath+"/CountryMaster.xls";
		System.out.println("PATH--------->>"+path);
		try {
			con=dataSource.getConnection();
			 query="select * from countrymaster";
			 pstmt = con.prepareStatement(query);
			 rs = pstmt.executeQuery();
			 rsmd = rs.getMetaData();
			 numberOfColumns = rsmd.getColumnCount();
			 details = new ArrayList();
			 // Read and store data in list variable.
			 while (rs.next()) {
			 for (int n = 1; n <= numberOfColumns; n++) {
			 details.add(rs.getString(n));
			 }
			 }
			// Excel file properties
			 System.out.println("dj->"+path);
			 file=new File(path);
			 if(!file.exists()){
			 file.createNewFile();
			 }
			 WorkbookSettings wbSettings = new WorkbookSettings();

			 wbSettings.setLocale(new Locale("en", "EN"));
			 WritableWorkbook w = Workbook.createWorkbook(file, wbSettings);
			 w.createSheet("Table Data", 0);
			 WritableSheet s = w.getSheet(0);
			 WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
			 WritableFont.NO_BOLD);
			 WritableCellFormat cf = new WritableCellFormat(wf);
			 cf.setWrap(true);

			 itr = details.iterator();
			 // Write column header
			 int col = 0;
			 for (int j = 1; j <= numberOfColumns; j++) {
			 lbl = new Label(col, 0, rsmd.getColumnName(j), cf);
			 s.addCell(lbl);
			 col++;
			 }
			 // Write content
			 int row = 1;
			 while (itr.hasNext()) {
			 for (int column = 0; column < numberOfColumns; column++) {
			 lbl = new Label(column, row, (String) itr.next(), cf);
			 s.addCell(lbl);
			 }
			 row++;
			 }
			 w.write();
			 w.close();
			 } catch (Exception e) {
			 e.printStackTrace();
			 } finally {
			 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 }
		return true;
	}

}
