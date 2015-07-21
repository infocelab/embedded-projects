import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

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

String msg="";
char ch='y';

 ServerRun()
{
BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
client=new ServerRun1("",1200);

do{

try{
br=new BufferedReader(new InputStreamReader(client.in));
wr=new PrintWriter(new OutputStreamWriter(client.out));


FileReader re=new FileReader("send.txt");
JTextField jt=new JTextField();
jt.read(re,null);
msg=jt.getText()+"\r\n";
re.close();


start=br.readLine();
System.out.println("Server :"+start);
msg=msg+"\r\n";
System.out.println("msg="+msg+"\r\n");
System.out.println(msg);
wr.write(msg+"\r\n");
wr.flush();
wr.print("");
System.out.println("Sending Data");	
wr.flush();

res=br.readLine();


FileWriter er=new FileWriter("res.xml");
er.write(res+"");
er.close();
System.out.println(" Server Res"+res);

wr.close();
br.close();

break;

}catch(Exception fre){}


}while(ch!='n');
}

public static void main(String args[])
{
ServerRun s=new ServerRun();
 // Body Of Client
}

}
