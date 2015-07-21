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
public class RemoveStudent extends JInternalFrame 
implements ActionListener 
{
    JLabel label_1;
    JLabel label_4;
    JTextField txtId1;
    JLabel header;
    JTextField txtId2;
    JButton removeBtn;
    JButton cancelBtn;
    JTextArea txtReport;
    JScrollPane sp_txtError;
    JLabel label_9;
    JLabel label_10;
    ExecDb db;
	JOptionPane dialog;
	String report="",exist="";
    public RemoveStudent() {
    	super("Add new student record",true,false,true,true);
    	
    	dialog=new JOptionPane();
    	db=new ExecDb();
    	
        RemoveStudentLayout customLayout = new RemoveStudentLayout();
		Icon headerImg=new ImageIcon("img"+MyVar.sep+"removestudent.jpg");
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("From :",JLabel.RIGHT);
        getContentPane().add(label_1);

        label_4 = new JLabel("To :",JLabel.RIGHT);
        getContentPane().add(label_4);

        txtId1 = new JTextField("");
        getContentPane().add(txtId1);

        header = new JLabel(headerImg);
        getContentPane().add(header);

        txtId2 = new JTextField("");
        getContentPane().add(txtId2);

        removeBtn = new JButton("Remove");
        getContentPane().add(removeBtn);

        cancelBtn = new JButton("Cancel");
        getContentPane().add(cancelBtn);

        txtReport = new JTextArea("");
        sp_txtError = new JScrollPane(txtReport);
        getContentPane().add(sp_txtError);

        label_9 = new JLabel("Report :",JLabel.LEFT);
        getContentPane().add(label_9);

        label_10 = new JLabel("( require Student ID )",JLabel.CENTER);
        getContentPane().add(label_10);

        setSize(getPreferredSize());
        removeBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
    	String sql,id1,id2;
    	if(e.getSource()==removeBtn)
    	{
    		id1=txtId1.getText();
    		id2=txtId2.getText();
    		
    		if(id1.equals("")&&id2.equals(""))//both are empty
    		{
    			dialog.showMessageDialog(this,"Both fields are empty!"
    			+"\nYou must fill both for range delete\nor fill one of them"
    			+"for delete only one record");
    		}
    		else if(id1.equals(""))//txtId2 is not empty
    		{
    			exist=db.execString("select f_name from student where stu_id='"+id2+"'","f_name");
    			if(exist.equals(""))
				{
					txtReport.append("Student ID : "+id2+"  Not Found !!! Error: Can not delete"+"\n");
				}
				else
				{
					report=db.execString("select f_name from student where stu_id='"
					+id2+"'","f_name")+"     ";
					report+=db.execString("select l_name from student where stu_id='"
					+id2+"'","l_name")+"     (Deleted!)";
					txtReport.append("Student ID : "+id2+"  Name : "+report+"\n");
				}
    			sql="delete from student"
					+" where stu_id='"+id2+"'";
    			db.execUpdate(sql);
    			sql="delete from student_phone"
					+" where stu_id='"+id2+"'";
				db.execUpdate(sql);
				success();
				
    		}
    		else if(id2.equals(""))//txtId1 is not empty
    		{
    			exist=db.execString("select f_name from student where stu_id='"+id1+"'","f_name");
    			if(exist.equals(""))
				{
					txtReport.append("Student ID : "+id1+"  Not Found !!! Error: Can not delete"+"\n");
				}
				else
				{
					report=db.execString("select f_name from student where stu_id='"
					+id1+"'","f_name")+"     ";
					report+=db.execString("select l_name from student where stu_id='"
					+id1+"'","l_name")+"     (Deleted!)";
					txtReport.append("Student ID : "+id1+"  Name : "+report+"\n");
				}
    			sql="delete from student"
					+" where stu_id='"+id1+"'";
    			db.execUpdate(sql);
    			sql="delete from student_phone"
					+" where stu_id='"+id1+"'";
				db.execUpdate(sql);
				success();
    		}
    		else //both are not empty
    		{
    			
    			int i1=Integer.parseInt(id1);
    			int i2=Integer.parseInt(id2);
    			if(i1<i2)
    			{
    				for(int i=i1;i<=i2;i++)
    				{
    					exist=db.execString("select f_name from student where stu_id='"+i+"'","f_name");
		    			if(exist.equals(""))
						{
							txtReport.append("Student ID : "+i+"  Not Found !!! Error: Can not delete"+"\n");
						}
						else
						{
							report=db.execString("select f_name from student where stu_id='"
							+i+"'","f_name")+"     ";
							report+=db.execString("select l_name from student where stu_id='"
							+i+"'","l_name")+"     (Deleted!)";
							txtReport.append("Student ID : "+i+"  Name : "+report+"\n");
						}
						//******************
    					sql="delete from student"
						+" where stu_id='"+i+"'";
    					db.execUpdate(sql);	
    					sql="delete from student_phone"
						+" where stu_id='"+i+"'";
						db.execUpdate(sql);
    				}
    				success();
    			}
    			else
    			{
    				dialog.showMessageDialog(this,"First field must have a"
    				+" value more than Second field\n or If you want to remove"
    				+"\nonly one record don't fill both field just fill one field"
    				+"\nfrom two field upper or lower field is the same!");
    			}
    			
    		}
    			
    	}
    	if(e.getSource()==cancelBtn)
    	{
    		txtId1.setText("");
    		txtId2.setText("");
    		txtReport.setText("");
    		MainGui.m_removeStu.setSelected(false);
    		setVisible(false);
    	}
    }
    public void success()
    {
    	dialog.showMessageDialog(this,"Successful removal !");
    	txtId1.setText("");
    	txtId2.setText("");
    }
}

class RemoveStudentLayout implements LayoutManager {

    public RemoveStudentLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 447 + insets.left + insets.right;
        dim.height = 409 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+136,64,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+168,40,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+136,104,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,448,96);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+168,104,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+368,96,32);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+368,96,32);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+216,432,136);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+192,96,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+104,160,24);}
    }
}
