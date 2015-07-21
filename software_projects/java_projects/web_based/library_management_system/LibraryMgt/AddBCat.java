import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddBCat extends JInternalFrame implements ActionListener {

	private JPanel pNew = new JPanel();
	private JLabel lbUser;
	private JTextField txtUser;
	private JButton btnOk, btnCancel;

	private Statement st;			//Statement for Getting the Required Table.

	//Constructor of Class.

	public AddBCat (Connection con) {

		//super(title, resizable, closable, maximizable, iconifiable)
		super ("New Book Category", false, true, false, true);
		setSize (280, 175);

		//Setting the Form's Labels.

		lbUser = new JLabel ("Category:");
		lbUser.setForeground (Color.black);
		lbUser.setBounds (20, 20, 100, 25);
	       
		//Setting the Form's TextField & PasswordField.

		txtUser = new JTextField ();
		txtUser.setBounds (100, 20, 150, 25);
		
		//Setting the Form's Buttons.

		btnOk = new JButton ("OK");
		btnOk.setBounds (20, 100, 100, 25);
		btnOk.addActionListener (this);
		btnCancel = new JButton ("Cancel");
		btnCancel.setBounds (150, 100, 100, 25);
		btnCancel.addActionListener (this);

		//Setting Panel's Layout.

		pNew.setLayout (null);

		//Adding All the Controls in Panel.

		pNew.add (lbUser);
		
		pNew.add (txtUser);
		
		pNew.add (btnOk);
		pNew.add (btnCancel);

		//Adding Panel to the Form.

		getContentPane().add (pNew);

		try {
			st = con.createStatement ();	//Creating Statement Object.
		}
		catch (SQLException sqlex) {			//If Problem then Show the User a Message.
 			JOptionPane.showMessageDialog (null, "A Problem Occurs While Loading the Form.");
 			dispose ();				//Closing the Form.
	 	}

		setVisible (true);

	}

	public void actionPerformed (ActionEvent ae) {

		Object obj = ae.getSource();

		if (obj == btnOk) {		//If OK Button Pressed.

			

			if (txtUser.getText().equals ("")) {
				txtUser.requestFocus();
				JOptionPane.showMessageDialog (this, "Category not Provided.");
			}
			
			else {
				try {	//INSERT Query to Add Book Record in Table.
					String id= txtUser.getText();
					String q = "SELECT * FROM BCat ";
					ResultSet rs = st.executeQuery (q);	//Executing the Query.
					int fl=0;
					while(rs.next())
					{
						String memberNo = rs.getString ("Cat");	//Storing the Record.
						if(id.equals(memberNo))
						{
							JOptionPane.showMessageDialog(this,"Already existing Category");
							txtUser.setText("");
							txtUser.requestFocus();
							fl=1;
							break;
							
						}
					}
					rs.close();
					if(fl==0){
					q = "INSERT INTO BCat " + 
						"VALUES ('" + txtUser.getText() + "')";

					int result = st.executeUpdate (q);	//Running Query.
					if (result == 1) {			//If Query Successful.
						JOptionPane.showMessageDialog (this, "New Category Created.");
						txtUser.setText ("");
						txtUser.requestFocus ();
					}
					else {					//If Query Failed.
						JOptionPane.showMessageDialog (this, "Problem while Creating. ");
						txtUser.setText ("");
						txtUser.requestFocus ();
					}
					}
				}
				catch (SQLException sqlex) {
					
					JOptionPane.showMessageDialog (this, "Problem while Creating excep.");
				}
			}

		}		

		if (obj == btnCancel) {		//If Cancel Button Pressed Unload the From.

			setVisible (false);
			dispose();

		}

	}


}	