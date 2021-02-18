package year_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lifeguards {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] shifts = new int[N][2];
		
		for (int i = 0; i < shifts.length; i++) {
			
			st = new StringTokenizer(br.readLine());
			shifts[i][0] = Integer.parseInt(st.nextToken());
			shifts[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		int maxTime = 0;
		
		for (int currentLifeGuard = 0; currentLifeGuard < shifts.length; currentLifeGuard++) {
			
			int totalTime = 0;
			
			
			for (int i = 0; i < shifts.length; i++) {
				
				if (i != currentLifeGuard) {
					
					totalTime += (shifts[i][1] - shifts[i][0]);
					
				}
				
			}
			
			if (totalTime > maxTime) {
				
				maxTime = totalTime;
				
			}
			
			
		}
		
		System.out.println(maxTime);
		
	}

}
