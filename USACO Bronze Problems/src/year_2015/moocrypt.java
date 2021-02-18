package year_2015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class moocrypt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Algorithm:
		// Buffered Reader/String Tokenizer
		// Find top two most common letters.
		// Replace them with 'M' or 'O'.
		// Use 'for' loop to find all possible 'moo's'
		// moo++;
		// println(moo);
		//
		
		BufferedReader br = new BufferedReader(new FileReader("input.in")); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\input.in
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.out"))); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\output.out
	    StringTokenizer st;
	    
		st = new StringTokenizer(br.readLine());
		
		int rows = Integer.parseInt(st.nextToken()); // At most 50
		int columns = Integer.parseInt(st.nextToken()); // At most 50
		char [][] puzzle = new char [rows][columns];
		String tmpstr;
		
		for (int i = 0; i < rows; i++) {
			
			st = new StringTokenizer(br.readLine());
			tmpstr = st.nextToken();
			puzzle[i] = tmpstr.toCharArray();
			
		}
		
		String string = Arrays.toString(puzzle);
		
		char mostCom = getMaxOccuringChar(string); // Finds Most Common Character
		char secMostCom = getSecondMostFreq(string);
		String newstring = string.replace(mostCom, 'C');
		String newstring2 = newstring.replace(secMostCom, 'O');
		char[] REPLACED_CHAR_ARRAY = newstring2.toCharArray();
		
		// Check Winners Here: https://stackoverflow.com/questions/1056316/algorithm-for-determining-tic-tac-toe-game-over
		
		br.close();
		pw.close();

	}
	
	static char getMaxOccuringChar(String str) {
		
		int array[] = new int[2500]; 
		
		for (int i = 0; i < array.length; i++)  {
			
            array[str.charAt(i)]++; 
            
		}
       
        int max = -1;  // Initialize max count 
        char result = ' ';   // Initialize result 
       
        // Traversing through the string and maintaining 
        // the count of each character 
        
        for (int i = 0; i < array.length; i++) { 
        	
            if (max < array[str.charAt(i)]) { 
            	
                max = array[str.charAt(i)];
                
                result = str.charAt(i); 
                
            } 
            
        }
        
		return result; 
        
	}
	
	static char getSecondMostFreq(String str) { 
		
        // count number of occurrences of every 
        // character.  
		
        int[] count = new int[2500]; 
        int i; 
        
        for (i = 0; i < str.length(); i++) {
        	
        	(count[str.charAt(i)])++; 
        	
        }
            
        // Traverse through the count[] and find 
        // second highest element. 
        
        int first = 0, second = 0; 
        
        for (i = 0; i < 2500; i++) { 
        	
            /* If current element is smaller than 
            first then update both first and second */
        	
            if (count[i] > count[first]) { 
            	
                second = first; 
                first = i; 
                
            } 
       
            /* If count[i] is in between first and 
            second then update second  */
            
            else if (count[i] > count[second] && count[i] != count[first]) {
                second = i; 
                
            }
            
        } 
       
        return (char) second; 
        
    } 

}
