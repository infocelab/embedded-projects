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
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import com.time.*;
import com.ui.*;
import com.var.*;
import com.sun.jfc.*;
import com.core.*;
public class MainGui extends JFrame
{
	//Declare global variable
	FileHandle fh;
	static JDBCAdapter myDb;
	TableSorter sorter;
	String sep=File.separator,sql;
	LoginFrame myLogin;
	JDesktopPane deskPane;//for MDI
	JOptionPane dialog;
	JMenuBar mbar;
	static JMenu mLogin,mView,mSearch,mStudent,mTeacher,mOfficer,mAdmin,mHelp;
	//main shared menu
	JMenuItem m_Login,m_Logout,m_SearchDiag,m_Help,m_FeedBack,m_About;
	
	//For student
	JMenuItem m_CheckGrade1,m_CheckGrade2,m_RegedSub,m_TimeTable_S,
				m_AvailSub_S,m_AllSub_S,m_ChkStatus_S;
	static JCheckBoxMenuItem m_Enroll,m_CPass_S;
	//For Teacher
	JMenuItem m_TimeTable,m_StuClass,m_AvailSub_T,m_AllSub_T,
				m_ChkStatus_T,m_WorkUnit_T;
	static JCheckBoxMenuItem m_CPass_T;			
	//For Officer
	JMenuItem m_DropSub,m_GiveGrade,m_AllDivision,m_AvailSub_O,m_ShowAllStudent,
				m_AllSub_O,m_ChkStatus_O,m_WorkUnit_O;
	static JCheckBoxMenuItem m_addStu,m_removeStu,m_CPass_O,m_AdUser,m_DelUser;
	//For admin
	static JCheckBoxMenuItem m_QueryForm,m_CPass_A,m_AdAdmin;
			
	JCheckBoxMenuItem m_ShLog,m_ShStatusBar,m_ShUserInfo,m_ShResult;
	JRadioButtonMenuItem m_Motif,m_Metal,m_Windows,m_GTK;
	final int INFO=JOptionPane.INFORMATION_MESSAGE,
	ERROR=JOptionPane.ERROR_MESSAGE,QUESTION=JOptionPane.QUESTION_MESSAGE;
	Container ct;
	public static JTextArea txtAreaLog,txtAreaUserInfo,txtResult;
	JInternalFrame internalLog,internalUserInfo,internalResult;
	JPanel myComponent;
	JScrollPane myTable;
	static JComboBox choice;
	public static JTextArea txtError;
	JTextField keyWord;
	
