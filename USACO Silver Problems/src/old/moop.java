package old;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class moop {

	public static Particle[] particles;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("moop.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		particles = new Particle[N];

		for (int i = 0; i < particles.length; i++) {

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			particles[i] = new Particle(x, y);

		}

		br.close();

		// Arrays.parallelSort(particles);

		boolean[] remove = new boolean[N];

		int ans = interact(remove);
		
		PrintWriter pw = new PrintWriter(new File("moop.out"));
		pw.println(ans);
		pw.close();

		//System.out.println(ans);

	}

	public static int interact(boolean[] rem) {

		int output = Integer.MAX_VALUE;
		boolean overlap = false;

		for (int i = 0; i < particles.length; i++) {

			if (!rem[i]) {

				for (int j = i + 1; j < particles.length; j++) {

					if (!rem[j]) {

						if ((particles[i].x <= particles[j].x && particles[i].y <= particles[j].y)
								|| (particles[i].x >= particles[j].x && particles[i].y >= particles[j].y)) {
							overlap = true;
							rem[i] = true; // remove i
							int out1 = interact(rem);
							rem[i] = false;
							rem[j] = true; // remove j
							int out2 = interact(rem);
							output = Math.min(output, Math.min(out1, out2));
						}

					}

				}

			}
		}

		if (!overlap) {
			int tmp = 0;
			for (int i = 0; i < particles.length; i++) {

				if (!rem[i]) {
					tmp++;
				}
			}
			output = tmp;
		}
		return output;
	}

	static class Particle implements Comparable<Particle> {

		public int x;
		public int y;

		public Particle(int x_, int y_) {

			this.x = x_;
			this.y = y_;

		}

		@Override
		public int compareTo(Particle p) {

			if (this.x < p.x)
				return -1;
			else if (this.x > p.x)
				return 1;
			else {

				if (this.y > p.y)
					return 1;
				if (this.y < p.y)
					return -1;

				return 0;

			}

		}
	}

}
