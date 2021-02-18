package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cowtip2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("cowtip.in")
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		boolean[][] values = new boolean[N][N];

		for (int i = 0; i < values.length; i++) {

			st = new StringTokenizer(br.readLine());

			String line = st.nextToken();
			
			System.out.println("Value of i: " + i + " ---> " + line);
			
			for (int j = 0; j < line.length(); j++) {
				
				if (line.charAt(i) == 1) {

					values[i][j] = true;

				}
				
			}
		}

		br.close();
		
		System.out.println(Arrays.deepToString(values));
		
		int count = 0;
		
		int[] largest = largestIndex(values);
		
		while(largest[0] != - 1) {
			
			flip(values, largest);
			count++;
			largest = largestIndex(values);
			
		}
		
		PrintWriter pw = new PrintWriter(new File("cowtip.out"));
		//pw.println(count);
		System.out.println(count);
		
		pw.close();

	}

	public static int[] largestIndex(boolean[][] array) {

		int[] max = { -1, -1 };

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[i].length; j++) {

				if (array[i][j]) {

					if (i > max[0])
						max[0] = i;
					if (j > max[1])
						max[1] = j;

				}

			}

		}
		
		System.out.println("Largest Index: " + Arrays.toString(max));

		return max;

	}

	public static boolean[][] flip(boolean[][] array, int[] max) {
		
		for (int i = 0; i < max[0]; i++) {
			
			for (int j = 0; j < max[1]; j++) {
				
				array[i][j] = !array[i][j];
				
			}
			
		}
		
		return array;

	}

}




