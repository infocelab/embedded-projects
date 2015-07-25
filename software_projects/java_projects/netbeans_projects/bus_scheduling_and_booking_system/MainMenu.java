import java.applet.Applet;
import java.awt.*;
import java.text.*;
import java.awt.event.*; 
import javax.swing.*;
import java.lang.StringBuffer;
import java.io.IOException;
import java.io.*;
import java.sql.*; 
import javax.swing.plaf.metal.*; 
public class MainMenu extends JFrame implements WindowListener
{ 
    JPanel Panel1;
	JDesktopPane Desk1 = new JDesktopPane();
	private JLabel welcome;
	JLabel BusinessTitleLabel = new JLabel();
	JLabel header=new JLabel();
	private java.util.Date currDate = new java.util.Date ();
    public JMenu MnuFile,MnuRec,MnuReport;
	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
    private ButtonGroup group = new ButtonGroup ();
	String StrBusinesTitle; 
    private JLabel log; 
	private	static JMenuItem  Booking,Scheduling,Payment,NewUser,
	 Passenger,Buses,Emps,Routes,Busrpt,Emprpt,shedrpt,bookrpt;
	public JButton  NewJButton;
    Connection getConnection;
	Main  buses;
	Employee Emp;
	Author aut;
	Schedule Sched;
	Route Rut;
	PASS pass;
	frmSplash FormSplash = new frmSplash();
	
