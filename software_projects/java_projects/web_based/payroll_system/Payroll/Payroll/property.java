import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.sql.*;

class property extends JInternalFrame implements ActionListener
{
	property()
	{
		super("System Property",false,true,false,false);
		setSize(Payroll.x/2,Payroll.x/2);
		setLocation(Payroll.x/4,Payroll.x/7);

		//Container c=getContentPane();

	//	west=new JPanel();
//		JScrollPane westScroll =new JScrollPane(west);
//		add(westScroll,"West");
		DefaultListModel dlm=new DefaultListModel();
		dlm.addElement(image[0]);dlm.addElement(image[1]);dlm.addElement(image[2]);
		dlm.addElement(image[3]);dlm.addElement(image[4]);dlm.addElement(image[5]);dlm.addElement(image[6]);
		dlm.addElement(image[7]);dlm.addElement(image[8]);dlm.addElement(image[9]);dlm.addElement(image[10]);
		dlm.addElement(image[11]);dlm.addElement(image[12]);dlm.addElement(image[13]);dlm.addElement(image[14]);
		dlm.addElement(image[15]);dlm.addElement(image[16]);dlm.addElement(image[17]);dlm.addElement(image[18]);
		dlm.addElement(image[19]);dlm.addElement(image[20]);dlm.addElement(image[21]);dlm.addElement(image[22]);
		dlm.addElement(image[23]);dlm.addElement(image[24]);dlm.addElement(image[25]);dlm.addElement(image[26]);

		dlm.addElement(image[27]);dlm.addElement(image[28]);dlm.addElement(image[29]);
		dlm.addElement(image[30]);dlm.addElement(image[31]);dlm.addElement(image[32]);dlm.addElement(image[33]);
		dlm.addElement(image[34]);dlm.addElement(image[35]);dlm.addElement(image[36]);dlm.addElement(image[37]);
		dlm.addElement(image[38]);dlm.addElement(image[39]);dlm.addElement(image[40]);dlm.addElement(image[41]);
		dlm.addElement(image[42]);dlm.addElement(image[43]);dlm.addElement(image[44]);dlm.addElement(image[45]);
		dlm.addElement(image[46]);dlm.addElement(image[47]);dlm.addElement(image[48]);dlm.addElement(image[49]);
		dlm.addElement(image[50]);dlm.addElement(image[51]);dlm.addElement(image[52]);dlm.addElement(image[53]);
		dlm.addElement(image[54]);dlm.addElement(image[55]);dlm.addElement(image[56]);dlm.addElement(image[57]);dlm.addElement(image[58]);
		dlm.addElement(image[59]);dlm.addElement(image[60]);dlm.addElement(image[61]);dlm.addElement(image[62]);dlm.addElement(image[63]);
		dlm.addElement(image[64]);dlm.addElement(image[65]);dlm.addElement(image[66]);dlm.addElement(image[67]);dlm.addElement(image[68]);
		dlm.addElement(image[69]);dlm.addElement(image[70]);dlm.addElement(image[71]);dlm.addElement(image[72]);dlm.addElement(image[73]);
		dlm.addElement(image[74]);dlm.addElement(image[75]);dlm.addElement(image[76]);dlm.addElement(image[77]);dlm.addElement(image[78]);
		dlm.addElement(image[79]);dlm.addElement(image[80]);dlm.addElement(image[81]);dlm.addElement(image[82]);dlm.addElement(image[83]);
		dlm.addElement(image[84]);dlm.addElement(image[85]);dlm.addElement(image[86]);dlm.addElement(image[87]);

		list=new JList(dlm);
		JScrollPane Spp=new JScrollPane(list);
		add(Spp,"West");
		//img=new ImageIcon(imgStr+image[1]);


		//centerLabel=new JLabel(img);
		//center.add(centerLabel);


		south=new JPanel();
		south.setBackground(Color.gray);
		okBut=new JButton(" OK ");
		okBut.addActionListener(this);
		okBut.setBackground(Color.white);
		canBut=new JButton(" CANCEL ");
		canBut.setBackground(Color.white);
		canBut.addActionListener(this);
		appBut=new JButton(" APPLY ");
		appBut.setBackground(Color.white);
		appBut.addActionListener(this);

		south.add(okBut);
		south.add(canBut);
		south.add(appBut);

		add(south,"South");

		try
		{
			conn = connect.setConnection(conn,"","");

		}
		catch(Exception e)
		{}
		centerProp=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				try{
				st=conn.createStatement();
				ResultSet rs=st.executeQuery("select * from img");
				String s="Image/backgro/";
				while(rs.next())
				{
					String ss=rs.getString(2);
					Toolkit kit = Toolkit.getDefaultToolkit();
					img =kit.getImage(s+ss);
					img = img.getScaledInstance(500, -1, Image.SCALE_FAST);
					//diskPane.repaint();
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,0);
					while(true)
					{
						try
						{
							t.waitForAll();
							break;
						}
						catch(Exception ee)
						{}
					}
					g.drawImage(img,0,0,Payroll.x/2,Payroll.x/2,null);
				}
				bakImage(g);
				}catch(Exception er){}
			}
		};
		add(centerProp);


	}
	public void actionPerformed(ActionEvent e)
	{
		Object obj=e.getSource();

		if(obj==appBut)
		{
			try
			{
				Object[] values=list.getSelectedValues();

				for(int i=0 ; i<values.length ; i++)
				{
					String word=(String)values[i];
					ps=conn.prepareStatement("Update img SET ID=?,Image=? WHERE ID LIKE "+1);
					ps.setInt(1,1);
					ps.setString(2,word);
					ps.executeUpdate();

					Payroll.diskPane.repaint();
					Payroll.diskPane.repaint();
				}
			}
			catch(Exception er)
			{
				System.out.println(""+er);
			}
		}
		else if(obj==okBut)
		{
			try
			{
				Object[] values=list.getSelectedValues();
				for(int i=0 ; i<values.length ; i++)
				{
					String word=(String)values[i];

					ps=conn.prepareStatement("Update img SET ID=?,Image=? WHERE ID LIKE "+1);
					ps.setInt(1,1);
					ps.setString(2,word);
					ps.executeUpdate();

					//Payroll.pane(Payroll.diskPane);
					Payroll.diskPane.repaint();
					Payroll.diskPane.repaint();
					dispose();
				}
			}
			catch(Exception er)
			{
				System.out.println(""+er);
			}
		}
		else if(obj==canBut)
		{
			dispose();
			Payroll.diskPane.requestFocus();
		}
	}
	public void bakImage(Graphics g)
	{
		list.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{

				Object[] values=list.getSelectedValues();
				for(int i=0 ; i<values.length ; i++)
				{
					word=(String)values[i];
				}
				add(centerProp);
			}
		});
		try
		{
			String ss="Image/backgro/"+word;
			Toolkit kit = Toolkit.getDefaultToolkit();
			img =kit.getImage(ss);
			img = img.getScaledInstance(300, -1, Image.SCALE_SMOOTH);
			centerProp.repaint();
			MediaTracker t=new MediaTracker(this);
			t.addImage(img,0);
			while(true)
			{
				try
				{
					t.waitForAll();
					break;
				}
				catch(Exception ee)
				{}
			}
			g.drawImage(img,0,0,Payroll.x/2-50,Payroll.x/2-50 ,null);
		}
		catch(Exception re){}
	}
	private Connection conn;
	private PreparedStatement ps;
	private JPanel centerProp,south;
	private JList list;
	private JLabel centerLabel;
	private JButton okBut,canBut,appBut;

	private String image[]={"01.jpg","02.jpg","03.jpg","04.jpg","05.jpg","06.jpg",
							"07.jpg","08.jpg","09.jpg","10.jpg","11.jpg","12.jpg","13.jpg","14.jpg","15.jpg","16.jpg","17.jpg",
							"18.jpg","19.jpg","20.jpg","21.jpg","22.jpg","23.jpg","24.jpg","25.jpg","26.jpg","27.jpg","28.jpg","29.jpg","30.jpg",
							"31.jpg","32.jpg","33.jpg","34.jpg","35.jpg","36.jpg","37.jpg","38.jpg","39.jpg","40.jpg",
							"41.jpg","42.jpg","43.jpg","44.jpg","45.jpg","46.jpg","47.jpg","48.jpg","49.jpg","50.jpg",
							"51.jpg","52.jpg","53.jpg","54.jpg","55.jpg","56.jpg","57.jpg","58.jpg","59.jpg","60.jpg",
							"61.jpg","62.jpg","63.jpg","64.jpg","65.jpg","66.jpg","67.jpg","68.jpg","69.jpg","70.jpg",
							"71.jpg","72.jpg","73.jpg","74.jpg","75.jpg","76.jpg","77.jpg","78.jpg","79.jpg","80.jpg",
							"81.jpg","82.jpg","83.jpg","84.jpg","85.jpg","86.jpg","87.jpg","88.jpg","89.jpg","80.jpg"
							};

	//private ImageIcon img;
	private String imgStr="Image/backgro/";
	clsConnection connect=new clsConnection();
	String word;
	private Image img;

	private Statement st;

}