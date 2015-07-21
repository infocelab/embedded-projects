package com.time;
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import com.ui.*;
public class Elapse extends JLabel implements ActionListener
{
	Timer t;
	JOptionPane warn;
	public Elapse()
	{
		Icon clock=new ImageIcon("img"+File.separator+"elapse.jpg");
		super.setIcon(clock);
		warn=new JOptionPane();
		super.setFont(new Font("Arial",Font.BOLD,12));
		t=new Timer(1000,this);
	}
	
	public void startTimer()
	{
		t.start();
	}
	
	public void stopTimer()
	{
		t.stop();
	}
	
	
	public void resetTimer()
	{
		second=0;
		minute=0;
		hour=0;
		leftSec=1;
		leftMin=30; //for student
		leftH=0;
	}
	
	private static int second=0;
	private static int minute=0;
	private static int hour=0;
	private int leftSec=1;
	private int leftMin=30;//init 30 for student(default value)
	private int leftH=0;
	public void setLeftSec(int left)
	{	
		if(left<0||left>59){
			warn.showMessageDialog(this,"Error: not valid range");
		}
		else
			leftSec=left;
	}
	public void setLeftMin(int left)
	{
			if(left<0||left>59){
			warn.showMessageDialog(this,"Error: not valid range");
		}
		else
			leftMin=left;
	}
	public void setLeftH(int left)
	{
			if(left<0||left>59){
			warn.showMessageDialog(this,"Error: not valid range");
		}
		else
			leftH=left;
	}
	public void setTimeLeft(int hleft,int mleft,int sleft)
	{
		if(hleft<0||hleft>59){
			warn.showMessageDialog(this,"Error: not valid range(Hour)");
		}
		else
			leftH=hleft;
			
		if(mleft<0||mleft>59){
			warn.showMessageDialog(this,"Error: not valid range(Minute)");
		}
		else
			leftMin=mleft;
			
		if(sleft<0||sleft>59){
			warn.showMessageDialog(this,"Error: not valid range(Second)");
		}
		else
			leftSec=sleft;
	}
	
	public void actionPerformed(ActionEvent e){
		second++;
		if(second==7)
			System.out.println("Timer interrupt checking");
		if(hour==24)
			warn.showMessageDialog(this,"Elapse : 1 day");
		if(second==60){
			minute++;
			second=0;
		}
		if(minute==60){
			hour++;
			minute=0;
		}
		leftSec--;
		if(leftSec==0)
		{
			leftMin--;
			leftSec=60;
		}
		if(leftH>0)
		{
			if(leftMin==0)
			{
				leftMin++;
				leftH--;
				leftMin=60;
			}
		}
		else	//leftH<=0
		{
			if(leftMin==0)//Time left
			{
				MainGui.logoutInterrupt();
				stopTimer();
				resetTimer();
				MainGui.lUser.setText(" NOT LOGIN");
			}
		}
		super.setText("Elapse : "+hour+":"+minute+":"+second+" Time Left : "
		+leftH+":"+leftMin+":"+leftSec);
	}	
}