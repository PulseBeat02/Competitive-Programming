import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class skyline {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("skyline.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] heights = new int[N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			int in = Integer.parseInt(st.nextToken());
			heights[i] = in;

		}
		
		br.close();

		int left = 0;
		
		int windowTotal = 0;

		// how much height is in the window?
		for (int x = 0; x < B; x++) {
			windowTotal += heights[x];
		}
		
		// 480

		int sum = windowTotal; // max amount of average height in any way
		
		// 120
		
		double middle = B/2;
		
		// SLIDE THE WINDOW

		// express the idea of "getting the window to touch the right side" in loop
		
		while (left + B < N) {

			// adjust windowTotal
			windowTotal -= heights[left];
			left++;
			windowTotal += heights[left + B - 1];

			// maximize result based on this newest windowTotal
			
			if (windowTotal > sum) {
				
				sum = windowTotal;
				middle = (double)((left + 1) + (left + B))/2;
				
			}

		}
		
		System.out.println(middle + " " + (double)sum/B);
		PrintWriter pw = new PrintWriter(new File("skyline.out"));
		pw.println(middle + " " + (double)sum/B);
		pw.close();

	}

}

/*
 * ANALYSIS
 * 
 * 6 4 <--- N Total Buildings (1000000) B Total Per Photo 100 <--- Tower #1 200
 * <--- Tower #2 120 <---- Tower... 60 100 220
 * 
 * Sliding Window (Without Coordinate Compression)
 * 
 * Read Data (I/O Streams) (1 Million)
 * 
 * |-| = 10 100 60 100 120 200 220 |----| |----| |----| |----| |----| |----|
 * |----| ...
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
