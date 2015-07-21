import java.util.*;                                //Contains exception classes
import java.io.Serializable;                       //The Serializable interface

public class LinkedListPT implements ListPT, Serializable {

   private TwoWayNode head;                                     //Sentinel node
   private int size;                              //Number of items in the list
   private int modCount;           //Number of times the list has been modified

   // Constructor -- sets up circular linked structure with a dummy header node
   public LinkedListPT()
   {
      head = new TwoWayNode(null, null, null);
      head.next = head;
      head.previous = head; 
      size = 0;
      modCount = 0;
   }
   
   //Adds item to list at index
   public void add (int index, Object item)
   {
      if (item == null)
         throw new IllegalArgumentException ("Cannot insert null");
      if (index < 0 || index > size)
         throw new IndexOutOfBoundsException 
         ("Index " + index + " out of range");

      //Locate node before insertion point   
      TwoWayNode nodeBefore = getNode (index - 1);

      //Create new node and link it into the list
      TwoWayNode newNode = new TwoWayNode (item, nodeBefore, 
		                                     nodeBefore.next);
      nodeBefore.next.previous = newNode;
      nodeBefore.next = newNode;

      size++;
      modCount++;
   }
   
   public boolean contains (Object item){
      // Traverse the links looking for item
      // and return true if it is found
      TwoWayNode probe = head.next;
      while (probe != head)
         if (item.equals (probe.value)) 
            return true;
         else
            probe = probe.next;

        // Item not found so return false
        return false;
    }
   public boolean isEmpty(){
      return size() == 0;
   }
   
   public boolean isFull(){
      return false;
   }
   
   public Object get(int index){
      if (index < 0 || index >= size)
         throw new IllegalArgumentException ("Index " + index + 
			                                    " out of range");
      return getNode(index).value;
   }
   
   // Helper method that returns the ith node
   private TwoWayNode getNode (int i){
      TwoWayNode ithNode = head;
      for (int k = -1; k < i; k++)
         ithNode = ithNode.next;
      return ithNode;
   }         

   //THIS WILL BE IMPLEMENTED LATER
   public ListIterator iterator(){   //Returns an iterator for this collection
      return new ListIter();
   }


   // OTHER ListPT METHODS go here...
   
   public Object remove(int index){
      if (index < 0 || index >= size)
         throw new IllegalArgumentException ("Index " + index + " out of range");

   	TwoWayNode rem = getNode(index);

   	(rem.previous).next = rem.next;
   	(rem.next).previous = rem.previous;
   	
   	size--;
   	modCount++;
   	
   	return rem.value;
   }
   public Object set(int index, Object item){
      if (index < 0 || index >= size)
         throw new IllegalArgumentException ("Index " + index + " out of range");
      if (item == null)
         throw new IllegalArgumentException("Cannot insert null");
         
   	TwoWayNode rep = getNode(index);
		Object val = rep.value;
		
		rep.value = item;
   	
   	return val;
   }
   
   public Object peek(){
      if (isEmpty())
         throw new IllegalStateException ("Peeking at an empty list");
      return getNode(0).value;
   }

    public int size(){
    	return size;
    }

   public String toString(){
      String str = "";

      // Traverse the array concatenating the string
      // representations of the items
      for (TwoWayNode probe = head.next; probe != head; probe = probe.next)
         str += probe.value.toString() + " ";

      return str;
   }

//================= inner class TwoWayNode ========================

   private class TwoWayNode extends Object implements Serializable{

      private Object     value;    //Value stored in this node
      private TwoWayNode next;     //Reference to next node
      private TwoWayNode previous; //Reference to previous node
    
      private TwoWayNode(){
         value = null;
         previous = null;
         next = null;
      }

      private TwoWayNode(Object value){
         this.value = value;
         previous = null;
         next = null;
      }

      private TwoWayNode(Object value, 
                         TwoWayNode previous, 
                         TwoWayNode next){
         this.value = value;
         this.previous = previous;
         this.next = next;
      }
      public String toString(){
      	return value.toString();
      }
   }

 //================= inner class ListIter to go here later  ======================== 

   private class ListIter implements ListIterator, Serializable{
    
      private int curPos;     
        //Current position indicator with respect to the backing list
        //Equals i if immediately before the item at index i
        //Equals size() if after the last item

      private int lastItemPos;                    
        //Equals index of last item returned by next or previous 
        //Equals -1 initially and after add and remove 

      private int expectedModCount;        
        //This iterator's notion of modCount

      private ListIter()                                          //Constructor
      {
         curPos = 0;
         lastItemPos = -1;
         expectedModCount = modCount;
      }                                   
        
      // Methods for navigation
      
      public boolean hasNext()          //Returns true if there are items after 
      {                                                  //the current position
         return curPos < size;                
      }
      public int previousIndex(){
      	return curPos-1;
      }
      public int nextIndex(){
      	return curPos+1;
      }
        
      public boolean hasPrevious()     //Returns true if there are items before 
      {                                                  //the current position
         return curPos > 0;                     
      }
        
      public Object next(){                             //Returns the next item
         if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
         if (!hasNext())
            throw new NoSuchElementException("There are no more elements");   
                     
         lastItemPos = curPos;   //Remember the index of the last item returned
         curPos++;                               //Advance the current position
         return getNode(lastItemPos).value; 
      }
      
      public Object previous(){                     //Returns the previous item
         if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
         if (!hasPrevious())
            throw new NoSuchElementException("There are no more elements");   
                     
         lastItemPos = curPos - 1;        //Remember the index of the last item
                                                                     //returned
         curPos--;                         //Move the current position backward
         return getNode(lastItemPos).value; 
      }
     
      // Methods for modifications

      public void add(Object o)         //Adds object o at the current position
      {                           
         if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
         LinkedListPT.this.add(lastItemPos, o);        //Call the backing list's 
                                    //add method, which will increment modCount
         curPos++; 
         expectedModCount++;               //Increment expectedModCount as well
         lastItemPos = -1;      //Block remove and set until after a successful
                                                             //next or previous
      }

      public void remove()           //Removes the most recently retrieved item
      { 
         if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
         if (lastItemPos == -1)
            throw new IllegalStateException 
            ("There is no established item to remove.");   

         LinkedListPT.this.remove(lastItemPos);        //Call the backing list's 
                                 //remove method, which will increment modCount
         expectedModCount++;               //Increment expectedModCount as well
         if (lastItemPos < curPos)       //If the item removed was obtained via
            curPos--;               //next, then move the current position back
         lastItemPos = -1;      //Block remove and set until after a successful
                                                             //next or previous
      }

      public void set(Object o)     //Replaces the most recently retrieved item
      { 
         if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
         if (lastItemPos == -1)
            throw new IllegalStateException 
            ("There is no established item to set.");   
         LinkedListPT.this.set(lastItemPos, o);        //Call the backing list's
                                                                   //set method 
         //Do not change modCount, expectedModCount, lastItemPos, curPos
      }
      
      public Object peekPrevious(){
         if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
         if(hasPrevious())
         		throw new NullPointerException("Previous item is null.");
         return getNode(curPos-1).value; 
      }
      public Object peekNext(){
         if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
         if(hasNext())
         		throw new NullPointerException("Next item is null.");
         return getNode(curPos+1).value; 
      }
   }

}  
