package com.ui;
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
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Enrollment extends JInternalFrame
{
	Container ct;
	
	public Enrollment()
	{
		super("Enrollment",true,false,true,true);
		ct=getContentPane();
		createInstance();
		setSize(300,300);
		pack();
	}
	static JTabbedPane tab;
	JPanel myPanel1,myPanel2,myPanel3,myPanel4;
	private void createInstance()
	{
		tab=new JTabbedPane();
		myPanel1=new Step1();
		myPanel2=new Step2();
		myPanel3=new Step3();
		myPanel4=new Step4();
		tab.addTab("Step 1",myPanel1);
		tab.addTab("Step 2",myPanel2);
		tab.addTab("Step 3",myPanel3);
		tab.addTab("Step 4",myPanel4);
		JLabel head=new JLabel("My University Enroll System",SwingConstants.CENTER);
		head.setFont(new Font("Arial",Font.BOLD,18));
		ct.add(head,"North");
		ct.add(tab,"Center");
		
			addInternalFrameListener(
			new InternalFrameAdapter()
			{
				public void internalFrameClosing(InternalFrameEvent e)
				{
					
					setVisible(false);
							
				}//internalFrameClosing
				
			});
		
	}
	public void setHide()
	{
		setVisible(false);
	
	}
}