import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class helpcross {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		ArrayList<Integer> c = new ArrayList<>(C);
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			c.add(Integer.parseInt(st.nextToken()));
		}

		int[][] cows = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
		}

		br.close();

		Arrays.sort(cows, Comparator.comparingInt(o -> o[0]));
		
		int count = 0;
		
		for (int i = 0; i < cows.length; i++) {
			
			for (int j = 0; j < c.size(); j++) {

				if (cows[i][0] <= c.get(j) && c.get(j) <= cows[i][1]) {
					
					c.remove(j);
					count++;
					break;
					
				}

			}

		}
		
		PrintWriter pw = new PrintWriter(new File("helpcross.out"));
		pw.println(count);
		pw.close();

	}

}
