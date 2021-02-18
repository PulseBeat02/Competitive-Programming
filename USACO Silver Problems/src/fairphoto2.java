import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fairphoto2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("fairphoto.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Cow[] cows = new Cow[N];

		int[] photo = new int[N];

		for (int i = 0; i < cows.length; i++) {
			
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String b = st.nextToken();

			if (b.equals("G")) {
				
				photo[i] = 1;
				
			} else {
				
				photo[i] = -1;
				
			}

			Cow c = new Cow(num, b);
			cows[i] = c;

		}
		
		br.close();
		
		Arrays.parallelSort(cows);
		
		PrintWriter pw = new PrintWriter(new File("fairphoto.out"));
		pw.println(Math.max(Math.max(sameBreed(cows, N, 'G'), sameBreed(cows, N, 'H')), bothBreeds(cows, N)));
		pw.close();
		
	}

	public static int sameBreed(Cow[] cows, int n, char value) {

		int start = -1;
		int max = 0;

		for (int i = 0; i < n; i++) {

			if (cows[i].breed != value) {
				start = -1;
				continue;
			}

			if (start == -1) {
				start = i;
			}

			else {
				max = Math.max(max, cows[i].x - cows[start].x);
			}
		}

		return max;
	}

	public static int bothBreeds(Cow[] myCows, int n) {

		int[] cumfreq = new int[n + 1];
		cumfreq[0] = n;
		for (int i = 1; i <= n; i++)
			cumfreq[i] = cumfreq[i - 1] + (myCows[i - 1].breed == 'G' ? 1 : -1);

		int[] min = new int[2 * n + 1];
		int[] max = new int[2 * n + 1];
		
		Arrays.fill(min, -1);
		Arrays.fill(max, -1);

		for (int i = 0; i <= n; i++)
			if (min[cumfreq[i]] == -1)
				min[cumfreq[i]] = i;

		for (int i = n; i >= 0; i--)
			if (max[cumfreq[i]] == -1)
				max[cumfreq[i]] = i;

		int best = 0;
		for (int i = 0; i <= 2 * n; i++)
			if (max[i] != -1 && min[i] < max[i])
				best = Math.max(best, myCows[max[i] - 1].x - myCows[min[i]].x);

		return best;
	}

	static class Cow implements Comparable<Cow> {

		char breed;
		int x; // index

		Cow(int x, String breed) {
			this.x = x;
			this.breed = breed.charAt(0);
		}

		public int compareTo(Cow other) {
			return this.x - other.x;
		}
	}

}
