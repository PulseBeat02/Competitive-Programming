package year_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Back_And_Forth {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int [] firstBarn = new int[10];
		int [] secondBarn = new int[10];

		for (int i = 0; i < firstBarn.length; i++) {
			
			firstBarn[i] = Integer.parseInt(st.nextToken());
			
		}
		
		for (int i = 0; i < secondBarn.length; i++) {
			
			secondBarn[i] = Integer.parseInt(st1.nextToken());
			
		}

		pw.println("Something Here");
		br.close();
		pw.close();

	}

}
