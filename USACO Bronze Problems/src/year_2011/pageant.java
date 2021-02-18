package year_2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class pageant {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");

		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		boolean[][] grid = new boolean[N][M];

		for (int i = 0; i < N; i++) { // Read Input

			String s = br.readLine();

			for (int j = 0; j < M; j++) {

				if (s.charAt(j) == 'X') {

					grid[i][j] = true;

				}

			}

		}

		br.close();
		
	
		
	}

}

class CornerPoint {
	
	int x;
	int y;
	
	CornerPoint(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
}
