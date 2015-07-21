import javax.swing.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.plaf.metal.*;
import java.sql.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.table.*;
class StudentInfo extends JFrame
{
	JPanel main;
	Container c=getContentPane();
	private JComboBox appyrst;
	private JComboBox appyred;
	private JTextField scode;
	private JTextField sname;
	private JTextField mname;
	private JTextField lname;
	private JTextArea addfield1;
	private JComboBox courselist;
	JComboBox joindateday;
	JComboBox joindatemon;
	JComboBox joindateyear;
	private JTextField mobno;
	private JTextField totalfees;
	private JTextField paidfees;
	private JTextField addfees;
	private JTextField remainfees;
	private JButton createcourse;
	private JButton New;
	private JButton save;
	private JButton modify;
	private JButton remove;
	private JButton exit;
	private JTable table;
	boolean therty=false;
	boolean twentynine=false;
	boolean twentyeight=false;
	CourseAddition cr=new CourseAddition();
	String coursename;
	TextValid onlyText;
	NumberValid onlyNumber;
	JMenuBar mbar;
	Connection conn;
	Statement st;
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;
	JMenu studs_Archieves,query_menu,view_menu,file_menu,registration_menu,setting_menu,reports_menu,help_menu;
	JMenu showStudentMenu;
	JMenuItem studentMasterList_Archieves,staff_item,marks_item,schedule_item,guest_item,classlist_item,classmaster_list_item;
	JMenu faculty_master_menu;
	JMenuItem faculty_master_item;
	JMenuItem about_item;
	JMenuItem administrative_item;

	JMenuItem signout_item,exit_item;
	JMenuItem studentmaster_item;
	JMenuItem facultyloading_item;

	JMenuItem guest_report_item,courseItem;
	JMenuItem Class_Schedules_Archieves,student_masterList,faculty_masterList,course_masterList,studentMasterRecord;

	JMenuItem course_detailsItem;
	JMenuItem course_item,staffentry_item,room_item,grade_item,reamain_fees_item;
	JMenuItem short_term_courses_item;

	JMenuItem by_YearLevel,stud_contact,search_stud,calcy,caln,by_EnrollmentStatus;
	String StrBusinessTitle;
   	JLabel BusinessTitleLabel = new JLabel();
   	StudentInfoHandler h=new StudentInfoHandler();
   	CourseInfoHandler ch=new CourseInfoHandler();
   	int height;
   	int width;
   	Dimension screenSize;
	StudentInfo()
	{
		Toolkit kits=Toolkit.getDefaultToolkit();
		screenSize=kits.getScreenSize();
		width=screenSize.width/2;
		height=screenSize.height/2;
		setSize(width+180,height+260);
		setTitle("Student Information");
		setLocation(screenSize.width/6,20);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
				cr.dispose();
				new MainMenuFrame().setVisible(true);
			}
		});
		StudentInfo.setDefaultLookAndFeelDecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
		main=new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				Toolkit kit=Toolkit.getDefaultToolkit();
				Image img=kit.getImage("plain.jpg");
				MediaTracker t=new MediaTracker(this);
				t.addImage(img,1);
				while(true)
				{
					try
					{
						t.waitForID(1);
						break;
					}
					catch(Exception e)
					{
					}
				}
				g.drawImage(img,0,0,width+180,height+260,null);
			}
		};
		main.setLayout(new GridBagLayout());
		main.setBackground(new Color(245,240,255));

		onlyText=new TextValid();
		onlyNumber=new NumberValid();
		createcourse = new JButton("Add New Course");
		appyrst=new JComboBox();
		appyrst.setToolTipText("Select apperaed year");
		appyrst.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		appyred=new JComboBox();
		appyred.setToolTipText("Select apperaed year");
		appyred.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		scode=new JTextField(10);
		scode.setToolTipText("Student Code");
		scode.setEditable(false);
		scode.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		sname=new JTextField(20);
		sname.addKeyListener(onlyText);
		sname.setToolTipText("Enter Student Name");
		sname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		mname=new JTextField(20);
		mname.addKeyListener(onlyText);
		mname.setToolTipText("Enter Student's Parent Name");
		mname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		lname=new JTextField(20);
		lname.addKeyListener(onlyText);
		lname.setToolTipText("Enter Student's Last Name");
		lname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		addfield1=new JTextArea(2,20);
		addfield1.setToolTipText("Enter Student's Address");
		addfield1.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		addfield1.setWrapStyleWord(true);
		addfield1.setLineWrap(true);
		JScrollPane addfield=new JScrollPane(addfield1);
		courselist=new JComboBox();
		courselist.setFont(new Font("serif",Font.BOLD,12));
		courselist.setToolTipText("Select The Course");
		courselist.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		courselist.setEditable(false);
		courselist.setMaximumRowCount(5);
		joindateday=new JComboBox();
		joindateday.setToolTipText("Select  Day");
		joindateday.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		joindatemon=new JComboBox(new String[]{"Jan ","Feb ","Mar ","Apr ","May ","June","July","Aug ","Sept","Oct ","Nov ","Desc"});
		joindatemon.setToolTipText("Select  Month");
		joindatemon.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		joindateyear=new JComboBox();
		joindateyear.setToolTipText("Select  Year");
		joindateyear.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		mobno=new JTextField(14);
		mobno.addKeyListener(onlyNumber);
		mobno.setToolTipText("Enter Mobile Number ");
		mobno.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
		mobno.setSelectionColor(Color.blue);
		mobno.setDisabledTextColor(Color.red);
		mobno.setCaretColor(Color.green);
		mobno.setSelectionColor(Color.pink);
		mobno.setFont(new Font("verdana", Font.BOLD, 12));
		totalfees=new JTextField(8);
		totalfees.setEditable(false);
		totalfees.setToolTipText("Enter the Total Fees of Course");
		totalfees.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		paidfees=new JTextField(8);
		paidfees.addKeyListener(onlyNumber);
		paidfees.setToolTipText("Enter the Recived Fees From Student");
		paidfees.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		addfees=new JTextField(8);
		addfees.addKeyListener(onlyNumber);
		addfees.setToolTipText("Enter the Addition Fees of Course \n e.g. Late Fees , Subject backlog Fees , Fine of Liabrary");
		addfees.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		remainfees=new JTextField(8);
		remainfees.setToolTipText("Total Fees Remaining of Student");
		remainfees.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
		remainfees.setEditable(false);
		New=new JButton("New");
		New.setToolTipText("Add New Entry");
		save=new JButton("Save");
		save.setToolTipText("Save The Entry of Student");
		modify=new JButton("Modify");
		modify.setToolTipText("Modify the Entry");
		remove=new JButton("Remove");
		remove.setToolTipText("Remove The Student Entry");
		exit=new JButton("Exit");
		exit.setToolTipText("Close Student Information Form");
		mbar=new JMenuBar();
     	setJMenuBar(mbar);

		file_menu=new JMenu("File");
     	file_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
       	file_menu.setMnemonic('F');

     	registration_menu=new JMenu("Registration");
     	registration_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	registration_menu.setMnemonic('n');

     	setting_menu=new JMenu("System");
     	setting_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        setting_menu.setMnemonic('s');

     	view_menu=new JMenu("List");
     	view_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        view_menu.setMnemonic('i');


     	help_menu=new JMenu("Help");
     	help_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
        help_menu.setMnemonic('H');


     	reports_menu=new JMenu("Query");
     	reports_menu.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	reports_menu.setMnemonic('e');

     	//---JMenuItem
     	about_item=new JMenuItem("About Software?");
     	about_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	about_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		about_item.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("mainicon.png")));
		about_item.addActionListener(h);




     	signout_item=new JMenuItem("Sign Out");
     	signout_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	signout_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		signout_item.setIcon(new ImageIcon("lockapplication.png"));
		signout_item.addActionListener(h);

		exit_item=new JMenuItem("Exit");
     	exit_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
     	exit_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		exit_item.setIcon(new ImageIcon("EXIT.PNG"));
		exit_item.addActionListener(h);

		studentmaster_item=new JMenuItem("Current Semester & School Year");//enrollment master file
		studentmaster_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		studentmaster_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        studentmaster_item.setIcon(new ImageIcon("RESET.PNG"));
		//studentmaster_item.addActionListener(this);


		studentMasterList_Archieves=new JMenuItem("Student Archieves");//enrollment master file
		studentMasterList_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
		studentMasterList_Archieves.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        studentMasterList_Archieves.setIcon(new ImageIcon("SUPPLIER.PNG"));
		//studentMasterList_Archieves.addActionListener(this);



		schedule_item=new JMenuItem("Class Schedules");
		schedule_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		schedule_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
        schedule_item.setIcon(new ImageIcon("RESET.png"));
		//schedule_item.addActionListener(this);

        course_item=new JMenuItem("Course/Program");
        course_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		course_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        course_item.setIcon(new ImageIcon("customer.png"));
		course_item.addActionListener(h);

	    marks_item=new JMenuItem("Internal Marks");
        marks_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		marks_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        marks_item.setIcon(new ImageIcon("delete.png"));
		marks_item.addActionListener(h);

		room_item=new JMenuItem("Room Master");
		room_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		room_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        room_item.setIcon(new ImageIcon("purchaseorder.png"));
		//room_item.addActionListener(this);

		staff_item=new JMenuItem("Staff Report");
		staff_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staff_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        staff_item.setIcon(new ImageIcon("purchaseorder.png"));
		staff_item.addActionListener(h);

		studentMasterRecord=new JMenuItem("Student Master Record");
		studentMasterRecord.setFont(new Font("Times New Roman",Font.PLAIN,13));
		studentMasterRecord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        studentMasterRecord.setIcon(new ImageIcon("SalesRep.png"));
		//studentMasterRecord.addActionListener(this);

		staffentry_item=new JMenuItem("Staff Information");
		staffentry_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		staffentry_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        staffentry_item.setIcon(new ImageIcon("RECIEVE.png"));
		staffentry_item.addActionListener(h);

		administrative_item=new JMenuItem("User Accounts");
		administrative_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		administrative_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        administrative_item.setIcon(new ImageIcon("SalesRep.png"));
		administrative_item.addActionListener(h);

		grade_item=new JMenuItem("Student Academic Report");
		grade_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		grade_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        grade_item.setIcon(new ImageIcon("SEARCH.png"));
		//grade_item.addActionListener(this);

		reamain_fees_item=new JMenuItem("Remainning Fees");
		reamain_fees_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		reamain_fees_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        reamain_fees_item.setIcon(new ImageIcon("newinvoice.png"));
		reamain_fees_item.addActionListener(h);

		guest_item=new JMenuItem("Guest Information");
		guest_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
		guest_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        guest_item.setIcon(new ImageIcon("EXPENSE.PNG"));
		guest_item.addActionListener(h);

    	showStudentMenu=new JMenu("Query Student");
		showStudentMenu.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    showStudentMenu.setIcon(new ImageIcon("categories.png"));

     	//short_term_courses_item=new JMenuItem("Short Term Courses");
	//	short_term_courses_item.setFont(new Font("Verdana",Font.PLAIN,13));
	//	short_term_courses_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
    //    short_term_courses_item.setIcon(new ImageIcon("newrecieve.png"));
