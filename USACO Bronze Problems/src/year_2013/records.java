package year_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class records {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("records.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		String[] records = new String[N];

		for (int i = 0; i < records.length; i++) {

			st = new StringTokenizer(br.readLine());
			records[i] = st.nextToken() + st.nextToken() + st.nextToken();

		}
		
		br.close();

		int max = 0;

		String[] allPossibilities = getAllPossible(records);

		for (int j = 0; j < allPossibilities.length; j++) {
			
			int currentMax = 0;
			
			for (int i = 0; i < records.length; i++) {
				
				if (isSameNoOrder(allPossibilities[j], records[i])) currentMax++;

			}
			
			if (currentMax > max) max = currentMax;

		}
		
		PrintWriter pw = new PrintWriter(new File("records.out"));
		pw.println(max);
		pw.close();

	}

	static String[] getAllPossible(String[] records) {
		
		List<String> array = new LinkedList<String>(Arrays.asList(records));
		
		for (int i = 0; i < array.size(); i++) {
			
			for (int j = i + 1; j < array.size(); j++) {
				
				if (isSameNoOrder(array.get(i), array.get(j))) {
					
					array.remove(array.get(i));
					
				}
				
			}
			
		}
		
		return array.toArray(new String[0]);

	}
	
	static boolean isSameNoOrder(String str1, String str2) {
		
		char[] first = str1.toCharArray();
		char[] second = str2.toCharArray();
		
		Arrays.parallelSort(first);
		Arrays.parallelSort(second);
		
		return Arrays.equals(first, second);
		
	}

}




