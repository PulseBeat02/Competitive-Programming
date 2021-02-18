package competition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class race {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("race.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] X = new int[N];

		for (int i = 0; i < X.length; i++) {

			st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());

		}
		
		br.close();

		int[] solutions = new int[N];

		for (int i = 0; i < X.length; i++) {

			int distTraveled = 0;
			int currSpeed = 0;
			int time = 0;

			while (true) {

				time++;

				int canDecrease = decrease(currSpeed, X[i], K, distTraveled + currSpeed);

				currSpeed += canDecrease;
				
				distTraveled += currSpeed;

				if (distTraveled >= K) {

					solutions[i] = time;
					break;

				}

			}

		}

		PrintWriter pw = new PrintWriter(new File("race.out"));
		
		for (int i = 0; i < solutions.length; i++) {
			
			pw.println(solutions[i]);
			
		}
		
		pw.close();

	}

	public static int decrease(int speed, int tspeed, int totalDist, int distTraveled) {

		if ((speed + 1 - tspeed) * (speed + 1) < totalDist - distTraveled) {
			
			return 1;
			
		}
		
		if ((speed - tspeed)  > (totalDist - distTraveled)) {
			
			return -1;
			
		}
			
		// check if can increase
		int td = 0;
//		for (int i = speed + 1 - tspeed; i > 0; i--) {
//			td += (i + tspeed);
//
//		}
		
		td = (speed + 1 - tspeed) * ((speed - tspeed + 2)) / 2 + (speed + 1 - tspeed) * tspeed;
				
		if (td < (totalDist - distTraveled)) {

			// we can increase
			return 1;
		}
		
		if ((td - speed - 1) > (totalDist - distTraveled + speed)) {
			return -1;
		}

//		td = 0;
//		for (int i = speed - tspeed; i > 0; i--) {
//			td += (i + tspeed);
//		}
//		
//		if (td > (totalDist - distTraveled + speed)) {
//
//			// we need to decrease
//			return -1;
//		}

		return 0;

	}

}
