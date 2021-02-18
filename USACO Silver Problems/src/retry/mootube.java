package retry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mootube {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[][] known = new int[N][3];

		for (int i = 1; i < known.length; i++) {

			st = new StringTokenizer(br.readLine());
			known[i][0] = Integer.parseInt(st.nextToken());
			known[i][1] = Integer.parseInt(st.nextToken());
			known[i][2] = Integer.parseInt(st.nextToken());

		}

		int[][] query = new int[Q][2];

		for (int i = 0; i < query.length; i++) {

			st = new StringTokenizer(br.readLine());
			query[i][0] = Integer.parseInt(st.nextToken());
			query[i][1] = Integer.parseInt(st.nextToken());

		}

		int[][] arr = new int[N + 1][N + 1];

		for (int[] a : arr) {
			
			Arrays.fill(a, Integer.MAX_VALUE);
			
		}
		
		

	}

}
