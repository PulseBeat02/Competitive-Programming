/*
ID: brandon66
LANG: JAVA
TASK: palsquare
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class palsquare {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));

		int B = Integer.parseInt(br.readLine());

		br.close();

		PrintWriter pw = new PrintWriter(new File("palsquare.out"));
		
		for (int i = 1; i <= 300; i++) {
			
			String s = (int)Math.pow(i, 2) + "";
			String baseStr = Integer.toString(Integer.parseInt(s, 10), B);
			
			if (isPalindrome(baseStr)) {
				
				//System.out.println(Integer.toString(Integer.parseInt(i + "", 10), B) + " " + baseStr);
				pw.println(Integer.toString(Integer.parseInt(i + "", 10), B).toUpperCase() + " " + baseStr.toUpperCase());
				
			}
			
		}
		
		pw.close();

	}

	public static boolean isPalindrome(String str) {

		for (int beginIndex = 0; beginIndex < str.length(); beginIndex++) {
			if (str.charAt(beginIndex) != str.charAt(str.length() - 1 - beginIndex)) {
				return false;
			}
		}

		return true;

	}

}
