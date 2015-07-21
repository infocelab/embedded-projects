/*******************************************************************************************
* this Prgram:					DISPLAYS  NESTED TABBEDPANES IN SPLIT PANE				   *
* prepared By:					Umer                                                       *
* last Modified:				03:01:03                                                   *
*******************************************************************************************/
import java.awt.*;
import javax.swing.*;
import java.util.Date;
import javax.swing.SwingUtilities;
import java.awt.event.*;
import java.beans.*;
import javax.swing.SwingUtilities;
import javax.swing.plaf.metal.MetalLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;

public class Project extends JFrame implements ActionListener
{

///////////////////////////////////DECLARATIONS////////////////////////////////////////////
    public final static int ONE_SECOND = 1000;

//////////////////////////	PROGRESS BAR 	declarations	////////////////////////////

    private JProgressBar progressBar;
    private Timer timer;
    private JButton startButton;
    private LongTask task;
    private String newline = "\n";

/*******************************	SETTING LOOK AND FEEL	********************************/
////////////////radio buttons for look'n feel
	JRadioButton rad_btn1=new JRadioButton("Metal",true);
	JRadioButton rad_btn2=new JRadioButton("Motif");
	JRadioButton rad_btn3=new JRadioButton("Windows");
/////////////////panel for radio buttons
	JPanel rad_panel=new JPanel();



////////////////////////////EMP-PROJ-TABBEDPANE/////////////////
	
	JTabbedPane emp_proj_TP = new JTabbedPane();
	
////////////EMP-SCHEDULE-TABBEDPANE////////////

JTabbedPane emp_schedule_TP = new JTabbedPane();

JPanel emp_day_panel = new JPanel();
JPanel emp_week_panel = new JPanel();
JPanel emp_month_panel = new JPanel();

JComboBox emp_day_combobox = new JComboBox();
JComboBox emp_week_combobox = new JComboBox();
JComboBox emp_month_combobox = new JComboBox();

/******************************* 	EMP DAY SCHED PANELS 	********************************/

JPanel emp_day_sched_panel_time = new JPanel();
JPanel emp_day_sched_panel_center = new JPanel();

 JPanel emp_hour1_panel = new JPanel();	
 JPanel emp_hour2_panel = new JPanel();
 JPanel emp_hour3_panel = new JPanel();
 JPanel emp_hour4_panel = new JPanel();
 JPanel emp_hour5_panel = new JPanel();
 JPanel emp_hour6_panel = new JPanel();
 JPanel emp_hour7_panel = new JPanel();
 JPanel emp_hour8_panel = new JPanel();
 /*
 JPanel emp_daily_9 = new JPanel(); 
 JPanel emp_daily_10 = new JPanel(); 
 JPanel emp_daily_11 = new JPanel(); 
 JPanel emp_daily_12 = new JPanel(); 
 JPanel emp_daily_1 = new JPanel(); 
 JPanel emp_daily_2 = new JPanel(); 
 JPanel emp_daily_3 = new JPanel(); 
 JPanel emp_daily_4 = new JPanel();
 JPanel emp_daily_5 = new JPanel();
 */
 JPanel emp_daily_9 = new JPanel(); 
JLabel emp_jl_9 = new JLabel("9");

JPanel emp_daily_10 = new JPanel(); 
JLabel emp_jl_10 = new JLabel("10");

JPanel emp_daily_11 = new JPanel(); 
JLabel emp_jl_11 = new JLabel("11");

JPanel emp_daily_12 = new JPanel(); 
JLabel emp_jl_12 = new JLabel("12");

JPanel emp_daily_1 = new JPanel(); 
JLabel emp_jl_1 = new JLabel("1");

JPanel emp_daily_2 = new JPanel(); 
JLabel emp_jl_2 = new JLabel("2");

JPanel emp_daily_3 = new JPanel(); 
JLabel emp_jl_3 = new JLabel("3");

JPanel emp_daily_4 = new JPanel(); 
JLabel emp_jl_4 = new JLabel("4");
JLabel emp_jl_5 = new JLabel("5");

/******************************* EMP WEEK SCHED PANELS 	********************************/

JPanel emp_week_sched_panel_center = new JPanel();
JPanel emp_week_sched_panel_north = new JPanel();

JPanel emp_mon_panel = new JPanel();
JPanel emp_tues_panel = new JPanel();
JPanel emp_wed_panel = new JPanel();
JPanel emp_thur_panel = new JPanel();
JPanel emp_fri_panel = new JPanel();
JPanel emp_sat_panel = new JPanel();

JPanel emp_time0_panel = new JPanel();
JPanel emp_time1_panel = new JPanel();
JPanel emp_time2_panel = new JPanel();
JPanel emp_time3_panel = new JPanel();
JPanel emp_time4_panel = new JPanel();
JPanel emp_time5_panel = new JPanel();
JPanel emp_time6_panel = new JPanel();
JPanel emp_time7_panel = new JPanel();
JPanel emp_time8_panel = new JPanel();

JPanel emp_mon9_panel = new JPanel();
JPanel emp_mon10_panel = new JPanel();
JPanel emp_mon11_panel = new JPanel();
JPanel emp_mon12_panel = new JPanel();
JPanel emp_mon1_panel = new JPanel();
JPanel emp_mon2_panel = new JPanel();
JPanel emp_mon3_panel = new JPanel();
JPanel emp_mon4_panel = new JPanel();

JPanel emp_tues9_panel = new JPanel();
JPanel emp_tues10_panel = new JPanel();
JPanel emp_tues11_panel = new JPanel();
JPanel emp_tues12_panel = new JPanel();
JPanel emp_tues1_panel = new JPanel();
JPanel emp_tues2_panel = new JPanel();
JPanel emp_tues3_panel = new JPanel();
JPanel emp_tues4_panel = new JPanel();

JPanel emp_wed9_panel = new JPanel();
JPanel emp_wed10_panel = new JPanel();
JPanel emp_wed11_panel = new JPanel();
JPanel emp_wed12_panel = new JPanel();
JPanel emp_wed1_panel = new JPanel();
JPanel emp_wed2_panel = new JPanel();
JPanel emp_wed3_panel = new JPanel();
JPanel emp_wed4_panel = new JPanel();

JPanel emp_thur9_panel = new JPanel();
JPanel emp_thur10_panel = new JPanel();
JPanel emp_thur11_panel = new JPanel();
JPanel emp_thur12_panel = new JPanel();
JPanel emp_thur1_panel = new JPanel();
JPanel emp_thur2_panel = new JPanel();
JPanel emp_thur3_panel = new JPanel();
JPanel emp_thur4_panel = new JPanel();

JPanel emp_fri9_panel = new JPanel();
JPanel emp_fri10_panel = new JPanel();
JPanel emp_fri11_panel = new JPanel();
JPanel emp_fri12_panel = new JPanel();
JPanel emp_fri1_panel = new JPanel();
JPanel emp_fri2_panel = new JPanel();
JPanel emp_fri3_panel = new JPanel();
JPanel emp_fri4_panel = new JPanel();

JPanel emp_sat9_panel = new JPanel();
JPanel emp_sat10_panel = new JPanel();
JPanel emp_sat11_panel = new JPanel();
JPanel emp_sat12_panel = new JPanel();
JPanel emp_sat1_panel = new JPanel();
JPanel emp_sat2_panel = new JPanel();
JPanel emp_sat3_panel = new JPanel();
JPanel emp_sat4_panel = new JPanel();

/////////////////Employee Monthly Schedule Area///////////////////////////

JPanel emp_month_north_panel = new JPanel();
JPanel emp_month_center_panel = new JPanel();

JPanel emp_cal_mon_panel = new JPanel();
JPanel emp_cal_tue_panel = new JPanel();
JPanel emp_cal_wed_panel = new JPanel();
JPanel emp_cal_thu_panel = new JPanel();
JPanel emp_cal_fri_panel = new JPanel();
JPanel emp_cal_sat_panel = new JPanel();
JPanel emp_cal_sun_panel = new JPanel();

JPanel emp_cal1 = new JPanel();
JPanel emp_cal2 = new JPanel();
JPanel emp_cal3 = new JPanel();
JPanel emp_cal4 = new JPanel();
JPanel emp_cal5 = new JPanel();
JPanel emp_cal6 = new JPanel();
JPanel emp_cal7 = new JPanel();
JPanel emp_cal8 = new JPanel();
JPanel emp_cal9 = new JPanel();
JPanel emp_cal10 = new JPanel();
JPanel emp_cal11 = new JPanel();
JPanel emp_cal12 = new JPanel();
JPanel emp_cal13 = new JPanel();
JPanel emp_cal14 = new JPanel();
JPanel emp_cal15 = new JPanel();
JPanel emp_cal16 = new JPanel();
JPanel emp_cal17 = new JPanel();
JPanel emp_cal18 = new JPanel();
JPanel emp_cal19 = new JPanel();
JPanel emp_cal20 = new JPanel();
JPanel emp_cal21 = new JPanel();
JPanel emp_cal22 = new JPanel();
JPanel emp_cal23 = new JPanel();
JPanel emp_cal24 = new JPanel();
JPanel emp_cal25 = new JPanel();
JPanel emp_cal26 = new JPanel();
JPanel emp_cal27 = new JPanel();
JPanel emp_cal28 = new JPanel();
JPanel emp_cal29 = new JPanel();
JPanel emp_cal30 = new JPanel();
JPanel emp_cal31 = new JPanel();
JPanel emp_cal32 = new JPanel();
JPanel emp_cal33 = new JPanel();
JPanel emp_cal34 = new JPanel();
JPanel emp_cal35 = new JPanel();

///////*/*///////////////////////////////

////////////PROJECT-SCHEDULE-TABBEDPANE

JTabbedPane proj_schedule_TP = new JTabbedPane();

JPanel proj_day_panel = new JPanel();
JPanel proj_week_panel = new JPanel();
JPanel proj_month_panel = new JPanel();

JComboBox proj_day_combobox = new JComboBox();
JComboBox proj_week_combobox = new JComboBox();
JComboBox proj_month_combobox = new JComboBox();

JPanel emp_day_combo_panel = new JPanel();	
JPanel emp_day_sched_panel = new JPanel();	

JPanel emp_week_combo_panel = new JPanel();
JPanel emp_week_sched_panel = new JPanel();	

JPanel emp_month_combo_panel = new JPanel();	
JPanel emp_month_sched_panel = new JPanel();

JPanel proj_day_combo_panel = new JPanel();			
JPanel proj_day_sched_panel = new JPanel();

JPanel proj_week_combo_panel = new JPanel();			
JPanel proj_week_sched_panel = new JPanel();			

JPanel proj_month_combo_panel = new JPanel();			
JPanel proj_month_sched_panel = new JPanel();			

///////////////////Project Daily Schedule Area//////////////////////////////////////////////
JPanel proj_day_sched_panel_time = new JPanel();
JPanel proj_day_sched_panel_center = new JPanel();
 JPanel proj_hour1_panel = new JPanel();	
 JPanel proj_hour2_panel = new JPanel();
 JPanel proj_hour3_panel = new JPanel();
 JPanel proj_hour4_panel = new JPanel();
 JPanel proj_hour5_panel = new JPanel();
 JPanel proj_hour6_panel = new JPanel();
 JPanel proj_hour7_panel = new JPanel();
 JPanel proj_hour8_panel = new JPanel();

JPanel proj_daily_9 = new JPanel(); 
JLabel proj_jl_9 = new JLabel("9");

JPanel proj_daily_10 = new JPanel(); 
JLabel proj_jl_10 = new JLabel("10");

JPanel proj_daily_11 = new JPanel(); 
JLabel proj_jl_11 = new JLabel("11");

JPanel proj_daily_12 = new JPanel(); 
JLabel proj_jl_12 = new JLabel("12");

JPanel proj_daily_1 = new JPanel(); 
JLabel proj_jl_1 = new JLabel("1");

JPanel proj_daily_2 = new JPanel(); 
JLabel proj_jl_2 = new JLabel("2");

JPanel proj_daily_3 = new JPanel(); 
JLabel proj_jl_3 = new JLabel("3");

JPanel proj_daily_4 = new JPanel(); 
JLabel proj_jl_4 = new JLabel("4");
JLabel proj_jl_5 = new JLabel("5");
 
////////////////////Project Weekly Schedule Area////////////////////////////////////////////
JPanel proj_week_sched_panel_center = new JPanel();
JPanel proj_week_sched_panel_north = new JPanel();

JPanel proj_mon_panel = new JPanel();
JPanel proj_tues_panel = new JPanel();
JPanel proj_wed_panel = new JPanel();
JPanel proj_thur_panel = new JPanel();
JPanel proj_fri_panel = new JPanel();
JPanel proj_sat_panel = new JPanel();

JPanel proj_time0_panel = new JPanel();
JPanel proj_time1_panel = new JPanel();
JPanel proj_time2_panel = new JPanel();
JPanel proj_time3_panel = new JPanel();
JPanel proj_time4_panel = new JPanel();
JPanel proj_time5_panel = new JPanel();
JPanel proj_time6_panel = new JPanel();
JPanel proj_time7_panel = new JPanel();
JPanel proj_time8_panel = new JPanel();

JPanel proj_mon9_panel = new JPanel();
JPanel proj_mon10_panel = new JPanel();
JPanel proj_mon11_panel = new JPanel();
JPanel proj_mon12_panel = new JPanel();
JPanel proj_mon1_panel = new JPanel();
JPanel proj_mon2_panel = new JPanel();
JPanel proj_mon3_panel = new JPanel();
JPanel proj_mon4_panel = new JPanel();

JPanel proj_tues9_panel = new JPanel();
JPanel proj_tues10_panel = new JPanel();
JPanel proj_tues11_panel = new JPanel();
JPanel proj_tues12_panel = new JPanel();
JPanel proj_tues1_panel = new JPanel();
JPanel proj_tues2_panel = new JPanel();
JPanel proj_tues3_panel = new JPanel();
JPanel proj_tues4_panel = new JPanel();

JPanel proj_wed9_panel = new JPanel();
JPanel proj_wed10_panel = new JPanel();
JPanel proj_wed11_panel = new JPanel();
JPanel proj_wed12_panel = new JPanel();
JPanel proj_wed1_panel = new JPanel();
JPanel proj_wed2_panel = new JPanel();
JPanel proj_wed3_panel = new JPanel();
JPanel proj_wed4_panel = new JPanel();

JPanel proj_thur9_panel = new JPanel();
JPanel proj_thur10_panel = new JPanel();
JPanel proj_thur11_panel = new JPanel();
JPanel proj_thur12_panel = new JPanel();
JPanel proj_thur1_panel = new JPanel();
JPanel proj_thur2_panel = new JPanel();
JPanel proj_thur3_panel = new JPanel();
JPanel proj_thur4_panel = new JPanel();

JPanel proj_fri9_panel = new JPanel();
JPanel proj_fri10_panel = new JPanel();
JPanel proj_fri11_panel = new JPanel();
JPanel proj_fri12_panel = new JPanel();
JPanel proj_fri1_panel = new JPanel();
JPanel proj_fri2_panel = new JPanel();
JPanel proj_fri3_panel = new JPanel();
JPanel proj_fri4_panel = new JPanel();

JPanel proj_sat9_panel = new JPanel();
JPanel proj_sat10_panel = new JPanel();
JPanel proj_sat11_panel = new JPanel();
JPanel proj_sat12_panel = new JPanel();
JPanel proj_sat1_panel = new JPanel();
JPanel proj_sat2_panel = new JPanel();
JPanel proj_sat3_panel = new JPanel();
JPanel proj_sat4_panel = new JPanel();

/////////////////Project Monthly Schedule Area///////////////////////////

JPanel proj_month_north_panel = new JPanel();
JPanel proj_month_center_panel = new JPanel();

JPanel proj_cal_mon_panel = new JPanel();
JPanel proj_cal_tue_panel = new JPanel();
JPanel proj_cal_wed_panel = new JPanel();
JPanel proj_cal_thu_panel = new JPanel();
JPanel proj_cal_fri_panel = new JPanel();
JPanel proj_cal_sat_panel = new JPanel();
JPanel proj_cal_sun_panel = new JPanel();

JPanel proj_cal1 = new JPanel();
JPanel proj_cal2 = new JPanel();
JPanel proj_cal3 = new JPanel();
JPanel proj_cal4 = new JPanel();
JPanel proj_cal5 = new JPanel();
JPanel proj_cal6 = new JPanel();
JPanel proj_cal7 = new JPanel();
JPanel proj_cal8 = new JPanel();
JPanel proj_cal9 = new JPanel();
JPanel proj_cal10 = new JPanel();
JPanel proj_cal11 = new JPanel();
JPanel proj_cal12 = new JPanel();
JPanel proj_cal13 = new JPanel();
JPanel proj_cal14 = new JPanel();
JPanel proj_cal15 = new JPanel();
JPanel proj_cal16 = new JPanel();
JPanel proj_cal17 = new JPanel();
JPanel proj_cal18 = new JPanel();
JPanel proj_cal19 = new JPanel();
JPanel proj_cal20 = new JPanel();
JPanel proj_cal21 = new JPanel();
JPanel proj_cal22 = new JPanel();
JPanel proj_cal23 = new JPanel();
JPanel proj_cal24 = new JPanel();
JPanel proj_cal25 = new JPanel();
JPanel proj_cal26 = new JPanel();
JPanel proj_cal27 = new JPanel();
JPanel proj_cal28 = new JPanel();
JPanel proj_cal29 = new JPanel();
JPanel proj_cal30 = new JPanel();
JPanel proj_cal31 = new JPanel();
JPanel proj_cal32 = new JPanel();
JPanel proj_cal33 = new JPanel();
JPanel proj_cal34 = new JPanel();
JPanel proj_cal35 = new JPanel();

///////////////////////////////////PROJ-TASK-APPTT-GANTT//////////////////////////////////
	
