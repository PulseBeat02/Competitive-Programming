package shuffle2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class shuffle {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] shuffles = new int[N + 1];
		int[][] contain = new int[2][N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < shuffles.length; i++) {

			shuffles[i] = Integer.parseInt(st.nextToken());

		}

		br.close();

		for (int i = 1; i < contain[0].length; i++) {

			contain[0][i] = 1;

		}

		int A = 0, B = 1;
		for (;;) {

			for (int i = 1; i < contain[0].length; i++) {

				contain[B][i] = 0;

			}

			for (int i = 1; i < contain[0].length; i++) {

				if (contain[A][i] == 1) {

					contain[B][shuffles[i]] = 1;

				}

			}

			if (Arrays.equals(contain[A], contain[B])) {

				break;

			} else {

				if (A == 0) {

					A = 1;
					B = 0;

				} else {

					A = 0;
					B = 1;

				}

			}

		}

		int count = 0;

		for (int i = 1; i < contain[0].length; i++) {

			if (contain[A][i] == 1) {

				count++;

			}

		}

		PrintWriter pw = new PrintWriter(new File("shuffle.out"));
		pw.print(count);
		pw.close();

	}

}
