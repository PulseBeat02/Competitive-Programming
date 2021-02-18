package year_2014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lazy {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("lazy.in")
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] fields = new int[N][2];
		
		for (int i = 0; i < fields.length; i++) {
			
			st = new StringTokenizer(br.readLine());
			fields[i][0] = Integer.parseInt(st.nextToken());
			fields[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
//		int max = 0;
//		
//		for (int i = 0; i < fields.length; i++) {
//			
//			int sumR = getRight(i, K, fields);
//			int sumL = getLeft(i, K, fields);
//			
//			if (sumR > max) {
//				
//				max = sumR;
//				
//				System.out.println(i);
//				
//			}
//			
//			if (sumL > max) {
//				
//				max = sumL;
//				
//				System.out.println(i);
//				
//			}
//			
//			
//		}
		
		int min = getMin(fields);
		int max = getMax(fields);
		
		int answer = 0;
		
		for (int i = min; i < max; i++) {
			
			int cMax = 0;
			
			for (int j = 0; j < fields.length; j++) {
				
				int units = fields[j][0];
				int point = fields[j][1];
				
				if (Math.abs(point - i) >= 0) {
					
					cMax += units;
					
				}
				
			}
			
			if (cMax > answer) {
				
				answer = cMax;
				
			}
			
		}
		
		
		System.out.println(max);
		

	}
	
	public static int getMin(int[][] log) {
		
		int min = 100000;
		
		for (int i = 0; i < log.length; i++) {
			
			if (log[i][0] < min) {
				
				min = log[i][0];
				
			}
			
		}
		
		return min;
		
	}
	
	public static int getMax(int[][] log) {
		
		int max = 0;
		
		for (int i = 0; i < log.length; i++) {
			
			if (log[i][0] > max) {
				
				max = log[i][0];
				
			}
			
		}
		
		return max;
		
	}
	
//	public static int getRight(int currentIndex, int K, int[][] fields) {
//		
//		int gSum = 0;
//		int dSum = 0;
//		
//		for (int i = currentIndex; i < fields.length - 1; i++) {
//			
//			int grass = fields[i][0];
//			int distance = Math.abs(fields[i + 1][1] - fields[i][1]);
//			
//			if (dSum + distance > K) {
//				
//				break;
//				
//			}
//			
//			else {
//				
//				dSum += distance;
//				gSum += grass;
//				
//				continue;
//				
//			}
//			
//		}
//		
//		return gSum;
//		
//	}
//	
//	public static int getLeft(int currentIndex, int K, int[][] fields) {
//		
//		int gSum = 0;
//		int dSum = 0;
//		
//		for (int i = currentIndex; i > 1; i--) {
//			
//			int grass = fields[i][0];
//			int distance = Math.abs(fields[i - 1][1] - fields[i][1]);
//			
//			if (dSum + distance > K) {
//				
//				break;
//				
//			}
//			
//			else {
//				
//				dSum += distance;
//				gSum += grass;
//				
//				continue;
//				
//			}
//			
//		}
//		
//		return gSum;
//		
//	}

}




