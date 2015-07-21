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

public class UserInfoPanel extends JPanel {
    JLabel myPic;
    JLabel label_2;
    JLabel label_3;
    JLabel label_4;
    JLabel label_5;
    JLabel label_6;
    JLabel label_7;
    JLabel label_8;
    JLabel label_9;
    JLabel label_10;
    JLabel idL;
    JLabel nameL;
    JLabel snameL;
    JLabel depL;
    JLabel genderL;
    JLabel dobL;
    JLabel addrL;
    JLabel phoneL;
    static Icon pic;

    public UserInfoPanel() {
        UserInfoPanelLayout customLayout = new UserInfoPanelLayout();

        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);

        myPic = new JLabel("");
        add(myPic);

        label_2 = new JLabel("Name : ");
        add(label_2);

        label_3 = new JLabel("Surname : ");
        add(label_3);

        label_4 = new JLabel("ID : ");
        add(label_4);

        label_5 = new JLabel("Departmemt : ");
        add(label_5);

        label_6 = new JLabel("My Profile :");
        add(label_6);

        label_7 = new JLabel("Birthday : ");
        add(label_7);

        label_8 = new JLabel("Gender : ");
        add(label_8);

        label_9 = new JLabel("Address : ");
        add(label_9);

        label_10 = new JLabel("Phone : ");
        add(label_10);

        idL = new JLabel("");
        add(idL);

        nameL = new JLabel("");
        add(nameL);

        snameL = new JLabel("");
        add(snameL);

        depL = new JLabel("");
        add(depL);

        genderL = new JLabel("");
        add(genderL);

        dobL = new JLabel("");
        add(dobL);

        addrL = new JLabel("");
        add(addrL);

        phoneL = new JLabel("");
        add(phoneL);

        setSize(getPreferredSize());

    }
    public static void loadImage(String user)
    {
    
    }

}

class UserInfoPanelLayout implements LayoutManager {

    public UserInfoPanelLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 386 + insets.left + insets.right;
        dim.height = 243 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,120,96);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+32,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+56,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+8,96,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+80,96,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+112,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+168,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+144,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+192,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+216,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+8,152,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+32,152,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+56,152,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+80,152,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+144,304,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+168,304,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+192,304,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+216,304,24);}
    }
}
