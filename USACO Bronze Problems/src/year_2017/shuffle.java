package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class shuffle {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("shuffle.in")
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] shuffles = new int[N];
		int[] finalShuffle = new int[N];
		int [] finalPos = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < shuffles.length; i++) {
			
			shuffles[i] = Integer.parseInt(st.nextToken());
			
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < finalShuffle.length; i++) {
			
			finalShuffle[i] = Integer.parseInt(st.nextToken());
			
		}
		
		br.close();
		
		
		int[] shuffled = new int[N];
		
		for (int i = 0; i < finalPos.length; i++) {
			
			finalPos[i] = i + 1;
			
		}
		
		
		for (int i = 0; i < 3; i++) {
			
			for (int j = 1; j <= N; j++) {
				
				//finalPos[shuffles[j - 1] - 1] = shuffles[j - 1];
				//finalPos[j - 1] = finalPos[shuffles[j - 1] - 1];
			}
			
			//shuffles = shuffled;
			
			
		}
		
		
		PrintWriter pw = new PrintWriter(new File("shuffle.out"));
		
		for (int i = 0; i < finalShuffle.length; i++) {
			
			System.out.println(finalShuffle[finalPos[i] - 1]);
			
		}
		
		pw.close();
		
		
	}

}






