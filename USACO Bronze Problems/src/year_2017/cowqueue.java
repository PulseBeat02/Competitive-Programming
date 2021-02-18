package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class cowqueue {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] array =  new int[N][2];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());

		}
		
		Arrays.sort(array, Comparator.comparingInt(a -> a[0]));

		br.close();
		
		int previousTime = 0;

		for (int i = 0; i < array.length; i++) { 
			
			int time = array[i][1];
			
			if (previousTime < array[i][0]) {
				
				previousTime = (array[i][0] + time);
				
			}
			
			else {
				
				previousTime += time;
				
			}
			
			
		}

		
		PrintWriter pw = new PrintWriter(new File("cowqueue.out"));
		pw.println(previousTime);
		pw.close();

	}

}

