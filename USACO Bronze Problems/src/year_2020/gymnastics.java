package year_2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class gymnastics {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("gymnastics.in")); 
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] log = new int[K][N];

		for (int i = 0; i < log.length; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {

				log[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		
		br.close();

		int count = 0;

		for (int i = 0; i < N; i++) {

			for (int j = i + 1; j < N; j++) {
				
				if (isConsistant(i + 1, j + 1, log)) {
					
					count++;
					
				}

			}

		}

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		pw.println(count);
		pw.close();

	}

	public static boolean isConsistant(int a, int b, int[][] log) {

		int direction = 0;

		// 0 - a = b
		// 1 - a > b
		// 2 - a < b

		for (int i = 0; i < log.length; i++) {

			int foundA = 0;
			int foundB = 0;

			for (int k = 0; k < log[i].length; k++) {

				if (log[i][k] == a) {

					foundA = k;

				} else if (log[i][k] == b) {

					foundB = k;

				}

			}

			if (i == 0) {
				if (foundA > foundB) {

					direction = 1;

				} else if (foundA < foundB) {

					direction = 2;

				}

			} else {
				
				if (direction == 1) {
					
					if (foundA > foundB) {
						
						continue;
						
					} else return false;
					
				} else if (direction == 2) {
					
					if (foundA < foundB) {
						
						continue;
						
					} else return false;
					
				} else {
					
					return false;
					
				}
				
			}

		}
		
		return true;

	}

}
