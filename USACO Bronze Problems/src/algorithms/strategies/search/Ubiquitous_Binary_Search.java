package algorithms.strategies.search;

public class Ubiquitous_Binary_Search {
	
	// largest value <= key 
	// Invariant: A[l] <= key and A[r] > key 
	// Boundary: |r - l| = 1 
	// Input: A[l .... r-1] 
	// Precondition: A[l] <= key <= A[r] 
	int Floor(int A[], int l, int r, int key) 
	{ 
	    int m; 
	  
	    while( r - l > 1 ) 
	    { 
	        m = l + (r - l)/2; 
	  
	        if( A[m] <= key ) 
	            l = m; 
	        else
	            r = m; 
	    } 
	  
	    return A[l]; 
	} 
	  
	// Initial call 
	int Floor(int A[], int size, int key) 
	{ 
	    // Add error checking if key < A[0] 
	    if( key < A[0] ) 
	        return -1; 
	  
	    // Observe boundaries 
	    return Floor(A, 0, size, key); 
	} 

}
