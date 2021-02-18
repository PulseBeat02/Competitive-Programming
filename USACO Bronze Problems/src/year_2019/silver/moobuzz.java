package year_2019.silver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class moobuzz {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
		// new FileReader("whereami.in")

		// BufferedReader br = new BufferedReader(new FileReader("whereami.in"));

		// Jump By Multiples of 15, count Numbers Past, check if Greater

		int N = Integer.parseInt(br.readLine());
		br.close();

		int[] firstEight = {1, 2, 4, 7, 8, 11, 13, 14, 16};
		
		int firstNum = get(N, firstEight);

		PrintWriter pw = new PrintWriter(new File("moobuzz.out"));
		pw.println(firstNum);
		pw.close();

	}

	public static int get(int N, int[] array) {
		
		int num = (N - 1) / 8;
		return array[N - 8 * num - 1] + 15 * num;
		
	}

}
