import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class moop {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Point[] points = new Point[N];
		for (int i = 0; i < points.length; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(points, );
		Map<Point, Set<Point>> possible = new IdentityHashMap<>();
		
	}
	
	private static class Point {
		public final int x;
		public final int y;
		public final boolean used;
		public Point(final int x, final int y) {
			this.x = x;
			this.y = y;
			this.used = false;
		}
		
	}

}
