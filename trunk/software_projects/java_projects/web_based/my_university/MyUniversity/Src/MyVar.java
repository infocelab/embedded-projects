package com.var;
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
import java.io.File;
public class MyVar
{
	/*status
	 *0=student
	 *1=teacher
	 *2=officer
	 *3=admin
	 */
	public static int status=0;
	
	//For DB connect-------------------
	public static String driver="";
	public static String host="";
	public static String user="myDB";
	public static String pass="myPASS";
	//---------------------------------
	
	public static String sep=File.separator;
	
	
	public static String userName;
	public static String passWord;
	public static String passWordText;
	
	
	public static int login=0;// login success=1,fail=0;
	
	public static String term="1";
	public static String year="2547";
	
	public static String subCode[]=new String[10];
	public static String subName[]=new String[10];
	public static int subAmount=0;
	
	
}