	JTabbedPane proj_task_apptt_depend_TP = new JTabbedPane();

	JPanel proj2_panel = new JPanel();
	JPanel task_panel = new JPanel();
	JPanel apptt_panel = new JPanel();
	JPanel depend_panel = new JPanel();
	
	////////////////////NEW-EDIT-DELETE-TABBEDPANE (PROJECT)
	
	JTabbedPane new_edit_delete_TP_proj=new JTabbedPane();

	JPanel new_proj_panel = new JPanel();
	JPanel edit_proj_panel = new JPanel();
	JPanel delete_proj_panel = new JPanel();
String[] projects = { "WORK GROUP TASK SCHEDULER", "MEDICAL INVENTORY CONTROL", "CLOTHES SHOP INVENTORY", "KERBEROS ALGORITHM", "DISTRIBUTED BANKING SYSTEM", "LINUX BASED TEACHIND AID", "BOKKS INVENTORY CONTROL", "NETWORK SECURITY", "SPEAKING CALCULATOR", "WINDOWS DIRECTORY SERVICES"};
JList delete_proj_list = new JList(projects);

/////////////////// SUB PANELS OF "NEW proj_TASK PANEL" ////////////////////////////////////
	JButton more_color_task_btn = new JButton("...");	
	JButton more_color_task_btn1 = new JButton("...");	
	JButton more_color_apptt_btn = new JButton("...");
	JComboBox proj_title_combo = new JComboBox();


JComboBox proj_delete_combo = new JComboBox();

////////////////////////////////  DEPENDENCIES PANEL  //////////////////////////////////////
JComboBox combobox = new JComboBox();
JPanel proj_depend_combo_panel = new JPanel();

    /*final static*/ String str_proj_x = "Project XXX";
	/*final static*/String str_proj_y = "Project YYY";
	/*final static*/ String str_proj_z = "Project ZZZ";

 	JPanel cards_panel;
    JPanel combo_panel;
	
	JPanel proj_x_panel;			
    JPanel proj_y_panel;
    JPanel proj_z_panel;
	JTextField apptt_title_tf = new JTextField();
	JTextArea new_apptt_descrip_ta = new JTextArea(2,20);
	
//////////////////NEW-EDIT-DELETE-TABBDEPANE- (TASK)
	
	JTabbedPane new_edit_delete_TP_task=new JTabbedPane();
	
	JPanel edit_task_panel = new JPanel();
	JPanel delete_task_panel = new JPanel();
	
	//////////////NEW-EDIT-DELETE-TABBEDPANE- (APPTT)
		
	JTabbedPane new_edit_delete_TP_apptt=new JTabbedPane();

