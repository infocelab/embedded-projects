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
import java.io.*;
import com.var.*;
import com.ui.*;
import com.core.*;
public class AdminFrame extends JInternalFrame implements 
ActionListener,ChangeListener
{
	JTextArea sql1,sql2,sql3;
	JButton btnQuery,newBtn,openBtn,saveBtn;
	int tabIndex=0;
	JTabbedPane tab;
	FileHandle fh;
	public AdminFrame()
	{
		super("DB Admin",true,false,true,true);
		fh=new FileHandle();
		sql1=new JTextArea();
		sql2=new JTextArea();
		sql3=new JTextArea();
		tab=new JTabbedPane();
		Icon textTab=new ImageIcon("img"+MyVar.sep+"query.gif")
			 ,saveTb=new ImageIcon("img"+MyVar.sep+"save.gif")
			 ,openTb=new ImageIcon("img"+MyVar.sep+"open.gif")
			 ,execTb=new ImageIcon("img"+MyVar.sep+"exec.jpg")
			 ,newTb=new ImageIcon("img"+MyVar.sep+"new.gif");
			 
		newBtn=new JButton(newTb);
		openBtn=new JButton(openTb);
		saveBtn=new JButton(saveTb);
		btnQuery=new JButton("Execute SQL",execTb);
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		btnQuery.addActionListener(this);
		tab.addChangeListener(this);
		JToolBar tb=new JToolBar();
		tb.add(newBtn);
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator();
		tb.add(btnQuery);
		add(tb,BorderLayout.NORTH);
		tab.addTab("sql 1",textTab,new JScrollPane(sql1));
		tab.addTab("sql 2",textTab,new JScrollPane(sql2));
		tab.addTab("sql 3",textTab,new JScrollPane(sql3));
		add(tab);
		setSize(600,300);
		
		addInternalFrameListener(
			new InternalFrameAdapter()
			{
				public void internalFrameClosing(InternalFrameEvent e)
				{
					System.out.println("Hello Work");
					hideFrame();	
							
				}//internalFrameClosing
				
			});
	}
	public void hideFrame()
	{
		super.setVisible(false);
	}
	public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==newBtn)
		{
				if(tabIndex==0)
				{
					sql1.setText("");
				}
				else if(tabIndex==1)
				{
					sql1.setText("");
				}
				else
				{
					sql1.setText("");
				}
		}
		if(e.getSource()==openBtn)
		{
				if(tabIndex==0)
				{
					fh.openFile(sql1);
				}
				else if(tabIndex==1)
				{
					fh.openFile(sql2);
				}
				else
				{
					fh.openFile(sql3);
				}
		}
		if(e.getSource()==saveBtn)
		{
				if(tabIndex==0)
				{
					fh.saveFile(sql1);
				}
				else if(tabIndex==1)
				{
					fh.saveFile(sql2);
				}
				else
				{
					fh.saveFile(sql3);
				}
		}
		if(e.getSource()==btnQuery)
		{
				if(tabIndex==0)
				{
					MainGui.myDb.executeQuery(sql1.getText());
				}
				else if(tabIndex==1)
				{
					MainGui.myDb.executeQuery(sql2.getText());
				}
				else
				{
					MainGui.myDb.executeQuery(sql3.getText());
				}
		}
	
	}//actionPerformed

	public void stateChanged(ChangeEvent e)
	{
		tabIndex=tab.getSelectedIndex();
		System.out.println(tabIndex);
	}
	
}