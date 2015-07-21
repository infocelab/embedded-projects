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
public class Up_date_Pass extends JFrame{
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8;
	private JTextField text1,text2,text3,text4,text6;
	private JButton button1,button2,button3,button4,button5;
	private JPanel panel1,panel2,panel3;
	private JComboBox combo1,combo2;
	private DateButton dob;
	String t1,t2,t3,t4,t5,t6,t7;
	Dimension screen 	= 	Toolkit.getDefaultToolkit().getScreenSize();
	public Up_date_Pass (String s1,String s2,String s3,String s4,String s5,String s6,String s7){
		super ("Passenger Details");
		label1=new JLabel("Passenger Number");
		label2=new JLabel("Passenger Name");
		label3=new JLabel("Address");
		label4=new JLabel("Telephone Number");
		label5=new JLabel("Date_of_Travel");
		label6=new JLabel("From");
		label7=new JLabel("To");
		text1=new JTextField(10);
		text2=new JTextField(10);
		text3=new JTextField(10);
		text4=new JTextField(10);
		text6=new JTextField(10);
		dob  =new DateButton();
	    dob.setForeground(Color.red);
		combo1=new JComboBox();
		combo2=new JComboBox();
		setCbx();
		button1=new JButton("UPDATE",new ImageIcon("Icon/i16x16/reset.png"));
		button2=new JButton("SEARCH",new ImageIcon("Icon/i16x16/search.png"));
		button3=new JButton("DELETE",new ImageIcon("Icon/i16x16/delete.png"));
		button4=new JButton("CLEAR",new ImageIcon("Icon/i16x16/exit.png"));
		button5=new JButton("CANCEL",new ImageIcon("Icon/i16x16/exit.png"));
		
		panel1=new JPanel(new GridLayout(7,2));
		panel1.setPreferredSize(new Dimension(350,250));
		panel1.add(label1);panel1.add(text1);
		panel1.add(label2);panel1.add(text2);
		panel1.add(label3);panel1.add(text3);
		panel1.add(label4);panel1.add(text4);
		panel1.add(label5);panel1.add(dob);
		panel1.add(label6);panel1.add(combo1);
		panel1.add(label7);panel1.add(combo2);
		
		
		panel2=new JPanel();
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);
		panel3=new JPanel();
		
		text1.setText(s1);
		text2.setText(s2);
		text3.setText(s3);
		text4.setText(s4);
		dob.setText(s5);
		
		panel3.setPreferredSize(new Dimension(550,400));
		panel3.add(panel1);
		panel3.add(panel2);
		add(panel3);
		setSize(500,350);
		setResizable(false);
		setLocation((screen.width - 500)/2,((screen.height-350)/2));	
		text1.addFocusListener(new FocusAdapter() {
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
               text1.setText("");
             }
           }
         }
       });
       
       text2.addKeyListener(new KeyAdapter() {
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
       
      text4.addFocusListener(new FocusAdapter() {
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
               text4.setText("");
             }
           }
         }
       });
	button1.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
	  if (text1.getText() == null ||
      text1.getText().equals("")){   
      JOptionPane.showMessageDialog(null,"Enter Passenger number","tobiluoch"
      ,JOptionPane.DEFAULT_OPTION);
      text1.requestFocus();
      return;
      }
      if (text2.getText() == null ||
      text2.getText().equals("")){   
      JOptionPane.showMessageDialog(null,"Enter passenger name","tobiluoch",
      JOptionPane.DEFAULT_OPTION);
      text2.requestFocus();
      return;}
      if (text3.getText() == null ||
      text3.getText().equals("")){   
      JOptionPane.showMessageDialog(null,"Address Field is required","tobiluoch",
      JOptionPane.DEFAULT_OPTION);
      text3.requestFocus();
      return;}
      if (text4.getText() == null ||
      text4.getText().equals("")){   
      JOptionPane.showMessageDialog(null,"Enter telephone number","tobiluoch",
      JOptionPane.DEFAULT_OPTION);
      text4.requestFocus();
      return;}
     
				try 
				{
					Statement statement =Connect.getConnection().createStatement();
					{
						 
	                
                     String temp = "UPDATE Passenger SET " +
					"  Pass_Name       ='" + text2.getText()          +
                    "',Address         ='" + text3.getText()          +	
					"',Tel_No          ='" + text4.getText()          +
					"',Date_of_Travel  ='" + dob.getText()          +
					"',Depot           ='" + combo1.getSelectedItem() +
					"',To              ='" + combo2.getSelectedItem() +
					
					"' WHERE Pass_No LIKE'"     + text1.getText()   + "'";
                    int result = statement.executeUpdate( temp );
				     
				      dispose();
					}
				 
				}
				
				 catch ( SQLException sqlex ) {
                      sqlex.printStackTrace();
             }
				
			}
		});
			
	  button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
                     {
                       if ( !text1.equals("") )
                       {

                              Statement statement =Connect.getConnection().createStatement();
                              String query =("SELECT * FROM Passenger where Pass_No ='" + text1.getText() + "'");
                                 
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
	
	button3.addActionListener(new java.awt.event.ActionListener() {
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
                     if (!text1.equals(""))
                        {
						System.out.print(text1.getText());
                              String query =("DELETE  FROM Passenger where Pass_No ='" + text1.getText() + "'");
                                   int result = statement.executeUpdate( query );

                                   if ( result == 0 )
                                 {
                                         JOptionPane.showMessageDialog(null,"Record Deleted",
                                        "DELETION",JOptionPane.DEFAULT_OPTION);
                                 }

                               else

                            {
                               text1.setText("");
                               text2.setText("");
                               text3.setText("");
                               text4.setText("");
                               
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
	 button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1.setText ("");
				text2.setText ("");
				text3.setText ("");
				text4.setText ("");	
			}
		});	
		button5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
  }
	public void display( ResultSet rs )
          {
             try
             { 
               boolean recordNumber = rs.next();
                if ( recordNumber)
                {   
                   t1 = rs.getString(1);
                   t2 =rs.getString(2);
                   t3 = rs.getString(3);
                   t4 = rs.getString(4);
                   t5 = rs.getString(5);
                   t6 = rs.getString(6);
                   t7 = rs.getString(7);
                   
                   
                   text1.setText(t1);
                   text2.setText(t2);
	               text3.setText(t3); 
                   text4.setText(t4);
                   dob.setText(t5);
                   combo1.setSelectedItem(t6);
                   combo2.setSelectedItem(t7); 
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
            
	private void setCbx()
	{
		try
		{
		    ResultSet rst=Connect.getConnection().createStatement(
			ResultSet.TYPE_SCROLL_INSENSITIVE,
			ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT Depot,Destination FROM Route");
			
			while(rst.next())
			{
				combo1.addItem(rst.getString(1)) ;
				combo2.addItem(rst.getString(2)) ;
			    
			}	
		}
		catch(Exception n)
		{
			n.printStackTrace();
		}			
	}	
	public static void main(String[]args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Passenger().setVisible(true);
		
		new Up_date_Pass("", "", "", "","","","").setVisible(false);
	}
	
}