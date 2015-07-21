
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.applet.Applet;
import javax.swing.*;
import java.lang.StringBuffer;
import java.io.IOException;
import java.io.*;
import java.sql.*;  
public class UpdateEntry extends javax.swing.JFrame {
	
private JLabel BusNo,RegNo,Model,Capacity,DP,Ins,DI,DE;
private JTextField txtBusNo,txtRegNo,txtModel,txtCapacity,txtIns;
	
	private JButton Update,Search,Load,Clear,Delete;
	
	String busNo, regNo,model, capacity, db,is,ie,id;
	private JButton jButton2;
	private JPanel jPanel1;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private JPanel jPanel5;
	private DateButton date_bought;
    private DateButton date_ins;
    private DateButton date_expiry;
    private static JTextArea txtInfo=new JTextArea( 15, 40 );
	private Connection dbconn;
	private static String info;
	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
	
	public UpdateEntry(String regNo,String busNo,  String model, String capacity,
	    
	    String db,String is,String ie,String id){
		super("Update Bus Details");

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		setResizable(true);

		BusNo = new JLabel("Bus Number ");
		RegNo = new JLabel("Reg Number ");
		Model = new JLabel("Model.: ");
		Capacity = new JLabel("Capacity ");
        DP = new JLabel("Date Purchased");
        Ins = new JLabel("Insurance Status");
        DI = new JLabel("Date Insured");
        DE = new JLabel("Insurance Expiry Date");
		
		txtBusNo = new JTextField(10);
		txtRegNo = new JTextField(10);
		txtModel = new JTextField(10);
		txtCapacity = new JTextField(10);
       
        txtIns = new JTextField(10);
       
       
		date_bought  =new DateButton();
		date_ins     =new DateButton();
		date_expiry  =new DateButton();
		
		txtBusNo.setText(busNo);
		txtRegNo.setText(regNo);
		txtModel.setText(model);
		txtCapacity.setText(capacity);
        date_bought.setText(db);
        
        txtIns.setText(is);
        date_ins .setText(ie);
        date_expiry.setText(id);
		
		date_ins.setForeground(Color.red);
	    date_bought.setForeground(Color.red);
	    date_expiry.setForeground(Color.red);
	    
		Update = new JButton("Update",new ImageIcon("Icon/i16x16/reset.png"));
		Search=new JButton ("Search",new ImageIcon("Icon/i16x16/search.png"));
		Clear=new JButton ("Clear",new ImageIcon("Icon/i16x16/exit.png"));
		Delete=new JButton("Delete",new ImageIcon("Icon/i16x16/delete.png"));
	    jButton2 = new JButton("Cancel",new ImageIcon("Icon/i16x16/exit.png"));
        
		jPanel1 = new JPanel(new java.awt.GridLayout(8,2));
         jPanel1.setPreferredSize(new Dimension (400,250));
		jPanel1.add(BusNo);jPanel1.add(txtBusNo);
		jPanel1.add(RegNo);jPanel1.add(txtRegNo);
		jPanel1.add(Model);jPanel1.add(txtModel);
		jPanel1.add(Capacity);jPanel1.add(txtCapacity);
        jPanel1.add(DP);jPanel1.add(date_bought);
        jPanel1.add(Ins);jPanel1.add(txtIns);
        jPanel1.add(DI);jPanel1.add(date_ins );
        jPanel1.add(DE);jPanel1.add(date_expiry);
		

		jPanel3 = new javax.swing.JPanel(new java.awt.FlowLayout());

		jPanel3.add(jPanel1);
	

		jPanel4 = new javax.swing.JPanel(new java.awt.FlowLayout());
        
		jPanel4.add(Update);
		jPanel4.add(jButton2);
		jPanel4.add(Search);
		jPanel4.add(Delete);
		jPanel4.add(Clear);		 
		setLocation((screen.width - 500)/2,((screen.height-350)/2));	
		setResizable(false);
		txtModel.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isLetter(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c==KeyEvent.VK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
             
             getToolkit().beep();
             JOptionPane.showMessageDialog(null,"This Field Only acept text","tobiluoch",
             JOptionPane.DEFAULT_OPTION);
             e.consume();
           }
         }
       });
       txtIns.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
           char c = e.getKeyChar();
           if (!(Character.isLetter(c) ||
              (c == KeyEvent.VK_BACK_SPACE) ||
              (c==KeyEvent.VK_SPACE) ||
              (c == KeyEvent.VK_DELETE))) {
             
             getToolkit().beep();
             JOptionPane.showMessageDialog(null,"This Field Only acept text","tobiluoch",
             JOptionPane.DEFAULT_OPTION);
             e.consume();
           }
         }
       });
       
       txtCapacity.addFocusListener(new FocusAdapter() {
         public void focusLost(FocusEvent e) {
           JTextField textField =
             (JTextField)e.getSource();
           String content = textField.getText();
           if (content.length() != 0) {
             try {
               Integer.parseInt(content);
             } catch (NumberFormatException nfe) {
               getToolkit().beep();
               JOptionPane.showMessageDialog(null,"Invalid data entry","tobiluoch",
               JOptionPane.DEFAULT_OPTION);
               textField.requestFocus();
               txtCapacity.setText("");
             }
           }
         }
       });
      
		try

         {
	
                Statement s = Connect.getConnection().createStatement();
      }

     
      catch ( Exception excp )

      {
            excp.printStackTrace();
            info=info+excp.toString();
      
		
	}    
	      
                 
	Update.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	  if (txtBusNo.getText() == null ||
      txtBusNo.getText().equals("")){   
      JOptionPane.showMessageDialog(null,"Error?? BusNo can't be null","tobiluoch"
      ,JOptionPane.DEFAULT_OPTION);
      txtBusNo.requestFocus();
      return;
      }
      if (txtRegNo.getText() == null ||
      txtRegNo.getText().equals("")){   
      JOptionPane.showMessageDialog(null,"Error?? RegNo can't be null","tobiluoch",
      JOptionPane.DEFAULT_OPTION);
      txtRegNo.requestFocus();
      return;}
      if (txtModel.getText() == null ||
      txtModel.getText().equals("")){   
      JOptionPane.showMessageDialog(null,"Error?? Model Field is required","tobiluoch",
      JOptionPane.DEFAULT_OPTION);
      txtModel.requestFocus();
      return;}
      if (txtCapacity.getText() == null ||
      txtCapacity.getText().equals("")){   
      JOptionPane.showMessageDialog(null,"Error?? Enter bus capacity","tobiluoch",
      JOptionPane.DEFAULT_OPTION);
      txtCapacity.requestFocus();
      return;}
      
      if (txtIns.getText() == null ||
      txtIns.getText().equals("")){   
      JOptionPane.showMessageDialog(null,"Error?? Insurance status entry is required",
      "tobiluoch",JOptionPane.DEFAULT_OPTION);
      txtIns.requestFocus();
      return;}
      
      
				try 
				{
					Statement statement =Connect.getConnection().createStatement();
					{
						
	                
                    String temp = "UPDATE Buses SET " +
					"  Model              ='" + txtModel.getText()      +
                    "',Capacity           ='" + txtCapacity.getText()   +
					
					"',DateBought         ='" + date_bought.getText()   +
					"',Insurance_Status   ='" + txtIns.getText()        +
					"',Date_Insured       ='" + date_ins.getText()      +
					"',Insurance_Expiry   ='" + date_expiry.getText()   +
					
					"' WHERE BusNo LIKE'"     + txtBusNo.getText() + "'";
                    int result = statement.executeUpdate( temp );
				     
				      dispose();
					}
				 
				}
				
				 catch ( SQLException sqlex ) {
                      sqlex.printStackTrace();
             }
				
			}
		});

		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		
		
  Delete.addActionListener(new java.awt.event.ActionListener() {
	public void actionPerformed(java.awt.event.ActionEvent e) {
	int DResult = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete Record?");

	if (DResult == JOptionPane.NO_OPTION) {
	   JOptionPane.showMessageDialog(null,"Deletion Cancel",
       "DELETION",JOptionPane.DEFAULT_OPTION);
	} 		 
	
	 if (DResult == JOptionPane.YES_OPTION)
         {            
              try
              {
                    Statement statement =Connect.getConnection().createStatement();
                     if (!txtBusNo.equals(""))
                        {
						System.out.print(txtBusNo.getText());
                                     String query =("DELETE  FROM Buses where BusNo ='" + txtBusNo.getText() + "'");
                                   int result = statement.executeUpdate( query );

                                   if ( result == 0 )
                                 {
                                         JOptionPane.showMessageDialog(null,"Record Deleted",
                                        "DELETION",JOptionPane.DEFAULT_OPTION);
                               }

                               else

                            {
                               txtInfo.append( "\nDeletion failed\n" );
                               txtBusNo.setText( "" );
                               txtRegNo.setText( "" );
                               txtModel.setText("");
                               txtCapacity.setText( "" );

				               txtIns.setText ("");
				               


                             }
                             statement.close();
                      }

                        
            }

             catch ( SQLException sqlex )

             {
                     sqlex.printStackTrace(); 
             }
          }
			}
		});
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBusNo.setText ("");
				txtRegNo.setText ("");
				txtModel.setText ("");
				txtCapacity.setText ("");

				txtIns.setText ("");

				
			}
		});	
	 Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
                     {
                       if ( !txtBusNo.equals("") )
                       {

                              Statement statement =Connect.getConnection().createStatement();
                              String query =("SELECT * FROM Buses where BusNo ='" + txtBusNo.getText() + "'");
                                 
                                 ResultSet rs = statement.executeQuery( query );
                                    display ( rs );
                                 statement.close();
                        }    
                     }

                     catch ( SQLException sqlex )

                     {
                             sqlex.printStackTrace();
                     }
				
				
				
				setVisible(true);
				
			}
		});
	

		jPanel5 = new javax.swing.JPanel(new java.awt.BorderLayout());

		jPanel5.add(jPanel3, BorderLayout.CENTER);
		jPanel5.add(jPanel4, BorderLayout.SOUTH);

		getContentPane().add(jPanel5);

		pack();
		setVisible(true);
	}
	
	public void display( ResultSet rs )
          {
             try
             {
                //rs.next();
                
               boolean recordNumber = rs.next();
                if ( recordNumber)
                {  regNo = rs.getString(1);
                  
                   busNo=rs.getString(2);
                   
                   model = rs.getString(3);
                   capacity = rs.getString(4);
                   db = rs.getString(5);
                   
                   is = rs.getString(6);
                   ie= rs.getString(7);
                   id = rs.getString(8);
                   
                   txtBusNo.setText(busNo);
                   txtRegNo.setText(regNo);
	               txtModel.setText(model); 
                   txtCapacity.setText(capacity);
                   date_bought.setText(db);
                   txtIns.setText(is);
                   date_ins .setText(ie);
                   date_expiry.setText(id);
                }

                else
                   {
                         JOptionPane.showMessageDialog(null,"Record Not found","ERROR",
                         JOptionPane.DEFAULT_OPTION);        
                   }
               }
                catch ( SQLException sqlex )

                {   
                sqlex.printStackTrace();
               
               }

            }
            
         
	public static void main(String args[]) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new LoginScreen().setVisible(true);

		new UpdateEntry("", "", "", "","","","","").setVisible(false);
	}
}