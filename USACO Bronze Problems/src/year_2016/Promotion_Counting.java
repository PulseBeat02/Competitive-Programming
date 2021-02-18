package year_2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Promotion_Counting {
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("promote.in"));
		PrintWriter pw = new PrintWriter(new File("promote.out"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		st.nextToken();
		
		st = new StringTokenizer(br.readLine());
		int silverBefore = Integer.parseInt(st.nextToken());
		int silverAfter = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int goldBefore = Integer.parseInt(st.nextToken());
		int goldAfter = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int platinumBefore = Integer.parseInt(st.nextToken());
		int platinumAfter = Integer.parseInt(st.nextToken());
		
		br.close();

		int goldToPlatinum = platinumAfter - platinumBefore;
		int silverToGold = goldAfter - goldBefore + goldToPlatinum;
		int bronzeToSilver = silverAfter - silverBefore + silverToGold;

		pw.println(bronzeToSilver);
		pw.println(silverToGold);
		pw.println(goldToPlatinum);
		
		// close output stream
		pw.close();
		
	}

}
