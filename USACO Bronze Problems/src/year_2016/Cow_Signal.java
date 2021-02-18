package year_2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cow_Signal {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		// M x N size Paper
		// K times Bigger
		//
		// Input:
		// 5 4 2
		// XXX.
		// X..X
		// XXX.
		// X..X
		// XXX.
		//
		// Output:
		// XXXXXX..
		// XXXXXX..
		// XX....XX
		// XX....XX
		// XXXXXX..
		// XXXXXX..
		// XX....XX
		// XX....XX
		// XXXXXX..
		// XXXXXX..
		//
		// Algorithm:
		// String Tokenizer / Buffered Reader
		// Loop to kX characters in length
		// Loop to kX characters in height
		
		BufferedReader br = new BufferedReader(new FileReader("cowsignal.in")); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\cowsignal.in
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out"))); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\cowsignal.out
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int height = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		int scaleFactor = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < height; i++) {
				
				String currentline = br.readLine();
			
				for (int g = 0; g < scaleFactor; g++) {
					
					for (int j = 0; j < length; j++) {
				
						for (int c = 0; c < scaleFactor; c++) {
					
							pw.print(currentline.charAt(j));
					
						}
				
				
					}
			
					pw.println();

				}
			
		
		}
		
		pw.close();
		br.close();
			
	}
		
}
