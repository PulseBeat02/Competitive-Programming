package year_2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Speeding_Ticket {

	/*
	 * Algorithm: ----------------------------------
	 * 
	 * 1) Use BufferedReader to Read File 2) Use PrintWriter to Print File 3) Use
	 * StringTokenizer to get numbers of segments and number of series of segments.
	 * 4) Make for loop and loop through each of the segments. 5) Make a loop that
	 * loops until 100 6) Make a current-max variable 7) Make an if statement
	 * checking if Bessie is over the speed limit currently. 8) If so, make the
	 * current-max variable equal to that. 9) If current-max is greater than max,
	 * make max = current-max 10) print out max in file.
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
		PrintWriter pw = new PrintWriter(new File("speeding.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int segments = Integer.parseInt(st.nextToken());
		int seriesOfSegments = Integer.parseInt(st.nextToken());

		int[][] allSegments = new int[segments][2];
		int[][] bessieSegments = new int[seriesOfSegments][2];

		for (int i = 0; i < segments; i++) {

			st = new StringTokenizer(br.readLine());
			allSegments[i][0] = Integer.parseInt(st.nextToken());
			allSegments[i][1] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < seriesOfSegments; i++) {

			st = new StringTokenizer(br.readLine());
			bessieSegments[i][0] = Integer.parseInt(st.nextToken());
			bessieSegments[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		int max = 0;

		for (int i = 0; i <= 100; i++) {

			int currentMax = 0;

			for (int j = 0; j < allSegments.length; j++) {

				if (i >= getBounderies(allSegments, j)[0] && i <= getBounderies(allSegments, j)[1]) {

					if (allSegments[j][1] < getCurrentSpeed(bessieSegments, i)) {

						currentMax = getCurrentSpeed(bessieSegments, i) - allSegments[j][1];

					}

				}

				if (currentMax > max) {

					max = currentMax;
					currentMax = 0;

				}

			}

		}

		pw.println(max);
		pw.close();

	}

	public static int[] getBounderies(int[][] segments, int segment) {

		int min = 0;

		for (int i = 0; i < segment; i++) {

			min += segments[i][0];

		}
		
		int max = min + segments[segment][0];

		int[] boundaries = { min, max };

		return boundaries;

	}
	
	public static int getCurrentSpeed(int [][] BessieSegments, int time) {
		
		for (int i = 0; i < BessieSegments.length; i++) {
			
			int [] boundaries = getBounderies(BessieSegments, i);
			
			if (time > boundaries[0] && time < boundaries[1]) {
				
				return BessieSegments[i][0];
				
			}
			
		}
		
		return 0;
		
	}

}












