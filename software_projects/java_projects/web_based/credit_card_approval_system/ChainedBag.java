//CHAINED BAG IMPLEMENTATION
//BABA, FLORES, RAPANOT

import java.util.*;
import java.io.*;
public class ChainedBag implements BagPT, Serializable{
	private static final int DEFAULT_CHAIN_SIZE = 7;
	private ListPT[] bag;
	int size;
	
	public ChainedBag(){
		this(DEFAULT_CHAIN_SIZE);
	}
	public ChainedBag(int buckSize){
		bag = new LinkedListPT[buckSize];
		for(int a=0;a<buckSize;a++)
			bag[a] = new LinkedListPT();
			
		this.size = 0;
		
	}
	
	public boolean isEmpty(){
		return (size()==0);
	}
	
	public int size(){
		return size;
	}
	
	public boolean add(Object item){
		try{
			bag[hash(item)].add(0, item);
		}
		catch(Exception e){
			return false;
		}
		size++;
		return true;
	}
	
	public Object remove(Object item){
		
		int hCode = hash(item), index = 0;
		
		ListIterator iterator = bag[hash(item)].iterator();
		
		while(iterator.hasNext()){
			if(iterator.next().equals(item)){
				size --;
				return bag[hash(item)].remove(index);
			}
			else
				index++;
		}
		throw (new IllegalStateException("item is not in the bag."));
		
	}
	
	public boolean contains(Object item){
		return bag[hash(item)].contains(item);
	}
	
	public int count(Object item){
		int count = 0;
		ListIterator iterator = bag[hash(item)].iterator();
		while(iterator.hasNext()){
			if(iterator.next().equals(item))
				count++;
		}
		return count;
	}
	
	public ListIterator iterator(){
		ListPT tmp = new LinkedListPT();
		for(int a=0;a<bag.length;a++){
			ListIterator iter = bag[a].iterator();
			while(iter.hasNext())
				tmp.add(tmp.size(),iter.next());
		}
		
		return tmp.iterator();
	}
	public String toString(){
		if(size() == 0)
			return "[]";
			ListIterator iterator = iterator();
		String out = "[";
		for(int a=0,b=0;a<bag.length;a++){
			for(;b<size()-1;b++){
				out+=iterator.next()+", ";	
			}
		}
		out += iterator.next()+"]";
		
		return out;
	}

	
	
	private int hash(Object data){
		return (int)(hashCode(data)%bag.length);
	}
	
	public long hashCode(Object data){
		String str = data.toString();
		long total=0;
		int div = (int)Math.ceil((str.length()+1)/2);
		for(int a=0;a<str.length();){
			String tmp = "";
			for(int b=0;b<2&&a<str.length();b++)
				tmp += ((int)str.charAt(a++));
			
			total+=(Integer.parseInt(tmp)*7);
		}
		return (int)(total/div*7);
	}

	
}