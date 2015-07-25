										

import java.net.*;
import java.io.*;
import java.util.Date;

public class SERVER
{
	public static void main(String arg[])
	{
	 try
	 {
		BufferedReader in;
		BufferedWriter out;
		String input;

		ServerSocket server = new ServerSocket(13000);
		
		System.out.println("");
		System.out.println("------------------------------------------------");
		System.out.println("Starting EchoServer v1.0 on port "+server.getLocalPort());
		System.out.println("CopyRights reserved @ info@computronicslab.com");
		System.out.println("------------------------------------------------");
		System.out.println("");
		System.out.println("Waiting for \"Incoming Connections\"");	
		System.out.println("");

		while(true)
		{
			Socket connection = null;
			connection = server.accept();
		try
			{
				System.out.println("");
				System.out.println("Opening new Client Socket");
				out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
				in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				out.write("EchoServer v1.0 started.\r\n"); 
				out.write("CopyRights reserved @ info@computronicslab.com\r\n"); 
				out.write("Local Time: "+new Date()+"\r\n\r\n");
				out.write("To end session use .(dot)\r\n");
				out.write("-----------------------------------------------\r\n\r\n");
				out.flush();

				input = in.readLine();
				while(true)
				{
					if(input.equals("."))
					{
						break;
					}
					String temp = input;
					temp += "\r\n";
					out.write("--> "+temp,0,(temp.length()+4));
					out.flush();
					input = in.readLine();
				}
	
			}catch(IOException e)
				{
					System.out.println("Client closed the connection");
				}
			finally
			{
				if(connection!=null)
				{
					try
					{
						connection.close();
					}catch(Exception e){}					
					System.out.println("Closing Client Socket");
					System.out.println("");
				}
				
				//break;           // Use it if u want no more connections after single telnet session
			}
		}
	 }catch(Exception e)
		{}		
	}
}