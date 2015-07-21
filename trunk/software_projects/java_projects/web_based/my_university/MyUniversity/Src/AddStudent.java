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
import com.var.*;
import com.core.*;

public class AddStudent extends JInternalFrame 
implements ActionListener,ItemListener
{
    JLabel label_1;
    JLabel label_2;
    JLabel label_3;
    JLabel label_4;
    JLabel label_5;
    JLabel label_6;
    JLabel label_7;
    JLabel label_8;
    JTextField txtId;
    JLabel header;
    JTextField txtFname;
    JTextField txtLname;
    JTextField txtDob;
    JTextField txtAddr;
    JTextField txtPhone;
    JComboBox comDepart;
    ButtonGroup cbg;
    JRadioButton maleR;
    JRadioButton femaleR;
    JButton addBtn;
    JButton clearAllbtn;
    JButton cancelBtn;
    String id,fname,lname,dob,addr,phone,gender,department;
    JOptionPane dialog;
    ExecDb db;

    public AddStudent() {
		super("Add new student record",true,false,true,true);
        AddStudentLayout customLayout = new AddStudentLayout();
        db=new ExecDb();
        dialog=new JOptionPane();
        Icon headerImg=new ImageIcon("img"+MyVar.sep+"addstudent.jpg");

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("ID :",JLabel.RIGHT);
        getContentPane().add(label_1);

        label_2 = new JLabel("First name :",JLabel.RIGHT);
        getContentPane().add(label_2);

        label_3 = new JLabel("Last name :",JLabel.RIGHT);
        getContentPane().add(label_3);

        label_4 = new JLabel("Date of birth :",JLabel.RIGHT);
        getContentPane().add(label_4);

        label_5 = new JLabel("Address :",JLabel.RIGHT);
        getContentPane().add(label_5);

        label_6 = new JLabel("Gender :",JLabel.RIGHT);
        getContentPane().add(label_6);

        label_7 = new JLabel("Phone :",JLabel.RIGHT);
        getContentPane().add(label_7);

        label_8 = new JLabel("Department :",JLabel.RIGHT);
        getContentPane().add(label_8);

        txtId = new JTextField("");
        getContentPane().add(txtId);

        header = new JLabel(headerImg);
        getContentPane().add(header);

        txtFname = new JTextField("");
        getContentPane().add(txtFname);

        txtLname = new JTextField("");
        getContentPane().add(txtLname);

        txtDob = new JTextField("");
        getContentPane().add(txtDob);

        txtAddr = new JTextField("");
        getContentPane().add(txtAddr);

        txtPhone = new JTextField("");
        getContentPane().add(txtPhone);

        comDepart = new JComboBox();
        comDepart.addItem("Laws");
        comDepart.addItem("Information Engineering");
        comDepart.addItem("Electronic Engineering");
        comDepart.addItem("Computer Engineering");
        comDepart.addItem("Chemistry Science");
        comDepart.addItem("Biology Science");
        comDepart.addItem("Physics Science");
        getContentPane().add(comDepart);

        cbg = new ButtonGroup();
        maleR = new JRadioButton("Male", true);
        cbg.add(maleR);
        getContentPane().add(maleR);

        femaleR = new JRadioButton("Female", false);
        cbg.add(femaleR);
        getContentPane().add(femaleR);

        addBtn = new JButton("Add");
        getContentPane().add(addBtn);

        clearAllbtn = new JButton("ClearAll");
        getContentPane().add(clearAllbtn);

        cancelBtn = new JButton("Cancel");
        getContentPane().add(cancelBtn);

        setSize(getPreferredSize());
        addBtn.addActionListener(this);
    	clearAllbtn.addActionListener(this);
    	cancelBtn.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==addBtn)
    	{
    		id=txtId.getText();
	    	fname=txtFname.getText();
	    	lname=txtLname.getText();
	    	dob=txtDob.getText();
	    	addr=txtAddr.getText();
	    	phone=txtPhone.getText();//another table
	    	
    		if(id.equals(""))
    		{
    			dialog.showMessageDialog(this,"Can't process\nID is empty !");
    		}
    		else if(fname.equals(""))
    		{
    			dialog.showMessageDialog(this,"Can't process\nFirstname is empty !");
    		}
    		else if(lname.equals(""))
    		{
    			dialog.showMessageDialog(this,"Can't process\nLastname is empty !");
    		}
    		else if(dob.equals(""))
    		{
    			dialog.showMessageDialog(this,"Can't process\nBithday is empty !");
    		}
    		else if(addr.equals(""))
    		{
    			dialog.showMessageDialog(this,"Can't process\nAddress is empty !");
    		}
    		else
    		{
	        
	    		switch(comDepart.getSelectedIndex())
	    		{
	    			case 0:department="0100";break;
	    			case 1:department="0201";break;
	    			case 2:department="0202";break;
	    			case 3:department="0203";break;
	    			case 4:department="0301";break;
	    			case 5:department="0302";break;
	    			case 6:department="0303";break;
	    		}
	    		if(maleR.isSelected())
	    			gender="M";
	    		else gender="F";
	    		String sql;
	    		try
	    		{
	    			sql="insert into student(stu_id,f_name,l_name,dob,address,gender,workunit_id)"
					+"values('"+id+"','"+fname+"','"+lname+"','"+dob+"','"+5+"','"+addr+"','"+department+"')";
		    		db.execUpdate(sql);
	    		}
	    		catch(Exception ex)
	    		{
	    			System.out.println("Error :"+ex.getMessage());
	    		}
	    		
	    		try
	    		{
	    			sql="insert into student_phone(stu_id,phone)"
					+"values('"+id+"','"+phone+"')";
					db.execUpdate(sql);
	    		}
	    		catch(Exception ex)
	    		{
	    			System.out.println("Error :"+ex.getMessage());
	    		}
	    		dialog.showMessageDialog(this,"New Student Added !");
	    		clearAllField();
    		}
    	}
    	if(e.getSource()==cancelBtn)
    	{
		    clearAllField();
    		MainGui.m_addStu.setSelected(false);
    		setVisible(false);
    	}
    	if(e.getSource()==clearAllbtn)
    	{
    		clearAllField();
    	}
    }
    public void clearAllField()
    {
    	txtId.setText("");
		txtFname.setText("");
		txtLname.setText("");
		txtDob.setText("");
		txtAddr.setText("");
		txtPhone.setText("");
    }
    public void itemStateChanged(ItemEvent e)
    {
    	
    }

}

class AddStudentLayout implements LayoutManager {

    public AddStudentLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 447 + insets.left + insets.right;
        dim.height = 406 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+104,136,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+136,136,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+168,136,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+200,136,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+232,136,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+264,136,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+296,136,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+328,136,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+104,216,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,448,96);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+136,216,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+168,216,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+200,216,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+232,216,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+296,216,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+328,216,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+264,88,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+288,insets.top+264,88,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+368,96,32);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+368,96,32);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+288,insets.top+368,96,32);}
    }
}
