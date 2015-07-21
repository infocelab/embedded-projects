/*

Copyrights reserved @ mayank2cool@yahoo.com

				Echo Server
				-----------

It is a simple example showing how java can 
be used to write Servers. To see how it 
works, just "javac & java" this source then
telnet to 127.0.0.1 on port 13000 keeping ur
term type to vt100 & type what u want the 
server to echo back to u. U can also change
the default port but it can be done from the
source code only. "IF YOU HAVE ANY COMMENTS 
ABOUT THE SERVER, THEN SHOOT 'EM AT MY EMAIL."

c:\>javac SERVER.java
c:\>java SERVER

(Suppose u have SERVER.java in c:\> drive)

For more on me, visit :
--------  www.maitZone.com  ----------

Thanks for bearing with me. Hope u like the
EchoServer as its my first Java Networking 
Programme.

												*/

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
		System.out.println("CopyRights reserved @ mayank2cool@yahoo.com");
		System.out.println("For more on my work visit  ::  www.maitZone.com");
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
				out.write("CopyRights reserved @ mayank2cool@yahoo.com\r\n"); 
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