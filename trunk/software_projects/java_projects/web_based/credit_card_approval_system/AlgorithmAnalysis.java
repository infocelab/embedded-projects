import java.util.*;

public class AlgorithmAnalysis {

    public static long comparisons = 0,
                       exchanges = 0,
                       runningTime = 0;

    ///////////////// SEARCHING ALGORITHMS //////////////////

    //---------- LINEAR SEARCH -----------//
    public static int linearSearch(int target, int[] array) {
        comparisons = 0;
        int result = -1;
        Date d1 = new Date();
        for (int i=0; i<array.length; i++) {
                comparisons++;
                if (array[i] == target) {
                    result = i;
                    break;
                }
                    
        }
        Date d2 = new Date();
        runningTime = d2.getTime() - d1.getTime();
        return result;
    }

    //---------- BINARY SEARCH -----------//
    public static int binarySearch(int target, int[] array) {
        comparisons = 0;
        int low = 0;
        int high = array.length - 1; 
        int result = -1;
        Date d1 = new Date();
        while ( low <= high ) {
            int middle = (low + high) / 2;
            comparisons++;
            if (array[middle] == target) {
                    result = middle;
                    break;
            }
            else if (array[middle] < target)
                low = middle + 1;
            else 
                high = middle - 1;
                    
        }
        Date d2 = new Date();
        runningTime = d2.getTime() - d1.getTime();
        return result;
    }




    ///////////////// SORTING ALGORITHMS //////////////////
    
    //---------- SELECTION SORT -----------//
    public static void selectionSort(int[] array) {
        comparisons = exchanges = 0;
        Date d1 = new Date();
        for (int i=0; i<array.length-1; i++) {
            int minIndex= i;
            for (int j = i + 1; j < array.length; j++) {
                comparisons++;
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            if (minIndex != i) {
            	exchanges++;
                swap(array, minIndex, i);
        	}
        }
        Date d2 = new Date();
        runningTime = d2.getTime() - d1.getTime();
    }

    //---------- BUBBLE SORT -----------//
    public static void bubbleSort(int[] array) {
        comparisons = exchanges = 0;
        Date d1 = new Date();
        for (int i=0; i<array.length-1; i++) 
            for (int j = 0; j < array.length-i-1; j++) {
                comparisons++;
                if (array[j] > array[j+1]) {
                    exchanges++;
                    swap(array, j, j+1);
                }
            } 
        Date d2 = new Date();
        runningTime = d2.getTime() - d1.getTime();       
    }


    //---------- IMPROVED BUBBLE SORT ----------- //
    public static void improvedBubbleSort(int[] array) {
        comparisons = exchanges = 0;
        Date d1 = new Date();
        boolean swapped = false;
        for (int i=0; i<array.length-1; i++) {    
            for (int j = 0; j < array.length-i-1; j++) {
                comparisons++;
                if (array[j] < array[j+1]) {
                    exchanges++;
                    swap(array, j, j+1);
                    swapped = true;   	
		}
		if (!swapped)
		   break;
            } 
        }
        Date d2 = new Date();
        runningTime = d2.getTime() - d1.getTime();       
    }

    //---------- INSERTION SORT ----------- //
    public static void insertionSort(int[] array) {
        comparisons = exchanges = 0;
        Date d1 = new Date();
        for (int i=1; i<array.length; i++) {
            int itemToInsert = array[i];
            int j = i - 1;
            while ( j>=0 ) {
                comparisons++;
                if (itemToInsert < array[j]) {
                   exchanges++; 
                   array[j+1] = array[j];
                   j--; 
                }
                else
                   break;
            } 
            array[j+1] = itemToInsert;
        } 
        Date d2 = new Date();
        runningTime = d2.getTime() - d1.getTime();       
    }
    
    
    //---------- MERGE SORT ----------- //
	public static void mergeSort(int[] array){
		exchanges = comparisons = 0;
		Date d1 = new Date();
		int[] temp = new int[array.length];
  	divide(array, temp, 0, array.length - 1);
	  Date d2 = new Date();
  	runningTime = d2.getTime() - d1.getTime();
	}


	private static void divide(int[] array, int[] sorted, int left, int right){
	  if (right > left){
  	  int mid = (right + left) / 2;
    	divide(array, sorted, left, mid);
	    divide(array, sorted, mid+1, right);
	
  	  sortAndMerge(array, sorted, left, mid+1, right);
  	}
 	
	}
	private static void sortAndMerge(int[] array, int[] sorted, int left, int mid, int right){
	  int tmpf2 = mid - 1;
  	int tmpf1 = left;
	  int size = right-left+1;

  	while (left <= tmpf2 && mid <= right){
     	comparisons++;
    	if (array[left] <= array[mid]){
      	sorted[tmpf1++] = array[left++];
      //	exchanges++;
      }
	    else{
  	    sorted[tmpf1++] = array[mid++];
  	    exchanges++;
  	  }
  	}

	  while (left <= tmpf2) 
  	  sorted[tmpf1++] = array[left++];
	  while (mid <= right)
  	  sorted[tmpf1++] = array[mid++];
	  for(int a=0;a<=size;a++,right--){
  		if(right<0)
	  		break;
  	  array[right] = sorted[right];
  	}
	}
	
	
    //---------- QUICK SORT ----------- //
	public static void quickSort(int[] array){
		exchanges = comparisons = 0;
		Date d1 = new Date();
		qsort(array, 0, array.length - 1);
		Date d2 = new Date();
		runningTime = d2.getTime()-d1.getTime();
	}
	
	private static void qsort(int[] array, int low, int high){
		if (low >= high)
			return;
		int p = partition(array, low, high);
		qsort(array, low, p);
		qsort(array, p + 1, high);
	}

	private static int partition(int[] a, int low, int high){
		int pivot = a[low];
		int i = low - 1;
		int j = high + 1;
		while(i < j){
			i++;

			comparisons++;
			while(a[i] < pivot){
				comparisons++;
				i++;
			}
			j--;
			
			comparisons++;
			while (a[j] > pivot){
			comparisons++;

				j--;
			}
				
//			comparisons++;
			if (i < j){
				swap(a, i, j);
				exchanges++;
			}
		}
		return j;
	}
    

    // exchange positions of two items in the array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



    // simulate an array - random generation
    public static int[] getRandomArray(int size, boolean duplicates) {
        int[] array = new int[size];
        int i = 0;
        while (i < size) {
            int value = 1 + (int) (Math.random() * size);
            if (duplicates || (linearSearch(value, array) == -1) ) {
                array[i] = value;
                i++;
            }
        }
        return array;
    }
    
    // display Array
    public static String toString(int[] array) {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += array[i] + " ";
            if (i != 0 && i % 10 == 0)
                str += "\n";
        }
        return str;
    }
 
}  //end class