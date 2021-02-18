package year_2017;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hps2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("hps.in"));

		int n = Integer.parseInt(br.readLine());
		
		int[][] matches = new int[4][4];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			matches[first][second]++;
		}
		
		br.close();
		
		int maximumWins = matches[1][2] + matches[2][3] + matches[3][1];
		if (matches[1][3] + matches[3][2] + matches[2][1] > maximumWins) {
			maximumWins = matches[1][3] + matches[3][2] + matches[2][1];
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		pw.println(maximumWins);
		pw.close();
		
	}

}
