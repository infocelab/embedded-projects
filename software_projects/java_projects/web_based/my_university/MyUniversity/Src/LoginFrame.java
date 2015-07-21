package com.ui;
/*
 * CopyLeft (c) 2004 Hussachai Puripunpinyo  All  Rights Reserved.
 * 
 * This software is made available under the terms of the "GPL License"
 * A copy of this license is included with this source distribution
 * in "license.txt" and is also available at:
 * http://www.gnu.org/copyleft/gpl.html 
 */
 
/*
 * Last Update : 14 October 2004
 *
 */
 
 /*
  * Welcome to any suggestion : SiberHus@YaHoo.com
  */
import java.awt.*;
import java.io.File;
import java.awt.event.*;
import javax.swing.*;
import com.crypt.*;
import com.ui.*;
import com.var.*;
import com.core.*;
import com.crypt.*;

public class LoginFrame extends JFrame implements ActionListener,ItemListener
{
    JLabel label_1;
    JLabel label_2;
    JButton btnRequest;
    JButton btnCancel;
    JTextField txtUser;
    JPasswordField txtPass;
    JLabel label_3;
    JLabel label_4;
    JButton btnRules;
    JComboBox selectUser;
    JLabel label_5;
	EasyCrypt easyCrypt;
	String sep=File.separator;
	String randImg[]={"img"+sep+"splash0.jpg","img"+sep+"splash1.jpg",
	"img"+sep+"splash2.jpg","img"+sep+"splash3.jpg"};
	String user[]={"Student","Teacher","Officer","Admin"};
	VerifyUser vUser;
	ExecDb db;
	FileHandle fh;
    public LoginFrame() {
    	
        LoginFrameLayout customLayout = new LoginFrameLayout();
        fh=new FileHandle();
        fh.loadProperties();
        db=new ExecDb();
		easyCrypt=new EasyCrypt(); //create easy crypt instance //import from com.crypt
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
        
        vUser=new VerifyUser();//create instance for user verifying
        
        int selectImg=(int)(Math.random()*4);
        if(selectImg==4)
        selectImg--;
		Icon splash=new ImageIcon(randImg[selectImg]);
		Icon myU_img=new ImageIcon("img"+sep+"header.gif");
        label_1 = new JLabel(splash);
        getContentPane().add(label_1);

        label_2 = new JLabel(myU_img,SwingConstants.CENTER);
        getContentPane().add(label_2);
		
        btnRequest = new JButton("Request");
        getContentPane().add(btnRequest);
		btnRequest.setToolTipText("Send Request to database server");
        btnCancel = new JButton("Cancel");
        getContentPane().add(btnCancel);

        txtUser = new JTextField("");
        getContentPane().add(txtUser);

        txtPass = new JPasswordField("");
        getContentPane().add(txtPass);

        label_3 = new JLabel("Username :");
        getContentPane().add(label_3);

        label_4 = new JLabel("Password :");
        getContentPane().add(label_4);

        btnRules = new JButton("Rules");
		btnRules.setToolTipText("You must click here");
        getContentPane().add(btnRules);

		
		selectUser=new JComboBox(user);
		getContentPane().add(selectUser);
		selectUser.addItemListener(this);
		
        label_5 = new JLabel("Log in as");
        getContentPane().add(label_5);
		// add register component here
		btnCancel.addActionListener(this);
		btnRequest.addActionListener(this);
		//
        setSize(getPreferredSize());
		setTitle("LoginFrame");
        pack();
		setAlwaysOnTop(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	University.showMainGui();
                hideFrame();
            }
        });
        
    }
	public void showFrame()
	{
		int selectImg=(int)(Math.random()*4);
        if(selectImg==4)
        selectImg--;
		Icon splash=new ImageIcon(randImg[selectImg]);
		label_1.setIcon(splash);
		setVisible(true);
	}
	public void hideFrame()
	{
		txtUser.setText("");
    	txtPass.setText("");
		setVisible(false);	
	}
    public static void main(String args[]) {
        LoginFrame window = new LoginFrame();
    }
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==btnCancel)
    	{
    		hideFrame();
    		University.showMainGui();
    		University.gui.disableAllMenu();
    		MyVar.login=0; //login fail
    		MainGui.lUser.setText(" NOT LOGIN");
    		MainGui.timer.resetTimer();
    		
    		
    	}
    	if(e.getSource()==btnRequest)
    	{
    		
    		System.out.println(MyVar.userName+MyVar.passWord);
    		MyVar.userName=txtUser.getText();
    		MyVar.passWordText=txtPass.getText();
    		MyVar.passWord=easyCrypt.encrypt(txtPass.getText());
    		if(vUser.verify(MyVar.driver,
    					MyVar.host,
    					MyVar.user,MyVar.pass))
    		{
    			System.out.println("Success");
    			MyVar.login=1; //login success
    			University.showMainGui();
    			hideFrame();
    			if(MyVar.status==0)
    			{
    				MainGui.txtAreaUserInfo.setText("User Profile :\n\n"
    				+"ID : "+MyVar.userName+"\n"
    				+"Name :"+db.execString("select f_name from student where stu_id='"+MyVar.userName+"'","f_name")+"\n"
    				+"Surname :"+db.execString("select l_name from student where stu_id='"+MyVar.userName+"'","l_name")+"\n"
    				+"Gender :"+db.execString("select gender from student where stu_id='"+MyVar.userName+"'","gender")+"\n"
    				+"Birthday :"+db.execString("select dob from student where stu_id='"+MyVar.userName+"'","dob")+"\n"
    				+"Address :"+db.execString("select address from student where stu_id='"+MyVar.userName+"'","address")+"\n"
    				+"Phone :"+db.execString("select phone from student_phone where stu_id='"+MyVar.userName+"'","phone")+"\n");
    			}
    			else
    			{
    				MainGui.txtAreaUserInfo.setText("User Profile :\n\n"
    				+"ID : "+MyVar.userName+"\n"
    				+"Name :"+db.execString("select f_name from staff where staff_id='"+MyVar.userName+"'","f_name")+"\n"
    				+"Surname :"+db.execString("select l_name from staff where staff_id='"+MyVar.userName+"'","l_name")+"\n"
    				+"Gender :"+db.execString("select gender from staff where staff_id='"+MyVar.userName+"'","gender")+"\n"
    				+"Birthday :"+db.execString("select dob from staff where staff_id='"+MyVar.userName+"'","dob")+"\n"
    				+"Address :"+db.execString("select address from staff where staff_id='"+MyVar.userName+"'","address")+"\n"
    				+"Phone :"+db.execString("select phone from staff_phone where staff_id='"+MyVar.userName+"'","phone")+"\n");
    			}
    			
    			
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(this,"Error : Username"+
    			" or Password or both is not valid"+"\nPlease Check your Username,"
    			+"Password \n and Login type","Error: Not valid user!",
    			JOptionPane.INFORMATION_MESSAGE);
    			MyVar.login=0; //login fail
    		}
    		txtUser.setText("");
    		txtPass.setText("");
			
    	}
    }
    public void itemStateChanged(ItemEvent e)
    {
    	if(selectUser.getSelectedIndex()==0)
    			MyVar.status=0;
    		else if(selectUser.getSelectedIndex()==1)
    			MyVar.status=1;
    		else if(selectUser.getSelectedIndex()==2)
    			MyVar.status=2;
    		else
    			MyVar.status=3;
    }
    
}

class LoginFrameLayout implements LayoutManager {

    public LoginFrameLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 423 + insets.left + insets.right;
        dim.height = 469 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+48,392,248);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+16,304,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+432,88,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+432,88,32);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+312,160,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+352,160,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+312,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+352,112,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+432,80,32);}
        
       
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+100,insets.top+392,104,24);}
     
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+392,104,24);}
    }
}
