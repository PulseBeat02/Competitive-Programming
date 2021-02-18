package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hps {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("hps.in")
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] moves = new int[N][2];

		for (int i = 0; i < moves.length; i++) {

			st = new StringTokenizer(br.readLine());
			moves[i][0] = Integer.parseInt(st.nextToken());
			moves[i][1] = Integer.parseInt(st.nextToken());

		}
		// 1, 2, 3

		br.close();

		int[] possibleMoves = { 1, 2, 3 };

		int max = 0;

		for (int i = 0; i < 6; i++) {
			
			int currentMax = 0;

			for (int j = 0; j < moves.length; j++) {
				
				if (isWin(moves[j][0], moves[j][1], possibleMoves)) currentMax++;
				
				update(possibleMoves);
				
			}
			
			if (currentMax > max) max = currentMax;

		}
		
		//PrintWriter pw = new PrintWriter(new File("hps.out"));
		//pw.println(max/2);
		//pw.close();
		
		System.out.println(max);

	}

	public static void update(int[] array) {

		for (int i = 0; i < array.length; i++) {

			if (array[i] == 3) {

				array[i] = 1;

			}

			else {

				array[i]++;

			}

		}

	}
	
	public static boolean isWin(int first, int second, int[] possibleMoves) {
		
		int hoof = possibleMoves[0];
		int paper = possibleMoves[1];
		int scissors = possibleMoves[2];
		
		if (first == hoof && second == scissors) return true;
		if (first == hoof && second == paper) return false;
		
		if (first == paper && second == hoof) return true;
		if (first == paper && second == 3) return false;
		
		if (first == scissors && second == 2) return true;
		if (first == scissors && second == hoof) return false;
		
		return false;
		
	}

}









