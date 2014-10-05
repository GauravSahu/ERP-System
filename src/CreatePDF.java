import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class CreatePDF {
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String args[]){
		 try {
			 
			 OutputStream file = new FileOutputStream(new File("D:\\PDF_Java4s.pdf"));
             Paragraph para = new Paragraph();
             Document document = new Document();
             PdfWriter.getInstance(document, file);
             Date date = new Date();
                document.open();
                Font font2 = new Font(Font.FontFamily.COURIER ,15, Font.BOLD);
                Font font1 = new Font(Font.FontFamily.COURIER ,10, Font.BOLD);
                 

            	   document.add(Chunk.NEWLINE);
                
            	   Image img = Image.getInstance ("src/stamp.png");
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
        		table.addCell(new Phrase("Gaurav Sahu", FontFactory.getFont(FontFactory.COURIER,10)));         		
        		// Code 3
        		table.addCell(new Phrase("Designation ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("Java Developer ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		// Code 4
        		table.addCell(new Phrase("Department ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("R&D", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table.addCell(new Phrase("Pf No ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("12345", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table.addCell(new Phrase("PAN No ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("123456", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table.addCell(new Phrase("S.B.A./C.N.O.", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
        		table.addCell(new Phrase("123456", FontFactory.getFont(FontFactory.COURIER,10)));
        		
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
        		table1.addCell(new Phrase("Basic ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("Professional Tax ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("GRADE PAY ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("PT ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("D.A ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("IT", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("HRA ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("OTHERS ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("CCA ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("MISCELLANOUS ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("MANAGEMENT ALLOWANCE ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("SALARY ADVANCE ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("ARREARS ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("GROSS", FontFactory.getFont(FontFactory.COURIER,12,Font.BOLD)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("4200 ", FontFactory.getFont(FontFactory.COURIER,12,Font.BOLD)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        		table1.addCell(new Phrase("TOTAL", FontFactory.getFont(FontFactory.COURIER,10)));
        		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
        		
        	 	
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
             //  sendSLIP();
 
               
               
		 } 
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 
	}
	/*
	public void sendSLIP(){
		 String result;
			// Recipient's email ID needs to be mentioned.
			//String to1 =(String) request.getAttribute("email");
			//System.out.println("STRIN email->"+to1);
			// Sender's email ID needs to be mentioned
			String from1 = "gauravsahu27@gmail.com";

			// Assuming you are sending email from localhost
			String host = "smtp.gmail.com";

			String password = "gauravsahu77";
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
			                 "gauravsahu27@gmail.com", "gauravsahu77");
			             }
			 });


			   // Create a default MimeMessage object.
			   MimeMessage message = new MimeMessage(mailSession);
			   // Set From: header field of the header.
			   message.setFrom(new InternetAddress(from1));
			   // Set To: header field of the header.
			   message.setRecipient(Message.RecipientType.TO,
			                            new InternetAddress("gauravsahu19@gmail.com"));
			   // Set Subject: header field
			   message.setSubject("Automated email from client information sheet");
			   
			   // Create the message part 
			   BodyPart messageBodyPart = new MimeBodyPart();

			   // Fill the message
			   messageBodyPart.setText("This is auto generated mail from MMvisa client information!");
			   
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
			   Transport.send(message);
			        result = "Sent message successfully....";
			}catch (MessagingException mex) {
			   mex.printStackTrace();
			   result = "Error: unable to send message....";
			}
			System.out.println(result);
			try{
				 
	    		File file = new File("D:\\PDF_Java4s.pdf");
	 
	    		if(file.delete()){
	    			System.out.println(file.getName() + " is deleted!");
	    		}else{
	    			System.out.println("Delete operation is failed.");
	    		}
	 
	    	}catch(Exception e){
	 
	    		e.printStackTrace();
	 
	    	}
	}
	*/
}
