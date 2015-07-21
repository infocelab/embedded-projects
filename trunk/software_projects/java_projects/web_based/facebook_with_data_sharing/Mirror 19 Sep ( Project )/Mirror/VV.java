import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.File.*;

public class VV extends JApplet
    implements ActionListener
{

    JButton b;

    public VV()
    {
	try

		{

			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}

		catch(Exception e)
		{}
    }

    public void init()
    {
        b = new JButton("Goto..Login Page..");
	b.setBackground(Color.black);
	b.setForeground(Color.red);
	ImageIcon h=new ImageIcon("image/roll.JPG");
	b.setRolloverIcon(h);
	VV c=new VV();
	b.setBounds(40,40,150,30);
	b.setSize(150,30);
	b.setLocation(70,80);
        add(b);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        login login1 = new login("Login");
        login1.setVisible(true);
        login1.setSize(800, 700);
    }
}