	void createSearchDialog()
	{
		myComponent=new JPanel(false);
		choice=new JComboBox();
		JPanel labelPanel=new JPanel(false),
				optionPanel=new JPanel(false);
		keyWord=new JTextField();
		JLabel choiceLabel=new JLabel("Search by : ",JLabel.RIGHT),
				keyLabel=new JLabel("Keyword : ",JLabel.RIGHT);
		labelPanel.setLayout(new GridLayout(0,1));
		labelPanel.add(choiceLabel);
		labelPanel.add(keyLabel);
		optionPanel.setLayout(new GridLayout(0,1));
		optionPanel.add(choice);
		optionPanel.add(keyWord);
		
		myComponent.setLayout(new BoxLayout(myComponent,BoxLayout.X_AXIS));
		myComponent.add(labelPanel);
		myComponent.add(optionPanel);	
	}
	void activateSearchDialog() {
			String btnName[]={"Search Now","Dismiss"};
			if(JOptionPane.showOptionDialog(this,myComponent,"Search",
		   JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                   null, btnName, btnName[1]) == 0) {
            	System.out.println("OK");
            	searchKey(choice.getSelectedItem().toString());
			}
			else
	    		System.out.println("Not OK");
    }
    void searchKey(String select)
    {  
    	if(select.equals("AvailableSubjectCode"))
    	{
    			sql="SELECT sub.open_id as ID,sub.sub_id as SubjectID,sub2.sub_name"
    			+" as SubjectName,sub2.Credit"
				+" from subject sub2,open_Subject as sub"
				+" where sub.sub_id =sub2.sub_id and sub2.sub_id='"+keyWord.getText()+"'";
    		myDb.executeQuery(sql);
    	}
    	else if(select.equals("AvailableSubjectName"))
    	{
    		sql="SELECT sub.open_id as ID,sub.sub_id as SubjectID,sub2.sub_name"
    			+" as SubjectName,sub2.Credit"
				+" from subject sub2,open_Subject as sub"
				+" where sub.sub_id =sub2.sub_id and sub2.sub_name='"+keyWord.getText()+"'";  
    		myDb.executeQuery(sql);
    	}
    	else if(select.equals("AllSubjectCode"))
    	{
    		sql="SELECT sub_id as SubjectID,sub_name as Subject,Credit"
				+" from Subject where sub_id='"+keyWord.getText()+"'"; 
    		myDb.executeQuery(sql);
    	}
    	else if(select.equals("AllSubjectName"))
    	{
    		sql="SELECT sub_id as SubjectID,sub_name as Subject,Credit"
				+" from Subject where sub_name='"+keyWord.getText()+"'";
    		myDb.executeQuery(sql);
    	}
    	else if(select.equals("StudentID"))
    	{
    		sql="SELECT stu_id as ID,f_name as FirstName,l_name as LastName"
				+" from student where stu_id='"+keyWord.getText()+"'";
    		myDb.executeQuery(sql);
    	}
    	else if(select.equals("StudentName"))
    	{
    		sql="SELECT stu_id as ID,f_name as FirstName,l_name as LastName"
				+" from student where f_name='"+keyWord.getText()+"'";
    		myDb.executeQuery(sql);
    	}
    	else if(select.equals("TeacherID"))
    	{
    		sql="select s.staff_id as StaffID ,s.f_name as FirstName,"
    		+"s.l_name as LastName,w.workunit_name as BeUnder"
			+" from staff s,workunit w"
			+" where w.workunit_id=s.workunit_id and w.workunit_id not like '00*'"
			+" and s.staff_id='"+keyWord.getText()+"'";
    		myDb.executeQuery(sql);
    	}
    	else if(select.equals("TeacherName"))
    	{
    		sql="select s.staff_id as StaffID ,s.f_name as FirstName,"
    		+"s.l_name as LastName,w.workunit_name as BeUnder"
			+" from staff s,workunit w"
			+" where w.workunit_id=s.workunit_id and w.workunit_id not like '00*'"
			+" and s.staff_name='"+keyWord.getText()+"'";
    		myDb.executeQuery(sql);
    	}
    	else if(select.equals("StaffID"))
    	{
    		sql="select staff_id as StaffID,f_name as FirstName,l_name as LastName"
				+" from staff where staff_id='"+keyWord.getText()+"'";
    		myDb.executeQuery(sql);
    	}
    	else if(select.equals("StaffName"))
    	{
    		sql="select staff_id as StaffID,f_name as FirstName,l_name as LastName"
				+" from staff where f_name='"+keyWord.getText()+"'";
    		myDb.executeQuery(sql);
    	}
    	else if(select.equals("StaffSalary"))
    	{
    		sql="select staff_id as StaffID,f_name as FirstName,l_name as LastName"
				+" from staff where salary='"+keyWord.getText()+"'";
    		myDb.executeQuery(sql);
    	}
    	
    }
    public static void createEnvirontment()
    {
    	
    	choice.removeAllItems();
    	timer.resetTimer();
    	
    	if(MyVar.status==0)//student
    	{		
    		
    		timer.startTimer();
    		
    		lUser.setText(" Student");
    		
    		//For Search Item******************
    		choice.addItem("AvailableSubjectCode");
    		choice.addItem("AvailableSubjectName"); 
    		choice.addItem("AllSubjectCode");
    		choice.addItem("AllSubjectName"); 
    		choice.addItem("TeacherID");
    		choice.addItem("TeacherName");    		
    		//*****************
    		mSearch.setEnabled(true);
			mStudent.setEnabled(true);
			mTeacher.setEnabled(false);
			mOfficer.setEnabled(false);
			mAdmin.setEnabled(false);
			tm_Search.setEnabled(true);
			tm_Enroll.setEnabled(true);
			tm_ChkGrade.setEnabled(true);
			tm_AvSubject.setEnabled(true);
			tm_AllSubject.setEnabled(true);
			tm_Drop.setEnabled(false);
			tm_ChkStatus.setEnabled(true);
    		
    		
    	}
   		if(MyVar.status==1)//teacher
    	{	
    	
    		timer.stopTimer();
    		
    		lUser.setText(" Teacher");
    		
    		//For Search Item*******************
    		choice.addItem("AvailableSubjectCode");
    		choice.addItem("AvailableSubjectName"); 
    		choice.addItem("AllSubjectCode");
    		choice.addItem("AllSubjectName");
    		choice.addItem("StudentID");
    		choice.addItem("StudentName");
    		choice.addItem("TeacherID");
    		choice.addItem("TeacherName");		
    		//*********************
    		mSearch.setEnabled(true);
			mStudent.setEnabled(false);
			mTeacher.setEnabled(true);
			mOfficer.setEnabled(false);
			mAdmin.setEnabled(false);
			tm_Search.setEnabled(true);
			tm_Enroll.setEnabled(false);
			tm_ChkGrade.setEnabled(false);
			tm_AvSubject.setEnabled(true);
			tm_AllSubject.setEnabled(true);
			tm_Drop.setEnabled(false);
			tm_ChkStatus.setEnabled(true);
    		    		
    	}
   		if(MyVar.status==2)//officer
    	{	
    		
    		timer.stopTimer();
    		
    		lUser.setText(" Officer");
    	
    		//For Search Item ******************
    		choice.addItem("AvailableSubjectCode");
    		choice.addItem("AvailableSubjectName"); 
    		choice.addItem("AllSubjectCode");
    		choice.addItem("AllSubjectName");
    		choice.addItem("StudentID");
    		choice.addItem("StudentName");
    		choice.addItem("StaffID");
    		choice.addItem("StaffName");
    		choice.addItem("StaffSalary");  
    		//**********************
    		
    		mSearch.setEnabled(true);
			mStudent.setEnabled(false);
			mTeacher.setEnabled(false);
			mOfficer.setEnabled(true);
			mAdmin.setEnabled(false);
			tm_Search.setEnabled(true);
			tm_Enroll.setEnabled(false);
			tm_ChkGrade.setEnabled(false);
			tm_AvSubject.setEnabled(true);
			tm_AllSubject.setEnabled(true);
			tm_Drop.setEnabled(true);
			tm_ChkStatus.setEnabled(true);
    		 		
    	}
    	if(MyVar.status==3)//admin
    	{		
    	
    		
    		timer.stopTimer();
    		
    		lUser.setText(" Admin");
    		   		
    		mSearch.setEnabled(false);
			mStudent.setEnabled(false);
			mTeacher.setEnabled(false);
			mOfficer.setEnabled(false);
			mAdmin.setEnabled(true);
			tm_Search.setEnabled(false);
			tm_Enroll.setEnabled(false);
			tm_ChkGrade.setEnabled(false);
			tm_AvSubject.setEnabled(false);
			tm_AllSubject.setEnabled(false);
			tm_Drop.setEnabled(false);
			tm_ChkStatus.setEnabled(false);
    	}
    }
   public void connectDB()
    {
    	myDb=new JDBCAdapter(
    		"jdbc:odbc:myDB",
    		"sun.jdbc.odbc.JdbcOdbcDriver",
    		MyVar.user,MyVar.pass);
    	sorter.setModel(myDb);
    }

   
   AdminFrame admin;
   Enrollment enr;
   AddStudent addstu;
   RemoveStudent rmstu;
   AddNewUser addUser;
   DelUser delUser;
   AddAdmin adAdmin;
   ChangePassword chPass;
   
