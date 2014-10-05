package com.itech.iERP.daoimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.PayslipForm;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PayslipDaoImpl
{

	private Properties configProp = new Properties();
	
	public List<PayslipForm> listEmp(long userid, DataSource dataSource)
	{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster where COMPANYID='"+userid+"' and active = 1";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new PayslipForm();
			   attmodform.setUserId1(rs.getString("USERID"));
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

	public List<PayslipForm> listComp(long userid, DataSource dataSource) 
	{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM componentmaster where COMPANYID='"+userid+"'";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new PayslipForm();
			   attmodform.setComponentName(rs.getString("COMPONENTNAME"));
			   
			   //attmodform.setUsername(rs.getString("USERNAME"));
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

	public List<PayslipForm> listuseinfo(long userid1, DataSource dataSource) 
	{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from usermaster a,companymaster b where(a.COMPANYID=b.COMPANYID) and userid='"+userid1+"'  ";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new PayslipForm();
				vform.setUserId(rs.getInt("a.USERID"));
			    vform.setUsername(rs.getString("a.USERNAME"));
				vform.setCompanyName(rs.getString("b.COMPANYNAME"));
			
				list.add(vform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}finally
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

	public List<PayslipForm> salarysave(PayslipForm payslip, long userid,
			DataSource dataSource)
			{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		PayslipForm vform = null;
		Connection con = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
        double a = 0.0;
        double b= 0.0;
        double  c= 0.0;
        double d=0.0;
        double e=0.0;
        String f=null;
        String g = null;
        int annaul=0;
        int ctc = payslip.getCtc();
        try
		{
			con=dataSource.getConnection();
			ps=con.prepareStatement("select * from componentmaster where COMPANYID='"+userid+"'");
			rs=ps.executeQuery();
			if(rs.next())
			{
				
				 a = Double.parseDouble(rs.getString("VALUE"));
			}
			//System.out.println("Component name "+a);
			if(rs.next())
			{
				
				 b=Double.parseDouble(rs.getString("VALUE"));
				
				 
			}
			System.out.println("Component name b"+b);
			
			if(rs.next())
			{
				
				 c=Double.parseDouble(rs.getString("VALUE"));
					
				
			}
			if(rs.next())
			{
				
				 d=Double.parseDouble(rs.getString("VALUE"));
				
				 
			}
			if(rs.next())
			{
				
				 e=Double.parseDouble(rs.getString("VALUE"));
				 
			}
			
		}
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}
        
		try
		{
			vform = new PayslipForm();
			annaul=(ctc/12);
			System.out.println("ctc monthly "+annaul);
			double basic=((annaul/100)*a);
			System.out.println("basic "+basic);
			vform.setBasic(String.valueOf(basic));
			
			double da =((annaul/100)*b);
			System.out.println("DA "+da);
			vform.setDa(String.valueOf(da));
			
			double pa = ((annaul/100)*c);
			System.out.println("PA "+pa);
			vform.setPa(String.valueOf(pa));
			
			double oa = ((annaul/100)*d);
			System.out.println("OA "+oa);
			vform.setOa(String.valueOf(oa));
			
			
			double lb = ((annaul/100)*e);
			System.out.println("LB "+lb);
			vform.setLb(String.valueOf(lb));
			
			if(payslip.getCtc()<=150000)
			{
				vform. setPt(150);
			}
			
			else if(payslip.getCtc()<=300000)
 			{
				vform.setPt(300);
			}
			else
			{
				vform.setPt(1000);
			}
			
			vform.setSalarypay(String.valueOf(0));
			
//		    vform.setUsername(rs.getString("a.USERNAME"));
//			vform.setCompanyName(rs.getString("b.COMPANYNAME"));
		
			list.add(vform);
		}
		catch (Exception e2)
		{
			// TODO: handle exception
			System.out.println(e2);
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
	
	public String addsal(Object attribute,Object attribute1, PayslipForm payslip, long userid,
			DataSource dataSource)
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con=null;

		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="SELECT * FROM salaryallocation WHERE USERID='"+attribute1+"' and COMPANYID='"+userid+"'";
			System.out.println(sql);
			pstmt=con.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				{
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
				//UPDATE statemaster SET Active=? WHERE stateid=?
				sql="update salaryallocation SET COMPANYID=?, CTC=?,BASIC=?,DA=?,PA=?,OA=?,LB=?,PT=?,SP=? where userid='"+attribute1+"'";
				System.out.println(sql);
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setLong(1, userid);
				pstmt.setObject(2,attribute);
				pstmt.setString(3, payslip.getBasic());
				pstmt.setString(4, payslip.getDa());
				pstmt.setString(5, payslip.getPa());
				pstmt.setString(6, payslip.getOa());
				pstmt.setString(7, payslip.getLb());
				pstmt.setInt(8, payslip.getPt());
				pstmt.setString(9,payslip.getSalarypay());
				
				pstmt.executeUpdate();
				}
			else{
				
				sql="INSERT INTO salaryallocation (COMPANYID,USERID,CTC,BASIC,DA,PA,OA,LB,PT,SP) VALUES (?,?,?,?,?,?,?,?,?,?)";
				System.out.println(sql);
				if(pstmt!=null)pstmt.close();
				pstmt=con.prepareStatement(sql);
				pstmt.setLong(1, userid);
				pstmt.setObject(2,attribute1);
				pstmt.setObject(3,attribute);
				pstmt.setString(4, payslip.getBasic());
				pstmt.setString(5, payslip.getDa());
				pstmt.setString(6, payslip.getPa());
				pstmt.setString(7, payslip.getOa());
				pstmt.setString(8, payslip.getLb());
				pstmt.setInt(9, payslip.getPt());
				pstmt.setString(10,payslip.getSalarypay());
				pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result=iERPConstants.REC_ADDED;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		System.out.println(result);
		return result;
	}

	public List<PayslipForm> modsalary(PayslipForm payslip,
			DataSource dataSource) 
			{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm vform = null;
		String sql = null;
		try
		{
			con = dataSource.getConnection();
			sql = "select * from salaryallocation";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				vform = new PayslipForm();
				vform.setUserId(rs.getInt("USERID"));
			    //vform.setUsername(rs.getString("USERNAME"));
				vform.setCompanyName(rs.getString("COMPANYID"));
				vform.setBasic(rs.getString("BASIC"));
				vform.setDa(rs.getString("DA"));
				vform.setPa(rs.getString("PA"));
				vform.setOa(rs.getString("OA"));
			    vform.setLb(rs.getString("LB"));
			    vform.setPt(rs.getInt("PT"));	
			    vform.setSalarypay(rs.getString("SP"));   
			    System.out.println(" Dispaly Issue "+vform.getUserId());
			    list.add(vform);
			}
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	      }
	
	public String addfinsalary(PayslipForm payslip,long userid,Object ctc, Object id1,
			long compid, String sal, String basic, String da,
			String pa, String oa, String lb, String pt,String sp,DataSource dataSource) 
	{
		PayslipForm vform = null;
		String result=null; 
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
					
			    conn=dataSource.getConnection();
			    /*sql="select * from finalsalary where USERID ='"+userid1+"' and COMPANYID='"+userid+"' and SalMonth='"+payslip.getMonth1()+"'  ";
			    pstmt=conn.prepareStatement(sql);
			    rs=pstmt.executeQuery();
			    if(rs.next())
			    {
			    	result = iERPConstants.DUPLICATE_NAME_MESSAGE;
			    }
			    else
			    {*/
				sql="INSERT INTO finalsalary(COMPANYID,USERID,CTC,BASIC,DA,PA,OA,LB,PT,SP,IT,LOP,OD,SalMonth,SalYear) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				if(pstmt!=null)pstmt.close();
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1, compid);
				pstmt.setLong(2,userid);
				pstmt.setObject(3,ctc);
				pstmt.setString(4, basic);
				pstmt.setString(5, da);
				pstmt.setString(6, pa);
				pstmt.setString(7, oa);
				pstmt.setString(8, lb);
				pstmt.setString(9, pt);
				pstmt.setString(10,sp);
				pstmt.setInt(11,'1');
				pstmt.setInt(12,'6');
				pstmt.setInt(13,'4');
				pstmt.setString(14,payslip.getMonth1());
				pstmt.setString(15,payslip.getYear1());
				pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result=iERPConstants.REC_ADDED;
			   // }
			}
		 catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null)conn.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	public List<PayslipForm> listComp(DataSource dataSource) 
	{
	    List<PayslipForm> list = new ArrayList<PayslipForm>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    PayslipForm pform = null;
	    try
	    {
	    	con=dataSource.getConnection();
	    	String sql = "select * from usermaster where active =1";
	    	pstmt=con.prepareStatement(sql);
	    	rs=pstmt.executeQuery();
	    	while(rs.next())
	    	{
	    		pform = new PayslipForm();
	    		pform.setUserId1(rs.getString("USERID"));
	    		pform.setUsername(rs.getString("USERNAME"));
	    		list.add(pform);
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
		return list;
	}

	public List<PayslipForm> listEmp2(long userid, DataSource dataSource) 
	{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	    PayslipForm pform = null;
	    try
	    {
	    	con = dataSource.getConnection();
	    	String sql = "select * from usermaster where active =1 and COMPANYID='"+userid+"' ";
	    	pstmt=con.prepareStatement(sql);
	    	rs=pstmt.executeQuery();
	    	while(rs.next())
	    	{
	    		pform = new PayslipForm();
	    		pform.setUserId2(rs.getInt("USERID"));
	    		pform.setUsername(rs.getString("USERNAME"));
	    		list.add(pform);
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
		return list;
	}
	
	
	public String printpdf(DataSource ds) {
		String result = "Failure";
		try {
			 
            OutputStream file = new FileOutputStream(new File("C:\\Payslip.pdf"));
            Paragraph para = new Paragraph();
            Document document = new Document();
            PdfWriter.getInstance(document, file);

          //Inserting Image in PDF
               Image image = Image.getInstance ("G:\\iERP_PROJECT\\iERP\\Itech Solutions logo.png");
               image.scaleAbsolute(80f,40f);//image width,height  
               image.setAlignment(Element.ALIGN_CENTER);
               document.open();
               Font font1 = new Font(Font.FontFamily.COURIER ,10, Font.BOLD);
                 
               document.add(image);
               document.add(Chunk.NEWLINE); 
               para = new Paragraph("Itech Solutions",font1);
               para.setAlignment(Element.ALIGN_CENTER);
               document.add(para);
               para = new Paragraph("Bangalore",font1);
               para.setAlignment(Element.ALIGN_CENTER);
               document.add(para);
               Calendar cal = Calendar.getInstance();
               java.util.Date d = new java.util.Date(cal.getTimeInMillis());
               String month = new SimpleDateFormat("MMMM").format(d);
               int year = cal.get(Calendar.YEAR);
               System.out.println("Month "+month);
              
               para = new Paragraph("Pay-slip for the month of " + month +" " + year,font1 );
               para.setAlignment(Element.ALIGN_CENTER);
               document.add(para);
               document.add(Chunk.NEWLINE);
               PdfPTable table = new PdfPTable(2); // Code 1

       		// Code 2
       	
       		table.addCell(new Phrase("Employee No ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table.addCell(new Phrase("I0035", FontFactory.getFont(FontFactory.COURIER,10)));         		
       		// Code 3
       		table.addCell(new Phrase("Name ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table.addCell(new Phrase("Vanishree K ", FontFactory.getFont(FontFactory.COURIER,10)));
       		
       		// Code 4
       		table.addCell(new Phrase("Designation ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table.addCell(new Phrase("Software Developer ", FontFactory.getFont(FontFactory.COURIER,10)));
       		
       		// Code 5
       		
       		document.add(table);
       		document.add(Chunk.NEWLINE);
       		 
       		PdfPTable table1 = new PdfPTable(6); // 3 columns.
       		table1.setTotalWidth(new float[]{ 136,60,110,45,110,90});
       		/*PdfPCell cell1 = new PdfPCell(new Paragraph("Earnings"));
              PdfPCell cell2 = new PdfPCell(new Paragraph("Rs"));
              PdfPCell cell3 = new PdfPCell(new Paragraph("Deductions"));
              PdfPCell cell4 = new PdfPCell(new Paragraph("Rs"));
              PdfPCell cell5 = new PdfPCell(new Paragraph("Other Details"));
              PdfPCell cell6 = new PdfPCell(new Paragraph("Rs"));
              table1.addCell(cell1);
              table1.addCell(cell2);
              table1.addCell(cell3);
              table1.addCell(cell4);
              table1.addCell(cell5);
              table1.addCell(cell6);*/
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("Earnings ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		table1.addCell(new Phrase("Rs ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		table1.addCell(new Phrase("Deductions ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		table1.addCell(new Phrase("Rs ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		table1.addCell(new Phrase("Other Details ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		table1.addCell(new Phrase("  ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Basic ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Professional Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Date of Joining ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("02-04-2012 ", FontFactory.getFont(FontFactory.COURIER,10)));
               
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Dearness Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("210 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Income Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Present Days ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("22 ", FontFactory.getFont(FontFactory.COURIER,10)));
               
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Performance Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
      		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("1925 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("LOP ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("367 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Working Days ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("25 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Other Allowances ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("1182 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Other Deductions ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Calendar Days ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("30 ", FontFactory.getFont(FontFactory.COURIER,10)));
        	
              
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Special Pay ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Location ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("Bangalore ", FontFactory.getFont(FontFactory.COURIER,10)));       
              
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Loyality bonus monthly comp  ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("825 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Pan No ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" - ", FontFactory.getFont(FontFactory.COURIER,10)));
              
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
      		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Leave For the Month ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("3 ", FontFactory.getFont(FontFactory.COURIER,10)));
              
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Actual Performance %  ", FontFactory.getFont(FontFactory.COURIER,10)));
      		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" 80 ", FontFactory.getFont(FontFactory.COURIER,10)));
              
              table1.addCell("  ");
              table1.addCell("  ");
              table1.addCell("  ");
              table1.addCell("  ");
              table1.addCell("  ");
              table1.addCell("  ");
              
              table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
          	table1.addCell(new Phrase("Total Earnings  ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
          	table1.addCell(new Phrase("7517 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
          	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
          	table1.addCell(new Phrase("Total Deductions ", FontFactory.getFont(FontFactory.COURIER,10)));
          	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
          	table1.addCell(new Phrase("367 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
          	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
          	table1.addCell(new Phrase("Net Salary Rupees  ", FontFactory.getFont(FontFactory.COURIER,10)));
          	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
          	table1.addCell(new Phrase("7150 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
              
              document.add(table1);
              document.add(Chunk.NEWLINE);
              document.add(Chunk.NEWLINE);
              document.add(Chunk.NEWLINE);
              para = new Paragraph("www.itechsolutions.in",font1);
              para.setAlignment(Element.ALIGN_CENTER);
              document.add(para);
              document.close();
               file.close();
               result="PDF Generated Successfully!..";
               System.out.println("Pdf generated normally");
               
           
      } catch (Exception e) 
      {
          e.printStackTrace();
      }
      return result;
	}

	public PayslipForm gePayslip(PayslipForm payform, String mon, String yr,
			String uid, DataSource dataSource) 
	{
		PayslipForm loginform=null;
    	Connection con=null;
    	PreparedStatement pstmt=null;
    	ResultSet rs=null;
    	
    	try 
    	{
    		con=dataSource.getConnection();
    		//String sql="select username,password,roleid,companylogo from usermaster,companymaster where (usermaster.companyid = companymaster.companyid) where username=? and password=? and Active=true ";
    		String sql="select * from finalsalary where SalMonth='"+mon+"' and SalYear='"+yr+"' and USERID='"+uid+"' ";	
    	    System.out.println("sql query is "+sql);
    		pstmt=con.prepareStatement(sql);
    		rs=pstmt.executeQuery();
    		while(rs.next())
    		{
    			loginform=new PayslipForm();
    			loginform.setUserId1(rs.getString("userid"));
    		    loginform.setBasic(rs.getString("BASIC"));
    		    loginform.setDa(rs.getString("DA"));
    		    loginform.setPa(rs.getString("PA"));
    		    loginform.setOa(rs.getString("OA"));
    		    loginform.setLb(rs.getString("LB"));
    		    loginform.setPt(rs.getInt("PT"));
    		    loginform.setSa(rs.getString("SP"));
    		    loginform.setIt(rs.getString("IT"));
    		}
    		
		} catch (Exception e) 
		{
			loginform=null;
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(con!=null)
				con.close();
			}
			catch (Exception e2) {}
		}
		return loginform;
	}

	public String printpdf(PayslipForm payslip,int pt, DataSource dataSource)
	{
		String result = "Failure";
		try {
			 
            OutputStream file = new FileOutputStream(new File("C:\\Payslip12.pdf"));
            Paragraph para = new Paragraph();
            Document document = new Document();
            PdfWriter.getInstance(document, file);

          //Inserting Image in PDF
               Image image = Image.getInstance ("G:\\iERP_PROJECT\\iERP\\Itech Solutions logo.png");
               image.scaleAbsolute(80f,40f);//image width,height  
               image.setAlignment(Element.ALIGN_CENTER);
               document.open();
               Font font1 = new Font(Font.FontFamily.COURIER ,10, Font.BOLD);
                 
               document.add(image);
               document.add(Chunk.NEWLINE); 
               para = new Paragraph("Itech Solutions",font1);
               para.setAlignment(Element.ALIGN_CENTER);
               document.add(para);
               para = new Paragraph("Bangalore",font1);
               para.setAlignment(Element.ALIGN_CENTER);
               document.add(para);
               //Calendar cal = Calendar.getInstance();
               //java.util.Date d = new java.util.Date(cal.getTimeInMillis());
               String month = payslip.getMonth1();
               String year = payslip.getYear1();
               System.out.println("Month "+month);
              
               para = new Paragraph("Pay-slip for the month of " + month +" " + year,font1 );
               para.setAlignment(Element.ALIGN_CENTER);
               document.add(para);
               document.add(Chunk.NEWLINE);
               PdfPTable table = new PdfPTable(2); // Code 1

       		// Code 2
       	
       		table.addCell(new Phrase("Employee No ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table.addCell(new Phrase(payslip.getUserId1(), FontFactory.getFont(FontFactory.COURIER,10)));         		
       		// Code 3
       		table.addCell(new Phrase("Name ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table.addCell(new Phrase("Vanishree K ", FontFactory.getFont(FontFactory.COURIER,10)));
       		
       		// Code 4
       		table.addCell(new Phrase("Designation ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table.addCell(new Phrase("Software Developer ", FontFactory.getFont(FontFactory.COURIER,10)));
       		
       		// Code 5
       		
       		document.add(table);
       		document.add(Chunk.NEWLINE);
       		 
       		PdfPTable table1 = new PdfPTable(6); // 3 columns.
       		table1.setTotalWidth(new float[]{ 136,60,110,45,110,90});
       		/*PdfPCell cell1 = new PdfPCell(new Paragraph("Earnings"));
              PdfPCell cell2 = new PdfPCell(new Paragraph("Rs"));
              PdfPCell cell3 = new PdfPCell(new Paragraph("Deductions"));
              PdfPCell cell4 = new PdfPCell(new Paragraph("Rs"));
              PdfPCell cell5 = new PdfPCell(new Paragraph("Other Details"));
              PdfPCell cell6 = new PdfPCell(new Paragraph("Rs"));
              table1.addCell(cell1);
              table1.addCell(cell2);
              table1.addCell(cell3);
              table1.addCell(cell4);
              table1.addCell(cell5);
              table1.addCell(cell6);*/
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("Earnings ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		table1.addCell(new Phrase("Rs ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		table1.addCell(new Phrase("Deductions ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		table1.addCell(new Phrase("Rs ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		table1.addCell(new Phrase("Other Details ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		table1.addCell(new Phrase("  ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
       		
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Basic ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(payslip.getBasic(), FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Professional Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(pt));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Date of Joining ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("02-04-2012", FontFactory.getFont(FontFactory.COURIER,10)));
               
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Dearness Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(payslip.getDa(), FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Income Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(payslip.getIt(), FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Present Days ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("22 ", FontFactory.getFont(FontFactory.COURIER,10)));
               
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Performance Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
      		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(payslip.getPa(), FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("LOP ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("367 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Working Days ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("25 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Other Allowances ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(payslip.getOa(), FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Other Deductions ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(payslip.getOa(), FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Calendar Days ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("30 ", FontFactory.getFont(FontFactory.COURIER,10)));
        	
              
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Special Pay ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("0", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Location ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("Bangalore ", FontFactory.getFont(FontFactory.COURIER,10)));       
              
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Loyality bonus monthly comp  ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("825 ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Pan No ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" - ", FontFactory.getFont(FontFactory.COURIER,10)));
              
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
      		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Leave For the Month ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("3 ", FontFactory.getFont(FontFactory.COURIER,10)));
              
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       		table1.addCell(new Phrase("Actual Performance %  ", FontFactory.getFont(FontFactory.COURIER,10)));
      		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       		table1.addCell(new Phrase(" 80 ", FontFactory.getFont(FontFactory.COURIER,10)));
              
              table1.addCell("  ");
              table1.addCell("  ");
              table1.addCell("  ");
              table1.addCell("  ");
              table1.addCell("  ");
              table1.addCell("  ");
              
            table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
          	table1.addCell(new Phrase("Total Earnings  ", FontFactory.getFont(FontFactory.COURIER,10)));
       		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
          	table1.addCell(new Phrase("7517 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
          	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
          	table1.addCell(new Phrase("Total Deductions ", FontFactory.getFont(FontFactory.COURIER,10)));
          	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
          	table1.addCell(new Phrase("367 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
          	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
          	table1.addCell(new Phrase("Net Salary Rupees  ", FontFactory.getFont(FontFactory.COURIER,10)));
          	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
          	table1.addCell(new Phrase("7150 ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
              
              document.add(table1);
              document.add(Chunk.NEWLINE);
              document.add(Chunk.NEWLINE);
              document.add(Chunk.NEWLINE);
              para = new Paragraph("www.itechsolutions.in",font1);
              para.setAlignment(Element.ALIGN_CENTER);
              document.add(para);
              document.close();
               file.close();
               result="PDF Generated Successfully!..";
               System.out.println("Pdf generated normally");
               
           
      } catch (Exception e) 
      {
          e.printStackTrace();
      }
      return result;
	}

	public List<PayslipForm> listcompallo(long userid, DataSource dataSource)
	{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM componentmaster where COMPANYID='"+userid+"'";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new PayslipForm();
			   attmodform.setComponentName(rs.getString("COMPONENTNAME"));
			   
			   //attmodform.setUsername(rs.getString("USERNAME"));
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

	public List<PayslipForm> listallcomponent(long userid, DataSource dataSource) 
	{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm payslipform = null;
  
		
		try
		{
			
		   con = dataSource.getConnection();
		   InputStream in =  this.getClass().getClassLoader().getResourceAsStream("/ApplicationResources.properties");
			   			try
			   			{   				
			   configProp.load(in);
			   			}
			   			catch 
			   			(IOException e) 
			   {
			   				
			   e.printStackTrace();
			   	}
	
		//String sql= configProp.getProperty("select.salarycomponent");;
		String sql = "SELECT * FROM componentmaster where COMPANYID = '"+userid+"'";
		System.out.println("sql "+sql);
		//pstmt.setLong(1,userid);
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   payslipform = new PayslipForm();
		       payslipform.setComponentid(rs.getString("COMPONENTID"));
			   payslipform.setComponentName(rs.getString("COMPONENTNAME"));
			   payslipform.setComponenttype(rs.getString("componenttype"));
               
			   list.add(payslipform);
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

	public String savesalaries(long userid, String componentname, String componentid, String value, String componenttype, PayslipForm payform,
			DataSource dataSource)
	{
    PayslipForm vform = null;
	String result=iERPConstants.FAILURE_MESSAGE; 
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;
	try {
	        int i = 0;
		    conn=dataSource.getConnection();
		    sql="select * from componentwithvalues where USERID ='"+payform.getUserId1()+"' and componentid='"+componentid+"' ";
		    System.out.println(sql);
		    pstmt=conn.prepareStatement(sql);
		    rs=pstmt.executeQuery();
		    while(rs.next())
		    {
		    	i++;
		    	result =  iERPConstants.DUPLICATE_NAME_MESSAGE;
		    	
		    }
		    System.out.println("i valur "+i);
		    if(i == 0)
		    {
			sql="INSERT INTO componentwithvalues(USERID,compid,COMPONENTNAME,COMPONENTTYPE,VALUE,componentid) VALUES (?,?,?,?,?,?)";
			if(pstmt!=null)pstmt.close();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,payform.getUserId1());
			pstmt.setLong(2,userid);
			pstmt.setString(3,componentname);
			pstmt.setString(4,componenttype);
			pstmt.setString(5,value);
			pstmt.setString(6,componentid);
		
			pstmt.executeUpdate();
			if(rs!=null)rs.close();
    		result=iERPConstants.REC_ADDED;
		   }
		}
	 catch (Exception e) {
		e.printStackTrace();
	} finally{
		try {
			if(conn!=null)conn.close();
		} catch (Exception e2) {}
	}
	return result;
	}

	@SuppressWarnings("unchecked")
	public List<PayslipForm> listAllComponentValues(long userid,
			HttpServletRequest request, DataSource dataSource)
	{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm attmodform = null;
		Object element  = null;
		ArrayList<String> list1= new ArrayList<String>();
		int uniqueuserid = 0;
		try
		{
		   con = dataSource.getConnection();
		   String sql1 = "select userid from componentwithvalues group by userid ";
		   pstmt=con.prepareStatement(sql1);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new PayslipForm();
			   //payslipform = new PayslipForm();
			   
			   //payslipform.setComponentid(rs.getString("COMPONENTID"));
			   //payslipform.setComponentName(rs.getString("COMPONENTNAME"));
			  attmodform.setUserId((rs.getInt("userid")));
               
			   list.add(attmodform);
			   uniqueuserid = rs.getInt("USERID");
			   
			  // list1.add("userid");
			   System.out.println("fgfndkndfk"+list1.add(rs.getString(1)));
			   request.setAttribute("uniqueuserid",uniqueuserid);
		       System.out.println("unique userid "+uniqueuserid);	 
		   }
		      
		     
		   Iterator itr = list1.iterator();
		      while(itr.hasNext()) {
		          element = itr.next();
		         System.out.print("jgfjgjfghjdfhn"+element + " ");
		     
			   String sql = "SELECT * FROM componentwithvalues where compid='"+userid+"' and USERID = '"+element+"'";
			   System.out.println("sql "+sql);
			   pstmt=con.prepareStatement(sql);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   attmodform = new PayslipForm();
				   attmodform.setUserId(Integer.parseInt(element.toString()));
				   request.setAttribute("userId", element);
				   attmodform.setValue(rs.getString("VALUE"));
				   attmodform.setComponentName(rs.getString("COMPONENTNAME"));
				   list.add(attmodform);
			   }
			   
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

	public String savesalariesjain(long userid, String uniqueuserid,
			String mon, String yr,String[] compo, String[] values,  DataSource dataSource) 
	{
		PayslipForm vform = null;
		String result=null; 
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
					
			    conn=dataSource.getConnection();
			    /*sql="select * from finalsalary where USERID ='"+userid1+"' and COMPANYID='"+userid+"' and SalMonth='"+payslip.getMonth1()+"'  ";
			    pstmt=conn.prepareStatement(sql);
			    rs=pstmt.executeQuery();
			    if(rs.next())
			    {
			    	result = iERPConstants.DUPLICATE_NAME_MESSAGE;
			    }
			    else
			    {*/
			    
			    String x = Arrays.asList(compo).toString();
			    String a = Arrays.asList(values).toString();
			    String y = x.replace("[", "");
			    String z = y.replace("]", "");
			    
			    String b = a.replace("[", "");
			    String c = b.replace("]", "");
			    System.out.println("====================>   "+x);
			    System.out.println("====================>   "+y);
			    
			    
			    
				sql="INSERT INTO jfinalsalary (userid, COMPANYID,"+z+",SalaryMonth, SalYear) VALUES ("+ uniqueuserid +","+userid+","+c+", '"+mon+"', "+ yr+")";
			    System.out.println("sdhdhas"+sql);
				if(pstmt!=null)pstmt.close();
				pstmt=conn.prepareStatement(sql);
			
				pstmt.executeUpdate();
				if(rs!=null)rs.close();
	    		result=iERPConstants.REC_ADDED;
			   // }
			}
		 catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null)conn.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	public List<PayslipForm> listallUserIds(long userid, DataSource dataSource) {
		// TODO Auto-generated method stub
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm attmodform = null;
		
		ArrayList<String> list1= new ArrayList<String>();
		int uniqueuserid = 0;
		try
		{
		   con = dataSource.getConnection();
		   String sql1 = "select userid from componentwithvalues group by userid ";
		   pstmt=con.prepareStatement(sql1);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new PayslipForm();
			   
			  attmodform.setUserId((rs.getInt("userid")));
               
			   list.add(attmodform);
			   uniqueuserid = rs.getInt("USERID");
			   
			  // list1.add("userid");
			   System.out.println("fgfndkndfk"+list1.add(rs.getString(1)));
			 
		       System.out.println("unique userid "+uniqueuserid);	 
		   }
		}
		   catch (Exception e) {
			// TODO: handle exception
		}
		   finally{
				try {
					if(con!=null)con.close();
				} catch (Exception e2) {}
			}
		   return list;
	}

	public List<PayslipForm> componentwithvalues(long userid,
			PayslipForm payform, DataSource dataSource) 
			{

		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm payslipform = null;
  
		
		try
		{
			
		   con = dataSource.getConnection();
		   InputStream in =  this.getClass().getClassLoader().getResourceAsStream("/ApplicationResources.properties");
			   			try
			   			{   				
			   configProp.load(in);
			   			}
			   			catch 
			   			(IOException e) 
			   {
			   				
			   e.printStackTrace();
			   	}
	
		//String sql= configProp.getProperty("select.salarycomponent");;
		String sql = "SELECT * FROM componentwithvalues where COMPANYID = '"+userid+"' and USERID between '"+payform.getUserId1()+"'and '"+payform.getUserId2()+"' ";
		System.out.println("sql "+sql);
		//pstmt.setLong(1,userid);
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   payslipform = new PayslipForm();
		       payslipform.setComponentid(rs.getString("COMPONENTID"));
			   payslipform.setComponentName(rs.getString("COMPONENTNAME"));
			   payslipform.setComponenttype(rs.getString("componenttype"));
			   payslipform.setUserId(rs.getInt("USERID"));
			   payslipform.setValue(rs.getString("VALUE"));
			   list.add(payslipform);
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

	public List<PayslipForm> componentwithvaluesforemployees(long userid,
			String month, String year, PayslipForm payform, DataSource dataSource)
			{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm payslipform = null;
  
		
		try
		{
			
		   con = dataSource.getConnection();
		   InputStream in =  this.getClass().getClassLoader().getResourceAsStream("/ApplicationResources.properties");
			   			try
			   			{   				
			   configProp.load(in);
			   			}
			   			catch 
			   			(IOException e) 
			   {
			   				
			   e.printStackTrace();
			   	}
	
		//String sql= configProp.getProperty("select.salarycomponent");;
		String sql = "SELECT * FROM componentwithvalues where compid = '"+userid+"' and USERID = '"+payform.getUserId1()+"' ";
		System.out.println("sql "+sql);
		//pstmt.setLong(1,userid);
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   payslipform = new PayslipForm();
		       payslipform.setComponentid(rs.getString("COMPONENTID"));
			   payslipform.setComponentName(rs.getString("COMPONENTNAME"));
			   payslipform.setMonth(month);
			   payslipform.setYear1(year);
			   payslipform.setComponenttype(rs.getString("componenttype"));
			   payslipform.setUserId(rs.getInt("USERID"));
			   payslipform.setValue(rs.getString("VALUE"));
               
			   list.add(payslipform);
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

	public String postsalaries(String year, String month, long userid,
			String componentname, String componentid, String value,
			String componenttype, PayslipForm payform, DataSource dataSource)
	{
		 PayslipForm vform = null;
			String result=null; 
			Connection conn=null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			try {
						
				    conn=dataSource.getConnection();
				    /*sql="select * from finalsalary where USERID ='"+userid1+"' and COMPANYID='"+userid+"' and SalMonth='"+payslip.getMonth1()+"'  ";
				    pstmt=conn.prepareStatement(sql);
				    rs=pstmt.executeQuery();
				    if(rs.next())
				    {
				    	result = iERPConstants.DUPLICATE_NAME_MESSAGE;
				    }
				    else
				    {*/
					sql="INSERT INTO salarytxntable(USERID,month,year,compid,componentid,VALUE) VALUES (?,?,?,?,?,?)";
					if(pstmt!=null)pstmt.close();
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1,payform.getUserId());
					pstmt.setString(2,month);
					pstmt.setString(3,year);
					pstmt.setLong(4,userid);
					pstmt.setString(5,componentid);
					pstmt.setString(6,value);
				
					pstmt.executeUpdate();
					if(rs!=null)rs.close();
		    		result=iERPConstants.REC_ADDED;
				   // }
				}
			 catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					if(conn!=null)conn.close();
				} catch (Exception e2) {}
			}
			return result;
	}

//	public List<PayslipForm> componentforpayslip(long userid, long compid,
//			String month, String year, PayslipForm payform,
//			HttpServletRequest request, DataSource dataSource)
//			{
//		List<PayslipForm> list = new ArrayList<PayslipForm>();
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		PayslipForm payslipform = null;
//		String monthval = null;
//		String yearval = null;
//		String username = null;
//		
//		try
//		{
//			 con=dataSource.getConnection();
//		//String sql= configProp.getProperty("select.salarycomponent");;
//		//String sql = "SELECT * FROM salarytxntable where compid = '"+compid+"' and USERID = '"+userid+"' and  month= '"+month+"' and year = '"+year+"' ";
//	    String sql = " SELECT u.firstname,s.month,s.year,s.VALUE FROM usermaster u join salarytxntable s on u.USERID=s.userid  where s.compid = '"+compid+"'" +
//	    		" and s.USERID = '"+userid+"' and  s.month= '"+month+"' and s.year = '"+year+"' ";
//			 System.out.println("sql statement "+sql);
//		//pstmt.setLong(1,userid);
//		   pstmt=con.prepareStatement(sql);
//		   rs=pstmt.executeQuery();
//		   while(rs.next())
//		   {
//			   payslipform = new PayslipForm();
//		       payslipform.setComponentid(rs.getString("componentid"));
//			  // payslipform.setComponentName(rs.getString("COMPONENTNAME"));
//			   payslipform.setMonth1(month);
//			   payslipform.setYear1(year);
//			   monthval = rs.getString("s.month");
//			   yearval = rs.getString("s.year");
//			   username = rs.getString("u.firstname");
//			  // payslipform.setComponenttype(rs.getString("componenttype"));
//			   payslipform.setUserId(rs.getInt("USERID"));
//			   payslipform.setValue(rs.getString("VALUE"));
//			  // request.setAttribute("month",monthval);
//			   list.add(payslipform);
//		   }
//		   request.setAttribute("monthval",monthval);
//		   request.setAttribute("yearval",yearval);
//		   request.setAttribute("username",username);
//		  
//		}
//		
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		   System.out.println("Exception is "+e);
//		}
//		
//		finally
//		{
//			try
//			{
//				if(con!=null)
//					con.close();
//			}
//			catch (Exception e2)
//			{
//			  System.out.println(e2);
//			}
//		}
//		return list;
//	        }

	public String generatepayslip(long userid, long compid, String month,
			String year,int startrange,int endrange, PayslipForm payform, HttpServletRequest request, DataSource dataSource) 
	{
		PayslipForm payslipform = null;
		String result=null; 
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String monthval = null;
		String yearval = null;
		String username = null;
		String rolename = null;
		String salaryaccountnumber = null;
		String bankdetails = null;
		String user = null;
		String email = null;
		try 
		{
					
			    conn=dataSource.getConnection();
			    /*sql="select * from finalsalary where USERID ='"+userid1+"' and COMPANYID='"+userid+"' and SalMonth='"+payslip.getMonth1()+"'  ";
			    pstmt=conn.prepareStatement(sql);
			    rs=pstmt.executeQuery();   
			    if(rs.next())
			    {
			    	result = iERPConstants.DUPLICATE_NAME_MESSAGE;
			    }
			    else
			    {*/
			    sql = "SELECT u.userid, u.emailid ,u.bankname,u.salaryaccountnumber,r.rolename,u.firstname,s.month,s.year,s.VALUE FROM usermaster u join salarytxntable s " +
			    	"on u.USERID=s.userid join rolemaster r on u.RoleID = r.ROLEID where s.compid = '"+compid+"' and s.USERID BETWEEN '"+startrange+"' AND '"+endrange+"' " +
			    	"and  s.month= '"+month+"' and s.year = '"+year+"'  and s.componentid = 1  ";
			    System.out.println("sql statement "+sql);
				//pstmt.setLong(1,userid);
				   pstmt=conn.prepareStatement(sql);
				   
				   rs=pstmt.executeQuery();
				 
				   while(rs.next())
				   {
					
					   payslipform = new PayslipForm();
				       //payslipform.setComponentid(rs.getString("s.componentid"));
					  // payslipform.setComponentName(rs.getString("COMPONENTNAME"));
					  // payslipform.setMonth1(month);
					  // payslipform.setYear1(year);
					   monthval = rs.getString("s.month");
					   System.out.println("execute");
					   yearval = rs.getString("s.year");
					   rolename = rs.getString("r.rolename");
					   salaryaccountnumber = rs.getString("u.salaryaccountnumber");
					   bankdetails = rs.getString("u.bankname");
					  // payslipform.setComponenttype(rs.getString("componenttype"));
					  //payslipform.setUserId(rs.getInt("s.USERID"));
					   payslipform.setValue(rs.getString("s.VALUE"));
					   username = rs.getString("u.firstname");
					   email = rs.getString("u.emailid");
					   user = rs.getString("u.userid");
					  //request.setAttribute("month",monthval);
					   
					   
					   request.setAttribute("monthval",monthval);
					   request.setAttribute("yearval",yearval);
					   request.setAttribute("username",username);
					   request.setAttribute("rolename",rolename);
					   request.setAttribute("bankdetails",bankdetails);
					   request.setAttribute("salaryaccountnumber",salaryaccountnumber);
					   System.out.println("execute");
					   new CreatePDF().createSlip(compid,monthval, yearval, username, rolename, salaryaccountnumber, bankdetails ,user ,email);
						  
				   }
				   
		}
				 
		 catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(conn!=null)conn.close();
			} catch (Exception e2) {}
		}
		return result;
	}

	public List<PayslipForm> listComponent(long userid, PayslipForm payform,
			DataSource dataSource)
			{

		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm payslipform = null;
  
		
		try
		{
			
		   con = dataSource.getConnection();
		   InputStream in =  this.getClass().getClassLoader().getResourceAsStream("/ApplicationResources.properties");
			   			try
			   			{   				
			   configProp.load(in);
			   			}
			   			catch 
			   			(IOException e) 
			   {
			   				
			   e.printStackTrace();
			   	}
	
		//String sql= configProp.getProperty("select.salarycomponent");;
		String sql = "SELECT * FROM componentwithvalues where compid = '"+userid+"' and USERID = '"+payform.getUserId1()+"' ";
		System.out.println("sql "+sql);
		//pstmt.setLong(1,userid);
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   payslipform = new PayslipForm();
		       payslipform.setComponentid(rs.getString("COMPONENTID"));
			   payslipform.setComponentName(rs.getString("COMPONENTNAME"));
			   payslipform.setComponenttype(rs.getString("componenttype"));
			   payslipform.setUserId(rs.getInt("USERID"));
			   payslipform.setValue(rs.getString("VALUE"));
               
			   list.add(payslipform);
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

	public String updateSalary(long userid, String componentname,
			String componentid, String value, String componenttype,
			PayslipForm payform, DataSource dataSource)
	{
		    PayslipForm vform = null;
			String result=null; 
			Connection conn=null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			try {
						
				    conn=dataSource.getConnection();
					sql="update componentwithvalues set VALUE = '"+value+"' where USERID='"+payform.getUserId()+"' and componentid = '"+componentid+"' and compid = '"+userid+"'";
//sql = "update salaryallocation SET COMPANYID=?, CTC=?,BASIC=?,DA=?,PA=?,OA=?,LB=?,PT=?,SP=? where userid='"+attribute1+"'"";
					System.out.println("sql update "+sql);
					pstmt=conn.prepareStatement(sql);	
					pstmt.executeUpdate();
					if(rs!=null)rs.close();
		    		result=iERPConstants.REC_UPDATED;
				   // }
				}
			 catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					if(conn!=null)conn.close();
				} catch (Exception e2) {}
			}
			return result;
	}

	public List<PayslipForm> fromUserList(long compid, DataSource dataSource) 
	{
	    
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster where COMPANYID='"+compid+"' and active = 1";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new PayslipForm();
			   attmodform.setUserId1(rs.getString("USERID"));
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

	public List<PayslipForm> toUserList(long compid, DataSource dataSource) 
	{
		List<PayslipForm> list = new ArrayList<PayslipForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayslipForm attmodform = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "SELECT * FROM usermaster where COMPANYID='"+compid+"' and active = 1";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   attmodform = new PayslipForm();
			   attmodform.setUserId2(rs.getInt("USERID"));
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
}

