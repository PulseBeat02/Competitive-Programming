package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class crossroad {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("crossroad.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] log = new int[N][2];
		
		for (int i = 0; i < log.length; i++) {
			
			st = new StringTokenizer(br.readLine());
			log[i][0] = Integer.parseInt(st.nextToken());
			log[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		br.close();
		
		HashMap<Integer, Integer> current = new HashMap<>();
		
		int count = 0;
		
		for (int i = 0; i < log.length; i++) {
			
			if (!current.containsKey(log[i][0])) {
				
				current.put(log[i][0], log[i][1]);
				
			}
			
			else {
				
				if (current.get(log[i][0]) != log[i][1]) {
					
					current.put(log[i][0], log[i][1]);
					count++;
					
				}
				
			}
			
		}
		
		PrintWriter pw = new PrintWriter(new File("crossroad.out"));
		pw.println(count);
		pw.close();
		
	}

}
