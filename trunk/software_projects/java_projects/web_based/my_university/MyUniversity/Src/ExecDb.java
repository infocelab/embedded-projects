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
import java.sql.*;
import com.var.*;
import javax.swing.*;
import com.ui.*;

public class ExecDb
{
	Connection con;
	ResultSet result;
	Statement statement;
	JOptionPane dialog;
	public ExecDb()
	{
		dialog=new JOptionPane();
		try
		{
			Class.forName(MyVar.driver);
		}
		catch(ClassNotFoundException ex)
		{
			dialog.showMessageDialog(null,"Error: "+ex.getMessage(),"Error"
			,JOptionPane.ERROR_MESSAGE);
			System.out.println("Error : "+ex.getMessage());
		}
	}
	public String execString(String sql,String colName)
	{
		String yield="";
		
		try{
			con=DriverManager.getConnection(MyVar.host,MyVar.user,MyVar.pass);
			statement=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE
			,ResultSet.CONCUR_READ_ONLY);
			
					
			result=statement.executeQuery(sql);
			result.next();	
			
			yield=result.getString(colName);
			result.close();
			con.close();
		}
		catch(SQLException ex){
			System.out.println("Error : "+ex.getMessage());
			MainGui.txtError.append("Error : "+ex.getMessage()+"\n");
		}
		return yield;
	}
	public void execUpdate(String sql)
	{
	
		try
		{
			con=DriverManager.getConnection(MyVar.host,MyVar.user,MyVar.pass);
			statement=con.createStatement();
		
			statement.executeUpdate(sql);
			con.close();
		}
		catch(SQLException ex){
			
			System.out.println("Error : "+ex.getMessage());
			MainGui.txtError.append("Error : "+ex.getMessage()+"\n");
		}
	}
}
