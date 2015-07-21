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
//Standard package
import java.awt.*;
//My package
import com.ui.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.*;
import com.var.*;
public class University
{
	static MainGui gui;
	public University()	//initial MainGui
	{
		setDefaultUI();
		gui=new MainGui();
		gui.pack();
		Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int)dm.getWidth();
		int height=(int)dm.getHeight();
		gui.setSize(width,height-27);
		gui.myLogin.setVisible(true);
		gui.setVisible(false);
		
	}
	public static void showMainGui()
	{
		gui.setVisible(true);
		if(MyVar.login==1)//login success
		{
			gui.createEnvirontment();
		}
		else
		{
			gui.disableAllMenu();
		}
		System.out.println(MyVar.status);
	}
	public static void hideMainGui()
	{
		gui.setVisible(false);
	}
	public void setDefaultUI()
	{
		UIManager.put("swing.boldMetal", Boolean.FALSE);
        JDialog.setDefaultLookAndFeelDecorated(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        System.setProperty("sun.awt.noerasebackground","true");

        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }  
        catch ( UnsupportedLookAndFeelException e ) {
            System.out.println ("Metal Look & Feel not supported on this platform. \nProgram Terminated");
            try{
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
			}
			catch(Exception ex2)
			{
				System.exit(1);
			}
        }
	}
	public void logout()
	{
		gui.logoutInterrupt();
	}
	public static void main(String args[])
	{
		new University();
	}
}