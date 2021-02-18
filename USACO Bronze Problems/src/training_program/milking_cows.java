package training_program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milking_cows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new File("milk2.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cows = Integer.parseInt(st.nextToken());
		
		int [][] log = new int[cows][2];
		
		for (int i = 0; i < cows; i++) {
			
			st = new StringTokenizer(br.readLine());
			log[i][0] = Integer.parseInt(st.nextToken());
			log[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		int maxMilkTime = 0;
		int maxNonMilkedTime = 0;
		
		for (int i = 0; i < 1000000; i++) {
			
			int currentMax = 0; // Longest Milking
			int currentMax1 = 0; // Longest IDLE
			
			if (!isMilking(i, log)) {
				
				currentMax1 = 0;
				currentMax1++;
				
				if (currentMax1 > maxNonMilkedTime) {
					
					maxNonMilkedTime = currentMax1;
					
				}
				
			}
			
			else {
				
				currentMax = 0;
				currentMax++;
					
				if (maxMilkTime < currentMax) {
					
					maxMilkTime = currentMax;
					
				}
				
			}
			
		}
		
		System.out.println(maxMilkTime + " " + maxNonMilkedTime);

	}
	
	public static int milkTime (int [] array) {
		
		return array[1] - array[0];
		
	}
	
	public static boolean isMilking(int time, int [][] log) {
		
		boolean flag = false;
		
		for (int i = 0; i < log.length; i++) {
			
			if (time > log[i][0] && time < log[i][1]) {
				
				flag = true;
				
			}
			
		}
		
		return flag;
		
	}

}
