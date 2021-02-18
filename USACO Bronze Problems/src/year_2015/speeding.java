package year_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class speeding {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("speeding.in")
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] limits = new int[N][2];
		int[][] bSpeeds = new int[M][2];

		for (int i = 0; i < limits.length; i++) {

			st = new StringTokenizer(br.readLine());
			limits[i][0] = Integer.parseInt(st.nextToken());
			limits[i][1] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < bSpeeds.length; i++) {

			st = new StringTokenizer(br.readLine());
			bSpeeds[i][0] = Integer.parseInt(st.nextToken());
			bSpeeds[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		int mostPassed = 0;
		int added = 0; // lower bound

		int maxSpeed = 0;
		int bSpeed = 0;

		int upper;

		for (int i = 1; i <= 100; i++) { // i is current segment
			
			bSpeed = getBessieSpeed(bSpeeds, i);

			for (int j = 0; j < bSpeeds.length; j++) {

				upper = limits[j][0] + added;

				if (i >= added && i < upper) {

					maxSpeed = limits[j][1];
					added += limits[j][0];

				}

				if (bSpeed > maxSpeed) {

					if (bSpeed - maxSpeed > mostPassed) {

						mostPassed = bSpeed - maxSpeed;

					}

				}

			}

		}

		System.out.println(mostPassed);

	}

	public static int getBessieSpeed(int[][] speeds, int time) {

		int added = 0;

		for (int i = 0; i < speeds.length; i++) {

			int upper;

			if (i == speeds.length - 1) {

				upper = 100;

			} else {

				upper = added + speeds[i + 1][0];

			}

			if (inRange(time, added, upper)) {

				return speeds[i][1];

			}

			else {

				added += speeds[i][0];

			}

		}

		return -1;

	}

	public static boolean inRange(int num, int l, int h) {

		return num < h && num >= l;

	}

}
