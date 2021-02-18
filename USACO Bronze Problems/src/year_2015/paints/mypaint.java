package year_2015.paints;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class mypaint {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("paint.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		br.close();
		
		int amountPainted = 100;
		
		for (int i = 0; i < 100; i++) {
			
			if (!((i > a && i < b) || (i > c && i < d))) amountPainted--;
			
		}
		
		pw.println(amountPainted + 1);
		pw.close();
		
	}

}
