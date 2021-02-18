package year_2015.whatbasep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class whatbase2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("whatbase.in"));
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

		for (int i = 0; i < numbers.length; i++) {
			
			int X = 10;
			int Y = 10;

			for (int j = 0; j < 15000 * 2; j++) {

				long finalX = convertToBase(numbers[i][0], X);
				long finalY = convertToBase(numbers[i][1], Y);

				if (finalX > finalY) {

					Y++;

				}

				else if (finalY > finalX) {

					X++;

				}

				else {

					answers[i][0] = X;
					answers[i][1] = Y;
					break;

				}

			}

		}
		
		PrintWriter pw = new PrintWriter("whatbase.out");
		
		for (int i = 0; i < answers.length; i++) {
			
			pw.println(answers[i][0] + " " + answers[i][1]);
			
		}
		
		pw.close();

	}

	public static long convertToBase(String num, int base) {

		long result = 0; // num.charAt(num.length() - 1) - '0';
		long factor = 1;

		for (int i = num.length() - 1; i >= 0; i--) {

			result += (num.charAt(i) - '0') * factor;
			factor *= base;

		}

		return result;

	}

}
