package old;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class skyline {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("skyline.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] heights = new int[N];
		for (int i = 0; i < heights.length; i++) {
			heights[i] = Integer.parseInt(br.readLine());
		}
		br.close();

		// 60
		// 100
		// 100
		// 120
		// 200
		// 220

		int sum = 0;
		for (int i = 0; i < B; i++) {
			sum += heights[i];
		}

		double center = 0;
		double average = sum / B;
		for (int i = 1; i + B - 1 < heights.length; i++) {
			int before = heights[i - 1];
			int next = heights[i + B - 1];
			sum = (sum - before) + next;
			if (average < sum / B) {
				average = sum / B;
				center = ((i + 1) + (i + B)) / 2;
			}
		}

		System.out.println(center + " " + average);

	}

}
