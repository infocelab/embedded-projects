import java.awt.*;
import javax.swing.*;

public class FactoryBook  
{	
	Books[] B;
	private int i = 0,count;
	
	private String z;

	public FactoryBook()
	{
		B = new Books[100];
	
		B[0] = new Books("UML Toolkit", "Hans-Erik Eriksson,Magnus Penker", "John  Wiley & Sons", 1, "Avalible");
		B[1] = new Books("UML Toolkit", "Hans-Erik Eriksson,Magnus Penker", "John  Wiley & Sons", 2, "Avalible");
		B[2] = new Books("UML Toolkit", "Hans-Erik Eriksson,Magnus Penker", "John  Wiley & Sons", 3, "Avalible");
		
		B[3] = new Books("Java Design Patterns", "Cooper, James W.", "Longman Higher Education", 4, "Avalible");
		B[4] = new Books("Java Design Patterns", "Cooper, James W.", "Longman Higher Education", 5, "Avalible");
		B[5] = new Books("Java Design Patterns", "Cooper, James W.", "Longman Higher Education", 6, "Avalible");
		
		B[6] = new Books("Thinking in Java", "Eckel, Bruce", "Prentice Hall Computer Books", 7, "Avalible");
		B[7] = new Books("Thinking in Java", "Eckel, Bruce", "Prentice Hall Computer Books", 8, "Avalible");	
		B[8] = new Books("Thinking in Java", "Eckel, Bruce", "Prentice Hall Computer Books", 9, "Avalible");
		
		B[9]  = new Books("Sams teach Yourself Java 2  in 24 Hours", "Rogers Cadenhead", "Macmillan Computer Publishing ", 10, "Avalible");
		B[10] = new Books("Sams teach Yourself Java 2  in 24 Hours", "Rogers Cadenhead", "Macmillan Computer Publishing ", 11, "Avalible");
		B[11] = new Books("Sams teach Yourself Java 2  in 24 Hours", "Rogers Cadenhead", "Macmillan Computer Publishing ", 12, "Avalible");

		B[12] = new Books("JSP A Beginner's Guide", "Gary Bollinger, Bharathi Natarajan", "Osborne", 13, "Avalible");
		B[13] = new Books("JSP A Beginner's Guide", "Gary Bollinger, Bharathi Natarajan", "Osborne", 14, "Avalible");
		B[14] = new Books("JSP A Beginner's Guide", "Gary Bollinger, Bharathi Natarajan", "Osborne", 15, "Avalible");
		
		B[15] = new Books("Java How To Program", "Deitel, Harvey M./ Deitel, Paul J.", "Prentice Hall ", 16, "Avalible");
		B[16] = new Books("Java How To Program", "Deitel, Harvey M./ Deitel, Paul J.", "Prentice Hall ", 17, "Avalible");
		B[17] = new Books("Java How To Program", "Deitel, Harvey M./ Deitel, Paul J.", "Prentice Hall ", 18, "Avalible");
		
		B[18] = new Books("C++ How To Program", "Deitel, H. M./ Deitel, P. J.", "Prentice Hall ", 19, "Avalible");
		B[19] = new Books("C++ How To Program", "Deitel, H. M./ Deitel, P. J.", "Prentice Hall ", 20, "Avalible");
		B[20] = new Books("C++ How To Program", "Deitel, H. M./ Deitel, P. J.", "Prentice Hall ", 21, "Avalible");

		B[21] = new Books("Flash 5 Visual Jumpstart", "Hartman, Patricia A./ Hartman", "Sybex", 22, "Avalible");
		B[22] = new Books("Flash 5 Visual Jumpstart", "Hartman, Patricia A./ Hartman", "Sybex", 23, "Avalible");
		B[23] = new Books("Flash 5 Visual Jumpstart", "Hartman, Patricia A./ Hartman", "Sybex", 24, "Avalible");
		
		B[24] = new Books("Inside the Adobe Photoshop 6 Studio", "Mullin, Eileen", "Prima Publications ", 25, "Avalible");
		B[25] = new Books("Inside the Adobe Photoshop 6 Studio", "Mullin, Eileen", "Prima Publications ", 26, "Avalible");
		B[26] = new Books("Inside the Adobe Photoshop 6 Studio", "Mullin, Eileen", "Prima Publications ", 27, "Avalible");

		B[27] = new Books("Adobe Photoshop 6.0 Web Design ", "Baumgardt, Michael", "Adobe Press", 28, "Avalible");
		B[28] = new Books("Adobe Photoshop 6.0 Web Design ", "Baumgardt, Michael", "Adobe Press", 29, "Avalible");
		B[29] = new Books("Adobe Photoshop 6.0 Web Design ", "Baumgardt, Michael", "Adobe Press", 30, "Avalible");
		
		count = getBookSize();
	}

