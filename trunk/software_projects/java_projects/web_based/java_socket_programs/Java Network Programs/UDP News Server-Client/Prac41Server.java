import java.net.*;
import java.util.*;
import java.io.*;

class Prac41Server
{
	public static void main(String args[]) throws Exception	
	{
		DatagramSocket ServerSoc=new DatagramSocket(5217);		
		while(true)
		{		
			AcceptClientRequest ob=new AcceptClientRequest(ServerSoc);
		}
	}
}

class AcceptClientRequest extends Thread
{
	
	DatagramSocket ServerSoc;
	byte Receivebuff[]=new byte[1024];
	byte Sendbuff[]=new byte[1024];
	DatagramPacket dp;

	AcceptClientRequest(DatagramSocket Soc)
	{
		ServerSoc=Soc;
		dp=new DatagramPacket(Receivebuff,Receivebuff.length);
		try
		{
			ServerSoc.receive(dp);
		}
		catch(Exception ex)
		{
		}
		start();	
	}
	
	public void run()
	{
		try
		{	
			InetAddress ClientHost=dp.getAddress();
			int ClientPort=dp.getPort();			
			System.out.println(ClientHost);
			
			FileReader fin=new FileReader("NewsDataFile.txt");
			BufferedReader br=new BufferedReader(fin);

			StringBuffer News=new StringBuffer();
			String NewsHeadLine;
		
			while((NewsHeadLine=br.readLine())!=null)
			{
				News.append("|" + NewsHeadLine + " |");
			}
		

			Sendbuff=News.toString().getBytes();
			System.out.println(News.toString());
			DatagramPacket sendPacket=new DatagramPacket(Sendbuff,Sendbuff.length,ClientHost,ClientPort);
			 ServerSoc.send(sendPacket);
			System.out.println("Packet Sent ...");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}		
}