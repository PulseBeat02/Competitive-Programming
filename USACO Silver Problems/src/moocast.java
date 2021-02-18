import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class moocast {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new File("moocast.out"));

		int n = Integer.parseInt(br.readLine());

		int[] x = new int[n];
		int[] y = new int[n];
		int[] p = new int[n];

		for (int i = 0; i < n; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());

		}

		br.close();

		boolean[][] canTransmit = new boolean[n][n];

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				int squareDist = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);

				if (squareDist <= p[i] * p[i]) {
					canTransmit[i][j] = true;
				}

			}

		}

		int ret = 1;
		for (int i = 0; i < n; i++) {
			boolean[] canHear = new boolean[n];
			ret = Math.max(ret, search(i, canHear, canTransmit));
		}

		pw.println(ret);
		pw.close();
	}

	public static int search(int curr, boolean[] canHear, boolean[][] canTransmit) {
		if (canHear[curr]) {
			return 0;
		}
		canHear[curr] = true;
		int ret = 1;
		for (int i = 0; i < canTransmit[curr].length; i++) {
			if (canTransmit[curr][i]) {
				ret += search(i, canHear, canTransmit);
			}
		}
		return ret;
	}
}
