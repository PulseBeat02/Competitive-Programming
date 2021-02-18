package competition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class race2 {
	
	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)/* new FileReader("race.in") */);
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

			int currentSpeed = 0;
			int time = 0;
			
			for (int j = 0; j < K; j += currentSpeed) {
				
				time++;
				currentSpeed += change(j, currentSpeed, X[i], K);
				
			}
			
			solutions[i] = time;
			
		}
		
		System.out.println(Arrays.toString(solutions));
		
	}
	
	public static int change(int metersRan, int currentSpeed, int targetSpeed, int totalDist) {
		
		if (currentSpeed == 0) {
			
			return 1;
			
		}
		
		int StepsToTargetSpd = Math.abs(currentSpeed - targetSpeed);
		
		if (metersRan + getTotal(currentSpeed, StepsToTargetSpd) < totalDist) { // have time to increase
			
			return 1;
			
		} else if (metersRan + getTotal(currentSpeed, StepsToTargetSpd) == totalDist) { // decrement normally
			
			return -1;
			
		} else {
			
			return 0;
			
		}
		
	}
	
	public static int getTotal(int currentSpeed, int decrements) {
		
		// returns total distance if decremented
		
		//  5 , 2
		//  5 + 4 + 3
		
		int sum = 0;
		
		for (int i = currentSpeed; i >= currentSpeed - decrements; i--) {
			
			sum += i;
			
		}
		
		return sum;
		
	}

}