	public int getBookSize()	{
		while (B[i] != null) {
			i++;
		}
		return i;
	}

	
	public void getStatsUsingBName(String Name)	{
	
		for(int j = 0; j <= getBookSize()-1; j++)	{
			if(Name.equalsIgnoreCase( B[j].getName()))	{
				JPanel p1 = new JPanel();
				p1.setLayout(new GridLayout(5,5));
				JLabel     bnl  = new JLabel("Book Name      : ");
				JTextField bnt  = new JTextField(""+B[j].getName()); 
				bnt.setEditable(false);
				JLabel     bal  = new JLabel("Book Author    : ");
				JTextField bat  = new JTextField(""+B[j].getAuthor()); 
				bat.setEditable(false);
				JLabel     bpl  = new JLabel("Book Publisher : ");
				JTextField bpt  = new JTextField(""+B[j].getPublisher()); 
				bpt.setEditable(false);
				JLabel     bidl = new JLabel("Book ID        : ");
				JTextField bidt = new JTextField(""+B[j].getID()); 
				bidt.setEditable(false);
				JLabel     bsl  = new JLabel("Book Status    : ");
				JTextField bst  = new JTextField(""+B[j].getStatus()); 
				bst.setEditable(false);
				p1.add(bnl);
				p1.add(bnt);
				p1.add(bal);
				p1.add(bat);
				p1.add(bpl);
				p1.add(bpt);
				p1.add(bidl);
				p1.add(bidt);
				p1.add(bsl);
				p1.add(bst);
								
			JOptionPane.showMessageDialog(null,p1,"Book Record",JOptionPane.INFORMATION_MESSAGE);
		
				
		 	}
		 		 
		}
	}

	public void getStatsUsingID (int ID)  {
//######################ID is invalid####################
	if(ID >getBookSize()){
	JOptionPane.showMessageDialog(null,"Book not Found. The BookID you have entered is invalid","Book not Found",JOptionPane.ERROR_MESSAGE);
	}

//###################check for books in the available books###################

		for(int j = 0; j <= getBookSize()-1; j++)	{
		
			if(ID == B[j].getID())	{
				//##################################################################
				JPanel p1id = new JPanel();
				p1id.setLayout(new GridLayout(5,5));
				JLabel     idbnl  = new JLabel("Book Name      : ");
				JTextField idbnt  = new JTextField(""+B[j].getName()); 
				idbnt.setEditable(false);
				JLabel     idbal  = new JLabel("Book Author    : ");
				JTextField idbat  = new JTextField(""+B[j].getAuthor()); 
				idbat.setEditable(false);
				JLabel     idbpl  = new JLabel("Book Publisher : ");
				JTextField idbpt  = new JTextField(""+B[j].getPublisher()); 
				idbpt.setEditable(false);
				JLabel     idbidl = new JLabel("Book ID        : ");
				JTextField idbidt = new JTextField(""+B[j].getID()); 
				idbidt.setEditable(false);
				JLabel     idbsl  = new JLabel("Book Status    : ");
				JTextField idbst  = new JTextField(""+B[j].getStatus()); 
				idbst.setEditable(false);
				
				p1id.add(idbnl);
				p1id.add(idbnt);
				p1id.add(idbal);
				p1id.add(idbat);
				p1id.add(idbpl);
				p1id.add(idbpt);
				p1id.add(idbidl);
				p1id.add(idbidt);
				p1id.add(idbsl);
				p1id.add(idbst);
								
			JOptionPane.showMessageDialog(null,p1id,"Book Record",JOptionPane.INFORMATION_MESSAGE);
	
				
				//#################################################################

		 	}
				 	
		}
		 
		 
	}


	public void addBook(String BName, String BAuthor, String BPublisher,int BID)	{

		B[getBookSize()] = new Books(BName, BAuthor, BPublisher, BID, "Avalible");
	}

	
	public void setBorrowStatus(int ID) {

		for(int j = 0; j <= getBookSize()-1; j++)	{
			if(ID == B[j].getID())	
			{
				B[j].setBorrowStatus();			
			}
		}
	}

	public void setReturnStatus(int ID) {

		for(int j = 0; j <= getBookSize()-1; j++)	{
			if(ID == B[j].getID())	
			{
				B[j].setReturnStatus();			
			}
		}
	}



	public String getBookStatus(int BookID) {

		for(int j = 0; j <= getBookSize()-1; j++)	{
			if(BookID == B[j].getID())	
			{
				z = B[j].getStatus();
			}
		}
		return z;
	}	

		
		
}
