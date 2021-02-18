package year_2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class herding {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		br.close();

		if (a > b) {
			
			swap(a, b);
			
		}

		if (b > c) {
			
			swap(b, c);
			
		}
		if (a > b) {
			
			swap(a, b);
			
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));

		if (c == a + 2) {
			
			pw.println(0);
			//System.out.println(0);

		} else if (b == a + 2 || c == b + 2) {
			
			pw.println(1);
			//System.out.println(1);
			
		} else {

			pw.println(2);
			//System.out.println(2);
		}
		
		pw.println(Math.max(b - a, c - b) - 1);
		//System.out.println(Math.max(b - a, c - b) - 1);

		
		pw.close();

	}

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

}
