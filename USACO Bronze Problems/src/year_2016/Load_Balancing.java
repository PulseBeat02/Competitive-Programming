package year_2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Load_Balancing {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());

		int[] xLoc = new int[n];
		int[] yLoc = new int[n];

		for (int i = 0; i < n; i++) {

			st = new StringTokenizer(br.readLine());
			
			xLoc[i] = Integer.parseInt(st.nextToken());
			yLoc[i] = Integer.parseInt(st.nextToken());
			
		}
		
		br.close();

		int ans = n;

		for (int xIndex = 0; xIndex < n; xIndex++) {

			for (int yIndex = 0; yIndex < n; yIndex++) {

				int xDiv = xLoc[xIndex] + 1;
				int yDiv = yLoc[yIndex] + 1;
				
				int upperLeft = 0;
				int upperRight = 0;
				int lowerLeft = 0;
				int lowerRight = 0;

				for (int i = 0; i < n; i++) {
					if (xLoc[i] < xDiv && yLoc[i] < yDiv) {
						lowerLeft++;
					}
					if (xLoc[i] < xDiv && yLoc[i] > yDiv) {
						upperLeft++;
					}
					if (xLoc[i] > xDiv && yLoc[i] < yDiv) {
						lowerRight++;
					}
					if (xLoc[i] > xDiv && yLoc[i] > yDiv) {
						upperRight++;
					}
				}

				int worstRegion = 0;
				if (upperLeft > worstRegion) {
					worstRegion = upperLeft;
				}
				if (upperRight > worstRegion) {
					worstRegion = upperRight;
				}
				if (lowerLeft > worstRegion) {
					worstRegion = lowerLeft;
				}
				if (lowerRight > worstRegion) {
					worstRegion = lowerRight;
				}

				if (worstRegion < ans) {
					ans = worstRegion;
				}
			}
		}
		// print the answer
		pw.println(ans);
		// close output stream
		pw.close();

	}

}
