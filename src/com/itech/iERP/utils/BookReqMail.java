package com.itech.iERP.utils;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BookReqMail {
	public static void bookmail(String ename , String booktitle, String rdate,String tdate, String remark, String toemail) {
		
		
		 
		try{	 // sets SMTP server properties
		    Properties properties = new Properties();
		    properties.put("mail.smtp.host","smtp.gmail.com");
		    properties.put("mail.smtp.port", "587");
		    properties.put("mail.smtp.auth", "true");
		    properties.put("mail.smtp.starttls.enable", "true");

		  //creates a new session with an authenticator
		    
		     
		     Authenticator auth = new Authenticator() {
		     public PasswordAuthentication getPasswordAuthentication() {
		     return new PasswordAuthentication("trainee@itechsolutions.in", "Itech123");
		       }
		    };
		    Session session1 = Session.getInstance(properties,auth);
		  	 //creates a new e-mail message
		    Message msg = new MimeMessage(session1);
		    msg.setFrom(new InternetAddress("trainee@itechsolutions.in"));
		    InternetAddress[] toAddresses = { new InternetAddress(toemail) };
		     msg.setRecipients(Message.RecipientType.TO, toAddresses);
		    msg.setSubject("Jain University Library");
		    msg.setText("Employee Name:"     +" "+ename+""+"\n\n"+
					"Book Title:"     +" "+booktitle+""+"\n\n"+
					"Taken Date:"     +" "+rdate+""+"\n\n"+
					"Return Date:"     +" "+tdate+""+"\n\n"+
					"Remark:"     +" "+remark+""+"\n\n");
		        
		  
		   // sends the e-mail
		    Transport.send(msg);
		 
		   }
		catch (Exception e) {
			// TODO: handle exception
			
		}
	}
}
			