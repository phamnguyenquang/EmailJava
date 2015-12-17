import java.io.BufferedOutputStream;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.sound.midi.Receiver;
import javax.mail.AuthenticationFailedException;

public class Email {
	private String email;
	private String password;
	private String text;
	private String receivingHost;
	private sessionHandler session;
	
	public Email(String username, String password )
	{
		email=username;
		this.password  =  password;
		session = new sessionHandler(username,password);
	}
	public void sendEmail(String receivers,String cc, String Bcc, String subject, String text, String AttachmentPath)
	{
		Message message = new MimeMessage(session.send());
		try {
			
			//message
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receivers));
			message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(cc));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(Bcc));
			message.setSubject(subject);
			BodyPart msgBodyPart = new MimeBodyPart();
			msgBodyPart.setText(text);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(msgBodyPart);
			//create attachment (if any)
			if(!AttachmentPath.isEmpty()){
				String data = AttachmentPath;
				DataSource source = new FileDataSource(data);
				msgBodyPart = new MimeBodyPart();
				msgBodyPart.setDataHandler(new DataHandler(source));
				msgBodyPart.setFileName(data);
				multipart.addBodyPart(msgBodyPart);
			}
			message.setContent(multipart);
			//message.setText(text);
			Transport.send(message);
			System.out.println("sent");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println(e.toString());
	 	}
		
	}
	public void checkEmail()
	{
		try{
		Store store = session.receive().getStore("imaps");
		store.connect(session.mail.getIncomingServer(), email, password);
        Folder folder=store.getFolder("INBOX");//get inbox
        folder.open(Folder.READ_ONLY);//open folder only to read
		Message message[]=folder.getMessages();
        for(int i=0;i<message.length;i++){
        	System.out.println(InternetAddress.toString(message[i].getFrom()));
        	System.out.println(message[i].getReceivedDate());
            System.out.println(message[i].getSubject());
           // System.out.println(message[i].getContent());
        }
        folder.close(true);
        store.close();
		}
		catch (Exception e) {
			System.out.println(e.toString());
	 	}
	}		
}
