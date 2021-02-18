package year_2017.cowqueu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class cowqueue {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		TreeMap<Integer, Integer> log = new TreeMap<Integer, Integer>();

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			int arrival = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			log.put(arrival, time);

		}

		br.close();

		Set<Integer> keys = log.keySet();

		int previousTime = 0;

		for (int key : keys) {
			
			int time = log.get(key);
			
			if (previousTime < key) {
				
				previousTime = (key + time);
				
			}
			
			else {
				
				previousTime += time;
				
			}

		}
		
		PrintWriter pw = new PrintWriter(new File("cowqueue.out"));
		pw.println(previousTime);
		pw.close();

	}

}
