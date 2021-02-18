import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class berries {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("berries.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] trees = new int[N];
		int maxB = 0;
		
		/*
		 * 
		 * Berries in Tree ---> Index
		 * 
		 */
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int next = trees[i];
			trees[i] = next;
			maxB = Math.max(maxB, next);
		}
		br.close();
		
		int max = 0;
		for (int q = 1; q <= maxB; q++) {
			
			int[] chunks = new int[N];
			for (int i = 0; i <= q; i++) {
				chunks[i] = 0;
			}
			
			for (int i = 0; i < N; i++) {
				chunks[q] += trees[i]/q;
				chunks[trees[i] % q]++;
			}
			
			if (chunks[q] < K/2) {
				continue;
			}
			
			chunks[q] -= K/2;
			int given = 0;
			int curr = q;
			int total = 0;
			while(curr > 0 && given < K/2) {
				if (chunks[curr] > 0) {
					given++;
					total += curr;
					chunks[curr]--;
				} else {
					curr--;
				}
			}
			
			if (given == K/2) {
				max = Math.max(max, total);
			}
			
		}
		System.out.println(max);

	}

}














