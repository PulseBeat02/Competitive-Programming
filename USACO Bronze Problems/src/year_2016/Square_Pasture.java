package year_2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Square_Pasture {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Rectangle #1: (6, 6) and (8,8)
		// Rectangle #2: (1, 8) and (4, 9)
		// Find Smallest Square that Covers Both Areas
		
		// X1 = 6, Y1 = 6
		// X2 = 8, Y2 = 9
		
		// Algorithm:
		// Read File
		// Store Variables as an Integer Array.
		// Find The Coordinate Closest to the Y axis. (Yclose)
		// Find the Coordinate Farthest to the Y axis. (Yfar)
		// Find the X difference between these two coordinates. This will represent a side of the square. (Label as posside1)
		// Find the Coordinate Closest to the X axis. (Xclose)
		// Find the Coordinate Farthest to the X axis. (Xfar)
		// Find the Y difference between these two coordinates. This will also represent a side of the square. (Label as posside2)
		// Find the greatest of posside1 and posside2 (Label as GreatestPosside)
		// System.out.println(Math.pow(GreatestPosside, 2));
		
		BufferedReader br = new BufferedReader(new FileReader("square.in")); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\square.in
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out"))); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\square.out
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int SQ1X1 = Integer.parseInt(st.nextToken());
		int SQ1Y1 = Integer.parseInt(st.nextToken());
		int SQ1X2 = Integer.parseInt(st.nextToken());
		int SQ1Y2 = Integer.parseInt(st.nextToken());
		int SQ2X1 = Integer.parseInt(st1.nextToken());
		int SQ2Y1 = Integer.parseInt(st1.nextToken());
		int SQ2X2 = Integer.parseInt(st1.nextToken());
		int SQ2Y2 = Integer.parseInt(st1.nextToken());
		
		int Yclose = Math.max(SQ2X2, Math.max(SQ2X1, Math.max(SQ1X2, SQ1X1)));
		int Yfar = Math.min(SQ2X2, Math.min(SQ2X1, Math.min(SQ1X2, SQ1X1)));
		int posside1 = Math.abs(Yclose - Yfar);
		
		int Xclose = Math.max(SQ2Y2, Math.max(SQ2Y1, Math.max(SQ1Y2, SQ1Y1)));
		int Xfar = Math.min(SQ2Y2, Math.min(SQ2Y1, Math.min(SQ1Y2, SQ1Y1)));
		int posside2 = Math.abs(Xclose - Xfar);
		
		int GreatestPosside = Math.max(posside1, posside2);
		
		//System.out.println((int)Math.pow(GreatestPosside, 2));
		pw.println((int)Math.pow(GreatestPosside, 2));
		
		br.close();
		pw.close();
		
	}

}
