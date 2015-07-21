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
import com.var.*;
import com.crypt.*;
public class ChangePassword extends JInternalFrame implements ActionListener {
    JPasswordField oldPass;
    JLabel label_1;
    JLabel label_3;
    JButton OkBtn;
    JButton CancelBtn;
    JLabel label_6;
    JPasswordField newPass;
    JLabel label_7;
    JPasswordField newPass2;
	JOptionPane msg;
	EasyCrypt ec;
	ExecDb db;
    public ChangePassword() {
    	super("Change Your Password",true,false,true,true);
    	ec=new EasyCrypt();
    	db=new ExecDb();
        ChangePasswordLayout customLayout = new ChangePasswordLayout();
		msg=new JOptionPane();
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        oldPass = new JPasswordField("");
        getContentPane().add(oldPass);

        label_1 = new JLabel("Change your password",JLabel.CENTER);
        getContentPane().add(label_1);

        label_3 = new JLabel("Old Password : ");
        getContentPane().add(label_3);

        OkBtn = new JButton("OK");
        getContentPane().add(OkBtn);

        CancelBtn = new JButton("CANCEL");
        getContentPane().add(CancelBtn);

        label_6 = new JLabel("New Password : ");
        getContentPane().add(label_6);

        newPass = new JPasswordField("");
        getContentPane().add(newPass);

        label_7 = new JLabel("Type it again : ");
        getContentPane().add(label_7);

        newPass2 = new JPasswordField("");
        getContentPane().add(newPass2);

        setSize(getPreferredSize());
		OkBtn.addActionListener(this);
		CancelBtn.addActionListener(this);
    }
    String sql;
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==OkBtn)//ADD
    	{
    		if(MyVar.passWordText.equals(oldPass.getText()))
    		{
    			if(newPass.getText().equals(newPass2.getText()))
    			{
	    			if(MyVar.status==0)//student
	    			{
	    				sql="update studentAccount set password='"+ec.encrypt(newPass.getText())+"'"
							+" where username='"+MyVar.userName+"'";
				    		db.execUpdate(sql);
	    			}
		    		else if(MyVar.status==1)//teacher
		    		{
		    			sql="update teacherAccount set password='"+ec.encrypt(newPass.getText())+"'"
							+" where username='"+MyVar.userName+"'";
				    		db.execUpdate(sql);
		    		}
		    		else if(MyVar.status==2)//officer
		    		{
		    			sql="update officerAccount set password='"+ec.encrypt(newPass.getText())+"'"
							+" where username='"+MyVar.userName+"'";
				    		db.execUpdate(sql);
		    		}
		    		else if(MyVar.status==3)//admin
		    		{
		    			sql="update adminAccount set password='"+ec.encrypt(newPass.getText())+"'"
							+" where username='"+MyVar.userName+"'";
				    		db.execUpdate(sql);
		    		}
		    		setVisible(false);
		    		msg.showMessageDialog(null,"Your Password have changed !!!");
		    	}	
		    	else
		    	{
		    		msg.showMessageDialog(null,"New Password not match !!!");
		    		newPass.setText("");
		    		newPass2.setText("");
		    	}
	    	}
	    	else
	    	{
	    		msg.showMessageDialog(null,"Wrong Password !!!");
	    		oldPass.setText("");
	    	}

    	}
    	else if(e.getSource()==CancelBtn)
    	{
    		setVisible(false);	
    	}
    		oldPass.setText("");
	    	newPass.setText("");
	    	newPass2.setText("");
	    	
	    	MainGui.m_CPass_S.setSelected(false);
	    	MainGui.m_CPass_T.setSelected(false);
	    	MainGui.m_CPass_O.setSelected(false);
	    	MainGui.m_CPass_A.setSelected(false);
    }
}

class ChangePasswordLayout implements LayoutManager {

    public ChangePasswordLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 349 + insets.left + insets.right;
        dim.height = 212 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+8,184,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+64,128,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+168,96,32);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+168,96,32);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+96,128,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+96,176,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+128,128,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+128,176,24);}
    }
}
