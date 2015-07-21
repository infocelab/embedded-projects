import java.util.*;
import java.io.*;

public class Transaction implements Serializable{
	private long transNumber;
	private Date transDate;
	private String merchant;
	private Customer dCustomer;
	private double amount;
	private CreditCard cardUsed;
	private String approvalNum;
	
	
	public Transaction(Customer cust, CreditCard card, double amt){
		transDate = new Date();
		amount = amt;
		dCustomer = cust;
		cardUsed = card;
	}
	
	void setTransNumber(long value){
		transNumber = value;
	}
	
	void transDate(Date aDate){
		transDate = aDate;
	}
	
	void setMerchant(String aMerch){
		merchant = aMerch;
	}
	
	void setCustomer(Customer aCustomer){
		dCustomer = aCustomer;
	}
	
	void setAmount(double value){
		amount = value;
	}
	

	void setCard(CreditCard aCard){
		cardUsed = aCard;
	}
	
	public void setApprovalNum(){
		
		approvalNum = "";
		int cardSum = 0;
		long typeSum = 0;
		if(getCardUsed()==null)
			cardSum = 0;
		else if(!getCardUsed().isAllowed()){
			approvalNum = getCardUsed().getStatus();
			return;
		}
		else if(!getCardUsed().canTransact(amount)){
			approvalNum = "Insufficient Credits";
			return;
		}
		else{
			String card = getCardUsed().getNumber();
			for(int a=0;a<card.length();a++)
				cardSum += Integer.parseInt(""+card.charAt(a));
			typeSum = 0;
			String type = getCardUsed().getType();
			for(int a=0;a<type.length();a++){
				StringBuffer sbfr = new StringBuffer(""+typeSum);
				typeSum += (Integer.parseInt(""+sbfr.reverse()))+(int)type.charAt(a);
			}
		}
		String name = getCustomer().toString();
		StringTokenizer str = new StringTokenizer(name," ,.");
		name = "";
		while(str.hasMoreTokens())
			name+=""+str.nextToken();
		int nameSum = 0;
		for(int a=0;a<name.length();){
			String tmp = "";
			for(int b=0;b<2&&a<name.length();b++)
				tmp += ((int)name.charAt(a++));
			nameSum+=(Integer.parseInt(tmp));
		}
		double diff;
		try{
			double a = getCardUsed().getLimit();
			double b = getCardUsed().getCredit();
		
			diff = Math.abs(((Math.abs(a-b))/a)*0.100);
		}
		catch(Exception e){
			diff = 1;
		}
		long approval = 0;
		
		approval += (cardSum*(379/diff));
		approval += (typeSum*(353/diff));
		approval += (nameSum*(373/diff));
		
		approval = (long)((double)(approval*(6*diff))/(28*11));
		approvalNum = ""+approval;
	}
	public long getTransNumber(){
		return transNumber;
	}
	public Date getTransDate(){
		return transDate;
	}
	public String getMerchant(){
		return merchant;
	}
	public Customer getCustomer(){
		return dCustomer;
	}
	public double getAmount(){
		return amount;
	}
	public CreditCard getCardUsed(){
		return cardUsed;
	}
	public String getApprovalNumber(){
		return approvalNum;
	}
	public boolean success(){
		return cardUsed.isAllowed();
			
	}
	
}