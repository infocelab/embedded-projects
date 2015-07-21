/**
 *Credit Card Apporval System View Elements
 **/

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.util.*;

public class ViewElements extends JInternalFrame{
	
	public static JFrame window = new JFrame();

	public ViewElements(String title){
		super(title);
		/*try{				
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {}//*/		
		setVisible(true);
		setupElements();
		setLayout();
		enableDisable();

	}	
	
	JTabbedPane tabFrame = new JTabbedPane();		
	//tab1 elements
	JPanel tab1 = new JPanel();
	JLabel lbApp = new JLabel("Credit Card Application and Customer Enlisting");

	JLabel lbcctype = new JLabel("Credit Card Type:");
	final Object[] type = {"Select One","DINER'S","JCB","MASTER","VISA"};
	JComboBox dltype = new JComboBox(type);
	JTextArea tacust = new JTextArea(5,20);
	JScrollPane spcustinf = new JScrollPane(tacust);
	JButton btok1 = new JButton("SAVE");
	JButton btrst1 = new JButton("Reset");
	
	JTextField tffn = new JTextField(20);
	JTextField tfmn = new JTextField(20);
	JTextField tfln = new JTextField(20);
	JTextField tfmfn = new JTextField(20);
	JTextField tfmmn = new JTextField(20);
	JTextField tfmln = new JTextField(20);
	
	JLabel lbfn = new JLabel("First Name: ");
	JLabel lbmn = new JLabel("Middle Name: ");
	JLabel lbln = new JLabel("Last Name: ");
	JLabel lbmfn = new JLabel("Mother's First Name: ");
	JLabel lbmmn = new JLabel("Mother's Maiden Middle Name: ");
	JLabel lbmln = new JLabel("Mother's Maiden Last Name: ");
	JLabel lbbday = new JLabel("Birthdate (mm/dd/yyyy): ");
	JLabel lbad = new JLabel("Billing Address: ");
	
	JSpinner spbday = new JSpinner(new SpinnerDateModel());
	JTextArea taad = new JTextArea(4,12);
	JScrollPane spad = new JScrollPane(taad);
		
	//tab2 elements
	JPanel tab2 = new JPanel();
	
	JLabel lbcust = new JLabel("Customer Name: ");
	JLabel lbcost = new JLabel("Total Purchase Cost: ");
	JLabel lbpay = new JLabel("Pay in: ");
	JLabel lbstore = new JLabel("Store Name: ");
	JRadioButton rbcash = new JRadioButton("Cash");
	JRadioButton rbcard = new JRadioButton("Credit Card");
	ButtonGroup rbgrp = new ButtonGroup();
	JTextField tfccnum2 = new JTextField(15);
	JTextField tfcust = new JTextField(20);
	JTextField tfcost = new JTextField(10);
	JTextField tfstore = new JTextField(20);
	JButton btselcard = new JButton("Select Credit Card");
	JButton btselcust = new JButton("Select a Customer");
	JButton btper = new JButton("Perform Transaction");
	JTextField tfcard = new JTextField(15);
	
	//tab3 elements
	JPanel tab3 = new JPanel();
	JTabbedPane tab3tabs = new JTabbedPane();
	JPanel tab31 = new JPanel();
	JPanel tab32 = new JPanel();
	
	public static DefaultTableModel tbcustmodel = new DefaultTableModel();
	TableSorter custsort = new TableSorter(tbcustmodel);
	JTable tbcust = new JTable(custsort);
	
	
	JScrollPane spcust = new JScrollPane(tbcust);
	JLabel[] lbsearch = {new JLabel("Search:"),new JLabel("KeyWord:")};
	JTextField[] tfsearch = {new JTextField(20),new JTextField(20)};
	JButton bttrans2 = new JButton("Make Transaction with SelectedCustomer");
	JButton btedit = new JButton("Edit/View Selected");
	
	public static DefaultTableModel tbcardmodel = new DefaultTableModel();
	TableSorter cardsort = new TableSorter(tbcardmodel);
	JTable tbcard = new JTable(cardsort);
	
	JScrollPane spcard = new JScrollPane(tbcard);
	DefaultTableModel tbtransmodel = new DefaultTableModel();
	
	JTable tbtrans = new JTable(cardsort);

