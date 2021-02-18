package algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Basic_Class {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("input.in")); 
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.out"))); 
		StringTokenizer st = new StringTokenizer(br.readLine());

		// int something_here = Integer.parseInt(st.nextToken());

		pw.println("Something Here");
		br.close();
		pw.close();

		/*
		 * BufferedReader br = new BufferedReader(new FileReader("blist.in"));
		 * 
		 * int N = Integer.parseInt(br.readLine()); int[][] arr = new int[N][3]; for
		 * (int i = 0; i < N; i++) { arr[i] =
		 * Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()
		 * ; }
		 */

	}

}
