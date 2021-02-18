package year_2017;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Blocked_Billboard {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int[] rect1 = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		int[] rect2 = { Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()),
				Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()) };
		int[] truck = { Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()),
				Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()) };

		br.close();

		int areaRect1 = area(rect1);
		int areaRect2 = area(rect2);
		
		int visibleArea = 0;
		
//		if (isOverlapping(rect1, truck)) {
			
			visibleArea += (areaRect1 - overlappingArea(rect1, truck));
			
//		}
//		
//		if (isOverlapping(rect2, truck)) {
			
			visibleArea += (areaRect2 - overlappingArea(rect2, truck));
			
//		}
//		
//		if (visibleArea == 0) {
			
			visibleArea += (areaRect1 + areaRect2);
			
		//}

		pw.println(visibleArea);

		pw.close();

	}

	public static int area(int[] rect) {

		int x1 = rect[0];
		int y1 = rect[1];

		int x2 = rect[2];
		int y2 = rect[3];

		int width = y2 - y1;
		int length = x2 - x1;

		return width * length;

	}

	public static int overlappingArea(int[] rect1, int[] rect2) {

		int x1_1 = rect1[0]; // X of Bottom Left Rect 1
		int y1_1 = rect1[1]; // Y of Bottom Left Rect 1

		int x2_1 = rect1[2]; // X of Top Right Rect 1
		int y2_1 = rect1[3]; // Y of Top Right Rect 1

		int x1_2 = rect2[0]; // X of Bottom Left Rect 2
		int y1_2 = rect2[1]; // Y of Bottom Left Rect 2

		int x2_2 = rect2[2]; // X of Top Right Rect 2
		int y2_2 = rect2[3]; // Y of Top Right Rect 2

		int intersectingArea = (Math.min(x2_1, x2_2) - Math.max(x1_1, x1_2))
				* (Math.min(y2_1, y2_2) - Math.max(y1_1, y1_2));

		return intersectingArea;

	}

	public static boolean isOverlapping(int[] rect1, int[] rect2) {

		int x1_1 = rect1[0]; // X of Bottom Left Rect 1
		int y1_1 = rect1[1]; // Y of Bottom Left Rect 1

		int x2_1 = rect1[2]; // X of Top Right Rect 1
		int y2_1 = rect1[3]; // Y of Top Right Rect 1

		int x1_2 = rect2[0]; // X of Bottom Left Rect 2
		int y1_2 = rect2[1]; // Y of Bottom Left Rect 2

		int x2_2 = rect2[2]; // X of Top Right Rect 2
		int y2_2 = rect2[3]; // Y of Top Right Rect 2

		if (x1_1 > x2_2 || x1_2 > x2_1) {
			return false;
		}

		if (y1_1 < y2_2 || y1_2 < y2_1) {
			return false;
		}

		return true;

	}

}
