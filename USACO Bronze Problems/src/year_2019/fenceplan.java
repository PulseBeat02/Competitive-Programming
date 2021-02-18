package year_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class fenceplan {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] cows = new int[N][2];
		int[][] connections = new int[M][2];
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			connections[i][0] = Integer.parseInt(st.nextToken());
			connections[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		ArrayList<ArrayList<int[]>> networks = new ArrayList<>();
		
		for (int i = 0; i < connections.length; i++) {
			
			
			
		}
		
		
	}

}




