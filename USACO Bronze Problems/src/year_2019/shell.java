package year_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class shell {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int swaps = Integer.parseInt(st.nextToken());

		int[][] allPossible = new int[swaps][3];

		allPossible[0][0] = 1;
		allPossible[0][1] = 2;
		allPossible[0][2] = 3;

		int[][] switches = new int[swaps][3];

		for (int i = 0; i < switches.length; i++) {

			st = new StringTokenizer(br.readLine());
			switches[i][0] = Integer.parseInt(st.nextToken());
			switches[i][1] = Integer.parseInt(st.nextToken());
			switches[i][2] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < allPossible.length; i++) {
			
			swap(allPossible, i, switches[i][0], switches[i][1]);
			
			System.out.println(Arrays.toString(allPossible[i]));

		}

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		for (int i = 0; i < allPossible.length; i++) {

			int current = allPossible[i][2];

			if (current == 1)
				count1++;
			if (current == 2)
				count2++;
			if (current == 3)
				count3++;

		}

		System.out.println(Math.max(Math.max(count1, count2), count3));

	}

	public static void swap(int[][] collection, int row, int first, int second) {
		
		if (row != 0) collection[row] = collection[row-1];

		int index1 = first - 1;
		int index2 = second - 1;

		collection[row][index1] = second;
		collection[row][index2] = first;


	}

}
