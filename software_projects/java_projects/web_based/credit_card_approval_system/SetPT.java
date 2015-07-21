//SET INTERFACE
//BABA, FLORES, RAPANOT
import java.util.*;

public interface SetPT{
	
	//checks for set emptiness
	public boolean isEmpty(); 
	
	//returns set size
	public int size(); 
	
	//adds item to set
	public boolean add(Object item); 
		
	//removes item from set
	public Object remove(Object item);
	
	//checks if 'this' set contains item
	public boolean contains(Object item);
	
	//gets the union of 'this' set and Set set.
	public SetPT union(SetPT set);
	
	//gets the intersection of 'this' set and Set set.
	public SetPT intersection(SetPT set);
	
	//gets the difference of 'this' set and Set set.
	public SetPT difference(SetPT set);
	
	//checks if set is subset of 'this' set.
	public boolean isSubset(SetPT set);
	
	//returns the iterator of this set.
	public ListIterator iterator();
	
	
}