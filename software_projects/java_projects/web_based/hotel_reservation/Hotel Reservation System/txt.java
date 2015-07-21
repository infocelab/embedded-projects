import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;


public class txt extends JPanel implements ActionListener
			{   
				Timer th=new Timer(100,this);
				TextArea tx;
				String stxt; int i=0;
				public txt()
					{   
						tx=new TextArea(4,52);
						tx.setEditable(false);
						tx.setFont(new Font("",Font.BOLD,14));
						Box box=Box.createVerticalBox();
						Box box2=Box.createHorizontalBox();
						JLabel l1=new JLabel("SYSTEM  MESSAGE");l1.setForeground(Color.BLUE);
						l1.repaint();
						l1.setFont(new Font("",Font.BOLD,14));
						box.add(new JLabel("              SYSTEM \n MESSAGE"));JLabel r=new JLabel();
						r.setIcon(new ImageIcon("res\\r.gif"));
						box.add(r);
						box2.add(box);box2.add(tx);
						add(box2);
						
					
						printme("Welcome to Bonair's Inn \nHotel Reservation System");
						setBackground(Color.BLACK);
					}
				
				public void printme(String s)
				{   tx.setText("");
					stxt=s;
					th.start();
					i=0;
				}		
				public void actionPerformed(ActionEvent e)
				{
				   if(i==stxt.length()-1)th.stop();
   			    	tx.append(stxt.charAt(i++)+"");
				
				}	
			}