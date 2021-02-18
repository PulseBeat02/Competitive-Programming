package test_packages;

import java.util.*;

public class search { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int intArr[] = { 10, 20, 15, 22, 35 }; // unsorted
		
		// Basic linear search to find the index of number 15, return its array index, which is 2
		
		for(int i=0; i < intArr.length; i++)  {
			System.out.println(i);
			// break;  // quit the loop
		}
		
		//  other logic

	
	
	// Binary search
	Arrays.sort(intArr); // sort the array first 
	int ret = Arrays.binarySearch(intArr, 15); // 10 15 20 22 35
	
	System.out.println(ret + 1); // binary search, index 2

	}
	
}

