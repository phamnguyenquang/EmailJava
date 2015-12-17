
public class HotMail extends EmailProvider {
	private static String outGoingServer = "smtp-mail.outlook.com";
	private static String outgoingPort = "587";
	private static String inComingServer = "imap-mail.outlook.com";
	private static String inComingPort = "993";
	public HotMail()
	{
		super(inComingServer,inComingPort,outGoingServer,outgoingPort);
	}
}
