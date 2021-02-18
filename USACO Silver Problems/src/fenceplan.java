import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class fenceplan {

	public static HashSet<Integer> visited = new HashSet<Integer>();

	public static Cow[] c;
	public static ConcurrentLinkedQueue<int[]> connections;

	public static int x1;
	public static int y1;

	public static int x2;
	public static int y2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		c = new Cow[N];

		for (int i = 0; i < c.length; i++) {

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			c[i] = new Cow(x, y, i);
			visited.add(i);

		}

		connections = new ConcurrentLinkedQueue<>();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;

			connections.add(new int[] { first, second });			

		}

		br.close();

		int small = Integer.MAX_VALUE;

		while (!visited.isEmpty()) {
			
			int index = visited.iterator().next();

			x1 = c[index].x;
			y1 = c[index].y;
			x2 = c[index].x;
			y2 = c[index].y;

			connect(c[index]);

			small = Math.min(small, 2 * ((y2 - y1) + (x2 - x1)));

		}
		
		PrintWriter pw = new PrintWriter(new File("fenceplan.out"));
		pw.println(small);
		pw.close();

	}


	public static void connect(Cow cow) {

		if (!visited.contains(cow.index))
			return;

		visited.remove(cow.index);

		if (cow.x < x1)
			x1 = cow.x;
		if (cow.x > x2)
			x2 = cow.x;
		if (cow.y < y1)
			y1 = cow.y;
		if (cow.y > y2)
			y2 = cow.y;

		for (int[] a : connections) {
			
			if (a[0] == cow.index) { // Found Match
				
				connections.remove(a);
				connect(c[a[1]]);
				

			} else if (a[1] == cow.index) {
				
				connections.remove(a);
				connect(c[a[0]]);

			}

		}

	}

	static class Cow {
 
		public int x;
		public int y;
		public int index;

		public Cow(int x_, int y_, int index_) {

			this.x = x_;
			this.y = y_;
			this.index = index_;

		}

	}

}
