import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class socdist {

	public static long[] a;
	public static long[] b;

	public static int M;
	public static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		a = new long[M];
		b = new long[M];

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());

		}

		br.close();

		Arrays.parallelSort(a);
		Arrays.parallelSort(b);

		long first = a[0];
		long last = b[M - 1];

		long DL = (last - first) / (N - 1);

//		long left = 1;
//		long right = DL;

		long prev = -1;

//		while (left <= right) {
//
//			long m = (left + right) / 2;
//
//			if (works(m)) {
//
//				prev = m;
//				left = m + 1;
//
//			} else {
//
//				if (prev == -1) {
//					prev = m;
//				}
//				break;
//
//			}
//
//		}
		for (prev = DL; prev >= 1; prev--) {

			if (works(prev)) {

				break;

			}

		}

		PrintWriter pw = new PrintWriter(new File("socdist.out"));
		pw.print(prev);
		pw.close();

	}

	public static boolean works(long m) {

		int i = 0;
		long td = 0;

//		for (int n = 0; n < N; n++) {
//
//			if (td >= a[i] && td <= b[i]) {
//				td += m;
//				continue;
//			} else {
//
//				while (i < M && td >= b[i]) {
//					i++;
//				}
//
//				// td = a[i];
//
//				if (i == M) {
//					return false;
//				}
//
//				// td += m;
//
//				if (a[i] > td) {
//
//					td = a[i];
//
//				} else {
//					td += m;
//				}
//			}
//
//		}

		td = 0;

		for (int n = 0; n < N; n++) {

//			if (td >= a[i] && td <= b[i]) {
//				td += m;
//				continue;
//			} else {

			while (i < M && td >= b[i]) {
				i++;
			}

			if (i == M) {
				return false;
			}

			// td += m;

			if (a[i] > td) {

				td = a[i];

			} else {
				td += m;
			}
		}

		return true;

	}

}

/*
 * ANALYSIS
 * 
 * 
 * sort - O(N)
 * 
 * Identify Last and First Interval - O(1) Calculate the largest possible D, or
 * DL = (Last-First)/(N - 1)
 * 
 * Use binary search O(log2 AB) to test all values from 1 to DL Find Biggest D
 * Possible
 * 
 * 
 */
