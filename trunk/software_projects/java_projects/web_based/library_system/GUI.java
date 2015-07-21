/********************************************************************
************** Subject       : ODA               ********************
************** Class         : C206              ******************** 
************** Group         : 2                 ********************
************** Project       : Library System    ********************
************** Name 1        : C A Vijayan       ********************
************** Name 2        : Ong Tian Rong     ********************
************** Name 3        : W A J Fernando    ********************
************** Name 4        : Zaw Zaw Latt      ********************   
*********************************************************************/

//##################################################################.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
//##################################################################.

public class GUI extends JFrame
{
	Controller c = new Controller();
	JTabbedPane tpane = new JTabbedPane();

/*--------------------Components used in add member ---------------------------------*/
	JPanel AddMemberPanel,AddMemberPanel1;
	JLabel AddMemberNameLabel,AddAgeLabel,AddICLabel,AddAddressLabel,AddMemberTelLabel;
	JTextField AddMemberNameField,AddAgeField,AddICField,AddAddressField,AddMemberTelField;
	JButton AddMemberButton;
/*--------------------Components used in add book ---------------------------------*/
	JPanel AddBookPanel,AddBookPanel1;
	JLabel AddBookNameLabel,AddBookPublisherLabel,AddBookAuthorLabel,AddBookIDLabel;
	JTextField AddBookNameField, AddBookPublisherField,AddBookAuthorField,AddBookIDField;
	JButton AddBookButton;
/*--------------------Components used in search books ---------------------------------*/
	JPanel SearchBookPanel;
	JLabel SearchBookIDLabel;
	JTextField SearchBookIDField;
	JButton SearchBookButton;
	
	JPanel SearchBook1Panel;
	JLabel SearchBook1IDLabel;
	JTextField SearchBook1IDField;
	JButton SearchBook1Button;
/*--------------------Components used in search members ---------------------------------*/
	JPanel SearchMemberPanel;
	JLabel SearchMemberIDLabel;
	JTextField SearchMemberIDField;
	JButton SearchMemberButton;
	
	JPanel SearchMember1Panel;
	JLabel SearchMember1IDLabel;
	JTextField SearchMember1IDField;
	JButton SearchMember1Button;
/*--------------------Components used in returning books ---------------------------------*/

	JPanel ReturnPanel,ReturnPanel1;						
	JLabel ReturnDateLabel, ReturnMemberIDLabel; 
	JTextField ReturnDateField, ReturnBookIDField;
	JButton ReturnDateButton; 
/*--------------------Components used in borrowing ---------------------------------*/

