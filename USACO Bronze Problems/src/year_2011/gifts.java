package year_2011;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class gifts {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("gifts.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] gifts = new int[N][2];

		for (int i = 0; i < gifts.length; i++) {

			st = new StringTokenizer(br.readLine());
			gifts[i][0] = Integer.parseInt(st.nextToken());
			gifts[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();
		
		while (!checkAffordable(gifts, B)) {
			
			gifts = remove(gifts, halfPAndShippingIndex(gifts));
			
		}
		
		PrintWriter pw = new PrintWriter(new File("gifts.out"));
		pw.println(gifts.length);
		pw.close();
		
	}

	public static boolean checkAffordable(int[][] gifts, int B) {
		
		int largestIndex = largestPIndex(gifts);
		
		int sum = 0;
		
		for (int i = 0; i < gifts.length; i++) {
			
			if (i == largestIndex) {
				
				sum += (gifts[i][0] / 2 + gifts[i][1]);
				
			}
			
			else {
				
				sum += (gifts[i][0] + gifts[i][1]);
				
			}
			
		}
		
		return sum <= B;

	}

	public static int largestPIndex(int[][] array) {

		int max = array[0][0];
		
		int index = 0;

		for (int i = 1; i < array.length; i++) {

			if (array[i][0] > max) {
				
				max = array[i][0];
				index = i;

			}

		}
		
		return index;

	}
	
	public static int[][] remove(int [][] array, int index) {
		
		int[][] newArray = new int[array.length-1][2];
		
		for (int i = 0; i < index; i++) {
			
			newArray[i][0] = array[i][0];
			newArray[i][1] = array[i][1];
			
		}
		
		for (int i = index; i < newArray.length - index; i++) {
			
			newArray[i][0] = array[i+1][0];
			newArray[i][1] = array[i+1][1];
			
		}
		
		return newArray;
		
	}
	
	public static int halfPAndShippingIndex(int[][] array) {
		
		int max = array[0][0]/2 + array[0][1];
		
		int index = 0;
		
		for (int i = 1; i < array.length; i++) {
			
			if ((array[i][0]/2 + array[i][1]) > max) {
				
				max = (array[i][0]/2 + array[i][1]);
				index = i;
				
			}
			
		}
		
		return index;
		
	}

}






