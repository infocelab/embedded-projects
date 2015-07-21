//MAP INTERFACE
//BABA, FLORES, RAPANOT

import java.util.*;
public interface MapPT{
	
	//checks for map emptiness
	public boolean isEmpty();
	
	//gets map size
	public int size();
	
	//adds to data to map given with given key
	public boolean insert(Object key, Object data);
	
	//removes data with key 'key' from map
	public Object remove(Object key);
	
	//gets object with key 'key' from map
	public Object get(Object key);
	
	//checks the availability of 'key'
	public boolean containsKey(Object key);
	
	//checks for occurence of item 'data'
	public boolean contains(Object data);
	
	//returns iterator of all keys
	public ListIterator keyIterator();
	
	//returns iterator of all objects
	public ListIterator dataIterator();
	
}