	JPanel BorrowPanel,BorrowPanel1;
	JLabel BorrowDateLabel,BorrowMemberLabel,BorrowBookIDLabel;
	JTextField BorrowDateField,BorrowMemberField,BorrowBookIDField;
	JButton BorrowButton;
/*--------------------Components used in transaction ---------------------------------*/
	JPanel TransactionPanel;
	JLabel TransMemberIDLabel;
	JTextField TransMemberField;
	JButton CheckTransButton;

	
	public GUI()
	{
		super("Library System");
/*--------------------Panels used in our project---------------------------------*/
		AddMemberPanel    = new JPanel();
		AddMemberPanel1   = new JPanel();
		AddBookPanel      = new JPanel();
		AddBookPanel1     = new JPanel();
		SearchBookPanel   = new JPanel();
		SearchBook1Panel  = new JPanel();
		SearchMemberPanel = new JPanel();
		SearchMember1Panel= new JPanel();
		ReturnPanel       = new JPanel();
		ReturnPanel1      = new JPanel();
		BorrowPanel       = new JPanel();
		BorrowPanel1      = new JPanel();
		TransactionPanel  = new JPanel();
/*--------------------textfields initialization used in our project---------------*/
		AddMemberNameField 		= new JTextField(8);
		AddAgeField 			= new JTextField(8);
		AddICField				= new JTextField(8);
		AddAddressField 		= new JTextField(8);
		AddMemberTelField 		= new JTextField(8);
		AddBookNameField 		= new JTextField(8);
		AddBookPublisherField 	= new JTextField(8);
		AddBookAuthorField 		= new JTextField(8);
		AddBookIDField 			= new JTextField(8);
		SearchBookIDField		= new JTextField(8);
		SearchBook1IDField		= new JTextField(8);
		SearchMemberIDField		= new JTextField(8);
		SearchMember1IDField	= new JTextField(8);
		ReturnDateField			= new JTextField(8);
		ReturnBookIDField		= new JTextField(8);
		BorrowDateField			= new JTextField(8);
		BorrowMemberField		= new JTextField(8);
		BorrowBookIDField		= new JTextField(8);
		TransMemberField		= new JTextField(8);
/*-----------------------Labels initialization used in our project------------*/
		AddMemberNameLabel    = new JLabel("Member Name       : ");
		AddAgeLabel           = new JLabel("Age               : ");
		AddICLabel            = new JLabel("IC No             : ");
		AddAddressLabel       = new JLabel("Address           : ");
		AddMemberTelLabel     = new JLabel("Telephone         : ");
		AddBookNameLabel      = new JLabel("Book Name         : ");
		AddBookPublisherLabel = new JLabel("Publisher Name    : ");
		AddBookAuthorLabel    = new JLabel("Author Name       : ");
		AddBookIDLabel        = new JLabel("Book ID           : ");
		SearchBookIDLabel     = new JLabel("Enter Book ID     : ");
		SearchBook1IDLabel    = new JLabel("Enter Book Name   : ");
		SearchMemberIDLabel   = new JLabel("Enter Member ID   : ");
		SearchMember1IDLabel  = new JLabel("Enter Member Name : ");
		ReturnDateLabel       = new JLabel("Enter Return Date : ");
		ReturnMemberIDLabel   = new JLabel("Enter Book ID     : ");
		BorrowDateLabel       = new JLabel("Enter Date Borrow : ");
		BorrowMemberLabel     = new JLabel("Enter Member ID   : ");
		BorrowBookIDLabel     = new JLabel("Enter Book ID     : ");
		TransMemberIDLabel    = new JLabel("Enter Member ID   : ");
/*-----------------------Buttons initialization used in our project------------*/
		AddMemberButton    = new JButton(" Create New Member ");
		AddBookButton      = new JButton(" Create New Book   ");
		SearchBookButton   = new JButton(" Search For Book   ");
		SearchBook1Button  = new JButton(" Search For Book   ");
		SearchMemberButton = new JButton(" Search For Member ");
		SearchMember1Button= new JButton(" Search For Member ");
		ReturnDateButton   = new JButton(" Return Book       ");
		BorrowButton       = new JButton(" Borrow Book       ");
		CheckTransButton   = new JButton(" Check Transaction ");
/*----------------Setting layout for the panels used in our project-------------*/
		AddBookPanel.setLayout(new GridLayout(4,1));
		AddBookPanel1.setLayout(new BorderLayout());
		AddMemberPanel.setLayout(new GridLayout(5,1));
		AddMemberPanel1.setLayout(new BorderLayout());
		SearchBookPanel.setLayout(new GridLayout(5,1));
		SearchBook1Panel.setLayout(new GridLayout(5,1));
		SearchMemberPanel.setLayout(new GridLayout(5,1));
		SearchMember1Panel.setLayout(new GridLayout(5,1));
		ReturnPanel.setLayout(new GridLayout(2,1));
		ReturnPanel1.setLayout(new BorderLayout());
		BorrowPanel.setLayout(new GridLayout(3,2));
		BorrowPanel1.setLayout(new BorderLayout() );
		TransactionPanel.setLayout(new GridLayout(4,1));
/*-------------------Member panel-------------------------------------------------------------*/	
		AddMemberPanel.add(AddMemberNameLabel);
		AddMemberPanel.add(AddMemberNameField);
		AddMemberPanel.add(AddAgeLabel);
		AddMemberPanel.add(AddAgeField);
		AddMemberPanel.add(AddICLabel);
		AddMemberPanel.add(AddICField);
		AddMemberPanel.add(AddAddressLabel);
		AddMemberPanel.add(AddAddressField);
		AddMemberPanel.add(AddMemberTelLabel);
		AddMemberPanel.add(AddMemberTelField);
/*--------------------------------------------------------------------------------*/
		AddBookPanel.add(AddBookNameLabel);
		AddBookPanel.add(AddBookNameField);
		AddBookPanel.add(AddBookAuthorLabel);
		AddBookPanel.add(AddBookAuthorField);
		AddBookPanel.add(AddBookPublisherLabel);
		AddBookPanel.add(AddBookPublisherField);
		AddBookPanel.add(AddBookIDLabel);
		AddBookPanel.add(AddBookIDField);
/*--------------------------------------------------------------------------------*/
		SearchBookPanel.add(SearchBookIDLabel);
		SearchBookPanel.add(SearchBookIDField);
		SearchBookPanel.add(SearchBookButton);
		SearchBookButton.addActionListener(new SearchBookButtonListener());
/*--------------------------------------------------------------------------------*/
		SearchBook1Panel.add(SearchBook1IDLabel);
		SearchBook1Panel.add(SearchBook1IDField);
		SearchBook1Panel.add(SearchBook1Button);
		SearchBook1Button.addActionListener(new SearchBook1ButtonListener());
/*--------------------------------------------------------------------------------*/
		SearchMemberPanel.add(SearchMemberIDLabel);
		SearchMemberPanel.add(SearchMemberIDField);
		SearchMemberPanel.add(SearchMemberButton);
		SearchMemberButton.addActionListener(new SearchMemberListener());
/*--------------------------------------------------------------------------------*/
		SearchMember1Panel.add(SearchMember1IDLabel);
		SearchMember1Panel.add(SearchMember1IDField);
		SearchMember1Panel.add(SearchMember1Button);
		SearchMember1Button.addActionListener(new SearchMember1Listener());
/*--------------------------------------------------------------------------------*/
		ReturnPanel.add(ReturnDateLabel);
		ReturnPanel.add(ReturnDateField);
		ReturnPanel.add(ReturnMemberIDLabel);
		ReturnPanel.add(ReturnBookIDField);
/*--------------------------------------------------------------------------------*/
		BorrowPanel.add(BorrowDateLabel);
		BorrowPanel.add(BorrowDateField);
		BorrowPanel.add(BorrowMemberLabel);
		BorrowPanel.add(BorrowMemberField);
		BorrowPanel.add(BorrowBookIDLabel);
		BorrowPanel.add(BorrowBookIDField);
/*--------------------------------------------------------------------------------*/
		TransactionPanel.add(TransMemberIDLabel);
		TransactionPanel.add(TransMemberField);
		TransactionPanel.add(CheckTransButton);
		CheckTransButton.addActionListener(new CheckTransButtonListener());
/*--------------------------------------------------------------------------------------------------------------------------------------*/	
		JPanel searchp = new JPanel();
		searchp.setLayout(new GridLayout(2,1));
		searchp.add(SearchBookPanel);
		searchp.add(SearchBook1Panel);
		searchp.add(SearchMemberPanel);
		searchp.add(SearchMember1Panel);
/*--------------------------------------------------------------------------------*/
AddMemberPanel1.add(AddMemberPanel,BorderLayout.CENTER);
AddMemberPanel1.add(AddMemberButton,BorderLayout.SOUTH);
AddMemberButton.addActionListener( new AddMemberButtonListener());
/*--------------------------------------------------------------------------------*/
AddBookPanel1.add(AddBookPanel,BorderLayout.CENTER);
AddBookPanel1.add(AddBookButton,BorderLayout.SOUTH);
AddBookButton.addActionListener( new AddBookButtonListener());
/*--------------------------------------------------------------------------------*/
BorrowPanel1.add(BorrowPanel,BorderLayout.CENTER);
BorrowPanel1.add(BorrowButton,BorderLayout.SOUTH);
BorrowButton.addActionListener(new BorrowButtonListener());
/*--------------------------------------------------------------------------------*/
ReturnPanel1.add(new JLabel("Please enter the date properly to calculate fines correctly.See Impotant Notes for details."),BorderLayout.NORTH);
ReturnPanel1.add(ReturnPanel,BorderLayout.CENTER);
ReturnPanel1.add(ReturnDateButton,BorderLayout.SOUTH);
ReturnDateButton.addActionListener(new ReturnDateButtonListener());
/*--------------------------------------------------------------------------------*/
JPanel design = new JPanel();
design.setLayout(new BorderLayout());
String designl =
      "<html>"+
      "<p><b><i>Designed by:</i></b></p>"+
	  "<p><b>C206 Group 2</b></p>"+
      "<ul>"+
      "<li>C A Vijayan</li>"+
      "<li>W A J Fernando</li>"+
      "<li>Ong Tian Rong</li>"+
      "<li>Zaw Zaw Latt</li>"+
      "</ul>";
        
    JLabel dby  = new JLabel(designl);
    design.add(dby,BorderLayout.CENTER);

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		JPanel timep = new JPanel();
		Date td = new Date();
		String tdate1 = DateFormat.getDateInstance().format(td);
		JLabel timel1 = new JLabel("Today the date is "+tdate1+". And now the time is ");
		JLabel time1 = new JLabel();
		new TimerTime(time1);
		timep.add(timel1);
		timep.add(time1);

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	JPanel help = new JPanel();
	help.setLayout(new BorderLayout());
	String helpl =
      "<html>"+
      "<p><b><i>Important Notes:</b></p>"+
	  "<p><b>Below were the some important points that you need to</b></p>"+
      "<p><b>keep in mind while using this system:</b></p>"+
      "<ul>"+
      "<li>If the book was borrowed previous month, for entering the return date please calculate and enter the no of days that book have been with member. </li>"+
      "<li>Ex: Borrowed date : 25th February </li>"+
      "<li>Return date: 15th March </li>"+
      "<li>No of days in february: 28-25 = 3 </li>"+
      "<li>No of days in march   : 15</li>"+
      "<li>Total no of days = 3+15 = 18 days </li>"+
      "</ul>";
     JLabel h1 = new JLabel(helpl);
     
     help.add(h1,BorderLayout.CENTER);
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		tpane.addTab("Add Members",AddMemberPanel1);
		tpane.addTab("Add Books",AddBookPanel1);
		tpane.addTab("Search",searchp);
		tpane.addTab("Returning Books",ReturnPanel1);
		tpane.addTab("Borrowing Books",BorrowPanel1);
		tpane.addTab("Transaction Records",TransactionPanel);
		tpane.addTab("Designed By",design);
		tpane.addTab("Important Notes",help);
/*--------------------------------------------------------------------------------*/
		
		Container mainpanel =getContentPane(); //getting  contentpane and creating mainpanel
		mainpanel.setLayout(new BorderLayout());
		mainpanel.add(tpane,BorderLayout.CENTER);
		mainpanel.add(timep,BorderLayout.SOUTH);
		setSize(625,325);
		setVisible(true);

		
/*--------------------------------------------------------------------------------*/
	}


