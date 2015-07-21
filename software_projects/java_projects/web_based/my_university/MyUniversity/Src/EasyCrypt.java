package com.crypt;
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
public class EasyCrypt
{
	private final int shift=3;
	private final String cipher="@)*%/~^!?z";
	public String encrypt(String data)
	{
		String encrypted="";
		for(int i=0;i<data.length();i++)
		{
			int compared=(int)data.charAt(i)+shift;
			if(compared<100)
			{
				if(compared<10)
					encrypted+="00"+String.valueOf(compared);
				else
					encrypted+="0"+String.valueOf(compared);
			}
			else
					encrypted+=String.valueOf(compared);
		}
		int j;//index for String substitution
		String temp="";
		for(j=0;j<encrypted.length();j++)//substitution
		{
			switch(encrypted.charAt(j))
			{
				case '0':temp+=cipher.charAt(0);break;
				case '1':temp+=cipher.charAt(1);break;
				case '2':temp+=cipher.charAt(2);break;
				case '3':temp+=cipher.charAt(3);break;
				case '4':temp+=cipher.charAt(4);break;
				case '5':temp+=cipher.charAt(5);break;
				case '6':temp+=cipher.charAt(6);break;
				case '7':temp+=cipher.charAt(7);break;
				case '8':temp+=cipher.charAt(8);break;
				case '9':temp+=cipher.charAt(9);break;
				default:System.out.println("Encrypt Error:number out of range");
				System.exit(1);
			}
		}
		encrypted=temp;//point temp address to encrypted
		return encrypted;
	}
	public String decrypt(String encrypted)
	{
		int j;//index for String substitution
		String encryptedEx="";
		for(j=0;j<encrypted.length();j++)//substitution
		{
			if(encrypted.charAt(j)==cipher.charAt(0))encryptedEx+='0';
			else if(encrypted.charAt(j)==cipher.charAt(1))encryptedEx+='1';
			else if(encrypted.charAt(j)==cipher.charAt(2))encryptedEx+='2';
			else if(encrypted.charAt(j)==cipher.charAt(3))encryptedEx+='3';
			else if(encrypted.charAt(j)==cipher.charAt(4))encryptedEx+='4';
			else if(encrypted.charAt(j)==cipher.charAt(5))encryptedEx+='5';
			else if(encrypted.charAt(j)==cipher.charAt(6))encryptedEx+='6';
			else if(encrypted.charAt(j)==cipher.charAt(7))encryptedEx+='7';
			else if(encrypted.charAt(j)==cipher.charAt(8))encryptedEx+='8';
			else encryptedEx+='9';
		}
		encrypted=encryptedEx;
		String data="";
		int temp=0;
		for(int i=0;i<encrypted.length();i=i+3)
		{
			temp=Integer.parseInt(encrypted.charAt(i)+""+encrypted.charAt(i+1)+""+encrypted.charAt(i+2));
			temp-=shift;
			data+=(char)temp;
		}
		return data;	
	}
}

