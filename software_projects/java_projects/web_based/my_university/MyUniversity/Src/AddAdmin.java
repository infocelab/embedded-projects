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
import java.awt.event.*;
import javax.swing.*;
import com.core.*;
import com.crypt.*;
import com.ui.*;

public class AddAdmin extends JInternalFrame implements ActionListener {
    JTextField accTxt;
    JLabel label_1;
    JLabel label_3;
    JButton button_1;
    JButton button_2;
    JTextField accPass;
    JLabel label_5;
	ExecDb db;
	RandomPassword rand;
	EasyCrypt ec;
	JOptionPane msg;
    public AddAdmin() {
    	super("Add Administrator Account",true,false,true,true);
        AddAdminLayout customLayout = new AddAdminLayout();
		db=new ExecDb();
		rand=new RandomPassword();
		ec=new EasyCrypt();
		msg=new JOptionPane();
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        accTxt = new JTextField("");
        getContentPane().add(accTxt);

        label_1 = new JLabel("Add new administrator account",JLabel.CENTER);
        getContentPane().add(label_1);

        label_3 = new JLabel("Account ID : ");
        getContentPane().add(label_3);

        button_1 = new JButton("ADD");
        getContentPane().add(button_1);

        button_2 = new JButton("CLOSE");
        getContentPane().add(button_2);

        accPass = new JTextField("");
        accPass.setEditable(false);
        getContentPane().add(accPass);

        label_5 = new JLabel("Random Password : ");
        getContentPane().add(label_5);

        setSize(getPreferredSize());
        
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		
    }
    String secret,sql;
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==button_1)//ADD
    	{
    		secret=rand.generatePassword();
    		sql="insert into adminAccount(username,password)"
				+" values('"+accTxt.getText()+"','"+ec.encrypt(secret)+"')";
		    db.execUpdate(sql);
    		accPass.setText(secret);
    		msg.showMessageDialog(null,"Successful !!! New Admin Account Inserted");
    	}
    	else if(e.getSource()==button_2)
    	{
    		accPass.setText("");
    		accTxt.setText("");
    		setVisible(false);
    		MainGui.m_AdAdmin.setSelected(false);	
    	}
    	
    }
   
}

class AddAdminLayout implements LayoutManager {

    public AddAdminLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 349 + insets.left + insets.right;
        dim.height = 179 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+64,176,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+8,184,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+64,128,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+136,96,32);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+136,96,32);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+96,176,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+96,128,24);}
    }
}
