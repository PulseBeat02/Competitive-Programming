package year_2018;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class billboard {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());

		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int cx1 = Integer.parseInt(st.nextToken());
		int cy1 = Integer.parseInt(st.nextToken());

		int cx2 = Integer.parseInt(st.nextToken());
		int cy2 = Integer.parseInt(st.nextToken());
		
		br.close();

		// Cases:
		// No Corners Covered
		// One Corner Covered
		// Two Corners Covered
		
		int answer = 0;
		
		int corners = 0;
		
		if (isCovered(x1, y1, cx1, cy1, cx2, cy2)) corners++;
		if (isCovered(x1, y2, cx1, cy1, cx2, cy2)) corners++;
		if (isCovered(x2, y1, cx1, cy1, cx2, cy2)) corners++;
		if (isCovered(x2, y2, cx1, cy1, cx2, cy2)) corners++;
		
		if (corners == 4) {
			
			answer = Math.abs(((cx2 - cx1) * (cy2 - cy1)));
			
		}
		
		else if (corners < 2) {
			
			answer = Math.abs((x2 - x1) * (y2 - y1));
			
		}
		
		else {
			
			int topLeft = Math.max(x1, cx1);
			int topRight = Math.min(x1, cx2);
			int bottomLeft = Math.max(y1, cy1);
			int bottomRight = Math.min(y2, cy2);
			
			answer = Math.abs((x2 - x1) * (y2 - y1) - (topRight - topLeft) * (bottomRight * bottomLeft));
			
		}
		
		PrintWriter pw = new PrintWriter(new File("billboard.in"));
		pw.println(answer);
		pw.close();

	}

	public static boolean isCovered(int x, int y, int x1, int y1, int x2, int y2) {

		return x >= x1 && x <= x2 && y >= y1 && y <= y2;

	}

}
