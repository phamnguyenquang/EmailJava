
public abstract class EmailProvider {
	private String InComingServer;
	private String InComingPort;
	private String OutGoingServer;
	private String OutgoingPort;
	public EmailProvider(String IServer,String IPort,String OServer,String OPort)
	{
		InComingServer = IServer;
		InComingPort = IPort;
		OutGoingServer = OServer;
		OutgoingPort = OPort;
	}
	public String getIncomingServer()
	{
		return InComingServer;
	}
	public String getIncomingPort()
	{
		return InComingPort;
	}
	public String getOutGoingServer()
	{
		return OutGoingServer;
	}
	public String getOutGoingPort()
	{
		return OutgoingPort;
	}
	public void getserver() {
		System.out.println("InComing Server: ");
		System.out.println(InComingServer);
		System.out.println("incoming port: ");
		System.out.println(InComingPort);
		System.out.println("Outgoing server:");
		System.out.println(OutGoingServer);
		System.out.println("outgoing port");
		System.out.println(OutgoingPort);
		
	}
}
