import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class loan {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("loan.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());

		br.close();

		long low = 0; // WE KNOW THIS DOES NOT WORK
		long high = N; // WE KNOW THIS WORKS (Give All At Once)

		while (high - low != 1) {

			long mid = (high + low) / 2;

			if (works(mid, N, M, K)) {

				high = mid;

			} else {

				low = mid;

			}

		}

		System.out.println(high);

	}

	public static boolean works(long X, long N, long M, long K) { // N-G for N

		long G = 0;
		while (K > 0 && G < N) {
			long Y = (N - G) / X;
			if (Y < M) {
				long leftover = (N - G + M - 1) / M;
				return leftover <= K;
			}
			long maxmatch = N - X * Y;
			long numdays = (maxmatch - G) / Y + 1;
			if (numdays > K)
				numdays = K;
			G += Y * numdays;
			K -= numdays;
		}
		return G >= N;

	}

}
