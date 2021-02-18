package year_2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class art {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("art.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] canvas = new int[N][N]; // Default value of int is 0
		
		for (int i = 0; i < canvas.length; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < canvas[i].length; j++) {
				
				canvas[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
		}
		
		br.close();
		
		
				
	}
	
	
	

}







