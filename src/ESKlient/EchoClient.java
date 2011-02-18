package ESKlient;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;

public class EchoClient extends JPanel
{
	private JFrame frame;
	private JPanel first, second;
	private JLabel svar;
	private JTextField meddelande;
	private JButton send;
	private Font minFont;
	private EchoClientLogic ECL;
	private EchoListener EL;
	public EchoClient()
	{
		super(new GridLayout(2,2));
		frame = new JFrame("Echo Client");
		frame.setSize(400, 345);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		first = new JPanel();
		first.setBackground(java.awt.Color.PINK);
		second = new JPanel();
		second.setBackground(java.awt.Color.PINK);
		this.add(first);
		this.add(second);
		minFont = new Font("Courier", Font.BOLD, 16);
		this.setBackground(java.awt.Color.PINK);
		svar = new JLabel("Svar från server hamnar här");
		svar.setFont(minFont);
		first.add(svar);
		meddelande = new JTextField(30);
		meddelande.setFont(minFont);
		second.add(meddelande);
		send = new JButton("Skicka!");
		second.add(send);
		ECL = new EchoClientLogic(this);
		EL = new EchoListener(ECL);
		send.addActionListener(EL);
	}
	public void setLabel(String s)
	{
		svar.setText(s);
	}
	public String getMsg()
	{
		return meddelande.getText();
	}
	public static void main(String[] args) 
	{
		EchoClient Client = new EchoClient();

	}

}
