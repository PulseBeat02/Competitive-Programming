import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class shuffle {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] shuffles = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < shuffles.length; i++) {

			shuffles[i] = Integer.parseInt(st.nextToken());

		}

		br.close();

		HashSet<Integer> rep = new HashSet<>();

		int[] states = new int[N];
		Arrays.fill(states, -1);

		// 4 Possible States

		// -1 ---> Not Met
		// 0 ---> Met/No Repeat
		// 1 ---> Met/Cycle

		for (int i = 0; i < N; i++) {

			if (states[i] == -1) {

				while (states[i] == -1) {

					rep.add(i);
					states[i] = 0;
					i = shuffles[i] - 1;

				}

				if (rep.contains(i)) {

					int temp = i;

					while (true) {

						states[i] = 1;
						i = shuffles[i] - 1;

						if (i == temp) {

							break;

						}

					}

				}
				
				rep.clear();

			}

		}
		
		int count = 0;
		for (int i = 0; i < states.length; i++) {
			if (states[i] == 1) {
				count++;
			}
		}
		
		
		PrintWriter pw = new PrintWriter(new File("shuffle.out"));
		pw.println(count);
		pw.close();

	}

}
