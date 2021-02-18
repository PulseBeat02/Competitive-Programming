package year_2018;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class outofplace {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] height = new int[N];
		int[] sorted = new int[N];
		
		for(int i = 0; i < height.length; i++) {
			
			height[i] = Integer.parseInt(br.readLine());
			sorted[i] = height[i];
			
		}
		
		br.close();
		
		Arrays.sort(sorted);
		
		int swaps = -1;
		for (int a = 0; a < height.length; a++) {
			if(sorted[a] != height[a]) {
				swaps++;
			}
		}
		swaps = Math.max(0, swaps);
		
		PrintWriter pw = new PrintWriter(new File("outofplace.out"));
		pw.println(swaps);
		pw.close();
		
	}

}
