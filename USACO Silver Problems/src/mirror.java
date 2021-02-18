import java.io.BufferedReader;
import java.io.File;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mirror {

	public static int max = 0;
	public static int direction = -1;

	public static char[][] pos;
	public static boolean[][] populate;

	public static void main(String[] args) throws IOException {

		// BufferedReader br = new BufferedReader(new FileReader("mirror.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		pos = new char[N][M];
		populate = new boolean[N][M];

		for (int i = 0; i < N; i++) {

			String s = br.readLine();

			for (int j = 0; j < M; j++) {
				
				pos[i][j] = s.charAt(j);

			}

		}
		
		br.close();
		
		PrintWriter pw = new PrintWriter(new File("mirror.out"));

		for (int i = 0; i < N; i++) { // Test Rows
			
			for (boolean[] a : populate) {

				Arrays.fill(a, false);

			}

			direction = 1;
			int first = track(i, 0, 0);

			for (boolean[] a : populate) {

				Arrays.fill(a, false);

			}

			direction = 0;
			int second = track(i, N - 1, 0);
			
			if (first == -1 || second == -1) {
				
				pw.println(-1);
				pw.close();
				
				System.exit(0);
				
			}
			
			
			max = Math.max(max, Math.max(first, second));
			
		}
		
		for (int j = 0; j < M; j++) { // Test Columns
			
			for (boolean[] a : populate) {

				Arrays.fill(a, false);

			}

			direction = 2;
			int first = track(0, j, 0);

			for (boolean[] a : populate) {

				Arrays.fill(a, false);

			}

			direction = 3;
			int second = track(M-1, j, 0);
			
			if (first == -1 || second == -1) {
				
				pw.println(-1);
				pw.close();
				
				System.exit(0);
				
			}
			
			max = Math.max(max, Math.max(first, second));
			
		}
		
		System.out.println(max);

	}

	private static int track(int i, int j, int count) {

		if (populate[i][j])
			return -1;

		populate[i][j] = true;
		count++;

		int[] n = next(i, j);

		if ((n[0] < 0 || n[0] >= populate.length) || (n[1] < 0 || n[1] >= populate[0].length)) {

			return count;

		} else {

			track(n[0], n[1], count);

		}

		return -1;

	}

	private static int[] next(int i, int j) {

		// @param direction:
		// 0 is left
		// 1 is right
		// 2 is down
		// 3 is up

		switch (direction) {

		case 0:

			if (pos[i][j] == '/') {

				direction = 2;
				return new int[] { i + 1, j };

			} else {

				direction = 3;
				return new int[] { i - 1, j };

			}

		case 1:

			if (pos[i][j] == '/') {

				direction = 3;
				return new int[] { i - 1, j };

			} else {

				direction = 2;
				return new int[] { i + 1, j };

			}

		case 2:

			if (pos[i][j] == '/') {

				direction = 0;
				return new int[] { i, j - 1 };

			} else {

				direction = 1;
				return new int[] { i, j + 1 };

			}

		case 3:

			if (pos[i][j] == '/') {

				direction = 1;
				return new int[] { i, j + 1 };

			} else {

				direction = 0;
				return new int[] { i, j - 1 };

			}

		}

		return new int[] { -1, -1 };

	}

}
