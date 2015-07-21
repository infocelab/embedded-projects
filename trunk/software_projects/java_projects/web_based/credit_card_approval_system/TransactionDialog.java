import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;

public class TransactionDialog extends JDialog {

	static Customer toProcess;
	
	JFrame parent;
	
	EasierGridLayout layout = new EasierGridLayout();
		
		
		DefaultTableModel tbtransmodel = new DefaultTableModel();
		TableSorter transsort = new TableSorter(tbtransmodel);
  	JTable tbtrans = new JTable(transsort);
  	JScrollPane sptrans = new JScrollPane(tbtrans);
  
  	JButton btclose = new JButton("CLOSE");
  
  	TransactionDialog(JFrame parent, Customer theCust)  {
    super(parent, true);
    this.setResizable(false);
	 	this.parent = parent;
	 	addElements();
	 	addListeners();
	 	setLayout();
	 	setTable();	 	
	this.toProcess = theCust;	 	
    Toolkit thKit = this.getToolkit();    
    Dimension wndSze = thKit.getScreenSize();
    this.pack();
    int wd = this.getWidth();
    int ht = this.getHeight();
    int x = (int)((wndSze.getWidth()/2)-(wd/2));
    int y = (int)((wndSze.getHeight()/2)-(ht/2));
    this.setBounds(x,y,wd,ht);
    setTitle("Client Transaction Log: " + toProcess.toString());
	updateTable();
	show();
  }
  Container cont = this.getContentPane();
  private void addElements(){  	
  	cont.add(sptrans);
  	sptrans.setBorder(new TitledBorder("Customer Transactions"));
  	cont.add(btclose);
  }

  public void show(CreditCard tmp){
  	this.show();
  }
  
  private void setLayout(){
  	cont.setLayout(layout);
  	layout.CenterBoth(sptrans,1,1,1,1);
  	layout.East(btclose,2,1,1,1);
  }
  private void addListeners(){
  	btclose.addActionListener(new ButtonListener());  	
  }
  private void setTable(){
	 	tbtransmodel.addColumn("Transaction Number");
		tbtransmodel.addColumn("Date of Transaction");
		tbtransmodel.addColumn("Approval Number");
		transsort.addMouseListenerToHeaderInTable(tbtrans);
    tbtrans.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  }
  private void updateTable(){  		
		ListIterator iter = toProcess.getTransactions();
		int a =0;
		while(iter.hasNext()){
  		Transaction tmp = (Transaction)iter.next();
  		Object[] row = { "" + tmp.getTransNumber(),	CCApproval.dateString(tmp.getTransDate()),tmp.getApprovalNumber()};
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
  
  private class ButtonListener implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  		dispose();
  	}
  }
}