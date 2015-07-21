//CHAINED MAP IMPLEMENTATION
//BABA, FLORES, RAPANOT

import java.util.*;
import java.io.*;
public class ChainedMap implements MapPT, Serializable{
	
	private ListPT[][] keys;
	private ListPT[][] data;
	private int size;
	private final int BUCKET_SIZE = 97;
	private static final int DEFAULT_CHAIN_SIZE = 7;
	
	public ChainedMap(){
		this(DEFAULT_CHAIN_SIZE);
	}
	
	public ChainedMap(int size){
		keys = new LinkedListPT[size][BUCKET_SIZE];
		data = new LinkedListPT[size][BUCKET_SIZE];
		for(int a=0;a<size;a++)
			for(int b=0;b<BUCKET_SIZE;b++){
				keys[a][b] = new LinkedListPT();
				data[a][b] = new LinkedListPT();
			}
			
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	//gets map size
	public int size(){
		return size;
	}
	
	//adds to data to map given with given key
	public boolean insert(Object key, Object data){
		try{
			int hCde1 = firstHash(key), hCde2 = secondHash(key);
			this.keys[hCde1][hCde2].add(this.keys[hCde1][hCde2].size(),key);
			this.data[hCde1][hCde2].add(this.data[hCde1][hCde2].size(),data);
		}
		catch(Exception e){
			return false;
		}
		size++;
		return true;
	}
	
	
	//removes data with key 'key' from map
	public Object remove(Object key){
		int hCde1 = firstHash(key), hCde2 = secondHash(key);
		
		ListIterator keyIter = keys[hCde1][hCde2].iterator();
		ListIterator dtaIter = data[hCde1][hCde2].iterator();
		Object tmp = null;
		int ind = 0;
		while(keyIter.hasNext()){
			tmp = dtaIter.next();
			if(keyIter.next().equals(key)){
				keyIter.remove();
				dtaIter.remove();
				break;
			}
			ind++;
		}
		if(tmp.equals(null))
			throw new IllegalStateException("key does not exist");
		else{
			size--;
			return tmp;
		}
	}
	
	//gets object with key 'key' from map
	public Object get(Object key){
		int hCde1 = firstHash(key), hCde2 = secondHash(key);
		int index = 0;
		ListIterator iter = keys[hCde1][hCde2].iterator();
		for(int a=0;a<keys[hCde1][hCde2].size();a++){
			if(iter.next().equals(key)){
				return data[hCde1][hCde2].get(index);
			}
		}
		throw new IllegalStateException("key does not exist");
	}
	
	//checks the availability of 'key'
	public boolean containsKey(Object key){
		int hCde1 = firstHash(key), hCde2 = secondHash(key);
		return keys[hCde1][hCde2].contains(key);
	}
	
	//checks for occurence of item 'data'
	public boolean contains(Object data){
		ListIterator iter = dataIterator();
		while(iter.hasNext()){
			if(iter.next().equals(data))
				return true;
		}
		return false;
	}
	
	//returns iterator of all keys
	public ListIterator keyIterator(){
		ListPT tmp = new LinkedListPT();
		
		for(int a=0;a<keys.length;a++){
			for(int b=0;b<keys[a].length;b++){
				ListIterator iter = keys[a][b].iterator();
				while(iter.hasNext())
					tmp.add(tmp.size(),iter.next());
			}
		}
		return tmp.iterator();
	}
	
	//returns iterator of all objects
	public ListIterator dataIterator(){
		ListPT tmp = new LinkedListPT();
		for(int a=0;a<data.length;a++){
			for(int b=0;b<data[a].length;b++){
				ListIterator iter = data[a][b].iterator();
				while(iter.hasNext())
					tmp.add(tmp.size(),iter.next());
			}
		}
		return tmp.iterator();
	}
	public String toString(){
		if(size()==0)
			return "[]";
		
		ListIterator dataIter = dataIterator();
		ListIterator keysIter = keyIterator();
		String out = "[";
		for(int a=0;a<size()-1;a++)
			out+=keysIter.next()+": "+dataIter.next()+", ";
			
		out+=keysIter.next()+": "+dataIter.next()+']';
		
		return out;
	}
	
	
	private int firstHash(Object data){
		return (int)(hashCode(data)%this.data.length);
	}
	private int secondHash(Object data){
		return (int)(hashCode(data)%97);
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