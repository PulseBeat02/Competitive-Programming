package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class notlast {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int entryNumber = Integer.parseInt(st.nextToken());

		String[][] entries = new String[entryNumber][2];

		for (int i = 0; i < entries.length; i++) {

			st = new StringTokenizer(br.readLine());
			entries[i][0] = st.nextToken();
			entries[i][1] = st.nextToken();

		}

		br.close();

		TreeMap<String, Integer> log = new TreeMap<String, Integer>();

		log.put("Bessie", 0);
		log.put("Elsie", 0);
		log.put("Daisy", 0);
		log.put("Gertie", 0);
		log.put("Annabelle", 0);
		log.put("Maggie", 0);
		log.put("Henrietta", 0);

		for (int i = 0; i < entries.length; i++) {

			for (String name : log.keySet()) {

				if (name.equals(entries[i][0])) {

					log.put(name, log.get(name) + Integer.parseInt(entries[i][1]));

				}

			}

		}

		int min = getLowest(log);
		int second = 100000;

		for (String name : log.keySet()) {
			if (log.get(name) > min && log.get(name) < second) {
				second = log.get(name);
			}
		}
		
		int state = 0; 
		
		// 0 - not found
		// 1 - found
		// > 1 - multiple

		String answer = "";

		for (String name : log.keySet()) {
			if (log.get(name) == second) {
				state++;
				answer = name;
			}

		}

		PrintWriter pw = new PrintWriter(new File("notlast.out"));

		if (state == 1) {
			pw.println(answer);
		} else {
			pw.println("Tie");
		}
		
		pw.close();

	}

	public static int getLowest(TreeMap<String, Integer> map) {

		int lowest = 10000;

		for (String key : map.keySet()) {

			if (map.get(key) < lowest) {

				lowest = map.get(key);

			} 

		}

		return lowest;

	}

}
