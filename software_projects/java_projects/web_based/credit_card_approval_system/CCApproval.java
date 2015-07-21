/**
 *Credit Card Apporval System
 *
 *@author Joseph John Paul Baba
 *@author Jeshurun Ray Flores
 *@author Lemuel Kit Rapanot
 *@version 1(BETA)
 *@since JDK 1.4 &copy 2006
 */
 
import java.awt.*;
import java.util.*;
import java.text.*;
import java.sql.Time;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import javax.swing.table.*; 
 
public class CCApproval extends ViewElements{
	
	/**************/
	/*    main    */
	/**************/
	
	public static Splash mySplash = new Splash(5000,false);
	public static void main(String[] args) {
		mySplash = new Splash(5000,false);
	 	mySplash.setVisible(true);
	 	mySplash.setStatus("Loading User Interface");
	 	mySplash.sleep(1000);
	 	try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {}//*/
		
		lbBlank.setText("Loading...");
		JFrame screen = new JFrame();
 		Dimension disp = Toolkit.getDefaultToolkit().getScreenSize();    	
   	int width = disp.width;
   	int height = disp.height;
   	int x = (disp.width - width) / 2;
   	int y = (disp.height - height) / 2;
		
		CCApproval iframe = new CCApproval("Credit Card Approval and Monitoring System V1 (BETA)");
		JDesktopPane desktop = new JDesktopPane();
		
		Dimension disp2 = Toolkit.getDefaultToolkit().getScreenSize();    	
   	int x2 = (disp2.width - 620) / 2;
   	int y2 = (disp2.height - 430) / 2;
    	
   	iframe.setBounds(x2,y2,620,430);
		iframe.setSize(620,430);	 	
		iframe.setVisible(true);
		iframe.setResizable(false);		
		iframe.setMaximizable(false);		
		iframe.setClosable(false);
		
		int bx = (disp.width - 1024)/2;
		int by = (disp.height - 768)/2;
		
		ImageIcon icon = new ImageIcon("backclip.jpg");
		JLabel back = new JLabel(icon);
		back.setBounds(x,y,1024,768);
		desktop.add(back, new Integer(Integer.MIN_VALUE));
		
	
 		desktop.add(iframe);
 		screen.getContentPane().add(desktop, BorderLayout.CENTER);
 		screen.getContentPane().setVisible(true);	 		
 		screen.setSize(width,height);
		screen.setUndecorated(true);
		screen.setVisible(true);			
		screen.setResizable(false);
		
		
		screen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		screen.addWindowListener(new windowListener());
		
		okId = (long)customers.size()+1;
		if(customers.containsKey(""+okId))
			while(!customers.containsKey(""+okId))
				okId++;
		mySplash.setStatus("Load completed..");
		mySplash.sleep(1000);
		mySplash.setVisible(false);
		lbBlank.setText("WELCOME!");
		updateClock();
		
	}	
	
	public CCApproval(String title){
		super(title);
		readFiles();
		mySplash.setStatus("Loading files..");
		mySplash.sleep(1000);
		reloadData();
		setListeners();
		clearFields(0);
		setVisible(true);
	}
	/**************/
	/*misc methods*/
	/**************/
	public void setListeners(){
		btrst1.addActionListener(new ButtonListener());
		btok1.addActionListener(new ButtonListener());
		rbcash.addActionListener(new RadioButtonListener());
		rbcard.addActionListener(new RadioButtonListener());
		btper.addActionListener(new ButtonListener());
		btselcard.addActionListener(new ButtonListener());
		btselcust.addActionListener(new ButtonListener());
		
		bttrans2.addActionListener(new ButtonListener());
		btedit.addActionListener(new ButtonListener());
		
		btview.addActionListener(new ButtonListener());
		tfsearch[0].addKeyListener(new nameSearch());
		tfsearch[1].addKeyListener(new cardSearch());		
		
		
		custsort.addMouseListenerToHeaderInTable(tbcust);
		cardsort.addMouseListenerToHeaderInTable(tbcard);
		
		miabout.addActionListener(new MenuListener());
		miexit.addActionListener(new MenuListener());
	}
	public void clearFields(int where){
		switch(where){
			case 0:
				dltype.setSelectedIndex(0);
				tacust.setText("");
  			tffn.setText("");	tfln.setText("");	tfmn.setText("");
  			tfmfn.setText("");	tfmln.setText(""); tfmmn.setText("");
  			taad.setText("");
  			spbday.setModel(new SpinnerDateModel());
				
				break;
			case 1:
				tfccnum2.setText("");	tfcust.setText("");
				tfcost.setText("");	tfstore.setText("");
				
				rbcash.setSelected(true);
				enableDisable();
				break;
				
		}
		cust = null;
		card = null;
	}
	
