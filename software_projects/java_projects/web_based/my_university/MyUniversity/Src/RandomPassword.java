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
public class RandomPassword
{
	public RandomPassword()
	{
		
	}
	public String generatePassword()
	{
		String pass="";
		int num;
		for(int i=0;i<6;i++)
		{
			num=(int)Math.round(Math.random()*10);
			switch(num)
			{
				case 0:pass+="A";break;
				case 1:pass+="j";break;
				case 2:pass+="k";break;
				case 3:pass+="B";break;
				case 4:pass+="o";break;
				case 5:pass+="h";break;
				case 6:pass+="Q";break;
				case 7:pass+="v";break;
				case 8:pass+="Z";break;
				case 9:pass+="i";break;
			}
		}
		return pass;
	}
	public static void main(String args[])
	{
		RandomPassword r=new RandomPassword();
		for(int i=0;i<6;i++)
		System.out.println(r.generatePassword());
	}
}