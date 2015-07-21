import java.net.*;
import java.io.*;
import java.util.*;

class UDPServer
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket dsoc=new DatagramSocket(5217);
		InetAddress host=InetAddress.getLocalHost();
		String str=(new Date()).toString();
		byte buf[]=str.getBytes();		
		dsoc.send(new DatagramPacket(buf,buf.length,host,24));
		dsoc.close();
	}
}