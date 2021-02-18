package training_program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class transformations {
	
public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
	
		// Algorithm: Brute - Force
		// Buffered Reader / String Tokenizer
		// Get value of a side of the square
		// Make a 2 dimensional array for the array before.
		// Make a 2 dimensional array for the answeroutput
		// Make a loop to try to attempt each combination
		// Make a function that rotates the array (rotateArr) + (Arguments: int[][] arr, int degrees)
		// Make a function that reflects the array (reflectArr) + (Arguments: int[][] arr, boolean ref-or-3)
		// If made a move, move++;
		// Compare this new rotated or reflected array with the answer output.
		// Store all the possible outcomes in an integer array, and find the minimum.
		// pw.println(move);
		// br.close();
		// pw.close();
		
		BufferedReader br = new BufferedReader(new FileReader("input.in")); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\input.in
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.out"))); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\output.out
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int side = Integer.parseInt(st.nextToken());
		
		
		
		pw.println("Something Here");
		br.close();
		pw.close();

	}

}
