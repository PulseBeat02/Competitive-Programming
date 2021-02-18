package year_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class taming {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("taming.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] log = new int[N];
		int[] breakouts = new int[N];
		breakouts[0] = 1;
		
		// -1 - No Breakout
		// 0 - Don't Know
		// 1 - Breakout
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < log.length; i++) {
			
			log[i] = Integer.parseInt(st.nextToken());
			
		}
		
		br.close();
		
		boolean isBroken = false;
			
		for (int i = 1; i < log.length; i++) {
			
			if (log[i] <= log[i - 1] && log[i] > 0 && log[i - 1] > 0) {
				
				isBroken = true;
				break;
				
			}
			
			if (log[i] > 0) {
				
				breakouts[i - log[i]] = 1;
				
				for (int j = i - log[i] + 1; j <= i; j++) {
					
					breakouts[j] = -1;
					
				}
				 
			} else if (log[i] == 0) {
				
				breakouts[i] = 1;
				
			}
	
		}
		
		int min = 0;
		int max = 0;
		
		for (int i = 0; i < breakouts.length; i++) {
			
			if (breakouts[i] == 1) {
				
				min++;
				max++;
				
			} else if (breakouts[i] == 0) {
				
				max++;
				
			}
			
		}
		
		System.out.println(min + " " + max);
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out"))); 
		
		if (isBroken) {
			
			pw.println("-1");
			
		} else {
			
			pw.println(min + " " + max);
			
		}
		
		pw.close();
		
	}

}