    ResultSet rsLogin;	
	Thread ThFormSplash = new Thread(FormSplash);
    public MainMenu(){
   	
   	super("tobiluoch softAgencies");
   			
   		try

         {
	
    Statement s = Connect.getConnection().createStatement();
    
      }

     
    catch ( Exception excp )

      {
    excp.printStackTrace();	
	}    
   	
   	
	

	 header=new JLabel(new ImageIcon("Icon/header/logo.png"));
     welcome = new JLabel ("Welcome Today is " + currDate + " ",JLabel.CENTER);
     welcome.setFont(new Font("Dialog", Font.PLAIN, 12));
	 welcome.setForeground(Color.blue);
	 BusinessTitleLabel.setText(StrBusinesTitle);
	 BusinessTitleLabel.setHorizontalAlignment(JLabel.LEFT);
	 BusinessTitleLabel.setForeground(new Color(166,0,0));
     
     addWindowListener(this);

	 Desk1.setBackground(Color.gray);
	 
	 Desk1.setBorder(BorderFactory.createEmptyBorder());
		
	 Desk1.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        
     Panel1 = new JPanel(new BorderLayout());
        
     Panel1.setBackground(Color.gray);
	 Panel1.setBorder(BorderFactory.createLoweredBevelBorder());
     Panel1.add(new JScrollPane(Desk1),BorderLayout.CENTER);
        
	 getContentPane().add(CreateJToolBar(),BorderLayout.PAGE_START);
	 getContentPane().add(Panel1,BorderLayout.CENTER);

     getContentPane().add(welcome,BorderLayout.PAGE_END,JLabel.CENTER);
	 setJMenuBar(CreateJMenuBar());
	 setExtendedState(this.MAXIMIZED_BOTH);

	 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	 setIconImage(new ImageIcon("images/appicon.png").getImage());
	 setLocation(0,0);
	 setSize(screen);
	 

	 setVisible(true);
	 show(); 
		}
     protected JMenuBar CreateJMenuBar(){
	 JMenuBar NewJMenuBar = new JMenuBar();

		
	 MnuFile = new JMenu("Operations");
	 MnuFile.setForeground((Color.blue));
	 MnuFile.setFont(new Font("Dialog", Font.PLAIN, 12));
	 MnuFile.setMnemonic('O');
	 MnuFile.setBackground(new Color(255,255,255));
	 NewJMenuBar.add(MnuFile);
	 MnuFile.setEnabled(false);
	 NewUser = new JMenuItem("AddNew User");
	 NewUser.setForeground(Color.blue);
	 NewUser.setFont(new Font("Dialog", Font.PLAIN, 12));
	 NewUser.setMnemonic('L');
	 NewUser.setIcon(new ImageIcon("images/lockapplication.png"));
	 NewUser.setAccelerator(
					KeyStroke.getKeyStroke(
						KeyEvent.VK_L,ActionEvent.CTRL_MASK
						)
				);
	NewUser.setActionCommand("new");
	NewUser.addActionListener(JMenuActionListener);
	NewUser.setBackground(new Color(255,255,255));
		
	 JMenuItem ItmLockApp = new JMenuItem("Lock Application");
	 ItmLockApp.setForeground(Color.blue);
	 ItmLockApp.setFont(new Font("Dialog", Font.PLAIN, 12));
	 ItmLockApp.setMnemonic('N');
	 ItmLockApp.setIcon(new ImageIcon("images/lockapplication.png"));
	 ItmLockApp.setAccelerator(
					KeyStroke.getKeyStroke(
						KeyEvent.VK_U,ActionEvent.CTRL_MASK
						)
				);
	ItmLockApp.setActionCommand("lockapp");
	ItmLockApp.addActionListener(JMenuActionListener);
	ItmLockApp.setBackground(new Color(255,255,255));
	
	
	JMenuItem ItmExit = new JMenuItem("Exit");
	ItmExit.setForeground(Color.blue);
	ItmExit.setFont(new Font("Dialog", Font.PLAIN, 12));
	ItmExit.setMnemonic('E');
	ItmExit.setIcon(new ImageIcon("images/exit.png"));
	ItmExit.setAccelerator(
					KeyStroke.getKeyStroke(
						KeyEvent.VK_X,ActionEvent.CTRL_MASK
						) 
				);
	ItmExit.setActionCommand("exit");
	ItmExit.addActionListener(JMenuActionListener);
	ItmExit.setBackground(new Color(255,255,255));

    MnuFile.add(NewUser);
	//MnuFile.add(ItmLockApp);
	MnuFile.addSeparator();
	MnuFile.add(ItmExit);
			
	MnuRec = new JMenu("Files");
	MnuRec.setFont(new Font("Dialog", Font.PLAIN, 12));
	MnuRec.setForeground ((Color.blue));
	MnuRec.setMnemonic('F');
	MnuRec.setBackground(new Color(255,255,255));
	NewJMenuBar.add(MnuRec);
		MnuRec.setEnabled(false);
    Buses = new JMenuItem("Buses");
	Buses.setForeground(Color.blue);
	Buses.setEnabled(true);
	Buses.setFont(new Font("Dialog", Font.PLAIN, 12));
	Buses.setMnemonic('B');
    Buses.setIcon(new ImageIcon("images/categories.png"));
	Buses.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_B,ActionEvent.CTRL_MASK
					)
				);
	Buses.setActionCommand("Buses");
	Buses.addActionListener(JMenuActionListener);
	Buses.setBackground(new Color(255,255,255));

	MnuRec.add(Buses); 
			
	Emps = new JMenuItem("Employees");
	Emps.setForeground(Color.blue);
	Emps.setEnabled(true);
	Emps.setFont(new Font("Dialog", Font.PLAIN, 12));
	Emps.setMnemonic('E');
	Emps.setIcon(new ImageIcon("images/categories.png"));
	Emps.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_E,ActionEvent.CTRL_MASK
					)
				);
	Emps.setActionCommand("Emp");
	Emps.addActionListener(JMenuActionListener);
	Emps.setBackground(new Color(255,255,255));

	MnuRec.add(Emps);
    NewJMenuBar.setBackground(new Color(255,255,255));
		    
    Routes = new JMenuItem("Routes");
    Routes.setEnabled(true);
    Routes.setForeground(Color.blue);
    Routes.setFont(new Font("Dialog", Font.PLAIN, 12));
	Routes.setMnemonic('R');		
	Routes.setIcon(new ImageIcon("images/categories.png"));		
	Routes.setAccelerator(		
				KeyStroke.getKeyStroke(
						KeyEvent.VK_R,ActionEvent.CTRL_MASK
					)
				);
	Routes.setActionCommand("rute");
	Routes.addActionListener(JMenuActionListener);
	Routes.setBackground(new Color(255,255,255));		

	MnuRec.add(Routes);
	
	Passenger = new JMenuItem("Passengers");
	Passenger.setForeground(Color.blue);
	Passenger.setEnabled(false);
	Passenger.setFont(new Font("Dialog", Font.PLAIN, 12));
	Passenger.setMnemonic('P');
    Passenger.setIcon(new ImageIcon("images/categories.png"));
	Passenger.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_P,ActionEvent.CTRL_MASK
					)
				);
	Passenger.setActionCommand("pase");
	Passenger.addActionListener(JMenuActionListener);
	Passenger.setBackground(new Color(255,255,255));

	MnuRec.add(Passenger); 
	
    JMenu MnuTrans = new JMenu("Processes ");
	MnuTrans.setFont(new Font("Dialog", Font.PLAIN, 12));
	MnuTrans.setForeground((Color.blue));
	MnuTrans.setMnemonic('P');
	MnuTrans.setBackground(new Color(255,255,255));
	NewJMenuBar.add(MnuTrans);
		
	 Scheduling = new JMenuItem("Scheduling");
	Scheduling.setEnabled(false);
	Scheduling.setForeground(Color.blue);
	Scheduling.setFont(new Font("Dialog", Font.PLAIN, 12));
	Scheduling.setMnemonic('S');
    Scheduling.setIcon(new ImageIcon("images/categories.png"));
	Scheduling.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_S,ActionEvent.CTRL_MASK
					)
				);
	Scheduling.setActionCommand("ched");
	Scheduling.addActionListener(JMenuActionListener);
	Scheduling.setBackground(new Color(255,255,255));

	MnuTrans.add(Scheduling);
    Booking=new JMenuItem("Booking");
	Booking.setEnabled(false);
	Booking.setForeground(Color.blue);
	Booking.setFont(new Font("Dialog",Font.PLAIN,12));
	Booking.setMnemonic('B');
	Booking .setIcon(new ImageIcon("images/categories.png"));
	Booking .setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_K,ActionEvent.CTRL_MASK
				)
				);
    Booking.setActionCommand("buk");
	Booking .addActionListener(JMenuActionListener);
	Booking.setBackground(new Color(255,255,255));

	MnuTrans.add(Booking );
	
	Payment = new JMenuItem("Payments");
	Payment .setForeground(Color.blue);
	Payment.setEnabled(false);
	Payment  .setFont(new Font("Dialog", Font.PLAIN, 12));
	Payment  .setMnemonic('P');
    Payment  .setIcon(new ImageIcon("images/categories.png"));
	Payment  .setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_T,ActionEvent.CTRL_MASK
					) 
				);
	Payment  .setActionCommand("Pay");
	Payment  .addActionListener(JMenuActionListener);
	Payment  .setBackground(new Color(255,255,255));

	MnuTrans.add(Payment);
	/////////////////////////////////////////////////////////////////////////////////
	MnuReport = new JMenu("Reports ");
	MnuReport.setFont(new Font("Dialog", Font.PLAIN, 12));
	MnuReport.setForeground(Color.blue);
	MnuReport.setMnemonic('R');
	MnuReport.setBackground(new Color(255,255,255));
	NewJMenuBar.add(MnuReport);	
	
	Busrpt = new JMenuItem("Bus Report");
	Busrpt .setForeground(Color.blue);
	
	Busrpt  .setFont(new Font("Dialog", Font.PLAIN, 12));
	Busrpt  .setMnemonic('P');
    Busrpt  .setIcon(new ImageIcon("images/categories.png"));
	Busrpt  .setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_Y,ActionEvent.CTRL_MASK
					) 
				);
	Busrpt  .setActionCommand("Busrpt");
	Busrpt  .addActionListener(JMenuActionListener);
	Busrpt  .setBackground(new Color(255,255,255));
    MnuReport.add(Busrpt);
    
    Emprpt = new JMenuItem("Employee Report");
	Emprpt .setForeground(Color.blue);
	//Busrpt .setEnabled(false);
	Emprpt  .setFont(new Font("Dialog", Font.PLAIN, 12));
	Emprpt  .setMnemonic('P');
    Emprpt  .setIcon(new ImageIcon("images/categories.png"));
	Emprpt  .setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_V,ActionEvent.CTRL_MASK
					) 
				);
	Emprpt  .setActionCommand("emprpt");
	Emprpt  .addActionListener(JMenuActionListener);
	Emprpt  .setBackground(new Color(255,255,255));
    MnuReport.add(Emprpt);
    
    shedrpt = new JMenuItem("Scheduling Report");
	shedrpt .setForeground(Color.blue);
	
	shedrpt  .setFont(new Font("Dialog", Font.PLAIN, 12));
	shedrpt  .setMnemonic('S');
    shedrpt  .setIcon(new ImageIcon("images/categories.png"));
	shedrpt  .setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_Q,ActionEvent.CTRL_MASK
					) 
				);
	shedrpt  .setActionCommand("schedrpt");
	shedrpt  .addActionListener(JMenuActionListener);
	shedrpt  .setBackground(new Color(255,255,255));
    MnuReport.add(shedrpt);
    
    bookrpt = new JMenuItem("Booking Report");
	bookrpt .setForeground(Color.blue);
	
	bookrpt  .setFont(new Font("Dialog", Font.PLAIN, 12));
	bookrpt  .setMnemonic('B');
    bookrpt  .setIcon(new ImageIcon("images/categories.png"));
	bookrpt  .setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_Z,ActionEvent.CTRL_MASK
					) 
				);
	bookrpt  .setActionCommand("bukdrpt");
	bookrpt  .addActionListener(JMenuActionListener);
	bookrpt  .setBackground(new Color(255,255,255));
    MnuReport.add(bookrpt);
	////////////////////////////////////////////////////////////////////////////////
	
	JMenu MnuTools = new JMenu("Tools ");
	MnuTools.setFont(new Font("Dialog", Font.PLAIN, 12));
	MnuTools.setForeground(Color.blue);
	MnuTools.setMnemonic('T');
	MnuTools.setBackground(new Color(255,255,255));
	NewJMenuBar.add(MnuTools);
		
	JMenuItem Calculator = new JMenuItem("Calculator");
	Calculator.setForeground(Color.blue);
	Calculator.setFont(new Font("Dialog", Font.PLAIN, 12));
	Calculator.setMnemonic('C');
    Calculator.setIcon(new ImageIcon("icon/i16x16/calc.png"));
	Calculator.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_C,ActionEvent.CTRL_MASK
					)
				);
	Calculator.setActionCommand("calculator");
	Calculator.addActionListener(JMenuActionListener);
	Calculator.setBackground(new Color(255,255,255));

	MnuTools.add(Calculator);
    
    JMenuItem Note = new JMenuItem("EDITOR");
    Note.setForeground(Color.blue);
	Note.setFont(new Font("Dialog", Font.PLAIN, 12));
	Note.setMnemonic('N');
    Note.setIcon(new ImageIcon("icon/i16x16/notepad.png"));
	Note.setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_N,ActionEvent.CTRL_MASK
					)
				);
	Note.setActionCommand("note");
	Note.addActionListener(JMenuActionListener);
	Note.setBackground(new Color(255,255,255));

	MnuTools.add(Note);
    
    JMenu Options=new JMenu ("Change Background");
    Options.setFont(new Font("Dialog",Font.PLAIN,12));
    Options.setForeground(Color.blue);
    Options.setMnemonic('C');
    Options.setBackground(new Color(255,255,255));
	NewJMenuBar.add(Options);
	
	JMenuItem Change = new JMenuItem("Options");
	Change.setForeground(Color.blue);
	Change .setFont(new Font("Dialog", Font.PLAIN, 12));
	Change .setMnemonic('O');
    
	Change .setAccelerator(
				KeyStroke.getKeyStroke(
						KeyEvent.VK_O,ActionEvent.CTRL_MASK
					)
				);
	Change .setActionCommand("change");
	Change .addActionListener(JMenuActionListener);


	Options.add(Change );
    
    
    JMenu MnuHelp = new JMenu("Help ");
	MnuHelp.setFont(new Font("Dialog", Font.PLAIN, 12));
	MnuHelp.setForeground(Color.blue);
	MnuHelp.setMnemonic('H');
	MnuHelp.setBackground(new Color(255,255,255));
	NewJMenuBar.add(MnuHelp);
		
	JMenuItem Authour = new JMenuItem("Author");
	Authour.setForeground(Color.blue);
	Authour .setFont(new Font("Dialog", Font.PLAIN, 12));
	Authour .setMnemonic('A');
    Authour .setIcon(new ImageIcon("icon/i16x16/Author.png"));
	Authour .setAccelerator(
			KeyStroke.getKeyStroke(
			KeyEvent.VK_A,ActionEvent.CTRL_MASK
					)
				);
	Authour .setActionCommand("me");
	Authour .addActionListener(JMenuActionListener);


	//MnuHelp.add(Authour );
	
	JMenuItem man = new JMenuItem("User Manual");
	man.setForeground(Color.blue);
	man .setFont(new Font("Dialog", Font.PLAIN, 12));
	man.setMnemonic('U');
    man .setIcon(new ImageIcon("images/HELPER.png"));
	man .setAccelerator(
				KeyStroke.getKeyStroke(
				KeyEvent.VK_M,ActionEvent.CTRL_MASK
					)
				);
	man .setActionCommand("user");
	man .addActionListener(JMenuActionListener);


	MnuHelp.add(man );
	
    NewJMenuBar.setBackground(new Color(255,255,255));
		    return NewJMenuBar;
		
}
	protected JToolBar CreateJToolBar (){
	JToolBar NewJToolBar = new JToolBar("Toolbar");
	NewJToolBar.setMargin(new Insets(0,0,0,0));	
	NewJToolBar.add(header);
	NewJToolBar.addSeparator();
	NewJToolBar.addSeparator();
	NewJToolBar.addSeparator();
	NewJToolBar.addSeparator();
	NewJToolBar.addSeparator();
	NewJToolBar.addSeparator();
	NewJToolBar.addSeparator();
	return NewJToolBar;
	}		
	protected void buses() throws SQLException{
		
	boolean AlreadyLoaded = isLoaded("Bus Records");
	if(AlreadyLoaded==false){
	buses = new Main();
	Desk1.add(buses);

			
	buses.setVisible(true);
	buses.show();
	try{
	
	}catch(Exception e){
			}
			
	}else{
	try{
				
	}catch(Exception e){
			}
		}
	}
	
	protected void emp() throws SQLException{
		
	boolean AlreadyLoaded = isLoaded("Employee Details");
	if(AlreadyLoaded==false){
	Emp = new Employee();
	Desk1.add(Emp);

			
	Emp.setVisible(true);
	Emp.show();
	try{
			
	}catch(Exception e){
			}
			
	}else{
	try{
				
	}catch(Exception e){
			}
		}
	

	}
	protected void Aut() throws SQLException{
		
	boolean AlreadyLoaded = isLoaded("Employee Details");
	if(AlreadyLoaded==false){
	aut = new Author();
	Desk1.add(aut);

			
	aut.setVisible(true);
	aut.show();
	try{
			
	}catch(Exception e){
			}
			
	}else{
	try{
				
	}catch(Exception e){
			}
		}
	

	}
	protected void rut() throws SQLException{
		
	boolean AlreadyLoaded = isLoaded("fgfg");
	if(AlreadyLoaded==false){
	Rut = new Route();
	Desk1.add(Rut);

			
	Rut.setVisible(true);
	Rut.show();
	try{
			
	}catch(Exception e){
		e.printStackTrace();
			}
			
	}else{
	try{
				
	}catch(Exception e){
		e.printStackTrace();
			}
		}
	

	}
	protected void pase() throws SQLException{
		
	boolean AlreadyLoaded = isLoaded("rute");
	if(AlreadyLoaded==false){
	pass = new PASS();
	Desk1.add(pass);
    
			
	pass.setVisible(true);
	pass.show();
	try{
			
	}catch(Exception e){
		e.printStackTrace();
			}
			
	}else{
	try{
				
	}catch(Exception e){
		e.printStackTrace();
			}
		}
	
 
	}
	protected void Sched() throws SQLException{
		
	boolean AlreadyLoaded = isLoaded("Bus Records");
	if(AlreadyLoaded==false){
	Sched = new Schedule();
	Desk1.add(buses);

			
	Sched.setVisible(true);
	Sched.show();
	try{
	
	}catch(Exception e){
			}
			
	}else{
	try{
				
	}catch(Exception e){
			}
		}
		

	}
	
		ActionListener JMenuActionListener = new ActionListener(){
		
		public void actionPerformed(ActionEvent e) {
			String srcObject = e.getActionCommand();
			if(srcObject=="Buses"){
				try{
					buses();
				     
				
				}catch(Exception sqle){
				}
			} else if(srcObject=="Emp"){
				try{
					emp();
					
					
				}catch(Exception sqle){
				}
				}
				else if(srcObject=="rute"){
				try{
					rut();
					
					 
				}catch(Exception sqle){
				}
			 }
			else if(srcObject=="calculator"){
				try{
				//	runComponents("Calc.exe");
				new MyCalc().setVisible(true);
				}catch(Exception sqle){
				}
			}
			else if(srcObject=="pase"){
				try{
					pase();
				}catch(Exception sqle){
				}
			}
			 else if(srcObject=="note"){ 
				try{
				 //runComponents("Notepad.exe");
				 new editor().setVisible(true);
				}catch(Exception sqle){
				}
			}
			 else if(srcObject=="me"){
                 new Author().setVisible(true); 
                   
            }
              else if(srcObject=="ched"){
                  
			       new Schedule().setVisible(true);
            
			}
			  else if(srcObject=="exit"){
				UnloadWindow();
		
			}
			  else if(srcObject=="user"){
				runURL("manual1/Main.html");
				}
			  else if(srcObject=="buk"){
			 new Booking().setVisible(true);
				}
 			  else if (srcObject=="new"){
				new NewUser().setVisible(true);
			}
		
			 else if (srcObject=="Pay"){
				new Payment().setVisible(true);
			}
			else if (srcObject=="Busrpt"){
				new Bus_Details().setVisible(true);
			}
			else if (srcObject=="emprpt"){
				new employee_report().setVisible(true);
			}
			else if (srcObject=="schedrpt"){//////////////////////////////////
				new Scheduling_report().setVisible(true);
			}
			else if (srcObject=="bukdrpt"){//////////////////////////////////
				new Booking_report().setVisible(true);
			}		
			 else if (srcObject == "change") {

			Color cl = new Color (153, 153, 204);
			cl= JColorChooser.showDialog (null, "Choose Background Color", cl);
			if (cl == null) { }
			 else {
				Desk1.setBackground (cl);
				Desk1.repaint ();
			}

		}
		}
	};	

	public void windowOpened(WindowEvent e){
	}
	public void windowClosing(WindowEvent e){
		UnloadWindow();
	}
	public void windowClosed(WindowEvent e){
	}
	public void windowIconified(WindowEvent e){
	}
	public void windowDeiconified(WindowEvent e){
	}
	public void windowActivated(WindowEvent e){
	}
	public void windowDeactivated(WindowEvent e){
	}
	
	protected void UnloadWindow(){
		String ObjButtons[] = {"Yes","No"};
		int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?",
		"tobiluoch",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		if(PromptResult==0){
			System.out.println(
				"\n\n" +
				"EVERY TIME YOU RUN THIS SYSTEM TRY TO SPOT AN ERROR AND SUGESST\n"+
				" ------------------------------------------------------------\n\n" +
				"THE WAY IT SHOULD BE DONE,I WILL REALLY APPRECIATE YOUR EFFORT EVEN\n"+
				" ------------------------------------------------------------\n\n" +
				"IF YOU TELL ME TO DELETE A CERTAIN LINE OF CODE.GOOD LUCK\n\n" +
				" ------------------------------------------------------------\n\n" +
				" THANKS FOR USING THIS SYSTEM \n\n" +
				" ------------------------------------------------------------\n\n" +
				" AUTHOR: TOBIAS OGALLO\n" +
				" ADDRESS: 6046,KISUMU\n" +
				" E-MAIL:tobi2006@gmail.com\n" +
				" CONTACT NO: 0720233259\n\n" +
				" ------------------------------------------------------------\n" +
				" ------------------------------------------------------------\n" +
				"\n\n"
				);
			System.exit(0);
				 
		}
	}