//		short_term_courses_item.addActionListener(this);

	    student_masterList=new JMenuItem("Students");
	    student_masterList.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    student_masterList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
	    student_masterList.addActionListener(h);
	    student_masterList.setIcon(new ImageIcon("CUSTOMER.PNG"));

	    course_detailsItem=new JMenuItem("Course Details");
	    course_detailsItem.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    course_detailsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
	    course_detailsItem.setIcon(new ImageIcon("EXPENSE.PNG"));
		course_detailsItem.addActionListener(h);

	    courseItem=new JMenuItem("Student by Course");
	    courseItem.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    courseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    courseItem.setIcon(new ImageIcon("newrecieve.png"));
	    courseItem.addActionListener(h);

	   guest_report_item=new JMenuItem("Guest Report");
	    guest_report_item.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    guest_report_item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
	    guest_report_item.setIcon(new ImageIcon("newrecieve.png"));
	    guest_report_item.addActionListener(h);

	    stud_contact=new JMenuItem("Student Contact");
		stud_contact.setFont(new Font("Times New Roman",Font.PLAIN,13));
		stud_contact.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		stud_contact.setIcon(new ImageIcon("EXPENSE.PNG"));
		stud_contact.addActionListener(h);

		search_stud=new JMenuItem("Search Student");
		search_stud.setFont(new Font("Times New Roman",Font.PLAIN,13));
		search_stud.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		search_stud.setIcon(new ImageIcon("SEARCH.png"));
		search_stud.addActionListener(h);

		calcy=new JMenuItem("Calculator");
		calcy.setFont(new Font("Times New Roman",Font.PLAIN,13));
		calcy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		calcy.setIcon(new ImageIcon("newrecieve.png"));
		calcy.addActionListener(h);


		caln=new JMenuItem("Calendar");
		caln.setFont(new Font("Times New Roman",Font.PLAIN,13));
		caln.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		caln.setIcon(new ImageIcon("purchaseorder.png"));
	    caln.addActionListener(h);

	    by_EnrollmentStatus=new JMenuItem("Query Student by Enrollment Status");
	    by_EnrollmentStatus.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    by_EnrollmentStatus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
	    by_EnrollmentStatus.setIcon(new ImageIcon("SEARCH.png"));
	    //by_EnrollmentStatus.addActionListener(this);

	    studs_Archieves=new JMenu("Student Enrollment File");
	    studs_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
	    studs_Archieves.setIcon(new ImageIcon("EXPENSE.PNG"));

	    Class_Schedules_Archieves=new JMenuItem("Class Schedules Archieves");
	    Class_Schedules_Archieves.setFont(new Font("Times New Roman",Font.PLAIN,13));
        Class_Schedules_Archieves.setIcon(new ImageIcon("EXPENSE.PNG"));
	    //Class_Schedules_Archieves.addActionListener(this);


     	//---Add to JMenu
     	file_menu.add(signout_item);
     	file_menu.addSeparator();
        file_menu.add(exit_item);

        //studs_Archieves.add(studentmaster_item);
        //studs_Archieves.addSeparator();
        //studs_Archieves.add(studentMasterList_Archieves);
        //studs_Archieves.addSeparator();
        //studs_Archieves.add(Class_Schedules_Archieves);

        //registration_menu.add(studs_Archieves);
        //registration_menu.addSeparator();
        //registration_menu.add(studentMasterRecord);
        //registration_menu.add(schedule_item);
        //registration_menu.addSeparator();
        registration_menu.add(course_item);
        registration_menu.addSeparator();
        registration_menu.add(marks_item);
        registration_menu.addSeparator();
        //registration_menu.add(room_item);
        //registration_menu.addSeparator();
        registration_menu.add(staffentry_item);
        registration_menu.addSeparator();
        registration_menu.add(guest_item);
        //registration_menu.addSeparator();
        //registration_menu.add(grade_item);
     //   registration_menu.addSeparator();
      //  registration_menu.add(short_term_courses_item);


        reports_menu.add(courseItem);
		reports_menu.addSeparator();
		reports_menu.add(course_detailsItem);
		reports_menu.addSeparator();
		reports_menu.add(reamain_fees_item);
		reports_menu.addSeparator();
		reports_menu.add(staff_item);
		reports_menu.addSeparator();
		reports_menu.add(guest_report_item);
		reports_menu.addSeparator();
		reports_menu.add(stud_contact);
		reports_menu.addSeparator();
		reports_menu.add(search_stud);
	   // reports_menu.addSeparator();
	   // reports_menu.add(by_Birthdate);
	   // reports_menu.addSeparator();
	   // reports_menu.add(by_Faculty_Load);
	   // reports_menu.addSeparator();
       // reports_menu.add(by_EnrollmentStatus);

        view_menu.add(student_masterList);
       // query_menu.add(query_builderItem);

        setting_menu.add(administrative_item);
		setting_menu.addSeparator();
		setting_menu.add(calcy);
		setting_menu.addSeparator();
       	setting_menu.add(caln);

        help_menu.add(about_item);

        //reports_menu.add(facultyloading_item);
     	//---Add to JMenuBar
     	mbar.add(file_menu);
     	mbar.add(registration_menu);
        mbar.add(reports_menu);
        mbar.add(view_menu);
        mbar.add(setting_menu);
        mbar.add(help_menu);
        Icon img1=new ImageIcon("ICON1.JPG");

        btn1=new JButton();
        btn1.setIcon(img1);
       	btn1.addActionListener(h);
        btn1.setToolTipText("New Student Entry");

        //StrBusinessTitle = "AMIS Software Copyright (C) 2006";
        BusinessTitleLabel.setText(StrBusinessTitle);
		BusinessTitleLabel.setFont(new Font("Verdana",Font.PLAIN,12));
		BusinessTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        Icon img2=new ImageIcon("ICON2.JPG");
        btn2=new JButton();
        btn2.setIcon(img2);
		btn2.setToolTipText("Search Student Entry");
		btn2.addActionListener(h);

        Icon img3=new ImageIcon("ICON3.JPG");
        btn3=new JButton();
        btn3.setIcon(img3);
        btn3.setToolTipText("Modify Student Entry");
		btn3.addActionListener(h);

        Icon img4=new ImageIcon("ICON4.JPG");
        btn4=new JButton();
        btn4.setIcon(img4);
		btn4.setToolTipText("Remove Student Entry");
		btn4.addActionListener(h);

        Icon img5=new ImageIcon("ICON5.JPG");
        btn5=new JButton();
        btn5.setToolTipText("Sign Out");
        btn5.setIcon(img5);
		btn5.addActionListener(h);

        Icon img6=new ImageIcon("ICON6.JPG");
        btn6=new JButton();
        btn6.setIcon(img6);
		btn6.setToolTipText("Calculator");
        btn6.addActionListener(h);

        Icon img7=new ImageIcon("ICON7.JPG");
        btn7=new JButton();
        btn7.setIcon(img7);
        btn7.setToolTipText("Calendar");
        btn7.addActionListener(h);


        Icon img8=new ImageIcon("ICON8.JPG");
        btn8=new JButton();
        btn8.setIcon(img8);
        btn8.setToolTipText("Student Contact's");
		btn8.addActionListener(h);


        Icon img9=new ImageIcon("ICON9.JPG");
        btn9=new JButton();
        btn9.setToolTipText("Next Course");
        btn9.setIcon(img9);
        btn9.addActionListener(h);

        Icon img10=new ImageIcon("ICON10.JPG");
        btn10=new JButton();
        btn10.setIcon(img10);
		btn10.setToolTipText("Change Password");
		btn10.addActionListener(h);

        Icon img11=new ImageIcon("ICON11.JPG");
        btn11=new JButton();
        btn11.setIcon(img11);
        btn11.setToolTipText("Save Student Entry");
        btn11.addActionListener(h);

        JToolBar toolbar=new JToolBar("Tools");
        c.add(toolbar);
        toolbar.setBounds(10,6,800,40);
		toolbar.setRollover(true);
		toolbar.setFloatable(false);
        toolbar.add(btn1);
        toolbar.add(btn2);
        toolbar.add(btn3);
        toolbar.add(btn4);
        toolbar.add(btn5);
        toolbar.add(btn6);
        toolbar.add(btn7);
        toolbar.add(btn8);
        toolbar.add(btn9);
        toolbar.add(btn10);
        toolbar.add(btn11);

        toolbar.add(BusinessTitleLabel);
        int row=0;
		int i=0;

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
			st=conn.createStatement();
			ResultSet set=st.executeQuery("select * from course_name");
			ResultSet tableset;
			while(set.next())
			{
				courselist.addItem(set.getString(2));
			}
			String cours=(String)courselist.getSelectedItem();
			String day[]=new String[31];
			for(int p=0;p<31;p++)
			{
				day[p]=""+(p+1);
				joindateday.addItem(day[p]);
			}
			for(int y=1950;y<2100;y++)
			{
				joindateyear.addItem(Integer.toString(y));
				appyrst.addItem(Integer.toString(y));
			}
			joindateyear.setSelectedItem("2007");
			appyrst.setSelectedItem("2007");
			if(cours!=null)
			{
				int x=0;
				try
				{
					set=st.executeQuery("select * from course_name");
					String dur=null;
					while(set.next())
					{
						String cr=set.getString(2).trim();
						dur=set.getString(4).trim();
						if(cr.equals(cours))
							break;
					}
					if(dur.equals("Two Semester") || dur.equals("One Year"))
						x=1;
					else
					if(dur.equals("Four Semester") || dur.equals("Two Year"))
						x=2;
					else
					if(dur.equals("Six Semester") || dur.equals("Three Year"))
						x=3;
					else
					if(dur.equals("Eight Semester") || dur.equals("Four Year"))
						x=4;

					int y=Integer.parseInt((String)appyrst.getSelectedItem());
					y=y+x;
					appyred.addItem(Integer.toString(y));


				}
				catch(Exception ec)
				{
				}
			}
			if(cours!=null)
			{
				ResultSet feeinfo=st.executeQuery("select * from course_name");
				while(feeinfo.next())
				{
					if(cours.equals(feeinfo.getString(2)))
						break;
				}
				totalfees.setText(feeinfo.getString(3));
				DataInputStream sin=new DataInputStream(new FileInputStream(cours+"_id.dat"));
				scode.setText(sin.readUTF());
				paidfees.setText("0");
				addfees.setText("0");
				String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Last Name","Mobile No"},row);
				table=new JTable(model);
				ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{

					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(4).trim(),i,2);
					model.setValueAt(tableset.getString(7).trim(),i,3);
					i++;
				}
			}
		}
		catch(Exception ex)
		{
		}
		table.addMouseListener(new TableHandler());

		table.setToolTipText("Select the Student for more information");
		JScrollPane table1=new JScrollPane(table);
		table.doLayout();
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(1);
		table.setEditingColumn(3);
		table.setGridColor(Color.pink);
		table.setRowMargin(3);
		table.setSelectionBackground(new Color(194,253,254));
		table.setSelectionForeground(new Color(128,64,0));
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.getTableHeader().setReorderingAllowed(false);


		GridBagConstraints cons=new GridBagConstraints();
		cons.fill=GridBagConstraints.NONE;
		cons.anchor=GridBagConstraints.EAST;
		cons.weightx=10;
		cons.weighty=10;

		cons.insets = new Insets(10, 10, 5, 5);
		add(new JLabel(" "), cons, 0, 0, 1, 1);
		cons.insets = new Insets(0, 10, 5, 0);
		add(new JLabel("Student Code  : "),cons,0,2,1,1);
		add(new JLabel("Student Name  : "),cons,0,3,1,1);
		add(new JLabel("Parent name  : "),cons,0,4,1,1);
		add(new JLabel("Last Name  : "),cons,0,5,1,1);
		add(new JLabel("Address  : "),cons,0,6,1,2);
		add(new JLabel("Date Of Joining  : "),cons,0,8,1,1);
		add(new JLabel("Mobile No  : "),cons,0,10,1,1);
		add(new JLabel("Total Fees  : "),cons,0,11,1,1);
		add(new JLabel("Paid Fees  : "),cons,0,12,1,1);
		add(new JLabel("Addition Fees  : "),cons,0,13,1,1);
		add(new JLabel("Remaining Fees  : "),cons,0,14,1,1);
		cons.fill=GridBagConstraints.HORIZONTAL;
		cons.weightx = 80;
		cons.insets = new Insets(10, 5, 5, 5);
		Box cor = Box.createHorizontalBox();
		cor.add(new JLabel("Course  : "));
		cor.add(courselist);
		cor.add(Box.createGlue());
		cor.add(new JLabel("Appered Year"));
		cor.add(Box.createHorizontalStrut(5));
		cor.add(appyrst);
		cor.add(Box.createHorizontalStrut(5));
		cor.add(new JLabel("TO"));
		cor.add(Box.createHorizontalStrut(5));
		cor.add(appyred);
		add(cor, cons, 0, 1, 2, 1);

		cons.insets = new Insets(0, 10, 5, 40);
		add(scode, cons, 1, 2, 1, 1);
		cons.insets = new Insets(0, 10, 1, 40);
		add(sname,cons,1,3,1,1);
		add(mname,cons,1,4,1,1);
		add(lname,cons,1,5,1,1);
		cons.insets = new Insets(0, 10, 1, 200);
		cons.ipady = 20;
		add(addfield,cons,1,6,1,2);
		cons.ipady = 0;
		cons.insets = new Insets(0, 10, 5, 40);
		Box datebox=Box.createHorizontalBox();
		datebox.add(joindateday);
		datebox.add(Box.createHorizontalStrut(10));
		datebox.add(joindatemon);
		datebox.add(Box.createHorizontalStrut(10));
		datebox.add(joindateyear);
		datebox.add(Box.createGlue());
		add(datebox,cons,1,8,1,1);
		cons.insets=new Insets(0,10,5,315);
		cons.ipady = 5;
		add(mobno,cons,1,10,1,1);
		cons.ipady = 0;
		cons.insets=new Insets(0,10,1,40);
		add(totalfees,cons,1,11,1,1);
		add(paidfees,cons,1,12,1,1);
		add(addfees,cons,1,13,1,1);
		add(remainfees,cons,1,14,1,1);
		cons.weightx=20;
		cons.anchor=GridBagConstraints.CENTER;
		cons.insets = new Insets(10, 20, 5, 20);
		cons.ipadx=0;
		cons.ipady=20;
		cons.weighty = 10;
		Box hbox=Box.createHorizontalBox();
		hbox.add(Box.createGlue());
		hbox.add(New);
		hbox.add(Box.createHorizontalStrut(15));
		hbox.add(save);
		hbox.add(Box.createHorizontalStrut(15));
		hbox.add(modify);
		hbox.add(Box.createHorizontalStrut(15));
		hbox.add(remove);
		hbox.add(Box.createHorizontalStrut(15));
		hbox.add(exit);
		hbox.add(Box.createHorizontalStrut(15));
		hbox.add(createcourse);
		hbox.add(Box.createGlue());
		add(hbox,cons,0,15,3,1);
		cons.weightx=100;
		cons.weighty=100;
		cons.insets=new Insets(5,16,10,15);
		cons.fill=GridBagConstraints.BOTH;
		add(table1,cons,0,17,3,3);


		New.addActionListener(h);
		modify.addActionListener(h);
		save.addActionListener(h);
		remove.addActionListener(h);
		exit.addActionListener(h);

		mobno.setMaximumSize(mobno.getMinimumSize());
		joindateday.setMaximumSize(joindateday.getMinimumSize());
		joindatemon.setMaximumSize(joindatemon.getMinimumSize());
		joindateyear.setMaximumSize(joindateyear.getMinimumSize());
		joindateday.setMaximumRowCount(10);
		joindatemon.setMaximumRowCount(10);
		joindateyear.setMaximumRowCount(10);
		DateHandler datehandler=new DateHandler();
		joindatemon.addActionListener(datehandler);
		joindateyear.addActionListener(datehandler);

		createcourse.addActionListener(new CourseHandler());
		courselist.addActionListener(ch);
		appyrst.addActionListener(ch);
		addWindowListener(new WindowHandler());


	}
	public void add(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
	{
		cons.gridx=x;
		cons.gridy=y;
		cons.gridwidth=w;
		cons.gridheight=h;
		comp.setPreferredSize(comp.getPreferredSize());
		main.add(comp,cons);
		c.add(main);
	}
	class TableHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent me)
		{
			int ro=table.getSelectedRow();
			String sel=(String)table.getValueAt(ro,0);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
				st=conn.createStatement();
				String cours=(String)courselist.getSelectedItem();
				ResultSet set=st.executeQuery("select * from "+cours+"_stud_info order by scode");
				String scd="";
				while(set.next())
				{
					scd=set.getString(1).trim();
					if(sel.equals(scd))
						break;
				}
				scode.setText(scd);
				sname.setText(set.getString(2));
				mname.setText(set.getString(3));
				lname.setText(set.getString(4));
				addfield1.setText(set.getString(5));
				String dat=set.getString(6);
				String day=dat.substring(0,2);
				if(day.charAt(0) == '0')
					day=String.valueOf(day.charAt(1));
				String mon=dat.substring(3,7);
				String yr=dat.substring(8,12);
				joindateday.setSelectedItem(day);
				joindatemon.setSelectedItem(mon);
				joindateyear.setSelectedItem(yr);
				mobno.setText(set.getString(7));
				totalfees.setText(set.getString(8));
				paidfees.setText(set.getString(9));
				addfees.setText(set.getString(10));
				remainfees.setText(set.getString(11));
				save.setEnabled(false);

			}
			catch(Exception ew)
			{
			}

		}
	}
	//change the table value on window activated
	class WindowHandler extends WindowAdapter
	{
		public void windowActivated(WindowEvent we)
		{
			try
			{
				conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
				st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from course_name");
				//courselist.removeAllItems();
				//while(set.next())
				//{
				//	courselist.addItem(set.getString(2));
				//}

				String cours=(String)courselist.getSelectedItem();
				String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				ResultSet tableset=ps.executeQuery();
				ResultSetMetaData meta=tableset.getMetaData();
				int row=0;
				int i=0;
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Last Name","Contact No"},row);
				ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{
					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(4).trim(),i,2);
					model.setValueAt(tableset.getString(7).trim(),i,3);
					i++;
				}
				table.setModel(model);

			}
			catch(Exception ex)
			{
			}
		}
	}//end window handler
	//change the value when course is selected
	class CourseInfoHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
				st=conn.createStatement();
				String cours=(String)courselist.getSelectedItem();
				ResultSet feeinfo=st.executeQuery("select * from course_name");
				while(feeinfo.next())
				{
					if(cours.equals(feeinfo.getString(2)))
						break;
				}
				totalfees.setText(feeinfo.getString(3));

				int x=0;
				try
				{
					ResultSet set=st.executeQuery("select * from course_name");
					String dur=null;
					while(set.next())
					{
						String cr=set.getString(2).trim();
						dur=set.getString(4).trim();
						if(cr.equals(cours))
							break;
					}

					if(dur.equals("Two Semester")||dur.equals("One Year"))
						x=1;
					if(dur.equals("Four Semester")||dur.equals("Two Year"))
						x=2;
					if(dur.equals("Six Semester")||dur.equals("Three Year"))
						x=3;
					if(dur.equals("Eight Semester")||dur.equals("Four Year"))
						x=4;

					appyred.removeAllItems();
					int y=Integer.parseInt((String)appyrst.getSelectedItem());
					y=y+x;
					appyred.addItem(Integer.toString(y));
					joindateyear.setSelectedItem((String)appyrst.getSelectedItem());
				}
				catch(Exception exc)
				{
				}

				st.close();
				DataInputStream sin=new DataInputStream(new FileInputStream(cours+"_id.dat"));
				scode.setText(sin.readUTF());
				save.setEnabled(true);
				String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				ResultSet tableset=ps.executeQuery();
				int row=0;
				int i=0;
				while(tableset.next())
				{
					row++;
				}
				DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Last Name","Contact No"},row);
				ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				tableset=ps.executeQuery();
				while(tableset.next())
				{
					model.setValueAt(tableset.getString(1).trim(),i,0);
					model.setValueAt(tableset.getString(2).trim(),i,1);
					model.setValueAt(tableset.getString(4).trim(),i,2);
					model.setValueAt(tableset.getString(7).trim(),i,3);
					i++;
				}
				table.setModel(model);
				ps.close();
				sname.setText("");
				mname.setText("");
				lname.setText("");
				addfield1.setText("");
				mobno.setText("");
				paidfees.setText("0");
				addfees.setText("0");
				remainfees.setText("");
				save.setEnabled(true);

			}
			catch(Exception ex)
			{
			}
		}
	}//end course info handler
	class StudentInfoHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			String s=e.getActionCommand();
			Object source=e.getSource();
			coursename=(String)courselist.getSelectedItem();
			//new button
			if(s.equals("New")||source==btn1)
			{
				try
				{
					DataInputStream sin=new DataInputStream(new FileInputStream(coursename+"_id.dat"));
					scode.setText(sin.readUTF());
				}
				catch(Exception ex)
				{
				}
				sname.setText("");
				mname.setText("");
				lname.setText("");
				addfield1.setText("");
				mobno.setText("");
				paidfees.setText("0");
				addfees.setText("0");
				remainfees.setText("");
				save.setEnabled(true);
			}//end new
			//save button
			if(s.equals("Save")||source==btn11)
			{
				boolean ok=false;
				try
				{
					String code=scode.getText().trim();
					String name=sname.getText().trim();
					String midname=mname.getText().trim();
					String lastname=lname.getText().trim();
					String address=addfield1.getText().trim();
					int dy=Integer.parseInt((String)joindateday.getSelectedItem());
					String dys="";
					if(dy>=1 && dy<=9)
						dys="0"+dy;
					else
						dys=""+dy;
					String date=""+dys+"-"+(String)joindatemon.getSelectedItem()+"-"+(String)joindateyear.getSelectedItem();
					String mobile=mobno.getText().trim();
					int total=Integer.parseInt(totalfees.getText());
					int paid=Integer.parseInt(paidfees.getText());
					int addition=Integer.parseInt(addfees.getText());
					int remain=(total+addition)-paid;
					String totalf=Integer.toString(total);
					String paidf=Integer.toString(paid);
					String additionf=Integer.toString(addition);
					String remainf=Integer.toString(remain);
					String appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
					remainfees.setText(remainf);

					if(remain<0)
					{
						Icon error=new ImageIcon("error.png");
						JOptionPane.showMessageDialog(StudentInfo.this,"<html><font size=4 color=red>Paid Fees Over Than Total Fees </font></html> \n\t\t Please Enter Valid Ammount","Student Information",JOptionPane.ERROR_MESSAGE,error);
					}
					else
					if(name.equals("") || midname.equals("") || lastname.equals("") || address.equals("") || paidfees.getText().equals("") || addfees.getText().equals(""))
					{
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(StudentInfo.this,"<html><font size=4 color=red>Field Can Not Be Blank </font></html> \n\t\t Please enter All Information","Student Information",JOptionPane.ERROR_MESSAGE,error);
							return;

					}
					else
					{
						String mobTest=mobno.getText().trim();
						boolean valid=false;
						if((mobTest.length() == 10)||(mobTest.length() == 11))
						{
							valid=true;
							if(mobTest.length() == 11)
							{
								char ch=mobTest.charAt(0);
								if(ch != '0')
								{
									valid=false;
									Icon error=new ImageIcon("error.png");
									JOptionPane.showMessageDialog(StudentInfo.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Student Information",JOptionPane.ERROR_MESSAGE,error);

								}
							}
						}
						else
						{
							valid=false;
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(StudentInfo.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Student Information",JOptionPane.ERROR_MESSAGE,error);
						}

						if(valid == true)
						{
							PreparedStatement ps=conn.prepareStatement("insert into "+coursename+"_stud_info values(?,?,?,?,?,?,?,?,?,?,?,?)");
							ps.setString(1,code);
							ps.setString(2,name);
							ps.setString(3,midname);
							ps.setString(4,lastname);
							ps.setString(5,address);
							ps.setString(6,date);
							ps.setString(7,mobile);
							ps.setInt(8,total);
							ps.setInt(9,paid);
							ps.setInt(10,addition);
							ps.setInt(11,remain);
							ps.setString(12,appyear);
							ps.execute();
							ps.close();


							sname.setText("");
							mname.setText("");
							lname.setText("");
							addfield1.setText("");
							mobno.setText("");
							paidfees.setText("0");
							addfees.setText("0");
							remainfees.setText("");



							st=conn.createStatement();
							int count=0;
							ResultSet sc=st.executeQuery("select * from "+coursename+"_sub ");
							while(sc.next())
							{
								count++;
							}
							int t=0;
							int querylength1=2;
							int querylength2=2;
							int querylength3=2;
							int querylength4=2;
							int querylength5=2;
							int querylength6=2;
							int querylength7=2;
							int querylength8=2;

							String sb[]=new String[count];
							String str=null;
							sc=st.executeQuery("select * from "+coursename+"_sub ");
							while(sc.next())
							{
								String sh=sc.getString(1);
								sb[t]=sh.replace(".","0");
								t++;
							}
							sc.close();
							st.close();
							for(t=0;t<sb.length;t++)
							{
								if((Integer.parseInt(sb[t])>100)&&(Integer.parseInt(sb[t])<200))
								{
									querylength1++;
								}
								if((Integer.parseInt(sb[t])>200)&&(Integer.parseInt(sb[t])<300))
								{
									querylength2++;
								}
								if((Integer.parseInt(sb[t])>300)&&(Integer.parseInt(sb[t])<400))
								{
									querylength3++;
								}
								if((Integer.parseInt(sb[t])>400)&&(Integer.parseInt(sb[t])<500))
								{
									querylength4++;
								}
								if((Integer.parseInt(sb[t])>500)&&(Integer.parseInt(sb[t])<600))
								{
									querylength5++;
								}
								if((Integer.parseInt(sb[t])>600)&&(Integer.parseInt(sb[t])<700))
								{
									querylength6++;
								}
								if((Integer.parseInt(sb[t])>700)&&(Integer.parseInt(sb[t])<800))
								{
									querylength7++;
								}
								if((Integer.parseInt(sb[t])>800)&&(Integer.parseInt(sb[t])<900))
								{
									querylength8++;
								}
							}

							if(querylength1>2)
							{
								String insertmarks="insert into "+coursename+"_marks1 values(?";
								int r=querylength1;
								while(querylength1>1)
								{
									insertmarks=insertmarks+",?";
									querylength1--;
								}
								insertmarks=insertmarks+")";

								ps=conn.prepareStatement(insertmarks);
								ps.setString(1,code);
								ps.setString(2,appyear);
								for(int i=3;i<=r;i++)
								{
									ps.setString(i,"00");
								}
								ps.execute();

							}
							if(querylength2>2)
							{
								String insertmarks="insert into "+coursename+"_marks2 values(?";
								int r=querylength2;
								while(querylength2>1)
								{
									insertmarks=insertmarks+",?";
									querylength2--;
								}
								insertmarks=insertmarks+")";

								ps=conn.prepareStatement(insertmarks);
								ps.setString(1,code);
								ps.setString(2,appyear);
								for(int i=3;i<=r;i++)
								{
									ps.setString(i,"00");
								}
								ps.execute();
							}
							if(querylength3>2)
							{
								String insertmarks="insert into "+coursename+"_marks3 values(?";
								int r=querylength3;
								while(querylength3>1)
								{
									insertmarks=insertmarks+",?";
									querylength3--;
								}
								insertmarks=insertmarks+")";

								ps=conn.prepareStatement(insertmarks);
								ps.setString(1,code);
								ps.setString(2,appyear);
								for(int i=3;i<=r;i++)
								{
									ps.setString(i,"00");
								}
								ps.execute();
							}
							if(querylength4>2)
							{
								String insertmarks="insert into "+coursename+"_marks4 values(?";
								int r=querylength4;
								while(querylength4>1)
								{
									insertmarks=insertmarks+",?";
									querylength4--;
								}
								insertmarks=insertmarks+")";

								ps=conn.prepareStatement(insertmarks);
								ps.setString(1,code);
								ps.setString(2,appyear);
								for(int i=3;i<=r;i++)
								{
									ps.setString(i,"00");
								}
								ps.execute();
							}
							if(querylength5>2)
							{
								String insertmarks="insert into "+coursename+"_marks5 values(?";
								int r=querylength5;
								while(querylength5>1)
								{
									insertmarks=insertmarks+",?";
									querylength5--;
								}
								insertmarks=insertmarks+")";

								ps=conn.prepareStatement(insertmarks);
								ps.setString(1,code);
								ps.setString(2,appyear);
								for(int i=3;i<=r;i++)
								{
									ps.setString(i,"00");
								}
								ps.execute();
							}
							if(querylength6>2)
							{String insertmarks="insert into "+coursename+"_marks6 values(?";
								int r=querylength6;
								while(querylength6>1)
								{
									insertmarks=insertmarks+",?";
									querylength6--;
								}
								insertmarks=insertmarks+")";

								ps=conn.prepareStatement(insertmarks);
								ps.setString(1,code);
								ps.setString(2,appyear);
								for(int i=3;i<=r;i++)
								{
									ps.setString(i,"00");
								}
								ps.execute();
							}
							if(querylength7>2)
							{String insertmarks="insert into "+coursename+"_marks7 values(?";
								int r=querylength7;
								while(querylength7>1)
								{
									insertmarks=insertmarks+",?";
									querylength7--;
								}
								insertmarks=insertmarks+")";

								ps=conn.prepareStatement(insertmarks);
								ps.setString(1,code);
								ps.setString(2,appyear);
								for(int i=3;i<=r;i++)
								{
									ps.setString(i,"00");
								}
								ps.execute();
							}
							if(querylength8>2)
							{String insertmarks="insert into "+coursename+"_marks8 values(?";
								int r=querylength8;
								while(querylength8>1)
								{
									insertmarks=insertmarks+",?";
									querylength8--;
								}
								insertmarks=insertmarks+")";

								ps=conn.prepareStatement(insertmarks);
								ps.setString(1,code);
								ps.setString(2,appyear);
								for(int i=3;i<=r;i++)
								{
									ps.setString(i,"00");
								}
								ps.execute();
							}


							DataInputStream dt=new DataInputStream(new FileInputStream(coursename+"_id.dat"));
							String temp2=dt.readUTF();
							int len=coursename.length();
							String temp=temp2.substring(len);
							int x=Integer.parseInt(temp);
							if(x<9)
							{
								x++;
								temp2=coursename+"000"+x;
							}
							else
							if(x<99)
							{
								x++;
								temp2=coursename+"00"+x;
							}
							else
							if(x<999)
							{
								x++;
								temp2=coursename+"0"+x;
							}
							else
							{
								x++;
								temp2=coursename+x;
							}
							DataOutputStream out=new DataOutputStream(new FileOutputStream(coursename+"_id.dat"));
							out.writeUTF(temp2);
							dt.close();
							out.close();
							DataInputStream sin=new DataInputStream(new FileInputStream(coursename+"_id.dat"));
							scode.setText(sin.readUTF());
							String cours=(String)courselist.getSelectedItem();
							appyear=(String)appyrst.getSelectedItem()+"-"+(String)appyred.getSelectedItem();
							ps=conn.prepareStatement("select * from "+cours+"_stud_info where appyear=? order by scode");
							ps.setString(1,appyear);
							ResultSet tableset=ps.executeQuery();
							ResultSetMetaData meta=tableset.getMetaData();
							int row=0;
							int i=0;
							while(tableset.next())
							{
								row++;
							}
							DefaultTableModel model=new DefaultTableModel(new String[]{"SCode","Name","Last Name","Mobile No"},row);
							ps.setString(1,appyear);
							tableset=ps.executeQuery();
							while(tableset.next())
							{
								model.setValueAt(tableset.getString(1).trim(),i,0);
								model.setValueAt(tableset.getString(2).trim(),i,1);
								model.setValueAt(tableset.getString(4).trim(),i,2);
								model.setValueAt(tableset.getString(7).trim(),i,3);
								i++;
							}
							table.setModel(model);
						}
					}


				}
				catch(Exception e1)
				{
					System.out.println(e1);
					Icon error=new ImageIcon("error.png");
					JOptionPane.showMessageDialog(StudentInfo.this,"<html><font size=3 color=red> Please Fill All Information <br> Field can not be blank </font></html>  ","Student Information",JOptionPane.ERROR_MESSAGE,error);
				}
			}//end save
			if(s.equals("Modify")||source==btn3)
			{
				ModifyInfo info=new ModifyInfo();
				info.setVisible(true);

			}
			if(s.equals("Remove")||source==btn4)
			{
				RemoveInfo info=new RemoveInfo();
				info.setVisible(true);
			}
			if(s.equals("Exit")||source==exit_item)
			{
				dispose();
				if(cr.isShowing())
					cr.dispose();
				new MainMenuFrame().setVisible(true);
			}
			if(source==signout_item||source==btn5)
			{
				Icon warning=new ImageIcon("warning.png");
				Icon question=new ImageIcon("question.png");
				int ans=JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Exit",JOptionPane.YES_NO_OPTION,1,question);

              	if(ans==JOptionPane.YES_OPTION)
              	{
              		System.exit(0);
              	}
              	if(ans==JOptionPane.NO_OPTION)
              	{
              		JOptionPane.showMessageDialog(null,"Termination Attempt Failed","Disacard",JOptionPane.WARNING_MESSAGE,warning);
              	}
			}
			if(source==about_item)
			{
				AboutDialog dl=new AboutDialog();
				dl.setVisible(true);
			}
			if(source==course_item)
			{
				cr = new CourseAddition();
				cr.setVisible(true);
			}
			if(source==courseItem)
			{
				StudentByCourseReport rt=new StudentByCourseReport();
				rt.setVisible(true);
			}
			if(source==course_detailsItem)
			{
				CourseReport t=new CourseReport();
				t.setVisible(true);
			}
			if(source==reamain_fees_item)
			{
				RemainFeesReport rt=new RemainFeesReport();
				rt.setVisible(true);
			}
			if(source==btn10||source==administrative_item)
			{
				ChangePass pass=new ChangePass();
				pass.setVisible(true);
			}
			if(source==btn9)
			{
				int x=courselist.getSelectedIndex();
				courselist.setSelectedItem(courselist.getItemAt(x+1));
			}
			if(source==marks_item)
			{
				dispose();
				if(cr.isShowing())
					cr.dispose();
				new StudentInternalReport().setVisible(true);

			}
			if(source==guest_item)
			{
				dispose();
				if(cr.isShowing())
					cr.dispose();
				new GestContact().setVisible(true);


			}
			if(source==staffentry_item)
			{
				dispose();
				if(cr.isShowing())
					cr.dispose();
				new StaffContact().setVisible(true);

			}
			if(source==staff_item)
			{
				StaffReport rt=new StaffReport();
				rt.setVisible(true);
			}
			if(source==guest_report_item)
			{
				GuestReport rt=new GuestReport();
				rt.setVisible(true);
			}
			if(source==btn2||source==search_stud)
			{
				SearchDialog dl=new SearchDialog(StudentInfo.this);
				dl.setVisible(true);
			}
			if(source==btn7||source==caln)
			{
				calendar l=new calendar();
				l.setVisible(true);

			}
			if(source==btn6||source==calcy)
			{
				Calculator cl=new Calculator();
				cl.setVisible(true);
			}
			if(source==btn8||source==stud_contact)
			{
				StudentContact ct=new StudentContact();
				ct.setVisible(true);
			}
			if(source==student_masterList)
			{
				StudentList ls=new StudentList();
				ls.setVisible(true);
			}

		}
	}
	class AboutDialog extends JDialog
	{
		JButton ok;
		Container c;
		AboutDialog()
		{
			super(StudentInfo.this,"About",true);
			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2+50, height2+40);
			setLocation(width2-20,height2-30);
			setTitle("About");
			ok=new JButton("Ok");
			c=getContentPane();
			JPanel p=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					Image img2=Toolkit.getDefaultToolkit().getImage("mainicon.png");
					t.addImage(img,1);
					t.addImage(img,2);
					while(true)
					{
						try
						{
							t.waitForID(1);
							t.waitForID(2);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,width2+50,height+40,null);
					g.drawImage(img2,10,10,50,50,null);
				}

			};
			JLabel l=new JLabel("<html><font size=6 color=#800080<br><br><B>Result Intimation System</B></dl></font><br><br><p><font size=4 color=blue align=left><B><dl>Developed By : </B></font><font size=4 color=#800000 align=left><B>Rahul Vyas</dd><dd><font size=3 color=black><br><center>version 1.1<br>Copyright 2008 All Rights Reserved");
			p.add(l);
			c.add(p);
			JPanel butpan=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,660,660,null);
				}

			};
			butpan.add(ok);
			c.add("South",butpan);
			ok.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
			});
		}
		public void paintComponent(Graphics g)
		{
			Image img=Toolkit.getDefaultToolkit().getImage("mainicon.gif");
			ImageIcon ic=new ImageIcon(img,"Center");
			g.drawImage(img,20,30,20,30,null);
		}
	}
	class DateHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			String mon=(String)joindatemon.getSelectedItem();
			int x=joindateyear.getSelectedIndex();
			int year=1950;
			year=year+x;
			if(mon.equals("Apr ")||mon.equals("June")||mon.equals("Sept")||mon.equals("Nov "))
			{
				joindateday.removeItem("31");
				therty=true;
				if (twentynine == true)
				{
					joindateday.addItem("30");
					twentynine = false;
					twentyeight = false;

				}
				if (twentyeight == true)
				{
					joindateday.addItem("29");
					joindateday.addItem("30");
					twentyeight = false;
					twentynine = false;
				}
			}
			else
			if(mon.equals("Feb ")&&year%4==0)
			{
				joindateday.removeItem("31");
				joindateday.removeItem("30");
				twentynine=true;
				therty = false;
				if (twentyeight == true)
				{
					joindateday.addItem("29");
					twentyeight = false;
					therty = false;
				}



			}
			else
			if(mon.equals("Feb "))
			{
				twentyeight=true;
				twentynine = false;
				therty = false;
				joindateday.removeItem("31");
				joindateday.removeItem("30");
				joindateday.removeItem("29");

			}
			else
			if(mon.equals("Jan ")||mon.equals("Mar ")||mon.equals("May ")||mon.equals("July")||mon.equals("Aug ")||mon.equals("Oct ")||mon.equals("Desc"))
			{
				if(therty==true)
				{
					joindateday.addItem("31");
					therty=false;
					twentynine = false;
					twentyeight = false;
				}
				else
				if(twentynine==true)
				{
					joindateday.addItem("30");
					joindateday.addItem("31");
					twentynine=false;
					therty = false;
					twentyeight = false;

				}
				else
				if(twentyeight==true)
				{
					joindateday.addItem("29");
					joindateday.addItem("30");
					joindateday.addItem("31");
					twentyeight=false;
					twentynine = false;
					therty = false;
				}

			}

		}
	}
	class CourseHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			cr = new CourseAddition();
			cr.setVisible(true);
		}
	}




	class ModifyInfo extends JFrame
	{
		Container mic=getContentPane();
		JComboBox appyrstmd;
		JComboBox appyredmd;
		JTable stud;
		JComboBox cour;
		JPanel pan;
		DefaultTableModel model;
		ModifyDialog mdl;
		String stcode;
		ModifyInfo()
		{
			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2+100, height2+100);
			setLocation(width2-20,height2-50);
			setTitle("Student Information");
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					dispose();
				}
			});
			ModifyInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Student To Modify");
			JPanel title=new JPanel()
			{
				public void paintComponent(Graphics g)
				{

					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("HEADER.gif");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,width2+100,height2+100,null);
				}
			};
			title.add(l);
			mic.add("North",title);

			pan=new JPanel();
			pan.setLayout(new GridBagLayout());
			GridBagConstraints cons=new GridBagConstraints();
			cons.fill=GridBagConstraints.BOTH;
			cons.anchor=GridBagConstraints.EAST;
			cons.weightx=10;
			cons.weighty=0;
			appyrstmd=new JComboBox();
			appyrstmd.setToolTipText("Select apperaed year");
			appyrstmd.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			appyredmd=new JComboBox();
			appyredmd.setToolTipText("Select apperaed year");
			appyredmd.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));


			cour=new JComboBox();
			cour.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));

			try
			{
				conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
				st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from course_name");
				cour.removeAllItems();
				while(set.next())
				{
					cour.addItem(set.getString(2));
				}
				String cors=(String)cour.getSelectedItem();
				for(int y=1950;y<2100;y++)
				{
					appyrstmd.addItem(Integer.toString(y));
				}
				appyrstmd.setSelectedItem("2007");
				if(cors!=null)
				{
					int x=0;
					try
					{
						set=st.executeQuery("select * from course_name");
						String dur=null;
						while(set.next())
						{
							String cr=set.getString(2).trim();
							dur=set.getString(4).trim();
							if(cr.equals(cors))
								break;
						}
						if(dur.equals("Two Semester") || dur.equals("One Year"))
							x=1;
						else
						if(dur.equals("Four Semester") || dur.equals("Two Year"))
							x=2;
						else
						if(dur.equals("Six Semester") || dur.equals("Three Year"))
							x=3;
						else
						if(dur.equals("Eight Semester") || dur.equals("Four Year"))
							x=4;

						int y=Integer.parseInt((String)appyrstmd.getSelectedItem());
						y=y+x;
						appyredmd.addItem(Integer.toString(y));


					}
					catch(Exception ec)
					{
					}
				}
				st.close();
				String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				ResultSet stset=ps.executeQuery();
				int row=0;
				int i=0;
				while(stset.next())
				{
					row++;
				}
				model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
				ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				stset=ps.executeQuery();
				while(stset.next())
				{
					model.setValueAt(stset.getString(1).trim(),i,0);
					String ft=stset.getString(2).trim();
					ft=ft+" "+stset.getString(4).trim();
					model.setValueAt(ft,i,1);
					model.setValueAt(stset.getString(6).trim(),i,2);
					i++;
				}
				stud=new JTable(model);
				ps.close();
				stud.addMouseListener(new ModifyStudList());
				stud.setToolTipText("Select The Student For Modify");
				stud.doLayout();
				stud.setColumnSelectionAllowed(false);
				stud.setSelectionMode(1);
				stud.setEditingColumn(3);
				stud.setGridColor(Color.pink);
				stud.setRowMargin(3);
				stud.setSelectionBackground(Color.gray);
				stud.setSelectionForeground(Color.red);
				stud.setShowHorizontalLines(false);
				stud.setShowVerticalLines(false);
				stud.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				JScrollPane spl=new JScrollPane(stud);
				mic.add(spl);

				cour.setMaximumRowCount(10);
				cons.anchor=GridBagConstraints.CENTER;
				cons.weightx=30;
				Box cor1 = Box.createHorizontalBox();
				cor1.add(Box.createGlue());
				cor1.add(new JLabel("Course"));
				cor1.add(Box.createHorizontalStrut(5));
				cor1.add(cour);
				cor1.add(Box.createHorizontalStrut(5));
				addOn(cor1,cons,0,0,2,1);

				cons.weightx=40;
				Box cor = Box.createHorizontalBox();
				cor.add(Box.createGlue());
				cor.add(new JLabel("Appered Year"));
				cor.add(Box.createHorizontalStrut(5));
				cor.add(appyrstmd);
				cor.add(Box.createHorizontalStrut(5));
				cor.add(new JLabel("TO"));
				cor.add(Box.createHorizontalStrut(5));
				cor.add(appyredmd);
				addOn(cor,cons,3,0,2,1);
				cons.weightx=100;
				cons.weighty=100;
				addOn(spl,cons,0,1,5,1);
				cour.addActionListener(new SelectedCourse());
				appyrstmd.addActionListener(new SelectedCourse());

				addWindowListener(new WindowAdapter()
				{
					public void windowActivated(WindowEvent we)
					{
						String cors=(String)cour.getSelectedItem();
						try
						{
							String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
							PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
							ps.setString(1,appyear);
							ResultSet stset=ps.executeQuery();
							int row=0;
							int i=0;
							while(stset.next())
							{
								row++;
							}
							model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
							ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
							ps.setString(1,appyear);
							stset=ps.executeQuery();
							while(stset.next())
							{
								model.setValueAt(stset.getString(1).trim(),i,0);
								String ft=stset.getString(2).trim();
								ft=ft+" "+stset.getString(4).trim();
								model.setValueAt(ft,i,1);
								model.setValueAt(stset.getString(6).trim(),i,2);
								i++;
							}
							stud.setModel(model);
						}
						catch(Exception ex)
						{
						}
					}
				});

			}

			catch(Exception es)
			{
			}
		}
		public void addOn(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
		{
			cons.gridx=x;
			cons.gridy=y;
			cons.gridwidth=w;
			cons.gridheight=h;
			comp.setPreferredSize(comp.getPreferredSize());
			pan.add(comp,cons);
			mic.add(pan);
		}
		class SelectedCourse implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String cors=(String)cour.getSelectedItem();
				try
				{
					int x=0;
					st=conn.createStatement();
					ResultSet set=st.executeQuery("select * from course_name");
					String dur=null;
					while(set.next())
					{
						String cr=set.getString(2).trim();
						dur=set.getString(4).trim();
						if(cr.equals(cors))
							break;
					}

					if(dur.equals("Two Semester")||dur.equals("One Year"))
						x=1;
					if(dur.equals("Four Semester")||dur.equals("Two Year"))
						x=2;
					if(dur.equals("Six Semester")||dur.equals("Three Year"))
						x=3;
					if(dur.equals("Eight Semester")||dur.equals("Four Year"))
						x=4;

					appyredmd.removeAllItems();
					int y=Integer.parseInt((String)appyrstmd.getSelectedItem());
					y=y+x;
					appyredmd.addItem(Integer.toString(y));
					st.close();
					int row=0;
					int i=0;
					String appyear=(String)appyrstmd.getSelectedItem()+"-"+(String)appyredmd.getSelectedItem();
					PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					ps.setString(1,appyear);
					ResultSet stset=ps.executeQuery();

					while(stset.next())
					{
						row++;
					}
					model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
					ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					ps.setString(1,appyear);
					stset=ps.executeQuery();
					while(stset.next())
					{
						model.setValueAt(stset.getString(1).trim(),i,0);
						String ft=stset.getString(2).trim();
						ft=ft+" "+stset.getString(4).trim();
						model.setValueAt(ft,i,1);
						model.setValueAt(stset.getString(6).trim(),i,2);
						i++;
					}
					stud.setModel(model);

				}
				catch(Exception ex)
				{
				}
			}
		}
		class ModifyStudList extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				String cors=(String)cour.getSelectedItem();
				int ro=stud.getSelectedRow();
				stcode=(String)stud.getValueAt(ro,0);
				mdl=new ModifyDialog(stcode,cors);
				mdl.setVisible(true);
			}
		}
		class ModifyDialog extends JDialog
		{
			JButton mok;
			JButton mcan;
			JPanel mpan;
			String mstud;
			String corsname;
			Container cont;

			JTextField sco;
			JTextField stuname;
			JTextField midname;
			JTextField lastname;
			JTextArea addre;
			JTextField datetf;
			JTextField mnum;
			JTextField tfee;
			JTextField pfee;
			JTextField addfee;
			JTextField rfee;
			ModifyDialog(String s,String corsf)
			{
				super(ModifyInfo.this,"Modify Student",true);
				mstud=s;
				corsname=corsf;
				final int width2=screenSize.width/3;
				final int height2=screenSize.height/3;
				setSize(width2+100, height2+120);
				setLocation(width2-20,height2-50);
				cont=getContentPane();
				JPanel bp=new JPanel();
				bp.setBackground(new Color(255,197,68));
				mok=new JButton("  Ok  ");
				mcan=new JButton("Cancle");
				bp.add(mok);
				bp.add(mcan);
				cont.add(bp,"South");
				ModifyStud ms=new ModifyStud();
				mok.addActionListener(ms);
				mcan.addActionListener(ms);


				mpan=new JPanel();
				mpan.setLayout(new GridBagLayout());
				sco=new JTextField(10);
				sco.setToolTipText("Student Code");
				sco.setEditable(false);
				sco.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				stuname=new JTextField(20);
				stuname.addKeyListener(onlyText);
				stuname.setToolTipText("Enter Student Name");
				stuname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				midname=new JTextField(20);
				midname.addKeyListener(onlyText);
				midname.setToolTipText("Enter Student's Parent Name");
				midname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				lastname=new JTextField(20);
				lastname.addKeyListener(onlyText);
				lastname.setToolTipText("Enter Student's Last Name");
				lastname.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				addre=new JTextArea(2,20);
				addre.setToolTipText("Enter Student's Address");
				addre.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				addre.setWrapStyleWord(true);
				addre.setLineWrap(true);
				JScrollPane addfd=new JScrollPane(addre);
				datetf=new JTextField(10);
				datetf.setToolTipText("Joining Date");
				datetf.setEditable(false);
				datetf.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				mnum=new JTextField(14);
				mnum.addKeyListener(onlyNumber);
				mnum.setToolTipText("Enter Mobile Number ");
				mnum.setBorder(BorderFactory.createBevelBorder(1,new Color(100,100,155),new Color(100,100,155)));
				mnum.setSelectionColor(Color.blue);
				mnum.setDisabledTextColor(Color.red);
				mnum.setCaretColor(Color.green);
				mnum.setSelectionColor(Color.pink);
				mnum.setFont(new Font("verdana", Font.BOLD, 12));
				tfee=new JTextField(8);
				tfee.setEditable(false);
				tfee.addKeyListener(onlyNumber);
				tfee.setToolTipText("Total Fees Of Course");
				tfee.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				pfee=new JTextField(8);
				pfee.addKeyListener(onlyNumber);
				pfee.setToolTipText("Enter the Recived Fees From Student");
				pfee.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				addfee=new JTextField(8);
				addfee.addKeyListener(onlyNumber);
				addfee.setToolTipText("Enter the Addition Fees of Course \n e.g. Late Fees , Subject backlog Fees , Fine of Liabrary");
				addfee.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				rfee=new JTextField(8);
				rfee.setEditable(false);
				rfee.addKeyListener(onlyNumber);
				rfee.setToolTipText("Remaining Fees Of Student");
				rfee.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));

				GridBagConstraints cons=new GridBagConstraints();
				cons.fill=GridBagConstraints.NONE;
				cons.anchor=GridBagConstraints.EAST;
				cons.weightx=10;
				cons.weighty=10;

				cons.insets = new Insets(0, 10, 5, 0);
				mdadd(new JLabel("Student Code  : "),cons,0,0,1,1);
				mdadd(new JLabel("Student Name  : "),cons,0,1,1,1);
				mdadd(new JLabel("Parent name  : "),cons,0,2,1,1);
				mdadd(new JLabel("Last Name  : "),cons,0,3,1,1);
				mdadd(new JLabel("Address  : "),cons,0,4,1,2);
				mdadd(new JLabel("Date Of Joining  : "),cons,0,6,1,1);
				mdadd(new JLabel("Mobile Number  : "),cons,0,7,1,1);
				mdadd(new JLabel("Total Fees  : "),cons,0,8,1,1);
				mdadd(new JLabel("Paid Fees  : "),cons,0,9,1,1);
				mdadd(new JLabel("Addition Fees  : "),cons,0,10,1,1);
				mdadd(new JLabel("Remaining Fees  : "),cons,0,11,1,1);

				cons.fill=GridBagConstraints.HORIZONTAL;
				cons.weightx = 50;
				cons.insets = new Insets(0, 10, 5, 40);
				mdadd(sco, cons, 1, 0, 1, 1);
				cons.insets = new Insets(0, 10, 1, 40);
				mdadd(stuname,cons,1,1,1,1);
				mdadd(midname,cons,1,2,1,1);
				mdadd(lastname,cons,1,3,1,1);
				cons.insets = new Insets(0, 10, 1, 100);
				cons.ipady = 20;
				mdadd(addfd,cons,1,4,1,2);
				cons.ipady=0;
				cons.insets = new Insets(0, 10, 1, 160);
				mdadd(datetf,cons,1,6,1,1);
				mdadd(mnum,cons,1,7,1,1);
				cons.ipady = 0;
				cons.insets=new Insets(0,10,1,40);
				mdadd(tfee,cons,1,8,1,1);
				mdadd(pfee,cons,1,9,1,1);
				mdadd(addfee,cons,1,10,1,1);
				mdadd(rfee,cons,1,11,1,1);

				try
				{
					st=conn.createStatement();
					ResultSet minfo=st.executeQuery("select * from "+corsname+"_stud_info order by scode");
					String stco="";
					while(minfo.next())
					{
						stco=minfo.getString(1).trim();
						if(stco.equals(mstud))
							break;
					}
					sco.setText(stco);
					stuname.setText(minfo.getString(2));
					midname.setText(minfo.getString(3));
					lastname.setText(minfo.getString(4));
					addre.setText(minfo.getString(5));
					datetf.setText(minfo.getString(6));
					mnum.setText(minfo.getString(7));
					tfee.setText(minfo.getString(8));
					pfee.setText(minfo.getString(9));
					addfee.setText(minfo.getString(10));
					rfee.setText(minfo.getString(11));

				}
				catch(Exception ed)
				{
					System.out.println(ed);
				}
			}
			public void mdadd(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
			{
				cons.gridx=x;
				cons.gridy=y;
				cons.gridwidth=w;
				cons.gridheight=h;
				comp.setPreferredSize(comp.getPreferredSize());
				mpan.add(comp,cons);
				cont.add(mpan);
			}
			class ModifyStud implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					String minfo=e.getActionCommand();
					if(minfo.equals("  Ok  "))
					{
						boolean ok=false;
						try
						{
							String name=stuname.getText();
							String mdname=midname.getText();
							String ltname=lastname.getText();
							String address=addre.getText();
							String mobile=mnum.getText();
							int total=Integer.parseInt(tfee.getText());
							int paidfs=Integer.parseInt(pfee.getText());
							int additionfs=Integer.parseInt(addfee.getText());
							int remain=(total+additionfs)-paidfs;
							String totalf=Integer.toString(total);
							String paidfe=Integer.toString(paidfs);
							String additionfe=Integer.toString(additionfs);
							String remainf=Integer.toString(remain);
							if(remain<0)
							{
								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(ModifyDialog.this,"<html><font size=4 color=red>Paid Fees Over Than Total Fees </font></html> \n\t\t Please Enter Valid Ammount","Student Information",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							if(name.equals("") || mdname.equals("") || ltname.equals("") || address.equals("")|| paidfe.equals(""))
							{
								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(ModifyDialog.this,"<html><font size=4 color=red>Field Can Not Be Blank </font></html> \n\t\t Please enter All Information","Student Information",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{
								String mobTest=mnum.getText().trim();
								boolean valid=false;
								if((mobTest.length() == 10)||(mobTest.length() == 11))
								{
									valid=true;
									if(mobTest.length() == 11)
									{
										char ch=mobTest.charAt(0);
										if(ch != '0')
										{
											valid=false;
											Icon error=new ImageIcon("error.png");
											JOptionPane.showMessageDialog(ModifyDialog.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Student Information",JOptionPane.ERROR_MESSAGE,error);
										}
									}
								}
								else
								{
									valid=false;
									Icon error=new ImageIcon("error.png");
									JOptionPane.showMessageDialog(ModifyDialog.this,"<html><font size=4 color=red>Mobile Number Not Be Valid </font></html> \n\t\t Please Enter Valid Mobile Number","Student Information",JOptionPane.ERROR_MESSAGE,error);
								}
								if(valid==true)
								{
									String csn=(String)cour.getSelectedItem();
									PreparedStatement pm=conn.prepareStatement("update "+csn+"_stud_info set sname=? ,mname=? ,lname=? ,address=? ,mobno=? ,paidfees=? ,addfees=? ,remfees=? where scode=?");
									pm.setString(1,name);
									pm.setString(2,mdname);
									pm.setString(3,ltname);
									pm.setString(4,address);
									pm.setString(5,mobile);
									pm.setInt(6,paidfs);
									pm.setInt(7,additionfs);
									pm.setInt(8,remain);
									pm.setString(9,mstud);
									pm.execute();
								}
								mdl.dispose();
							}
						}
						catch(Exception es)
						{
							Icon error=new ImageIcon("error.png");
							JOptionPane.showMessageDialog(ModifyDialog.this,"<html><font size=4 color=red>Field Can Not Be Blank </font></html> \n\t\t Please enter All Information","Student Information",JOptionPane.ERROR_MESSAGE,error);
						}

					}
					else
					{
						mdl.dispose();
					}
				}
			}
		}
	}

	class RemoveInfo extends JFrame
	{
		Container mic=getContentPane();
		JComboBox appyrstrm;
		JComboBox appyredrm;
		JTable stud;
		JComboBox cour;
		JPanel pan;
		DefaultTableModel model;
		RemoveDialog dlg;
		String corname;
		RemoveInfo()
		{
			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2+100, height2+100);
			setLocation(width2-20,height2-50);setTitle("Student Information");
			addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					dispose();
				}
			});
			RemoveInfo.setDefaultLookAndFeelDecorated(true);
			setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage("mainicon.png"));
			JLabel l=new JLabel("<html><font size=5 color=#800080><i>Select Student To Remove");
			JPanel title=new JPanel()
			{
				public void paintComponent(Graphics g)
				{

					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("HEADER.gif");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,width2+100,height2+100,null);
				}
			};
			title.add(l);
			mic.add("North",title);
			pan=new JPanel();
			pan.setLayout(new GridBagLayout());
			GridBagConstraints cons=new GridBagConstraints();
			cons.fill=GridBagConstraints.BOTH;
			cons.anchor=GridBagConstraints.EAST;
			cons.weightx=10;
			cons.weighty=0;

			cour=new JComboBox();
			cour.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			appyrstrm=new JComboBox();
			appyrstrm.setToolTipText("Select apperaed year");
			appyrstrm.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			appyredrm=new JComboBox();
			appyredrm.setToolTipText("Select apperaed year");
			appyredrm.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
			try
			{
				conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
				st=conn.createStatement();
				ResultSet set=st.executeQuery("select * from course_name");
				while(set.next())
				{
					cour.addItem(set.getString(2));
				}
				for(int y=1950;y<2100;y++)
				{
					appyrstrm.addItem(Integer.toString(y));
				}
				appyrstrm.setSelectedItem("2007");
				String crs=(String)cour.getSelectedItem();
				if(crs!=null)
				{
					int x=0;
					try
					{
						set=st.executeQuery("select * from course_name");
						String dur=null;
						while(set.next())
						{
							String cr=set.getString(2).trim();
							dur=set.getString(4).trim();
							if(cr.equals(crs))
								break;
						}
						if(dur.equals("Two Semester") || dur.equals("One Year"))
							x=1;
						else
						if(dur.equals("Four Semester") || dur.equals("Two Year"))
							x=2;
						else
						if(dur.equals("Six Semester") || dur.equals("Three Year"))
							x=3;
						else
						if(dur.equals("Eight Semester") || dur.equals("Four Year"))
							x=4;

						int y=Integer.parseInt((String)appyrstrm.getSelectedItem());
						y=y+x;
						appyredrm.addItem(Integer.toString(y));


					}
					catch(Exception ec)
					{
					}
				}

				st.close();

				String appyear=(String)appyrstrm.getSelectedItem()+"-"+(String)appyredrm.getSelectedItem();
				PreparedStatement ps=conn.prepareStatement("select * from "+crs+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				ResultSet stset=ps.executeQuery();
				int row=0;
				int i=0;
				while(stset.next())
				{
					row++;
				}
				model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
				ps=conn.prepareStatement("select * from "+crs+"_stud_info where appyear=? order by scode");
				ps.setString(1,appyear);
				stset=ps.executeQuery();

				while(stset.next())
				{
					model.setValueAt(stset.getString(1).trim(),i,0);
					String ft=stset.getString(2).trim();
					ft=ft+" "+stset.getString(4).trim();
					model.setValueAt(ft,i,1);
					model.setValueAt(stset.getString(6).trim(),i,2);
					i++;
				}
				stud=new JTable(model);
				stud.addMouseListener(new RemoveStudList());
				stud.setToolTipText("Select The Student For Modify");
				stud.doLayout();
				stud.setColumnSelectionAllowed(false);
				stud.setSelectionMode(1);
				stud.setEditingColumn(3);
				stud.setGridColor(Color.pink);
				stud.setRowMargin(3);
				stud.setSelectionBackground(Color.gray);
				stud.setSelectionForeground(Color.red);
				stud.setShowHorizontalLines(false);
				stud.setShowVerticalLines(false);
				stud.setBorder(BorderFactory.createBevelBorder(1,new Color(192,192,255),new Color(192,192,255)));
				JScrollPane spl=new JScrollPane(stud);
				mic.add(spl);

				cour.setMaximumRowCount(10);
				cons.anchor=GridBagConstraints.CENTER;
				cons.weightx=30;
				Box cor1=Box.createHorizontalBox();
				cor1.add(Box.createGlue());
				cor1.add(new JLabel("Course"));
				cor1.add(Box.createHorizontalStrut(5));
				cor1.add(cour);
				cor1.add(Box.createHorizontalStrut(5));
				addOn(cor1,cons,0,0,2,1);
				cons.weightx=40;
				Box cor = Box.createHorizontalBox();
				cor.add(Box.createGlue());
				cor.add(new JLabel("Appered Year"));
				cor.add(Box.createHorizontalStrut(5));
				cor.add(appyrstrm);
				cor.add(Box.createHorizontalStrut(5));
				cor.add(new JLabel("TO"));
				cor.add(Box.createHorizontalStrut(5));
				cor.add(appyredrm);
				addOn(cor,cons,3,0,2,1);
				cons.weightx=100;
				cons.weighty=100;
				addOn(spl,cons,0,1,5,1);
				stset.close();
				cour.setMaximumRowCount(10);
				cour.addActionListener(new SelectedCourseRemove());
				appyrstrm.addActionListener(new SelectedCourseRemove());
				addWindowListener(new WindowAdapter()
				{
					public void windowActivated(WindowEvent we)
					{
						String cors=(String)cour.getSelectedItem();
						try
						{


							String appyear=(String)appyrstrm.getSelectedItem()+"-"+(String)appyredrm.getSelectedItem();
							PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
							ps.setString(1,appyear);
							ResultSet stset=ps.executeQuery();
							int row=0;
							int i=0;
							while(stset.next())
							{
								row++;
							}
							model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
							ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
							ps.setString(1,appyear);
							stset=ps.executeQuery();
							while(stset.next())
							{
								model.setValueAt(stset.getString(1).trim(),i,0);
								String ft=stset.getString(2).trim();
								ft=ft+" "+stset.getString(4).trim();
								model.setValueAt(ft,i,1);
								model.setValueAt(stset.getString(6).trim(),i,2);
								i++;
							}
							stud.setModel(model);
						}
						catch(Exception ex)
						{
						}
					}
				});

			}
			catch(Exception es)
			{
			}

		}
		public void addOn(Component comp,GridBagConstraints cons,int x,int y,int w,int h)
		{
			cons.gridx=x;
			cons.gridy=y;
			cons.gridwidth=w;
			cons.gridheight=h;
			comp.setPreferredSize(comp.getPreferredSize());
			pan.add(comp,cons);
			mic.add(pan);
		}
		class SelectedCourseRemove implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String cors=(String)cour.getSelectedItem();
				try
				{
					int x=0;
					st=conn.createStatement();
					ResultSet set=st.executeQuery("select * from course_name");
					String dur=null;
					while(set.next())
					{
						String cr=set.getString(2).trim();
						dur=set.getString(4).trim();
						if(cr.equals(cors))
							break;
					}

					if(dur.equals("Two Semester")||dur.equals("One Year"))
					x=1;
					if(dur.equals("Four Semester")||dur.equals("Two Year"))
						x=2;
					if(dur.equals("Six Semester")||dur.equals("Three Year"))
						x=3;
					if(dur.equals("Eight Semester")||dur.equals("Four Year"))
						x=4;
					appyredrm.removeAllItems();
					int y=Integer.parseInt((String)appyrstrm.getSelectedItem());
					y=y+x;
					appyredrm.addItem(Integer.toString(y));
					st.close();
					String appyear=(String)appyrstrm.getSelectedItem()+"-"+(String)appyredrm.getSelectedItem();
					PreparedStatement ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					ps.setString(1,appyear);
					ResultSet stset=ps.executeQuery();
					int row=0;
					int i=0;
					while(stset.next())
					{
						row++;
					}
					model=new DefaultTableModel(new String[]{"Student Code","Name","Addmition Date"},row);
					ps=conn.prepareStatement("select * from "+cors+"_stud_info where appyear=? order by scode");
					ps.setString(1,appyear);
					stset=ps.executeQuery();
					while(stset.next())
					{
						model.setValueAt(stset.getString(1).trim(),i,0);
						String ft=stset.getString(2).trim();
						ft=ft+" "+stset.getString(4).trim();
						model.setValueAt(ft,i,1);
						model.setValueAt(stset.getString(6).trim(),i,2);
						i++;
					}
					stud.setModel(model);
					}
					catch(Exception ex)
					{
					}

			}
		}
		class RemoveStudList extends MouseAdapter
		{
			public void mouseClicked(MouseEvent e)
			{
				int ro=stud.getSelectedRow();
				String stcode=(String)stud.getValueAt(ro,0);
				dlg=new RemoveDialog(stcode);
				dlg.setVisible(true);


			}
		}
		class RemoveDialog extends JDialog
		{
			JButton rok;
			JButton rcan;
			JLabel ls;
			String rmstud;
			RemoveDialog(String s)
			{
				super(RemoveInfo.this,"Remove Student",true);
				rmstud=s;
				setSize(250,150);
				setLocation(400,280);
				JPanel bp=new JPanel();
				bp.setBackground(new Color(255,197,68));
				rok=new JButton("  Ok  ");
				rcan=new JButton("Cancle");
				bp.add(rok);
				bp.add(rcan);
				add(bp,"South");
				JPanel lp=new JPanel();
				lp.add(new JLabel("<html><font size=4 color=#800080>Do You Want To Ramove <br>    Student Information </font></html>"));
				add(lp);
				RemoveStud rs=new RemoveStud();
				rok.addActionListener(rs);
				rcan.addActionListener(rs);

			}
			class RemoveStud implements ActionListener
			{
				String dur;
				public void actionPerformed(ActionEvent ev)
				{
					String cm=ev.getActionCommand();
					if(cm.equals("  Ok  "))
					{
						try
						{
							String csn=(String)cour.getSelectedItem();
							PreparedStatement pts=conn.prepareStatement("delete from "+csn+"_stud_info  where scode=?");
							pts.setString(1,rmstud);
							pts.execute();
							pts.close();

							pts=conn.prepareStatement("select course_dura from course_name where course_name=? ");
							pts.setString(1,csn);
							ResultSet set=pts.executeQuery();
							set.next();
							String dur=set.getString(1);

							pts.close();

							int semno=0;

							if(dur.equals("One Semester")||(dur.equals("One Year")))
							{
								semno=1;
							}
							if(dur.equals("Two Semester")||(dur.equals("Two Year")))
							{
								semno=2;
							}
							if(dur.equals("Three Semester")||(dur.equals("Three Year")))
							{
								semno=3;
							}
							if(dur.equals("Four Semester")||(dur.equals("Four Year")))
							{
								semno=4;
							}
							if(dur.equals("Five Semester"))
							{
								semno=5;
							}
							if(dur.equals("Six Semester"))
							{
								semno=6;
							}
							if(dur.equals("Seven Semester"))
							{
								semno=7;
							}
							if(dur.equals("Eight Semester"))
							{
								semno=8;
							}
							Connection cns=DriverManager.getConnection("Jdbc:Odbc:Student_Info","raj","17java71");
							for(int i=1;i<=semno;i++)
							{
								String tablename=csn+"_marks"+i;
								System.out.println(tablename);

								PreparedStatement pts2=cns.prepareStatement("delete from "+tablename+"  where scode=?");
								//pts2.setString(1,tablename);
								pts2.setString(1,rmstud);
								pts2.execute();
								pts2.close();

							}
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
						dlg.dispose();
					}
					else
					{
						dlg.dispose();
					}

				}
			}

		}

	}
	class ChangePass extends JDialog
	{
		JTextField chuname1;
		JPasswordField chpass1;
		JTextField chuname2;
		JPasswordField chpass2;
		ResultSet set;
		ChangePass()
		{
			super(StudentInfo.this,"Change Password",true);

			final int width2=screenSize.width/3;
			final int height2=screenSize.height/3;
			setSize(width2,height2);setLocation(screenSize.width/3+20,screenSize.height/4+40);
			setResizable(false);
			StudentInfo.setDefaultLookAndFeelDecorated(true);
			Container c=getContentPane();
			chuname1=new JTextField(10);
			chuname1.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
			chpass1=new JPasswordField(10);
			chpass1.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
			chuname2=new JTextField(10);
			chuname2.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));
			chpass2=new JPasswordField(10);
			chpass2.setBorder(BorderFactory.createBevelBorder(1, new Color(200, 200, 200), new Color(200, 200, 200)));

			JPanel main=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,660,660,null);
				}
			};
			main.setLayout(new BorderLayout());
			Box vbox=Box.createVerticalBox();
			JPanel chun1=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,660,660,null);
				}
			};
			chun1.add(new JLabel("    User Name        "));
			chun1.add(chuname1);
			vbox.add(chun1);

			JPanel chpas1=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,660,660,null);
				}
			};
			chpas1.add(new JLabel("    Password         "));
			chpas1.add(chpass1);
			vbox.add(chpas1);

			JPanel chun2=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,660,660,null);
				}
			};
			chun2.add(new JLabel("New User Name   "));
			chun2.add(chuname2);
			vbox.add(chun2);

			JPanel chpas2=new JPanel()
			{
				public void paintComponent(Graphics g)
				{
					Toolkit kit=Toolkit.getDefaultToolkit();
					Image img=kit.getImage("Gradien.jpg");
					MediaTracker t=new MediaTracker(this);
					t.addImage(img,1);
					while(true)
					{
						try
						{
							t.waitForID(1);
							break;
						}
						catch(Exception e)
						{
						}
					}
					g.drawImage(img,0,0,660,660,null);
				}
			};
			chpas2.add(new JLabel("New Password     "));
			chpas2.add(chpass2);
			vbox.add(chpas2);
			vbox.add(Box.createVerticalStrut(20));

			JButton ok=new JButton("Ok");
			JButton clear=new JButton("clear");
			JButton exit=new JButton("exit");
			Box butpan=Box.createHorizontalBox();
			butpan.setCursor(new Cursor(Cursor.HAND_CURSOR));
			butpan.add(ok);
			butpan.add(Box.createHorizontalStrut(20));
			butpan.add(clear);
			butpan.add(Box.createHorizontalStrut(20));
			butpan.add(exit);
			vbox.add(butpan);
			main.add(vbox);
			c.add(main);

			ok.setToolTipText("Save Password");
			clear.setToolTipText("Clear Text");
			exit.setToolTipText("Exit");
			chuname1.setToolTipText("Enter The User Name");
			chpass1.setToolTipText("Enter The Password");
			chuname2.setToolTipText("Enter The New User Name");
			chpass2.setToolTipText("Enter The New password");


			clear.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					chuname1.setText("");
					chpass1.setText("");
					chuname2.setText("");
					chpass2.setText("");

				}
			});
			exit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
			});

			chpass2.addKeyListener(new KeyAdapter()
			{
				public void keyPressed(KeyEvent e)
				{
					if((e.getKeyCode())==KeyEvent.VK_ENTER)
					{
						boolean flag=false;
						String s="";
						s=chuname1.getText();
						char a[]=chpass1.getPassword();
						String u_name=null;
						String p_name=null;
						try
						{
						conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
						st=conn.createStatement();
						set=st.executeQuery("Select * from Login");
						set.next();
						u_name=set.getString(1);
						p_name=set.getString(2);
						}
						catch(Exception ex)
						{
						}
						if(s.equals(u_name) && a.length==p_name.length())
						{
							for(int i=0;i<p_name.length();i++)
							{
							  if(a[i]==p_name.charAt(i))
								   flag=true;
							  else
							  {
								   flag=false;
								   break;
							  }

							}
						 }
						if(flag==true)
						{
							if(chuname2.getText().equals("") || chpass2.getPassword().length==0)
							{
								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Enter New User Name and Password</font></html>","change Password",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{


							try
							{

							PreparedStatement ps=conn.prepareStatement("UPDATE Login set u_name=?,p_name=? where u_name=?");
							ps.setString(1,chuname2.getText());
							ps.setString(2,String.copyValueOf(chpass2.getPassword()));
							ps.setString(3,chuname1.getText());
							ps.execute();
							Icon info=new ImageIcon("info.png");
							JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=green>Password Is Change</font></html> \n\t\t Use New password","Change Password",JOptionPane.INFORMATION_MESSAGE,info);
							dispose();
							}
							catch(Exception e2)
							{
							}
							}

						}
						else
						{
							Icon error=new ImageIcon("error.png");
							 JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
						}
					}
				}
			});
			ok.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
						boolean flag=false;
						String s="";
						s=chuname1.getText();
						char a[]=chpass1.getPassword();
						String u_name=null;
						String p_name=null;
						try
						{
							conn=DriverManager.getConnection("jdbc:odbc:Student_Info","raj","17java71");
							st=conn.createStatement();
							set=st.executeQuery("Select * from Login");
							set.next();
							u_name=set.getString(1);
							p_name=set.getString(2);
						}
						catch(Exception ex)
						{
						}
						if(s.equals(u_name) && a.length==p_name.length())
						{
							for(int i=0;i<p_name.length();i++)
							{
							  if(a[i]==p_name.charAt(i))
							   flag=true;
							  else
							  {
							   flag=false;
							   break;
							  }
							}
						 }
						if(flag==true)
						{
							if(chuname2.getText().equals("")|| chpass2.getPassword().length==0)
							{
								Icon error=new ImageIcon("error.png");
								JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Enter New User Name and Password</font></html>","change Password",JOptionPane.ERROR_MESSAGE,error);
							}
							else
							{

							try
							{

								PreparedStatement ps=conn.prepareStatement("UPDATE Login set u_name=?,p_name=? where u_name=?");
								ps.setString(1,chuname2.getText());
								ps.setString(2,String.copyValueOf(chpass2.getPassword()));
								ps.setString(3,chuname1.getText());
								ps.execute();
								Icon info=new ImageIcon("info.png");
								JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=green>Password Is Change</font></html> \n\t\t Use New password","Change Password",JOptionPane.INFORMATION_MESSAGE,info);
								dispose();
							}
							catch(Exception e2)
							{
							}
							}
						}
						else
						{
							 Icon error=new ImageIcon("error.png");
							 JOptionPane.showMessageDialog(ChangePass.this,"<html><font size=4 color=red>Invalid Password </font></html> \n\t\t Please enter valid password","Login",JOptionPane.ERROR_MESSAGE,error);
						}


				}
			});


		}



	}

}