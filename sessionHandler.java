import java.util.Properties;


import javax.mail.PasswordAuthentication;
import javax.mail.Session;
public class sessionHandler {
	private String user;
	private String password;
	public EmailProvider mail;
	public sessionHandler(String email, String pass)
	{
		password = pass;
		if(email.contains("@gmail.com"))
		{
			mail = new Gmail();
			user = email;
		}
		else if (email.contains("@yahoo.com"))
		{
			mail = new Yahoo();
			user = email;
			System.out.println(user);
		}
		else if(email.contains("@hotmail.com")|| email.contains("@outlook.com") || email.contains("@live.com"))
		{
			mail = new HotMail();
			user = email;
		}
	}
	public Session send()
	{
		Properties prop = new Properties();
		prop = System.getProperties();
		prop.put("mail.smtp.host", mail.getIncomingServer());
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", mail.getIncomingPort());
		Session session = Session.getInstance(prop,
		         new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(user, password);
			   }
		         });
		return session;
	}
	public Session receive() 
	{
		Properties prop = System.getProperties();
		prop.setProperty("mail.store.protocol", "imaps");
		//prop.store(new OutputStream, comments);
        prop.put("mail.imap.host", mail.getOutGoingServer());
        prop.put("mail.imap.port", mail.getOutGoingPort());
        prop.put("mail.imap.starttls.enable", "true");
        Session session = Session.getInstance(prop,
		         new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(user, password);
		            }
        		});
		return session;
		}
}
	
