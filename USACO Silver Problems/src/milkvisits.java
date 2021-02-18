import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class milkvisits {

	public static Map<Integer, Boolean> milks;
	public static Map<Integer, Set<Integer>> roads;
	public static boolean found = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		milks = new HashMap<Integer, Boolean>();
		String m = br.readLine();
		for (int i = 0; i < m.length(); i++) {
			milks.put(i + 1, m.charAt(i) == 'G' ? true : false);
		}
		roads = new HashMap<>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (roads.containsKey(start)) {
				roads.get(start).add(end);
			} else {
				Set<Integer> t = new HashSet<>();
				t.add(end);
				roads.put(start, t);

			}
		}
		String bin = "";
		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());

			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			boolean GH = st.nextToken().toCharArray()[0] == 'G';
			bin += flood(begin, end, GH) ? "1" : "0";
			
			found = false;

		}

		br.close();
		System.out.println(bin);

	}

	public static boolean flood(int current, int goal, boolean milk) {

		if (current == goal || found) { // Found It!
			found = true;
			return true;
		}
		
		if (!milks.containsKey(current)) // Dead End
			return false;
		
		if (milks.get(current) != milk)
			return false;

		for (int a : roads.get(current)) {

			flood(a, goal, milk);

		}

		return true;

	}

}