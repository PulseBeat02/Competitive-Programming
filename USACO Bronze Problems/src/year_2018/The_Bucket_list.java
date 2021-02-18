package year_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class The_Bucket_list {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("blist.in"));

		int N = Integer.parseInt(br.readLine()); // Get Number of Cows

		int[][] arr = new int[N][3]; // Make 2D Array sFull of Vlaues

		for (int i = 0; i < N; i++) {

			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // Fill Array With
																									// File Contentents
		}

		br.close();

		int max = 0; // Test Case for if Needed Buckets is  0

		for (int i = 1; i < 1000; i++) { // Loop Until 1000, i represents the current time.

			int total = 0; // Total Buckets Needed

			for (int j = 0; j < arr.length; j++) { // Loop Through 2D Array

				if (arr[j][0] <= i && arr[j][1] >= i) { // Checks if the current Time is Between the start and end point
														// with comparisons to i

					total += arr[j][2]; // Add the needed buckets to the total.

					// Notice that loop doesn't over-count the amount of buckets needed, because the
					// if conditional needs to be satisfied with the cow's milking time being valid
					// in order to add it to the total.

				}

			}

			max = Math.max(max, total); // If needed buckets is 0, then it will be defined here. Else, the max buckets
										// is the total.

		}

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out"))); // Print
		out.println(max);
		out.close();

	}
}
