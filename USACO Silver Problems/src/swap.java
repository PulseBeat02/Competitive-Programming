
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
//import java.util.HashMap;
import java.util.StringTokenizer;

public class swap {

	static int mini = 100000, maxi = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

//		st = new StringTokenizer(br.readLine());
//		int[] shift1 = new int[2];
//		shift1[0] = Integer.parseInt(st.nextToken());
//		shift1[1] = Integer.parseInt(st.nextToken());
//
//		st = new StringTokenizer(br.readLine());
//		int[] shift2 = new int[2];
//		shift2[0] = Integer.parseInt(st.nextToken());
//		shift2[1] = Integer.parseInt(st.nextToken());

		int[][] shifts = new int[M][2];

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			shifts[i][0] = Integer.parseInt(st.nextToken());
			shifts[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		int[] cows = new int[N + 1];
		int[] orig = new int[N + 1];

		for (int i = 1; i <= N; i++) {

			cows[i] = i;
			orig[i] = i;

		}

		int count = K;

		int pa = findPattern(cows, shifts, M);

		if (pa < M) {

			M = M % pa;

		}

		for (int i = 0; i < K; i++) {

			for (int j = 0; j < M; j++) {

				reverse(cows, shifts[j]);

			}

			// if (Arrays.equals(cows, orig)) {
			boolean same = true;
			for (int x = mini; same && x <= maxi; x++) {
				if (cows[x] != orig[x]) {
					same = false;
				}
			}
			if (same) {
				count = (i + 1);
				break;
			}
		}

		if (count < K) {

			count = (K % count);

			while (count > 0) {

				for (int j = 0; j < M; j++) {

					reverse(cows, shifts[j]);

				}
				count--;

			}

		}

		PrintWriter pw = new PrintWriter(new File("swap.out"));

		for (int c = 1; c < cows.length; c++) {

			pw.println(cows[c]);

		}

		pw.close();

	}

	public static int findPattern(int[] cows, int[][] swaps, int M) {

		int[] copy = new int[cows.length];

		for (int i = 1; i < copy.length; i++) {
			copy[i] = cows[i];
		}

		for (int i = 0; i < M; i++) {
			if (mini > swaps[i][0])
				mini = swaps[i][0];
			if (maxi < swaps[i][1])
				maxi = swaps[i][1];

			reverse(copy, swaps[i]);

			if (Arrays.equals(cows, copy)) {

				return i + 1;

			}

		}

		return M;

	}

	public static void reverse(int[] cows, int[] swaps) {

		for (int i = 0; i < (swaps[1] - swaps[0] + 1) / 2; i++) {

			int tmp = cows[swaps[0] + i];

			cows[swaps[0] + i] = cows[swaps[1] - i];
			cows[swaps[1] - i] = tmp;

		}

	}

}
