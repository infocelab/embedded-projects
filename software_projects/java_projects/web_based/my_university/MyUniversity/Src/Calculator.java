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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.var.*;

class CalculatorPanel extends JPanel implements ActionListener
{
	private JTextField display;
	private JOptionPane alert;
	private double arg=0;
	private String op="=";
	private boolean start=true;
	private byte dot=0;
	JButton transferBtn;
	CalculatorPanel()
	{
		Icon pic=new ImageIcon("img"+MyVar.sep+"transfer.gif");
		transferBtn=new JButton(pic);
		alert=new JOptionPane();
		setLayout(new BorderLayout());
		display=new JTextField("0");
		display.setFont(new Font("Courier",Font.BOLD,18));
		display.setBackground(Color.WHITE);
		display.setEditable(false);
		
		JPanel P=new JPanel();
		P.setLayout(new BorderLayout());
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(5,5));
		String buttons="789/456*123-0.=+";
		for(int i=0;i<buttons.length();i++)
			addButton(p,buttons.substring(i,i+1));
		P.add(display,"North");
		P.add(p,"Center");
		P.add(transferBtn,"South");
		JLabel label=new JLabel("Easy Calculator",JLabel.CENTER);
		label.setFont(new Font("Times New Roman",Font.BOLD,18));
		add(label,"North");
		add(P,"Center");
	}
	private void addButton(Container c,String s)
	{
		JButton b=new JButton(s);
		c.add(b);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		String s=e.getActionCommand();
		if('0'<=s.charAt(0)&&s.charAt(0)<='9'||s.equals("."))
		{
			if(s.equals(".")){dot++;}
			if(dot<=1){
				if(start)
					display.setText(s);	
				else
					display.setText(display.getText()+s);
				start=false;
			}
			else
			{
				alert.showMessageDialog(null,"Error : Dot has already existed");
				dot--;
			}
		}
		else
		{
			dot=0;
			if(start)
			{
				if(s.equals("-"))
				{
					display.setText(s);
					start=false;
				}
				else op=s;
			}
			else
			{
				double x=Double.parseDouble(display.getText());
				calculate(x);
				op=s;
				start=true;
			}
		}
	}
	public void calculate(double n)
	{
		if(op.equals("+"))arg+=n;
		else if(op.equals("-"))arg-=n;
		else if(op.equals("*"))arg*=n;
		else if(op.equals("/"))arg/=n;
		else if(op.equals("="))arg=n;
		else arg=n;
		display.setText(""+arg);
	}
} 
