package retry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class maxcross {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Boolean> walks = new HashMap<>();

		for (int i = 0; i < B; i++) {

			walks.put(Integer.parseInt(new StringTokenizer(br.readLine()).nextToken()), true);

		}

		br.close();

		int minFix = N;
		
		for (int i : walks.keySet()) {

			int count = 0;

			int left = i;
			int right = i + K - 1;
			
			if (right > N) {
				
				break;
				
			}

			for (int j = left; j <= right; j++) {
				
				// Between Left and Right, check if there are lanterns
				
				if (walks.containsKey(j)) {

					count++;

				}

			}

			if (count < minFix) {

				minFix = count;

			}

		}
		
		PrintWriter pw = new PrintWriter(new File("maxcross.out"));
		pw.println(minFix);
		pw.close();
		
	}

}
