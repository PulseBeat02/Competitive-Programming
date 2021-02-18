import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cowjog {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("cowjog.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] speeds = new int[N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			st.nextToken();

			/*
			 * Position is useless, because a slower cow in front of a faster one will make
			 * the faster cow eventually catch up to the slower cow at some point of time.
			 * Fortunately, this time is unnecessary, so we do not need to read it into our
			 * array. Just the speeds.
			 * 
			 */

			speeds[i] = Integer.parseInt(st.nextToken());

		}

		br.close();

		/*
		 * An easy approach would be to loop through the array N times and do it again
		 * to see if there are any cows that are faster than a slower cow.
		 * Unfortunately, we can't do this because N is equal to 10^5, and the
		 * efficiency of this algorithm is O(N^2), bypassing our billion thumb rule.
		 * However, we can perform an even faster approach by looping backwards,
		 * storing the current slowest cow (which default can be speeds[speeds.length - 1]) 
		 * and then checking if there are any slower cows than the current one. (Because we are
		 * going backwards) This only is O(N) time, so it is very fast, considering 10^5 
		 * calculations is not much to time out any test cases.
		 * 
		 */

		int slowestSpeed = speeds[speeds.length - 1];
		int count = 1;
		
		for (int i = speeds.length - 2; i >= 0; i--) { // Already included first one, go next index back.

			if (speeds[i] <= slowestSpeed) {
				
				count++;
				
			}

			slowestSpeed = Math.min(slowestSpeed, speeds[i]);

		}

		PrintWriter pw = new PrintWriter(new File("cowjog.out"));
		pw.println(count);
		pw.close();

	}

}