protected boolean isLoaded(String FormTitle) {

		JInternalFrame Form[] = Desk1.getAllFrames();
		for (int i = 0; i < Form.length; i++) {
			if (Form[i].getTitle().equalsIgnoreCase (FormTitle)) {
				Form[i].show ();
				try{
					Form[i].setIcon(true);
					Form[i].setSelected(true);
				}catch(Exception e){
				}
				return true;
			}
		}
		return false;

	}

  public static void main(String[] args)
	{JFrame.setDefaultLookAndFeelDecorated(true);
		new MainMenu().setVisible(true);
		
	}

  protected void runComponents(String sComponents)
	{
		Runtime rt = Runtime.getRuntime();
		try{rt.exec(sComponents);}
		catch(IOException evt){JOptionPane.showMessageDialog(null,evt.getMessage(),"Error Found",JOptionPane.ERROR_MESSAGE);}
	}

	protected void runURL(String sURL)
	{		
		try{Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + sURL);}
		catch(Exception ex){}
	}		
	
	public  void loginvalidity(){
		MnuFile.setEnabled(true);
		MnuRec.setEnabled(true);
		Booking.setEnabled(true);
		Scheduling.setEnabled(true);
		Payment.setEnabled(true);
		Routes.setEnabled(true);
		Emps.setEnabled(true);
		Buses.setEnabled(true);
		Passenger.setEnabled(true);
		
	}
	public  void loginvalidity2(){
		MnuRec.setEnabled(true);
		Scheduling.setEnabled(true);
		Payment.setEnabled(true);
		Routes.setEnabled(true);
		Emps.setEnabled(true);
		Buses.setEnabled(true);
		
	}
		public  void loginvalidity3(){
		Booking.setEnabled(true);
		Payment.setEnabled(true);
		MnuRec.setEnabled(true);
		Passenger.setEnabled(true);
		
	}		
	}