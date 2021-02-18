package year_2017;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class The_Lost_Cow {
	
public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
//		
//		int farmer = Integer.parseInt(st.nextToken());
//		int cow = Integer.parseInt(st.nextToken());
//		int distance_to_cow = Math.abs(farmer - cow);
//		int distance_total = 0;
//		int moving_distance = 0;
//		
//		search: {
//		
//		for (int i = 0; i <= 50; i++) {
//			
//			if (distance_to_cow == 0) {
//				
//				distance_total = 0;
//				
//				break search;
//				
//			}
//			
//			if (i == 1) {
//				
//				moving_distance = 1;
//				
//			}
//			
//			if (distance_total == distance_to_cow) {
//				
//				break search;
//				
//			}
//			
//			if (i % 2 == 1) {
//				
//				distance_total += moving_distance;
//				moving_distance *= 2;
//				
//			}
//			
//			else {
//				
//				distance_total -= moving_distance;
//				moving_distance *= 2;
//				
//			}
//			
//		}
//		
//	}
//		
//		pw.println(distance_total);
//
//
//
	
	
		
		Scanner scanner = new Scanner(new File("lostcow.in"));
		int x = scanner.nextInt();
		int y = scanner.nextInt();

		int total = 0, curx = x, mult = 1;

		while (true) {

			// Go to the new x.
			
			int newx = x + mult;
			int min = Math.min(curx,newx);
			int max = Math.max(curx,newx);
			int travel = max-min;

			// We made it, get out.
			
			if (inbetween(min, y, max)) {
				
				total += Math.abs(y-curx);
				break;
				
			}

			mult *= (-2);
			total += travel;
			curx = newx;
		}

		PrintWriter output = new PrintWriter(new FileWriter("lostcow.out"));
		
		output.println(total);
		output.close();
		scanner.close();
	}

	public static boolean inbetween(int a, int b, int c) {
		
		return a <= b && b <= c;
		
		}

	}


