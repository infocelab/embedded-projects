import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.io.File.*;
class error extends JFrame
{
JLabel l1;
JButton b1;
error(String str)
{
Container cp=getContentPane();
cp.setLayout(new FlowLayout());
l1=new JLabel();
try

		{

			UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		}

		catch(Exception e)
		{}

l1.setText(str+"");
b1=new JButton("OK");
cp.add(l1);cp.add(b1);
b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e){
setVisible(false);
}
});

}
}