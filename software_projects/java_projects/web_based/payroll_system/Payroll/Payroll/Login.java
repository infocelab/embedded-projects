import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

class Login extends JFrame
{
	JPanel center;
	int x,y;
	Login()
	{
		Dimension dim =Toolkit.getDefaultToolkit().getScreenSize();
		x=dim.width;
		y=dim.height;
		setSize(x,y);
		setUndecorated(true);

		pb=new JProgressBar();
		pb.setStringPainted(true);

		center=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit = Toolkit.getDefaultToolkit();
				Image img =kit.getImage("Image/login.jpg");
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
		center.setLayout(null);
		pb.setBounds(y/2,x/2,250,25);
		pb.setBorder(BorderFactory.createRaisedBevelBorder());
		pb.setForeground(new Color(0,0,00));
		center.add(pb);
		add(center);


		time=new Timer(500,new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				pb.setValue(pb.getValue() + 10);

				if(pb.getValue()==30)
				{
					pb.setForeground(new Color(250,200,200));
				}
				if(pb.getValue()==60)
				{
					pb.setForeground(new Color(255,255,200));
				}
				if(pb.getValue()==80)
				{
					pb.setForeground(new Color(0,0,00));
				}
			}
		});
		time.start();
		setVisible(true);
		try
		{
			Thread.sleep(10000);

		}
		catch (Exception e){}
		dispose ();
		Usermaster uu=new Usermaster();
		uu.setVisible(true);
		//dispose ();

	}

	JProgressBar pb;
	Timer time;
}


