package year_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class proximity {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("proximity.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] id = new int[N];

		for (int i = 0; i < id.length; i++) {

			st = new StringTokenizer(br.readLine());
			id[i] = Integer.parseInt(st.nextToken());

		}

		br.close();
		
		int maxid = -1;

		for (int i = 0; i < id.length - 1; i++) {
			
			int index = nextElementIndex(id, i + 1, id[i]);
			
			if (index != -1 && (index - i - 1) < K) {
				if (id[i] > maxid) {
					
					maxid = id[i];
					
				}
				
			}

		}

		PrintWriter pw = new PrintWriter(new File("proximity.out"));
		pw.println(maxid);
		pw.close();

	}
	
	static int nextElementIndex(int[] arr, int start, int target) {
		
		for (int i = start; i < arr.length; i++) {
			
			if (arr[i] == target) {
				
				return i;
				
			}
			
		}
		
		return -1;
		
	}
	
	

}
