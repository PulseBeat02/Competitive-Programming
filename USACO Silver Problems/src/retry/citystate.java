package retry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class citystate {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		HashMap<String, Long> city = new HashMap<>();

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			String two = st.nextToken().substring(0, 2);
			String s = st.nextToken();

			if (!two.substring(0, 2).equals(s)) {

				String key = two.substring(0, 2) + s;

				if (!city.containsKey(key)) {

					city.put(key, 0L);

				}
				city.put(key, city.get(key) + 1);
				
			}

		}
		
		br.close();
		
		long count = 0;
		
		for (String key : city.keySet()) {
			
			String k = key.substring(2) + key.substring(0, 2);
			
			if (city.containsKey(k)) count += (city.get(key) * city.get(k));
			
		}
		
		PrintWriter pw = new PrintWriter(new File("citystate.out"));
		pw.println(count/2);
		pw.close();
		

	}

}
