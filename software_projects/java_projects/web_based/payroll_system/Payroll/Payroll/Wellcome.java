import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;
class Wellcome extends JFrame
{
	JPanel center;
	int x,y;
	Wellcome()
	{
		Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
		x=dim.width;
		y=dim.height;
		setSize(x,y);
		setUndecorated(true);

		center=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit = Toolkit.getDefaultToolkit();
				Image img =kit.getImage("Image/well.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,0);
				while(true)
				{
					try
					{
						t.waitForAll();
						break;
					}
					catch(Exception ee)
					{}
				}
				g.drawImage(img,0,0,x,y,null);
			}
		};
		add(center);
		center.setLayout(null);

		JLabel l=new JLabel("<html><body ><font size='35'><b><i>&nbsp;&nbsp; WellCome  &nbsp;&nbsp;</b></i></font></body></html>");
		l.setForeground(Color.red);
		l.setBounds(x/2,y/2,200,100);
		center.add(l);

		this.setVisible(true);

		try
		{
			Thread.sleep(3000);
		}
		catch (Exception e){}
		setVisible(false);
		new Login();
	}
	public static void main(String []args)
	{
		new Wellcome();
	}
}


