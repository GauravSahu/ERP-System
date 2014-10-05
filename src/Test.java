import javax.mail.Session;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Test 
{
	public static void main(String args[]) throws IOException{
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = "...";

		try {
		    Message msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress("gauravsahu27@gmail.com", "gauravsahu77"));
		    msg.addRecipient(Message.RecipientType.TO,
		     new InternetAddress("gauravsahu19@gmail.com", "Mr. User"));
		    msg.setSubject("Your Example.com account has been activated");
		    msg.setText(msgBody);
		    Transport.send(msg);

		} catch (AddressException e) {
		   System.out.print(e);
		} catch (MessagingException e) {
			  System.out.print(e);
		}
	}
}

 