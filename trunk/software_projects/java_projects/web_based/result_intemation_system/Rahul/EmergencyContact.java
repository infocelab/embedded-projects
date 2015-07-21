import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.plaf.metal.*;
import java.sql.*;
import java.io.*;
import javax.swing.event.*;
class EmergencyContact extends JFrame
{
	Container c;
	EmergencyContact()
	{
		setSize(620,640);
		setTitle("Emergency Contact");
		setLocation(220,20);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				new MainMenuFrame().setVisible(true);
			}
		});
		EmergencyContact.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		JTextField tf=new JTextField("Emergency Contact",SwingConstants.CENTER);
		tf.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setEditable(false);
		tf.setBackground(new Color(192,192,255));
		tf.setFont(new Font("verdana",Font.BOLD,28));
		tf.setForeground(new Color(255,255,255));
		c=getContentPane();
		c.add(tf,"North");


	}
}