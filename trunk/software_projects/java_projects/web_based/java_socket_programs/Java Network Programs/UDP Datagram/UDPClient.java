import java.net.*;
import java.io.*;

class UDPClient
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket dsoc=new DatagramSocket(24);
		byte buff[]=new byte[1024];
		DatagramPacket dpack=new DatagramPacket(buff,buff.length);
		dsoc.receive(dpack);
		System.out.println(new String(dpack.getData()));
	}
}
