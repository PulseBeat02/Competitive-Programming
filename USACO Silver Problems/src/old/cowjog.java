package old;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cowjog {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cowjog.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		Pair[] cows = new Pair[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		br.close();

		/*
		 * Algorithm is simple. If a cow's position is less than another cow's position
		 * and has a higher speed, that means that eventually at some point of time, the
		 * faster cow will catch up to the slower cow.
		 * 
		 */

		Arrays.parallelSort(cows);

		int count = 0;
		int currentPos = -1;
		for (int i = 0; i < cows.length; i++) {
			if (cows[i].pos > currentPos) {
				currentPos = cows[i].pos;
				count++;
			}
		}

		PrintWriter pw = new PrintWriter(new File("cowjog.out"));
		pw.println(count);
		pw.close();

	}

}

class Pair implements Comparable<Pair> {
	int pos;
	int speed;

	public Pair(int p, int s) {
		this.pos = p;
		this.speed = s;
	}

	@Override
	public int compareTo(Pair other) {
		return this.pos - other.pos;
	}
}
