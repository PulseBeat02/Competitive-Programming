package old;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javafx.util.Pair;

public class auto {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("auto.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int max = 0;
		
		Map<String, Integer> dict = new TreeMap<>();
		for (int i = 0; i < W; i++) {
			String s = br.readLine();
			dict.put(s, i);
			max = Math.max(max, s.length());
		}
		
		List<Pair<Integer, String>> query = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			query.add(new Pair<Integer, String>(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		br.close();

		PrintWriter pw = new PrintWriter(new File("auto.out"));
		for (Pair<Integer, String> p : query) {
			String[] set = dict.keySet().toArray(new String[0]);
			String fill = p.getValue();
			int get = p.getKey();
			
			int low = 0;
			int high = W;
			boolean found = false;
			while (low < high) {
				int mid = (low + high)/2;
				int result = set[mid].substring(0, get).compareTo(fill);
				if (result > 0) {
					high = mid;
				} else if (result < 0) {
					low = mid;
				} else {
					found = true;
					break;
				}
			}
			
			int index = low + get;
			if (index >= 0) {
				pw.println(index);
			} else {
				pw.println(-1);
			}
		}
		pw.close();

	}

}

/*
 
10 3
dab -> 0
ba  -> 1
ab
daa
aa
aaa
aab
abc
ac
dadba
4 a
2 da
4 da
 
 
aa   |
aaa  |
aab  |
ab   |
abc  |
ac   |
ba   |
daa  |
dab  |
dadba|
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 */
