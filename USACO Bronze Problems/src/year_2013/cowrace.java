package year_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cowrace {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cowrace.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] bessie = new int[N][2];
		int[][] elsie = new int[M][2];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			bessie[i][0] = Integer.parseInt(st.nextToken());
			bessie[i][1] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			elsie[i][0] = Integer.parseInt(st.nextToken());
			elsie[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		int totalTime = getTotalTime(bessie);

		int bIndex = 0;
		int eIndex = 0;

		int[] bTime = { 0, bessie[bIndex][1] };
		int[] eTime = { 0, elsie[eIndex][1] };

		int Db = 0;
		int De = 0;

		int count = 0;

		int winning = 0;

		// 0 -> No One
		// 1 -> Bessie
		// 2 -> Elsie

		for (int i = 0; i < totalTime; i++) {

			if (i >= bTime[1]) {

				bTime[0] = bTime[1];
				bIndex++;
				bTime[1] += bessie[bIndex][1];
				Db += bessie[bIndex][0];

			}

			else {

				Db += bessie[bIndex][0];
			}

			if (i >= eTime[1]) {

				eTime[0] = eTime[1];
				eIndex++;
				eTime[1] += elsie[eIndex][1];
				De += elsie[eIndex][0];

			}

			else {

				De += elsie[eIndex][0];

			}

			switch (winning) {

			case 0:
				if (Db > De)
					winning = 1;
				if (De > Db)
					winning = 2;
				break;

			case 1:
				if (De > Db) {

					count++;
					winning = 2;

				}
				break;

			case 2:
				if (Db > De) {

					count++;
					winning = 1;

				}
				break;

			}

		}

		PrintWriter pw = new PrintWriter(new File("cowrace.out"));
		pw.println(count);
		pw.close();

	}

	public static int getTotalTime(int[][] log) {

		int sum = 0;

		for (int i = 0; i < log.length; i++) {

			sum += log[i][1];

		}

		return sum;

	}

}
