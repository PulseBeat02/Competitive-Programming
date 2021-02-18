package usopen2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class buckets {
	
	public static void main(String[] args) throws IOException { 
		
		BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
		
		int[] B = {0, 0};
		int[] L = {0, 0};
		int[] R = {0, 0};
		
		for (int i = 0; i < 10; i++) {
			
			String line = br.readLine();
			
			for (int j = 0; j < line.length(); j++) {
				
				if (line.charAt(j) == 'B') {B[0] = i; B[1] = j;}
				if (line.charAt(j) == 'L') {L[0] = i; L[1] = j;}
				if (line.charAt(j) == 'R') {R[0] = i; R[1] = j;}
				
			}
			
		}
		
		br.close();
		
		int xDiff = Math.abs(L[0] - B[0]);
		int yDiff = Math.abs(L[1] - B[1]) - 1;
		
		PrintWriter pw = new PrintWriter(new File("buckets.out"));
		
		if (isSpecial(R, B, L)) {
			
			pw.println(xDiff + yDiff + 2);
			
		}
		
		else {
			
			pw.println(xDiff + yDiff);
			
		}
		
		
		pw.close();
		
	}
	
	static boolean isSpecial(int[] R, int[] B, int[] L) {
		
		  int barnrock = Math.abs(B[0] - R[0]) + Math.abs(B[1] - R[1]);
		  int barnlake = Math.abs(B[0] - L[0]) + Math.abs(B[1] - L[1]);
		  int rocklake = Math.abs(R[0] - L[0]) + Math.abs(R[1] - L[1]);
		
		return (B[0]==L[0] || B[1]==L[1]) && barnlake == barnrock + rocklake;
		
	}

}








