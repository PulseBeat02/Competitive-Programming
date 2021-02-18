package year_2014.odo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class odometer {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("odemeter.in")
		StringTokenizer st = new StringTokenizer(br.readLine());

		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());

		int count = 0;

		for (int i = first; i <= second; i++) {

			if (isInteresting(i)) {
				count++;
				
				System.out.println(i);

			}

		}

		System.out.println(count);

		PrintWriter pw = new PrintWriter(new File("odemeter.out"));
		// pw.println(count);
		pw.close();

	}

	public static boolean isInteresting(int num) {

		String number = String.valueOf(num);
		
		int differences = 0;
		
		for (int i = 0; i < number.length() - 1; i++) {

			if (number.charAt(i) != '0' && number.charAt(i) != number.charAt(i + 1)) {

				differences++; // 11210, 21110

			}

		}
		
		return differences == 1 || differences == 2;

	}

}