	JPanel new_apptt_panel = new JPanel();
	JPanel edit_apptt_panel = new JPanel();
	JPanel delete_apptt_panel = new JPanel();
	
//////////////////////	ADDING DATE PANEL IN NEW_PROJ_PANEL 	////////////////////////
    private DateButton startDateButton;
    private DateButton endDateButton;
    private Date startDate;
    private Date endDate;
	JButton proj_save_btn = new JButton("Save");
	JButton proj_cancel_btn = new JButton("Cancel");
	JTextField proj_title_tf = new JTextField();
	
JComboBox edit_proj_title_combo = new JComboBox();
	
	


/////////////////*************  CENTER PANEL(MAIN PANEL)  ***************///////////////////

JPanel center_panel = new JPanel();	
 
////////////////////////////////////// SPLITPANE ///////////////////////////////////////////	

JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,emp_proj_TP,proj_task_apptt_depend_TP);	
////////////////////////////////////////CONSTRUCTOR////////////////////////////////////////

	public Project()
	{
		super("Work Group Task Scheduler");
		Container cp=getContentPane();
		
////*************new Addition	MENU ITEMS DECLARED AND ADDED	  new addition*********//////
		
		JMenuBar menubar=new JMenuBar();
		
		JMenu    menu1 = new JMenu("File");
		
		JMenuItem menuitem1 = new JMenuItem("New");
		JMenuItem menuitem2 = new JMenuItem("Open");
		JMenuItem menuitem3 = new JMenuItem("Exit");
		
		menu1.add(menuitem1);
		menu1.add(menuitem2);
		menu1.addSeparator();
		menu1.add(menuitem3);
		
		JMenu menu2 = new JMenu("Edit");
		
		JMenuItem menuitem4 = new JMenuItem("Cut");
		JMenuItem menuitem5 = new JMenuItem("Copy");
		JMenuItem menuitem6 = new JMenuItem("Paste");
		
		menu2.add(menuitem4);
		menu2.add(menuitem5);
		menu2.add(menuitem6);
		
		JMenu 	 menu3=new JMenu("Personal Info");
		
		JMenuItem menuitem7 = new JMenuItem("Work Blocks");
		JMenuItem menuitem8 = new JMenuItem("Address");
		JMenuItem menuitem9 = new JMenuItem("E-mail");
				
		menu3.add(menuitem7);
		menu3.add(menuitem8);
		menu3.add(menuitem9);
		
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
	
		menu1.setMnemonic('F');
		menu2.setMnemonic('E');
		menu3.setMnemonic('P');
		
		setJMenuBar(menubar);
		
/********************************	LOOK AND FEEL RADIO BUTTONS	   *************************/	 


		ButtonGroup bg=new ButtonGroup();
		bg.add(rad_btn1);
		bg.add(rad_btn2);
		bg.add(rad_btn3);

//////////////////Radio Button Mnemonics
		
		rad_btn1.setMnemonic('M');
		rad_btn2.setMnemonic('o');
		rad_btn3.setMnemonic('W');

////////////////Radio Button ToolTips
		
		rad_btn1.setToolTipText("Metal Look 'n Feel");
		rad_btn2.setToolTipText("Motif Look 'n Feel");
		rad_btn3.setToolTipText("Windows Look 'n Feel");
		
////////////////Radio Button Action Listener 
		
		rad_btn1.addActionListener(this);
		rad_btn2.addActionListener(this);
		rad_btn3.addActionListener(this);


		
		rad_panel.add(rad_btn1);
		rad_panel.add(rad_btn2);
		rad_panel.add(rad_btn3);
		
		
//////////////////////TABS OF EMP_PROJ_TABBED PANE//////////////////////////////////////////
		
		emp_proj_TP.addTab("Employee",null,emp_schedule_TP,"This is Employee Schedule Area");
		emp_proj_TP.addTab("Project",null,proj_schedule_TP,"This is Project Schedule Area");
		
//		proj2_panel.add(new JLabel("Project related matters here"));
//		task_panel.add(new JLabel("Task related matters here"));
//    	apptt_panel.add(new JLabel("Appointment related matters here"));
		depend_panel.add(new JLabel("Dependencies related matters here"));
		
emp_schedule_TP.addTab("Day",null,emp_day_panel,"Day Schedul Area of Emplyee");
emp_schedule_TP.addTab("Week",null,emp_week_panel,"Week Schedule Area of Employee");
emp_schedule_TP.addTab("Month",null,emp_month_panel,"Monthly Schedule Area of Employee");


emp_day_combo_panel.add(emp_day_combobox);
emp_day_combobox.addItem("Sohail Siddiqui");
emp_day_combobox.addItem("Naumaan Tareq");
emp_day_combobox.addItem("Umer Uzair");
emp_day_panel.setLayout(new BorderLayout());
emp_day_panel.add(emp_day_combo_panel,BorderLayout.NORTH);
emp_day_panel.add(emp_day_sched_panel,BorderLayout.CENTER);

//////Creating Border
emp_day_sched_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Day Schedule Area"));

emp_week_combo_panel.add(emp_week_combobox);
emp_week_combobox.addItem("Sohail Siddiqui");
emp_week_combobox.addItem("Naumaan Tareq");
emp_week_combobox.addItem("Umer Uzair");
emp_week_panel.setLayout(new BorderLayout());
emp_week_panel.add(emp_week_combo_panel,BorderLayout.NORTH);
emp_week_panel.add(emp_week_sched_panel,BorderLayout.CENTER);

//////Creating Border
emp_week_sched_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Week Schedule Area"));

emp_month_combo_panel.add(emp_month_combobox);
emp_month_combobox.addItem("Sohail Siddiqui");
emp_month_combobox.addItem("Naumaan Tareq");
emp_month_combobox.addItem("Umer Uzair");
emp_month_panel.setLayout(new BorderLayout());
emp_month_panel.add(emp_month_combo_panel,BorderLayout.NORTH);
emp_month_panel.add(emp_month_sched_panel,BorderLayout.CENTER);

//////Creating Border
emp_month_sched_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Month Schedule Area"));

proj_day_combo_panel.add(proj_day_combobox);
proj_day_combobox.addItem("ProjectX daily");
proj_day_combobox.addItem("ProjectY daily");
proj_day_combobox.addItem("ProjectZ daily");
proj_day_panel.setLayout(new BorderLayout());
proj_day_panel.add(proj_day_combo_panel,BorderLayout.NORTH);
proj_day_panel.add(proj_day_sched_panel,BorderLayout.CENTER);

//////Creating Border
proj_day_sched_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Day schedule area"));

proj_week_combo_panel.add(proj_week_combobox);
proj_week_combobox.addItem("ProjectX weekly");
proj_week_combobox.addItem("ProjectY weekly");
proj_week_combobox.addItem("ProjectZ weekly");
proj_week_panel.setLayout(new BorderLayout());
proj_week_panel.add(proj_week_combo_panel,BorderLayout.NORTH);
proj_week_panel.add(proj_week_sched_panel,BorderLayout.CENTER);

//////Creating Border
proj_week_sched_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Week Schedule Area"));

proj_month_combo_panel.add(proj_month_combobox);
proj_month_combobox.addItem("ProjectX monthly");
proj_month_combobox.addItem("ProjectY monthly");
proj_month_combobox.addItem("ProjectZ monthly");
proj_month_panel.setLayout(new BorderLayout());
proj_month_panel.add(proj_month_combo_panel,BorderLayout.NORTH);
proj_month_panel.add(proj_month_sched_panel,BorderLayout.CENTER);

//////Creating Border
proj_month_sched_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Month Schedule Area"));

proj_schedule_TP.addTab("Day",null,proj_day_panel,"Day Schedule Area of Project");
proj_schedule_TP.addTab("Week",null,proj_week_panel,"Week Schedule Area of Project");
proj_schedule_TP.addTab("Month",null,proj_month_panel,"Month Schedule Area of Project");

///////////////////Project Daily Schedule Area Hours/////////////////////////////////////////

proj_day_sched_panel.setLayout(new BorderLayout());

proj_day_sched_panel.add(proj_day_sched_panel_time,BorderLayout.NORTH);

proj_day_sched_panel_time.setLayout(new GridLayout(1,8));
proj_day_sched_panel_time.add(proj_daily_9);	proj_daily_9.setBackground(Color.white);		
proj_daily_9.setLayout(new BorderLayout());
proj_daily_9.add(proj_jl_9,BorderLayout.WEST);

proj_day_sched_panel_time.add(proj_daily_10);	proj_daily_10.setBackground(Color.white);		
proj_daily_10.setLayout(new BorderLayout());
proj_daily_10.add(proj_jl_10,BorderLayout.WEST);

proj_day_sched_panel_time.add(proj_daily_11);	proj_daily_11.setBackground(Color.white);		
proj_daily_11.setLayout(new BorderLayout());
proj_daily_11.add(proj_jl_11,BorderLayout.WEST);

proj_day_sched_panel_time.add(proj_daily_12);	proj_daily_12.setBackground(Color.white);		
proj_daily_12.setLayout(new BorderLayout());
proj_daily_12.add(proj_jl_12,BorderLayout.WEST);

proj_day_sched_panel_time.add(proj_daily_1);	proj_daily_1.setBackground(Color.white);		
proj_daily_1.setLayout(new BorderLayout());
proj_daily_1.add(proj_jl_1,BorderLayout.WEST);

proj_day_sched_panel_time.add(proj_daily_2);	proj_daily_2.setBackground(Color.white);		
proj_daily_2.setLayout(new BorderLayout());
proj_daily_2.add(proj_jl_2,BorderLayout.WEST);

proj_day_sched_panel_time.add(proj_daily_3);	proj_daily_3.setBackground(Color.white);		
proj_daily_3.setLayout(new BorderLayout());
proj_daily_3.add(proj_jl_3,BorderLayout.WEST);

proj_day_sched_panel_time.add(proj_daily_4);		proj_daily_4.setBackground(Color.white);		
proj_daily_4.setLayout(new BorderLayout());
proj_daily_4.add(proj_jl_4,BorderLayout.WEST);
proj_daily_4.add(proj_jl_5,BorderLayout.EAST);

proj_day_sched_panel.add(proj_day_sched_panel_center,BorderLayout.CENTER);
proj_day_sched_panel_center.setLayout(new GridLayout(1,8));

proj_day_sched_panel_center.add(proj_hour1_panel);		
proj_hour1_panel.setBackground(Color.red);

proj_day_sched_panel_center.add(proj_hour2_panel);		
proj_hour2_panel.setBackground(Color.green);

proj_day_sched_panel_center.add(proj_hour3_panel);		
proj_hour3_panel.setBackground(Color.red);

proj_day_sched_panel_center.add(proj_hour4_panel);		
proj_hour4_panel.setBackground(Color.green);

proj_day_sched_panel_center.add(proj_hour5_panel);		
proj_hour5_panel.setBackground(Color.red);

proj_day_sched_panel_center.add(proj_hour6_panel);		
proj_hour6_panel.setBackground(Color.green);

proj_day_sched_panel_center.add(proj_hour7_panel);		
proj_hour7_panel.setBackground(Color.red);

proj_day_sched_panel_center.add(proj_hour8_panel);		
proj_hour8_panel.setBackground(Color.green);


////////////////////////Project WEEKLY SCHEDULE Area/////////////////////////////////////////

proj_week_sched_panel.setLayout(new BorderLayout());		

proj_week_sched_panel.add(proj_week_sched_panel_center,BorderLayout.CENTER);
proj_week_sched_panel.add(proj_week_sched_panel_north,BorderLayout.NORTH);

proj_week_sched_panel_north.setLayout(new GridLayout(1,9));

proj_week_sched_panel_north.add(proj_time0_panel);	
//proj_time0_panel.setBackground(Color.black);

proj_week_sched_panel_north.add(proj_time1_panel);  	
proj_time1_panel.setBackground(Color.white);
///
proj_time1_panel.setLayout(new BorderLayout());
proj_time1_panel.add(new JLabel("9"),BorderLayout.WEST);
///
proj_week_sched_panel_north.add(proj_time2_panel);	
proj_time2_panel.setBackground(Color.white);
proj_time2_panel.setLayout(new BorderLayout());
proj_time2_panel.add(new JLabel("10"),BorderLayout.WEST);

proj_week_sched_panel_north.add(proj_time3_panel);	
proj_time3_panel.setBackground(Color.white);
proj_time3_panel.setLayout(new BorderLayout());
proj_time3_panel.add(new JLabel("11"),BorderLayout.WEST);

proj_week_sched_panel_north.add(proj_time4_panel);	
proj_time4_panel.setBackground(Color.white);
proj_time4_panel.setLayout(new BorderLayout());
proj_time4_panel.add(new JLabel("12"),BorderLayout.WEST);

proj_week_sched_panel_north.add(proj_time5_panel);	
proj_time5_panel.setBackground(Color.white);
proj_time5_panel.setLayout(new BorderLayout());
proj_time5_panel.add(new JLabel("1"),BorderLayout.WEST);

proj_week_sched_panel_north.add(proj_time6_panel);	
proj_time6_panel.setBackground(Color.white);
proj_time6_panel.setLayout(new BorderLayout());
proj_time6_panel.add(new JLabel("2"),BorderLayout.WEST);

proj_week_sched_panel_north.add(proj_time7_panel);	
proj_time7_panel.setBackground(Color.white);
proj_time7_panel.setLayout(new BorderLayout());
proj_time7_panel.add(new JLabel("3"),BorderLayout.WEST);

proj_week_sched_panel_north.add(proj_time8_panel);	
proj_time8_panel.setBackground(Color.white);
proj_time8_panel.setLayout(new BorderLayout());
proj_time8_panel.add(new JLabel("4"),BorderLayout.WEST);
proj_time8_panel.add(new JLabel("5"),BorderLayout.EAST);

proj_week_sched_panel_center.setLayout(new GridLayout(6,9));

proj_week_sched_panel_center.add(proj_mon_panel);		 
proj_mon_panel.add(new JLabel("MON"));

proj_week_sched_panel_center.add(proj_mon9_panel);		  
proj_mon9_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_mon10_panel);	
proj_mon10_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_mon11_panel);	
proj_mon11_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_mon12_panel);	
proj_mon12_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_mon1_panel);		
proj_mon1_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_mon2_panel);		
proj_mon2_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_mon3_panel);		
proj_mon3_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_mon4_panel);		
proj_mon4_panel.setBackground(Color.pink);


proj_week_sched_panel_center.add(proj_tues_panel);		 
proj_tues_panel.add(new JLabel("TUE"));

proj_week_sched_panel_center.add(proj_tues9_panel);	
proj_tues9_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_tues10_panel);	
proj_tues10_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_tues11_panel);	
proj_tues11_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_tues12_panel);	
proj_tues12_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_tues1_panel);	
proj_tues1_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_tues2_panel);
proj_tues2_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_tues3_panel);
	proj_tues3_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_tues4_panel);
proj_tues4_panel.setBackground(Color.red);



proj_week_sched_panel_center.add(proj_wed_panel);		 
proj_wed_panel.add(new JLabel("WED"));

proj_week_sched_panel_center.add(proj_wed9_panel);		
proj_wed9_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_wed10_panel);	
proj_wed10_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_wed11_panel);	
proj_wed11_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_wed12_panel);	
proj_wed12_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_wed1_panel);		
proj_wed1_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_wed2_panel);		
proj_wed2_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_wed3_panel);		
proj_wed3_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_wed4_panel);		
proj_wed4_panel.setBackground(Color.pink);


proj_week_sched_panel_center.add(proj_thur_panel);		 
proj_thur_panel.add(new JLabel("THUR"));


proj_week_sched_panel_center.add(proj_thur9_panel);	
proj_thur9_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_thur10_panel);	
proj_thur10_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_thur11_panel);	
proj_thur11_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_thur12_panel);	
proj_thur12_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_thur1_panel);	
proj_thur1_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_thur2_panel);	
proj_thur2_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_thur3_panel);	
proj_thur3_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_thur4_panel);	
proj_thur4_panel.setBackground(Color.red);



proj_week_sched_panel_center.add(proj_fri_panel);		 
proj_fri_panel.add(new JLabel("FRI"));

proj_week_sched_panel_center.add(proj_fri9_panel);		
proj_fri9_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_fri10_panel);	
proj_fri10_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_fri11_panel);	
proj_fri11_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_fri12_panel);	
proj_fri12_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_fri1_panel);		
proj_fri1_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_fri2_panel);		
proj_fri2_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_fri3_panel);		
proj_fri3_panel.setBackground(Color.pink);

proj_week_sched_panel_center.add(proj_fri4_panel);		
proj_fri4_panel.setBackground(Color.pink);


proj_week_sched_panel_center.add(proj_sat_panel);		 
proj_sat_panel.add(new JLabel("SAT"));

proj_week_sched_panel_center.add(proj_sat9_panel);		
proj_sat9_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_sat10_panel);	
proj_sat10_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_sat11_panel);	
proj_sat11_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_sat12_panel);	
proj_sat12_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_sat1_panel);		
proj_sat1_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_sat2_panel);		
proj_sat2_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_sat3_panel);		
proj_sat3_panel.setBackground(Color.red);

proj_week_sched_panel_center.add(proj_sat4_panel);		
proj_sat4_panel.setBackground(Color.red);


////////////////////////////////Project Monthly Schedule Area///////////////////////////////////////
proj_month_sched_panel.setLayout(new BorderLayout());//////

proj_month_sched_panel.add(proj_month_north_panel,BorderLayout.NORTH);//////
proj_month_sched_panel.add(proj_month_center_panel,BorderLayout.CENTER);////////

proj_month_north_panel.setLayout(new GridLayout(1,7));

proj_month_north_panel.add(proj_cal_sun_panel);		
proj_cal_sun_panel.setBackground(Color.gray);
proj_cal_sun_panel.add(new JLabel("SUN"));


proj_month_north_panel.add(proj_cal_mon_panel);		
proj_cal_mon_panel.setBackground(Color.gray);		
proj_cal_mon_panel.add(new JLabel("MON"));

proj_month_north_panel.add(proj_cal_tue_panel);		
proj_cal_tue_panel.setBackground(Color.gray);
proj_cal_tue_panel.add(new JLabel("TUES"));

proj_month_north_panel.add(proj_cal_wed_panel);		
proj_cal_wed_panel.setBackground(Color.gray);
proj_cal_wed_panel.add(new JLabel("WED"));

proj_month_north_panel.add(proj_cal_thu_panel);
proj_cal_thu_panel.setBackground(Color.gray);
proj_cal_thu_panel.add(new JLabel("THU"));

proj_month_north_panel.add(proj_cal_fri_panel);		
proj_cal_fri_panel.setBackground(Color.gray);
proj_cal_fri_panel.add(new JLabel("FRI"));

proj_month_north_panel.add(proj_cal_sat_panel);		
proj_cal_sat_panel.setBackground(Color.gray);
proj_cal_sat_panel.add(new JLabel("SAT"));

