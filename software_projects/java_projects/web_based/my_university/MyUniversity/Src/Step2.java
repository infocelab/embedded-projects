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

public class Step2 extends JPanel 
implements ActionListener
{
    JLabel label_2;
    JLabel label_3;
    JLabel label_4;
    JTextField subject1;
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
    JTextField subject3;
    JTextField subject5;
    JTextField subject7;
    JTextField subject9;
    JTextField subject2;
    JTextField subject4;
    JTextField subject6;
    JTextField subject8;
    JTextField subject10;
    JButton btnNext;
    JLabel lStep2;
    JLabel termLabel;
    JLabel yearLabel;
    JButton btnBack;
	JOptionPane dialog;
	ExecDb db;
    public Step2() {
    	
        Step2Layout customLayout = new Step2Layout();
        
        db=new ExecDb();
		dialog=new JOptionPane();
		
		Icon header1=new ImageIcon("img"+MyVar.sep+"step2.jpg");
		FileHandle fh=new FileHandle();
		
        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);

        label_2 = new JLabel("Term :");
        add(label_2);

        label_3 = new JLabel("Academic year :");
        add(label_3);

        label_4 = new JLabel("Fill all subject field with ID Code only",JLabel.CENTER);
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
    	MyVar.subAmount=0; //initial
    	
    	
    	if(e.getSource()==btnNext)
    	{
    		
    		clearAllSub(); //Clear Existing value of MyVar.subName to ""
    		
    		if(!subject1.getText().equals(""))
    		{
    			MyVar.subCode[0]=subject1.getText();
    			MyVar.subAmount++;
    		}
    		if(!subject2.getText().equals(""))
    		{
    			MyVar.subCode[1]=subject2.getText();
    			MyVar.subAmount++;
    		}
    		if(!subject3.getText().equals(""))
    		{
    			MyVar.subCode[2]=subject3.getText();
    			MyVar.subAmount++;
    		}
    		if(!subject4.getText().equals(""))
    		{
    			MyVar.subCode[3]=subject4.getText();
    			MyVar.subAmount++;
    		}
    		if(!subject5.getText().equals(""))
    		{
    			MyVar.subCode[4]=subject5.getText();
    			MyVar.subAmount++;
    		}
    		if(!subject6.getText().equals(""))
    		{
    			MyVar.subCode[5]=subject6.getText();
    			MyVar.subAmount++;
    		}
    		if(!subject7.getText().equals(""))
    		{
    			MyVar.subCode[6]=subject7.getText();
    			MyVar.subAmount++;
    		}
    		if(!subject8.getText().equals(""))
    		{
    			MyVar.subCode[7]=subject8.getText();
    			MyVar.subAmount++;
    		}
    		if(!subject9.getText().equals(""))
    		{
    			MyVar.subCode[8]=subject9.getText();
    			MyVar.subAmount++;
    		}
    		if(!subject10.getText().equals(""))
    		{
    			MyVar.subCode[9]=subject10.getText();
    			MyVar.subAmount++;
    		}
  
    		
    		if(MyVar.subAmount>8)
    		{
    			if((dialog.showConfirmDialog(this,"You have filled subject code more than"
    			+"\n8 fields,Are you sure you'll graduate in this term"
    			+"\nAnswer \"Yes\" click OK if \"No\" click Cancel","Graduate?",
    			JOptionPane.OK_CANCEL_OPTION ))==JOptionPane.CANCEL_OPTION)
    			{
    				dialog.showMessageDialog(this,"Please clear one or more field");
    				
    			}
    			else
    			{
    				queryManage();
    			}
    		}
    		else
    		{
    		
    			queryManage();
    		}
    		
    		
    	}
    	if(e.getSource()==btnBack)
    	{
    		Enrollment.tab.setEnabledAt(1,false);
    		Enrollment.tab.setEnabledAt(2,false);
    		Enrollment.tab.setEnabledAt(3,false);
    		Enrollment.tab.setSelectedIndex(0);
    	}
    }
    public String querySubject(String id)
    //Input=Open_id,Output=SubjectName
    {
    	String sql="select sub.sub_name"
		+" from subject sub,open_subject op"
		+" where sub.sub_id=op.sub_id and op.open_id='"+id+"'";
		
    	return db.execString(sql,"sub_name");
    	
    }
    public void queryManage()
    {
    	int success=0;
    	
    	for(int i=0;i<10;i++)
    	{
    		MyVar.subName[i]=querySubject(MyVar.subCode[i]);
    		if(!MyVar.subName[i].equals(""))
    		{
    			success++;
    		}
    	}
    	if(success==MyVar.subAmount)
    	{
    		
    		//Success
    		dialog.showMessageDialog(this,"Total Subject = "+success);
    		Enrollment.tab.setEnabledAt(2,true);
    		Enrollment.tab.setSelectedIndex(2);
    		
    		Step3.subject1.setText(MyVar.subName[0]);
    		Step3.subject2.setText(MyVar.subName[1]);
    		Step3.subject3.setText(MyVar.subName[2]);
    		Step3.subject4.setText(MyVar.subName[3]);
    		Step3.subject5.setText(MyVar.subName[4]);
    		Step3.subject6.setText(MyVar.subName[5]);
    		Step3.subject7.setText(MyVar.subName[6]);
    		Step3.subject8.setText(MyVar.subName[7]);
    		Step3.subject9.setText(MyVar.subName[8]);
    		Step3.subject10.setText(MyVar.subName[9]);
    		
    		
    	}
    	else
    	{
    		//Some query fail
    		dialog.showMessageDialog(this,"Some field is not correct!\nPlease check ID code again");
    		
    	}
    	
    }
    public void clearAllSub()
    {
    	for(int i=0;i<10;i++)
    		MyVar.subName[i]="";
    }

}

class Step2Layout implements LayoutManager {

    public Step2Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 493 + insets.left + insets.right;
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
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+96,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+128,296,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+160,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+160,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+192,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+224,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+256,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+288,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+296,insets.top+160,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+296,insets.top+192,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+296,insets.top+224,72,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+296,insets.top+256,72,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+296,insets.top+288,72,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+192,72,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+224,72,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+256,72,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+288,72,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+160,72,24);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+192,72,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+224,72,24);}
        c = parent.getComponent(21);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+256,72,24);}
        c = parent.getComponent(22);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+288,72,24);}
        c = parent.getComponent(23);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+320,88,40);}
        c = parent.getComponent(24);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,496,88);}
        c = parent.getComponent(25);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+96,72,24);}
        c = parent.getComponent(26);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+96,72,24);}
        c = parent.getComponent(27);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+320,88,40);}
    }
}
