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

public class DelUser extends JInternalFrame 
implements ItemListener,ActionListener{
    JComboBox accType;
    JTextField accTxt;
    JLabel label_1;
    JLabel label_2;
    JLabel label_3;
    JButton button_1;
    JButton button_2;
	ExecDb db;
	JOptionPane msg;
    public DelUser() {
    	super("Delete Existing User Account",true,false,true,true);
    	msg=new JOptionPane();
    	db=new ExecDb();
        DelUserLayout customLayout = new DelUserLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        accType = new JComboBox();
        accType.addItem("Student");
        accType.addItem("Teacher");
        accType.addItem("Officer");
        getContentPane().add(accType);

        accTxt = new JTextField("");
        getContentPane().add(accTxt);

        label_1 = new JLabel("Delete Existing  user account",JLabel.CENTER);
        getContentPane().add(label_1);

        label_2 = new JLabel("Account Type : ");
        getContentPane().add(label_2);

        label_3 = new JLabel("Account ID : ");
        getContentPane().add(label_3);

        button_1 = new JButton("DELETE");
        getContentPane().add(button_1);

        button_2 = new JButton("CLOSE");
        getContentPane().add(button_2);

        setSize(getPreferredSize());
		accType.addItemListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);
    }

	int acc=0;
    String secret,sql;
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==button_1)//DEL
    	{
    		if(acc==0)//student
    		{
 				sql="delete from studentAccount"
					+" where username='"+accTxt.getText()+"'";
    			db.execUpdate(sql);
    		}
    		else if(acc==1)//teacher
    		{
    			sql="delete from teacherAccount"
					+" where username='"+accTxt.getText()+"'";
    			db.execUpdate(sql);
    		}
    		else if(acc==2)//officer
    		{
    			sql="delete from officerAccount"
					+" where username='"+accTxt.getText()+"'";
    			db.execUpdate(sql);
    		}
    		msg.showMessageDialog(null,"Account deleted!!");
    	}
    	else if(e.getSource()==button_2)
    	{
    		setVisible(false);
    			
    		MainGui.m_DelUser.setSelected(false);
    	}
    	accTxt.setText("");
    }
    public void itemStateChanged(ItemEvent e)
    {
    	acc=accType.getSelectedIndex();
    }
}

class DelUserLayout implements LayoutManager {

    public DelUserLayout() {
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
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+96,176,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+8,184,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+64,128,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+96,128,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+136,96,32);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+136,96,32);}
    }
}
