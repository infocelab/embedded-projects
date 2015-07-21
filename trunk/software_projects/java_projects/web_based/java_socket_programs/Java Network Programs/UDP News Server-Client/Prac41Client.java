import java.net.*;
import java.awt.*;

public class Prac41Client extends Frame implements Runnable
{
	Label lblNewsHeadline;
	String NewsMsg;
	Thread t=null;
	int ClinetPortNumber;

	Prac41Client()
	{
		super("News Client");
	}
	public void Setup(int ClientPort)
	{
		ClinetPortNumber=ClientPort;
		setSize(500,50);
		lblNewsHeadline=new Label("Retrieving News From News.Com");
		add(lblNewsHeadline);		
		show();
		t=new Thread(this);
		t.start();
	}
	public static void main(String args[]) throws Exception
	{
		Prac41Client ob=new Prac41Client();	
		ob.Setup(Integer.parseInt(args[0]));
	}
	public void run()
	{
		while(true)
		{
			try
			{
				DatagramSocket ClientSoc=new DatagramSocket(ClinetPortNumber);
				String Command="GET";
				
				byte Sendbuff[]=new byte[1024];
				Sendbuff=Command.getBytes();
	
				InetAddress ServerHost=InetAddress.getLocalHost();
				ClientSoc.send(new DatagramPacket(Sendbuff,Sendbuff.length,ServerHost,5217));

				byte Receivebuff[]=new byte[1024];
				DatagramPacket dp=new DatagramPacket(Receivebuff,Receivebuff.length);
				ClientSoc.receive(dp);
				
				
				NewsMsg=new String(dp.getData(),0,dp.getLength());
				System.out.println(NewsMsg);
				lblNewsHeadline.setText(NewsMsg);
				
				Thread.sleep(5000);			
				ClientSoc.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}	
}