proj_month_center_panel.setLayout(new GridLayout(5,7));

proj_month_center_panel.add(proj_cal1);	
proj_cal1.setBackground(Color.black);
proj_cal1.add(new JLabel("31"));

proj_month_center_panel.add(proj_cal2);	
proj_cal2.setBackground(Color.white);
proj_cal2.add(new JLabel("1"));

proj_month_center_panel.add(proj_cal3);
proj_cal3.setBackground(Color.black);
proj_cal3.add(new JLabel("2"));

proj_month_center_panel.add(proj_cal4);
proj_cal4.setBackground(Color.white);
proj_cal4.add(new JLabel("3"));

proj_month_center_panel.add(proj_cal5);		
proj_cal5.setBackground(Color.black);
proj_cal5.add(new JLabel("4"));

proj_month_center_panel.add(proj_cal6);
proj_cal6.setBackground(Color.white);
proj_cal6.add(new JLabel("5"));

proj_month_center_panel.add(proj_cal7);
proj_cal7.setBackground(Color.black);
proj_cal7.add(new JLabel("6"));

proj_month_center_panel.add(proj_cal8);
proj_cal8.setBackground(Color.white);
proj_cal8.add(new JLabel("7"));

proj_month_center_panel.add(proj_cal9);
proj_cal9.setBackground(Color.black);
proj_cal9.add(new JLabel("8"));

proj_month_center_panel.add(proj_cal10);
proj_cal10.setBackground(Color.white);
proj_cal10.add(new JLabel("9"));

proj_month_center_panel.add(proj_cal11);		
proj_cal11.setBackground(Color.black);
proj_cal11.add(new JLabel("10"));

proj_month_center_panel.add(proj_cal12);		
proj_cal12.setBackground(Color.white);
proj_cal12.add(new JLabel("11"));

proj_month_center_panel.add(proj_cal13);		
proj_cal13.setBackground(Color.black);
proj_cal13.add(new JLabel("12"));

proj_month_center_panel.add(proj_cal14);		
proj_cal14.setBackground(Color.white);
proj_cal14.add(new JLabel("13"));

proj_month_center_panel.add(proj_cal15);		
proj_cal15.setBackground(Color.black);
proj_cal15.add(new JLabel("14"));

proj_month_center_panel.add(proj_cal16);		
proj_cal16.setBackground(Color.white);
proj_cal16.add(new JLabel("15"));

proj_month_center_panel.add(proj_cal17);		
proj_cal17.setBackground(Color.black);
proj_cal17.add(new JLabel("16"));

proj_month_center_panel.add(proj_cal18);
proj_cal18.setBackground(Color.white);
proj_cal18.add(new JLabel("17"));

proj_month_center_panel.add(proj_cal19);
proj_cal19.setBackground(Color.black);
proj_cal19.add(new JLabel("18"));

proj_month_center_panel.add(proj_cal20);		
proj_cal20.setBackground(Color.white);
proj_cal20.add(new JLabel("19"));

proj_month_center_panel.add(proj_cal21);
proj_cal21.setBackground(Color.black);
proj_cal21.add(new JLabel("20"));

proj_month_center_panel.add(proj_cal22);
proj_cal22.setBackground(Color.white);
proj_cal22.add(new JLabel("21"));

proj_month_center_panel.add(proj_cal23);
proj_cal23.setBackground(Color.black);
proj_cal23.add(new JLabel("22"));

proj_month_center_panel.add(proj_cal24);
proj_cal24.setBackground(Color.white);
proj_cal24.add(new JLabel("23"));

proj_month_center_panel.add(proj_cal25);
proj_cal25.setBackground(Color.black);
proj_cal25.add(new JLabel("24"));

proj_month_center_panel.add(proj_cal26);
proj_cal26.setBackground(Color.white);
proj_cal26.add(new JLabel("25"));

proj_month_center_panel.add(proj_cal27);
proj_cal27.setBackground(Color.black);
proj_cal27.add(new JLabel("26"));

proj_month_center_panel.add(proj_cal28);
proj_cal28.setBackground(Color.white);
proj_cal28.add(new JLabel("27"));

proj_month_center_panel.add(proj_cal29);
proj_cal29.setBackground(Color.black);
proj_cal29.add(new JLabel("28"));

proj_month_center_panel.add(proj_cal30);
proj_cal30.setBackground(Color.white);
proj_cal30.add(new JLabel("29"));

proj_month_center_panel.add(proj_cal31);
proj_cal31.setBackground(Color.black);
proj_cal31.add(new JLabel("30"));

proj_month_center_panel.add(proj_cal32);
proj_cal32.setBackground(Color.white);

proj_month_center_panel.add(proj_cal33);
proj_cal33.setBackground(Color.black);

proj_month_center_panel.add(proj_cal34);
proj_cal34.setBackground(Color.white);

proj_month_center_panel.add(proj_cal35);
proj_cal35.setBackground(Color.black);


//////////////////////TABS OF PROJ_TASK_APPOINTMENT_GANTT TABBED PANE//////////////////////////////////////////
		
	proj_task_apptt_depend_TP.addTab("Project",null,new_edit_delete_TP_proj,"Initiate, Edit or Delete a Project");
	proj_task_apptt_depend_TP.addTab("Task",null,new_edit_delete_TP_task,"Initiate, Edit or Delete a Project Task");
	proj_task_apptt_depend_TP.addTab("Apptt",null,new_edit_delete_TP_apptt,"Initiate, Edit or Delete an Appointment");
	proj_task_apptt_depend_TP.addTab("Dependencies",null,depend_panel,"View Task Dependencies");

///////////////////ADDING NEW-EDT-DELETE-TABBEDPANE IN THE PROJECT TAB 

	new_edit_delete_TP_proj.addTab("New",null,new_proj_panel,"Initiate a New Project");				
	new_edit_delete_TP_proj.addTab("Edit",null,edit_proj_panel,"Edit existing Project");
	new_edit_delete_TP_proj.addTab("Delete",null,delete_proj_panel,"Delete a Project");
	
/************************* EMP DAY SCHEDULE AREA*************************************/	

emp_day_sched_panel.setLayout(new BorderLayout());

emp_day_sched_panel.add(emp_day_sched_panel_time,BorderLayout.NORTH);

emp_day_sched_panel_time.setLayout(new GridLayout(1,8));
emp_day_sched_panel_time.add(emp_daily_9);		emp_daily_9.setBackground(Color.white);		
emp_daily_9.setLayout(new BorderLayout());
emp_daily_9.add(emp_jl_9,BorderLayout.WEST);

emp_day_sched_panel_time.add(emp_daily_10);		emp_daily_10.setBackground(Color.white);		
emp_daily_10.setLayout(new BorderLayout());
emp_daily_10.add(emp_jl_10,BorderLayout.WEST);

emp_day_sched_panel_time.add(emp_daily_11);		emp_daily_11.setBackground(Color.white);		
emp_daily_11.setLayout(new BorderLayout());
emp_daily_11.add(emp_jl_11,BorderLayout.WEST);

emp_day_sched_panel_time.add(emp_daily_12);		emp_daily_12.setBackground(Color.white);		
emp_daily_12.setLayout(new BorderLayout());
emp_daily_12.add(emp_jl_12,BorderLayout.WEST);

emp_day_sched_panel_time.add(emp_daily_1);		emp_daily_1.setBackground(Color.white);		
emp_daily_1.setLayout(new BorderLayout());
emp_daily_1.add(emp_jl_1,BorderLayout.WEST);

emp_day_sched_panel_time.add(emp_daily_2);			emp_daily_2.setBackground(Color.white);		
emp_daily_2.setLayout(new BorderLayout());
emp_daily_2.add(emp_jl_2,BorderLayout.WEST);

emp_day_sched_panel_time.add(emp_daily_3);	    	emp_daily_3.setBackground(Color.white);		
emp_daily_3.setLayout(new BorderLayout());
emp_daily_3.add(emp_jl_3,BorderLayout.WEST);

emp_day_sched_panel_time.add(emp_daily_4);		    emp_daily_4.setBackground(Color.white);		
emp_daily_4.setLayout(new BorderLayout());
emp_daily_4.add(emp_jl_4,BorderLayout.WEST);
emp_daily_4.add(emp_jl_5,BorderLayout.EAST);

emp_day_sched_panel.add(emp_day_sched_panel_center,BorderLayout.CENTER);
emp_day_sched_panel_center.setLayout(new GridLayout(1,8));

emp_day_sched_panel_center.add(emp_hour1_panel);		
emp_hour1_panel.setBackground(Color.red);

emp_day_sched_panel_center.add(emp_hour2_panel);		
emp_hour2_panel.setBackground(Color.green);

emp_day_sched_panel_center.add(emp_hour3_panel);		
emp_hour3_panel.setBackground(Color.red);

emp_day_sched_panel_center.add(emp_hour4_panel);		
emp_hour4_panel.setBackground(Color.green);

emp_day_sched_panel_center.add(emp_hour5_panel);		
emp_hour5_panel.setBackground(Color.red);

emp_day_sched_panel_center.add(emp_hour6_panel);		
emp_hour6_panel.setBackground(Color.green);

emp_day_sched_panel_center.add(emp_hour7_panel);		
emp_hour7_panel.setBackground(Color.red);

emp_day_sched_panel_center.add(emp_hour8_panel);		
emp_hour8_panel.setBackground(Color.green);


////////////////////////EMPLOYEE WEEKLY SCHEDULE Area/////////////////////////////////////////

emp_week_sched_panel.setLayout(new BorderLayout());		

emp_week_sched_panel.add(emp_week_sched_panel_center,BorderLayout.CENTER);
emp_week_sched_panel.add(emp_week_sched_panel_north,BorderLayout.NORTH);

emp_week_sched_panel_north.setLayout(new GridLayout(1,9));

emp_week_sched_panel_north.add(emp_time0_panel);	
//proj_time0_panel.setBackground(Color.black);

emp_week_sched_panel_north.add(emp_time1_panel);  	
emp_time1_panel.setBackground(Color.white);
///
emp_time1_panel.setLayout(new BorderLayout());
emp_time1_panel.add(new JLabel("9"),BorderLayout.WEST);
///
emp_week_sched_panel_north.add(emp_time2_panel);	
emp_time2_panel.setBackground(Color.white);
emp_time2_panel.setLayout(new BorderLayout());
emp_time2_panel.add(new JLabel("10"),BorderLayout.WEST);

emp_week_sched_panel_north.add(emp_time3_panel);	
emp_time3_panel.setBackground(Color.white);
emp_time3_panel.setLayout(new BorderLayout());
emp_time3_panel.add(new JLabel("11"),BorderLayout.WEST);

emp_week_sched_panel_north.add(emp_time4_panel);	
emp_time4_panel.setBackground(Color.white);
emp_time4_panel.setLayout(new BorderLayout());
emp_time4_panel.add(new JLabel("12"),BorderLayout.WEST);

emp_week_sched_panel_north.add(emp_time5_panel);	
emp_time5_panel.setBackground(Color.white);
emp_time5_panel.setLayout(new BorderLayout());
emp_time5_panel.add(new JLabel("1"),BorderLayout.WEST);

emp_week_sched_panel_north.add(emp_time6_panel);	
emp_time6_panel.setBackground(Color.white);
emp_time6_panel.setLayout(new BorderLayout());
emp_time6_panel.add(new JLabel("2"),BorderLayout.WEST);

emp_week_sched_panel_north.add(emp_time7_panel);	
emp_time7_panel.setBackground(Color.white);
emp_time7_panel.setLayout(new BorderLayout());
emp_time7_panel.add(new JLabel("3"),BorderLayout.WEST);

emp_week_sched_panel_north.add(emp_time8_panel);	
emp_time8_panel.setBackground(Color.white);
emp_time8_panel.setLayout(new BorderLayout());
emp_time8_panel.add(new JLabel("4"),BorderLayout.WEST);
emp_time8_panel.add(new JLabel("5"),BorderLayout.EAST);

emp_week_sched_panel_center.setLayout(new GridLayout(6,9));

emp_week_sched_panel_center.add(emp_mon_panel);		 
emp_mon_panel.add(new JLabel("MON"));

emp_week_sched_panel_center.add(emp_mon9_panel);		  
emp_mon9_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_mon10_panel);	
emp_mon10_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_mon11_panel);	
emp_mon11_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_mon12_panel);	
emp_mon12_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_mon1_panel);		
emp_mon1_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_mon2_panel);		
emp_mon2_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_mon3_panel);		
emp_mon3_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_mon4_panel);		
emp_mon4_panel.setBackground(Color.pink);


emp_week_sched_panel_center.add(emp_tues_panel);		 
emp_tues_panel.add(new JLabel("TUE"));

emp_week_sched_panel_center.add(emp_tues9_panel);	
emp_tues9_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_tues10_panel);	
emp_tues10_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_tues11_panel);	
emp_tues11_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_tues12_panel);	
emp_tues12_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_tues1_panel);	
emp_tues1_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_tues2_panel);
emp_tues2_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_tues3_panel);
emp_tues3_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_tues4_panel);
emp_tues4_panel.setBackground(Color.red);



