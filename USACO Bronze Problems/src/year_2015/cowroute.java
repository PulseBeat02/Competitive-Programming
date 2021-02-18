package year_2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cowroute {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("cowroute.in")
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> costs = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			
			boolean start = false; // Make sure start is before end
			boolean end = false;
			
			int indexStart = 0;
			int indexEnd = 0;
			
			st = new StringTokenizer(br.readLine());
			
			int cost = Integer.parseInt(st.nextToken());
			int stops = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < stops; j++) {
				
				int city = Integer.parseInt(st.nextToken());
				
				if (city == A) {
					
					start = true;
					indexStart = j;
					
				}
				
				if (city == B) {
					
					end = true;
					indexEnd = j;
					
				}
				
			}
			
			if (start && end && indexStart <= indexEnd) {
				
				costs.add(cost);
				
			}
			
		}
		
		br.close();
		
		int minimum = 1001;
		
		for (int i = 0; i < costs.size(); i++) {
			
			if (costs.size() == 0) {
				
				minimum = -1;
				break;
				
			}
			
			else {
				
				if (costs.get(i) < minimum) {
					
					minimum = costs.get(i);
					
				}
				
			}
			
		}
		
		PrintWriter pw = new PrintWriter(new File("cowroute.out"));
		//pw.println(minimum);
		System.out.println(minimum);
		pw.close();
		
	}

}







