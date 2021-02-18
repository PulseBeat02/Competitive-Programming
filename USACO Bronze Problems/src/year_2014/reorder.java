package year_2014;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class reorder {
	
	static int swapcnt = 0;
	static int cowcnt = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("reorder.in"));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cows = new int[N];
		int[] target = new int[N];
		
		for (int i = 0; i < cows.length; i++) {
			
			cows[i] = Integer.parseInt(br.readLine());
			
		}
		
		for (int i = 0; i < target.length; i++) {
			
			target[i] = Integer.parseInt(br.readLine());
			
		}
		
		br.close();
		
		PrintWriter pw = new PrintWriter(new File("reorder.out"));
		
		cyclicshift(cows, target);
		
		if (swapcnt == 0) {
			
			cowcnt = -2;
			
		} 
		
		cowcnt++;
			
		pw.println(swapcnt + " " + cowcnt);
	
		pw.close();

		
	}

	private static void cyclicshift(int[] cows, int[] target) {

		for (int i = 0; i < cows.length; i ++) {
			
			int lcowcnt = 0;
			
			while (cows[i] != target[i]) {
				// find the cows[i] in target location
				int index = -1;
				
				for (int j = 0; j <target.length; j++) {
					if (cows[i] == target[j]) {
						index = j;
					}
				}
				
				// swap 
				int tmp = cows[index];
				cows[index] = cows[i];
				cows[i] = tmp;
				lcowcnt ++;
			}
			if (lcowcnt != 0) {
				swapcnt ++;
				if (lcowcnt > cowcnt) {
					
					cowcnt = lcowcnt;
					
				}
				cyclicshift(cows, target);
			}
			
		}
		
		
	}

}
