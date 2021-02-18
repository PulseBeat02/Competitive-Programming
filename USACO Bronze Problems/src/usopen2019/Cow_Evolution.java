package usopen2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cow_Evolution {
	
	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("input.in")); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\input.in
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.out"))); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\output.out
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int something_here = Integer.parseInt(st.nextToken());
		
		pw.println("Something Here");
		br.close();
		pw.close();

	}

}
