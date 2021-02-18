import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cereal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("cereal.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] f = new int[N];
		int[] s = new int[N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			f[i] = Integer.parseInt(st.nextToken()) - 1;
			s[i] = Integer.parseInt(st.nextToken()) - 1;

		}

		br.close();

		boolean[] c = new boolean[M];

		int[] count = new int[N];

		for (int i = 0; i < N; i++) {

			Arrays.fill(c, false);
			
			for (int j = i; j < N; j++) {

				if (!c[f[j]]) {

					c[f[j]] = true;
					count[i]++;

				} else if (!c[s[j]]) {

					c[s[j]] = true;
					count[i]++;

				}

			}


		}

		PrintWriter pw = new PrintWriter(new File("cereal.out"));

		for (int a : count) {

			pw.println(a);

		}

		pw.close();

	}

}
