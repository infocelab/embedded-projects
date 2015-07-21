import javax.swing.*;
import java.awt.*;

public class Controller
{	
	private int Count = 0;
	FactoryMember fm;
	FactoryBook   bm;
	FactoryTransaction ft;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JTextField bsct = new JTextField();
	JTextField bsct1 = new JTextField();
	JTextField nobt = new JTextField();	
	
	public Controller()	{ 
		fm = new FactoryMember();
		bm = new FactoryBook();
		ft = new FactoryTransaction();	
		//******************************************************
		p1.setLayout(new GridLayout(5,0));						
		JLabel     nob  = new JLabel("No.of Books Member Borrowed : ");
		JLabel     bsc  = new JLabel("Book Status Changed to : ");
		JLabel     bbc  = new JLabel("Book Borrow Confirmed");
		bsct.setEditable(false);
		nobt.setEditable(false);
		p1.add(nob);
		p1.add(nobt);
		p1.add(bsc);
		p1.add(bsct);
		p1.add(bbc);
		//******************************************************
		p2.setLayout(new GridLayout(3,0));
		JLabel bsc1 = new JLabel("Book Status Changed to : ");
		JLabel bbc1 = new JLabel("Book Return Confirmed");
		bsct1.setEditable(false);
		p2.add(bsc1);
		p2.add(bsct1);
		p2.add(bbc1);
		
		
	}


	public void ControllerNameRetrieve(String Name)	{
		fm.getStatsUsingName(Name);
	}
	//***************************************************
	public void ControllerICRetrieve(String IC)	{
		fm.getStatsUsingIC(IC);
	}
	//***************************************************

	public void ControllerAddMember(String Name, int Age, String IC, String Address, int Telephone)	{
		fm.addMember(Name,Age,IC,Address,Telephone);
	
	}
	public void ControllerBookNameRetrieve(String BName) {
		bm.getStatsUsingBName(BName);
	}
	public void ControllerBookIDRetrieve(int ID) {
		bm.getStatsUsingID(ID);
	}
	public void ControllerAddBook(String BName, String BAuthor, String BPublisher, int BID) {
		bm.addBook(BName, BAuthor, BPublisher, BID);
	}
	public void BorrowBook(String MemberID, int BookID, int DateBorrowed) {
		if(fm.getMemberBookCount(MemberID) == 4 )
			{
			JOptionPane.showMessageDialog(null,"You have reached the maximum no of books\n that you can borrow" ,"No of book limits reached",JOptionPane.INFORMATION_MESSAGE);
			}
				else if(bm.getBookStatus(BookID).equals("Unavalible")) 
			{
			JOptionPane.showMessageDialog(null,"The Book was out of library" ,"Book not Available",JOptionPane.INFORMATION_MESSAGE);
			}	
				
				
				else if (fm.getMemberBookCount(MemberID) < 4 && bm.getBookStatus(BookID).equals("Avalible")) 
					{ 
						fm.UpdateBookCount(MemberID);
						bm.setBorrowStatus(BookID);
						ft.CreateBookTrans(MemberID,BookID,DateBorrowed, 0, 0.0);
						//------------------------------------------------
						bsct.setText(bm.getBookStatus(BookID));
						nobt.setText(""+fm.getMemberBookCount(MemberID));
						//-----------------------------------------------
	JOptionPane.showMessageDialog(null,p1,"Member's Status",JOptionPane.INFORMATION_MESSAGE);
					}

	}
	public void ReturnBook(int BookID, int DateReturned) {
		
		bm.setReturnStatus(BookID);
		fm.ReturnBookCount(ft.UpdateBookTransaction(BookID, DateReturned));
		//------------------------------------------------
		//	bsct1.setText(""+bm.getBookStatus(BookID));
		//-------------------------------------------
	//JOptionPane.showMessageDialog(null,p2," Status of Book No "+BookID,JOptionPane.INFORMATION_MESSAGE);

}
	public void checkTrans(String MemberID)	{
	
		ft.getIDDetails(MemberID);
	}
}
