
public class SortableArrayListWithSelectionSort<T extends  Comparable<T> > extends SortableArrayList<T>{

	public SortableArrayListWithSelectionSort(int maxSize){// creates the list
		super(maxSize);
	}
	protected void sortSubArray(T[] a, int lowIndex, int highIndex) {	
	 
		int maxValue=lowIndex;       // The lowIndex value is considered the maxValue 
		if(lowIndex<highIndex+1){      //Checks if lowIndex Value is 
										//less than HighIndex Value    		
			
			for(int n=maxValue;n<highIndex+1;n++){	// For loop iterates until maxValue reaches 
													//the highValue Index as it increases by 1   
		 		
		 		 if(a[n].compareTo(a[maxValue])>0){// if the value for loop value of n is greater than the maxValue  
		 			 maxValue=n;		// Assume the new maxValue as n   		 		 
		 			}
		}		
 			swap(a,lowIndex,maxValue);//  switch index values with lowIndex and maxValues

			sortSubArray(a,lowIndex+1,highIndex);// start over, recursively, with new lowIndex.  

		
		}
	}
	private void swap(T[] a, int i, int k) {// swap the assigned variables
		T temp=a[i];
		a[i]=a[k];
		a[k]= temp;
		
		
	}

	

}
