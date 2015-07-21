import java.net.*;
import java.io.*;
import java.awt.*;
import java.util.*;

class Servermain1
{
private ServerSocket server;
public InputStream in;
public OutputStream out;
private Socket socket;
public InetAddress ina;
public byte[] bytes;
int fbytes[]=new int[4];
public static void main(String args[])
	{
	try{
	server=new ServerSocket(1200);
	System.out.println(" Server Socket before accept");
	System.out.println(" "+server);
	System.out.println(" waiting for client");
	socket=server.accept();
	ina=socket.getInetAddress();
	System.out.println(" Server responce to "+ina.getHostName());
	System.out.println(" with ip address");
	bytes=ina.getAddress();
	for(int i=0;i<4;i++)
	{	
	fbytes[i]=bytes[i]&255;
	System.out.println(fbytes[0]+":"+fbytes[1]+":"+fbytes[2]+":"+fbytes[3]);
	in=socket.getInputStream();
	out=socket.getOutputStream();
	}

	}catch(Exception fr){System.out.println(" "+fr);}
	
	}

}

public class Servermain
{
final static int SERVER_PORT=1200;
servermain(){
	String req;
	Servermain1 server;
	BufferedReader br;
	PrintWriter wr;
	String msg;
	char ch='y';
	BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
	server=new Servermain1(SERVER_PORT);
	br=new BufferedReader(new InputStreamReader(server.in));
	wr=new PrintWriter(new OutputStreamWriter(server.out));
	wr.println("Server date info :"+new Date());
	wr.flush();
	while(true)
		{
		try{
			req=br.readLine();
			System.out.println(" Clinet:"+req);	
			if(req.startsWith("Quit"))
			{
			System.out.println(" Diconnect...");
			System.out.println(0);
			}
			
			if(req.startsWith("End"))
			{
			System.out.println(" Diconnect...");
			wr.flush();
			}

			else{
			System.out.println(" Send");
			System.out.flush();
			msg=dis.readLine();
			wr.println(msg);
			wr.flush();
			}

		   }catch(Exception de){}
		}

	}



}