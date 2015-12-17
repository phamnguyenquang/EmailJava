
public class Gmail extends EmailProvider {
	private static String outGoingServer = "smtp.gmail.com";
	private static String outGoingPort = "587";
	private static String inComingServer = "imap.gmail.com";
	private static String inComingPort = "993";
	public Gmail()
	{
		super(inComingServer,inComingPort,outGoingServer,outGoingPort);
	}
}
