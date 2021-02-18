package year_2020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class whereami {

	public static void main(String[] args) throws IOException {

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		// new FileReader("whereami.in")
		
		BufferedReader br = new BufferedReader(new FileReader("whereami.in")); 
		
		int N = Integer.parseInt(br.readLine());
		String mailboxes = br.readLine();
		br.close();
		
		int answer = 0;

		//boolean found = false;

		for (int K = 1; K < N; K++) {
			
			boolean stop = false;
			
			if (K == 47) {
				
				System.out.println("d");
				
			}

			for (int i = 0; i < (N - K - 1) && !stop; i++) {

				int repeat = findRepeat(mailboxes.substring(i, i + K), mailboxes);

				if (repeat > 1) {
					
					stop = true;
					
				}

			}
			
			if (!stop) {
				
				answer = K;
				break;
				
			}

		}

		PrintWriter pw = new PrintWriter(new File("whereami.out"));
		pw.println(answer);
		pw.close();

	}

	public static int findRepeat(String s, String original) {


		int count = 0;
		
		for (int i = 0; i < original.length() - s.length(); i++) {
			
			String current = original.substring(i, i + s.length());
			
			if (current.equals(s)) {
				
				count++;
				
			}
			
		}
		
//		Pattern p = Pattern.compile(s);
//		Matcher m = p.matcher(original);
//
//		while (m.find()) {
//
//			count++;
//
//		}

		return count;

	}

}