emp_week_sched_panel_center.add(emp_wed_panel);		 
emp_wed_panel.add(new JLabel("WED"));

emp_week_sched_panel_center.add(emp_wed9_panel);		
emp_wed9_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_wed10_panel);	
emp_wed10_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_wed11_panel);	
emp_wed11_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_wed12_panel);	
emp_wed12_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_wed1_panel);		
emp_wed1_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_wed2_panel);		
emp_wed2_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_wed3_panel);		
emp_wed3_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_wed4_panel);		
emp_wed4_panel.setBackground(Color.pink);


emp_week_sched_panel_center.add(emp_thur_panel);		 
emp_thur_panel.add(new JLabel("THUR"));


emp_week_sched_panel_center.add(emp_thur9_panel);	
emp_thur9_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_thur10_panel);	
emp_thur10_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_thur11_panel);	
emp_thur11_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_thur12_panel);	
emp_thur12_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_thur1_panel);	
emp_thur1_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_thur2_panel);	
emp_thur2_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_thur3_panel);	
emp_thur3_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_thur4_panel);	
emp_thur4_panel.setBackground(Color.red);



emp_week_sched_panel_center.add(emp_fri_panel);		 
emp_fri_panel.add(new JLabel("FRI"));

emp_week_sched_panel_center.add(emp_fri9_panel);		
emp_fri9_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_fri10_panel);	
emp_fri10_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_fri11_panel);	
emp_fri11_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_fri12_panel);	
emp_fri12_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_fri1_panel);		
emp_fri1_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_fri2_panel);		
emp_fri2_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_fri3_panel);		
emp_fri3_panel.setBackground(Color.pink);

emp_week_sched_panel_center.add(emp_fri4_panel);		
emp_fri4_panel.setBackground(Color.pink);


emp_week_sched_panel_center.add(emp_sat_panel);		 
emp_sat_panel.add(new JLabel("SAT"));

emp_week_sched_panel_center.add(emp_sat9_panel);		
emp_sat9_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_sat10_panel);	
emp_sat10_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_sat11_panel);	
emp_sat11_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_sat12_panel);	
emp_sat12_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_sat1_panel);		
emp_sat1_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_sat2_panel);		
emp_sat2_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_sat3_panel);		
emp_sat3_panel.setBackground(Color.red);

emp_week_sched_panel_center.add(emp_sat4_panel);		
emp_sat4_panel.setBackground(Color.red);


////////////////////////////////Employee Monthly Schedule Area///////////////////////////////////////
emp_month_sched_panel.setLayout(new BorderLayout());//////
emp_month_sched_panel.add(emp_month_north_panel,BorderLayout.NORTH);//////
emp_month_sched_panel.add(emp_month_center_panel,BorderLayout.CENTER);////////

emp_month_north_panel.setLayout(new GridLayout(1,7));

emp_month_north_panel.add(emp_cal_sun_panel);		
emp_cal_sun_panel.setBackground(Color.gray);
emp_cal_sun_panel.add(new JLabel("SUN"));


emp_month_north_panel.add(emp_cal_mon_panel);		
emp_cal_mon_panel.setBackground(Color.gray);		
emp_cal_mon_panel.add(new JLabel("MON"));

emp_month_north_panel.add(emp_cal_tue_panel);		
emp_cal_tue_panel.setBackground(Color.gray);
emp_cal_tue_panel.add(new JLabel("TUES"));

emp_month_north_panel.add(emp_cal_wed_panel);		
emp_cal_wed_panel.setBackground(Color.gray);
emp_cal_wed_panel.add(new JLabel("WED"));

emp_month_north_panel.add(emp_cal_thu_panel);
emp_cal_thu_panel.setBackground(Color.gray);
emp_cal_thu_panel.add(new JLabel("THU"));

emp_month_north_panel.add(emp_cal_fri_panel);		
emp_cal_fri_panel.setBackground(Color.gray);
emp_cal_fri_panel.add(new JLabel("FRI"));

emp_month_north_panel.add(emp_cal_sat_panel);		
emp_cal_sat_panel.setBackground(Color.gray);
emp_cal_sat_panel.add(new JLabel("SAT"));

emp_month_center_panel.setLayout(new GridLayout(5,7));

emp_month_center_panel.add(emp_cal1);	
emp_cal1.setBackground(Color.black);
emp_cal1.add(new JLabel("31"));

emp_month_center_panel.add(emp_cal2);	
emp_cal2.setBackground(Color.white);
emp_cal2.add(new JLabel("1"));

emp_month_center_panel.add(emp_cal3);
emp_cal3.setBackground(Color.black);
emp_cal3.add(new JLabel("2"));

emp_month_center_panel.add(emp_cal4);
emp_cal4.setBackground(Color.white);
emp_cal4.add(new JLabel("3"));

emp_month_center_panel.add(emp_cal5);		
emp_cal5.setBackground(Color.black);
emp_cal5.add(new JLabel("4"));

emp_month_center_panel.add(emp_cal6);
emp_cal6.setBackground(Color.white);
emp_cal6.add(new JLabel("5"));

emp_month_center_panel.add(emp_cal7);
emp_cal7.setBackground(Color.black);
emp_cal7.add(new JLabel("6"));

emp_month_center_panel.add(emp_cal8);
emp_cal8.setBackground(Color.white);
emp_cal8.add(new JLabel("7"));

emp_month_center_panel.add(emp_cal9);
emp_cal9.setBackground(Color.black);
emp_cal9.add(new JLabel("8"));

emp_month_center_panel.add(emp_cal10);
emp_cal10.setBackground(Color.white);
emp_cal10.add(new JLabel("9"));

emp_month_center_panel.add(emp_cal11);		
emp_cal11.setBackground(Color.black);
emp_cal11.add(new JLabel("10"));

emp_month_center_panel.add(emp_cal12);		
emp_cal12.setBackground(Color.white);
emp_cal12.add(new JLabel("11"));

emp_month_center_panel.add(emp_cal13);		
emp_cal13.setBackground(Color.black);
emp_cal13.add(new JLabel("12"));

emp_month_center_panel.add(emp_cal14);		
emp_cal14.setBackground(Color.white);
emp_cal14.add(new JLabel("13"));

emp_month_center_panel.add(emp_cal15);		
emp_cal15.setBackground(Color.black);
emp_cal15.add(new JLabel("14"));

emp_month_center_panel.add(emp_cal16);		
emp_cal16.setBackground(Color.white);
emp_cal16.add(new JLabel("15"));

emp_month_center_panel.add(emp_cal17);		
emp_cal17.setBackground(Color.black);
emp_cal17.add(new JLabel("16"));

emp_month_center_panel.add(emp_cal18);
emp_cal18.setBackground(Color.white);
emp_cal18.add(new JLabel("17"));

emp_month_center_panel.add(emp_cal19);
emp_cal19.setBackground(Color.black);
emp_cal19.add(new JLabel("18"));

emp_month_center_panel.add(emp_cal20);		
emp_cal20.setBackground(Color.white);
emp_cal20.add(new JLabel("19"));

emp_month_center_panel.add(emp_cal21);
emp_cal21.setBackground(Color.black);
emp_cal21.add(new JLabel("20"));

emp_month_center_panel.add(emp_cal22);
emp_cal22.setBackground(Color.white);
emp_cal22.add(new JLabel("21"));

emp_month_center_panel.add(emp_cal23);
emp_cal23.setBackground(Color.black);
emp_cal23.add(new JLabel("22"));

emp_month_center_panel.add(emp_cal24);
emp_cal24.setBackground(Color.white);
emp_cal24.add(new JLabel("23"));

emp_month_center_panel.add(emp_cal25);
emp_cal25.setBackground(Color.black);
emp_cal25.add(new JLabel("24"));

emp_month_center_panel.add(emp_cal26);
emp_cal26.setBackground(Color.white);
emp_cal26.add(new JLabel("25"));

emp_month_center_panel.add(emp_cal27);
emp_cal27.setBackground(Color.black);
emp_cal27.add(new JLabel("26"));

emp_month_center_panel.add(emp_cal28);
emp_cal28.setBackground(Color.white);
emp_cal28.add(new JLabel("27"));

emp_month_center_panel.add(emp_cal29);
emp_cal29.setBackground(Color.black);
emp_cal29.add(new JLabel("28"));

emp_month_center_panel.add(emp_cal30);
emp_cal30.setBackground(Color.white);
emp_cal30.add(new JLabel("29"));

emp_month_center_panel.add(emp_cal31);
emp_cal31.setBackground(Color.black);
emp_cal31.add(new JLabel("30"));

emp_month_center_panel.add(emp_cal32);
emp_cal32.setBackground(Color.white);

emp_month_center_panel.add(emp_cal33);
emp_cal33.setBackground(Color.black);

emp_month_center_panel.add(emp_cal34);
emp_cal34.setBackground(Color.white);

emp_month_center_panel.add(emp_cal35);
emp_cal35.setBackground(Color.black);



/********************  	NEW PROJECT PANEL *************************/

	JPanel new_proj_title_panel = new JPanel();
	
	JPanel new_proj_descrip_panel = new JPanel();
	JTextArea new_proj_descrip_ta = new JTextArea(2,20);
	
	JPanel new_proj_start_panel = new JPanel();
	JPanel new_proj_end_panel = new JPanel();
	startDate = new Date();
	endDate = new Date();
	startDateButton = new DateButton();
	endDateButton = new DateButton();
	
	
	JPanel new_proj_effort_panel = new JPanel();
	
	JPanel new_proj_tasks_panel = new JPanel();
	
	JPanel new_proj_prog_panel = new JPanel();
	
	JPanel new_proj_notes_panel = new JPanel();
	JTextArea new_proj_notes_ta = new JTextArea(6,20);	
	
	JComboBox new_proj_status_combo = new JComboBox();
	JPanel new_proj_status_combo_panel = new JPanel();
	
	JPanel new_proj_btns_panel = new JPanel();





new_proj_panel.setLayout(new BoxLayout(new_proj_panel,BoxLayout.Y_AXIS));
	new_proj_panel.add(Box.createVerticalStrut(10));
	new_proj_panel.add(new_proj_title_panel);
	new_proj_panel.add(Box.createVerticalStrut(10));
	new_proj_panel.add(new_proj_descrip_panel);
	new_proj_panel.add(Box.createVerticalStrut(10));
	new_proj_panel.add(new_proj_start_panel);
	new_proj_panel.add(Box.createVerticalStrut(10));
	new_proj_panel.add(new_proj_end_panel);
	new_proj_panel.add(Box.createVerticalStrut(10));
	new_proj_panel.add(new_proj_status_combo_panel);
	new_proj_panel.add(Box.createVerticalStrut(10));
	new_proj_panel.add(new_proj_effort_panel);
	new_proj_panel.add(Box.createVerticalStrut(10));
	new_proj_panel.add(new_proj_tasks_panel);
	new_proj_panel.add(Box.createVerticalStrut(10));
	new_proj_panel.add(new_proj_prog_panel);
	new_proj_panel.add(Box.createVerticalStrut(5));
	new_proj_panel.add(new_proj_notes_panel);
	new_proj_panel.add(Box.createVerticalStrut(10));
	new_proj_panel.add(new_proj_btns_panel);
	new_proj_panel.add(Box.createVerticalStrut(5));


	new_proj_title_panel.setLayout(new BoxLayout(new_proj_title_panel,BoxLayout.X_AXIS));
	new_proj_title_panel.add( new JLabel("Project Title") );
	new_proj_title_panel.add(Box.createHorizontalStrut(20));
	new_proj_title_panel.add(proj_title_tf);
	
