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

public class Step1 extends JPanel implements ActionListener
{
    JLabel label_9;
    JLabel lStep4;
    JButton showSubBtn;
    JTextArea txtArea;
    JScrollPane sp_txtArea;
    JButton nextStepBtn;

    public Step1() {
        Step1Layout customLayout = new Step1Layout();
        
		Icon header1=new ImageIcon("img"+MyVar.sep+"step1.jpg");
		FileHandle fh=new FileHandle();
		
        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);

        label_9 = new JLabel("Read First before do the next step :",JLabel.CENTER);
        add(label_9);

        lStep4 = new JLabel(header1);
        add(lStep4);

        showSubBtn = new JButton("Show available subject");
        add(showSubBtn);

        txtArea = new JTextArea("");
        sp_txtArea = new JScrollPane(txtArea);
        add(sp_txtArea);
        
        fh.loadFile("doc","step1",txtArea);

        nextStepBtn = new JButton("OK! next step>>");
        add(nextStepBtn);

        setSize(getPreferredSize());
		showSubBtn.addActionListener(this);
		nextStepBtn.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==nextStepBtn)
    	{
    		Enrollment.tab.setEnabledAt(1,true);
    		Enrollment.tab.setSelectedIndex(1);
    	}
    	if(e.getSource()==showSubBtn)
    	{
    			String sql="select op.open_id as ID,op.sub_id as SubjectID"
				+",sub.sub_name as Name,sub.Credit,d.date_test as Exam"
				+" from open_subject op,subject sub,open_date d"
				+" where op.sub_id=sub.sub_id and op.open_id=d.open_id";
				MainGui.myDb.executeQuery(sql);
    	}
    }

    
}

class Step1Layout implements LayoutManager {

    public Step1Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 492 + insets.left + insets.right;
        dim.height = 361 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+96,200,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,496,88);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+312,144,40);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+120,360,184);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+312,144,40);}
    }
}
