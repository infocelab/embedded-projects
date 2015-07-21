import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.event.*;

public class ViewCreditCardDialog extends JDialog {
	
	Customer toProcess;
	
	JFrame parent;
	
	EasierGridLayout layout = new EasierGridLayout();
	EasierGridLayout layout2 = new EasierGridLayout();
	EasierGridLayout layout3 = new EasierGridLayout();
	EasierGridLayout mLayout = new EasierGridLayout();
  
  CreditCard toUse;
  
  ViewCreditCardDialog(JFrame parent)  {
    super(parent, true);
    this.setResizable(false);
	 	this.parent = parent;
  	this.setTitle(CCApproval.card.toString());
  	this.toUse = CCApproval.card;
	 	addElements();
	 	addListeners();
	 	setLayout();
	 	setTable();
	 	enableDisable();
    this.pack();
    Toolkit thKit = this.getToolkit();
    Dimension wndSze = thKit.getScreenSize();
    int wd = 400;
    int ht = 500;
    int x = (int)((wndSze.getWidth()/2)-(wd/2));
    int y = (int)((wndSze.getHeight()/2)-(ht/2));
    this.setBounds(x,y,wd,ht);
	 	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	 	
  	update();
  	show();
  }
	DefaultTableModel tbtransmodel = new DefaultTableModel();
	TableSorter transsort = new TableSorter(tbtransmodel);
  JTable tbtrans = new JTable(transsort);
  JScrollPane sptrans = new JScrollPane(tbtrans);
  
  JButton btok = new JButton("Save & Close");
  JButton btcan = new JButton("Cancel");
  
  JLabel lbhold = new JLabel("Card Holder:");
  JLabel lbnum = new JLabel("Card Number:");
  JLabel lbtype = new JLabel("Card Type:");
  JLabel lbexp = new JLabel("Expiry Date:");
  JLabel lbcrdit = new JLabel("Credit Limit:");
  JLabel lbcurrent = new JLabel("Current Credit:");
  JLabel lbtrans = new JLabel("Transaction Log:");
  
  JTextField tfhold = new JTextField(20);
  JTextField tfnum = new JTextField(20);
  JTextField tftype = new JTextField(10);
  JTextField tfexp = new JTextField(20);
  JTextField tfcrdit = new JTextField(10);
  JTextField tfcurrent = new JTextField(10);
  
  
  JLabel lbpay = new JLabel("Amount to Pay:");
  JTextField tfamt = new JTextField(7);
  JButton btpay = new JButton("Pay Balance");
  
  JLabel lbnexp = new JLabel("New Expiry:");
  JSpinner spnexp = new JSpinner(new SpinnerDateModel());
  JButton btnexp = new JButton("Change Expiry");
  
