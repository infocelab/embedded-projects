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

public class Step4 extends JPanel
implements ActionListener
{
    JLabel label_5;
    JLabel pic1;
    JLabel label_9;
    JLabel label_10;
    JLabel label_11;
    JLabel label_12;
    JLabel label_13;
    JTextField txtCredit;
    JTextField txtPassword;
    JLabel lStep4;
    JButton btnFinish1;
    JComboBox combo1;
    JLabel pic2;
    JButton btnFinish2;
    JTextArea txtArea;
    JScrollPane sp_txtArea;

    public Step4() {
        Step4Layout customLayout = new Step4Layout();
        
        Icon header1=new ImageIcon("img"+MyVar.sep+"step4.jpg"),
        	visa=new ImageIcon("img"+MyVar.sep+"visa.jpg"),
        	master=new ImageIcon("img"+MyVar.sep+"master.jpg");
		FileHandle fh=new FileHandle();

        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);

        label_5 = new JLabel("Pay via bank account :",JLabel.CENTER);
        add(label_5);

        pic1 = new JLabel(master);
        add(pic1);

        label_9 = new JLabel("Pay online via credit card :",JLabel.CENTER);
        add(label_9);

        label_10 = new JLabel("Select one :");
        add(label_10);

        label_11 = new JLabel("Powered by : PayPal");
        add(label_11);

        label_12 = new JLabel("Credit card number ::");
        add(label_12);

        label_13 = new JLabel("Password :");
        add(label_13);

        txtCredit = new JTextField("");
        add(txtCredit);

        txtPassword = new JTextField("");
        add(txtPassword);

        lStep4 = new JLabel(header1);
        add(lStep4);

        btnFinish1 = new JButton("Finish (Pay later)");
        add(btnFinish1);

        combo1 = new JComboBox();
        combo1.addItem("Mastercard ");
        combo1.addItem(" Visa");
        add(combo1);

        pic2 = new JLabel(visa);
        add(pic2);

        btnFinish2 = new JButton("Finish (Pay now!)");
        add(btnFinish2);

        txtArea = new JTextArea("");
        sp_txtArea = new JScrollPane(txtArea);
        add(sp_txtArea);
        fh.loadFile("doc","step4",txtArea);

        setSize(getPreferredSize());
		btnFinish1.addActionListener(this);
		btnFinish2.addActionListener(this);
      
    }
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==btnFinish1)
    	{
    		setVisible(false);
    	}
    	if(e.getSource()==btnFinish2)
    	{
    		setVisible(false);
    	}
    }

}

class Step4Layout implements LayoutManager {

    public Step4Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 494 + insets.left + insets.right;
        dim.height = 358 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+96,176,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+352,insets.top+160,56,48);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+96,200,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+128,104,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+272,128,32);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+208,112,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+240,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+352,insets.top+208,128,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+352,insets.top+240,128,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,496,88);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+312,136,40);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+352,insets.top+128,128,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+424,insets.top+160,56,48);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+312,136,40);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+128,208,176);}
    }
}
