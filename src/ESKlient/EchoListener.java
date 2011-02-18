package ESKlient;
import java.awt.event.*;
import java.io.IOException;

public class EchoListener implements ActionListener
{
	private EchoClientLogic ECL;
	public EchoListener(EchoClientLogic ECL)
	{
		this.ECL = ECL;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try 
		{
			ECL.sendMeddelande();
		} 
		catch (IOException epeen) 
		{
			
			epeen.printStackTrace();
		}
	}
}
