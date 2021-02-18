package year_2019.redo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class shell2 {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("shell.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] pos = new int[N][2];
		int[] guess = new int[N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
			guess[i] = Integer.parseInt(st.nextToken());

		}

		br.close();

		boolean[] swaps = new boolean[4];

		int maxCount = 0;

		for (int i = 1; i < 4; i++) {

			//Arrays.fill(swaps, false);
			swaps[i] = true;

			int count = 0;

			for (int j = 0; j < N; j++) {

				boolean tmp = swaps[pos[j][0]];
				swaps[pos[j][0]] = swaps[pos[j][1]];
				swaps[pos[j][1]] = tmp;

				if (swaps[guess[j]]) {

					count++;

				}

			}

			if (count > maxCount) {

				maxCount = count;

			}
			swaps[i] = false;
		}
		
		System.out.println(maxCount);

		PrintWriter pw = new PrintWriter(new File("shell.out"));
		pw.println(maxCount);
		pw.close();

	}

}
