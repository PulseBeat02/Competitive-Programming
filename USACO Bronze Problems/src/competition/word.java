package competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class word {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("word.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String[] words = br.readLine().split(" ");

		br.close();

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));

		int len = 0;

		for (int i = 0; i < N; ) {

			if (len + words[i].length() <= K) {
				
				if (len == 0) {
					
					pw.print(words[i]);
					
				} else {
					
					pw.print(" " + words[i]);
					
				}

				len += words[i].length();
				i++;

			} else {

				pw.println();
				
				len = 0;

			}

		}

		pw.close();

	}

}