	/**************/
	/*   model    */
	/**************/
	public static ChainedMap customers = new ChainedMap(29);
	public static ChainedMap cards = new ChainedMap(29);
	public static Customer cust = new Customer();
	public static CreditCard card = new CreditCard();
	public static Transaction trans = new Transaction(null,null,0.0);
	public static long okId;	
	public static long transCount;
	public static final String[] month = {"January","Febuary","March","April",
	                                      "May","June","July","August","September",
	                                      "October","November","December"};
	
	/**************/
	/*    view    */
	/**************/
	/**all view objects coded in ViewElements.java**/
	
	
	/**************/
	/* controller */
	/**************/
	
	private class RadioButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			enableDisable();
		}
	}
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object src = e.getSource();
			if(src == btok1){
				cust = new Customer(tffn.getText(),tfln.getText());
				
				Date bday = (Date)spbday.getValue();
				cust.setMiddleName(tfmn.getText().trim().toUpperCase());
				cust.setMother(new Person(tfmfn.getText().trim().toUpperCase(),
				                          tfmln.getText().trim().toUpperCase(),
				                          tfmmn.getText().trim().toUpperCase()));
				cust.setBirthday(bday);
				cust.setAddress(taad.getText());
				cust.setId(okId++);
				
				if(dltype.getSelectedIndex()!=0){
					card = new CreditCard(cust,dltype.getSelectedIndex());
					cards.insert(card.getNumber(),card);
					cust.addCreditCard((CreditCard)cards.get(card.getNumber()));
					Object[] row = {card,card.getHolder(), card.getType(),card.getStatus()};
					tbcardmodel.addRow(row);
				}
				customers.insert(""+cust.getId(),cust);
				Object[] row = {cust,""+cust.cardCount()};
				tbcustmodel.addRow(row);
				clearFields(0);
				
				cust = null;
				card = null;
				lbBlank.setText("["+new Date()+"] Customer: "+row[0]+" added to database.");
			}
			else if(src == btrst1){
				clearFields(0);
				cust = null;
				card = null;
			}
			else if(src == btselcust){
				tabFrame.setSelectedIndex(2);
				tab3tabs.setSelectedIndex(0);
			}
			else if(src == btselcard){
				CustomerCreditCardsDialog dlgcard = new CustomerCreditCardsDialog(new JFrame(),tfccnum2);
			}
			else if(src == btper){
				lbBlank.setText("["+new Date()+"] Processing Transaction...");
				try{
					if(rbcard.isSelected())
						trans = new Transaction(cust,(CreditCard)cards.get(card.getNumber()),Integer.parseInt(tfcost.getText()));
					else
						trans = new Transaction(cust,null,Long.parseLong(tfcost.getText()));
					trans.setTransNumber(transCount++);
					trans.setMerchant(tfstore.getText());
					cust.addTransaction(trans);
					customers.remove(""+cust.getId());
					customers.insert(""+cust.getId(),cust);
					if(rbcard.isSelected()){
						card.addTransaction(trans);
						cards.remove(card.getNumber());
						cards.insert(card.getNumber(),card);
					}
					reloadData();
					String theOut = "";
					theOut += "Store: " + trans.getMerchant().toUpperCase() + "\n"
						+ "=======================\n" + trans.getTransDate().toString() + "\n\n" 
						+ "Customer: "+trans.getCustomer().toString()+"\n" 
						+ "Paid in ";				
	
	  				if(trans.getCardUsed() == null)
	  					theOut += "CASH :: Php "+trans.getAmount();
	  				else
	  					theOut += "CREDIT CARD :: "+trans.getCardUsed().toString();
					trans.setApprovalNum();
	  			theOut+="\n\nApproval Number: "+trans.getApprovalNumber();
					JOptionPane.showMessageDialog(null, theOut);				
				}
				catch(Exception err){
					JOptionPane.showMessageDialog(null, "There was an invalid value in the input,\nPlease enter appropriate input in the fields!","Error", JOptionPane.ERROR_MESSAGE);
					lbBlank.setText("Some fields are incomplete.");

					return;
				}			
				clearFields(1);
				cust = null;
				card = null;
				enableDisable();
				lbBlank.setText("["+new Date()+"] Transaction Processed...");
			}
			
			else if(src == bttrans2){
				try{

					int sel = tbcust.getSelectedRow();
					cust = (Customer)tbcust.getModel().getValueAt(sel,0);
					
					tabFrame.setSelectedIndex(1);
					tfcust.setText(cust.toString());
					enableDisable();
				}
				catch(Exception ex){
					lbBlank.setText("No customer has been selected.");
				}
			}
			else if(src == btedit){
				try{
					int sel = tbcust.getSelectedRow();
					cust = (Customer)tbcust.getModel().getValueAt(sel,0);
					Customer old = cust;
					ViewModifyCustomerDialog dlg = new ViewModifyCustomerDialog(new JFrame());
					customers.remove(old);
					enableDisable();
				}
				catch(Exception ex){}
			}
			else if(src == btview){
				try{
					int sel = tbcard.getSelectedRow();
					card = (CreditCard)tbcard.getModel().getValueAt(sel,0);
					ViewCreditCardDialog dlg = new ViewCreditCardDialog(new JFrame());
					reloadData();
				}
				catch(Exception ex){}
			}
		}
	}
	
 	static String profileSearchText = "";
 	static String cardSearchText = "";
	
	private class nameSearch extends KeyAdapter
	{
	  	public void keyReleased(KeyEvent e)
		{
	   		profileSearchText = tfsearch[0].getText();
	   		updateProfileTable();
	   	
	  	}
	}
	private class cardSearch extends KeyAdapter
	{
	  	public void keyReleased(KeyEvent e)
		{
	   		cardSearchText = tfsearch[1].getText();	   		
	   		updateCardTable();
	   	
	  	}
	}
	private void updateProfileTable() {

	  	while(srchTableModel.getRowCount() > 0)
	  		srchTableModel.removeRow(0);	  	
  	
	  	if(profileSearchText.equals(""))
	  		tbcust.setModel(custsort);
	  	
	  	else{	  	
	  		ListIterator iter = CCApproval.customers.dataIterator();
	  	
	  		while(iter.hasNext()){
		  		Customer toProcess = (Customer)iter.next();
		  		if(toProcess.toString().startsWith(profileSearchText.toUpperCase()))
		  			srchTableModel.addRow(new Object[]{toProcess, ""+toProcess.cardCount()});		  		
		  	}
		  	tbcust.setModel(srchsort);
		}			
 	}
 	private void updateCardTable() {

	  	while(srchCardModel.getRowCount() > 0)
	  		srchCardModel.removeRow(0);	  	
  	
	  	if(cardSearchText.equals(""))
	  		tbcard.setModel(cardsort);
	  	
	  	else{	  	
	  		ListIterator iter = CCApproval.cards.dataIterator();
		  		int tempX = dlsearch.getSelectedIndex();
	  		while(iter.hasNext()){
		  		CreditCard toProcess = (CreditCard)iter.next();
		  		String comparable = "";
		  		switch(tempX){
		  			case 0 : comparable = toProcess.getHolder().toString(); break;
		  			case 1 : comparable = "" + toProcess.getNumber(); break;
		  			case 2 : comparable = toProcess.getType();break;
		  		}
		  		if(comparable.startsWith(cardSearchText.toUpperCase()))
		  			srchCardModel.addRow(new Object[]{toProcess, ""+toProcess.getHolder(), toProcess.getType(), toProcess.getStatus()});		  		
		  	}
		  	tbcard.setModel(crdsort);
		}			
 	}
	
	
	private class MenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Object src = e.getSource();
			if(src == miabout){
				JDialog theAbout = new About(null);
			}
			else if(src == miexit){
				Object[] options = { "YES", "NO" };
				int option = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?","EXIT",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, options, options[0]);
				if (option == JOptionPane.OK_OPTION){
					writeFiles();
					lbBlank.setText("Thank You For Using Me.. :D");
					System.exit(0);
				}
			}
			
		}
	}
	private static class windowListener extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			Object[] options = { "YES", "NO" };
			int option = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?","EXIT",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, options[0]);
			if (option == JOptionPane.OK_OPTION){
				lbBlank.setText("Thank You For Using Me.. :D");
				System.exit(0);
			}
		}
	}
	
	
	public static void updateClock(){		
		while(true){    		
   			Date now = new Date();
   	    	DateFormat df1 = DateFormat.getDateInstance(DateFormat.LONG); 
    		long startDate = now.getTime();
  
			Time distime = new Time(startDate);
					boolean amPM = false;
					int tempH = distime.getHours();
					int tempMin = distime.getMinutes();
					int tempSec = distime.getSeconds();
					
					if(tempH > 12){        	
						tempH -= 12;
						amPM = true;
					}
        	
        	
					NumberFormat nf = NumberFormat.getInstance();
					nf.setMinimumIntegerDigits(2);
					nf.setMaximumIntegerDigits(2);        	
					String theOut = "" + nf.format(tempH) + ":" + nf.format(tempMin) + ":" + nf.format(tempSec);
					if(amPM)
						theOut += " PM";
					else
        		theOut += " AM";        		
					
     	 	DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL);
			String s4 = df2.format(now);
			theOut += "  " + s4;	
			
			lbClock.setText(theOut);		
		
        	if(Integer.parseInt(nf.format(tempMin))%10==0 && 
        	Integer.parseInt(nf.format(tempSec)) == 0){
        		lbBlank.setText("Auto-saving data...");
        		writeFiles();
        		lbBlank.setText("System is Idle..");
        	}
		
    	try{Thread.sleep(200);} catch(InterruptedException e){}
    	}	  
	}
	
	static void writeFiles(){
		try{
			FileOutputStream outStream = new FileOutputStream("Customers.dat");
			ObjectOutputStream ooStream = new ObjectOutputStream(outStream);
			
			ooStream.writeObject(customers);
			ooStream.flush();
			outStream.close();
			
			
			outStream = new FileOutputStream("CreditCards.dat");
			ooStream = new ObjectOutputStream(outStream);

			ooStream.writeObject(cards);
			ooStream.flush();
			outStream.close();

			FileWriter misc = new FileWriter("misc.inf");
			misc.write(""+transCount);
			misc.close();
    }
    catch (IOException exc){System.err.println("Encountered error while writing files!");}
  }
  static void readFiles(){
		lbBlank.setText("Loading...");
    try{
			FileInputStream inStream;
			ObjectInputStream oiStream;
      
			inStream = new FileInputStream("CreditCards.dat");
			oiStream = new ObjectInputStream(inStream);
       
       
			cards = (ChainedMap)oiStream.readObject();
			
			inStream.close();
			
			inStream = new FileInputStream("Customers.dat");
			oiStream = new ObjectInputStream(inStream);
      
			customers = (ChainedMap)oiStream.readObject();
      
			inStream.close();
    }
    catch (FileNotFoundException exc){
			System.err.println("Some required file/s is/are missing or might be corrupt!");
    }
    catch (IOException exc){}
    catch(ClassNotFoundException exc){
			System.err.println("Required files not found.");
    }
    try{
			BufferedReader br = new BufferedReader(new FileReader("misc.inf"));
			transCount = Long.parseLong(br.readLine());
		}
		catch(FileNotFoundException ex){
			transCount = 1;
		}
    catch (IOException exc){}
  }
	public static void reloadData(){
		ListIterator iter = customers.dataIterator();
		int a =0;
		while(iter.hasNext()){
			Customer tmp = (Customer)iter.next();
			Object[] row = {tmp,""+tmp.cardCount()};
			try{
				tbcustmodel.setValueAt(row[0],a,0);
				tbcustmodel.setValueAt(row[1],a,1);
			}
			catch(Exception e){
				tbcustmodel.addRow(row);
			}
			a++;
		}
		iter = cards.dataIterator();
		a = 0;
		while(iter.hasNext()){
			CreditCard tmp = (CreditCard)iter.next();
			Object[] row2 = {tmp,tmp.getHolder(), tmp.getType(),tmp.getStatus()};
			try{
				for(int b=0;b<row2.length;b++)
					tbcardmodel.setValueAt(row2[b],a,b);
			}
			catch(Exception e){
				tbcardmodel.addRow(row2);
			}
			a++;
		}
	}
	public static String dateString(Date thisDate){
		String date = "";
		date+=month[thisDate.getMonth()]+" ";
		date+=thisDate.getDate()+", ";
		date+=(thisDate.getYear()+1900);
		
		return date;
	}
}