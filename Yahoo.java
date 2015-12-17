
public class Yahoo extends EmailProvider {
	private static String outGoingServer = "smtp.mail.yahoo.com";
	private static String outgoingPort = "587";
	private static String inComingServer = "imap.mail.yahoo.com";
	private static String inComingPort = "993";
	public Yahoo()
	{
		super(inComingServer,inComingPort,outGoingServer,outgoingPort);
	}
}
