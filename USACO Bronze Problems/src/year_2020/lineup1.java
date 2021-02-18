package year_2020;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class lineup1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("lineup.in")); // new InputStreamReader(System.in)

		int N = Integer.parseInt(br.readLine());

		String[][] constraints = new String[N][2];

		for (int i = 0; i < constraints.length; i++) {

			String[] besides = br.readLine().split(" ");

			constraints[i] = new String[] { besides[0], besides[5] };

		}
		
		br.close();

		String[] cows = { "Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue" };
		
		ArrayList<String[]> possibleComb = new ArrayList<String[]>();
		
		for (int i = 0; i < constraints.length; i++) {
			
			String const1 = constraints[i][0];
			String const2 = constraints[i][1];
			
			int index1 = Arrays.binarySearch(cows, const1);
			int index2 = Arrays.binarySearch(cows, const2);
			
			
			
		}
		

	}
	
}