	class AddMemberButtonListener implements ActionListener {


		public void actionPerformed(ActionEvent ae) {
			
  			c.ControllerAddMember(AddMemberNameField.getText(),Integer.parseInt(AddAgeField.getText()), AddICField.getText(), AddAddressField.getText(), Integer.parseInt(AddMemberTelField.getText()));
			
				
			}
		}


	class AddBookButtonListener implements ActionListener {

		private int a;

		public void actionPerformed(ActionEvent ae) {

					a = Integer.parseInt(AddBookIDField.getText());
			
					c.ControllerAddBook(AddBookNameField.getText(),AddBookAuthorField.getText(),AddBookPublisherField.getText(),a);

					
			
				
			}
		}

	class SearchBookButtonListener implements ActionListener {

		private int a;

		public void actionPerformed(ActionEvent ae) {

					a = Integer.parseInt(SearchBookIDField.getText());
			
					c.ControllerBookIDRetrieve(a);
			
				
			}
		}
//--------------------------------------		
	class SearchBook1ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
					
			c.ControllerBookNameRetrieve(SearchBook1IDField.getText());
							
			}
		}
//------------------------------------------------
	class SearchMemberListener implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
					
			c.ControllerICRetrieve(SearchMemberIDField.getText());
		
			}
		}
//*****************************************************************
	class SearchMember1Listener implements ActionListener {


		public void actionPerformed(ActionEvent ae) {
					
					c.ControllerNameRetrieve(SearchMember1IDField.getText());
		
			}
		}
//*****************************************************************
	class ReturnDateButtonListener implements ActionListener {

	

		public void actionPerformed(ActionEvent ae) {

					
					c.ReturnBook(Integer.parseInt(ReturnBookIDField.getText()),Integer.parseInt(ReturnDateField.getText()));
				
					
				
			}
		}

	class BorrowButtonListener implements ActionListener {

	

		public void actionPerformed(ActionEvent ae) {

					
					c.BorrowBook(BorrowMemberField.getText(), Integer.parseInt(BorrowBookIDField.getText()), Integer.parseInt(BorrowDateField.getText()));
					
					
				
			}
		}


	class CheckTransButtonListener implements ActionListener {

	

		public void actionPerformed(ActionEvent ae) {

					
					c.checkTrans(TransMemberField.getText());
					
					
				
			}
		}
//--------------------------------------------------------------------------------

//--------------------------------------------------------------------------------

	}	

