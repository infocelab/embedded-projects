import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

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

public class patients extends JPanel
{
	
	public JLabel id = new JLabel("Patient ID:");
	public JLabel name = new JLabel("Name:");
	public JLabel sex = new JLabel("Sex:");
	public JLabel age = new JLabel("Age:");
	public JLabel contact = new JLabel("Contact:");
	public JLabel history = new JLabel("History:");
	
	public JTextField id_text = new JTextField(20);
	public JTextField name_text = new JTextField(20);
	public JTextField age_text = new JTextField(20);
	
	public JTextArea history_text = new JTextArea(0,0);
	public JTextArea contact_text = new JTextArea(0,0);
	
	public JScrollPane history_scroller = new JScrollPane(history_text);
	public JScrollPane contact_scroller = new JScrollPane(contact_text);
	
	public String age_string[] = {"0-10", "11-20", "21-30", "31-40", "40 and above"};
	public String sex_string[] = {"Male", "Female"};
	
	public JComboBox age_combo = new JComboBox(age_string);
	public JComboBox sex_combo = new JComboBox(sex_string);
	
	public JToolBar toolBar = new JToolBar();
	
	public JButton button1 = null;
	public JButton button2 = null;
	public JButton button3 = null;
	public JButton button4 = null;
	
	public Connection con;
	
	
	public patients() {
		//create a connection
		String url = "jdbc:odbc:AI";
		
		//Load the driver to allow connection to the database
		try {
 			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 			con = DriverManager.getConnection(url);
 		}
 		catch(ClassNotFoundException cnfex)  {
 			System.err.println("Failed to load driver");
 			cnfex.printStackTrace();
 			System.exit(1);
 		}
 		catch(SQLException sqlex){
 			System.err.println("unable to connect");
 			sqlex.printStackTrace();
 		}
		
		this.setLayout(null);
		setSize(400,600);
		setBackground(Color.gray);
		
		toolBar.setBorder(null);
		addButtons(toolBar);
		
		toolBar.setBackground(Color.gray);
		
		toolBar.setBounds(0,0,150,30);
		this.add(toolBar);
		
		
		id.setBounds(10,50,80,30);
		id_text.setBounds(80,55,50,20);
		this.add(id);
		this.add(id_text);
		id_text.setText("P-");
		
		id_text.addFocusListener(new MyActionListener()
  		{
			public void focusLost(FocusEvent e)
			{
				try
				{
					Statement statement = con.createStatement();
					String query = "SELECT * FROM patient " + 
 								"WHERE patient_id = '" + 
 								id_text.getText() +"'";
					
					ResultSet rs1 = statement.executeQuery(query);
					try
					{
						rs1.next();
						name_text.setText(rs1.getString("name"));
						sex_combo.setSelectedItem(rs1.getString("sex"));
						age_combo.setSelectedItem(rs1.getString("age"));
						contact_text.setText(rs1.getString("contact"));
						history_text.setText(rs1.getString("history"));
					}
					catch(SQLException sqlex)
					{
					}
				}
				catch(SQLException sqlex)
				{
				} 
			}
		});
		
		name.setBounds(10,80,80,30);
		name_text.setBounds(80,85,200,20);
		this.add(name);
		this.add(name_text);
		
		sex.setBounds(10,110,80,30);
		sex_combo.setBounds(80,115,100,20);
		sex_combo.setBackground(Color.gray);
		this.add(sex);
		this.add(sex_combo);
		
		age.setBounds(10,140,80,30);
		age_combo.setBounds(80,145,100,20);
		age_combo.setBackground(Color.gray);
		this.add(age);
		this.add(age_combo);
		
		contact.setBounds(10,170,80,30);
		contact_scroller.setBounds(80,175,200,150);
		contact_text.setLineWrap(true);
		this.add(contact);
		this.add(contact_scroller);
		
		history.setBounds(10,330,80,30);
		history_scroller.setBounds(80,335,300,250);
		history_text.setLineWrap(true);
		this.add(history);
		this.add(history_scroller);
		
		}
		
		
		//add the toolBar
	protected void addButtons(JToolBar toolBar) {
        //first button
        button1 = new JButton(new ImageIcon("new.gif"));
        button1.setToolTipText("New");
        button1.setBackground(Color.gray);
        button1.setBorder(null);
        button1.addMouseListener(new MouseListener()
        {
        	public void mousePressed(MouseEvent e) 
	 		{
		    }
		    public void mouseReleased(MouseEvent e) 
		    {
		    }
		    public void mouseEntered(MouseEvent e) 
		    {
		    	button1.setBorder(BorderFactory.createRaisedBevelBorder());
		    }
		    public void mouseExited(MouseEvent e) 
		    {
		    	button1.setBorder(null);
		    }
		    public void mouseClicked(MouseEvent e) 
		    {
		    }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	id_text.setText("P-");
            	name_text.setText("");
            	contact_text.setText("");
            	history_text.setText("");
            }
        });

