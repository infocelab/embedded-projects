
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
 import  java.applet.AudioClip;
import java.net.*;
import  java.applet.AppletContext.*;
import java.applet.AppletContext;  
import java.applet.*;


public class ServerRun1
{
	public InputStream in;
	public OutputStream out;
	Socket client;
	PrintWriter wr;
	public ServerRun1(String host,int port)
	{
	try{

		client=new Socket(host,port);
		System.out.println("Client Requesting..");
		//System.out.println("Socket info: "+client);
		out=client.getOutputStream();
		in=client.getInputStream();
	   }catch(Exception ht){System.out.println(ht);}
	   	
		
			
	}	
}