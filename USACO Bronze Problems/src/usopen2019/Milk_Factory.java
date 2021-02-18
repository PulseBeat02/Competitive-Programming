package usopen2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Milk_Factory {
	
	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Computer Science Learning\\USACO Bronze Problems\\src\\US_OPEN\\factory.in")); // 
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Computer Science Learning\\USACO Bronze Problems\\src\\US_OPEN\\factory.out"))); // 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int result = -1;
		
		int [][] conveyers = new int [N][2]; // Make array
		boolean [] rowWorks = new boolean[N];
		
		for (int h = 0; h < N - 1; h++) {
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < conveyers[0].length; i++) {
				
				if (st.hasMoreTokens()) {
				
					conveyers[h][i] = Integer.parseInt(st.nextToken());
				
				}
				
				
			}

		}
		
		for (int c = 0; c < N; c++) {

			
			for (int d = 0; d < N; d++) {
				
				if (d == c) {
					
					rowWorks[d] = true;
					
				}
				
				else {
					
					rowWorks[d] = false;
				
				}
				
			}
			
			for (int e = 0; e < N; e++) {
				
				if (c + 1 == conveyers[e][1]) {
					
					rowWorks[c] = true;
				
					rowWorks[conveyers[e][0] - 1] = true; // -1
					
				}
				
			}

			boolean rc = true;
			
			for (int f = 0; f < N; f++) {

				if (!rowWorks[f]) {
					
					rc = false;
					break;
					
				}

			}
			
			if (rc) {
				
				result = c + 1;
				break;
				
			}
			
		}
		
		pw.println(result);
		
		br.close();
		pw.close();
		
		
		
	}
	
}
