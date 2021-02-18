package year_2015.speedingredo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class speeding {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// new FileReader("speeding.in")
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] l = new int[N][2];
		int[][] b = new int[M][2];

		for (int i = 0; i < l.length; i++) {

			st = new StringTokenizer(br.readLine());
			l[i][0] = Integer.parseInt(st.nextToken());
			l[i][1] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < b.length; i++) {

			st = new StringTokenizer(br.readLine());
			b[i][0] = Integer.parseInt(st.nextToken());
			b[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		int index = 0;
		int max = 0;
		int exceeded = 0;

		int addedDist = b[0][0];

		for (int m = 0; m <= 100; m++) {

			if (m == addedDist) {
				index++;
				addedDist += b[index][0];

				if (exceeded > max) {

					max = exceeded;

				}

				exceeded = 0;

			}

			if (b[index][1] > getSpeed(m, l)) {

				exceeded = b[index][1] - getSpeed(m, l);

			}

		}

		System.out.println(exceeded);

	}

	private static int getSpeed(int m, int[][] l) {

		int upper = 0;
		int lower = 0;

		for (int i = 0; i < l.length; i++) {
			
			upper += l[i][0];
			
			if (m < upper) {
				
				lower = upper - l[i][0];
				break;
				
			}

		}
		
		
		
		for (int i = 0; i < l.length; i++) {
			
			if (m >= lower && m < upper && i != 0) {
				
				return l[i + 1][1];
				
			} else if (i == 0) {
				
				return l[i][1];
				
			}
			
		}

		return -1;
	}

}
