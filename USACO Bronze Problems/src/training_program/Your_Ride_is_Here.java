/*
ID: brandonli
LANG: JAVA
TASK: ride
*/

package training_program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class ride {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		// Algorithm:
		// Buffered Reader/String Tokenizer
		// Make an array. Fill it with letter values. (A = 1, B = 2) Do this by using this "int value = (int) Character.MAX_VALUE;"
		// Get Strings for the input in the problem.
		// Convert them to char array
		// Use a for loop to retrieve the integer value for each letter by accessing it in the array.
		// Multiply those values together. (Multipliedval1, Multipliedval2)
		// Find modulo (47 of each of the numbers)
		// if (Multipliedval1 == Multipliedval2) {
		//
		//	  pw.println("Go");
		//
	    // } else {
		//
		//    pw.println("Stay");
		//
		// }

		
		BufferedReader br = new BufferedReader(new FileReader("ride.in")); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\input.in
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out"))); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\output.out
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		String line1 = st.nextToken();
		String line2 = st1.nextToken();
		
		char[] line1f = line1.toCharArray();
		char[] line2f = line2.toCharArray();
		
		// int [] charnum1f = new int[6];
		// int [] charnum2f = new int[6];
		
		int product1f = 1;
		int product2f = 1;
		
		for (int i = 0; i < line1f.length; i++) {
			
			//charnum[i] = (int) Character.MAX_VALUE;
			
			product1f *= (line1f[i] - 'A' + 1);
			
		}
		
		for (int i = 0; i < line2f.length; i++) {
			
			//charnum[i] = (int) Character.MAX_VALUE;
			
			product2f *= (line2f[i] - 'A' + 1);
			
		}
		
		int mod1 = product1f % 47;
		int mod2 = product2f % 47;
		
		if (mod1 == mod2) {
			
			pw.println("GO");
			
		}
		
		else {
			
			pw.println("STAY");
			
		}
		
		br.close();
		pw.close();

	}

}
