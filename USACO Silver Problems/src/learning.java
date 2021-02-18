import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class learning {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("learning.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		Cow[] c = new Cow[N];

		for (int i = 0; i < c.length; i++) {

			st = new StringTokenizer(br.readLine());
			c[i] = new Cow(st.nextToken(), Integer.parseInt(st.nextToken()));

		}

		br.close();

		Arrays.parallelSort(c);

		int count = 0;

		for (int i = 0; i < c.length - 1; i++) {

			// Always include first, not last

			if (c[i].weight >= A && c[i + 1].weight <= B) {

				boolean spot1 = c[i].spotted;
				boolean spot2 = c[i + 1].spotted;

				int mid = (c[i].weight + c[i + 1].weight) / 2;

				if (spot1 && spot2) {

					count += (c[i + 1].weight - c[i].weight);

				} else if (spot1 && !spot2) {

					count += (mid - c[i].weight + 1);

				} else if (!spot1 && spot2) {

					if ((c[i + 1].weight - c[i].weight) % 2 == 0) {

						count += (c[i + 1].weight - mid);

					} else {

						mid++;
						count += (c[i + 1].weight - mid);

					}

				}
				
				if (c[i].weight <= B && c[i + 1].weight > B) {
					
					count++;
					
				}
				
			}
			
		}

//		for (int i = A; i <= B; i++) {
//
//			int min = 1000000000;
//			int index = -1;
//			int tie = -1;
//			
//			for (int j = 0; j < c.length; j++) {
//				
//				if (Math.abs(c[j].weight - i) < min) {
//					
//					min = Math.abs(c[j].weight - i);
//					index = j;
//					tie = -1;
//					
//				} else if (Math.abs(c[j].weight - i) == min) {
//					
//					tie = j;
//					
//				}
//				
//			}
//			
//			if (tie == -1) {
//				
//				if (c[index].spotted) {
//					
//					count++;
//					
//				}
//				
//			} else {
//				
//				if (c[index].spotted || c[tie].spotted) {
//					
//					count++;
//					
//				}
//				
//			}
//			
//		}

		System.out.println(count);

	}

	static class Cow implements Comparable<Cow> {

		public boolean spotted;
		public int weight;

		public Cow(String s, int n) {

			this.spotted = (s.equals("S") ? true : false);
			this.weight = n;

		}

		@Override
		public int compareTo(Cow c) {

			if (this.weight > c.weight) {

				return 1;

			} else if (this.weight < c.weight) {

				return -1;

			} else {

				return 0;

			}
		}

	}

}
