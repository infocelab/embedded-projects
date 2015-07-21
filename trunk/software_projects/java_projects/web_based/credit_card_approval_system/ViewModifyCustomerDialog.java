import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.border.*;

public class ViewModifyCustomerDialog extends JDialog {
	
	static Customer toProcess;
	
	JFrame parent;
	
	EasierGridLayout layout = new EasierGridLayout();
	EasierGridLayout layout2 = new EasierGridLayout();
	EasierGridLayout mLayout = new EasierGridLayout();
	
  
  ViewModifyCustomerDialog(JFrame parent)  {
    super(parent, true);
    this.setResizable(false);
	 	this.parent = parent;
	 	addElements();
	 	addListeners();
	 	setLayout();
	 	setTable();
  	this.toProcess = CCApproval.cust;
  	
  	initialize();
  	this.setTitle("CUSTOMER PROFILE: "+toProcess.toString());

    Toolkit thKit = this.getToolkit();
    Dimension wndSze = thKit.getScreenSize();
    this.pack();
    int wd = this.getWidth();
    int ht = this.getHeight();
    int x = (int)((wndSze.getWidth()/2)-(wd/2));
    int y = (int)((wndSze.getHeight()/2)-(ht/2));
    this.setBounds(x,y,wd,ht);
	 	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	 	updateTable();
	 	show();
  }
  
  JButton btok = new JButton("Close & Save");
  JButton btcan = new JButton("Cancel");
  JButton btcrd = new JButton("Add Credit Card");
  JButton btShow = new JButton("Customer's Transactions");
  
  
	DefaultTableModel tbtransmodel = new DefaultTableModel();
	TableSorter transsort = new TableSorter(tbtransmodel);
  JTable tbtrans = new JTable(transsort);
  
  
  JScrollPane sptrans = new JScrollPane(tbtrans);
  JLabel lbinf = new JLabel("Customer Information");
  JLabel lbln = new JLabel("Customer Last Name:");
  JLabel lbfn = new JLabel("Customer First Name:");
  JLabel lbmn = new JLabel("Customer Middle Name;");
  
  JLabel lbbday = new JLabel("Birthdate: ");
  JTextField tfln = new JTextField(20);
  JTextField tffn = new JTextField(20);
  JTextField tfmn = new JTextField(20);
  SpinnerDateModel bdaymodel = new SpinnerDateModel();
  JSpinner spbday = new JSpinner(bdaymodel);
	final Object[] type = {"Select One","DINER'S","JCB","MASTER","VISA"};
	JComboBox dltype = new JComboBox(type);
	
  JLabel lbmfn = new JLabel("Mother's First Name:");
  JLabel lbmln = new JLabel("Mother's Maiden Family Name:");
  JLabel lbmmn = new JLabel("Mother's Maiden Middle Name:");
  
  JTextField tfmfn = new JTextField(20);
  JTextField tfmln = new JTextField(20);
  JTextField tfmmn = new JTextField(20);
  
  JLabel lbad = new JLabel("Billing Address:");
  JTextArea taad = new JTextArea(3,12);
  JScrollPane spad = new JScrollPane(taad);
  JLabel lbtrans = new JLabel("Credit Cards:");
  
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel panel3 = new JPanel();
  
