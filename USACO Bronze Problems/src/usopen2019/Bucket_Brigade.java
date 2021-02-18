package usopen2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bucket_Brigade {
	
	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(new BufferedReader(new FileReader("C:\\Computer Science Learning\\USACO Bronze Problems\\src\\US_OPEN\\buckets.in")));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Computer Science Learning\\USACO Bronze Problems\\src\\US_OPEN\\buckets.out")));
	
	    char [][] myArray = new char[10][10];
		int bx = 0, by = 0, rx = 0, ry = 0, lx = 0, ly = 0;
		
	    while (sc.hasNextLine()) {
	    	  
	         for (int i = 0; i < myArray.length; i++) {
	        	 
	            String line = sc.nextLine();
	            
	            for (int j = 0; j < myArray[i].length; j++) {
	            	
	               myArray[i][j] = line.charAt(j);
	               
	               if (myArray[i][j] == 'B') {
	            	   
	            	   bx = i;
	            	   by = j;
	            	   
	               }
	               
	               else if (myArray[i][j] == 'L') {
	            	   
	            	   lx = i;
	            	   ly = j;
	            	   
	               }
	               
	               else if (myArray[i][j] == 'R') {
	            	   
	            	   rx = i;
	            	   ry = j;
	            	   
	               }
	               
	            }
	            
	         }
	         
	      }
	    
		int xDiff = Math.abs(bx - lx);
		int yDiff = Math.abs(by - ly);
		int direct = xDiff + yDiff - 1;
		
		pw.println(direct);
		sc.close();
		pw.close();


	}

}
