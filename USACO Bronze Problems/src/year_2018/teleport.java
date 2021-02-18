package year_2018;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class teleport {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		br.close();
		
		int answer = Math.abs(a - b); // no teleport
		answer = Math.min(answer, Math.abs(a - x) + Math.abs(b - y));
		answer = Math.min(answer, Math.abs(a - y) + Math.abs(b - x));
		
		PrintWriter pw = new PrintWriter(new File("teleport.out"));
		pw.println(answer);
		pw.close();

	}

}
