//package ksm.mulitiserver;

import java.io.*;
import java.net.*;
import java.sql.*;



public class MultiServer
{
	private ServerSocket	Server;
 	private Socket			Client;
 	private int ConnectionCounter;

 	private int Port;


 	public MultiServer()
	{
		ConnectionCounter=0;
		Port=5000;
        

		Init();
 
	}

	public void Init()
	{
		try
		{
			Server=new ServerSocket(4444);
			System.out.println("Waiting For Connection "+Server.getInetAddress().getHostName());
	        System.out.println("Listening on port: "+Server.getLocalPort());

			while(true)
			{


				WaitingForConnection();
				CreateThread();

			}


		}
		catch(Exception e)
		{
			//System.out.println(e);
		}
	}

	public void CreateThread()
	{
		try
		{
			//System.out.println("Total Active Users:\t"+ConnectionCounter);
			ConnectionCounter++;
			new ServerThread(Client,ConnectionCounter);
		}
		catch(Exception e)
		{
			//System.out.println(e);
		}
			return;

	}

	public void WaitingForConnection()
	{
		//System.out.println("Waiting For Connection "+Server.getInetAddress().getHostName());
		//System.out.println("Listening on port: "+Server.getLocalPort());

		try
		{
			do
			{
				Client=Server.accept();

			}
			while(Client==null);
			//System.out.println("Client Found:\t"+Client.getInetAddress().getHostName());



		}
		catch(Exception e)
		{
			//System.out.println(e);
		}
	}

	public static void main(String a[])
	{
		new MultiServer();
	}
}