	JScrollPane sptrans = new JScrollPane(tbtrans);
	JButton btview = new JButton("View Selected");
	
	
 	DefaultTableModel srchTableModel = new DefaultTableModel();
  TableSorter srchsort = new TableSorter(srchTableModel);
  	
 	DefaultTableModel srchCardModel = new DefaultTableModel();
  TableSorter crdsort = new TableSorter(srchCardModel);
	
	String usertype = "";	
	
	static JLabel lbBlank = new JLabel("System is Idle", JLabel.CENTER);
	public static JLabel lbClock = new JLabel("Clock Here");
	final Object[] by = {"Card Holder","Card Number","Card Type"};
	JLabel lbsrchby = new JLabel("Search by: ");
	JComboBox dlsearch = new JComboBox(by);
	
	JPanel panel11 = new JPanel();
	JPanel panel12 = new JPanel();
	
	EasierGridLayout mLayout = new EasierGridLayout();
	public EasierGridLayout layout = new EasierGridLayout();
	public EasierGridLayout layout2 = new EasierGridLayout();
	
	//menu elements
	JMenuBar menu = new JMenuBar();
	JMenu mufile = new JMenu("File");
	JMenuItem miabout = new JMenuItem("About");
	JMenuItem miexit = new JMenuItem("EXIT");

	private void setupElements(){

		tab1.setLayout(mLayout);
		panel11.setLayout(layout);
		panel12.setLayout(layout2);
		panel11.setBorder(new TitledBorder("Credit Card Application and Customer Enlisting"));
		panel12.setBorder(new TitledBorder("Billing Address"));
		
  	panel11.add(lbfn);	panel11.add(tffn);	
		panel11.add(lbmn);	panel11.add(tfmn);	  	
   	panel11.add(lbln);	panel11.add(tfln);	
   	
  	panel11.add(lbmfn);	panel11.add(tfmfn);	
		panel11.add(lbmmn);	panel11.add(tfmmn);	  	
   	panel11.add(lbmln);	panel11.add(tfmln);	  		

  	panel11.add(lbbday); panel11.add(spbday);
		panel11.add(lbcctype); panel11.add(dltype);	 
  	
  	panel12.add(spad); 	panel12.add(lbad);
  			
		tab1.add(panel11);
		tab1.add(panel12);
		tab1.add(btok1);
		tab1.add(btrst1);
		
  	taad.setLineWrap(true);
		
		tabFrame.addTab("Customer Application",tab1);
		tfcust.setEditable(false);
		tab2.add(lbcust);	tab2.add(tfcust);	tab2.add(btselcust);
		tab2.add(lbcost);	tab2.add(tfcost);	tab2.add(lbpay);
		tab2.add(lbstore);	tab2.add(tfstore);	
		tab2.add(btper);	tab2.add(rbcash);	tab2.add(rbcard);
		
		rbgrp.add(rbcash);	rbgrp.add(rbcard);
		
		tab2.add(tfccnum2);	tab2.add(btselcard);
		rbcash.setSelected(true);
		enableDisable();
		tabFrame.addTab("Transactions",tab2);
		
		
		
		tabFrame.addTab("Search/View/Modify",tab3);
		tab3tabs.addTab("Search/View/Modify Customers",tab31);
		tab3tabs.addTab("Search/View/Modify Credit Cards",tab32);
		tab3.add(tab3tabs);
		setupTables();

		tab31.add(spcust);
		tab31.add(lbsearch[0]);	tab31.add(tfsearch[0]);
		tab31.add(bttrans2);	tab31.add(btedit);
		
		tab32.add(spcard);
		
		tab32.add(lbsrchby);
		tab32.add(tfsearch[1]);
		tab32.add(dlsearch);
		tab32.add(btview);
		
		this.getContentPane().add(tabFrame);		
		
		//added clock
		Font forClock = new Font("Arial",3,20);
		
		lbBlank.setBorder(BorderFactory.createEtchedBorder(BevelBorder.RAISED));
		lbClock.setAlignmentX(CENTER_ALIGNMENT);
		lbClock.setFont(forClock);
		lbClock.setForeground(Color.RED);
		lbClock.setBorder(BorderFactory.createEtchedBorder(BevelBorder.RAISED));
		tab2.add(lbClock);//
		
		this.getContentPane().add(lbBlank, BorderLayout.SOUTH);
		mufile.add(miabout);
		mufile.addSeparator();
		mufile.add(miexit);
		menu.add(mufile);
		setJMenuBar(menu);
	}
	
