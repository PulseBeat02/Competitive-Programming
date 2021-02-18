package year_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mixing_Milk {
	
	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("input.in")); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\input.in
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.out"))); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\output.out
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] bucketsMax = new int[2];
		int [] bucketsCurrent = new int[2];
		
		String line;
		
		int i = 0;
		
		while ((line = br.readLine()) != null) {
		   
			bucketsMax[i] = Integer.parseInt(st.nextToken());
			bucketsCurrent[i] = Integer.parseInt(st.nextToken());
			i++;
			
		}
		
		for (int z = 0; z < 4; z++) {
			
			int remainder = bucketsMax[z] % bucketsCurrent[z];
			
			
			
			
		}
		
		pw.println("Something Here");
		br.close();
		pw.close();

	}

}


