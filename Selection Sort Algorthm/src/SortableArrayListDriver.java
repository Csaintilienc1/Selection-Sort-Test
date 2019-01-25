/***********************************************************************
 * The class SortableArrayListDriver is a driver to test the subclasses
 * of SortableArrayList that implement different sorting algorithms
 * It generates a list of random integers, prints out the list, sorts
 * them, and prints the sorted list.
 * 
 * @author James Benham
 */


import java.util.Random;
import java.util.Iterator;

public class SortableArrayListDriver {
	
	public static void main(String[] args)
	{
	   	int length = Integer.parseInt(args[0]);
	   	int maxValue = 1000;
	   	
	   	SortableArrayListWithSelectionSort<Integer> integerList=new
	   			SortableArrayListWithSelectionSort<Integer>(10);
	   	
	   	// Create list of random values
	   	Random randomNumberGenerator = new Random();
	   	for(int i = 0; i < length; i++)
	   		integerList.append(randomNumberGenerator.nextInt(maxValue));
	   	
	   	// Print unsorted list
	   	System.out.println("The unsorted list:\n");
	   	Iterator<Integer> intIterator = integerList.getIterator();
	   	while(intIterator.hasNext())
	   		System.out.println(intIterator.next());
	   	
	   	// Sort and print sorted list
	   	integerList.sort();
	   	System.out.println("\nThe sorted list:\n");
	   	intIterator = integerList.getIterator();
	   	while(intIterator.hasNext())
	   		System.out.println(intIterator.next());
	   	
	} // main

} // SortableArrayListDriver
