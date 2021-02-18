package year_2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class typo {
	
	static char[] typos;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 
		
		typos = br.readLine().toCharArray();
		br.close();
		
		//char[] temp = new char[typos.length];
		
		int answer = 0;
		
		for (int i = 0; i < typos.length; i++) {
			
			if (typos[i] == '(') {
				
				typos[i] = ')';
				
			} else {
				
				typos[i] = '(';
				
			}
			
			if (isBal()) answer++;
			
			if (typos[i] == '(') {
				
				typos[i] = ')';
				
			} else {
				
				typos[i] = '(';
				
			}
			
		}
		
		PrintWriter pw = new PrintWriter(new File("typo.out"));
		//pw.println(answer);
		System.out.println(answer);
		pw.close();

	}
	
	public static boolean isBal() {
		
		int d = 0;
		
		for (int i = 0; i < typos.length; i++) {
			
			if (typos[i] == '(') {

				d++;
				
			} else {
				
				d--;

			}
			
			if (d < 0) {

				return false;
				
			}
			
		}
		
		return d == 0;
		
	}

}
