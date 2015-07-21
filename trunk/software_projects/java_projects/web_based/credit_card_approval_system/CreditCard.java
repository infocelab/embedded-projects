import java.util.*;
import java.io.*;

public class CreditCard implements Serializable{
	private int type;
	private String ccNumber;
	private double creditLimit;
	private double currCredit;
	private Date expiration;
	private Customer cardHolder;
	private ChainedSet transactions;
	private static ChainedMap issuedCards = new ChainedMap(53);
	private static final String[] types = {"No Card:Cash Only","DINER'S","JCB","MASTER","VISA"};
	public CreditCard(){
		this(null,0);
	}
	public CreditCard(Customer cust, int type){
		cardHolder = cust;
		setType(type);
		expiration = new Date();
		expiration.setYear(expiration.getYear()+3);
		currCredit = 0.0;
		creditLimit = 10000.0;
		transactions = new ChainedSet();
	}
	void setType(int aType){
		type = aType;
		setNumber();
	}
	
	void setNumber(){
		ccNumber = generate(getTypeCode());		
		if(type>0)
			issuedCards.insert(ccNumber,this);
	}
	
	void setLimit(double aLimit){
		creditLimit = aLimit;
	}
	
	void setCredit(double aCredit){
		currCredit = aCredit;
	}
	
	void setExpiry(Date aExpiry){
		expiration = aExpiry;
	}
	
	void setHolder(Customer aHolder){
		cardHolder = aHolder;
	}	
	
	public String getType(){
		return types[type];
	}
	public int getTypeCode(){
		return type;
	}
	
	public String getNumber(){
		return ccNumber;		
	}
	
	public double getLimit(){
		return creditLimit;
	}
	
	public double getCredit(){
		return currCredit;
	}
	
	public Date getExpiry(){
		return expiration;
	}
	
	public Customer getHolder(){
		return cardHolder;
	}
	
	void addTransaction(Transaction aTransaction){
		transactions.add(aTransaction);
		if(canTransact(aTransaction.getAmount()))
			payCredit(-1*aTransaction.getAmount());
	}
	
	void payCredit(double dAmount){
		currCredit -= dAmount;
	}
	
	void renew(Date renewal){
		expiration = renewal;
	}
	
	void extendCredit(double addCredit){
		creditLimit += addCredit;
	}
	
	public boolean hasMoreCredits(){
		return currCredit<creditLimit;
	}
	public boolean isExpired(){
		Date curDate = new Date();
		long timeleft = getExpiry().getTime() - curDate.getTime();
		return timeleft < 0;
	}
	public boolean isAllowed(){
		if(!hasMoreCredits())
			return false;
		else if(isExpired())
			return false;
		else
			return true;
	}
	public boolean canTransact(double amt){
		return (isAllowed() && (currCredit+amt)<=creditLimit);
			
	}
	public String getStatus(){
		String toRet = "";
		if(isAllowed())
			toRet = "OK";
		else{
			if(!hasMoreCredits())
				toRet += "Credit Limit Exceeded. ";
			if(isExpired())
				toRet += "Card expired. ";
		}
		return toRet;
	}
	public ListIterator getTransactions(){
		return transactions.iterator();
	}
	public static String generate(int type){
		String out = "";
		int[] card = new int[1]; int start = 0;
		switch(type){
			case 0:
				type = 0;
				return "";
			case 1: // diner's card number generator
				card = new int[14];
				card[0] = 3;
				card[1] = (int)Math.floor(Math.random()*7)+1;
				card[13] = 4;
				if(card[1]>=0&&card[1]<6){
					card[2] = (int)Math.floor(Math.random()*4)+1;
					start = 3;
				}
				else
					start = 2;
				break;
			case 2: //JCB card number generator
				card = new int[16];
				card[0] = 2; card[1] = 1;
				card[2] = 3; card[3] = 1;
				card[15] = 8;
				start = 3;
				break;
			case 3: //master card number generator
				card = new int[16];
				card[0] = 5;
				card[1] = (int)Math.floor(Math.random()*4)+1;
				card[15] = 4; start = 2;
				break;
			case 4: //visa card number generator
				switch((int)Math.floor(Math.random()*2)){
					case 0:  card = new int[13]; break;
					case 1:  card = new int[16]; card[15] = 2;
				}
				card[0] = 4; start = 2;
				break;
			default:
				type = -1;
				return "";
		}
		
		for(int a=0;a<start;a++)
			out+=card[a];
		
		for(int a=start;a<card.length-1;a++){
			card[a] = (int)Math.floor(Math.random()*10);
			out += card[a];
		}
		if(!isValid(card)||issuedCards.containsKey(out))
			generate(type);
			
		return out;
	}
	
	private static boolean isValid(int[] card){
		int sum = 0;
		for(int a=1;a<=card.length;a++){
			int factor = card[a-1]*((a%2)+1);
			if(factor>9)
				factor-=9;
			sum+=factor;
		}
		if(sum%10==0)	return true;
		return false;
	}
	
	public String toString(){
		return ""+getNumber();
	}
}