        toolBar.add(button1);
        //second button
        button2 = new JButton(new ImageIcon("save.gif"));
        button2.setToolTipText("Save");
        button2.setBackground(Color.gray);
        button2.setBorder(null);
        button2.addMouseListener(new MouseListener()
        {
        	public void mousePressed(MouseEvent e) 
	 		{
		    }
		    public void mouseReleased(MouseEvent e) 
		    {
		    }
		    public void mouseEntered(MouseEvent e) 
		    {
		    	button2.setBorder(BorderFactory.createRaisedBevelBorder());
		    }
		    public void mouseExited(MouseEvent e) 
		    {
		    	button2.setBorder(null);
		    }
		    public void mouseClicked(MouseEvent e) 
		    {
		    }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String sexy = (sex_combo.getSelectedItem()).toString();
            	String agy = (age_combo.getSelectedItem()).toString();
            	patientSQL psql = new patientSQL(
            		id_text.getText(),
            		name_text.getText(),
            		sexy,
            		agy,
            		contact_text.getText(),
            		history_text.getText());
            		psql.add();
            		id_text.setText("P-");
	            	name_text.setText("");
	            	contact_text.setText("");
	            	history_text.setText("");
            }
        });
        toolBar.add(button2);
		
		//forth button
        button3 = new JButton(new ImageIcon("clear.gif"));
        button3.setToolTipText("Update");
        button3.setBackground(Color.gray);
        button3.setBorder(null);
        button3.addMouseListener(new MouseListener()
        {
        	public void mousePressed(MouseEvent e) 
	 		{
		    }
		    public void mouseReleased(MouseEvent e) 
		    {
		    }
		    public void mouseEntered(MouseEvent e) 
		    {
		    	button3.setBorder(BorderFactory.createRaisedBevelBorder());
		    }
		    public void mouseExited(MouseEvent e) 
		    {
		    	button3.setBorder(null);
		    }
		    public void mouseClicked(MouseEvent e) 
		    {
		    }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String sexy = (sex_combo.getSelectedItem()).toString();
            	String agy = (age_combo.getSelectedItem()).toString();
            	patientSQL psql = new patientSQL(
            		id_text.getText(),
            		name_text.getText(),
            		sexy,
            		agy,
            		contact_text.getText(),
            		history_text.getText());
            		
            		psql.update();
            		
            		id_text.setText("P-");
	            	name_text.setText("");
	            	contact_text.setText("");
	            	history_text.setText("");
            }
        });
        toolBar.add(button3);
		
         //forth button
        button4 = new JButton(new ImageIcon("delete.gif"));
        button4.setToolTipText("Delete");
        button4.setBackground(Color.gray);
        button4.setBorder(null);
        button4.addMouseListener(new MouseListener()
        {
        	public void mousePressed(MouseEvent e) 
	 		{
		    }
		    public void mouseReleased(MouseEvent e) 
		    {
		    }
		    public void mouseEntered(MouseEvent e) 
		    {
		    	button4.setBorder(BorderFactory.createRaisedBevelBorder());
		    }
		    public void mouseExited(MouseEvent e) 
		    {
		    	button4.setBorder(null);
		    }
		    public void mouseClicked(MouseEvent e) 
		    {
		    }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String sexy = (sex_combo.getSelectedItem()).toString();
            	String agy = (age_combo.getSelectedItem()).toString();
            	patientSQL psql = new patientSQL(
            		id_text.getText(),
            		name_text.getText(),
            		sexy,
            		agy,
            		contact_text.getText(),
            		history_text.getText());
            		
            		psql.delete();
            		
            		id_text.setText("P-");
	            	name_text.setText("");
	            	contact_text.setText("");
	            	history_text.setText("");
            }
        });
        toolBar.add(button4);
    }
		
} 