package year_2011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class haybales {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2011\\haybales.in")); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2011\\haybales.in
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2011\\haybales.out"))); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2011\\haybales.out
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int rows = Integer.parseInt(st.nextToken());
		int [] input = new int[rows + 1];
		int moves = 0;
		int tempVar;
		
		for (int i = 0; i < input.length; i++) {
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			input[i] = Integer.parseInt(st1.nextToken()); // Fills Array
			
		}
		
		 for (int i = 0; i < input.length - 1; i++) {
			 
		        // each iteration i you would need to go over a smaller array, so you set j = i each time
			 
		        for (int j = i; j < input.length - 1; j++) {
		        	
		            // checking if input[i] is greater than input[j + 1] instead of smaller than
		        	
		            if (input[i] > input[j + 1]) {
		            	
		                tempVar = input [j + 1];
		                input [j + 1]= input [i];
		                input [i] = tempVar;
		                
		            }
		            
		        }
		        
		        moves++;
		        
		    } 
		 
		 pw.println(moves);
		
		br.close();
		pw.close();
		

	}

}
