package year_2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Shell_Game {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] cups = new int[3];

		int[][] swaps = new int[N][3];

		for (int i = 0; i < N; i++) {
			swaps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		
		System.out.println(Arrays.deepToString(swaps));

		for (int i = 0; i < 100; i++) {

			swap(cups, swaps[i][0], swaps[i][1]);
			
			if (swaps[i][2] == 1 && cups[0] == 1) count1++;
			if (swaps[i][2] == 2 && cups[1] == 2) count2++;
			if (swaps[i][2] == 3 && cups[2] == 3) count3++;

		}
		
		System.out.println(Math.max(Math.max(count1, count2), count3));
		
//		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
//		pw.print(count);
//		pw.close();
//		br.close();

	}

	public static void swap(int[] cups, int index, int target) {

		int original = index;
		int newInteger = target;

		cups[original - 1] = newInteger;
		cups[newInteger - 1] = original;
		
		System.out.println(cups[0] + " " + cups[1] + " " + cups[2]);

	}

}
