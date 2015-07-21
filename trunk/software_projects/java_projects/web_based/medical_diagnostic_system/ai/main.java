/** Medical Diagnostic System for Heart Diseases
	build 10/10/2002
	Genre: Expert System for Doctors and Patients
	language: Java
	Knowledgebase: Amzi KnowledgeWright
	Database: Microsoft Access XP
	L&F: Oyoaha look and feel
*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.util.*;
import java.text.*;
import javax.swing.text.html.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.UIManager;
import javax.swing.tree.*;
import java.io.*;
import java.util.*;
import java.awt.PrintJob.*;
import java.net.*;
import com.oyoaha.swing.plaf.oyoaha.*;
import amzi.ls.*;

/**
 -This program has been solely programmed for an AI project and not meant for any business means.
 -If you intend to use the code please do so freely on condition you acknowledge us.
 -Created by Group 13 - CyberVision softwares.
 -Thanx to Oyoaha for providing us such a wonderful look and feel.Please include in the path
  the path name of the oyaha jar file when compiling.
 -The ODBC datasource name is AI please do not forget to set that before running then program.
 -Please DO NOT DELETE the following files
 		
 		-amzi folder (contains the logic server files amzi.ls)
 		-amzi.dll
 		-amzijni.dll
 		-amzi.cfg
 		-kw.cfg
 		-Utils.class
 		-oalnf.jar
 		-java_run.jpx
 		-aodbc.lsx
 		-aosutils.lsx
 		-basic.xpl (main file)
 		-kwauthor.xpl
 		-support.xpl
 
 -These files are needed for the connecivity with the knwoledgebase.
 -Please do not hesitate to submit any bug to us.
 -You can mail us on dh002211@ex.apiit.edu.my

 @author Asrar Ahmed Makrani
 @version 1.4.0 build 3
 */

public class main extends JFrame implements TreeSelectionListener, mainInterface
{

	public JPanel logoPanel = new JPanel();
	public JPanel linkPanel = new JPanel();
	public JPanel infoPanel = new JPanel();
	public JPanel basePanel = new JPanel();
	public Icon logo = new ImageIcon("x.jpg");
	public JLabel logoLabel = new JLabel(logo);
	public JLabel wordings;
	public JTree links;	
	public JTextArea info = new JTextArea(10,10);
	public JScrollPane infoScroller = new JScrollPane(info);
	public Container c = getContentPane();
	public JMenuBar menuBar = new JMenuBar();
	public JMenu file = new JMenu("File");
	public JMenu help = new JMenu("Help");
	public JMenuItem about = new JMenuItem("About us", new ImageIcon("about.gif"));
	public JMenuItem exit = new JMenuItem("Exit", new ImageIcon("blank.gif"));
	public JMenuItem helpMenu = new JMenuItem("Help", new ImageIcon("help.gif"));
	public JMenu site = new JMenu("AHFI on the web");
	public JMenuItem ahfiSite = new JMenuItem("AHFI site", new ImageIcon("world.gif"));
	public JMenuItem ahfiFaq = new JMenuItem("Frequently Asked Questions", new ImageIcon("world.gif"));
	public JMenuItem ahfiTs = new JMenuItem("Technical Support", new ImageIcon("world.gif"));
	public JMenuItem ahfiFeed = new JMenuItem("Give us your Feedback", new ImageIcon("world.gif"));
	public JMenuItem print = new JMenuItem("Print", new ImageIcon("print.gif"));
	public String text = "";
	public Date currentDate;
	public SimpleDateFormat formatter;
	public patients p = new patients();
	public JScrollPane linkScroller;
	public aboutUs ab = new aboutUs();
	public JEditorPane editor = null;
	public addRule addRules = new addRule();
	public JScrollPane rule_scroller = new JScrollPane(addRules);
	public risk_factors r_f = new risk_factors();
	public LogicServer ls;
	public int ctr = 0;
	JScrollPane scroller = new JScrollPane();
	JEditorPane output = new JEditorPane();


