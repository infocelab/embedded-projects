import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class a extends JInternalFrame  implements ActionListener 
{   
    JMenuItem m3i1;
    JMenuItem m3i2,pop1;
   BasicCalc cal; notepad note;
    JMenu lok; JMenuItem lok1,lok2,lok3,lok4,log1;   UIManager.LookAndFeelInfo loks[]=UIManager.getInstalledLookAndFeels();
    Statement st;
    Connection con;
    ResultSet set;JFrame f3;
    JDesktopPane f2;
    txt txt1;  Table tb;m m;
    p1 p;reservation res;
    b b;login log;
	public a()
	{   
		super("Hotel Reservation System",false,true,false,true);
		f2=new JDesktopPane()
			{	public void paintComponent(Graphics g)
					{super.paintComponent(g);
		   				 ImageIcon i=new ImageIcon("res\\desk.png");
		    				i.paintIcon(this,g,0,0);
					}
							
			};
		
			JPanel pj=new JPanel()
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				ImageIcon i=new ImageIcon("res\\bak2.png");
				i.paintIcon(this,g,0,0);	
			}
		};
		f3=new JFrame();
	
		 try{ 
		   UIManager.setLookAndFeel(loks[0].getClassName());SwingUtilities.updateComponentTreeUI(this);
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=hotel.mdb;DriverID=22;READONLY=true) ","","");
		    st=con.createStatement(); 
		    }
	  	    catch(ClassNotFoundException e){System.out.println("a");}
		    catch(SQLException e){System.out.println("b");}
		    catch(Exception e){}
	  	log=new login(st,this);	
		f2.add(this);
		f2.add(log);
		f3.setContentPane(f2);
		f3.show();f3.setSize(1300,970);
		
		
		//**********************************************************************************************************************
		
		txt1=new txt();
		tb=new Table(st); cal=new BasicCalc();cal.setVisible(false);
		b=new b(st,txt1,tb);note=new notepad();note.setVisible(false);
		p=new p1(st,txt1,b,tb,note,res);
		res=new reservation(st,tb,txt1,p); m=new m(st,note);
		
		
		//**********************************************************************************************************************
	    JMenu menu1=new JMenu("Menu");menu1.setIcon(new ImageIcon("res\\menu.png"));
	    JMenu menu2=new JMenu("Option");menu2.setIcon(new ImageIcon("res\\option.png"));	    
	    JMenu menu3=new JMenu("Tools"); menu3.setIcon(new ImageIcon("res\\tool.png"));
	   	log1=new JMenuItem("Log Out");log1.addActionListener(this);
	   	log1.setIcon(new ImageIcon("res\\logout.png"));
	    lok=new JMenu("Theme");lok.setIcon(new ImageIcon("res\\theme.png"));
	    lok1=new JMenuItem("Java");lok2=new JMenuItem("Metal");lok3=new JMenuItem("Window");lok4=new JMenuItem("Motif");
	    lok1.addActionListener(this);lok2.addActionListener(this);lok3.addActionListener(this);lok4.addActionListener(this);
	    lok.add(lok1);lok.add(lok2);lok.add(lok3);lok.add(lok4);
	    		
	    m3i1=new JMenuItem("Caculator");m3i1.addActionListener(this);m3i1.setIcon(new ImageIcon("res\\cal.png"));
	    m3i2=new JMenuItem("NotePad");m3i2.addActionListener(this);m3i2.setIcon(new ImageIcon("res\\not.png"));
	    menu3.add(m3i1);menu3.add(m3i2);menu2.add(lok);
	     menu1.add(menu2);menu1.add(menu3);menu1.add(log1);
	    JMenuBar bar=new JMenuBar();bar.add(menu1);
	    setJMenuBar(bar);
	    Container con=getContentPane();
	    con.setLayout(new BorderLayout());
	    
	   
	    
	    JTabbedPane tab=new JTabbedPane();
	    tab.add("CHECK IN",p);
	    
	    tab.add("RESERVATION",res);
	    tab.add("ROOM STATUS",tb);
	  
	    //**********************************************************************
	    con.add( new c(),BorderLayout.NORTH);
	    con.add( b,BorderLayout.WEST);
	    con.add(tab,BorderLayout.CENTER);
	    con.add(txt1,BorderLayout.SOUTH);
		setBackground(new Color(120,120,120));
		setResizable(false);
		setLocation(70,70);
		setSize(630,640);
	
	}
	
    public void actionPerformed(ActionEvent e)
    { try{
    
    	if(e.getSource()==lok1){UIManager.setLookAndFeel(loks[0].getClassName());SwingUtilities.updateComponentTreeUI(this);}
    	if(e.getSource()==lok2){{UIManager.setLookAndFeel(loks[2].getClassName());SwingUtilities.updateComponentTreeUI(this);}}
    	if(e.getSource()==lok3){{UIManager.setLookAndFeel(loks[3].getClassName());SwingUtilities.updateComponentTreeUI(this);}}
    	if(e.getSource()==lok4){{UIManager.setLookAndFeel(loks[1].getClassName());SwingUtilities.updateComponentTreeUI(this);}}
    	if(e.getSource()== m3i1){cal.setVisible(true);}
    	if(e.getSource()== m3i2){note.setVisible(true);}
    	if(e.getSource()==log1){setVisible(false);log.setVisible(true);}
         }
         catch(Exception e2){System.out.print("Error kai malas");}
    }
	public static void main(String args[])
	{
	   a a=	new a();
		
	}
}
