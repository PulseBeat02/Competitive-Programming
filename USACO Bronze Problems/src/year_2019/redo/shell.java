package year_2019.redo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class shell {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedReader br = new BufferedReader(new FileReader("shell.in")); 
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		int[][] pos = new int[N][2];
		int[] guess = new int[N];
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
			guess[i] = Integer.parseInt(st.nextToken());
			
		}
		
		br.close();
		
		int[] temp = {1, 2, 3};
		int[] pebbles = {1, 2, 3};
		
		int maxCount = 0;
		
		for (int i = 1; i < 4; i++) { // i is pebble location
			
			int currentPebbleLocation = i;
			int count = 0;
			
			for (int j = 0; j < N; j++) {
				
				int currentGuess = guess[j];

				currentPebbleLocation = swap(pebbles, getIndex(pebbles, pos[j][0]), getIndex(pebbles, pos[j][1]), currentPebbleLocation);
				
				//currentPebbleLocation = getIndex(pebbles, i);
				
				//if (pebbles[currentPebbleLocation] == currentGuess) {
				if (currentPebbleLocation == getIndex(pebbles, currentGuess - 1)) {
					
					count++;
					
				}
				
				
			}
			
			if (count > maxCount) {
				
				maxCount = count;
				
			}
			
			pebbles = temp;
			
		}
		
		PrintWriter pw = new PrintWriter(new File("shell.out"));
		pw.println(maxCount);
		pw.close();


	}
	
	public static int getIndex(int[] pebbles, int p) {
		
		if (pebbles[0] == p) return 0;
		if (pebbles[1] == p) return 1;
		return 2;
		
	}
	
	public static int swap(int[] pebbles, int indexA, int indexB, int currentPebbleLocation) {
		
		int temp = pebbles[indexA];
		
		pebbles[indexA] = pebbles[indexB];
		pebbles[indexB] = temp;
		
		if (currentPebbleLocation == indexA) {
			return indexB;
		}
		if (currentPebbleLocation == indexB) {
			return indexA;
		}
		return currentPebbleLocation;
		
	}
	
}
