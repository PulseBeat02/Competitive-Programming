package year_2011;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class digits {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("digits.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String num1 = st.nextToken();

		st = new StringTokenizer(br.readLine());

		String num2 = st.nextToken();

		br.close();

		String answer = "";

		for (int i = 0; i < num1.length(); i++) {

			char[] temp = num1.toCharArray();

			if (temp[i] == '0') {
				
				temp[i] = '1';
				
			}
			
			else {
				
				temp[i] = '0';
				
			}
			
			String newString = Integer.toString(Integer.parseInt(new String(temp), 2), 3);
			
			int differences = 0;
			
			for (int j = 0; j < newString.length(); j++) {
				
				if (newString.charAt(j) != num2.charAt(j)) differences++;
				
			}
			
			if (differences == 1) {
				
				answer = Integer.toString(Integer.parseInt(newString, 3), 10);
				break;
				
			}
			

		}
		
		PrintWriter pw = new PrintWriter(new File("digits.out"));
		pw.println(answer);
		pw.close();

	}
	
}