	public MainGui()
	{
		super("My University 1.0");
		
		//Create instance *************
		txtError=new JTextArea();
		dialog=new JOptionPane();
		
		myLogin=new LoginFrame();//For Login Frame
		
		fh=new FileHandle();//You can use method loadFile 
							//from this instance
		myTable=createTable();//Table that show query result
		
		ct=getContentPane();//
		
		deskPane=new JDesktopPane();//This instance for 
									//adding internalframe
	
									
		enr=new Enrollment();//This for Enrollment Frame
		enr.setVisible(false);//Initial hide this window until requested
		
		
		admin=new AdminFrame();//This for admin Query
		admin.setVisible(false);//hide this window until requested
		
		addstu=new AddStudent();
		addstu.setVisible(false);
		
		rmstu=new RemoveStudent();
		rmstu.setVisible(false);
		
		addUser=new AddNewUser();
		addUser.setVisible(false);
		
		delUser=new DelUser();
		delUser.setVisible(false);
		
		adAdmin=new AddAdmin();
		adAdmin.setVisible(false);
		
		chPass=new ChangePassword();
		chPass.setVisible(false);
		
		
		deskPane.add(enr);//Add EnrollForm to Deskpane 
		deskPane.add(admin);//Add AdminForm to Deskpane
		deskPane.add(addstu);
		deskPane.add(rmstu);
		deskPane.add(addUser);
		deskPane.add(delUser);
		deskPane.add(adAdmin);
		deskPane.add(chPass);
		ct.add(deskPane);//Add Deskpane to ContentPane
		
		//Call intitial method
		createInstanceForMenu();
		createSearchDialog();
		registerMenu();
		toolBarInit();
		internalFrameInit();
		disableAllMenu();
		//Connect Database
		connectDB();
					
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try{
					myDb.close();
				}
				catch(Exception ex)
				{
					showMessage("Error:"+ex.getMessage(),"Error",ERROR);
					txtError.append("Error : "+ex.getMessage()+"\n");
				}
				System.exit(0);
				//Exit normally
			}
		});
	}
	
	public JScrollPane createTable()
	{
		
		sorter=new TableSorter();
		JTable table=new JTable(sorter);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		sorter.addMouseListenerToHeaderInTable(table);
		JScrollPane scrollpane = new JScrollPane(table);
		return scrollpane;
	}
	JTextArea textPad;
	CalculatorPanel calc;
	JButton newBtn,saveBtn,openBtn;
	private void internalFrameInit()
	{
		//
		textPad=new JTextArea(10,37);
		textPad.setBackground(Color.pink);
		textPad.setText("Simple textpad for carry forwarding\n");
		calc=new CalculatorPanel();
		JPanel calc_pad=new JPanel();
		calc_pad.setLayout(new BorderLayout());
		calc_pad.add(calc,"West");
		calc_pad.add(new JScrollPane(textPad),"East");
		//
		InnerAction action=new InnerAction();
		internalLog=new JInternalFrame("Log",true,false,true,true);
		internalUserInfo=new JInternalFrame("UserInfo",true,false,true,true);
		internalResult=new JInternalFrame("Result",true,false,true,true);
		
		deskPane.add(internalLog);
		deskPane.add(internalUserInfo);
		deskPane.add(internalResult);
		//set default value
		internalLog.setSize(500,200);
		internalUserInfo.setSize(300,200);
		internalResult.setSize(600,400);
		internalLog.setVisible(false);
		internalUserInfo.setVisible(false);
		internalResult.setVisible(true);
		//create instance for component in JInternalFrame
		txtResult=new JTextArea();
		txtAreaLog=new JTextArea();
		txtAreaUserInfo=new JTextArea();
		txtAreaUserInfo.setFont(new Font("Times New Roman",Font.BOLD,14));
		txtAreaUserInfo.setBackground(Color.BLACK);
		JTabbedPane tab=new JTabbedPane();
		Icon reportTab=new ImageIcon("img"+sep+"report.gif")
			 ,tableTab=new ImageIcon("img"+sep+"wiber.gif")
			 ,errorTab=new ImageIcon("img"+sep+"error.gif")
			 ,calcpadTab=new ImageIcon("img"+sep+"calcpad.gif")
			 ,saveTb=new ImageIcon("img"+sep+"save.gif")
			 ,openTb=new ImageIcon("img"+sep+"open.gif")
			 ,newTb=new ImageIcon("img"+sep+"new.gif");
		newBtn=new JButton(newTb);
		openBtn=new JButton(openTb);
		saveBtn=new JButton(saveTb);
		newBtn.addActionListener(action);
		openBtn.addActionListener(action);
		saveBtn.addActionListener(action);
		JToolBar tb=new JToolBar();
		tb.add(newBtn);
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator();
		
		internalResult.getContentPane().add(tb,BorderLayout.NORTH);
		//add component
		tab.addTab("Table",tableTab,myTable,"Display result in table form");
		tab.addTab("Report",reportTab,new JScrollPane(txtResult),"Display result in text form");
		tab.addTab("Error Log",errorTab,new JScrollPane(txtError),"Error Log collect all error occure event");
		tab.addTab("Calc & TextPad",calcpadTab,calc_pad,"Calc&TextPad");
		internalLog.getContentPane().add(new JScrollPane(txtAreaLog));
		internalUserInfo.getContentPane().add(txtAreaUserInfo);
		internalResult.getContentPane().add(tab);
		//set
		txtAreaLog.setBackground(Color.WHITE);
		txtResult.setBackground(Color.WHITE);
		txtAreaLog.setForeground(Color.BLUE);
		txtAreaUserInfo.setEnabled(false);
		txtAreaLog.append("> Load University to memory\n");
	}
	private class InnerAction implements ActionListener
	{
		JFileChooser jf=new JFileChooser();
		int result;
		public void actionPerformed(ActionEvent e)
		{
		try{
			if(e.getSource()==openBtn)
			{
				result=jf.showOpenDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
				{
					txtResult.setText("");
					File file=jf.getSelectedFile();
					BufferedReader inStream=new BufferedReader(
					new FileReader(file.toString()));
					String line=inStream.readLine();
					while(line!=null)
					{
						txtResult.append(line+"\n");
						line=inStream.readLine();
					}
					inStream.close();
				}
			}
			if(e.getSource()==saveBtn)
			{
				result=jf.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
				{
					File file=jf.getSelectedFile();
					FileWriter outStream=new FileWriter(file.toString());
					outStream.write(txtResult.getText());
					outStream.close();
				}
			}
			if(e.getSource()==newBtn)
			{
				txtResult.setText("");
			}
		}catch(Exception ex)
		{
			txtError.append("Error : "+ex.getMessage()+"\n");
		}
		finally
		{

		}
		}
	}
	public static JLabel lUser;
	JLabel lTime,lToday;
	static JButton tm_Login,tm_Logout,tm_Search,tm_AvSubject,
	tm_ChkGrade,tm_AllSubject,tm_Drop,tm_ChkStatus,tm_About;
	static JToggleButton tm_Enroll;
	static Elapse timer;//this is timer interrupt for automatic logout
	
	JToolBar toolbar,mainToolBar;
	Date date;
	private void toolBarInit()
	{
		mainToolBar=new JToolBar();
		toolbar=new JToolBar();
		Icon elapse=new ImageIcon("elapse.jpg"),
			 loginAs=new ImageIcon("img"+sep+"loginAs.jpg"),
			 login=new ImageIcon("img"+sep+"login.jpg"),
			 logout=new ImageIcon("img"+sep+"logout.jpg"),
			 search=new ImageIcon("img"+sep+"search.jpg"),
			 enroll=new ImageIcon("img"+sep+"enroll.jpg"),
			 chkgrade=new ImageIcon("img"+sep+"chkgrade.jpg"),
			 availsubject=new ImageIcon("img"+sep+"availSubject.jpg"),
			 allsubject=new ImageIcon("img"+sep+"allSubject.jpg"),
			 drop=new ImageIcon("img"+sep+"drop.jpg"),
			 chkstatus=new ImageIcon("img"+sep+"chkstatus.jpg"),
			 about=new ImageIcon("img"+sep+"about.jpg"),
			 today=new ImageIcon("img"+sep+"todayis.gif");
			 
		tm_Login=new JButton(login);
		tm_Login.addActionListener(handler);
		tm_Login.setToolTipText("Log in");
		
		tm_Logout=new JButton(logout);
		tm_Logout.addActionListener(handler);
		tm_Logout.setToolTipText("Log out");
		
		tm_Search=new JButton(search);
		tm_Search.addActionListener(handler);
		tm_Search.setToolTipText("Intelligent Search");
		
		tm_Enroll=new JToggleButton(enroll);
		tm_Enroll.addItemListener(handler);
		tm_Enroll.setToolTipText("Enroll");
		
		tm_ChkGrade=new JButton(chkgrade);
		tm_ChkGrade.addActionListener(handler);
		tm_ChkGrade.setToolTipText("Check Grade");
		
		tm_AvSubject=new JButton(availsubject);
		tm_AvSubject.addActionListener(handler);
		tm_AvSubject.setToolTipText("Show Available Subject");
		
		tm_AllSubject=new JButton(allsubject);
		tm_AllSubject.addActionListener(handler);
		tm_AllSubject.setToolTipText("Show All Subject");
		
		tm_Drop=new JButton(drop);
		tm_Drop.addActionListener(handler);
		tm_Drop.setToolTipText("Drop registered subject");
		
		tm_ChkStatus=new JButton(chkstatus);
		tm_ChkStatus.addActionListener(handler);
		tm_ChkStatus.setToolTipText("Check Status");
		
		tm_About=new JButton(about);
		tm_About.addActionListener(handler);
		tm_About.setToolTipText("About the Author");
		
		date=new Date();
		String d=""+date.getDate()+"/"+date.getMonth()+"/"+date.getYear();
		lToday=new JLabel("Today is :"+d,today,JLabel.LEFT);
		
		mainToolBar.add(tm_Login);
		mainToolBar.add(tm_Logout);
		mainToolBar.addSeparator();
		mainToolBar.add(tm_Search);
		mainToolBar.addSeparator();
		mainToolBar.add(tm_Enroll);
		mainToolBar.add(tm_ChkGrade);
		mainToolBar.add(tm_AvSubject);
		mainToolBar.addSeparator();
		mainToolBar.add(tm_AllSubject);
		mainToolBar.add(tm_Drop);
		mainToolBar.addSeparator();
		mainToolBar.add(tm_ChkStatus);
		mainToolBar.add(tm_About);	
		mainToolBar.addSeparator(); 
		mainToolBar.addSeparator();
		mainToolBar.add(lToday); 
		JLabel l_User=new JLabel("Login as",loginAs,SwingConstants.LEFT);
		lUser=new JLabel("");
		lUser.setFont(new Font("Arial",Font.BOLD,12));
		timer=new Elapse();
		toolbar.add(timer);
		toolbar.addSeparator();
		toolbar.add(l_User);
		toolbar.add(lUser);
		ct.add(mainToolBar,"North");
		ct.add(toolbar,BorderLayout.SOUTH);
	}
	
	public static void disableAllMenu()
	{
		mSearch.setEnabled(false);
		mStudent.setEnabled(false);
		mTeacher.setEnabled(false);
		mOfficer.setEnabled(false);
		mAdmin.setEnabled(false);
		tm_Search.setEnabled(false);
		tm_Enroll.setEnabled(false);
		tm_ChkGrade.setEnabled(false);
		tm_AvSubject.setEnabled(false);
		tm_AllSubject.setEnabled(false);
		tm_Drop.setEnabled(false);
		tm_ChkStatus.setEnabled(false);

		
	}

	public static void logoutInterrupt()
	{
		System.out.println("Logout interrupt occur");
		disableAllMenu();
	}
	MenuDriven handler;
	public void registerMenu()
	{
		
		handler=new MenuDriven();
		
		m_Login.addActionListener(handler);
		m_Logout.addActionListener(handler);
		//
		m_ShLog.addItemListener(handler);
		m_ShStatusBar.addItemListener(handler);
		m_ShUserInfo.addItemListener(handler);
		m_ShResult.addItemListener(handler);
		m_Motif.addItemListener(handler);
		m_Metal.addItemListener(handler);
		m_Windows.addItemListener(handler);
		m_GTK.addItemListener(handler);
		//
		m_SearchDiag.addActionListener(handler);
		//
		//For student
		m_CheckGrade1.addActionListener(handler);
		m_CheckGrade2.addActionListener(handler);
		m_RegedSub.addActionListener(handler);
		m_Enroll.addItemListener(handler);
		m_AvailSub_S.addActionListener(handler);
		m_AllSub_S.addActionListener(handler);
		m_ChkStatus_S.addActionListener(handler);
		m_TimeTable_S.addActionListener(handler);
		m_CPass_S.addItemListener(handler);
		
		//For Teacher
		m_TimeTable.addActionListener(handler);
		m_StuClass.addActionListener(handler);
		m_AvailSub_T.addActionListener(handler);
		m_AllSub_T.addActionListener(handler);
		m_ChkStatus_T.addActionListener(handler);
		m_WorkUnit_T.addActionListener(handler);
		m_CPass_T.addItemListener(handler);
		
		//For Officer
		m_DropSub.addActionListener(handler);
		m_GiveGrade.addActionListener(handler);
		m_AllDivision.addActionListener(handler);
		m_AvailSub_O.addActionListener(handler);
		m_ShowAllStudent.addActionListener(handler);
		m_addStu.addItemListener(handler);
		m_removeStu.addItemListener(handler);
		m_AllSub_O.addActionListener(handler);
		m_ChkStatus_O.addActionListener(handler);
		m_WorkUnit_O.addActionListener(handler);
		m_CPass_O.addItemListener(handler);
		m_AdUser.addItemListener(handler);
		m_DelUser.addItemListener(handler);
		
		//For admin
		m_QueryForm.addItemListener(handler);
		m_CPass_A.addItemListener(handler);
		m_AdAdmin.addItemListener(handler);
		
		m_Help.addActionListener(handler);
		m_FeedBack.addActionListener(handler);
		m_About.addActionListener(handler);
		
		
	}
	public void createInstanceForMenu()
	{
		//Menu
		mbar=new JMenuBar();
		mLogin=new JMenu("Connect");
		mView=new JMenu("View");
		mSearch=new JMenu("Search");
		mStudent=new JMenu("Student");
		mTeacher=new JMenu("Teacher");
		mOfficer=new JMenu("Officer");
		mAdmin=new JMenu("Admin");
		mHelp=new JMenu("Help");
		
		//mConnect *********************
		m_Login=new JMenuItem("Log in");
		m_Logout=new JMenuItem("Log out");
		
		mLogin.add(m_Login);
		mLogin.add(m_Logout);
		
		//mView *********************
		m_ShLog=new JCheckBoxMenuItem("Show/Hide Log");
		m_ShStatusBar=new JCheckBoxMenuItem("Show/Hide Statusbar");
		m_ShUserInfo=new JCheckBoxMenuItem("Show/Hide User Info.");
		m_ShResult=new JCheckBoxMenuItem("Show/Hide Result");
		
		mView.add(m_ShLog);
		mView.add(m_ShStatusBar);
		mView.add(m_ShUserInfo);
		mView.add(m_ShResult);
		mView.addSeparator();
		ButtonGroup btn=new ButtonGroup();
		m_Motif=new JRadioButtonMenuItem("Motif Style");
		m_Metal=new JRadioButtonMenuItem("Metal Style");
		m_Windows=new JRadioButtonMenuItem("Windows Style");
		m_GTK=new JRadioButtonMenuItem("GTK Style");
		
		btn.add(m_Motif);
		btn.add(m_Metal);
		btn.add(m_Windows);
		btn.add(m_GTK);
		mView.add(m_Motif);
		mView.add(m_Metal);
		mView.add(m_Windows);
		mView.add(m_GTK);
		
		//mSearch *********************
		m_SearchDiag=new JMenuItem("Search Dialog");
		
		mSearch.add(m_SearchDiag);
		
		
		
		//mStudent*********************
		m_AvailSub_S=new JMenuItem("Show Available subject");
		m_AllSub_S=new JMenuItem("Show All subject");
		m_CheckGrade1=new JMenuItem("CheckGrade(Specify term)");
		m_CheckGrade2=new JMenuItem("CheckGrade(All term)");
		m_RegedSub=new JMenuItem("Show Registered Subject");
		m_Enroll=new JCheckBoxMenuItem("Enroll");
		m_TimeTable_S=new JMenuItem("Subject Time Table");
		m_ChkStatus_S=new JMenuItem("My Profile");
		m_CPass_S=new JCheckBoxMenuItem("Change Your Password");
		
		mStudent.add(m_AllSub_S);
		mStudent.add(m_AvailSub_S);
		mStudent.addSeparator();//
		mStudent.add(m_TimeTable_S);
		mStudent.add(m_RegedSub);
		mStudent.addSeparator();
		mStudent.add(m_Enroll);
		mStudent.addSeparator();//
		mStudent.add(m_CheckGrade1);
		mStudent.add(m_CheckGrade2);
		mStudent.addSeparator();//
		mStudent.add(m_ChkStatus_S);
		mStudent.add(m_CPass_S);
		
		
		//mTeacher****************************
		m_AvailSub_T=new JMenuItem("Show Available subject");
		m_AllSub_T=new JMenuItem("Show All subject");
		m_TimeTable=new JMenuItem("Show Time Table");
		m_StuClass=new JMenuItem("Show Student In Class");
		m_WorkUnit_T=new JMenuItem("Show All WorkUnit");
		m_ChkStatus_T=new JMenuItem("My Profile");
		m_CPass_T=new JCheckBoxMenuItem("Change Your Password");
		
		mTeacher.add(m_AllSub_T);
		mTeacher.add(m_AvailSub_T);
		mTeacher.addSeparator();
		mTeacher.add(m_TimeTable);
		mTeacher.add(m_StuClass);
		mTeacher.addSeparator();
		mTeacher.add(m_WorkUnit_T);
		mTeacher.add(m_ChkStatus_T);
		mTeacher.add(m_CPass_T);
		
		//mOfficer ***************************
		m_AvailSub_O=new JMenuItem("Show Available subject");
		m_AllSub_O=new JMenuItem("Show All subject");
		m_DropSub=new JMenuItem("Drop Subject");
		m_GiveGrade=new JMenuItem("Give Student Grade");
		m_AllDivision=new JMenuItem("Show All Division");
		m_WorkUnit_O=new JMenuItem("Show All WorkUnit");
		m_ChkStatus_O=new JMenuItem("My Profile");
		m_addStu=new JCheckBoxMenuItem("Add new student");
		m_removeStu=new JCheckBoxMenuItem("Remove existing student");
		m_ShowAllStudent=new JMenuItem("Show all student");
		m_CPass_O=new JCheckBoxMenuItem("Change Your Password");
		m_AdUser=new JCheckBoxMenuItem("Add User Account");
		m_DelUser=new JCheckBoxMenuItem("Delete User Account");
		
		
		mOfficer.add(m_AllSub_O);
		mOfficer.add(m_AvailSub_O);
		mOfficer.addSeparator();
		mOfficer.add(m_DropSub);
		mOfficer.add(m_GiveGrade);
		mOfficer.addSeparator();
		mOfficer.add(m_ShowAllStudent);
		mOfficer.add(m_addStu);
		mOfficer.add(m_removeStu);
		mOfficer.addSeparator();
		mOfficer.add(m_AdUser);
		mOfficer.add(m_DelUser);
		mOfficer.addSeparator();
		mOfficer.add(m_AllDivision);
		mOfficer.add(m_WorkUnit_O);
		mOfficer.addSeparator();
		mOfficer.add(m_ChkStatus_O);
		mOfficer.add(m_CPass_O);
		
		//mAdmin ****************************
		m_QueryForm=new JCheckBoxMenuItem("QueryForm");
		m_CPass_A=new JCheckBoxMenuItem("Change Your Password");
		m_AdAdmin=new JCheckBoxMenuItem("Create New Admin Account");
		mAdmin.add(m_QueryForm);
		mAdmin.addSeparator();
		mAdmin.add(m_CPass_A);
		mAdmin.add(m_AdAdmin);
		
		//mHelp *********************
		m_Help=new JMenuItem("Help");
		m_FeedBack=new JMenuItem("Feed back");
		m_About=new JMenuItem("About");
		mHelp.add(m_Help);
		mHelp.add(m_FeedBack);
		mHelp.addSeparator();
		mHelp.add(m_About);
		//*********************
		mbar.add(mLogin);
		mbar.add(mView);
		mbar.add(mSearch);
		mbar.add(mStudent);
		mbar.add(mTeacher);
		mbar.add(mOfficer);
		mbar.add(mAdmin);
		mbar.add(mHelp);
		setJMenuBar(mbar);
		//*********************
		
		//initial menu setting
		
		m_ShStatusBar.setSelected(true);
		m_ShResult.setSelected(true);
		m_ShLog.setSelected(false);
		m_ShUserInfo.setSelected(false);
	}
	public void showMessage(String msg,String title,int icon)
	{
		dialog.showMessageDialog(this,msg,title,icon);
	}
	public void showMessage(Object obj,String title,int icon)
	{
		dialog.showMessageDialog(this,obj,title,icon);
	}
	public void showMessage(String s,String a)
	{
		
	}
	public void selectUI(int ui)
	{
		/*
		 * 1 for motif
		 * 2 for metal
		 * 3 for windows
		 * 4 for win classic
		 */
		try{
			if(ui==1){
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				SwingUtilities.updateComponentTreeUI(this);
			}
			else if(ui==2){
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				SwingUtilities.updateComponentTreeUI(this);
			}
			else if(ui==3){
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				SwingUtilities.updateComponentTreeUI(this);
			}
			else{
				UIManager.setLookAndFeel("javax.swing.plaf.GTK.GTKLookAndFeel");
				SwingUtilities.updateComponentTreeUI(this);
			}
				
		}
		catch(Exception ex)
		{
			showMessage("Error",ex.getMessage()+"\nClass not found\n"+
			"\n LookAndFeel set to System Default",ERROR);
			txtError.append("Error : "+ex.getMessage()+"\n");
			try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
			}
			catch(Exception ex2)
			{
				JOptionPane.showMessageDialog(this,"Error","Error : SystemDefaultLookAndFeel class was not found"
				,JOptionPane.ERROR_MESSAGE);
				txtError.append("Error : "+ex2.getMessage()+"\n");
			}
		}
	}
	private class MenuDriven implements ActionListener,ItemListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==m_Login||e.getSource()==tm_Login)
			{
				txtAreaLog.setText("Log system activated !\n");
				txtError.setText("Error collection system activated !\n");
				myDb.executeQuery("select text as greeting from greeting");
				
				admin.setVisible(false);
   				enr.setVisible(false);
   				addstu.setVisible(false);
   				rmstu.setVisible(false); 
   				addUser.setVisible(false);	
   				delUser.setVisible(false);
   				adAdmin.setVisible(false);
   				chPass.setVisible(false);
   							
   				try
   				{
   					m_QueryForm.setSelected(false);
   					m_Enroll.setSelected(false);
   					m_addStu.setSelected(false);
   					m_removeStu.setSelected(false);
   					m_CPass_S.setSelected(false);
   					m_CPass_O.setSelected(false);
   					m_CPass_T.setSelected(false);
   					m_CPass_A.setSelected(false);
   					m_AdUser.setSelected(false);
   					m_DelUser.setSelected(false);
   					m_AdAdmin.setSelected(false);
   					
				}
				catch(Exception ex){
					System.out.println(ex);
					txtError.append("Error : "+ex.getMessage()+"\n");
				}
				
				University.hideMainGui();
				myLogin.showFrame();
			}
			if(e.getSource()==m_Logout||e.getSource()==tm_Logout)
			{
				txtAreaLog.setText("Log system activated !\n");
				txtError.setText("Error collection system activated !\n");
				myDb.executeQuery("select text as greeting from greeting");
				
				admin.setVisible(false);
   				enr.setVisible(false);
   				addstu.setVisible(false);
   				rmstu.setVisible(false);
   				try
   				{
   					admin.setSelected(false);
   					enr.setSelected(false);
   					addstu.setSelected(false);
   					rmstu.setSelected(false);
				}
				catch(Exception ex)
				{
					txtError.append("Error : "+ex.getMessage()+"\n");
				}
				
				University.hideMainGui();
				myLogin.showFrame();
			}
			if(e.getSource()==m_SearchDiag)
			{	
				txtAreaLog.append("open search dialog\n");
				activateSearchDialog();
			}
			
			
			//Student *******

			if(e.getSource()==m_CheckGrade1)//specify term
			{	
				String year=dialog.showInputDialog("Academic Year (Ex. 2547)");
				String term=dialog.showInputDialog("Term (Ex. 1 or 2 )");
				sql="select sub.sub_id as ID,sub.sub_name as Name,sub.credit"
				+",en.grade,op.semester,op.year"
				+" from subject sub,enrollment en,open_subject op"
				+" where en.open_id=op.open_id and op.sub_id=sub.sub_id and "
				+"en.stu_id='"+MyVar.userName+"' and op.semester='"+term+"' and op.year='"+year+"'"
				+"and en.grade is not null"; 
				myDb.executeQuery(sql);
				
				txtAreaLog.append("checkgrade by term\n");
			}
			if(e.getSource()==m_CheckGrade2)
			{	
				sql="select sub.sub_id as ID,sub.sub_name as Name,sub.credit"
				+",en.grade,op.semester,op.year"
				+" from subject sub,enrollment en,open_subject op"
				+" where en.open_id=op.open_id and op.sub_id=sub.sub_id and "
				+"en.stu_id='"+MyVar.userName+"' and en.grade is not null";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("checkgrade all term\n");
			}
			if(e.getSource()==m_RegedSub)//(require term,academic,stu_id)
			{	
				sql="select op.sub_id as SubjectID,sub.sub_name as Name,sub.Credit"
				+" from enrollment en,subject sub,open_subject op"
				+" where en.open_id=op.open_id and op.sub_id=sub.sub_id"
				+" and en.stu_id='"+MyVar.userName+"' and op.semester='"+MyVar.term
				+"' and op.year='"+MyVar.year+"'";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show registered subject\n");
			}
			
			if(e.getSource()==m_TimeTable_S)//(require stu_id,semester,year)
			{	
				sql="select sub.sub_id,sub.sub_name,t.day,t.time,t.room"
				+" from subject sub,subject_time_table t,enrollment e,open_subject op"
				+" where e.stu_id='"+MyVar.userName+"' and t.open_id=e.open_id and"
				+" op.open_id=e.open_id and op.sub_id=sub.sub_id and"
				+" op.semester='"+MyVar.term+"' and op.year='"+MyVar.year+"'";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show time table\n");
			}
			if(e.getSource()==m_AvailSub_S)
			{	
				sql="select op.open_id as ID,op.sub_id as SubjectID"
				+",sub.sub_name as Name,sub.Credit,d.date_test as Exam"
				+" from open_subject op,subject sub,open_date d"
				+" where op.sub_id=sub.sub_id and op.open_id=d.open_id";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show available subject\n");
			}
			if(e.getSource()==m_AllSub_S)
			{	
				sql="select sub.sub_id as ID,sub.sub_name as Name,"
				+"sub.credit,w.workunit_name as Department"
				+" from subject sub,workunit w"
				+" where w.workunit_id=sub.workunit_id";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show all subject\n");
			}
			if(e.getSource()==m_ChkStatus_S)//(require stu_id)
			{	
				sql="select st.stu_id as ID,st.f_name as Firstname,st.l_name as Lastname"
				+",st.Gender,st.Dob as Birthday,st.Address,w.workunit_name as Department"
				+" from student st,workunit w"
				+" where st.workunit_id=w.workunit_id and st.stu_id='"+MyVar.userName+"'";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show my profile\n");
			}
			//**********************
			
			//Teacher ******************

			if(e.getSource()==m_TimeTable)//(require staff_id,semester,year)
			{	
				sql="select sub.sub_id as SubjectID,sub.sub_name as Subject"
				+",t.Day,t.Time,t.Room"
				+" from subject sub,subject_time_table t,teacher_table te,open_subject op"
				+" where te.staff_id='"+MyVar.userName+"' and te.open_id=t.open_id and"
				+" te.open_id=op.open_id and op.sub_id=sub.sub_id and"
				+" op.semester='"+MyVar.term+"' and op.year='"+MyVar.year+"'";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show teacher time table\n");
			}
			if(e.getSource()==m_StuClass)//(require [sub_id],semester,year)
			{	
				String mesg="Please enter subject ID for classifying\n"
				+"student group or leave this blank for showing\n"
				+"all student in your class";
				String sub_id=dialog.showInputDialog(mesg);
				if(sub_id.equals(""))
				{
					sql="select st.stu_id as StudentID,st.f_name as Firstname,st.l_name as Lastname,w.workunit_name as Department"
					+" from teacher_table t,enrollment e,student  st,workunit w"
					+" where t.staff_id='"+MyVar.userName+"' and t.open_id=e.open_id"
					+" and e.stu_id=st.stu_id and st.workunit_id=w.workunit_id and t.open_id in"
					+"(select open_id from open_Subject where semester='"+MyVar.term
					+"' and year='"+MyVar.year+"')";
					myDb.executeQuery(sql);	
				} 
				else
				{sql="select st.stu_id as StudentID,st.f_name as Firstname,st.l_name as Lastname,w.workunit_name as Department"
					+" from teacher_table t,enrollment e,student  st,workunit w"
					+" where t.staff_id='"+MyVar.userName+"' and t.open_id=e.open_id"
					+" and e.stu_id=st.stu_id and st.workunit_id=w.workunit_id and t.open_id in"
					+"(select open_id from open_Subject where semester='"+MyVar.term
					+"' and year='"+MyVar.year+"' and sub_id='"+sub_id+"')";
					myDb.executeQuery(sql);
				}
				txtAreaLog.append("show student in your class\n");
			}
			if(e.getSource()==m_AvailSub_T)//
			{	
				sql="select op.open_id as ID,op.sub_id as SubjectID"
				+",sub.sub_name as Name,sub.Credit,d.date_test as Exam"
				+" from open_subject op,subject sub,open_date d"
				+" where op.sub_id=sub.sub_id and op.open_id=d.open_id";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show available subject\n");
			}
			if(e.getSource()==m_AllSub_T)
			{	
				sql="select sub.sub_id as ID,sub.sub_name as Name,"
				+"sub.credit,w.workunit_name as Department"
				+" from subject sub,workunit w"
				+" where w.workunit_id=sub.workunit_id";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show all subject\n");

			}
			if(e.getSource()==m_ChkStatus_T)//(require staff_id)
			{	
				sql="select s.staff_id as ID,s.f_name as Firstname"
				+",s.l_name as Lastname,s.Gender,s.dob as Birthday,s.Address"
				+",s.Class,s.Salary,w.workunit_name as WorkAt"
				+" from staff s,workunit w"
				+" where s.workunit_id=w.workunit_id and s.staff_id='"+MyVar.userName+"'";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show my profile\n");
			}
			if(e.getSource()==m_WorkUnit_T)
			{	
				sql="select workunit_id as ID,workunit_name as WorkUnit,Location"
				+" from workunit";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show all workunit\n");
			}
			//*******************************
			
			//Officer ***********************
			if(e.getSource()==m_ShowAllStudent)
			{
				myDb.executeQuery("select *from student");
			}
			if(e.getSource()==m_DropSub||e.getSource()==tm_Drop)//(require stu_id,sub_id,year,semester)
			{	
				//Year and Term obtain from Variable in MyVar class
				String stu_id=dialog.showInputDialog("Please enter student's ID");
				String sub_id=dialog.showInputDialog("And Subject's ID");
				sql="update enrollment set grade='W'"
				+" where stu_id='"+stu_id+"' and open_id in" 
				+"(select open_id from open_subject"
				+" where sub_id='"+sub_id+"' and year='"+MyVar.year+"' and semester='"+MyVar.term+"')";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("drop subject\n");
			}
			if(e.getSource()==m_GiveGrade)//(require stu_id,sub_id,year,semester,grade)
			{	
				String stu_id=dialog.showInputDialog("Please enter student's ID");
				String sub_id=dialog.showInputDialog("And Subject's ID");
				String grade=dialog.showInputDialog("And Subject's ID");
				//Year and Term obtain from Variable in MyVar class
				sql="update enrollment set grade='"+grade+"'"
				+" where stu_id='"+stu_id+"' and open_id in" 
				+"(select open_id from open_subject"
				+" where sub_id='"+sub_id+"' and year='"+MyVar.year+"' and semester='"+MyVar.term+"')";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("give a grade\n");
			}
			if(e.getSource()==m_AllDivision)//
			{	
				sql="select d.workunit_id as ID,w.workunit_name as Division,d.Duty"
				+" from workunit w,division d"
				+" where d.workunit_id=w.workunit_id";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show all division\n");
			}
			if(e.getSource()==m_AvailSub_O||e.getSource()==tm_AvSubject)//
			{	
				sql="select op.open_id as ID,op.sub_id as SubjectID"
				+",sub.sub_name as Name,sub.Credit,d.date_test as Exam"
				+" from open_subject op,subject sub,open_date d"
				+" where op.sub_id=sub.sub_id and op.open_id=d.open_id";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show available subject\n");
			}
			if(e.getSource()==m_AllSub_O||e.getSource()==tm_AllSubject)//
			{	
				sql="select sub.sub_id as ID,sub.sub_name as Name,"
				+"sub.credit,w.workunit_name as Department"
				+" from subject sub,workunit w"
				+" where w.workunit_id=sub.workunit_id";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show all subject\n");
			}
			if(e.getSource()==m_ChkStatus_O)//*
			{	
				sql="select s.staff_id as ID,s.f_name as Firstname"
				+",s.l_name as Lastname,s.Gender,s.dob as Birthday,s.Address"
				+",s.Class,s.Salary,w.workunit_name as WorkAt"
				+" from staff s,workunit w"
				+" where s.workunit_id=w.workunit_id and s.staff_id='"+MyVar.userName+"'";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show my profile\n");
			}
			if(e.getSource()==m_WorkUnit_O)//*
			{	
				sql="select workunit_id as ID,workunit_name as WorkUnit,Location"
				+" from workunit";
				myDb.executeQuery(sql);
				
				txtAreaLog.append("show all workunit\n");
			}
			
			//*********************************	
			
			//Toolbar***************************	
			if(e.getSource()==tm_ChkGrade)
			{
				if((dialog.showConfirmDialog(null,"Do you want to see all term result?"
				,"Check Grade",JOptionPane.YES_NO_OPTION))==JOptionPane.OK_OPTION)
				{
					sql="select sub.sub_id as ID,sub.sub_name as Name,sub.credit"
					+",en.grade,op.semester,op.year"
					+" from subject sub,enrollment en,open_subject op"
					+" where en.open_id=op.open_id and op.sub_id=sub.sub_id and "
					+"en.stu_id='"+MyVar.userName+"'";
					myDb.executeQuery(sql);
				}
				else
				{
					String year=dialog.showInputDialog("Academic Year (Ex. 2547)");
					String term=dialog.showInputDialog("Term (Ex. 1 or 2 )");
					sql="select sub.sub_id as ID,sub.sub_name as Name,sub.credit"
					+",en.grade,op.semester,op.year"
					+" from subject sub,enrollment en,open_subject op"
					+" where en.open_id=op.open_id and op.sub_id=sub.sub_id and "
					+"en.stu_id='"+MyVar.userName+"' and op.semester='"+term+"' and op.year='"+year+"'"; 
					myDb.executeQuery(sql);
				}
				txtAreaLog.append("student checkgrade\n");
				
			}
		
			if(e.getSource()==tm_ChkStatus)
			{
				if(MyVar.status==0) //student
				{
					sql="select st.stu_id as ID,st.f_name as Firstname,st.l_name as Lastname"
					+",st.Gender,st.Dob as Birthday,st.Address,w.workunit_name as Department"
					+" from student st,workunit w"
					+" where st.workunit_id=w.workunit_id and st.stu_id='"+MyVar.userName+"'";
					myDb.executeQuery(sql);
				}
				else 
				{
					sql="select s.staff_id as ID,s.f_name as Firstname"
					+",s.l_name as Lastname,s.Gender,s.dob as Birthday,s.Address"
					+",s.Class,s.Salary,w.workunit_name as WorkAt"
					+" from staff s,workunit w"
					+" where s.workunit_id=w.workunit_id and s.staff_id='"+MyVar.userName+"'";
					myDb.executeQuery(sql);
				}
				
				txtAreaLog.append("show my profile\n");
			}
			if(e.getSource()==tm_About)
			{
				aboutDialog();
			}
			if(e.getSource()==tm_Search)
			{	
				activateSearchDialog();
			}
			//*********************************
			if(e.getSource()==m_Help)
			{
				showMessage("No help system installed","Help",INFO);;
			}
				
			if(e.getSource()==m_FeedBack)
			{
				showMessage("Mail to: SuberHus@yahoo.com","Feedback",INFO);
			}
				
			if(e.getSource()==m_About)
			{
				aboutDialog();
				
			}
		}
		public void aboutDialog()
		{
				JTabbedPane myTb=new JTabbedPane();
				JTextArea license=new JTextArea(8,50);
				fh.loadFile("doc","license",license);
				JPanel panel=new JPanel();
				JTextArea txtArea=new JTextArea(8,50);
				fh.loadFile("doc","about",txtArea);
				Icon img=new ImageIcon("img"+sep+"spring.gif");
				JLabel label=new JLabel(img);
				panel.setLayout(new BorderLayout());
				panel.add(myTb,"South");
				panel.add(label,"North");
				myTb.addTab("Author",new JScrollPane(txtArea));
				myTb.addTab("License",new JScrollPane(license));
				showMessage(panel,"About",INFO);
		}
		public void itemStateChanged(ItemEvent e)
		{
			if(e.getSource()==m_ShLog)
			{
				if(m_ShLog.isSelected())
				{
					internalLog.setVisible(true);
					internalLog.toFront();
				}
				else
					internalLog.setVisible(false); 	
				
			}
			if(e.getSource()==m_ShStatusBar)
			{
				if(m_ShStatusBar.isSelected())
				{
					toolbar.setVisible(true);
				}
				else
					toolbar.setVisible(false); 	
			}
			if(e.getSource()==m_ShUserInfo)
			{
				if(m_ShUserInfo.isSelected())
				{
					internalUserInfo.setVisible(true);
					internalUserInfo.toFront();
				}
				else
					internalUserInfo.setVisible(false); 	
			}
			if(e.getSource()==m_ShResult)
			{
				if(m_ShResult.isSelected())
				{
					internalResult.setVisible(true);
					internalResult.toFront();
				}
				else
					internalResult.setVisible(false); 		
			}
			if(e.getSource()==m_Enroll||e.getSource()==tm_Enroll)
			{
				if(m_Enroll.isSelected())
				{
					enr.setVisible(true);
					enr.tab.setSelectedIndex(0);
					enr.tab.setEnabledAt(1,false);
					enr.tab.setEnabledAt(2,false);
					enr.tab.setEnabledAt(3,false);
				}
				else
				{	
					enr.setVisible(false);
				
				}
			}
			if(e.getSource()==m_addStu)
			{
				if(m_addStu.isSelected())
				{
					addstu.setVisible(true);
				}
				else
					addstu.setVisible(false);
			}
			if(e.getSource()==m_removeStu)
			{
				if(m_removeStu.isSelected())
				{
					rmstu.setVisible(true);
				}
				else
					rmstu.setVisible(false);
			}
			
			if(e.getSource()==m_QueryForm)
			{
				if(m_QueryForm.isSelected())
				{
					admin.setVisible(true);
				}
				else
					admin.setVisible(false);
			}
			////////////////////////////////////////////////////////
			if(e.getSource()==m_CPass_S)
			{
				if(m_CPass_S.isSelected())
				{
					chPass.setVisible(true);
				}
				else
					chPass.setVisible(false);
			}
			if(e.getSource()==m_CPass_T)
			{
				if(m_CPass_T.isSelected())
				{
					chPass.setVisible(true);
				}
				else
					chPass.setVisible(false);
			}
			if(e.getSource()==m_CPass_O)
			{
				if(m_CPass_O.isSelected())
				{
					chPass.setVisible(true);
				}
				else
					chPass.setVisible(false);
			}
			if(e.getSource()==m_AdUser)
			{
				if(m_AdUser.isSelected())
				{
					addUser.setVisible(true);
				}
				else
					addUser.setVisible(false);
			}
			if(e.getSource()==m_DelUser)
			{
				if(m_DelUser.isSelected())
				{
					delUser.setVisible(true);
				}
				else
					delUser.setVisible(false);
			}
			if(e.getSource()==m_CPass_A)
			{
				if(m_CPass_A.isSelected())
				{
					chPass.setVisible(true);
				}
				else
					chPass.setVisible(false);
			}
			if(e.getSource()==m_AdAdmin)
			{
				if(m_AdAdmin.isSelected())
				{
					adAdmin.setVisible(true);
				}
				else
					adAdmin.setVisible(false);
			}
			///////////////////////////////////////////////////////
			
			
			
			if(m_Motif.isSelected())
				selectUI(1);
			if(m_Metal.isSelected())
				selectUI(2);
			if(m_Windows.isSelected())
				selectUI(3);
			if(m_GTK.isSelected())
				selectUI(4);	
			
		}
		
	}
}
class MyException extends Exception
{
	public MyException()
	{
		super("Exception Occure");
	}
}