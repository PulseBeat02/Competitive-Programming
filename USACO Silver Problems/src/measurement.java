import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class measurement {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());

		Entry[] entries = new Entry[N];
		HashSet<Integer> cows = new HashSet<>();

		for (int i = 0; i < entries.length; i++) {

			st = new StringTokenizer(br.readLine());

			int day = Integer.parseInt(st.nextToken());
			int id = Integer.parseInt(st.nextToken());

			String change = st.nextToken();

			if (change.contains("+")) {

				entries[i] = new Entry(day, id, Integer.parseInt(change.substring(1)));

			} else {

				entries[i] = new Entry(day, id, Integer.parseInt(change));

			}
			
			cows.add(id);

		}
		
		br.close();

		HashMap<Integer, Integer> amounts = new HashMap<>();
//		HashMap<Integer, Integer> rates = new HashMap<>();
		
		for (int id : cows) {
			
			amounts.put(id, G);
			
		}
		
		Arrays.parallelSort(entries);
		
//		int count = 0;
//		int lastDay = entries[0].day;
//		
//		for (int i = 1; i < entries.length; i++) { // Only loop through days, multiple the amount produced and add
//			
//			int day = entries[i].day;
//			int cow = entries[i].id;
//			int difference = entries[i].change;
//			
//			rates.put(cow, rates.get(cow) + difference);
//			amounts.put(cow, amounts.get(cow) + rates.get(cow));
//			
//			
//			
//			
//		}
		
	}

}

class Entry implements Comparable<Entry> {

	int day;
	int id;
	int change;

	public Entry(int d, int i, int c) {

		this.day = d;
		this.id = i;
		this.change = c;

	}

	@Override
	public int compareTo(Entry arg0) {
		// TODO Auto-generated method stub
		if (arg0.day < this.day) {
			
			return -1;
			
		} else if (arg0.day > this.day) {
			
			return 1;
			
		} else {
			
			return 0;
			
		}
	}

}
