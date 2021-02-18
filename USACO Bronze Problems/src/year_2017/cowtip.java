package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class cowtip {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
		int N = Integer.parseInt(br.readLine());

		boolean[][] values = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			
			char[] modes = br.readLine().replaceAll("\\s","").toCharArray();
			
			for (int j = 0; j < modes.length; j++) {
				
				if (modes[j] == '1') {
					
					values[i][j] = true;
					
				}
				
			}
			
		}
		
		br.close();
		
		int flips = 0;
		
		for (int i = values.length - 1; i >= 0; i--) {
			
			for (int j = values[i].length - 1; j >= 0; j--) {
				
				if (allFlipped(values)) break;
				
				if (values[i][j]) {
					
					// Flip from (0, 0) to (i, j)
					
					flips++;
				
					for (int a = 0; a <= i; a++) {
						
						for (int b = 0; b <= j; b++) {
							
							values[a][b] = !values[a][b];
							
						}
						
					}
					
				}
				
			}
			
		}
		
		PrintWriter pw = new PrintWriter(new File("cowtip.out"));
		pw.println(flips);
		pw.close();

	}
	
	public static boolean allFlipped(boolean[][] array) {
		
		for (int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array[i].length; j++) {
				
				if (array[i][j]) return false;
				
			}
			
		}
		
		return true;
		
	}

}