JScrollPane new_proj_descrip_sp = new JScrollPane(new_proj_descrip_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	new_proj_descrip_panel.setLayout(new BoxLayout(new_proj_descrip_panel,BoxLayout.X_AXIS));
	new_proj_descrip_panel.add( new JLabel("Description ") );
	new_proj_descrip_panel.add(Box.createHorizontalStrut(20));
	new_proj_descrip_panel.add(new_proj_descrip_sp);
	
	new_proj_start_panel.setLayout(new BoxLayout(new_proj_start_panel,BoxLayout.X_AXIS));
	new_proj_start_panel.add( new JLabel("Start Date") );
	new_proj_start_panel.add(Box.createHorizontalStrut(15));
	new_proj_start_panel.add( startDateButton );

	new_proj_end_panel.setLayout(new BoxLayout(new_proj_end_panel,BoxLayout.X_AXIS));
	new_proj_end_panel.add( new JLabel("Deadline") );
	new_proj_end_panel.add(Box.createHorizontalStrut(22));
	new_proj_end_panel.add( endDateButton );
	pack();
	setResizable(false);
	
new_proj_status_combo.addItem("Not started"); 
new_proj_status_combo.addItem("Waiting");
new_proj_status_combo.addItem("In Progress");	
new_proj_status_combo.addItem("Done");	
new_proj_status_combo_panel.setLayout(new BoxLayout(new_proj_status_combo_panel,BoxLayout.X_AXIS));
new_proj_status_combo_panel.add(new JLabel("Project Status   "));
new_proj_status_combo_panel.add(Box.createHorizontalStrut(20));
new_proj_status_combo_panel.add(new_proj_status_combo);
/*
JTextArea new_proj_effort_ta = new JTextArea();	
new_proj_effort_panel.setLayout(new BoxLayout(new_proj_effort_panel,BoxLayout.X_AXIS));
new_proj_effort_panel.add( new JLabel("Effort ") );
new_proj_effort_panel.add(Box.createHorizontalStrut(20));
new_proj_effort_panel.add(new_proj_effort_ta);
new_proj_effort_panel.add(Box.createHorizontalStrut(0));
new_proj_effort_panel.add(new JLabel("in hrs"));
*/
JTextArea new_proj_effort_ta = new JTextArea();		
new_proj_effort_panel.setLayout(new GridLayout(1,3));
new_proj_effort_panel.add( new JLabel("Effort :") );
new_proj_effort_panel.add(new_proj_effort_ta);
new_proj_effort_panel.add(new JLabel("  in hrs"));

////////////////////////////// ADDING PROGRESS BAR /////////////////////////////////////////
        task = new LongTask();

        //Create the demo's UI.
        startButton = new JButton("Start");
        startButton.setActionCommand("start");
        startButton.addActionListener(new ButtonListener());

        progressBar = new JProgressBar(0, task.getLengthOfTask());
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        JPanel panel = new JPanel();
        new_proj_prog_panel.add(startButton);
        new_proj_prog_panel.add(progressBar);

        //Create a timer.
        timer = new Timer(ONE_SECOND, new ActionListener()
		{
            public void actionPerformed(ActionEvent evt) 
			{
                progressBar.setValue(task.getCurrent());
                if (task.done())
				{
					Toolkit.getDefaultToolkit().beep();
                    timer.stop();
                    startButton.setEnabled(true);
                    progressBar.setValue(progressBar.getMinimum());
                }
            }
        });
////////// remaining items of new project panel are added here 
/*
JPanel new_proj_notes_ta_panel = new JPanel();
JPanel new_proj_notes_title_panel = new JPanel();
JScrollPane new_proj_notes_sp = new JScrollPane(notes_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
new_proj_notes_panel.setLayout(new BorderLayout());
new_proj_notes_panel.add(new_proj_notes_title_panel,BorderLayout.NORTH);
new_proj_notes_panel.add(new_proj_notes_ta_panel,BorderLayout.CENTER);
new_proj_notes_title_panel.add(new JLabel("Notes:"));
new_proj_notes_ta_panel.add(new_proj_notes_sp);
*/
JScrollPane new_proj_notes_sp = new JScrollPane(new_proj_notes_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
new_proj_notes_panel.setLayout(new BoxLayout(new_proj_notes_panel,BoxLayout.X_AXIS));
new_proj_notes_panel.add(new JLabel("Notes: "));
new_proj_notes_panel.add(Box.createHorizontalStrut(20));
new_proj_notes_panel.add(new_proj_notes_sp);

new_proj_btns_panel.add(proj_save_btn);
new_proj_btns_panel.add(proj_cancel_btn);
proj_save_btn.addActionListener(this);
proj_cancel_btn.addActionListener(this);

/////********************	ADDINDG EDIT_PROJECT_PANEL	 *****************************///////

JPanel edit_proj_title_panel = new JPanel();
JPanel edit_proj_title_combo_panel = new JPanel();

JPanel edited_proj_title_panel = new JPanel();
JTextField edited_proj_title_tf = new JTextField();

JPanel edit_proj_descrip_panel = new JPanel();
JTextArea edit_proj_descrip_ta = new JTextArea(2,20);

JPanel edit_proj_start_panel = new JPanel();

JPanel edit_proj_end_panel = new JPanel();

JPanel edit_proj_notes_panel = new JPanel();
JTextArea edit_proj_notes_ta = new JTextArea(6,6);
  
JPanel edit_proj_btn_panel = new JPanel();
JButton edit_proj_save_btn = new JButton("Save");
JButton edit_proj_cancel_btn = new JButton("Cancel");

edit_proj_panel.setLayout(new BoxLayout(edit_proj_panel, BoxLayout.Y_AXIS));
edit_proj_panel.add(Box.createVerticalStrut(30));

edit_proj_panel.add(edit_proj_title_panel);
edit_proj_panel.add(Box.createVerticalStrut(30));

edit_proj_panel.add(edited_proj_title_panel);
edit_proj_panel.add(Box.createVerticalStrut(30));

edit_proj_panel.add(edit_proj_descrip_panel);
edit_proj_panel.add(Box.createVerticalStrut(30));

edit_proj_panel.add(edit_proj_start_panel);
edit_proj_panel.add(Box.createVerticalStrut(30));

edit_proj_panel.add(edit_proj_end_panel);
edit_proj_panel.add(Box.createVerticalStrut(30));

edit_proj_panel.add(edit_proj_notes_panel);
edit_proj_panel.add(Box.createVerticalStrut(30));

edit_proj_panel.add(edit_proj_btn_panel);
edit_proj_panel.add(Box.createVerticalStrut(30));

edit_proj_title_combo.addItem("Project X"); 
edit_proj_title_combo.addItem("Project Y");
edit_proj_title_combo.addItem("Project Z");	
edit_proj_title_panel.setLayout(new BoxLayout(edit_proj_title_panel,BoxLayout.X_AXIS));
edit_proj_title_panel.add(new JLabel("Project Title"));
edit_proj_title_panel.add(Box.createHorizontalStrut(10));
edit_proj_title_panel.add(edit_proj_title_combo);

edited_proj_title_panel.setLayout(new BoxLayout(edited_proj_title_panel,BoxLayout.X_AXIS));
edited_proj_title_panel.add(new JLabel("New Title"));
edited_proj_title_panel.add(Box.createHorizontalStrut(10));
edited_proj_title_panel.add(edited_proj_title_tf);

JScrollPane edit_proj_descrip_sp = new JScrollPane(edit_proj_descrip_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
edit_proj_descrip_panel.setLayout(new BoxLayout(edit_proj_descrip_panel,BoxLayout.X_AXIS));
edit_proj_descrip_panel.add( new JLabel("Description ") );
edit_proj_descrip_panel.add(Box.createHorizontalStrut(20));
edit_proj_descrip_panel.add(edit_proj_descrip_sp);

edit_proj_start_panel.setLayout(new BoxLayout(edit_proj_start_panel, BoxLayout.X_AXIS));
edit_proj_start_panel.add(new JLabel("Start :  "));

edit_proj_end_panel.setLayout(new BoxLayout(edit_proj_end_panel,BoxLayout.X_AXIS));
edit_proj_end_panel.add(new JLabel("DeadLine : "));

JScrollPane edit_proj_notes_sp = new JScrollPane(edit_proj_notes_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
edit_proj_notes_panel.setLayout(new BoxLayout(edit_proj_notes_panel,BoxLayout.X_AXIS));
edit_proj_notes_panel.add(new JLabel("Notes: "));
edit_proj_notes_panel.add(Box.createHorizontalStrut(20));
edit_proj_notes_panel.add(edit_proj_notes_sp);

edit_proj_btn_panel.setLayout(new BoxLayout(edit_proj_btn_panel,BoxLayout.X_AXIS));
edit_proj_btn_panel.add(edit_proj_save_btn);
edit_proj_btn_panel.add(Box.createHorizontalStrut(15));
edit_proj_btn_panel.add(edit_proj_cancel_btn);

////********************	ADDINDG DELETE PROJECT PANEL	*****************************//////
JPanel delete_proj_list_panel = new JPanel();
JPanel delete_proj_btn_panel = new JPanel();
JButton del_proj_save_btn = new JButton("Save");
JButton del_proj_cancel_btn = new JButton("Cancel");

delete_proj_panel.setLayout(new BoxLayout(delete_proj_panel,BoxLayout.Y_AXIS));
delete_proj_panel.add(Box.createVerticalStrut(20));
delete_proj_panel.add(new JLabel("Select a single project or multiple projects to Delete"));
delete_proj_panel.add(Box.createVerticalStrut(20));
delete_proj_panel.add(delete_proj_list_panel);
delete_proj_panel.add(Box.createVerticalStrut(10));
delete_proj_panel.add(delete_proj_btn_panel);

JScrollPane delete_proj_jsp = new JScrollPane(delete_proj_list);  
delete_proj_list.setVisibleRowCount(8);
delete_proj_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
delete_proj_panel.add(Box.createVerticalStrut(10));

delete_proj_list_panel.setLayout(new FlowLayout());
delete_proj_list_panel.add(delete_proj_jsp);


delete_proj_btn_panel.setLayout(new BorderLayout());
delete_proj_btn_panel.add(del_proj_save_btn,BorderLayout.NORTH);
//delete_proj_btn_panel.add(Box.createHorizontalStrut(10));
delete_proj_btn_panel.add(del_proj_cancel_btn,BorderLayout.SOUTH);

/////********************	ADDINDG NEW proj_TASK PANEL	 *****************************///////	

	JPanel new_task_panel = new JPanel();

	JPanel proj_title_combo_panel = new JPanel();
	
	JPanel new_task_title_panel = new JPanel();
	JTextField new_task_title_tf = new JTextField("Task Title");
	
	JPanel new_task_descrip_panel = new JPanel();
	JTextArea new_task_descrip_ta = new JTextArea(2,20);
		
	JPanel new_task_end_panel = new JPanel();
	
	JPanel new_task_start_panel = new JPanel();
	
	JPanel new_task_status_combo_panel = new JPanel();
	JComboBox new_task_status_combo = new JComboBox();
	
	JPanel new_task_allotted_panel = new JPanel();
	
	JPanel new_task_effort_panel = new JPanel();
	JTextArea new_task_effort_ta = new JTextArea();
		
	JPanel new_task_colorchooser_panel = new JPanel();
	JPanel six_color_panel = new JPanel();

	JPanel new_task_notes_panel = new JPanel();
	JTextArea new_task_notes_ta = new JTextArea(6,6);
	
	JPanel new_task_color_btn_panel = new JPanel();
	
	JButton red_task_btn = new JButton("R");
	JButton yellow_task_btn = new JButton("Y");
	JButton green_task_btn = new JButton("G");
	JButton blue_task_btn = new JButton("B");
	JButton magenta_task_btn = new JButton("M");
	JButton cyan_task_btn = new JButton("C");
	
	JPanel new_task_btn_panel = new JPanel();
	JButton new_task_save_btn = new JButton("Save");
	JButton new_task_cancel_btn = new JButton("Cancel");
	

new_task_panel.setLayout(new BoxLayout(new_task_panel,BoxLayout.Y_AXIS));
new_task_panel.add(Box.createVerticalStrut(10));

new_task_panel.add(proj_title_combo_panel);	
new_task_panel.add(Box.createVerticalStrut(10));

new_task_panel.add(new_task_title_panel);
new_task_panel.add(Box.createVerticalStrut(10));

new_task_panel.add(new_task_descrip_panel);
new_task_panel.add(Box.createVerticalStrut(10));

new_task_panel.add(new_task_status_combo_panel);
new_task_panel.add(Box.createVerticalStrut(10));

new_task_panel.add(new_task_effort_panel);			
new_task_panel.add(Box.createVerticalStrut(10));

new_task_panel.add(new_task_allotted_panel);
new_task_panel.add(Box.createVerticalStrut(10));

new_task_panel.add(new_task_colorchooser_panel);
new_task_panel.add(six_color_panel);
new_task_panel.add(Box.createVerticalStrut(10));

new_task_panel.add(new_task_notes_panel);
new_task_panel.add(Box.createVerticalStrut(10));

new_task_panel.add(new_task_color_btn_panel);
more_color_task_btn.addActionListener(this);
more_color_task_btn1.addActionListener(this);

new_task_panel.add(new_task_btn_panel);
new_task_panel.add(Box.createVerticalStrut(10));



proj_title_combo.addItem("Project X"); 
proj_title_combo.addItem("Project Y");
proj_title_combo.addItem("Project Z");	
proj_title_combo_panel.setLayout(new BoxLayout(proj_title_combo_panel,BoxLayout.X_AXIS));
proj_title_combo_panel.add(new JLabel("Project Title"));
proj_title_combo_panel.add(Box.createHorizontalStrut(10));
proj_title_combo_panel.add(proj_title_combo);

new_task_title_panel.setLayout(new BoxLayout(new_task_title_panel,BoxLayout.X_AXIS));
new_task_title_panel.add( new JLabel("Task Title") );
new_task_title_panel.add(Box.createHorizontalStrut(20));
new_task_title_panel.add(new_task_title_tf);
	
JScrollPane new_task_descrip_sp = new JScrollPane(new_task_descrip_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
new_task_descrip_panel.setLayout(new BoxLayout(new_task_descrip_panel,BoxLayout.X_AXIS));
new_task_descrip_panel.add( new JLabel("Description ") );
new_task_descrip_panel.add(Box.createHorizontalStrut(20));
new_task_descrip_panel.add(new_task_descrip_sp);

new_task_status_combo.addItem("Not started"); 
new_task_status_combo.addItem("Waiting");
new_task_status_combo.addItem("In Progress");	
new_task_status_combo.addItem("Done");	
new_task_status_combo_panel.setLayout(new BoxLayout(new_task_status_combo_panel,BoxLayout.X_AXIS));
new_task_status_combo_panel.add(new JLabel("Task Status   "));
new_task_status_combo_panel.add(Box.createHorizontalStrut(20));
new_task_status_combo_panel.add(new_task_status_combo);

new_task_effort_panel.setLayout(new GridLayout(1,3));
new_task_effort_panel.add(new JLabel("Effort :: "));
new_task_effort_panel.add(new_task_effort_ta);
new_task_effort_panel.add(new JLabel(" in hrs"));

JComboBox allotted_combo = new JComboBox();
allotted_combo.addItem("Umer Uzair");
allotted_combo.addItem("Sohail Siddiqui");
allotted_combo.addItem("Sayyed Naumaan Tareq");
new_task_allotted_panel.setLayout(new BoxLayout(new_task_allotted_panel,BoxLayout.X_AXIS));
new_task_allotted_panel.add(new JLabel("Allotted To: "));
new_task_allotted_panel.add(Box.createHorizontalStrut(30));
new_task_allotted_panel.add(allotted_combo);


new_task_colorchooser_panel.setLayout(new BoxLayout(new_task_colorchooser_panel,BoxLayout.X_AXIS));
new_task_colorchooser_panel.add(new JLabel("Choose Color"));
new_task_colorchooser_panel.add(Box.createHorizontalStrut(20));
new_task_colorchooser_panel.add(more_color_task_btn);

six_color_panel.add(red_task_btn);
red_task_btn.setBackground(Color.red);
six_color_panel.add(blue_task_btn);
blue_task_btn.setBackground(Color.blue);
six_color_panel.add(green_task_btn);
green_task_btn.setBackground(Color.green);
six_color_panel.add(yellow_task_btn);
yellow_task_btn.setBackground(Color.yellow);
six_color_panel.add(cyan_task_btn);
cyan_task_btn.setBackground(Color.cyan);
six_color_panel.add(magenta_task_btn);
magenta_task_btn.setBackground(Color.magenta);

JScrollPane new_task_notes_sp = new JScrollPane(new_task_notes_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
new_task_notes_panel.setLayout(new BoxLayout(new_task_notes_panel,BoxLayout.X_AXIS));
new_task_notes_panel.add( new JLabel("Notes ") );
new_task_notes_panel.add(Box.createHorizontalStrut(20));
new_task_notes_panel.add(new_task_notes_sp);

new_task_btn_panel.setLayout(new BoxLayout(new_task_btn_panel,BoxLayout.X_AXIS));
new_task_btn_panel.add(new_task_save_btn);
new_task_btn_panel.add(Box.createHorizontalStrut(20));
new_task_btn_panel.add(new_task_cancel_btn);

//////****************		ADDING EDIT_TASK_PANEL		********************////////

edit_task_panel.setLayout(new BoxLayout(edit_task_panel, BoxLayout.Y_AXIS));

JPanel edit_task_title_combo_panel = new JPanel();
JComboBox edit_task_title_combo = new JComboBox();

JPanel edit_task_title_panel = new JPanel();
JTextField edit_task_title_tf = new JTextField(); 

JPanel edit_task_descrip_panel = new JPanel();
JTextArea edit_task_descrip_ta = new JTextArea(2,20);

JPanel edit_task_effort_panel = new JPanel();
JTextArea edit_task_effort_ta = new JTextArea(1,4);

JPanel edit_task_allotted_panel = new JPanel();
JComboBox edit_task_allotted_combo = new JComboBox();

JPanel edit_task_color_panel = new JPanel();

JPanel edit_task_notes_panel = new JPanel();
JTextArea edit_task_notes_ta = new JTextArea(5,8);

JPanel edit_task_btn_panel = new JPanel();
JButton edit_task_save_btn = new JButton("Save");
JButton edit_task_cancel_btn = new JButton("Cancel");

edit_task_panel.add(Box.createVerticalStrut(20));
edit_task_panel.add(edit_task_title_combo_panel);
edit_task_panel.add(Box.createVerticalStrut(20));

edit_task_panel.add(edit_task_title_panel);
edit_task_panel.add(Box.createVerticalStrut(20));

edit_task_panel.add(edit_task_descrip_panel);
edit_task_panel.add(Box.createVerticalStrut(20));

edit_task_panel.add(edit_task_effort_panel);
edit_task_panel.add(Box.createVerticalStrut(20));

edit_task_panel.add(edit_task_allotted_panel);
edit_task_panel.add(Box.createVerticalStrut(20));

edit_task_panel.add(edit_task_color_panel);
edit_task_panel.add(Box.createVerticalStrut(20));

edit_task_panel.add(edit_task_notes_panel);
edit_task_panel.add(Box.createVerticalStrut(20));

edit_task_panel.add(edit_task_btn_panel);
edit_task_panel.add(Box.createVerticalStrut(20));

edit_task_title_combo.addItem("Task X");
edit_task_title_combo.addItem("Task Y");
edit_task_title_combo.addItem("Task Z");
edit_task_title_combo_panel.setLayout(new BoxLayout(edit_task_title_combo_panel,BoxLayout.X_AXIS));
edit_task_title_combo_panel.add( new JLabel("Title") );
edit_task_title_combo_panel.add(Box.createHorizontalStrut(20));
edit_task_title_combo_panel.add(edit_task_title_combo);

edit_task_title_panel.setLayout(new BoxLayout(edit_task_title_panel,BoxLayout.X_AXIS));
edit_task_title_panel.add( new JLabel("Title") );
edit_task_title_panel.add(Box.createHorizontalStrut(20));
edit_task_title_panel.add(edit_task_title_tf);

JScrollPane edit_task_descrip_sp = new JScrollPane(edit_task_descrip_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
edit_task_descrip_panel.setLayout(new BoxLayout(edit_task_descrip_panel,BoxLayout.X_AXIS));
edit_task_descrip_panel.add( new JLabel("Description") );
edit_task_descrip_panel.add(Box.createHorizontalStrut(20));
edit_task_descrip_panel.add(edit_task_descrip_sp);
	
//edit_task_effort_panel.setLayout(new BoxLayout(edit_task_effort_panel,BoxLayout.X_AXIS));
//edit_task_effort_panel.add( new JLabel("Effort"));
//edit_task_effort_panel.add(Box.createHorizontalStrut(20));
//edit_task_effort_panel.add(edit_task_effort_ta);
//edit_task_effort_panel.add(new JLabel("in hrs"));

edit_task_effort_panel.setLayout(new GridLayout(1,3));
edit_task_effort_panel.add(new JLabel("Effort"));
edit_task_effort_panel.add(edit_task_effort_ta);
edit_task_effort_panel.add(new JLabel("  in hrs"));

edit_task_allotted_combo.addItem("Umer Uzair");
edit_task_allotted_combo.addItem("Sohail Siddiqui");
edit_task_allotted_combo.addItem("Ssyyed Naumaan Tareq");
edit_task_allotted_panel.setLayout(new BoxLayout(edit_task_allotted_panel,BoxLayout.X_AXIS));
edit_task_allotted_panel.add( new JLabel("Allotted To ") );
edit_task_allotted_panel.add(Box.createHorizontalStrut(20));
edit_task_allotted_panel.add(edit_task_allotted_combo);


edit_task_color_panel.setLayout(new BoxLayout(edit_task_color_panel,BoxLayout.X_AXIS));
edit_task_color_panel.add( new JLabel("Choose Color") );
edit_task_color_panel.add(Box.createHorizontalStrut(20));
edit_task_color_panel.add(more_color_task_btn1);

JScrollPane edit_task_notes_sp = new JScrollPane(edit_task_notes_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
edit_task_notes_panel.setLayout(new BoxLayout(edit_task_notes_panel,BoxLayout.X_AXIS));
edit_task_notes_panel.add( new JLabel("Notes") );
edit_task_notes_panel.add(Box.createHorizontalStrut(20));
edit_task_notes_panel.add(edit_task_notes_sp);

edit_task_btn_panel.setLayout(new BoxLayout(edit_task_btn_panel,BoxLayout.X_AXIS));
edit_task_btn_panel.add(edit_task_save_btn );
edit_task_btn_panel.add(Box.createHorizontalStrut(20));
edit_task_btn_panel.add(edit_task_cancel_btn);

////********************	ADDINDG DELETE TASK PANEL	*****************************//////
JPanel delete_task_list_panel = new JPanel();
String[] tasks = { "WORK GROUP TASK SCHEDULER", "MEDICAL INVENTORY CONTROL", "CLOTHES SHOP INVENTORY", "KERBEROS ALGORITHM", "DISTRIBUTED BANKING SYSTEM", "LINUX BASED TEACHIND AID", "BOKKS INVENTORY CONTROL", "NETWORK SECURITY", "SPEAKING CALCULATOR", "WINDOWS DIRECTORY SERVICES"};
JList delete_task_list = new JList(tasks);

proj_delete_combo.addItem("Project XXX"); 
proj_delete_combo.addItem("Project YYY");
proj_delete_combo.addItem("Project ZZZ");
proj_delete_combo.addItem("Project AAA");

JScrollPane delete_task_jsp = new JScrollPane(delete_task_list);  
delete_task_list.setVisibleRowCount(8);
delete_task_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

delete_task_panel.setLayout(new BoxLayout(delete_task_panel,BoxLayout.Y_AXIS));
delete_task_panel.add(Box.createVerticalStrut(30));
delete_task_panel.add(new JLabel("Select a project "));
delete_task_panel.add(Box.createVerticalStrut(5));
delete_task_panel.add(proj_delete_combo);
delete_task_panel.add(Box.createVerticalStrut(20));
delete_task_panel.add(new JLabel("Select a task or tasks of project to delete "));
delete_task_panel.add(Box.createVerticalStrut(5));
delete_task_panel.add(delete_task_list_panel);

delete_task_list_panel.setLayout(new FlowLayout());
delete_task_list_panel.add(delete_task_jsp);
delete_task_panel.add(delete_task_list_panel);



//////****************		ADDING NEW_APPOINTMENT_PANEL		********************////////
new_apptt_panel.setLayout(new BoxLayout(new_apptt_panel,BoxLayout.Y_AXIS));
JPanel new_apptt_title_panel = new JPanel();
JPanel new_apptt_descrip_panel = new JPanel();
JPanel new_apptt_start_panel = new JPanel();
JPanel new_apptt_end_panel = new JPanel();
JPanel new_apptt_duration_panel = new JPanel();
JPanel new_apptt_place_panel = new JPanel();
JPanel new_apptt_color_panel = new JPanel();
JPanel new_apptt_notes_panel = new JPanel();
JPanel new_apptt_btn_panel = new JPanel();

new_apptt_panel.add(Box.createVerticalStrut(15)); 

new_apptt_panel.add(new_apptt_title_panel);
new_apptt_panel.add(Box.createVerticalStrut(15));

new_apptt_panel.add(new_apptt_descrip_panel);
new_apptt_panel.add(Box.createVerticalStrut(15));

new_apptt_panel.add(new_apptt_start_panel);
new_apptt_panel.add(Box.createVerticalStrut(15));

new_apptt_panel.add(new_apptt_end_panel);
new_apptt_panel.add(Box.createVerticalStrut(15));

new_apptt_panel.add(new_apptt_duration_panel);
new_apptt_panel.add(Box.createVerticalStrut(15));

new_apptt_panel.add(new_apptt_place_panel);
new_apptt_panel.add(Box.createVerticalStrut(15));

new_apptt_panel.add(new_apptt_color_panel);
new_apptt_panel.add(Box.createVerticalStrut(15));

new_apptt_panel.add(new_apptt_notes_panel);
new_apptt_panel.add(Box.createVerticalStrut(15));

new_apptt_panel.add(new_apptt_btn_panel);
new_apptt_panel.add(Box.createVerticalStrut(15));


	new_apptt_title_panel.setLayout(new BoxLayout(new_apptt_title_panel,BoxLayout.X_AXIS));
	new_apptt_title_panel.add( new JLabel("Title") );
	new_apptt_title_panel.add(Box.createHorizontalStrut(50));
	new_apptt_title_panel.add(apptt_title_tf);
	
JScrollPane new_apptt_descrip_sp = new JScrollPane(new_apptt_descrip_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	new_apptt_descrip_panel.setLayout(new BoxLayout(new_apptt_descrip_panel,BoxLayout.X_AXIS));
	new_apptt_descrip_panel.add( new JLabel("Description ") );
	new_apptt_descrip_panel.add(Box.createHorizontalStrut(10));
	new_apptt_descrip_panel.add(new_apptt_descrip_sp);

JTextField new_apptt_start_tf = new JTextField();
	new_apptt_start_panel.setLayout(new BoxLayout(new_apptt_start_panel,BoxLayout.X_AXIS));
	new_apptt_start_panel.add( new JLabel("Start Date and Time ") );
	new_apptt_start_panel.add(Box.createHorizontalStrut(18));
	new_apptt_start_panel.add(new_apptt_start_tf);

JTextField new_apptt_end_tf = new JTextField();
	new_apptt_end_panel.setLayout(new BoxLayout(new_apptt_end_panel,BoxLayout.X_AXIS));
	new_apptt_end_panel.add( new JLabel("End Date and Time ") );
	new_apptt_end_panel.add(Box.createHorizontalStrut(22));
	new_apptt_end_panel.add(new_apptt_end_tf);

JTextField new_apptt_duration_tf = new JTextField();	
	new_apptt_duration_panel.setLayout(new BoxLayout(new_apptt_duration_panel,BoxLayout.X_AXIS));
	new_apptt_duration_panel.add( new JLabel("Duration ") );
	new_apptt_duration_panel.add(Box.createHorizontalStrut(15));
	new_apptt_duration_panel.add(new_apptt_duration_tf);

JTextField new_apptt_place_tf = new JTextField();	
	new_apptt_place_panel.setLayout(new BoxLayout(new_apptt_place_panel,BoxLayout.X_AXIS));
	new_apptt_place_panel.add( new JLabel("Place") );
	new_apptt_place_panel.add(Box.createHorizontalStrut(30));
	new_apptt_place_panel.add(new_apptt_place_tf);

//JButton more_color_apptt_btn = new JButton("...");
	new_apptt_color_panel.setLayout(new BoxLayout(new_apptt_color_panel,BoxLayout.X_AXIS));
	new_apptt_color_panel.add( new JLabel("Choose Color ") );
	new_apptt_color_panel.add(Box.createHorizontalStrut(20));
	new_apptt_color_panel.add(more_color_apptt_btn);
	more_color_apptt_btn.addActionListener(this);

JTextArea new_apptt_notes_ta = new JTextArea(4,6);	
JScrollPane new_apptt_notes_sp = new JScrollPane(new_apptt_notes_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	new_apptt_notes_panel.setLayout(new BoxLayout(new_apptt_notes_panel,BoxLayout.X_AXIS));
	new_apptt_notes_panel.add( new JLabel("Notes ") );
	new_apptt_notes_panel.add(Box.createHorizontalStrut(20));
	new_apptt_notes_panel.add(new_apptt_notes_sp);
	
JButton new_apptt_save_btn = new JButton ("Save");
JButton new_apptt_cancel_btn = new JButton ("Cancel");
	new_apptt_btn_panel.setLayout(new  BoxLayout(new_apptt_btn_panel, BoxLayout.X_AXIS));
	new_apptt_btn_panel.add(new_apptt_save_btn);
	new_apptt_btn_panel.add(Box.createHorizontalStrut(20));
	new_apptt_btn_panel.add(new_apptt_cancel_btn);
		
	
////**********************	ADDINDG EDIT_APPOINTMENT_PANEL   *************************//////
edit_apptt_panel.setLayout(new BoxLayout(edit_apptt_panel, BoxLayout.Y_AXIS));

JPanel edit_apptt_title_combo_panel = new JPanel();
JComboBox edit_apptt_title_combo = new JComboBox();
JPanel edit_apptt_title_panel = new JPanel();
JTextField edit_apptt_title_tf = new JTextField();
JPanel edit_apptt_descrip_panel = new JPanel();
JTextArea edit_apptt_descrip_ta = new JTextArea(2,20);
JPanel edit_apptt_start_panel = new JPanel();
JPanel edit_apptt_end_panel = new JPanel();
JPanel edit_apptt_place_panel = new JPanel();
JTextField edit_apptt_place_tf = new JTextField();

edit_apptt_panel.add(Box.createVerticalStrut(20));
edit_apptt_panel.add(edit_apptt_title_combo_panel);
edit_apptt_panel.add(Box.createVerticalStrut(50));
edit_apptt_panel.add(edit_apptt_title_panel);
edit_apptt_panel.add(Box.createVerticalStrut(50));
edit_apptt_panel.add(edit_apptt_descrip_panel);
edit_apptt_panel.add(Box.createVerticalStrut(50));
edit_apptt_panel.add(edit_apptt_start_panel);
edit_apptt_panel.add(Box.createVerticalStrut(50));
edit_apptt_panel.add(edit_apptt_end_panel);
edit_apptt_panel.add(Box.createVerticalStrut(50));
edit_apptt_panel.add(edit_apptt_place_panel);
edit_apptt_panel.add(Box.createVerticalStrut(50));

edit_apptt_title_combo.addItem("Task XXX");
edit_apptt_title_combo.addItem("Task YYY");
edit_apptt_title_combo.addItem("Task ZZZ");
edit_apptt_title_combo_panel.setLayout(new BoxLayout(edit_apptt_title_combo_panel, BoxLayout.X_AXIS));
edit_apptt_title_combo_panel.add(new JLabel("Task Title"));
edit_apptt_title_combo_panel.add(Box.createHorizontalStrut(20));
edit_apptt_title_combo_panel.add(edit_apptt_title_combo);

edit_apptt_title_panel.setLayout(new BoxLayout(edit_apptt_title_panel, BoxLayout.X_AXIS));
edit_apptt_title_panel.add(new JLabel("Title"));
edit_apptt_title_panel.add(Box.createHorizontalStrut(20));
edit_apptt_title_panel.add(edit_apptt_title_tf);

JScrollPane edit_apptt_descrip_sp = new JScrollPane(edit_apptt_descrip_ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
										   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
edit_apptt_descrip_panel.setLayout(new BoxLayout(edit_apptt_descrip_panel, BoxLayout.X_AXIS));
edit_apptt_descrip_panel.add(new JLabel("Description"));
edit_apptt_descrip_panel.add(Box.createHorizontalStrut(20));
edit_apptt_descrip_panel.add(edit_apptt_descrip_sp);

edit_apptt_start_panel.setLayout(new BoxLayout(edit_apptt_start_panel, BoxLayout.X_AXIS));
edit_apptt_start_panel.add(new JLabel("Start Time"));
//edit_apptt_start_panel.add(Box.createHorizontalStrut(20));
//edit_apptt_start_panel.add(edit_apptt_start_tf);

edit_apptt_end_panel.setLayout(new BoxLayout(edit_apptt_end_panel, BoxLayout.X_AXIS));
edit_apptt_end_panel.add(new JLabel("End Time"));

edit_apptt_place_panel.setLayout(new BoxLayout(edit_apptt_place_panel, BoxLayout.X_AXIS));
edit_apptt_place_panel.add(new JLabel("Place"));
edit_apptt_place_panel.add(Box.createHorizontalStrut(20));
edit_apptt_place_panel.add(edit_apptt_place_tf);





////********************	ADDINDG DELETE APPOINTMENT PANEL	*****************************//////
JPanel delete_apptt_list_panel = new JPanel();
String[] appointments = { "APPOINTMENT 1", "APPOINTMENT 2", "APPOINTMENT 3", "APPOINTMENT 4", "APPOINTMENT 5", "APPOINTMENT 6", "APPOINTMENT 7", "APPOINTMENT 8", "APPOINTMENT 9", "APPOINTMENT 10"};
JList delete_apptt_list = new JList(appointments);

JScrollPane delete_apptt_jsp = new JScrollPane(delete_apptt_list);  
delete_apptt_list.setVisibleRowCount(8);
delete_apptt_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

delete_apptt_panel.setLayout(new BoxLayout(delete_apptt_panel,BoxLayout.Y_AXIS));
delete_apptt_panel.add(Box.createVerticalStrut(30));
delete_apptt_panel.add(new JLabel("Select a single or multiple appointments to Delete"));
delete_apptt_panel.add(Box.createVerticalStrut(10));
delete_apptt_panel.add(delete_apptt_list_panel);

delete_apptt_list_panel.setLayout(new FlowLayout());
delete_apptt_list_panel.add(delete_apptt_jsp);
delete_apptt_panel.add(delete_apptt_list_panel);


//////****************	ADDING DEPENDENCIES_PANEL	********************////////
	depend_panel.setLayout(new BoxLayout(depend_panel,BoxLayout.Y_AXIS));
   /* String comboBoxItems[] = {str_proj_x, str_proj_y, str_proj_z};*/
    combo_panel = new JPanel();
	/*JComboBox combobox = new JComboBox(comboBoxItems);*/
	combobox.addItem(str_proj_x);
	combobox.addItem(str_proj_y);
	combobox.addItem(str_proj_z);
      
    combobox.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent ie) {
    CardLayout cl = (CardLayout)(cards_panel.getLayout());
    cl.show(cards_panel, (String)ie.getItem());
    }
    	});
    combo_panel.add(combobox);

    //Use the default layout manager, BorderLayout
    depend_panel.add(combo_panel, BorderLayout.NORTH);

    cards_panel = new JPanel();
    cards_panel.setLayout(new CardLayout());

    proj_x_panel = new JPanel();
    proj_x_panel.add(new JLabel("Project XXX"));

    proj_y_panel = new JPanel();
    proj_y_panel.add(new JLabel("Project YYY"));
    
    proj_z_panel = new JPanel();
    proj_z_panel.add(new JLabel("Project ZZZ"));

    cards_panel.add(proj_x_panel, str_proj_x);
    cards_panel.add(proj_y_panel, str_proj_y);
    cards_panel.add(proj_z_panel, str_proj_z);
    depend_panel.add(cards_panel, BorderLayout.CENTER);


//depend_panel.add(Box.createVerticalStrut(15));
//depend_panel.add(proj_depend_combo_panel);	
//depend_panel.add(Box.createVerticalStrut(15));
//
//proj_depend_combo.addItem("Project X"); 
//proj_depend_combo.addItem("Project Y");
//proj_depend_combo.addItem("Project Z");	
//proj_depend_combo_panel.setLayout(new BoxLayout(proj_depend_combo_panel,BoxLayout.X_AXIS));
//proj_depend_combo_panel.add(new JLabel("Project Title"));
//proj_depend_combo_panel.add(Box.createHorizontalStrut(10));
//proj_depend_combo_panel.add(proj_depend_combo);


///////////////////ADDING NEW-EDIT-DELETE-TABBEDPANE IN THE TASK TAB
	
	new_edit_delete_TP_task.addTab("New",null,new_task_panel,"Initiate a New Task of the Project");				
	new_edit_delete_TP_task.addTab("Edit",null,edit_task_panel,"Edit Task of the Project");
	new_edit_delete_TP_task.addTab("Delete",null,delete_task_panel,"Delete Task of a Project");

///////////////////ADDING NEW-EDIT-DELETE-TABBEDPANE IN THE APPTT TAB

	new_edit_delete_TP_apptt.addTab("New",null,new_apptt_panel,"Initiate a New Appointment");				
	new_edit_delete_TP_apptt.addTab("Edit",null,edit_apptt_panel,"Edit existing Appointments");
	new_edit_delete_TP_apptt.addTab("Delete",null,delete_apptt_panel,"Delete an Appointment");


///////////////////////SETTING LAYOUT OF THE CONTENTPANE//////////////////
/*	cp.setLayout(new BorderLayout());
		
	cp.add(jsp,BorderLayout.CENTER);*/
	
	cp.setLayout(new BorderLayout());
	cp.add(rad_panel,BorderLayout.NORTH);
	cp.add(center_panel,BorderLayout.CENTER);
	center_panel.setLayout(new BorderLayout());
	center_panel.add(jsp,BorderLayout.CENTER);
//JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,emp_proj_TP,proj_task_apptt_depend_TP);	
		
///////////////////////////////////ending layout of content pane/////////////////////////
}

//////////////  Button Listener class for PROGRESS BAR  ///////////////////////////////////
   class ButtonListener implements ActionListener 
   {
        public void actionPerformed(ActionEvent evt)
		{
            startButton.setEnabled(false);
            task.go();
            timer.start();
        }
    }	
	
	
	
////////////////////////////////////////MAIN METHOD////////////////////////////////////////

	public static void main(String a[])//throws Exception
	{
		ProgressBarDemo progress = new ProgressBarDemo();	
		final JFrame mf = new Project();
	//	progress.setVisible(true);
		mf.setBounds(0,0,800,600);
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.setVisible(true);
		mf.setResizable(true);
	}
	

	public void actionPerformed(ActionEvent ae)
	{
		  if (ae.getSource() == proj_save_btn)
 	      {
    	   String new_proj_title_str = proj_title_tf.getText();
    	   edit_proj_title_combo.addItem(new_proj_title_str);
		   proj_title_combo.addItem(new_proj_title_str);
		   combobox.addItem(new_proj_title_str);
		   proj_delete_combo.addItem(new_proj_title_str);
  	      }	
		  
	//	  if (ae.getSource() == del_proj_save_btn)
	//	  {
		  
  
		if (ae.getSource()==more_color_task_btn || ae.getSource()==more_color_task_btn1 || ae.getSource()==more_color_apptt_btn )
		{
		Color color = JColorChooser.showDialog(Project.this,"Select a new color...", Color.white);
///		jpanel.setBackground(color);
		}
try
  {
			JRadioButton src=(JRadioButton)ae.getSource();

	if((JRadioButton)ae.getSource()==rad_btn1)
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

	else if((JRadioButton)ae.getSource()==rad_btn2)
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");				

	else if((JRadioButton)ae.getSource()==rad_btn3)
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");		
   }	
		catch(Exception ex)
		{}
	
	SwingUtilities.updateComponentTreeUI(getContentPane());
  }
  

  		
		
		
		
	
}		
/**************************************** THE END ******************************************/
		
	
	
	