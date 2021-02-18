import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.IntBinaryOperator;

public class maxcross {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] walks = new int[N];

		for (int i = 0; i < B; i++) {
			
			walks[Integer.parseInt(new StringTokenizer(br.readLine()).nextToken()) - 1] = 1;

		}
		
		IntBinaryOperator op = (x1, x2) -> x1 + x2;
		Arrays.parallelPrefix(walks, op);
		
		br.close();
		
		int minFix = N;

		for (int i = 0; i < walks.length; i++) {

			int left = i;
			int right = i + K - 1;
			
			if (right >= N) {
				
				break;
				
			}

			if (walks[right] - walks[left] < minFix) {
				
				minFix = walks[right] - walks[left];
				
			}

		}
		
		PrintWriter pw = new PrintWriter(new File("maxcross.out"));
		pw.print(minFix);
		pw.close();
		
	}

}
