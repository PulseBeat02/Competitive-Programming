/*
ID: brandon66
LANG: JAVA
TASK: milk2
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class milk2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Point[] times = new Point[N];

		for (int i = 0; i < times.length; i++) {

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			times[i] = new Point(x, y);
		}
		
		br.close();

		Arrays.parallelSort(times);

		int begin = times[0].x;
		int end = times[0].y;
		int milktime = times[0].y - times[0].x;
		int stopping = 0;

		for (int i = 1; i < times.length; i++) {
			if (end >= times[i].x && end <= times[i].y) {
				end = times[i].y;
			}

			milktime = Math.max(end - begin, milktime);

			if (times[i].x > end) {

				milktime = Math.max(end - begin, milktime);
				stopping = Math.max(stopping, times[i].x - end);

				begin = times[i].x;
				end = times[i].y;

			}

		}

		PrintWriter pw = new PrintWriter(new File("milk2.out"));
		pw.println(milktime + " " + stopping);
		pw.close();

	}

}

class Point implements Comparable<Point> {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		Integer a = this.x;
		Integer b = o.x;
		return a.compareTo(b);
	}

}
