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

public class Step3 extends JPanel 
implements ActionListener
{
    JLabel label_2;
    JLabel label_3;
    JLabel label_4;
    JLabel label_5;
    JLabel label1;
    JLabel label_7;
    JLabel label_8;
    JLabel label_9;
    JLabel label_10;
    JLabel label_11;
    JLabel label_12;
    JLabel label_13;
    JLabel label_14;
    static JTextField subject1,subject2,subject3,subject4,subject5,subject6,
    		subject7,subject8,subject9,subject10;
    JButton btnNext;
    JLabel lStep2;
    JLabel termLabel;
    JLabel yearLabel;
    JButton btnBack;
    JOptionPane dialog;
	ExecDb db;
	
    public Step3() {
        Step3Layout customLayout = new Step3Layout();
        db=new ExecDb();
        dialog=new JOptionPane();
        Icon header1=new ImageIcon("img"+MyVar.sep+"step3.jpg");

        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);

        label_2 = new JLabel("Term :");
        add(label_2);

        label_3 = new JLabel("Academic year :");
        add(label_3);

        label_4 = new JLabel("Do you have selected these subject ?",JLabel.CENTER);
        add(label_4);

        subject1 = new JTextField("");
        add(subject1);

        label_5 = new JLabel("Subject 1 :");
        add(label_5);

        label1 = new JLabel("Subject 3 :");
        add(label1);

        label_7 = new JLabel("Subject 5 :");
        add(label_7);

        label_8 = new JLabel("Subject 7 :");
        add(label_8);

        label_9 = new JLabel("Subject 9 :");
        add(label_9);

        label_10 = new JLabel("Subject 2 :");
        add(label_10);

        label_11 = new JLabel("Subject4 :");
        add(label_11);

        label_12 = new JLabel("Subject 6 :");
        add(label_12);

        label_13 = new JLabel("Subject 8 :");
        add(label_13);

        label_14 = new JLabel("Subject 10:");
        add(label_14);

        subject3 = new JTextField("");
        add(subject3);

        subject5 = new JTextField("");
        add(subject5);

        subject7 = new JTextField("");
        add(subject7);

        subject9 = new JTextField("");
        add(subject9);

        subject2 = new JTextField("");
        add(subject2);

        subject4 = new JTextField("");
        add(subject4);

        subject6 = new JTextField("");
        add(subject6);

        subject8 = new JTextField("");
        add(subject8);

        subject10 = new JTextField("");
        add(subject10);

        btnNext = new JButton("Next>>");
        add(btnNext);

        lStep2 = new JLabel(header1);
        add(lStep2);

        termLabel = new JLabel("1");
        add(termLabel);

        yearLabel = new JLabel("4547");
        add(yearLabel);

        btnBack = new JButton("<<Back");
        add(btnBack);

        setSize(getPreferredSize());
        
		btnNext.addActionListener(this);
		btnBack.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==btnNext)
    	{
    		if((dialog.showConfirmDialog(this,"Are you sure everything is correct?","Confirm",
    			JOptionPane.OK_CANCEL_OPTION ))==JOptionPane.CANCEL_OPTION)
    			{
    				
    				dialog.showMessageDialog(this,"Not Registered! Please check it again");
    				
    			}
    			else
    			{
    				try
    				{
    					updateData();
    				}
    				catch(Exception ex)
    				{
    					System.out.println("Error :"+ex.getMessage());
    				}
    				
    				dialog.showMessageDialog(this,"No. "+MyVar.userName+" Successful Register");
    				Enrollment.tab.setEnabledAt(3,true);
    				Enrollment.tab.setSelectedIndex(3);
    			}
    		
    	}
    	if(e.getSource()==btnBack)
    	{
    		Enrollment.tab.setEnabledAt(2,false);
    		Enrollment.tab.setEnabledAt(3,false);
    		Enrollment.tab.setSelectedIndex(1);
    	}
    }
    public void updateData()
    {
    	for(int i=0;i<10;i++)
    	{
    		if(!MyVar.subCode[i].equals(""))
    		{
    			db.execUpdate("insert into enrollment(open_id,Stu_id)"
				+"values('"+MyVar.subCode[i]+"','"+MyVar.userName+"')");
    		}
    	}

    	
    }

   
}

class Step3Layout implements LayoutManager {

    public Step3Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 490 + insets.left + insets.right;
        dim.height = 367 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+96,56,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+96,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+128,296,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+160,128,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+160,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+192,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+224,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+256,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+288,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+160,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+192,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+224,72,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+256,72,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+288,72,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+192,128,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+224,128,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+256,128,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+288,128,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+160,128,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+192,128,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+224,128,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+256,128,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+288,128,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+320,88,40);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,496,88);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+96,72,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+96,72,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+320,88,40);}
    }
}
