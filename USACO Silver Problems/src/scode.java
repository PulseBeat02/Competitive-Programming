import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class scode {
	
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("scode.in"));
		PrintWriter pw = new PrintWriter(new File("scode.out"));
		pw.println(countWays(br.readLine()));
		br.close();
		pw.close();
		
	}
	
	public static int countWays(String s) {
		
		count++;
		
		// Let's start with our four cases:
		 
		// ABC -> AB + ABC
		if (s.substring(0, s.length()/2).equals(s.substring(s.length()/2, s.length()/2))) {
			
			count += countWays(s.substring(s.length()/2, s.length()/2 + 1));
			
		}
		
		// ABC -> ABC + AB
		if (s.substring(0, s.length()/2).equals(s.substring(s.length()/2 + 1, s.length()/2))) {
			
			count += countWays(s.substring(0, s.length()/2));
			
		}
		
		// ABC -> BC + ABC
		if (s.substring(0, s.length()/2).equals(s.substring(s.length()/2 + 1, s.length()/2))) {
			
			count += countWays(s.substring(s.length()/2, s.length()/2 + 1));
			
		}
		
		// ABC -> ABC + BC
		if (s.substring(1, s.length()/2).equals(s.substring(s.length()/2 + 1, s.length()/2))) {
			
			count += countWays(s.substring(0, s.length()/2 + 1));
			
		}
		
		return count;
		
	}

}
