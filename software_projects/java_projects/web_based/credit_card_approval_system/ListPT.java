import java.util.*;

public interface ListPT {

   public void add (int index, Object item);                                           

   public int size();
   
   public boolean isEmpty();
   
   public boolean isFull();
   
   public Object peek();
 
   public boolean contains (Object item);

   public String toString();

   public Object get(int index);

   public Object set(int index, Object newItem);

   public Object remove(int index);

   public ListIterator iterator();

}



