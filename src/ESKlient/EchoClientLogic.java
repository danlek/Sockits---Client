package ESKlient;
import java.io.*;
import java.net.*;
public class EchoClientLogic 
{
	private Socket klienten;
	private DataInputStream inkommande;
	private PrintStream utgaende;
	private EchoClient EC;
	public EchoClientLogic(EchoClient EC)
	{
		this.EC = EC;
		try
		{
			klienten = new Socket("192.168.1.2", 9999);
			EC.setLabel("Socket skapats");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		try
		{
			inkommande = new DataInputStream(klienten.getInputStream());
			utgaende = new PrintStream(klienten.getOutputStream());
			EC.setLabel("in och ut strömar skapats");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	@SuppressWarnings("deprecation")
	public void sendMeddelande() throws IOException
	{
		utgaende.println(EC.getMsg());
		EC.setLabel(inkommande.readLine());
	}
}
