import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class MainMenuFrame extends JFrame
{
	ImagePanel imagepanel;
	JPanel buttonpanel;
	private Image image;
   	private int current=1;
   	private int imageCount=36;
   	private int imageWidth;
   	private int imageHeight;
   	private Thread runner;
	MainMenuFrame()
	{
		setSize(600,600);
		setTitle("Result Intemation System");
		setLocation(220,20);
		setDefaultCloseOperation(3);
		LoginFrame.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		Image img=Toolkit.getDefaultToolkit().getImage("mainicon.png");
		setIconImage(img);
		Container c=getContentPane();
		JPanel mainpanel=new JPanel();

		JPanel subpanel=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("title_background.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,600,600,null);
			}
		};
		 buttonpanel=new JPanel()
		 {
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("title_background.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,600,600,null);
			}
		 };
		imagepanel=new ImagePanel();
		subpanel.setBackground(new Color(245, 240, 255));
		imagepanel.setBackground(new Color(245, 240, 255));

		mainpanel.setLayout(new BorderLayout());
		JLabel l=new JLabel("<html><font size=6 color=#800080><i>Main Menu");
		JPanel title=new JPanel()
		{
			public void paintComponent(Graphics g)
			{

				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("HEADER.gif");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,600,50,null);
			}
		};
		title.add(l);
		mainpanel.add(title,"North");
		mainpanel.add(subpanel);
		subpanel.setLayout(new GridLayout(1,2,10,10));
		subpanel.add(imagepanel);
		subpanel.add(buttonpanel);
		buttonpanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonpanel.setLayout(new GridLayout(12,0,20,12));
		buttonpanel.add(new JLabel(""));
		ButtonHandler handler=new ButtonHandler();
		JButton emergency_contact=addButton("Emergency Contact",handler);
		emergency_contact.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		emergency_contact.setVisible(false);
		JButton student_info=addButton("Student Information",handler);
		student_info.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton internal_report=addButton("Internal Exam Report",handler);
		internal_report.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton memo_form=addButton("Memo Window",handler);
		memo_form.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton invetation_form=addButton("Invitaion Card",handler);
		invetation_form.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton staff_contact=addButton("Staff Information",handler);
		staff_contact.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton gest_contact=addButton("Gest Information",handler);
		gest_contact.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));
		JButton exit=addButton("Exit",handler);
		exit.setBorder(BorderFactory.createBevelBorder(1, new Color(100, 100, 155), new Color(100, 100, 155)));

		c.add(mainpanel);
	}
	JButton addButton(String s,ActionListener listen)
	{
		JButton  b=new JButton(s);
		b.addActionListener(listen);
		buttonpanel.add(b);
		return b;
	}
	class ImagePanel extends JPanel
	{
		ImageIcon ic;
		ImagePanel()
		{
			setLayout(new BorderLayout());

		}
		public void paintComponent(Graphics g)
		{
			Image img=Toolkit.getDefaultToolkit().getImage("n66.jpg");
			ic=new ImageIcon(img,"Center");
      		g.drawImage(img,10,70,280,300,null);
		}
	}

	class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String action=e.getActionCommand();
			if(action.equals("Student Information"))
			{
				StudentInfo info=new StudentInfo();
				info.setVisible(true);
				setVisible(false);
			}
			if(action.equals("Internal Exam Report"))
			{
				StudentInternalReport report=new StudentInternalReport();
				report.setVisible(true);
				setVisible(false);
			}
			if(action.equals("Memo Window"))
			{
				MemoWindow memo=new MemoWindow();
				memo.setVisible(true);
				setVisible(false);
			}
			if(action.equals("Invitaion Card"))
			{
				InvetationForm invite=new InvetationForm();
				invite.setVisible(true);
				setVisible(false);
			}
			if(action.equals("Emergency Contact"))
			{
				EmergencyContact emergency=new EmergencyContact();
				emergency.setVisible(true);
				setVisible(false);
			}
			if(action.equals("Staff Information"))
			{
				StaffContact staff=new StaffContact();
				staff.setVisible(true);
				setVisible(false);
			}
			if(action.equals("Gest Information"))
			{
				GestContact gest=new GestContact();
				gest.setVisible(true);
				setVisible(false);
			}
			if(action.equals("Exit"))
				System.exit(0);


		}
	}


}