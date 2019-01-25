/************************************************************************
 * SortableArrayList is a parameterized abstract class of Comparable 
 * objects with operations to build the list and an operation to sort 
 * the items in the list.  It is also possible to iterate through the
 *  items in the list.
 *  
 *  This class is an abstract class with an abstract method sortSubarray
 *  that needs to be made concrete in a subclass, using a sorting
 *  sorting algorithm
 * 
 * @author James Benham
 ***********************************************************************/


import java.util.Iterator;

public abstract class SortableArrayList<T extends Comparable<T>> {
	
	private T[] listItems;  // an array containing the items in the list
	private int itemCount;  // the number of items in the list
	private boolean isSorted;  // true iff the list is known to be sorted
	
	private static int DEFAULT_MAX_COUNT = 50;
	
	// Constructor with specified array size (maxCount)
	public SortableArrayList(int maxCount)
	{
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Comparable[maxCount];
		listItems = tempArray;
		itemCount = 0;
		isSorted = false;
	}
	
	// Constructor with default array size
	public SortableArrayList()
	{
		this(DEFAULT_MAX_COUNT);
	}
	
	/**
	 * Appends the specified item to the end of the list
	 */
	public void append(T item)
	{
		listItems[itemCount] = item;
		itemCount++;
		isSorted = false;
	}
	
	/** 
	 * Sorts the list
	 */
	public void sort() 
	{
		if (!isSorted){
			sortSubArray(listItems,0,itemCount-1);
			isSorted = true;
		}
	}
	
	// Sorts the specified sub-array a[lowIndex]...a[highIndex]
	protected abstract void sortSubArray(T[] a, int lowIndex, int highIndex);
	
	public class ListIterator implements  Iterator<T>{
		private int currentIndex;
		
		public ListIterator() 
		{
			currentIndex = 0;
		}
		
		public boolean hasNext() 
		{
			return currentIndex < itemCount;
		}
		
		public T next() {
			T returnValue = listItems[currentIndex];
			currentIndex++;
			return returnValue;
		}
	}
		
	public ListIterator getIterator()
	{
		return new ListIterator();
	}
}
