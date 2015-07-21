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
public class VerifyUser
{
	Connection con;
	ResultSet result;
	Statement statement;
	public boolean verify(String driver,String host,String user,String pass)
	{
		boolean success=false;
		try{
			Class.forName(driver);
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println("Error : "+ex.getMessage());
		}
		try{
			con=DriverManager.getConnection(host,user,pass);
			statement=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE
			,ResultSet.CONCUR_READ_ONLY);
			String type="";
			if(MyVar.status==0)
				type="studentAccount";
			else if(MyVar.status==1)
				type="teacherAccount";
			else if(MyVar.status==2)
				type="officerAccount";
			else
				type="adminAccount";
    		String sql="select username,password from "+type
						+" where username='"+MyVar.userName+
						"' and password='"+MyVar.passWord+"'";
			result=statement.executeQuery(sql);
			success=result.next();
			String s=(success==true)?"Success":"Fail";
			System.out.println(result.getString("username")+
			" Login : "+s);
			result.close();
			con.close();
		}
		catch(SQLException ex){
			System.out.println("Error : "+ex.getMessage());
		}
		return success;
	}
}
