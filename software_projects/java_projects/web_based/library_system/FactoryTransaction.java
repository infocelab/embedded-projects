import javax.swing.*;
import java.awt.*;
import java.text.*;

public class FactoryTransaction
{
	Transaction[] t;
	int i = 0;
	int j;
	DecimalFormat df = new DecimalFormat("##0.00");
	
	public FactoryTransaction()	{
		t = new Transaction[1000];
	}

	public void CreateBookTrans(String MemberID, int BookID, int BDate, int RDate, double Cost)	{
		t[getTransIDSize()] = new Transaction(MemberID, BookID, BDate, RDate, Cost);
	}


	public int getTransIDSize()	{
		while (t[i] != null) {
			i++;
		}
		return i;
	}




	public void getIDDetails (String ID) 	{
	
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(28,0));
		for(int j = 0; j <= getTransIDSize()-1; j++)	{
				if(ID.equals(t[j].getTransMemberID()))
				{
				
		p1.setBorder(BorderFactory.createTitledBorder("Transaction Details:"));
					JLabel ddd = new JLabel("========================");
					JLabel tid = new JLabel("Transaction ID : "+(j+1));
					JLabel mid = new JLabel("Member ID : "+t[j].getTransMemberID());
					JLabel bid = new JLabel("Book ID : "+t[j].getTransMBookID());
					JLabel dob = new JLabel("Date of Borrow : "+t[j].getBDate());
					JLabel dod = new JLabel("Date of Return : "+t[j].getRDate());
					p1.add(tid);
					p1.add(mid);
					p1.add(bid);
					p1.add(dob);
					p1.add(dod);
					
					if(t[j].getRDate() == 0)
					{
					JLabel bs = new JLabel("Book Has Not been Returned");
					p1.add(bs);
					}
					else
					{	
						if (t[j].calculateCost(t[j].getRDate()) < 0.00)
						{
						JLabel f = new JLabel("No Fines Aquired");
						p1.add(f);
						}
						else
						{	
					
						JLabel f1 = new JLabel("Fine Issued : $"+df.format(t[j].calculateCost(t[j].getRDate())));
						p1.add(f1);
						}
					}
					p1.add(ddd);
				}
			}
JOptionPane.showMessageDialog(null,p1,"Transaction Record",JOptionPane.INFORMATION_MESSAGE);
	
	}

	public String UpdateBookTransaction(int BookID,int DateReturned) 	{
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(6,6));
		
		for(int j = 0; j <= getTransIDSize()-1; j++)	{
				if(BookID == t[j].getTransMBookID() &&  t[j].getRDate() == 0)
				{
					p2.setBorder(BorderFactory.createTitledBorder("Transaction Details of Transaction ID:"+(j+1)));
					JLabel tid1 = new JLabel("Transaction ID : "+(j+1));
					JLabel mid1 = new JLabel("Member ID : "+t[j].getTransMemberID());
					JLabel bid1 = new JLabel("Book ID : "+t[j].getTransMBookID());
					JLabel dob1 = new JLabel("Date of Borrow : "+t[j].getBDate());
					JLabel dod1 = new JLabel("Date of Return : "+t[j].setRDate(DateReturned));
					p2.add(tid1);
					p2.add(mid1);
					p2.add(bid1);
					p2.add(dob1);
					p2.add(dod1);
					if (t[j].calculateCost(DateReturned) < 0.50)
					{
					JLabel fine = new JLabel("No Fines Aquired");
					p2.add(fine);
					}
					else
					{	
					JLabel fine1 = new JLabel("Fine Issued : $"+df.format(t[j].calculateCost(DateReturned)));
					p2.add(fine1);
					}
					
				}
			}
JOptionPane.showMessageDialog(null,p2,"Transaction Record",JOptionPane.INFORMATION_MESSAGE);
			return t[j].getTransMemberID();
		}
			
}
