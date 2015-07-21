//CHAINED SET IMPLEMENTATION
//BABA, FLORES, RAPANOT

import java.util.*;
import java.io.*;

public class ChainedSet implements SetPT, Serializable {
	
	private ListPT[] set;
	private static final int DEFAULT_CHAIN_SIZE = 7;
	private int size;
	
	public ChainedSet(){
		this(DEFAULT_CHAIN_SIZE);
	}
	
	public ChainedSet(int size){
		set = new LinkedListPT[size];
		for(int a=0;a<size;a++)
			set[a] = new LinkedListPT();	
	}
	
	public boolean isEmpty(){
		return (size()==0);
	}
	
	public int size(){
		return size;
	}
	public boolean add(Object item){
		try{
			if(!contains(item)){
				int hCode = hash(item);
				set[hCode].add(set[hCode].size(),item);
				size++;
			}
		}
		catch(Exception e){
			return false;
		}
		return true;
	}
	
	
	public Object remove(Object item){
		int hCode = hash(item);
		ListIterator iterator = set[hCode].iterator();
		int ind = 0;
		while(iterator.hasNext()){
			Object obj = iterator.next();
			if(obj.equals(item)){
				size--;
				return set[hCode].remove(ind);
			}
			else
				ind++;
		}
		throw (new IllegalStateException("item is not in the bag."));
		
	}
	
	public boolean contains(Object item){
		int hCode = hash(item);
		return set[hCode].contains(item);
	}
	
	public ListIterator iterator(){
		ListPT tmp = new LinkedListPT();
		for(int a=0;a<set.length;a++){
			ListIterator iter = set[a].iterator();
			while(iter.hasNext())
				tmp.add(tmp.size(),iter.next());
		}
		return tmp.iterator();
	}
	
	public SetPT union(SetPT dSet){
		ListIterator iter = this.iterator();
		SetPT temp = new ChainedSet();
		while(iter.hasNext())
			temp.add(iter.next());
		
		iter = dSet.iterator();
		while(iter.hasNext())
			temp.add(iter.next());
			
		return temp;
	}
	
	//gets the intersection of 'this' set and Set set.
	public SetPT intersection(SetPT dSet){
		ListIterator iter = dSet.iterator();
		
		SetPT temp = new ChainedSet();
		
		while(iter.hasNext()){
			Object item = iter.next();
			if(contains(item))
				temp.add(item);
		}
		return temp;
	}
	
	//gets the difference of 'this' set and Set set.
	public SetPT difference(SetPT dSet){
		ListIterator iter = this.iterator();
		SetPT temp = new ChainedSet();
		while(iter.hasNext()){
			Object item = iter.next();
			if(!dSet.contains(item))
				temp.add(item);		 
		}
		return temp;
	}
	
	//checks if set is subset of 'this' set.
	public boolean isSubset(SetPT dSet) {
		ListIterator dSetIter = dSet.iterator();
		while(dSetIter.hasNext()){
			Object theItem = dSetIter.next();
			if(!contains(theItem))
				return false;
		}		
		return true;
	}
	
	public String toString(){
		if(size()==0)
			return "[]";
			
		ListIterator iter = iterator();
		String out = "[";
		for(int a=0;a<size()-1;a++)
			out+=iter.next()+", ";
			
		out+="" + iter.next() + "]";
		
		return out;
	}
	
	private int hash(Object data){
		return (int)(hashCode(data)%set.length);
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
	
	
	
	public ChainedSet sort(){
		Object[] obj = toArray();
		qsort(obj, 0, obj.length - 1);
		ChainedSet sortedSet = new ChainedSet(1);
		for(int a=0;a<obj.length;a++)
			sortedSet.add(obj[a]);
		return sortedSet;
	}
	
	public Object[] toArray(){
		Object[] objSet = new Object[size()];
		ListIterator iter = iterator();
		int ind = 0;
		while(iter.hasNext())
			objSet[ind++] = iter.next();
			
		return objSet;
	}
	private void qsort(Object[] array, int low, int high){
		if (low >= high)
			return;
		int p = partition(array, low, high);
		qsort(array, low, p);
		qsort(array, p + 1, high);
	}

	private int partition(Object[] a, int low, int high){
		Object pivot = a[low];
		int i = low - 1;
		int j = high + 1;
		while(i < j){
			i++;

			while(a[i].toString().compareTo(pivot)<0)
				i++;
			j--;
			
			while (a[j].toString().compareTo(pivot)>0)
				j--;
				
			if (i < j)
				swap(a, i, j);
		}
		return j;
	}

  private void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
  }//*/
}