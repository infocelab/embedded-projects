/* 

								copyrights resreved @ mayank2cool@yahoo.com
                                -------------------------------------------

This is a simple programme to mail anybody. SendMail v1.0 saves you a visit to YAHOO or HOTMAIL or just
ANYTHING. Just fill in the required fields & hit "Send Mail". You need to have "JavaMail API" installed 
on your system & your "CLASSPATH" set to "mail.jar" & "activation.jar" To download the "JavaMail API" go
to  --- http://java.sun.com/products/javamail --- & follow the online instructions. 

c:\>javac SendMail.java
c:\>java SendMail

( Suppose you have SendMail.java in your c:\> drive )

For more on my wok visit  --- www.maitZone.com ---

*/



import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;


public class SendMail
{
	public static void main(String a[])
	{
		Image Icon = Toolkit.getDefaultToolkit().getImage("flag.gif") ;
		JFrame s = new SMTP();
		s.setIconImage(Icon);
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setSize(400,400);
		s.setResizable(false);
		s.setLocation(200,100);
		s.show();
	}
}


class SMTP extends JFrame implements ActionListener
{
	
	JButton			Send			= new JButton("Send  Message");
	JButton			Clear			= new JButton("Clear  All");
	JButton			Exit			= new JButton("Exit");
	JLabel			Spacer1			= new JLabel("                                                                                SendMail  v1.0");
	JLabel			Spacer2			= new JLabel("   ");
	JLabel			Contact			= new JLabel(" Contact me at   ::   info@computronicslab.com");
	JLabel			To				= new JLabel(" To:     ");
	JLabel			From			= new JLabel(" From:     ");
	JLabel			Subject			= new JLabel(" Subject:     ");
	JTextField		ToField			= new JTextField(30);
	JTextField		FromField		= new JTextField(30);
	JTextField		SubjectField	= new JTextField(30);
	JTextArea		Data			= new JTextArea(15,71);
	JScrollPane		Jsp				= new JScrollPane(Data);
	
	JPanel			Labels			= new JPanel();
	JPanel			Texts			= new JPanel();
	JPanel			Center			= new JPanel();	 
	JPanel			SubCenter		= new JPanel();	
	JPanel			South			= new JPanel();

	Box				north			= Box.createHorizontalBox();
	boolean			RESULT			= false;
	
	
	public SMTP()
	{
		setTitle("SendMail v1.0   ::   By :CELAB");
		Container C = getContentPane();
		C.setLayout(new BorderLayout());
                

		Labels.setLayout(new GridLayout(4,1));
		Labels.add(Spacer2);
		Labels.add(To);
		Labels.add(From);
		Labels.add(Subject);
		north.add(Labels);

		Texts.setLayout(new GridLayout(4,1));
		Texts.add(Spacer1);
		Texts.add(ToField);
			ToField.setFont(new Font("monospaced",Font.BOLD,12));
		Texts.add(FromField);
			FromField.setFont(new Font("monospaced",Font.BOLD,12));
		Texts.add(SubjectField);
			SubjectField.setFont(new Font("monospaced",Font.BOLD,12));
		north.add(Texts);
		
		C.add(north,BorderLayout.NORTH);
		
		Data.setFont(new Font("monospaced",Font.BOLD,15));
		Center.setLayout(new BorderLayout());
		SubCenter.add(Contact);
		Center.add(SubCenter,BorderLayout.NORTH);
		Center.add(Jsp,BorderLayout.CENTER);
		Data.setLineWrap(true);
		C.add(Center,BorderLayout.CENTER);

		South.add(Clear);
		South.add(Send);
		South.add(Exit);
		C.add(South,BorderLayout.SOUTH);

		Send.addActionListener(this);
		Clear.addActionListener(this);
		Exit.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource().equals(Exit))
		{
			System.exit(0);
		}
		
		if(ae.getSource().equals(Send))
		{
			try
			{
				RESULT = CheckValidity();
				if(RESULT == true)
				{
                                        
					Properties props = new Properties();
					props.put("mail.host","delhi1.mtnl.net.in");
	
					Session mail = Session.getInstance(props,null);
					final Message msg = new MimeMessage(mail);

					Address to = new InternetAddress(ToField.getText());
					Address from = new InternetAddress(FromField.getText());
				
					msg.setContent(Data.getText(),"text/plain");
					msg.setFrom(from);
					msg.setRecipient(Message.RecipientType.TO,to);
					msg.setSubject(SubjectField.getText());

					Runnable r = new Runnable()
					{
						public void run()
						{
							try
							{
								Transport.send(msg);
								ShowMessage("\""+SubjectField.getText()+"\" sent sucessfully.");
							}catch (Exception e)
								{
									ShowMessage("Error in sending \""+SubjectField.getText()+"\"");
								}
						}
					};
					Thread  t = new Thread(r);
					t.start();
				}
				else
				{
					ShowMessage("Please fill in the required fields.");
				}
	
			}catch(Exception e)
				{
					ShowMessage("Error...\nPlease Send the mail again.");
				}
				
		}
		if(ae.getSource().equals(Clear))
		{
			ToField.setText("");
			FromField.setText("");
			SubjectField.setText("");
			Data.setText("");
		}
	}
	
	public void ShowMessage(String mssg)
	{
		
		JOptionPane.showMessageDialog(null,mssg,"Alert",JOptionPane.INFORMATION_MESSAGE);
	}

	public boolean CheckValidity()
	{
		if(ToField.getText().equals("")||FromField.getText().equals(""))
		{
			return(false);
		}
		else
		{
			return(true);	
		}
		
	}
}