	private void setLayout(){
		tab3.setLayout(layout);
		tab31.setLayout(layout);
		tab32.setLayout(layout);
		
  	layout.East(lbfn,2,1,1,1);	layout.West(tffn,2,2,1,1);
  	layout.East(lbmn,3,1,1,1);	layout.West(tfmn,3,2,1,1);
  	layout.East(lbln,4,1,1,1);	layout.West(tfln,4,2,1,1);  	
  	layout.East(lbmfn,5,1,1,1);	layout.West(tfmfn,5,2,1,1);
  	layout.East(lbmmn,6,1,1,1);	layout.West(tfmmn,6,2,1,1);
  	layout.East(lbmln,7,1,1,1);	layout.West(tfmln,7,2,1,1);  	
  	layout.East(lbbday,8,1,1,1);	layout.West(spbday,8,2,1,1);  	
		layout.East(lbcctype,9,1,1,1);	layout.West(dltype,9,2,1,1);
		
  	layout2.West(lbad,1,1,1,1);	layout2.CenterBoth(spad,1,1,4,1);
		
		mLayout.CenterBoth(panel11,1,1,3,1);
		mLayout.CenterBoth(panel12,3,1,3,1);
		mLayout.East(btok1,4,2,1,1);
		mLayout.West(btrst1,4,3,1,1);
		
		tab2.setLayout(layout);
		
		layout.Center(lbClock,1,1,5,1);
		
		layout.East(lbcust,2,1,1,1);	layout.West(tfcust,2,2,3,1);	layout.West(btselcust,2,5,2,1);
		layout.East(lbcost,3,1,1,1);	layout.West(tfcost,3,2,2,1);	
		layout.East(lbpay,4,1,1,1);	layout.West(rbcash,4,2,1,1);	
		layout.West(rbcard,5,2,1,1);	layout.East(btselcard,5,4,1,1);	layout.West(tfccnum2,5,5,1,1);
		
		layout.East(lbstore,6,1,1,1);		layout.West(tfstore,6,2,3,1);
		layout.Center(btper,8,5,1,1);
		
		layout.defineOwnConstraints(spcust,1,1,3,1,300,300,1,10,1,1,1,1);
		layout.West(lbsearch[0],2,1,1,1);
		layout.CenterHorizontal(tfsearch[0],3,1,3,1);
				
		layout.Center(bttrans2,4,1,1,1);
		layout.Center(btedit,  4,2,2,1);
		
		layout.CenterBoth(tab3tabs,1,1,1,1);
		
		layout.East(lbsrchby,2,1,1,1);
		layout.West(dlsearch,2,2,1,1);
		layout.CenterHorizontal(tfsearch[1],3,1,4,1);
		layout.CenterBoth(btview,3,7,1,1);
		layout.defineOwnConstraints(spcard,1,1,7,1,300,300,1,10,1,1,1,1);
	}
	
	private void setupTables(){
		
		tbcustmodel.addColumn("Customer Name");
		tbcustmodel.addColumn("Credit Cards Owned");
		
		tbcardmodel.addColumn("Credit Card Number");
		tbcardmodel.addColumn("Holder");
		tbcardmodel.addColumn("Type");
		tbcardmodel.addColumn("Status");
		
		tbtransmodel.addColumn("Date of transaction");
		tbtransmodel.addColumn("Merchant");
		
		srchTableModel.addColumn("Customer");
		srchTableModel.addColumn("Credit Cards Owned");
		
		srchCardModel.addColumn("Credit Card Number");
		srchCardModel.addColumn("Holder");
		srchCardModel.addColumn("Type");
		srchCardModel.addColumn("Status");
		
    tbcust.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tbcard.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public void enableDisable(){
		btselcard.setEnabled(false);
		tfccnum2.setEditable(false);
		rbcash.setEnabled(true);
		rbcard.setEnabled(true);
		try{
		if(CCApproval.cust.cardCount()==0)
			rbcard.setEnabled(false);
		else
			rbcard.setEnabled(true);
			}
			catch(Exception e){ rbcard.setEnabled(false); rbcard.setEnabled(true);}
		if(rbcard.isSelected()){
			btselcard.setEnabled(true);
		}
	}
}