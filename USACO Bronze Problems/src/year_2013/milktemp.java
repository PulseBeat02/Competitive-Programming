package year_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milktemp {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("milktemp.in") );
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		int N = Integer.parseInt(st.nextToken());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int Z = Integer.parseInt(st.nextToken());

		int[][] cows = new int[N][2];

		for (int i = 0; i < cows.length; i++) {

			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());

		}
		
		br.close();

		int minT = getMin(cows);
		int maxT = getMax(cows);
		
		int max = 0;

		for (int temp = minT; temp < maxT; temp++) {

			int milk = 0;

			for (int i = 0; i < cows.length; i++) {
				
				if (temp >= cows[i][0] && temp <= cows[i][1]) {
					
					milk += Y;
					
				} else if (temp < cows[i][0]) {
					
					milk += X;
					
				} else {
					
					milk += Z;
					
				}

			}
			
			if (milk > max) {
				
				max = milk;
				
			}

		}
		
		PrintWriter pw = new PrintWriter(new File("milktemp.out"));
		pw.println(max);
		pw.close();

	}

	private static int getMin(int[][] cows) {

		int min = 100;

		for (int i = 0; i < cows.length; i++) {

			if (cows[i][0] < min) {

				min = cows[i][0];

			}

		}

		return min;

	}

	private static int getMax(int[][] cows) {

		int max = 0;

		for (int i = 0; i < cows.length; i++) {

			if (cows[i][1] > max) {

				max = cows[i][1];

			}

		}

		return max;

	}

}
