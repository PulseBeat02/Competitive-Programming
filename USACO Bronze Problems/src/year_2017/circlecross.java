package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class circlecross {
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
		
		char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		String line = br.readLine();
		
		br.close();
		
		int count = 0;
		
		for (int i = 0; i < a.length; i++) {
			
			int first = getFirstOccurance(line, a[i]);
			int last = getLastOccurance(line, a[i]);
			
			String between = line.substring(first + 1, last);
			
			for (char c : between.toCharArray()) {
				
				if (!sameLetter(between, c)) count++;
				
			}
			
		}
		
		PrintWriter pw = new PrintWriter(new File("circlecross.out"));
		pw.println(count/2);
		pw.close();
		
	}
	
	public static int getFirstOccurance(String str, char target) {
		
		for (int i = 0; i < str.length(); i++) {
			
			if (str.charAt(i) == target) {
				
				return i;
				
			}
			
		}
		
		return -1;
		
	}
	
	public static int getLastOccurance(String str, char target) {
		
		for (int i = str.length() - 1; i > 0; i--) {
			
			if (str.charAt(i) == target) {
				
				return i;
				
			}
			
		}
		
		return -1;
		
	}
	
	public static boolean sameLetter(String sub, char c) {
		
		int count = 0;
		
		for (int i = 0; i < sub.length(); i++) {
			
			if (sub.charAt(i) == c) {
				
				count++;
				
			}
			
		}
		
		return count == 2;
		
	}

}




