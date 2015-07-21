//BAG INTERFACE
//BABA, FLORES, RAPANOT
import java.util.*;

public interface BagPT{
	
	//checks for bag emptiness
	public boolean isEmpty();
	
	//gets number of items in the bag
	public int size();
	
	//adds an item to the bag
	public boolean add(Object item);
	
	//removes an item from the bag
	public Object remove(Object item);
	
	//checks if 'item' is present in the bag
	public boolean contains(Object item);
	
	//gets count occurences of 'item'
	public int count(Object item);
	
	//gets bag iterator
	public ListIterator iterator();
}