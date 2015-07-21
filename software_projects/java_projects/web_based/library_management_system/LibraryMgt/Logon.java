import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Logon extends JFrame implements ActionListener {

	public Dimension d = Toolkit.getDefaultToolkit().getScreenSize();	
	private int fl=1;
	private JPanel pLog = new JPanel();
	private JLabel lbUser, lbPass;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnOk, btnCancel;
	private JRadioButton rad,rcle,rmem;
	private Connection con;		
	public String user;		
	FrmSplash FormSplash = new FrmSplash();
	Thread ThFormSplash = new Thread(FormSplash);
	public Logon () {

		super ("Library Management System.");
		loadSplashScreen();
		FormSplash.dispose();
		setIconImage (getToolkit().getImage ("Images/Home.gif"));	
		setSize (275, 300);					
		setResizable (false);					

		addWindowListener (new WindowAdapter () {		
			public void windowClosing (WindowEvent we) {
				setVisible (false);			
				dispose();            		
				System.exit (0);        	
			}
		}
		);

		//Setting the Logon Form Position on User's Screen.

		setLocation (d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);

		//Setting the Layout of Panel.

		pLog.setLayout (null);

		//Setting the Form's Radio Button's
		rad=new JRadioButton("Admin");
		rad.setBounds(80,140,100,25);
		rad.addActionListener(this);
		
		rcle=new JRadioButton("Clerk");
		rcle.setBounds(80,170,100,25);
		rcle.addActionListener(this);
		rmem=new JRadioButton("Member");
		rmem.setBounds(80,200,100,25);
		rmem.addActionListener(this);
		rad.setSelected(true);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rad);
		bg.add(rcle);
		bg.add(rmem);
		
		
		//Setting the Form's Labels.

		lbUser = new JLabel ("Username:");
		lbUser.setForeground (Color.black);
		lbUser.setBounds (20, 15, 75, 25);
	    lbPass = new JLabel ("Password:");
		lbPass.setForeground (Color.BLACK);
        lbPass.setBounds (20, 50, 75, 25);

		//Setting the Form's TextField & PasswordField.

		txtUser = new JTextField ();
		txtUser.setBounds (100, 15, 150, 25);
		txtPass = new JPasswordField ();
		txtPass.setBounds (100, 50, 150, 25);

		//Setting the Form's Buttons.

		btnOk = new JButton ("OK");
		btnOk.setBounds (20, 90, 100, 25);
		btnOk.addActionListener (this);
		btnCancel = new JButton ("Cancel");
		btnCancel.setBounds (150, 90, 100, 25);
		btnCancel.addActionListener (this);

		//Adding All the Controls in Panel.
		pLog.add(rad);
		pLog.add(rcle);
		pLog.add(rmem);
		pLog.add (lbUser);
		pLog.add (lbPass);
		pLog.add (txtUser);
		pLog.add (txtPass);
		pLog.add (btnOk);
		pLog.add (btnCancel);

		//Adding Panel to the Form.

		getContentPane().add (pLog);

		//Opening the Database.

		try {
			Class.forName ("sun.jdbc.odbc.JdbcOdbcDriver");
			String loc = "jdbc:odbc:Library";
			con = DriverManager.getConnection (loc);
		}
		catch (ClassNotFoundException cnf)  {
			JOptionPane.showMessageDialog (null, "Driver not Loaded...");
			System.exit (0);
		}
		catch (SQLException sqlex) {
 			JOptionPane.showMessageDialog (null, "Unable to Connect to Database...");
 			System.exit (0);
	 	}

		//Showing The Logon Form.

		setVisible (true);

	}

	public void actionPerformed (ActionEvent ae) {

		Object obj = ae.getSource();

		if (obj == btnOk) {		//If OK Button Pressed.

			String password = new String (txtPass.getPassword());

			if (txtUser.getText().equals ("")) {
				JOptionPane.showMessageDialog (this, "Provide Username to Logon.");
				txtUser.requestFocus();
			}
			else if (password.equals ("")) {
				txtPass.requestFocus();
				JOptionPane.showMessageDialog (null,"Provide Password to Logon.");
			}
			else {
				String pass;			//To Hold the Password.
				
				boolean verify = false;		//To Confirm Logon.
				if(fl==1)
				{
						if(txtUser.getText().equals("Admin")&&password.equals("admin"))
						{
							verify=true;
							//JOptionPane.showMessageDialog(this,"Admin Logged in");
							new LibrarySystem(1,1,con);
							setVisible(false);
							dispose();
						}
				}
				else
				{
					String tablename=null;
					if(fl==2) tablename="Clerks";
					else if(fl==3)tablename="Members";
					
					try {	//SELECT Query to Retrieved the Record.
 					String query = "SELECT * FROM " + tablename + " WHERE id = " + Integer.parseInt(txtUser.getText());

 					Statement st = con.createStatement ();		//Creating Statement Object.
		 			ResultSet rs = st.executeQuery (query);		//Executing the Query.
					rs.next();					//Moving Towards the Record.
 					user = rs.getString ("id");		//Storing UserName.
 					pass = rs.getString ("Password");		//Storing Password.

 					if (txtUser.getText().equals (user) && password.equals (pass)) {//If Found then.
						verify = true;
						new LibrarySystem (fl,Integer.parseInt(txtUser.getText()), con);	//Show Main Form.
						//JOptionPane.showMessageDialog(this,"Correct Information Provided");
						setVisible (false);		//Hide the Form.
						dispose();            		//Free the System Resources.
					}
					else {
						verify = false;
						JOptionPane.showMessageDialog (this, "Incorrect Information Provided.");
						txtUser.setText ("");
						txtPass.setText ("");
						txtUser.requestFocus ();
					}
				}
				catch (Exception sqlex) {
					if (verify == false) {
						JOptionPane.showMessageDialog (this, "Incorrect excep Information Provided.");
						txtUser.setText ("");
						txtPass.setText ("");
						txtUser.requestFocus ();
					}
				}
			}

		}
		}
		else if (obj == btnCancel) {		//If Cancel Button Pressed Unload the From.

			setVisible (false);
			dispose();
			System.exit (0);

		}
		else if(obj==rad)
		{
				fl=1;
		}
		else if(obj==rcle)
		{
				fl=2;
		}
		else if(obj==rmem)
		{
				fl=3;
		}

	}
	public static void main(String args[])
	{
			Logon start=new Logon();
	}
	protected void loadSplashScreen(){
		//Start the thread
		ThFormSplash.start();
		while(!FormSplash.isShowing()){
			try{
				//Display the FormSplash for 10 seconds
				Thread.sleep(1000);
			}catch(InterruptedException e){
			}
		}
 }	
}
class FrmSplash extends JWindow implements Runnable{
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();	
	public void run(){
		JLabel SplashLabel = new JLabel("");
		Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
		
		getContentPane().add(SplashLabel,BorderLayout.CENTER);
		
		setSize(275,300);
		setLocation (d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);
		setVisible(true);
	}
}