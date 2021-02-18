import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swap {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] shift1 = new int[2];
		shift1[0] = Integer.parseInt(st.nextToken());
		shift1[1] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] shift2 = new int[2];
		shift2[0] = Integer.parseInt(st.nextToken());
		shift2[1] = Integer.parseInt(st.nextToken());
		
		br.close();

		int[] cows = new int[N + 1];
		int[] orig = new int[N + 1];

		for (int i = 1; i <= N; i++) {

			cows[i] = i;
			orig[i] = i;

		}
		
		int count = K;
		
		for (int i = 0; i < K; i++) {
			
			reverse(cows, shift1);
			reverse(cows, shift2);
			
			if (Arrays.equals(cows, orig)) {
				
				count = (i + 1);
				break;
				
			}
			
			
		}
		
		if (count < K) {
			
			count = (K % count);
			
			while (count > 0)  {
				
				reverse(cows, shift1);
				reverse(cows, shift2);
				count--;
				
			}
			
		}
		
		PrintWriter pw = new PrintWriter(new File("swap.out"));
		
		for (int c = 1; c < cows.length; c++) {
			
			pw.println(cows[c]);
			
		}
		
		pw.close();

	}

	public static int[] reverse(int[] cows, int[] swaps) {

		for (int i = 0; i < (swaps[1] - swaps[0] + 1)/2; i++) {
			
			int tmp = cows[swaps[0] + i];
			
			cows[swaps[0] + i] = cows[swaps[1] - i];
			cows[swaps[1] - i] = tmp;
			
			
		}
		
		return cows;

	}

}


