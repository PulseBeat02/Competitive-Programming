import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class milk {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("milk.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Farmer[] farmers = new Farmer[M];

		for (int i = 0; i < farmers.length; i++) {

			st = new StringTokenizer(br.readLine());
			farmers[i] = new Farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		}
		br.close();

		Arrays.parallelSort(farmers);

		int count = 0;
		int total = N;
		int i = 0;

		while (total > 0) {

			if (i >= farmers.length) {

				count += farmers[farmers.length - 1].amount;
				break;

			}

			if (total - farmers[i].amount < 0) {

				i++;

			} else {

				total -= farmers[i].amount;
				
				
				count += farmers[i].cents;

			}

		}

		System.out.println(count);

	}

	static class Farmer implements Comparable<Farmer> {

		public int cents;
		public int amount;
		public boolean soldOut;

		public Farmer(int c, int a) {

			this.cents = c;
			this.amount = a;
			this.soldOut = false;
			
		}

		@Override
		public int compareTo(Farmer arg0) {
			// TODO Auto-generated method stub
			if (this.cents > arg0.cents)
				return 1;
			else if (this.cents < arg0.cents)
				return -1;
			else
				return 0;
		}

	}

}
