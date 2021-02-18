package year_2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class greetings {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("greetings.in")); // 
		StringTokenizer st = new StringTokenizer(br.readLine());

		int B = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] bessie = new int[B][2];
		int[][] elsie = new int[E][2];

		for (int i = 0; i < bessie.length; i++) {

			st = new StringTokenizer(br.readLine());
			bessie[i][0] = Integer.parseInt(st.nextToken());

			String dir = st.nextToken();

			if (dir.equals("L")) {

				bessie[i][1] = 1;

			} else {
				
				bessie[i][1] = 0;

			}

		}
		
		for (int i = 0; i < elsie.length; i++) {

			st = new StringTokenizer(br.readLine());
			elsie[i][0] = Integer.parseInt(st.nextToken());

			String dir = st.nextToken();

			if (dir.equals("L")) {

				elsie[i][1] = 1;

			} else {
				
				elsie[i][1] = 0;

			}

		}
		
		br.close();
		
		// Assume speed == 1
		
		int currentBessie = 0;
		int currentElsie = 0;
		
		int count = 0;
		
		for (int i = 0; i < Math.max(bessie.length, elsie.length) - 1; i++) {
			
			if (valid(bessie[i], i)) currentBessie += getChange(bessie[i]);
			if (valid(elsie[i], i)) currentElsie += getChange(bessie[i]);
			
			if (currentBessie == currentElsie) count++;
			
		}
		
		PrintWriter pw = new PrintWriter(new File("greetings.out"));
		pw.println(count - 1);
		pw.close();

	}
	
	static int getChange(int[] array) {
		
		if (array[1] == 0) {
			
			return -1 * array[0];
			
		}
		
		else {
			
			return array[0];
			
		}
		
	}
	
	public static boolean valid(int[] data, int index){
	    return data != null && index >= 0 && index < data.length;
	}

}







