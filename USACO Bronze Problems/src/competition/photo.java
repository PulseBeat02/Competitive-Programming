package competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class photo {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("photo.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] b = new int[N - 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < b.length; i++) {

			b[i] = Integer.parseInt(st.nextToken());

		}

		br.close();

		int[] min = new int[N];

		boolean found = false;

		for (int j = b[0] - 1; j >= 1 && !found;) {

			int b0 = j;
			int b1 = b[0] - j;

			int[] curr = new int[N];

			curr[0] = b0;
			curr[1] = b1;

			for (int i = 2; i < curr.length - 1; i++) {

				int diff = b[i - 1] - b1;

				if (diff <= 0) {

					j--;
					break;

				} else {
					
					b1 = diff;
					curr[i] = diff;
					

				}

				if (i == curr.length - 2) {
					
					curr[curr.length - 1] = b[i] - diff;

					if (curr[curr.length - 1] > 0) {

						min = curr;
						found = true;

					}

				}

			}

		}

		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		
		for (int i = 0; i < min.length - 1; i++) {
			
			pw.print(min[i] + " ");
			
		}
		
		pw.print(min[min.length - 1]);
		
		pw.close();

	}

}
