import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.util.*;

public class DeleteBook extends JInternalFrame implements ActionListener, FocusListener {

	private JPanel pBook = new JPanel ();
	private JLabel lbBookId, lbBookName, lbBookAuthor;
	private JTextField txtBookId, txtBookName, txtBookAuthor;
	private JButton btnDel, btnCancel;
	
	private Statement st;		//Statement for Getting the Required Table.
	private ResultSet rs;		//For Getting the Records From Table.
	private long id = 0,bisued;		//To Hold the BookId.

	//Constructor of Class.

	public DeleteBook (Connection con) {

		//super (Title, Resizable, Closable, Maximizable, Iconifiable)
		super ("Delete Book", false, true, false, true);
		setSize (325, 250);

		//Setting the Form's Labels.

		lbBookId = new JLabel ("Book Id:");
		lbBookId.setForeground (Color.black);
		lbBookId.setBounds (15, 15, 100, 20);
		lbBookName = new JLabel ("Book Name:");
		lbBookName.setForeground (Color.black);
		lbBookName.setBounds (15, 45, 100, 20);
		lbBookAuthor = new JLabel ("Book Author:");
		lbBookAuthor.setForeground (Color.black);
		lbBookAuthor.setBounds (15, 75, 100, 20);
		
		txtBookId = new JTextField ();
		txtBookId.setHorizontalAlignment (JTextField.RIGHT);
		txtBookId.addFocusListener (this);
		txtBookId.setBounds (120, 15, 175, 25);
		txtBookName = new JTextField ();
		txtBookName.setEnabled (false);
		txtBookName.setBounds (120, 45, 175, 25);
		txtBookAuthor = new JTextField ();
		txtBookAuthor.setEnabled (false);
		txtBookAuthor.setBounds (120, 75, 175, 25);
		
		btnDel = new JButton ("Delete Book");
		btnDel.setBounds (25, 175, 125, 25);
		btnDel.addActionListener (this);
		btnCancel = new JButton ("Cancel");
		btnCancel.setBounds (165, 175, 125, 25);
		btnCancel.addActionListener (this);
		
		txtBookId.addKeyListener (new KeyAdapter () {
			public void keyTyped (KeyEvent ke) {
				char c = ke.getKeyChar ();
				if (! ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
					getToolkit().beep ();
					ke.consume ();
				}
			}
		}
		);
		
		pBook.setLayout (null);
		pBook.add (lbBookId);
		pBook.add (lbBookName);
		pBook.add (lbBookAuthor);
		
		pBook.add (txtBookId);
		pBook.add (txtBookName);
		pBook.add (txtBookAuthor);
		
		pBook.add (btnDel);
		pBook.add (btnCancel);
		
		getContentPane().add (pBook, BorderLayout.CENTER);

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

		if (obj == btnDel) {		//If Delete Button Pressed.

			if (txtBookId.getText().equals ("")) {
				JOptionPane.showMessageDialog (this, "Book's Id not Provided.");
				txtBookId.requestFocus ();
			}
			else if(bisued!=0)
				{
					txtClear();
					JOptionPane.showMessageDialog(this,"Book held by a member");
				}
			else
			{
				
				//Show a Confirmation Dialog to Delete the Record.
			    	int reply = JOptionPane.showConfirmDialog (this, 
				"Are you really want to Delete\nthe " + txtBookName.getText () + " Record?",
				"LibrarySystem - Delete Book", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

				//Check the User Selection.
				if (reply == JOptionPane.YES_OPTION) {		//If User's Choice Yes then.

					try {	//DELETE Query to Delete Record From Table.
						String q = "DELETE FROM Books WHERE BId = " + id + "";
						txtClear ();				//Clering All TextFields.
						JOptionPane.showMessageDialog (this, "Book Deleted.");
						ResultSet rs = st.executeQuery (q);	//Running Query.
					}
					catch (SQLException sqlex) { }
				}
				//If User's Choice No then Do Nothing Return to Program.
				else if (reply == JOptionPane.NO_OPTION) { }
			}

		}		

		if (obj == btnCancel) {		//If Cancel Button Pressed Unload the From.

			setVisible (false);
			dispose();

		}

	}

	//OverRidding the FocusListener Class Function.

	public void focusGained (FocusEvent fe) { }

	public void focusLost (FocusEvent fe) {

		if (txtBookId.getText().equals ("")) {	//If TextField is Empty.
		}
		else {
			id = Integer.parseInt (txtBookId.getText ());	//Converting String to Numeric.
			long bookNo;					//Use for Comparing the Book's Id.
			boolean found = false;				//To Confirm the Book's Id Existance.

			try {	//SELECT Query to Retrieved the Record.
				
				String q = "SELECT * FROM Books WHERE BId = " + id + "";
				ResultSet rs = st.executeQuery (q);	//Executing the Query.
				rs.next ();				//Moving towards the Record.
				bookNo = rs.getLong ("BId");		//Storing the Record.
				bisued=rs.getLong("Mid");
				
				if (bookNo == id) {
					found = true;
					txtBookId.setText ("" + id);
					txtBookName.setText ("" + rs.getString ("BName"));
					txtBookAuthor.setText ("" + rs.getString ("BAuthor"));
					
				}
				else {
					found = false;
				}
			}
			catch (SQLException sqlex) {
				if (found == false) {
					txtClear ();		//Clearing the TextFields.
					JOptionPane.showMessageDialog (this, "Record not Found.");
				}
			}
		}

	}

	//Function Use to Clear All the TextFields of Form.

	private void txtClear () {

		txtBookId.setText ("");
		txtBookName.setText ("");
		txtBookAuthor.setText ("");
		txtBookId.requestFocus();
	}

	
}
	
