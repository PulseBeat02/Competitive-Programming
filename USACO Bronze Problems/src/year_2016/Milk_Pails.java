package year_2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Milk_Pails {
	
	/*					  Algorithm:
	 *  ----------------------------------------------
	 *  
	 *  1) BufferedReader
	 *  2) PrintWriter
	 *  3) StringTokenizer
	 *  4) Get elements using StringTokenizer class. Variable names: smallest, largest, goal.
	 *  5) Get maximum buckets you can put just by using one bucket.
	 *     For Example: In the sample input, you can fit at most 3 large buckets (25 * 3), and at most
	 *     small buckets (4 * 17). Variable names: maxBuckets, minBuckets
	 *  6) Make an ArrayList called answers
	 *  6) Make a loop to first loop up to maxBucket (loop through maxBuckets first) {var i}
	 *  7) Make a loop inside the first loop that loops up through minBucket. (loop through minBuckets next) {var j}
	 *  8) In the loop, make an if conditional that does the following:
	 *     if (i * largest) + (j * smallest) < goal		
	 *     ====>		
	 *     int possibleAnswer = (i * smallest) + (j * largest);
	 * 	   answers.add(possibleAnswer);
	 *  9) After the for loop, make a method called "max" which will input an ArrayList and find the maximum possible value
	 *     of the ArrayList, and return it.
	 *  10) Print out the maximum integer.
	 *  
	 *  Note: Brute Force Solution, so the complexity is around O(N).
	 * 
	 */
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("pails.in")); // new FileReader("pails.in")
		PrintWriter pw = new PrintWriter(new File("pails.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int smallest = Integer.parseInt(st.nextToken());
		int largest = Integer.parseInt(st.nextToken());
		
		int goal = Integer.parseInt(st.nextToken());
		
		br.close();
		
		int maxBuckets = (int) goal/largest;
		int minBuckets = (int) goal/smallest;
		
		int max = 0;
		
		for (int i = 0; i <= maxBuckets; i++) {
			
			for (int j = 0; j <= minBuckets; j++) {
				
				if ((i * largest) + (j * smallest) <= goal && (i * largest) + (j * smallest) > max) {
					
					max = (i * largest) + (j * smallest);

				}
				
			}
			
		}
		
		pw.println(max);
		pw.close();
		
	}

}
