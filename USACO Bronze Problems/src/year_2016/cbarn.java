package year_2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class cbarn {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cbarn.in")); 
		
		// new InputStreamReader(System.in)

		// new FileReader("cowfind.in")

		int N = Integer.parseInt(br.readLine());

		int[] barn = new int[N];

		for (int i = 0; i < barn.length; i++) {

			barn[i] = Integer.parseInt(br.readLine());

		}

		br.close();

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			
			int sum = 0;
			int nCount = 0;
			int mult = 0;
			
			for (int room = i;; room++) {
				
				if (room == N) room = 0;
				if (nCount == N) break;
				
				sum += (mult * barn[room]);
				
				mult++;
				nCount++;
				
			}
			
			if (sum < min) min = sum;
			
		}

		PrintWriter pw = new PrintWriter(new File("cbarn.out"));
		pw.println(min);
		pw.close();

	}
}
