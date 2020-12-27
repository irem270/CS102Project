package forum;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class ForgetPassword {
	final static String myMail = "cs102.emptydata@gmail.com";
	final static String pass = "emptydata102";

	public static boolean sendMail(String email) {
		Properties props = System.getProperties();
		int userPass =  Operations.getPassword(email);
		if(userPass!=-1) {
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", myMail);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);
		String[] to = new String[1];
		to[0] = email;

		try {
			message.setFrom(new InternetAddress(myMail));
			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			message.setSubject("Your EmptyData Password");
			message.setText("Hello, your EmptyData password is : " + userPass);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, myMail, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			return true;
		} catch (AddressException ae) {
			ae.printStackTrace();
			return false;
		} catch (MessagingException me) {
			me.printStackTrace();
			return false;
		}
	}
		else {
			return false;
		}
	}
	

}
