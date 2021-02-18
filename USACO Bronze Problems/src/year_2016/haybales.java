package year_2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class haybales {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] bales = new int[N];

		int[][] query = new int[Q][2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < bales.length; i++) {

			bales[i] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < query.length; i++) {

			st = new StringTokenizer(br.readLine());
			query[i][0] = Integer.parseInt(st.nextToken());
			query[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		Arrays.parallelSort(bales);

		PrintWriter pw = new PrintWriter(new File("haybales.out"));

		for (int i = 0; i < query.length; i++) {

			pw.println();
			//System.out.println(total);
			
		}

		pw.close();

	}

}
