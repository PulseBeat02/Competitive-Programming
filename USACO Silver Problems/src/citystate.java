import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class citystate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		HashMap<String, ArrayList<String>> city = new HashMap<>();

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			String two = st.nextToken().substring(0, 2);
			String s = st.nextToken();

			if (!city.containsKey(two)) {

				ArrayList<String> t = new ArrayList<>();
				t.add(s);
				city.put(two, t);

			} else {

				city.get(two).add(s);

			}

		}

		br.close();

		int count = 0;

		for (String s : city.keySet()) {

			ArrayList<String> val = city.get(s);

			for (int i = 0; i < val.size(); i++) {

				if (val.get(i) != s) {

					if (city.containsKey(val.get(i)) && city.get(val.get(i)).contains(s)) {

						count++;

					}

				}

			}

		}

		PrintWriter pw = new PrintWriter(new File("citystate.out"));
		pw.println(count / 2);
		pw.close();

	}

}