  JLabel lblim = new JLabel("New Limit:");
  JTextField tflim = new JTextField(7);
  JButton btlim = new JButton("Change Limit");
  
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel panel3 = new JPanel();
  
  
  private void addElements(){
  	Container cont = this.getContentPane();
  	cont.setLayout(mLayout);  	
  	panel1.add(lbhold);	panel1.add(tfhold);
  	panel1.add(lbnum);	panel1.add(tfnum);
  	panel1.add(lbtype);	panel1.add(tftype);
  	panel1.add(lbexp);	panel1.add(tfexp);
  	panel1.add(lbcrdit);	panel1.add(tfcrdit);
  	panel1.add(lbcurrent);	panel1.add(tfcurrent);
  	
  	//panel2.add(lbtrans);
  	panel2.add(sptrans);
  	sptrans.setPreferredSize(new Dimension(300,100));
  	
		panel3.add(lbpay);	panel3.add(tfamt);	panel3.add(btpay);
  	panel3.add(lbnexp);	panel3.add(spnexp);	panel3.add(btnexp);
  	panel3.add(lblim);	panel3.add(tflim);	panel3.add(btlim);
  	
  	cont.add(btok); 	cont.add(btcan);  	
  	cont.add(panel1);
  	cont.add(panel2);
  	cont.add(panel3);
  	
  	panel1.setBorder(new TitledBorder("Credit Card Data"));
  	panel2.setBorder(new TitledBorder("Transaction Log"));
  	panel3.setBorder(new TitledBorder("Operations"));
  }
  private void setLayout(){
  	panel1.setLayout(layout);
  	panel2.setLayout(layout2);
  	panel3.setLayout(layout3);
  	
  	layout.East(lbhold,1,1,1,1);	layout.West(tfhold,1,2,2,1);
  	layout.East(lbnum,2,1,1,1);	layout.West(tfnum,2,2,2,1);
  	layout.East(lbtype,4,1,1,1);	layout.West(tftype,4,2,1,1);
  	layout.East(lbexp,3,1,1,1);	layout.West(tfexp,3,2,1,1);
  	layout.East(lbcrdit,5,1,1,1);	layout.West(tfcrdit,5,2,1,1);
  	layout.East(lbcurrent,6,1,1,1);	layout.West(tfcurrent,6,2,1,1);
  	
  	layout2.CenterBoth(sptrans,1,1,4,1);  
  		  	
  	layout3.East(lbpay,1,1,1,1);	layout3.CenterHorizontal(tfamt,1,2,1,1);	layout3.Center(btpay,1,3,1,1);
  	layout3.East(lbnexp,2,1,1,1);	layout3.CenterHorizontal(spnexp,2,2,1,1);	layout3.Center(btnexp,2,3,1,1);
  	layout3.East(lblim,3,1,1,1);	layout3.CenterHorizontal(tflim,3,2,1,1);	layout3.Center(btlim,3,3,1,1);
  	
  	mLayout.CenterBoth(panel1,1,1,4,1);
  	mLayout.CenterBoth(panel2,2,1,4,1);	
  	mLayout.CenterBoth(panel3,3,1,4,1);
  	mLayout.Center(btok,4,2,1,1);	mLayout.Center(btcan,4,3,1,1);
  }
  private void addListeners(){
  	btok.addActionListener(new ButtonListener());
  	btcan.addActionListener(new ButtonListener());
  	btpay.addActionListener(new ButtonListener());
  	btnexp.addActionListener(new ButtonListener());
  	btlim.addActionListener(new ButtonListener());
  }
  private void setTable(){
  	tbtransmodel.addColumn("Transaction Number");
  	tbtransmodel.addColumn("Date of Transaction");
  	tbtransmodel.addColumn("Approval Number");
  	
  	ListIterator iter = toUse.getTransactions();
  	while(iter.hasNext()){
  		Transaction next = (Transaction)iter.next();
  		Object[] row = {""+next.getTransNumber(),CCApproval.dateString(next.getTransDate()),
  		                next.getApprovalNumber()};
  		tbtransmodel.addRow(row);
  	}
  	
  }
  private void enableDisable(){
  	tfhold.setEditable(false);
  	tfnum.setEditable(false);
  	tftype.setEditable(false);
  	tfexp.setEditable(false);
  	tfcrdit.setEditable(false);
  	tfcurrent.setEditable(false);
  }
  public void update(){
  	tfhold.setText(toUse.getHolder().toString());
  	tfnum.setText(toUse.getNumber());
  	tftype.setText(toUse.getType());
  	tfexp.setText(CCApproval.dateString(toUse.getExpiry()));
  	tfcrdit.setText(""+toUse.getLimit());
  	spnexp.setValue(toUse.getExpiry());
  	tfcurrent.setText(""+toUse.getCredit());
  }
  private class ButtonListener implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  		Object src = e.getSource();
  		if(src == btpay){
  			try{
  				double payment = Double.parseDouble(tfamt.getText());
  				toUse.payCredit(payment);
  				tfamt.setText("");
  				update();
  			}
  			catch(Exception ex){}
  		}
  		else if(src == btnexp){
  			toUse.renew((Date)spnexp.getValue());
  			update();
  		}
  		else if(src == btlim){
  			try{
  				toUse.setLimit(Double.parseDouble(tflim.getText()));
  				tflim.setText("");
  				update();
  			}
  			catch(Exception ex){}
  		}
  		else if(src == btok){
  			Customer using = toUse.getHolder();
	  		CCApproval.cards.remove(toUse.toString());
	  		CCApproval.cards.insert(toUse.getNumber(),toUse);
  			CCApproval.reloadData();
  			dispose();
  		}
  		else if(src == btcan){
  			dispose();
  		}
  	}
  }
  
}