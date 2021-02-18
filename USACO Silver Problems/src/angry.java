import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class angry {

	public static boolean[] explode;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("moop.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] bales = new int[N];

		for (int i = 0; i < bales.length; i++) {

			st = new StringTokenizer(br.readLine());
			bales[i] = Integer.parseInt(st.nextToken());

		}

		br.close();

		explode = new boolean[N];

		Arrays.parallelSort(bales);

		int left = 0; // We know this DOES NOT work.
		int right = bales[N - 1] - bales[0]; // We know this DOES work.

		while (right - left > 1) {

			int m = (left + right) / 2;

			int used = 0;
			int last = 0;

			while (last < N) {
				
				used++;
	
				int c = last + 1;
				
				while (c < bales.length && bales[c] - bales[last] <= 2 * m) {
					
					c++;
					
				}
				
				last = c;
				
			}

			if (used <= K) {

				right = m;

			} else {

				left = m;

			}

		}
		
	    PrintWriter out = new PrintWriter(new File("angry.out"));
	    System.out.println(right);
	    out.println(right);
	    out.close();

	}

}
