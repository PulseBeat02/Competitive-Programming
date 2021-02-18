package year_2015.speeds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class speed {

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

		int max = 0;

		int added = 0;

		for (int i = 0; i < bSpeeds.length; i++) {

			added += bSpeeds[i][0];

			int bSpeed = bSpeeds[i][1];
			int speedLimit = getSpeed(limits, added);

			if (bSpeed > speedLimit/* && speedLimit != -1 */) {

				if (bSpeed - speedLimit > max) {

					max = bSpeed - speedLimit;

				}

			}

		}

		System.out.println(max);

	}

	public static int getSpeed(int[][] limit, int distance) {

		int added = 0;

		for (int i = 0; i < limit.length; i++) {

			if (i == limit.length - 1) {

				if (distance >= added && distance < 100) {

					return limit[i][1];

				}

			}

			else {
				
				if (distance >= added && distance < added + limit[i + 1][0]) {

					return limit[i][1];

				}

			}
			
			added += limit[i][0];

		}

		return -1;

	}

}
