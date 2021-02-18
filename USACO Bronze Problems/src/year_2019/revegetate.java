package year_2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class revegetate {

	public static void main(String[] args) throws IOException {

		// BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] b = new int[N];
		b[0] = 1;

		int[][] rest = new int[M][2];

		for (int i = 0; i < rest.length; i++) {

			st = new StringTokenizer(br.readLine());
			rest[i][0] = Integer.parseInt(st.nextToken());
			rest[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		for (int i = 1; i < b.length; i++) {

			b[i] = 1;

			for (int j = 0; j < rest.length;) {

				if ((rest[j][0] - 1 <= i) && (rest[j][1] - 1 <= i)) {
					if (b[rest[j][0] - 1] == b[rest[j][1] - 1]) {

						b[i]++;
						j = 0;
						
						// j = -1

					} else {
						j++;
					}

				} else {
					j++;
				}

			}

		}

		String str = "";

		for (int i = 0; i < b.length; i++) {

			str += b[i];

		}

		PrintWriter pw = new PrintWriter(new File("revegetate.out"));

		System.out.println(str);
		pw.println(str);
		pw.close();

	}

}
