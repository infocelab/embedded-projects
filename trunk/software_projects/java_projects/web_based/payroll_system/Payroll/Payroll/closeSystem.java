import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.URL;
import java.applet.*;

public class closeSystem extends JFrame
{
	closeSystem()
	{
		setSize(300,175);
		setLocation(Payroll.x/3,Payroll.y/3);
		setUndecorated(true);

		Container c=getContentPane();
		JPanel north=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit = Toolkit.getDefaultToolkit();
				Image img =kit.getImage("Image/turncen.gif");
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
				g.drawImage(img,-15,-10,325,75,null);

			}
		};
		c.add(north,"North");
		north.setBackground(Color.blue);
		title=new JLabel("Turn Off Computer");
		title.setFont(new Font("Arial",Font.BOLD,20));
		title.setForeground(new Color(255,255,255));
		north.add(new JLabel(new ImageIcon("Image/xp1.jpg")));
		north.add(title);
		north.add(new JLabel(new ImageIcon("Image/xp.jpg")));

		turnoff=new JButton(new ImageIcon("Image/exit.gif"));
		turnoff.setBackground(Color.red);
		logoff=new JButton(new ImageIcon("Image/log.gif"));
		logoff.setBackground(Color.green);
		standoff=new JButton(new ImageIcon("Image/stand.gif"));
		standoff.setBackground(Color.orange);

		JLabel st=new JLabel("Stand by ");
		st.setForeground(new Color(255,255,255));
		JLabel tun=new JLabel("Turn OFF ");
		tun.setForeground(new Color(255,255,255));
		JLabel lf=new JLabel(" Log OFF ");
		lf.setForeground(new Color(255,255,255));

		center =new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit = Toolkit.getDefaultToolkit();
				Image img =kit.getImage("Image/turnnorth.gif");
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
				g.drawImage(img,-15,-10,325,150,null);

			}
		};
		GridBagLayout layout = new GridBagLayout();
		center.setLayout(layout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.weightx = 0;
	    constraints.weighty = 0;

	    add(standoff,constraints,0,0,1,1);
	    add(new JLabel("     "),constraints,1,0,1,1);
	    add(turnoff,constraints,2,0,1,1);
	    add(new JLabel("     "),constraints,3,0,1,1);
	    add(logoff,constraints,4,0,1,1);
	    add(new JLabel("     "),constraints,0,1,1,1);

	    add(st,constraints,0,2,1,1);
	    add(tun,constraints,2,2,1,1);
	    add(lf,constraints,4,2,1,1);

	    URL urlClick = closeSystem.class.getResource("spacemusic.au");
	    click = Applet.newAudioClip(urlClick);

	    south =new JPanel()
	    {
			public void paintComponent(Graphics g)
			{
				Toolkit kit = Toolkit.getDefaultToolkit();
				Image img =kit.getImage("Image/turncen.gif");
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
				g.drawImage(img,-15,-10,325,75,null);

			}
		};

		c.add(south,"South");
		cancel=new JButton("<html><body><font size='2'><b>&nbsp;&nbsp;Cancel &nbsp;&nbsp;</b></font></body></html>");
		south.setLayout(new BorderLayout());
		south.add(cancel,"East");
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
		});
		turnoff.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					click .play();
					Runtime rt = Runtime.getRuntime();
					rt.exec("shutdown -f -s");
				}
				catch(Exception er)
				{
					System.out.println(""+er);
				}
			}
		});
		logoff.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{

					setVisible(false);
					paro.setVisible(false);
					new Wellcome();
				}
				catch(Exception er)
				{
					System.out.println(""+er);
				}
			}
		});
		standoff.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

	}
	public void add(Component c, GridBagConstraints constraints, int x, int y, int w, int h)
	{
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;

		//		getContentPane().add(c, constraints);
		getContentPane().add(center);

		center.add(c, constraints);
	}

	private JButton turnoff,logoff,standoff,cancel;
	private JLabel title;
	private JPanel center,south;
	AudioClip click;
	static Payroll paro=new Payroll();
}