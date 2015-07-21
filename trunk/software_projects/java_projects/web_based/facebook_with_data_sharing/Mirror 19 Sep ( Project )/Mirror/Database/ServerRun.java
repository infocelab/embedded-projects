import java.net.*;
import java.io.*;


class ServerRun1
{
	public InputStream in;
	public OutputStream out;
	private Socket client;
	public ServerRun1(String host,int port)
	{
	try{
		client=new Socket(host,port);
		System.out.println("Client Requesting..");
		System.out.println("Socket info: "+client);
		out=client.getOutputStream();
		in=client.getInputStream();
		
	   }catch(Exception ht){System.out.println(ht);}
	   	
		
			
	}	


}

public class ServerRun
{

String start,res;
ServerRun1 client;
BufferedReader br;
PrintWriter wr;

String msg;
char ch='y';

 ServerRun(String msg1)
{
BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
client=new ServerRun1("",1200);

do{

try{
br=new BufferedReader(new InputStreamReader(client.in));
wr=new PrintWriter(new OutputStreamWriter(client.out));

start=br.readLine();
System.out.println("Server :"+start);
msg=msg1+dis.readLine();
System.out.println(msg);
wr.println(msg1);
wr.flush();
res=br.readLine();
System.out.println(" Server Res"+res);
msg=dis.readLine();
System.out.println(msg1);
wr.println(msg1);
wr.flush();
wr.close();
br.close();

}catch(Exception fre){}


}while(ch!='n');
}

public static void main(String args[])
{
ServerRun s=new ServerRun("");
 // Body Of Client
}

}
