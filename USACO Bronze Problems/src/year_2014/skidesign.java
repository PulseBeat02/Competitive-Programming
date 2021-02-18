package year_2014;

//"Ski Course Design"
//http://usaco.org/index.php?page=viewproblem2&cpid=376

import java.util.*;
import java.io.*;

public class skidesign {
	static final String FILE_NAME = "skidesign";

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME + ".in"));

		int N = Integer.parseInt(br.readLine());

		int[] hills = new int[N];

		for (int i = 0; i < hills.length; i++) {

			hills[i] = Integer.parseInt(br.readLine());

		}

		br.close();

		int minCost = Integer.MAX_VALUE;
		Arrays.parallelSort(hills);
		int maxElement = hills[hills.length - 1];

		for (int i = 0; i <= maxElement; i++) {

			int cost = 0;
			int diff = 0;

			for (int j = 0; j < hills.length; j++) {

				if (hills[j] < i) { // less

					diff = i - hills[j];

				} else if (hills[j] > i + 17) { // more

					diff = hills[j] - (i + 17);

				} else { // equal

					diff = 0;

				}

				cost += diff * diff; // add to cost

			}

			if (cost < minCost) {

				minCost = cost;

			}

		}

		PrintWriter out = new PrintWriter(new File(FILE_NAME + ".out"));
		out.println(minCost);
		System.out.println(minCost);
		out.close();
	}
}
