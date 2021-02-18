package usopen2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class factory {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("factory.in")
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] belt = new int[N - 1][2];

		for (int i = 0; i < belt.length; i++) {

			st = new StringTokenizer(br.readLine());
			belt[i][0] = Integer.parseInt(st.nextToken());
			belt[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		int[] possibleVal = getColumn(belt, 1);
		
		System.out.println(Arrays.toString(possibleVal));

		int answer = N;

		for (int i = 0; i < possibleVal.length; i++) {
			
			int value = possibleVal[i];
			
			boolean flag = false;

			for (int j = 0; j < belt.length; j++) {
				
				if (isReached(belt, possibleVal[j], value)) {
					
					flag = true;

				}
				
				else {
					
					flag = false;
					
				}

			}
			
			if (value < answer && flag) 
				answer = value;

		}
		
		PrintWriter pw = new PrintWriter(new File("factory.out"));
//		pw.println(answer);
		
		if (answer == N) {
			
			//pw.println(-1);
			
		}
		
		System.out.println(answer);
		
		pw.close();

	}

	static int[] getColumn(int[][] matrix, int column) {
		return IntStream.range(0, matrix.length).map(i -> matrix[i][column]).toArray();
	}

	static boolean isReached(int[][] belt, int current, int target) {

		if (current == target) {

			return true;

		}

		else {

			int next = -1;

			for (int i = 0; i < belt.length; i++) {

				if (belt[i][0] == current) {

					next = belt[i][1];

				}

			}

			if (next == -1) {
				
				return false;
				
			} else {

				isReached(belt, next, target);

			}

		}
		
		return false;

	}

}
