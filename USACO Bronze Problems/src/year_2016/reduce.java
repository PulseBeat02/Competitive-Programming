package year_2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class reduce {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] locations = new int[N][2];

		for (int i = 0; i < locations.length; i++) {

			st = new StringTokenizer(br.readLine());
			locations[i][0] = Integer.parseInt(st.nextToken());
			locations[i][1] = Integer.parseInt(st.nextToken());

		}
		
		br.close();

		// Get Most Top, Bottom, Left, and Right Cow

		int[] top = locations[0];
		int topi = 0;
		int[] bottom = locations[0];
		int bottomi = 0;
		int[] left = locations[0];
		int lefti = 0;
		int[] right = locations[0];
		int righti = 0;

		for (int i = 0; i < locations.length; i++) {

			if (locations[i][1] > top[1]) {

				top = locations[i];
				topi = i;

			}

			if (locations[i][1] < bottom[1]) {

				bottom = locations[i];
				bottomi = i;

			}

			if (locations[i][0] < left[0]) {

				left = locations[i];
				lefti = i;

			}

			if (locations[i][0] > right[0]) {

				right = locations[i];
				righti = i;

			}

		} // Check how many cows are in the current row, column

		// area after remove the top

		int answer = 0;

		int topArea = recalculate(locations, topi);
		int bottomArea = recalculate(locations, bottomi);
		int leftArea = recalculate(locations, lefti);
		int rightArea = recalculate(locations, righti);

		answer = Math.min(topArea, Math.min(bottomArea, Math.min(leftArea, rightArea)));

		PrintWriter pw = new PrintWriter(new File("reduce.out"));
		pw.println(answer);
		pw.close();

	}

	public static int recalculate(int[][] locations, int removed) {

		int lt = 0, lb = Integer.MAX_VALUE, ll = Integer.MAX_VALUE, lr = 0;

		for (int i = 0; i < locations.length; i++) {
			if (i != removed) {
				if (locations[i][1] > lt) {
					lt = locations[i][1];
				}
				if (locations[i][1] < lb) {
					lb = locations[i][1];
				}
				if (locations[i][0] > lr) {
					lr = locations[i][0];
				}
				if (locations[i][0] < ll) {
					ll = locations[i][0];
				}

			}

		}

		return (lt - lb) * (lr - ll);

	}

}
