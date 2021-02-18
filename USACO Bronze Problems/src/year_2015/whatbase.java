package year_2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class whatbase {

	public static void main(String[] args) throws IOException {

		// Do Separate for One Way and Two Way

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("whatbase.in")
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());

		String[][] numbers = new String[K][2];

		for (int i = 0; i < numbers.length; i++) {

			st = new StringTokenizer(br.readLine());
			numbers[i][0] = st.nextToken();
			numbers[i][1] = st.nextToken();

		}

		br.close();

		int[][] answers = new int[K][2];
		int [][] first = new int[K][15001];

		for (int j = 10; j < 15001; j++) {
			
			for (int k = 0; k < K; k++) {
				
				first[j][k] = convertToBase10(numbers[j][k], j);
				
			}

		}
		
		for (int i = 0; i < first.length; i++) {
			
			
			
		}

		System.out.print(Arrays.deepToString(answers));

	}

	public static int convertToBase10(String num, int base) {
		
		int result = 1; //num.charAt(num.length() - 1) - '0';
		int factor = 1;
		
		for (int i = num.length(); i > 0; i--) {
			

			result += (num.charAt(i - 1) - '0') * factor;
			factor *= base;
			
		}
		
		return result;

	}

}















