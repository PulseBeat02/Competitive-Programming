package problems;

import java.util.Scanner;

public class Thanos_Sort {
	
public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in); 
		
		int size = sc.nextInt();
		
		String line = sc.nextLine();
		
		String[] lineArray = line.split(" "); 
		
		int [] input = new int[size];
		
		for (int i = 0; i < input.length; i++){
			
		    input[i] = Integer.parseInt(lineArray[i]); 
		    
		
		}
		
		reHalf(input);
		


//		              (src   , src-offset  , dest , offset, count)
		

		
		sc.close();
		
		

	}

	static boolean isSorted(int[] a) {
		
		int i = 0;
		
		for (i = 0; i < a.length; i++); { 
			
		    if (a[i] < a[i + 1]) {
		    	
		        return true;
		        
		    }
		    
		    else {
		    	
		        return false;
		        
		    }
		}
		
	}
	
	static int z = 0;
	
	static int reHalf(int [] array) {
		
		z++;
		
		int[] part1 = new int[array.length/2];
		int[] part2 = new int[array.length/2];
		
		System.arraycopy(array, 0, part1, 0, part1.length);
		System.arraycopy(array, part1.length, part2, 0, part2.length);
		
		boolean [] bool = new boolean[2];
		
		bool[1] = isSorted(part1);
		bool[2] = isSorted(part2);
		
		if (bool[1] == true || bool[2] == true) {
			
			return z;
			
		}
		
		else {
			
			return reHalf(part1);
			
		}
		
		
		
	}

}









