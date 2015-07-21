import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class CustomerCreditCardsDialog extends JDialog {
	
	Customer toProcess;
	CreditCard toUse;
	JTextField tmp;
	
	JFrame parent;
	
	EasierGridLayout layout = new EasierGridLayout();
  
  JList ltcards = new JList();
  JScrollPane spcards = new JScrollPane(ltcards);
  JLabel lbhold = new JLabel("Credit Card Holder: ");	JTextField tfhold = new JTextField(20);
  JLabel lbtype = new JLabel("Card Type: ");	JTextField tftype = new JTextField(15);
  JLabel lbnum = new JLabel("Card Number: ");	JTextField tfnum = new JTextField(15);
  JLabel lbexp = new JLabel("Expiry Date: ");	JTextField tfexp = new JTextField(20);
  JLabel lblim = new JLabel("Credit Limit: ");	JTextField tflim = new JTextField(10);
  JLabel lbcur = new JLabel("Current Credit: ");	JTextField tfcur = new JTextField(10);
  JButton btok = new JButton("OK");	JButton btcan = new JButton("Cancel");
  
  CustomerCreditCardsDialog(JFrame parent, JTextField text)  {
    super(parent, true);
	 	this.layout = layout;
	 	this.parent = parent;
	 	this.tmp = text;
	 	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
  	this.setTitle("Select Credit Card | Customer: "+CCApproval.cust.toString());
	 	addElements();
	 	addListeners();
	 	setLayout();
	 	setData();
    this.pack();
    
    Toolkit thKit = this.getToolkit();
    Dimension wndSze = thKit.getScreenSize();
    int wd = this.getWidth();
    int ht = this.getHeight();
    int x = (int)((wndSze.getWidth()/2)-(wd/2));
    int y = (int)((wndSze.getHeight()/2)-(ht/2));
    this.setBounds(x,y,wd,ht);
    this.setResizable(false);
    show();
  }
  private void addElements(){
  	Container cont = this.getContentPane();
  	cont.add(spcards);
  	cont.add(lbhold);	cont.add(tfhold);
  	cont.add(lbtype);	cont.add(tftype);
  	cont.add(lbnum);	cont.add(tfnum);
  	cont.add(lbexp);	cont.add(tfexp);
  	cont.add(lblim);	cont.add(tflim);
  	cont.add(lbcur);	cont.add(tfcur);
  	cont.add(btok);	cont.add(btcan);
  	
  	
  	tfhold.setEditable(false);
  	tftype.setEditable(false);
  	tfnum.setEditable(false);
  	tfexp.setEditable(false);
  	tflim.setEditable(false);
  	tfcur.setEditable(false);
  	btok.setEnabled(false);
  			
		ltcards.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  	ltcards.setFixedCellWidth(200);
  }
  private void addListeners(){
  	btok.addActionListener(new ButtonListener());
  	btcan.addActionListener(new ButtonListener());
  	ltcards.addMouseListener(new ListListener());
  }
  private void setLayout(){
  	this.getContentPane().setLayout(layout);
  	layout.CenterBoth(spcards,1,1,1,6);
  	layout.East(lbhold,1,2,1,1);	layout.West(tfhold,1,3,1,1);
  	layout.East(lbtype,2,2,1,1);	layout.West(tftype,2,3,1,1);
  	layout.East(lbnum,3,2,1,1);	layout.West(tfnum,3,3,1,1);
  	layout.East(lbexp,4,2,1,1);	layout.West(tfexp,4,3,1,1);
  	layout.East(lblim,5,2,1,1);	layout.West(tflim,5,3,1,1);
  	layout.East(lbcur,6,2,1,1);	layout.West(tfcur,6,3,1,1);
  	layout.CenterBoth(btok,1,4,1,1);	layout.CenterBoth(btcan,2,4,1,1);
  }
  
  public void setData(){
  	ListIterator iter = CCApproval.cust.getCards();
  	CreditCard[] cards = new CreditCard[CCApproval.cust.cardCount()];
  	
  	for(int a=0;a<cards.length;a++)
  		cards[a] = (CreditCard)iter.next();
  	
  	ltcards.setListData(cards);
  }
  public void clearFields(){
  	tfhold.setText("");
  	tftype.setText("");
  	tfnum.setText("");
  	tfexp.setText("");
  	tflim.setText("");
  	tfcur.setText("");
  	toUse = null;
  }
  public void setInfo(){
  	CreditCard toUse = (CreditCard)ltcards.getSelectedValue();
  	tfhold.setText(toUse.getHolder().toString());
  	tftype.setText(toUse.getType());
  	tfnum.setText(toUse.getNumber());
  	tfexp.setText(CCApproval.dateString(toUse.getExpiry()));
  	tflim.setText(""+toUse.getLimit());
  	tfcur.setText(""+toUse.getCredit());
  	
  }
  private class ListListener extends MouseAdapter{
  	public void mouseClicked(MouseEvent e){
  		if(ltcards.isSelectionEmpty()){
  			toUse = (CreditCard)ltcards.getSelectedValue();
  			btok.setEnabled(false);
  			clearFields();
  			return;
  		}
  		btok.setEnabled(true);
  		setInfo();
  	}
  	
  }
  
  private class ButtonListener implements ActionListener{
  	public void actionPerformed(ActionEvent e){
  		Object src = e.getSource();
  		if(src == btok){
  			CCApproval.card = (CreditCard)ltcards.getSelectedValue();
  			tmp.setText(CCApproval.card.toString());
  		}
  		else if(src == btcan){
  		}
  		dispose();
  	}
  }
  
  
  
}