
import java.text.*;

public class Transaction
{	
	String MemberID2 ;
	int BookID2, DateB, DateR;
	double Cost1;

	public Transaction(String MemberID, int BookID, int BDate, int RDate, double Cost) {

	MemberID2 = MemberID;
	BookID2 =  BookID;
	DateB = BDate;
	DateR = RDate;
	Cost1 = Cost;
}

	public String getTransMemberID(){
		return MemberID2;
	}
	public int getTransMBookID(){
		return BookID2;
	}
	public int getBDate(){
		return DateB;
	}
	public double getCost(){
		return Cost1;
	}
	public int setRDate(int ReturnedDate){
		DateR = ReturnedDate;
		return DateR;
	}
	public int getRDate(){
		return DateR;
	}
	public double calculateCost(int ReturnedDate){

 		Cost1 = (((ReturnedDate-getBDate())-14)*0.10);
 		
		return Cost1;
	}
}
