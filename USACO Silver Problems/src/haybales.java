import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class haybales {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] bales = new int[100000];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			bales[Integer.parseInt(st.nextToken())] = 1;

		}

		Arrays.parallelPrefix(bales, (x, y) -> (x + y));

		PrintWriter pw = new PrintWriter(new File("haybales.out"));
		for (int i = 0; i < Q; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			if (a == b) {

				pw.println(0);

			} else if (b - a > 0) {

				pw.println(bales[b] - bales[a] + 1);

			}

		}

		br.close();
		pw.close();

	}

}
