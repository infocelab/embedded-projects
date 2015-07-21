import java.util.*;
import java.io.*;
public class Customer extends Person implements Serializable{
	private long id;
	private static long custCount;
	private Person mother;
	private String address;
	private Date BirthDate;
	private ChainedBag transactions;
	private ChainedMap cards;
	
	Customer(){
		this("","");
	}	
	
	Customer(String fName, String lName){
		super(fName.toUpperCase().trim(), lName.toUpperCase().trim(), "");
		mother = new Person();
		address = "";
		this.BirthDate = new Date();
		transactions = new ChainedBag();
		cards = new ChainedMap();
	}
	
	public double getBalance(){
		double totalBal = 0.0;
		if(cardCount()==0)
			return 0.0;
		else{
			ListIterator iter = cards.dataIterator();
			while(iter.hasNext()){
				CreditCard tmp = (CreditCard)iter.next();
				totalBal+=tmp.getCredit();
			}
		}
		return totalBal;
	}
	public void printCards(){
		System.out.println(cards);
	}
	
	public long getId(){
		return id;
	}
	public void setId(long id){
		this.id = id;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setMother(Person mother){
		this.mother = mother;
	}
	
	public void setBirthday(Date bDay){
		BirthDate = bDay;
	}
	
	public String getMotherName(){
		return mother.toString();
	}
	public Person getMother(){
		return mother;
	}
	
	public Date getBirthday(){
		return BirthDate;
	}
	
	public ListIterator getTransactions(){
		return transactions.iterator();
	}
	
	public ListIterator getCards(){
		return cards.dataIterator();
	}
	public int cardCount(){
		return cards.size();
	}
	
	public void addTransaction(Object trans){
		//if(!trans.getCustomer().toString().equals(this.toString()))
	//		throw new IllegalStateException ("Transaction is not by this customer.");
			
		transactions.add(trans);
	}
	
	public void addCreditCard(CreditCard aCreditCard){
		cards.insert(aCreditCard,aCreditCard);
	}
	
	public String toString(){
		return super.toString();
	}
}