	public main()
	{
		super("Heart Disease Info Center");
		
		splash();
		System.out.println("ok2");
		this.setResizable(false);

			try
			{
			  OyoahaLookAndFeel lnf = new OyoahaLookAndFeel();
			  UIManager.setLookAndFeel(lnf);
			}
			catch (UnsupportedLookAndFeelException e)
			{
				e.printStackTrace();
			}

				//Quit this app when the big window closes.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

		setIconImage(getToolkit().getImage("heart.gif"));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int paintx = (screenSize.width);
		int painty = (screenSize.height);
		setBounds( (paintx - 610)/2 , ((painty-100) - 680)/2,
						 610,680);

		c.setLayout(null);
		logoPanel.setLayout(null);
		infoPanel.setLayout(null);
		linkPanel.setLayout(null);

		launchMain();

		info.setLineWrap(true);

		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Links");
        createNodes(top);
        links = new JTree(top);
        links.setOpaque(true);
        links.setBackground(Color.gray);
        linkScroller = new JScrollPane(links);

        links.addTreeSelectionListener(this);

		String dd;
		formatter = new SimpleDateFormat ("MMMMMMMMM dd yyyy", Locale.getDefault());
		currentDate = new java.util.Date();
		dd = formatter.format(currentDate);

		logoLabel.setBounds(0,0,200,200);
		linkScroller.setBounds(0,0,180,400);
		infoScroller.setBounds(0,0,400,600);

		links.setBackground(Color.gray);
		links.setForeground(Color.gray);

		infoPanel.setBackground(Color.gray);

		basePanel.setBackground(Color.gray);

		file.setMnemonic(KeyEvent.VK_F);
		print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		about.setMnemonic(KeyEvent.VK_A);
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.CTRL_MASK));
		exit.setMnemonic(KeyEvent.VK_X);

		exit.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
            {
            	int confirm = JOptionPane.showConfirmDialog(null,
				"Are you sure want to exit?",
				"Exit Application",
				JOptionPane.YES_NO_OPTION);

 				if( confirm == JOptionPane.YES_OPTION )
 				{
 					JOptionPane.showMessageDialog( null,
 					"Thanks for using our System");
 					dispose();
 					System.exit(0);
 				}
            }
        });

		print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         	     printRecord(makeRecord());
            }
        });
		file.add(print);

		file.add(about);
		about.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
            {
            	infoPanel.removeAll();
            	infoPanel.repaint();
            	infoPanel.add(ab);
				infoPanel.validate();

            }
        });

		file.addSeparator();
		file.add(exit);

		help.setMnemonic(KeyEvent.VK_H);
		helpMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
		help.add(helpMenu);
		help.addSeparator();
		help.add(site);
		helpMenu.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
            {
            	infoPanel.removeAll();
            	infoPanel.repaint();
            	launchMain();
				infoPanel.validate();

            }
        });

		site.add(ahfiSite);
		site.add(ahfiFaq);
		site.add(ahfiTs);
		site.add(ahfiFeed);

		menuBar.add(file);
		menuBar.add(help);

		setJMenuBar(menuBar);

		logoPanel.add(logoLabel);
		linkPanel.add(linkScroller);
		infoPanel.add(infoScroller);
		wordings = new JLabel("Welcome to the Heart Disease info Center, Today is: " + dd);
		basePanel.add(wordings);
		basePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		logoPanel.setBounds(0,0,200,200);
		linkPanel.setBounds(0,200,200,400);
		infoPanel.setBounds(200,0,400,600);
		basePanel.setBounds(0,600,600,30);

		c.add(logoPanel);
		c.add(linkPanel);
		c.add(infoPanel);
		c.add(basePanel);
	}


	private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode detail = null;
        DefaultMutableTreeNode sub_detail = null;


        category = new DefaultMutableTreeNode("Patients");
        top.add(category);

        detail = new DefaultMutableTreeNode("Add");
        category.add(detail);

        detail = new DefaultMutableTreeNode("Delete");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Update");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Search");
        category.add(detail);

        category = new DefaultMutableTreeNode("Doctor");
        top.add(category);

        detail = new DefaultMutableTreeNode("Diagonise");
        category.add(detail);
        
        detail = new DefaultMutableTreeNode("Know Symptoms");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Control your risk factors");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Excercise");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Learn lifetime weight control");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Discover new developments");
        category.add(detail);
        
        detail = new DefaultMutableTreeNode("Modify Facts");
        category.add(detail);

        detail = new DefaultMutableTreeNode("Hospitals");
        category.add(detail);

        category = new DefaultMutableTreeNode("Diseases");
        top.add(category);

        detail = new DefaultMutableTreeNode("Aortic Aneurysm");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Angina");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Congenital Heart Disease");
        category.add(detail);

        category = new DefaultMutableTreeNode("Know your Heart");
        detail = new DefaultMutableTreeNode("Info on Heart");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Calculate your angina risk factor");
        category.add(detail);
        top.add(category);
        
        category = new DefaultMutableTreeNode("Basic info");
        detail = new DefaultMutableTreeNode("Patient Guide");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Heart - A Strong Muscle");
        category.add(detail);
        top.add(category);
        
        category = new DefaultMutableTreeNode("Treatments for heart diseases");
        top.add(category);

        detail = new DefaultMutableTreeNode("Treatment for Aortic Aneurysm");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Treatment for Angina");
        category.add(detail);
        detail = new DefaultMutableTreeNode("Treatment for Congenital Heart Disease");
        category.add(detail);

        category = new DefaultMutableTreeNode("Contact us");
        detail = new DefaultMutableTreeNode("Contact us");
        category.add(detail);
        top.add(category);

    }

    public void valueChanged(TreeSelectionEvent e)
    {
    	TreePath[] paths = links.getSelectionPaths();

    	if(paths == null)
    	return;

    	for(int i = 0; i < paths.length; i++)
    	{

    	String s = (String)(((DefaultMutableTreeNode)(paths[i].getPathComponent(2))).getUserObject());

    			if(s.equals("Add")||s.equals("Delete")||s.equals("Update")||s.equals("Search"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		infoPanel.add(p);
					infoPanel.validate();
    			}else
    			if(s.equals("Diagonise"))
    			{
    				runKnow();
    			}else
    			if(s.equals("Congenital Heart Disease"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchCongestive();
					infoPanel.validate();
    			}else
    			if(s.equals("Aortic Aneurysm"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchAortic();
					infoPanel.validate();
    			}else
    			if(s.equals("Angina"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchAngina();
					infoPanel.validate();
    			}else
    			if(s.equals("Modify Facts"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		infoPanel.add(addRules);
					infoPanel.validate();
    			}else
    			if(s.equals("Info on Heart"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchHeart();
					infoPanel.validate();
    			}else
    			if(s.equals("Calculate your angina risk factor"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		infoPanel.add(r_f);
					infoPanel.validate();
    			}else
    			if(s.equals("Contact us"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchContact();
					infoPanel.validate();
    			}else
    			if(s.equals("Patient Guide"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchBasic(1);
					infoPanel.validate();
    			}else
    			if(s.equals("Heart - A Strong Muscle"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchBasic(2);
					infoPanel.validate();
    			}else
    			if(s.equals("Treatment for Aortic Aneurysm"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchTreatment(1);
					infoPanel.validate();
    			}else
    			if(s.equals("Treatment for Angina"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchTreatment(2);
					infoPanel.validate();
    			}else
    			if(s.equals("Treatment for Congenital Heart Disease"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchTreatment(3);
					infoPanel.validate();
    			}else
    			if(s.equals("Know Symptoms"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchLink(1);
					infoPanel.validate();
    			}else
    			if(s.equals("Control your risk factors"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchLink(2);
					infoPanel.validate();
    			}else
    			if(s.equals("Excercise"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchLink(3);
					infoPanel.validate();
    			}else
    			if(s.equals("Learn lifetime weight control"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchLink(4);
					infoPanel.validate();
    			}else
    			if(s.equals("Discover new developments"))
    			{
    				infoPanel.removeAll();
            		infoPanel.repaint();
            		launchLink(5);
					infoPanel.validate();
    			}
    		}
    }

    public String makeRecord()
	{
		String buffer;
		buffer = output.getText();
		return buffer;
	}

    private void printRecord(String s)
	{
		StringReader sr = new StringReader(s);
		LineNumberReader lnr = new LineNumberReader(sr);
		Font typeface = new Font("Monospaced", Font.PLAIN, 12);
		Properties p = new Properties();
		PrintJob pjob = getToolkit().getPrintJob(this, "Print report", p);

		if (pjob != null) {
			Graphics pg = pjob.getGraphics();
			if (pg != null) {
				FontMetrics fm = pg.getFontMetrics(typeface);
				int margin = 20;
				int pageHeight = pjob.getPageDimension().height - margin;
    			int fontHeight = fm.getHeight();
    			int fontDescent = fm.getDescent();
    			int curHeight = margin;

				String nextLine;
				pg.setFont (typeface);

				try
				{
					do
					{
						nextLine = lnr.readLine();
						if (nextLine != null) {
							if ((curHeight + fontHeight) > pageHeight)
							{ // New Page
								pg.dispose();
								pg = pjob.getGraphics();
								curHeight = margin;
							}

							curHeight += fontHeight;

							if (pg != null)
							{
								pg.setFont (typeface);
								pg.drawString (nextLine, margin, curHeight - fontDescent);
							}
						}
					}
					while (nextLine != null);

				}
				catch (EOFException eof)
				{
				}
				catch (Throwable t)
				{
					t.printStackTrace();
				}
			}
			pg.dispose();
		}
		if (pjob != null)
			pjob.end();
	}

	public static void main (String args[])
	{
		System.out.println("ok");
		main m = new main();
		m.setVisible(true);
		m.show();
		splash3.getWindow().dispose();

	}
		
	public void launchMain()
	{
		try
		{
			URL url = null;
			try
			{
				url = getClass().getResource("index.html");
            }
            catch (Exception e)
            {
				System.err.println("Failed to open ");
				url = null;
            }

	            if(url != null)
	            {
	                editor = new JEditorPane(url);
	                editor.setEditable(false);
	                JScrollPane scroller = new JScrollPane(editor);
	                scroller.setBackground(Color.gray);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(0,0,400,600);
			        infoPanel.add(scroller);
			     }

		   }
		   catch (MalformedURLException e)
		   {
		       System.out.println("Malformed URL: " + e);
		   }
		   catch (IOException e)
		   {
		       System.out.println("IOException: " + e);
		   }

		}
		
		public void launchCongestive()
		{
		try
		{
			URL url = null;
			try
			{
				url = getClass().getResource("Congenital heart disease.htm");
            }
            catch (Exception e)
            {
				System.err.println("Failed to open ");
				url = null;
            }

	            if(url != null)
	            {
	                editor = new JEditorPane(url);
	                editor.setEditable(false);
	                JScrollPane scroller = new JScrollPane(editor);
	                scroller.setBackground(Color.gray);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(0,0,400,600);
			        infoPanel.add(scroller);
			     }

		   }
		   catch (MalformedURLException e)
		   {
		       System.out.println("Malformed URL: " + e);
		   }
		   catch (IOException e)
		   {
		       System.out.println("IOException: " + e);
		   }
		}

		public void launchAortic()
		{
		try
		{
			URL url = null;
			try
			{
				url = getClass().getResource("Aortic.htm");
            }
            catch (Exception e)
            {
				System.err.println("Failed to open ");
				url = null;
            }

	            if(url != null)
	            {
	                editor = new JEditorPane(url);
	                editor.setEditable(false);
	                JScrollPane scroller = new JScrollPane(editor);
	                scroller.setBackground(Color.gray);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(0,0,400,600);
			        infoPanel.add(scroller);
			     }

		   }
		   catch (MalformedURLException e)
		   {
		       System.out.println("Malformed URL: " + e);
		   }
		   catch (IOException e)
		   {
		       System.out.println("IOException: " + e);
		   }
		}

		public void launchAngina()
		{
		try
		{
			URL url = null;
			try
			{
				url = getClass().getResource("Angina.html");
            }
            catch (Exception e)
            {
				System.err.println("Failed to open ");
				url = null;
            }

	            if(url != null)
	            {
	                editor = new JEditorPane(url);
	                editor.setEditable(false);
	                JScrollPane scroller = new JScrollPane(editor);
	                scroller.setBackground(Color.gray);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(0,0,400,600);
			        infoPanel.add(scroller);
			     }

		   }
		   catch (MalformedURLException e)
		   {
		       System.out.println("Malformed URL: " + e);
		   }
		   catch (IOException e)
		   {
		       System.out.println("IOException: " + e);
		   }
		}

		public void launchHeart()
		{
		try
		{
			URL url = null;
			try
			{
				url = getClass().getResource("heart.htm");
            }
            catch (Exception e)
            {
				System.err.println("Failed to open ");
				url = null;
            }

	            if(url != null)
	            {
	                editor = new JEditorPane(url);
	                editor.setEditable(false);
	                JScrollPane scroller = new JScrollPane(editor);
	                scroller.setBackground(Color.gray);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(0,0,400,600);
			        infoPanel.add(scroller);
			     }

		   }
		   catch (MalformedURLException e)
		   {
		       System.out.println("Malformed URL: " + e);
		   }
		   catch (IOException e)
		   {
		       System.out.println("IOException: " + e);
		   }
		}

		public void launchContact()
		{
		try
		{
			URL url = null;
			try
			{
				url = getClass().getResource("contact.htm");
            }
            catch (Exception e)
            {
				System.err.println("Failed to open ");
				url = null;
            }

	            if(url != null)
	            {
	                editor = new JEditorPane(url);
	                editor.setEditable(false);
	                JScrollPane scroller = new JScrollPane(editor);
	                scroller.setBackground(Color.gray);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(0,0,400,600);
			        infoPanel.add(scroller);
			     }

		   }
		   catch (MalformedURLException e)
		   {
		       System.out.println("Malformed URL: " + e);
		   }
		   catch (IOException e)
		   {
		       System.out.println("IOException: " + e);
		   }
		}
		
		public void launchLink(int i)
		{
		try
		{
			URL url = null;
			try
			{
				url = getClass().getResource("heartlink"+i+".htm");
            }
            catch (Exception e)
            {
				System.err.println("Failed to open ");
				url = null;
            }

	            if(url != null)
	            {
	                editor = new JEditorPane(url);
	                editor.setEditable(false);
	                JScrollPane scroller = new JScrollPane(editor);
	                scroller.setBackground(Color.gray);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(0,0,400,600);
			        infoPanel.add(scroller);
			     }

		   }
		   catch (MalformedURLException e)
		   {
		       System.out.println("Malformed URL: " + e);
		   }
		   catch (IOException e)
		   {
		       System.out.println("IOException: " + e);
		   }
		}
		
		public void launchBasic(int i)
		{
		try
		{
			URL url = null;
			try
			{
				url = getClass().getResource("basicInfo"+i+".htm");
            }
            catch (Exception e)
            {
				System.err.println("Failed to open ");
				url = null;
            }

	            if(url != null)
	            {
	                editor = new JEditorPane(url);
	                editor.setEditable(false);
	                JScrollPane scroller = new JScrollPane(editor);
	                scroller.setBackground(Color.gray);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(0,0,400,600);
			        infoPanel.add(scroller);
			     }

		   }
		   catch (MalformedURLException e)
		   {
		       System.out.println("Malformed URL: " + e);
		   }
		   catch (IOException e)
		   {
		       System.out.println("IOException: " + e);
		   }
		}
		
		public void launchTreatment(int i)
		{
		try
		{
			URL url = null;
			try
			{
				url = getClass().getResource("treat"+i+".htm");
            }
            catch (Exception e)
            {
				System.err.println("Failed to open ");
				url = null;
            }

	            if(url != null)
	            {
	                editor = new JEditorPane(url);
	                editor.setEditable(false);
	                JScrollPane scroller = new JScrollPane(editor);
	                scroller.setBackground(Color.gray);
	                editor.setBackground(Color.gray);
	                scroller.setBounds(0,0,400,600);
			        infoPanel.add(scroller);
			     }

		   }
		   catch (MalformedURLException e)
		   {
		       System.out.println("Malformed URL: " + e);
		   }
		   catch (IOException e)
		   {
		       System.out.println("IOException: " + e);
		   }
		}

void runKnow()
   {
      long solveTerm, actionTerm, responseTerm, term;
      String id = "none", responseFunctor, responseType, solutions = "", s;
      boolean more = true, oneAnswer;

      try
      {
         // Initialize a new Logic Server
         System.out.print("1");
         ls = new LogicServer();
         ls.Init("");
         System.out.print("2");
         // Load OSUtils
         ls.AddLSX("aosutils", 0);

         // Load ODBC (optional, you can take this out if you don't use it)
         // Alternatively you could call ls.InitLSX() which will load any
         // LSXs specified in amzi.cfg
         ls.AddLSX("aodbc", 0);
          System.out.print("3");
         // Load the Jig
         ls.Load("basic.xpl");
          System.out.print("4");
         // Initialize the runtime with directory and logfile
         // Prior to starting a new KWI session the session id must be kw_init.
         String path = System.getProperty("user.dir") + System.getProperty("file.separator");
                   System.out.print("5");
         id = "kw_init";
                    System.out.print("6");
         // The directory is where the kb file is located
         // The session_directory is where a temporary file is created to maintain the state
         //   of the reasoning process
         // The log_file is a log of the reasoning process and is created in the directory
         // The message level is the level of detail in the log_file
         //Utils utl = new Utils();
         s = "kwi(" + id + ", initialize([directory = $" + Utils.doubleSlashes(path) + "$, " +
                    "session_directory = $" + Utils.doubleSlashes(path) + "$, " +
//                    "message_level = none]), _INFO)";
                    "log_file = $kwrun.log$, message_level = high]), _INFO)";
                              System.out.print("7");
         term = ls.ExecStr(s);
         if (term == 0)
            JOptionPane.showMessageDialog(null, "kwi / initialize failed",
               "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print("8");
         // Get the name, version and build (optional)
         Properties sysInfo = Utils.prologListToProperties(ls, ls.GetArg(term, 3), 5000);
         String engineName = sysInfo.getProperty("system");
         String version = sysInfo.getProperty("version");
//         outputText.setText("System: " + engineName + " Version: " + version);

         // Open the logicbase
         String name = "aiheart.kb";
         //String name = JOptionPane.showInputDialog("Enter name of knowledgebase to open:");
         if (name.length() == 0) return;
         s = "kwi(" + id + ", open($" + name + "$), _)";
         term = ls.ExecStr(s);

         System.out.print(" = " + s + "\n");
        // if (term == 0)
        //System.out.print("109");
         //   JOptionPane.showMessageDialog(null, "kwi / open " + name + " failed",
          //     "Error", JOptionPane.ERROR_MESSAGE);

         // Start a new session
         // Now the id can be anything but kw_init
         id = "session_0";
         if (ls.ExecStr("kwi('" + id + "', new_session, _)") == 0 )
            JOptionPane.showMessageDialog(null, "kwi / new_session failed",
               "Error", JOptionPane.ERROR_MESSAGE);

         // Keep calling kwi / solve until there is nothing else to do

         while((solveTerm = ls.ExecStr("kwi('" + id + "', solve, _MORE)")) != 0)
         {
            // Check if we're done
            if (!ls.GetStrArg(solveTerm, 3).equals("more"))
               more = false;

            // Process all the actions. Actions are either questions to
            // ask the user or information to tell the user.
            do
            {
               // Get the action
               if ((actionTerm = ls.ExecStr("kwi('" + id + "', get_action, _ACTION)")) == 0)
               {
                        System.out.print("12");
                  JOptionPane.showMessageDialog(null, "kwi / get_action",
                     "Error", JOptionPane.ERROR_MESSAGE);
                     return;
               }

               // The third parameter in the kwi call contains the type and
               // parameters of the action to be performed
               // Use the Amzi! Logic Server to retrieve the action
               responseTerm = ls.GetArg(actionTerm, 3);
               responseFunctor = ls.GetFunctor(responseTerm);
               responseType = ls.GetStrArg(responseTerm, 1);

               // Display the HTML question page (we ignore this...used by the web interface)
               if (responseFunctor.equals("ask") && responseType.equals("html"))
               {
                  // Do nothing
               }

               // Get a fact from the user
               if (responseFunctor.equals("ask") && responseType.equals("user"))
               {
                  String factName, prompt, questionType, defaultValue, answerType, delimiter;
                  int length;
                  Vector menu;

                  // The name of the fact we are seeking a value for
                  factName = ls.GetStrArg(responseTerm, 2);

                  // Get all the slots from the question object into a Properties object
                  Properties question = Utils.prologListToProperties(ls, ls.GetArg(responseTerm, 3), 5000);
                  System.out.print("ahil");
                  // Get the prompt
                  prompt = question.getProperty("prompt");

                  // Get the question type
                  questionType = question.getProperty("question_type");

                     // Get all the menu choices into a vector
                     // Note this code will not work if you have a separate display string
                     menu = Utils.prologListToVector(ls, ls.StrToTerm(question.getProperty("choices")), 5000);
                     if (question.getProperty("question_type").equals("menu_multiple_choices"))
                        oneAnswer = false;
                     else
                        oneAnswer = true;

                     // Ask the user
                     AskMenuDialog ask = new AskMenuDialog(this, "Fact: " + factName, prompt, menu, oneAnswer);
                     Point loc = this.getContentPane().getLocationOnScreen();
                     ask.setLocation(loc.x, loc.y);
                     ask.setModal(true);
                     ask.show();

                     // See if the user wants to stop
                     if (ask.getSelectedValue() == null) return;

                     // Assert the new fact or facts (for multiple choices)
                     if (oneAnswer)
                        s = "kwi('" + id + "', assert(fact('" + factName + "', $" + ask.getSelectedValue() + "$)), _)";

                     // Multiple answers need to be asserted as a prolog list which is enclosed in []'s
                     else
                     {
                        // Build the list from the vector returned from AskMenuDialog
                        Vector facts = ask.getSelectedValues();
                        String factList = "";
                        for (int i = 0 ; i < facts.size() ; i++)
                           factList = factList + "$" + facts.elementAt(i) + "$,";
                        s = "kwi('" + id + "', assert(fact('" + factName + "', [" + factList.substring(0,factList.length()-1) + "])), _)";
                     }
                     if (ls.ExecStr(s) == 0)
                        JOptionPane.showMessageDialog(null, "kwi / assert",
                           "Error", JOptionPane.ERROR_MESSAGE);
                  //}
               }

               // Display an answer
               if (responseFunctor.equals("tell") && responseType.equals("user"))
               {
                  // Get the type of the answer
                  String answerType = ls.GetStrArg(responseTerm, 1);

                  // Get all the slots in the answer into a Properties object
                  Properties answer = Utils.prologListToProperties(ls, ls.GetArg(responseTerm, 2), 100000);

                  // Get the name of the answer
                  String answerName = answer.getProperty("goal");

                  // Add new answer onto existing ones
                  String newSolution = answer.getProperty("text");
                  if (newSolution != null)
                  {
                     solutions = solutions + "<P>" + answerName + ": " + newSolution + "</P>";
                     output.setBackground(Color.gray);
                     output.setContentType("text/html");
				     output.getEditorKit().createDefaultDocument();
				     output.setEditable(false);
                     output.setText(solutions);
                     scroller.getViewport().add(output, null);
                     scroller.setBounds(0,0,400,600);
                     infoPanel.removeAll();
            		infoPanel.repaint();
            		infoPanel.add(scroller); 
					infoPanel.validate();
                  }
                  else
                     JOptionPane.showMessageDialog(null, "No text for goal: " + answerName,
                        "Error", JOptionPane.ERROR_MESSAGE);
               }

            }
            while (!responseFunctor.equals("none"));

            if (!more)  break;

         } // while solveTerm

         ls.Close();
      }
      catch (LSException ex)
      {
         ex.printStackTrace();
         //displayKBError(ex, "'" + id + "'");
      }
   }
   
   private static void splash()
	{
		th.start(); // I sleep to let the thread startup and display the window
			while (splash3.getWindow() == null || !splash3.getWindow().isShowing())
			{ 
				try { 
					Thread.sleep(2000);
					} 
				catch (InterruptedException e){} 
			}
			 
	}


}


