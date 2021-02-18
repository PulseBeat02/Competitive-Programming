package year_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class combo {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("combo.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int f1 = Integer.parseInt(st.nextToken());
		int f2 = Integer.parseInt(st.nextToken());
		int f3 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int m1 = Integer.parseInt(st.nextToken());
		int m2 = Integer.parseInt(st.nextToken());
		int m3 = Integer.parseInt(st.nextToken());

		br.close();

		int count = 0;

		for (int a = 0; a < N; a++) {

			for (int b = 0; b < N; b++) {

				for (int c = 0; c < N; c++) {

					if (closeEnough(a, b, c, f1, f2, f3, N) || closeEnough(a, b, c, m1, m2, m3, N))
						count++;

				}

			}

		}

		PrintWriter pw = new PrintWriter(new File("combo.out"));
		pw.println(count);
		pw.close();

	}

	static boolean closeEnough(int a, int b, int c, int m1, int m2, int m3, int N) {

		return close(a, m1, N) && close(b, m2, N) && close(c, m3, N);

	}

	static boolean close(int a, int b, int N) {
		if (Math.abs(a - b) <= 2)
			return true;
		if (Math.abs(a - b) >= N - 2)
			return true;
		return false;
	}

}
