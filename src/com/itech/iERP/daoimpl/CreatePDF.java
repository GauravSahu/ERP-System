package com.itech.iERP.daoimpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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




public class CreatePDF extends Thread {
	
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
	String basic = null;
	String gradepay = null;
	String da = null;
	String sql1 = null;
	String hra = null;
	String cca = null;
	String managementallowance = null;
	String arrears = null;
	String gross = null;
	String pf = null;
	String pt = null;
	String it = null;
	String others = null;
	String miscalleneous=null;
	String salarydavance = null;
	String total = null;
	String netsalary= null;
	String user = null;
	String emailid = null;
	public String createSlip(long compid,String monthval,String yearval,String username,String rolename,String salaryaccountnumber,String bankdetails,String user, String email){
			 
		try {
				emailid = email;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				 Date date = new Date();
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ierp","root","root");
			
				sql1 = "select value as basic from salarytxntable where componentid = 1 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
			      basic = rs.getString("basic");
			   }
			   
			   sql1 = "select value as gradepay from salarytxntable where componentid = 2 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
			     gradepay = rs.getString("gradepay");
			    }
			   
			   sql1 = "select value as da from salarytxntable where componentid = 3 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
			      da = rs.getString("da");
			    }
			   
			   sql1 = "select value as hra from salarytxntable where componentid = 4 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
			      hra = rs.getString("hra");
			   }
			   
			   sql1 = "select value as cca from salarytxntable where componentid = 5 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
			      cca = rs.getString("cca");
			   }
			   
			   sql1 = "select value as managementallowance from salarytxntable where componentid = 6 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   managementallowance = rs.getString("managementallowance");
			   }
			   
			   sql1 = "select value as arrears from salarytxntable where componentid = 7 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   arrears = rs.getString("arrears");
			   }
			   
			   sql1 = "select value as pf from salarytxntable where componentid = 8 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
			      pf = rs.getString("pf");
			   }
			   
			   sql1 = "select value as pt from salarytxntable where componentid = 9 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   pt = rs.getString("pt");
			   }
			   
			   sql1 = "select value as it from salarytxntable where componentid = 10 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   it = rs.getString("it");
			   }
			   
			   sql1 = "select value as others from salarytxntable where componentid = 11 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				  others = rs.getString("others");
			   }
			   
			   sql1 = "select value as miscalleneous from salarytxntable where componentid = 12 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   miscalleneous = rs.getString("miscalleneous");
			   }
			   
			   sql1 = "select value as salarydavance from salarytxntable where componentid = 13 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   salarydavance = rs.getString("salarydavance");
			   }
			   
			   sql1 = "select value as gross from salarytxntable where componentid = 14 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   gross = rs.getString("gross");
			   }
			   
			   sql1 = "select value as total  from salarytxntable where componentid = 15 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);                                                                    
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   total  = rs.getString("total");
			   }
			   
			   sql1 = "select value as netsalary  from salarytxntable where componentid = 16 and  compid = '"+compid+"' and USERID = '"+user+"' and  month= '"+monthval+"' and year = '"+yearval+"'";
			   pstmt=conn.prepareStatement(sql1);                                                                    
			   rs=pstmt.executeQuery();
			   while(rs.next())
			   {
				   netsalary  = rs.getString("netsalary");
				}
			 
			 
			 
			 
			 	OutputStream file = new FileOutputStream(new File("D:\\PDF_Java4s.pdf"));
			 	Paragraph para = new Paragraph();
			 	Document document = new Document();
			 	PdfWriter.getInstance(document, file);

                document.open();
                Font font2 = new Font(Font.FontFamily.COURIER ,15, Font.BOLD);
                Font font1 = new Font(Font.FontFamily.COURIER ,10, Font.BOLD);
                 

            	   document.add(Chunk.NEWLINE);
                
            	   Image img = Image.getInstance ("D:\\stamp.png");
            	   img.scaleAbsolute(100f,100f);//image width,height  
            	   img.setAlignment(Element.ALIGN_CENTER);
            	   
            	   img.setAbsolutePosition(320, 390);
            	   
            	   document.add(img);
                  
         
                para = new Paragraph("SRI BHAGAWAN MAHAVEER JAIN COLLEGE OF ENGINEERING",font2);
                para.setAlignment(Element.ALIGN_CENTER);
                document.add(para);
                para = new Paragraph("JAKKASANDRA POST, KANAKAPURA TALUK,RAMANAGARA DISTRICT - 562112",font1);
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
                PdfPTable table = new PdfPTable(3); // Code 1
                table.getDefaultCell().setBorder(0);
        		// Code 2
        	
        		table.addCell(new Phrase("Name of Employee ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(username, FontFactory.getFont(FontFactory.COURIER,10)));         		
        		// Code 3
        		table.addCell(new Phrase("Designation ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(rolename, FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		// Code 4
        		table.addCell(new Phrase("Department ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("CNMS", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table.addCell(new Phrase("Pf No ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(pf, FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table.addCell(new Phrase("PAN No ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("12345", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table.addCell(new Phrase("SBA/CNO", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(salaryaccountnumber, FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table.addCell(new Phrase("Bank of Maharashtra", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("City Market,Bangalore", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		// Code 5
        		
        		document.add(table);
        		
               document.add(Chunk.NEWLINE);
               
        		PdfPTable table1 = new PdfPTable(4); // 3 columns.
        		
        		table1.getDefaultCell().setBorderWidth(1);
        		
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("INCOME", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
        		table1.addCell(new Phrase("AMOUNT ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
        		table1.addCell(new Phrase("DEDUCTIONS", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
        		table1.addCell(new Phrase("AMOUNT", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
        		
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("BASIC ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(basic, FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("PF ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(pf, FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("GRADE PAY ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(gradepay, FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("PT", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(pt, FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("DA", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(da, FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("IT ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(it, FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("HRA ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(hra, FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("OTHERS ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(others, FontFactory.getFont(FontFactory.COURIER,10)));
         		     	
                
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("CCA", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(cca, FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("MISCELLANEOUS ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(miscalleneous, FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("MANAGMENT ALLOWANCE", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(managementallowance, FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
         		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("ARREARS", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(arrears, FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("GROSS", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(gross, FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
         		table1.addCell(new Phrase("Total ", FontFactory.getFont(FontFactory.COURIER,10)));
         		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
         		table1.addCell(new Phrase(total, FontFactory.getFont(FontFactory.COURIER,10)));
         		 
                table1.addCell("  ");
                table1.addCell("  ");
                table1.addCell("  ");
                table1.addCell("  ");
                
               
        		
               document.add(table1);
               
               String date1 = date.toString();
               date1 = date1.substring(4,8)+date1.substring(24);
               para = new Paragraph("                        "+date1,font1);
               para.setAlignment(Element.ALIGN_CENTER);
               document.add(para);
        	   
               document.add(Chunk.NEWLINE);
           	   
               para = new Paragraph("Net Salery 7500/-                                     Director",font1);
               para.setAlignment(Element.ALIGN_CENTER);
               document.add(para);
              
               document.close();
                file.close();
                System.out.println("Pdf generated normally");
              
                sendSLIP(emailid);
            
		 } 
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return "";
	}
	
	public void sendSLIP(String mailid){
		
		
		 
		 String result;
			// Recipient's email ID needs to be mentioned.
			//String to1 =(String) request.getAttribute("email");
			//System.out.println("STRIN email->"+to1);
			// Sender's email ID needs to be mentioned
			String from1 = "trainee@itechsolutions.in";

			// Assuming you are sending email from localhost
			String host = "smtp.gmail.com";

			String password = "Itech123";
			try{
			// Get system properties object
					Properties props = new Properties();
					props.put("mail.smtp.user",from1); 
					props.put("mail.smtp.password", password);
					props.setProperty("mail.transport.protocol", "smtp");
					props.setProperty("mail.host", "smtp.gmail.com");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.port", "465");
					props.put("mail.smtp.socketFactory.port", "465");
					props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
					props.put("mail.smtp.socketFactory.fallback", "false");
					props.setProperty("mail.smtp.quitwait", "false");

					java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			// Get the default Session object.
				Session mailSession = Session.getInstance(props,new Authenticator() {
			     protected PasswordAuthentication  getPasswordAuthentication() {
			     return new PasswordAuthentication(
			                 "trainee@itechsolutions.in", "Itech123");
			             }
			 });


			   // Create a default MimeMessage object.
			   MimeMessage message = new MimeMessage(mailSession);
			   // Set From: header field of the header.
			   message.setFrom(new InternetAddress(from1));
			   // Set To: header field of the header.
			   message.setRecipient(Message.RecipientType.TO,
			                            new InternetAddress(mailid));
			   // Set Subject: header field
			   message.setSubject("PaySlip");
			   
			   // Create the message part 
			   BodyPart messageBodyPart = new MimeBodyPart();

			   // Fill the message
			   messageBodyPart.setText("This is auto generated mail from SRI BHAGAWAN MAHAVEER JAIN COLLEGE OF ENGINEERING");
			   
			   // Create a multipar message
			   Multipart multipart = new MimeMultipart();

			   // Set text message part
			   multipart.addBodyPart(messageBodyPart);

			
			   
			   messageBodyPart = new MimeBodyPart();
			   String flpath = "D:\\PDF_Java4s.pdf";
			   DataSource source1 = new FileDataSource(flpath);
			   messageBodyPart.setDataHandler(new DataHandler(source1));
			   messageBodyPart.setFileName("PDF_Java4s.pdf");
			   multipart.addBodyPart(messageBodyPart);
			  
			   // Send the complete message parts
			   message.setContent(multipart );
			   // Send the actual HTML message, as big as you like
			  // message.setContent("<h1>This is actual message</h1>",
			    //                     "text/html" );
			   // Send message
			   try {
					Thread.sleep(2000);
					Transport.send(message);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					try{
							Transport.send(message);
					}
					catch(Exception e2){
						e2.printStackTrace();
					}
					//e1.printStackTrace();
				}
				finally{
					 result = "Sent message successfully....";
				}
			}catch (MessagingException mex) {
			   mex.printStackTrace();
			   result = "Error: unable to send message....";
			}
			System.out.println(result);
	}

}
