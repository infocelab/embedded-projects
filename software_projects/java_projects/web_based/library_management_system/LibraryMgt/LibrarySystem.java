import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class LibrarySystem extends JFrame implements ActionListener
{

	//Main Place on Form where All Child Forms will Shown.

	private JDesktopPane desktop = new JDesktopPane ();

	//For Program's MenuBar.

	private JMenuBar bar;
	private JMenu mnuFile, mnuEdit, mnuOpt, mnuWin, mnuHelp;
	private JMenuItem newBook, newMember, printBook, printMember, printIssueBook, end;	//File Menu Options.
	private	JMenuItem issueBook, returnBook, delBook, delMember, findBook, findMember,memleave;	//Edit Menu Options.
				
	private	JMenuItem change;						//Option Menu Options.
	private JMenuItem makeUser,addBCat,addMCat, close, closeAll;				//Window Menu Options.
	private	JMenuItem keyHelp, about;						//Help Menu Options.
	
	private JPopupMenu popMenu = new JPopupMenu ();
	
	//MenuItems for PopupMenu of the Program.

	private JMenu popadd,popdel,popir,popsea;
	private JMenuItem  book,member, print, issue, bookReturn, find, view,pdelbk,pdelme,findm;

	//For Program's ToolBar.

	private	JToolBar toolBar;

	//For ToolBar's Button.

	private	JButton btnNewBook, btnNewMember, btnIssue, btnReturn, btnPrintIssue, btnDelBook, 
				btnDelMember, btnFindBook, btnFindMember, btnChange, btnHelp, btnKey;

	//Panel For Main Form StatusBar where Program's Name & Welcome Message Display.

	private JPanel statusBar = new JPanel ();
	
	private JLabel lbStatus;	//For Program's Status.
	private JLabel lbWelcome;	//For Welcome Message.

	//Getting the Current System Date.

	private java.util.Date currDate = new java.util.Date ();					//Creating Object.
	private SimpleDateFormat sdf = new SimpleDateFormat ("dd MMMM yyyy", Locale.getDefault());	//Changing Format.
	private String d = sdf.format (currDate);	
	
	private Connection con;		//For Creating the Connection Between Program & Database.
	private Statement st;		//For Getting the Tables From Database.

	private String userName;	//For Getting the Current User's Name.
	
	public LibrarySystem (int type,int user, Connection conn)
	{
		super ("Library Management System.");

		//Setting the Main Window of Program.

		setIconImage (getToolkit().getImage ("Images/Warehouse.png"));	//Setting the Program's Icon.
		setSize (700, 550);						//Setting Main Window Size.

		//Setting the Location of Program on User's Computer Screen By Getting the Screen's Height & Width.

		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getWidth()) / 2,
			(Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);

		//Closing Code of Main Window.

		addWindowListener (new WindowAdapter () {		//Attaching the WindowListener to Program.
			public void windowClosing (WindowEvent we) {	//Overriding the windowClosing Function.
				quitApp ();				//Call the Function to Perform the Closing Action.
			}
		}
		);
		bar = new JMenuBar ();		//Creating the MenuBar Object.
		setJMenuBar (bar);		//Setting Main Window MenuBar.
		
//		Creating the Menus of Program & Assigning the Key too to Open them.

		mnuFile = new JMenu ("File");
		mnuFile.setMnemonic ((int)'E');
		mnuEdit = new JMenu ("Edit");
		mnuEdit.setMnemonic ((int)'E');
		
		mnuOpt = new JMenu ("Options");
		mnuOpt.setMnemonic ((int)'O');
		mnuWin = new JMenu ("Admin");
		mnuWin.setMnemonic ((int)'A');
		mnuHelp = new JMenu ("Help");
		mnuHelp.setMnemonic ((int)'H');
		
//		Creating All the MenuItems of Program.

		//MenuItems for FileMenu.

		newBook = new JMenuItem ("Add New Book");
		newBook.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
		newBook.setMnemonic ((int)'N');
		newBook.addActionListener (this);
		newMember = new JMenuItem ("Add New Member");
		newMember.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.CTRL_MASK));
		newMember.setMnemonic ((int)'M');
		newMember.addActionListener (this);
		end = new JMenuItem ("Quit LibrarySystem ?");
		end.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
		end.setMnemonic ((int)'Q');	
		end.addActionListener (this);

		//MenuItems for EditMenu.

		issueBook = new JMenuItem ("Issue Book");
		issueBook.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
		issueBook.setMnemonic ((int)'I');
		issueBook.addActionListener (this);
		returnBook = new JMenuItem ("Return Book");
		returnBook.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));
		returnBook.setMnemonic ((int)'R');	
		returnBook.addActionListener (this);
		delBook = new JMenuItem ("Delete Book");
		delBook.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
		delBook.setMnemonic ((int)'D');
		delBook.addActionListener (this);
		delMember = new JMenuItem ("Delete Member");
		delMember.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK));
		delMember.setMnemonic ((int)'M');
		delMember.addActionListener (this);
		findBook = new JMenuItem ("Search Book");
		findBook.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK));
		findBook.setMnemonic ((int)'F');
		findBook.addActionListener (this);
		findMember = new JMenuItem ("Search Member");
		findMember.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		findMember.setMnemonic ((int)'S');	
		findMember.addActionListener (this);
		memleave = new JMenuItem("Collect Fines");
		memleave.addActionListener(this);

		//MenuItems for ViewMenu.

		

		//MenuItems for OptionMenu.

		change = new JMenuItem ("Change Background Color");
		change.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
		change.setMnemonic ((int)'C');
		change.addActionListener (this);
	
	makeUser = new JMenuItem ("Create New Clerk");
	makeUser.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
	makeUser.setMnemonic ((int)'N');
	makeUser.addActionListener (this);
	addBCat = new JMenuItem("New Book Category");
	addBCat.addActionListener(this);
	addBCat.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.SHIFT_MASK));
	addMCat = new JMenuItem("New Member Category");
	addMCat.addActionListener(this);
	addMCat.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.SHIFT_MASK));
	close = new JMenuItem ("Close Active Window");
	close.setMnemonic ((int)'C');
	close.addActionListener (this);
	closeAll = new JMenuItem ("Close All Windows...");
	closeAll.setMnemonic ((int)'A');
	closeAll.addActionListener (this);

	//MenuItems for HelpMenu.

	
	keyHelp = new JMenuItem ("Shortcut Keys...");
	keyHelp.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_K, Event.CTRL_MASK));
	keyHelp.setMnemonic ((int)'K');
	keyHelp.addActionListener (this);
	about = new JMenuItem ("About LibrarySystem");
	about.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
	about.setMnemonic ((int)'L');
	about.addActionListener (this);

	//Adding All MenuItems to their Menu.

	//File Menu Items.
	mnuFile.add (newBook);
	mnuFile.add (newMember);
	mnuFile.addSeparator ();
	mnuFile.addSeparator ();
	mnuFile.add (end);

	//Edit Menu Items.
	mnuEdit.add (issueBook);
	mnuEdit.add (returnBook);
	mnuEdit.addSeparator ();
	mnuEdit.add (delBook);
	mnuEdit.add (delMember);
	mnuEdit.addSeparator ();
	mnuEdit.add (findBook);
	mnuEdit.add (findMember);
	mnuEdit.add (memleave);

	

	//Options Menu Items.
	mnuOpt.add (change);
	
	mnuWin.add (makeUser);
	mnuWin.add (addBCat);
	mnuWin.add (addMCat);
	mnuOpt.addSeparator ();
	mnuOpt.add (close);
	mnuOpt.add (closeAll);

	//Help Menu Items.
	

	mnuHelp.add (keyHelp);
	mnuHelp.addSeparator ();
	mnuHelp.add (about);

	//Adding All Menus to MenuBar.

	bar.add (mnuFile);
	bar.add (mnuEdit);
	
	bar.add (mnuOpt);
	bar.add (mnuWin);
	bar.add (mnuHelp);

	popadd=new JMenu("Add..");
	book = new JMenuItem ("Add New Book");
	book.addActionListener (this);
	member = new JMenuItem ("Add New Member");
	member.addActionListener (this);
	popdel=new JMenu("Delete..");
	pdelbk=new JMenuItem("Delete Book");
	pdelbk.addActionListener(this);
	pdelme=new JMenuItem("Delete Member");
	pdelme.addActionListener(this);
	popdel.add(pdelbk);
	popdel.add(pdelme);
	popir=new JMenu("Issue/Return..");
	
	findm=new JMenuItem("Search Member");
	findm.addActionListener(this);

	
	popsea=new JMenu("Search..");
	
	
	
	
	issue = new JMenuItem ("Issue Book");
	issue.addActionListener (this);
	bookReturn = new JMenuItem ("Return Book");
	bookReturn.addActionListener (this);
	popir.add(issue);
	popir.add(bookReturn);
	find = new JMenuItem ("Search Book");
	find.addActionListener (this);
	
	popsea.add(find);
	popsea.add(findm);
	
	//Adding MenuItems to PopupMenu.
	popadd.add(book);
	popadd.add(member);
	
	
	popMenu.add(popadd);
	popMenu.add(popdel);
	popMenu.add(popir);
	
	popMenu.add(popsea);
	
	
	//Following Procedure display the PopupMenu of Program Whenever User Right Click on Program By Mouse.

	addMouseListener (new MouseAdapter () {
		public void mousePressed (MouseEvent me) { checkMouseTrigger (me); }
		public void mouseReleased (MouseEvent me) { checkMouseTrigger (me); }
		private void checkMouseTrigger (MouseEvent me) {
			if (me.isPopupTrigger ())
				popMenu.show (me.getComponent (), me.getX (), me.getY ());
		}
	}
	);
	
	btnNewBook = new JButton (new ImageIcon ("Images/NotePad.gif"));
	btnNewBook.setToolTipText ("Add New Book");
	btnNewBook.addActionListener (this);
	btnNewMember = new JButton (new ImageIcon ("Images/Info.gif"));
	btnNewMember.setToolTipText ("Add New Member");
	btnNewMember.addActionListener (this);
	btnIssue = new JButton (new ImageIcon ("Images/Film.gif"));
	btnIssue.setToolTipText ("Issue Book");
	btnIssue.addActionListener (this);
	btnReturn = new JButton (new ImageIcon ("Images/Backup.gif"));
	btnReturn.setToolTipText ("Return Book");
	btnReturn.addActionListener (this);
	
	
	btnDelBook = new JButton (new ImageIcon ("Images/Recycle.gif"));
	btnDelBook.setToolTipText ("Delete Book");
	btnDelBook.addActionListener (this);
	btnDelMember = new JButton (new ImageIcon ("Images/Basket.gif"));
	btnDelMember.setToolTipText ("Delete Member");
	btnDelMember.addActionListener (this);
	btnFindBook = new JButton (new ImageIcon ("Images/Mirror.gif"));
	btnFindBook.setToolTipText ("Search Book");
	btnFindBook.addActionListener (this);
	btnFindMember = new JButton (new ImageIcon ("Images/Search.gif"));
	btnFindMember.setToolTipText ("Search Member");
	btnFindMember.addActionListener (this);
	
	
	btnKey = new JButton (new ImageIcon ("Images/Keys.gif"));
	btnKey.setToolTipText ("Shortcut Keys of LibrarySystem");
	btnKey.addActionListener (this);

	//Creating the ToolBar of Program.

	toolBar = new JToolBar ();
	toolBar.add (btnNewBook);
	toolBar.add (btnNewMember);
	toolBar.addSeparator ();
	toolBar.add (btnIssue);
	toolBar.add (btnReturn);
	toolBar.addSeparator ();
	
	toolBar.add (btnDelBook);
	toolBar.add (btnDelMember);
	toolBar.addSeparator ();
	toolBar.add (btnFindBook);
	toolBar.add (btnFindMember);
	toolBar.addSeparator ();
	

	toolBar.add (btnKey);
	
	if(type==1)
		userName="Admin";
	else if(type==2)
	{
		userName="Clerk:"+user;
		newBook.setEnabled (false);
		book.setEnabled (false);
		btnNewBook.setEnabled (false);
		newMember.setEnabled (false);
		member.setEnabled (false);
		btnNewMember.setEnabled (false);
		delBook.setEnabled(false);
		btnDelBook.setEnabled(false);
		pdelbk.setEnabled(false);
		delMember.setEnabled(false);
		btnDelMember.setEnabled(false);
		pdelme.setEnabled(false);
		addBCat.setEnabled(false);
		addMCat.setEnabled(false);
		makeUser.setEnabled (false);
	}
	else if(type==3){
		
		userName="Member:"+user;
		newBook.setEnabled (false);
		book.setEnabled (false);
		btnNewBook.setEnabled (false);
		newMember.setEnabled (false);
		member.setEnabled (false);
		btnNewMember.setEnabled (false);
		issueBook.setEnabled (false);
		issue.setEnabled (false);
		btnIssue.setEnabled (false);
		returnBook.setEnabled(false);
		bookReturn.setEnabled(false);
		btnReturn.setEnabled(false);
		delBook.setEnabled(false);
		btnDelBook.setEnabled(false);
		pdelbk.setEnabled(false);
		delMember.setEnabled(false);
		btnDelMember.setEnabled(false);
		pdelme.setEnabled(false);
		addBCat.setEnabled(false);
		addMCat.setEnabled(false);
		makeUser.setEnabled (false);
	}
	
	
	
	lbStatus = new JLabel (" " + "Library Management System.", Label.LEFT);
	lbStatus.setForeground (Color.black);
	lbStatus.setToolTipText ("Program's Title");
	lbWelcome = new JLabel ("Welcome " + userName + " Today is " + d + " ", JLabel.RIGHT);
	lbWelcome.setForeground (Color.black);
	statusBar.setLayout (new BorderLayout());
	statusBar.add (lbStatus, BorderLayout.WEST);
	statusBar.add (lbWelcome, BorderLayout.EAST);

	//Setting the Contents of Programs.

	getContentPane().add (toolBar, BorderLayout.NORTH);
	getContentPane().add (desktop, BorderLayout.CENTER);
	getContentPane().add (statusBar, BorderLayout.SOUTH);

	//Getting the Database.

	con = conn;
	
	setVisible (true);
	
	}	
	
	public void actionPerformed (ActionEvent ae) {
		
		Object obj = ae.getSource();

		if (obj == newBook || obj == book || obj == btnNewBook) {

			
			boolean b = openChildWindow ("Add New Book");
			if (b == false) {
				AddBook adBook = new AddBook (con);
				desktop.add (adBook);			//Adding Child Window to DesktopPane.
				adBook.show ();				//Showing the Child Window.
			}

		}
		else if (obj == newMember || obj == member || obj == btnNewMember) {

			boolean b = openChildWindow ("Add New Member");
			if (b == false) {
				AddMember adMember = new AddMember (con);
				desktop.add (adMember);
				adMember.show ();
				
			} 

		}
		
		else if (obj == end) {

			quitApp ();	//Calling the Function to Quit the Program.

		}
		else if (obj == issueBook || obj == issue || obj == btnIssue) {

			
			boolean b = openChildWindow ("Issue Book");
			if (b == false) {
				IssueBook isBook = new IssueBook (con);
				desktop.add (isBook);
				isBook.show ();
			} 

		}
		else if (obj == returnBook || obj == bookReturn || obj == btnReturn) {

			boolean b = openChildWindow ("Return Book");
			if (b == false) {
				ReturnBook rtBook = new ReturnBook (con);
				desktop.add (rtBook);
				rtBook.show ();
			}
			

		}
		else if (obj == delBook || obj == btnDelBook || obj==pdelbk) {

			boolean b = openChildWindow ("Delete Book");
			if (b == false) {
				DeleteBook dlBook = new DeleteBook (con);
				desktop.add (dlBook);
				dlBook.show ();
			} 

		}
		else if (obj == delMember || obj == btnDelMember|| obj==pdelme) {

			boolean b = openChildWindow ("Delete Member");
			if (b == false) {
				DeleteMember dlMember = new DeleteMember (con);
				desktop.add (dlMember);
				dlMember.show ();
			} 

		}
		else if (obj == findBook || obj == find || obj == btnFindBook) {

			boolean b = openChildWindow ("Search Books");
			if (b == false) {
				SearchBook srBook = new SearchBook (con);
				desktop.add (srBook);
				srBook.show ();
			} 

		}
		else if (obj == findMember || obj == btnFindMember|| obj==findm) {

			boolean b = openChildWindow ("Search Members");
			if (b == false) {
				SearchMember srMember = new SearchMember (con);
				desktop.add (srMember);
				srMember.show ();
			} 

		}
		
		else if (obj == change) {

			Color cl = desktop.getBackground ();	//Getting the Current Background Color.
			//Showing the Color Dialog Box to Change Background Color.
			cl = JColorChooser.showDialog (this, "Choose Background Color", cl);
			if (cl == null) { }			//If No Color is Selected.
			else {
				desktop.setBackground (cl);	//Aplying Selected Color for Background Color.
				desktop.repaint ();		//Repaint the DesktopPane.
			}

		}
		
		else if (obj == makeUser) {

			boolean b = openChildWindow ("Create New Clerk");
			if (b == false) {
				AddClerk mkUser = new AddClerk(con);
				desktop.add (mkUser);
				mkUser.show ();
			} 
		}
		else if (obj == memleave) {

			boolean b = openChildWindow ("Collect Fine");
			if (b == false) {
				ColFine mkUser = new ColFine(con);
				desktop.add (mkUser);
				mkUser.show ();
			} 
		}
		else if(obj == addBCat){
			boolean b = openChildWindow ("New Book Category");
			if (b == false) {
				AddBCat mkCat = new AddBCat(con);
				desktop.add (mkCat);
				mkCat.show ();
			} 
		}
		else if(obj == addMCat){
			boolean b = openChildWindow ("New Member Category");
			if (b == false) {
				AddMCat mkCat = new AddMCat(con);
				desktop.add (mkCat);
				mkCat.show ();
			} 
		}
		else if (obj == close) {

			try {
				desktop.getSelectedFrame().setClosed(true);	//Closing the Active Form.
			}
			catch (Exception CloseExc) { }

		}
		else if (obj == closeAll) {

			JInternalFrame Frames[] = desktop.getAllFrames (); 	//Getting all Open Frames.

			for (int getFrameLoop = 0; getFrameLoop < Frames.length; getFrameLoop++) {
				try {
	 				Frames[getFrameLoop].setClosed (true); 	//Close the Active Frame One By One.
				} 
				catch (Exception CloseExc) { }			//if Error then Do Nothing.
			}

		}
		
		else if (obj == keyHelp || obj == btnKey) {

			
			boolean b = openChildWindow ("LibrarySystem Keys");
			if (b == false) {
				LibraryHelp hlpKey = new LibraryHelp ("LibrarySystem Keys", "Help/Keys.htm");
				desktop.add (hlpKey);
				hlpKey.show ();
			} 

		}
		else if (obj == about) {

			
			String msg = "VarunKumar's LibrarySystem.\n\n" + "Created & Designed By:\n" + 
				"M.Varun Kumar\n\n" + "E-mail me:\n varun.iiitb@gmail.com";
			JOptionPane.showMessageDialog (this, msg, "About LibrarySystem", JOptionPane.PLAIN_MESSAGE);

		}

	}
	
	private boolean openChildWindow (String title) {

		JInternalFrame[] childs = desktop.getAllFrames ();		//Get All Open Child Windows.
		for (int i = 0; i < childs.length; i++) {
			if (childs[i].getTitle().equalsIgnoreCase (title)) {	//Getting the Title of Child Window.
				childs[i].show ();				//Setting Focus on the Child Window.
				return true;
			}
		}
		return false;

	}
	private void quitApp () {

		try {
			//Show a Confirmation Dialog.
		    	int reply = JOptionPane.showConfirmDialog (this, 
				"Do you really want to exit From\n Library Management System?",
				"LibrarySystem - Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			//Check the User Selection.
			if (reply == JOptionPane.YES_OPTION) {				//If User's Choice Yes then.
				setVisible (false);					//Hide the Frame.
				dispose();            					//Free the System Resources.
				System.exit (0);        				//Close the Application.
			}
			else if (reply == JOptionPane.NO_OPTION) {			//If User's Choice No then.
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	//Do Nothing Return to Program.
			}
		} 

		catch (Exception e) {}

	}
	
	
}