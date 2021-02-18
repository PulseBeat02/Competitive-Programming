package year_2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class diamond {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] allDiamonds = new int[N];

		for (int i = 0; i < allDiamonds.length; i++) {

			st = new StringTokenizer(br.readLine());
			allDiamonds[i] = Integer.parseInt(st.nextToken());

		}

		br.close();

		int ans = 0;
		
		for (int i = 0; i < N; i++) {

			int amt = 0;
			
			for (int j = 0; j < N; j++) {

				if (allDiamonds[j] >= allDiamonds[i] && allDiamonds[j] <= allDiamonds[i] + K) {
					
					amt++;
					
				}
				
			}

			if (amt > ans) {
				
				ans = amt;
				
			}
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		pw.println(ans);
		pw.close();

	}
	
}
