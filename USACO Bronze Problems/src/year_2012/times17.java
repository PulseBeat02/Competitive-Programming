package year_2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class times17 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("times17.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		br.close();

		int num17 = N * 17;

		int binary [] = new int[1000];
		
		int index = 0;
		while (num17 > 0) {
			binary[index++] = num17 % 2;
			num17 = num17 / 2;
		}
		
		PrintWriter pw = new PrintWriter(new File("times17.out"));
		
		for (int i = index - 1; i >= 0; i--) {
			
			pw.print(binary[i]);
			
		}
		
		pw.close();

	}

}
