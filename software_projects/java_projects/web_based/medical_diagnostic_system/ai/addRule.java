import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import amzi.ls.*;
import java.util.*;

/**
 This program has been solely programmed for an AI project and not meant for any business means.
 If you intend to you the code please do so freely on condition you acknowledge us.
 Created by Group 13 - CyberVision softwares.
 The ODBC datasource name is AI please do not forget to set that before running then program.
 Please do not hesitate to submit any bug to us.
 you can mail us on dh002211@ex.apiit.edu.my

 @author Asrar Ahmed Makrani
 @version 1.4.0 build 3
 */

public class addRule extends JPanel //implements MouseListener
{
	public JLabel title = new JLabel("Modify Facts");
	
	public JLabel rule_id = new JLabel("Fact ID: ");
	public JLabel rule_path = new JLabel("Path: ");
	public JLabel rule_desc = new JLabel("Description: ");
	public JLabel rule = new JLabel("Value: ");
	
	public JTextField rule_id_text = new JTextField(20);
	public JTextField rule_path_text = new JTextField(20);
	public JTextArea rule_desc_text = new JTextArea(0,0);
	public JTextField fact = new JTextField(20);
	
	public LogicServer ls;
	
	public JToolBar toolBar = new JToolBar();
	
	public JButton addRule = null;
	public JButton reset = null;
	
	public addRule()
	{
		setLayout(null);
		setSize(400,600);
		setBackground(Color.gray);
		
		addButtons(toolBar);
		toolBar.setBackground(Color.gray);
		toolBar.setBounds(0,0,150,30);
		toolBar.setBorder(null);
		add(toolBar);
		
		title.setBounds(150, 10, 100,10);
		add(title);
		
		rule_id.setBounds(10,55, 50,10);
		add(rule_id);
		
		rule_id_text.setBounds(100,50, 100,20);
		add(rule_id_text);
		
		rule_path.setBounds(10,80, 50,10);
		add(rule_path);
		
		rule_path_text.setEditable(false);
		rule_path_text.setText("/");
		rule_path_text.setBounds(100,80, 50,20);
		add(rule_path_text);
		
		rule_desc.setBounds(10,115, 80,10);
		add(rule_desc);
		
		JScrollPane scroller = new JScrollPane(rule_desc_text);
		scroller.setBounds(100,110, 200,100);
		rule_desc_text.setLineWrap(true);
		add(scroller);
		
		rule.setBounds(10,255, 50,20);
		add(rule);
		
		fact.setBounds(100,250, 80,20);
		add(fact);		
	}

void addKnow()
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

         //System.out.print(" = " + s + "\n");
         
         // Start a new session
         // Now the id can be anything but kw_init
         id = "session_0";
         if (ls.ExecStr("kwi('" + id + "', new_session, _)") == 0 )
            JOptionPane.showMessageDialog(null, "kwi / new_session failed",
               "Error", JOptionPane.ERROR_MESSAGE);

        String st = "kwi('" + id + "', assert(fact('" + rule_id_text.getText() + "', " + fact.getText() + ")), _)";
        long l = ls.ExecStr(st);
        JOptionPane.showMessageDialog(null, "Fact updated");
      }
      catch (LSException ex)
      {
		System.out.println(ex+"'" + id + "'");
	//         displayKBError(ex, "'" + id + "'");
      }

   }
   
   protected void addButtons(JToolBar toolBar) {
        //first button
        addRule = new JButton(new ImageIcon("save.gif"));
        addRule.setToolTipText("Add");
        addRule.setBackground(Color.gray);
        addRule.setBorder(null);
        addRule.addMouseListener(new MouseListener()
        {
        	public void mousePressed(MouseEvent e) 
	 		{
		    }
		    public void mouseReleased(MouseEvent e) 
		    {
		    }
		    public void mouseEntered(MouseEvent e) 
		    {
		    	addRule.setBorder(BorderFactory.createRaisedBevelBorder());
		    }
		    public void mouseExited(MouseEvent e) 
		    {
		    	addRule.setBorder(null);
		    }
		    public void mouseClicked(MouseEvent e) 
		    {
		    }
        });
        addRule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	addKnow();
            }
        });

        toolBar.add(addRule);
        //second button
        reset = new JButton(new ImageIcon("clear.gif"));
        reset.setToolTipText("Reset");
        reset.setBackground(Color.gray);
        reset.setBorder(null);
        reset.addMouseListener(new MouseListener()
        {
        	public void mousePressed(MouseEvent e) 
	 		{
		    }
		    public void mouseReleased(MouseEvent e) 
		    {
		    }
		    public void mouseEntered(MouseEvent e) 
		    {
		    	reset.setBorder(BorderFactory.createRaisedBevelBorder());
		    }
		    public void mouseExited(MouseEvent e) 
		    {
		    	reset.setBorder(null);
		    }
		    public void mouseClicked(MouseEvent e) 
		    {
		    }
		 });
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	rule_id_text.setText("");
            	rule_desc_text.setText("");
            }
        });
        toolBar.add(reset);
    }
	
}