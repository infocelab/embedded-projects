package com.core;
/*
 * CopyLeft (c) 2004 Hussachai Puripunpinyo  All  Rights Reserved.
 * 
 * This software is made available under the terms of the "GPL License"
 * A copy of this license is included with this source distribution
 * in "license.txt" and is also available at:
 * http://www.gnu.org/copyleft/gpl.html 
 */
 
/*
 * Last Update : 14 October 2004
 *
 */
 
 /*
  * Welcome to any suggestion : SiberHus@YaHoo.com
  */
import java.io.*;
import java.util.*;
import javax.swing.*;
import com.var.*;
import com.core.*;
import com.sun.jfc.*;
import com.ui.*;
public class FileHandle
{
	ExampleFileFilter filter;
	JFileChooser jf;
	public FileHandle()
	{
		filter=new ExampleFileFilter();
		filter.addExtension("sql");
		jf=new JFileChooser();
		jf.setFileFilter(filter);
		
	}
	public String loadProperties()
   	{
   		String value="";
   		try{
   			Properties props=new Properties();
   			FileInputStream in=new FileInputStream("conf"+MyVar.sep+"config.txt");
   			props.load(in);
   			MyVar.host=props.getProperty("jdbc.server");
   			MyVar.driver=props.getProperty("jdbc.driver");
   		}
   		catch(Exception ex)
   		{
   			JOptionPane.showMessageDialog(null,"Error :"+ex.getMessage(),"Error"
   			,JOptionPane.ERROR_MESSAGE);
   			MainGui.txtError.append("Error : "+ex.getMessage()+"\n");
   		}
   		return value;
   	}
	public void loadFile(String path,String name,JTextArea area)
	{
		String data="";
		try{
			FileReader instream=new FileReader(path+MyVar.sep+name);
			BufferedReader in=new BufferedReader(instream);
			data=in.readLine()+"\n";
			while(data!=null)
			{
				area.append(data+"\n");
				data=in.readLine();
			}
			in.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error :"+ex.getMessage());
		}
	}
	public void openFile(JTextArea text)
	{
		try{
			if(jf.showOpenDialog(null)==JFileChooser.CANCEL_OPTION)
				return;
			File file=jf.getSelectedFile();
			BufferedReader fin=new BufferedReader(new FileReader(file));
			text.append(fin.readLine()+"\n");
			while(fin.readLine()!=null)
			{
				text.append(fin.readLine()+"\n");
			}
			fin.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error :"+ex.getMessage());
		}
	}
	public void saveFile(JTextArea text)
	{
		try{
				int result;
				result=jf.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
				{
					File file=jf.getSelectedFile();
					FileWriter outStream=new FileWriter(file);
					outStream.write(text.getText());
					outStream.close();
				}
			}
			catch(Exception ex)
			{
				System.out.println("Error: "+ex.getMessage());
			}
	}
	public static void main(String args[])
	{
		JFrame f=new JFrame();
		JTextArea t=new JTextArea();
		f.add(new JScrollPane(t));
		FileHandle fh=new FileHandle();
		fh.loadFile("doc","step1",t);
		f.setVisible(true);
		f.pack();
	}
}