  TitledBorder dPanel1 = new TitledBorder("Customer Information:");
  private void addElements(){
  	Container cont = this.getContentPane();
  	cont.setLayout(mLayout);
  	panel1.setLayout(layout);
  	cont.add(btok);	cont.add(btcan);
  	panel1.add(lbln);	panel1.add(tfln);
  	panel1.add(lbfn);	panel1.add(tffn);
  	panel1.add(lbmn);	panel1.add(tfmn);
  	panel1.add(lbbday);	panel1.add(spbday);
  	panel1.add(dltype);	panel1.add(btcrd);
  	panel1.add(lbmfn);	panel1.add(tfmfn);
  	panel1.add(lbmln);	panel1.add(tfmln);
  	panel1.add(lbmmn);	panel1.add(tfmmn);  	
  	panel1.add(spad);
  	cont.add(panel1);
  	
		spad.setBorder(new TitledBorder("Billing Address"));
  	
  	panel2.setLayout(layout2);
  	panel2.add(sptrans);
  	cont.add(panel2);  
  	panel3.setLayout(new GridLayout(1,3));
  	panel3.add(btok);  panel3.add(btcan); panel3.add(btShow); 
  	cont.add(panel3);
  	panel1.setBorder(new TitledBorder("Customer Information"));
  	panel2.setBorder(new TitledBorder("Credit Cards"));
  	sptrans.setPreferredSize(new Dimension(250,100));
  }
  private void setLayout(){
  	layout.East(lbfn,1,1,1,1);	layout.West(tffn,1,2,1,1);
  	layout.East(lbmn,2,1,1,1);	layout.West(tfmn,2,2,1,1);
  	layout.East(lbln,3,1,1,1);	layout.West(tfln,3,2,1,1);
  	
  	layout.East(lbmfn,4,1,1,1);	layout.West(tfmfn,4,2,1,1);
  	layout.East(lbmmn,5,1,1,1);	layout.West(tfmmn,5,2,1,1);
  	layout.East(lbmln,6,1,1,1);	layout.West(tfmln,6,2,1,1);
  	
  	layout.East(lbbday,7,1,1,1);	layout.West(spbday,7,2,1,1);
  	layout.East(dltype,8,1,1,1);	layout.West(btcrd,8,2,1,1);
  	layout.West(lbad,9,1,1,1);	layout.CenterBoth(spad,10,1,2,1);
  	layout2.CenterBoth(sptrans,1,1,2,1); 
  	
  	mLayout.Center(panel1,1,1,1,1);
  	mLayout.CenterBoth(panel2,3,1,2,1);
  	mLayout.Center(panel3,4,1,2,1);
  	
  }
  private void setTable(){
		tbtransmodel.addColumn("Credit Card Number");
		tbtransmodel.addColumn("Type");
		tbtransmodel.addColumn("Status");
		transsort.addMouseListenerToHeaderInTable(tbtrans);
		tbtrans.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
  }
  private void addListeners(){
  	btShow.addActionListener(new ButtonListener());
  	btok.addActionListener(new ButtonListener());
  	btcan.addActionListener(new ButtonListener());
  	btcrd.addActionListener(new ButtonListener());
  }
  private void updateTable(){
		ListIterator iter = toProcess.getCards();
		int a =0;
		while(iter.hasNext()){
  		CreditCard tmp = (CreditCard)iter.next();
  		
  		CreditCard tmp2 = (CreditCard)CCApproval.cards.get(tmp.getNumber());
  		
  		Object[] row = {tmp,tmp.getType(),tmp.getStatus()};
			try{
				for(int b=0;b<row.length;b++)
					tbtransmodel.setValueAt(row[b],a,b);
			}
			catch(Exception e){
  			tbtransmodel.addRow(row);
			}
			a++;
		}
  }
  private void initialize(){
  	tfln.setText(toProcess.getLastName());
  	tffn.setText(toProcess.getFirstName());
  	tfmn.setText(toProcess.getMiddleName());
  	bdaymodel.setValue(toProcess.getBirthday());
  	tfmfn.setText(toProcess.getMother().getFirstName());
  	tfmln.setText(toProcess.getMother().getLastName());
  	tfmmn.setText(toProcess.getMother().getMiddleName());
  	taad.setText(toProcess.getAddress());
  }
  public static void refreshCards(){
  	Iterator iter = CCApproval.cards.dataIterator();
  	while(iter.hasNext()){
  		CreditCard card = (CreditCard)iter.next();
  		if(card.getHolder().getId() == toProcess.getId()){
  			CreditCard tmp = (CreditCard)CCApproval.cards.remove(card.getNumber());
  			tmp.setHolder(toProcess);
  			CCApproval.cards.insert(tmp.getNumber(),tmp);
  		}
  	}
	  CCApproval.reloadData();
  }
  
  private void update(){
  	toProcess.setFirstName(tffn.getText().trim().toUpperCase());
  	toProcess.setLastName(tfln.getText().trim().toUpperCase());
  	toProcess.setMiddleName(tfmn.getText().trim().toUpperCase());
  	toProcess.setMother(new Person(tfmfn.getText().trim().toUpperCase(),
  	                               tfmln.getText().trim().toUpperCase(),
  	                               tfmmn.getText().trim().toUpperCase()));
  	toProcess.setBirthday((Date)spbday.getValue());
  	toProcess.setAddress(taad.getText());
  	refreshCards();
  }
  private class ButtonListener implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  		Object src = e.getSource();
  		if(src == btok){
  			update();
	 			CCApproval.reloadData();
  			dispose();
  		}
  		else if(src == btcan){
  			dispose();
  		}
  		else if(src == btcrd){
  			if(dltype.getSelectedIndex()!=0){
  				CreditCard newCrd = new CreditCard(toProcess,dltype.getSelectedIndex());
  				toProcess.addCreditCard(newCrd);
  				CCApproval.cards.insert(newCrd.getNumber(),newCrd);
	  			CCApproval.customers.remove(""+toProcess.getId());
	  			CCApproval.customers.insert(""+toProcess.getId(),toProcess);
	  			CCApproval.reloadData();
	  			updateTable();
	  		}
  		}
  		else if(src == btShow){		
				TransactionDialog aDlg = new TransactionDialog(new JFrame(), toProcess);
			}
  	}
  }
  
}