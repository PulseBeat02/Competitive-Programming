package year_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Arrays;
import java.util.StringTokenizer;

public class wormhole {
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] grid = new int[N][2];
		
		for (int i = 0; i < grid.length; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			grid[i][0] = Integer.parseInt(st.nextToken());
			grid[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		br.close(); 
		
		int count = 0;
		
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = i + 1; j < grid.length; j++) {
				
				if (isInfinite(grid[i], grid[j])) {
					
					count++;
					
					grid = remove(grid, grid[i], grid[j]);
					
				}
				
			}
			
		}
		
		PrintWriter pw = new PrintWriter(new File("wormhole.out"));
		pw.println(count);
		pw.close();
		
	}
	
	static boolean isInfinite(int[] array1, int[] array2) {
		
		return array1[1] == array2[1];
		
	}
	
	static int[][] remove(int[][] array, int[] object1, int[] object2) {
		
		int index1 = Arrays.binarySearch(array, object1);
		array = removeOneElement(array, index1);

		int index2 = Arrays.binarySearch(array, object2);
		array = removeOneElement(array, index2);
		
		return array;
		
	}
	
	static int[][] removeOneElement(int[][] array, int index) {
		
		int[][] newArray = new int[array.length - 1][array[0].length];
		
		for (int i = 0, k = 0; i < array.length; i++) { 
			  
            if (i == index) { 
                continue; 
            } 
            
            newArray[k++] = array[i]; 
        } 
  
        // return the resultant array 
        return newArray; 
		
	}

}






