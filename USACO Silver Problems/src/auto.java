import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class auto {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("auto.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		String[] dict = new String[W];
		for (int i = 0; i < dict.length; i++) {

			st = new StringTokenizer(br.readLine());
			dict[i] = st.nextToken();
			map.put(dict[i], i + 1);

		}

		Arrays.parallelSort(dict);

		PrintWriter pw = new PrintWriter(new File("auto.out"));

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			char[] last = new char[N + 1];

			Arrays.fill(last, 'z');

			for (int j = 0; j < s.length(); j++) {

				last[j] = s.charAt(j);

			}

			int start = binarySearch(s, 0, dict.length, dict);
			int end = binarySearch(new String(last), 0, dict.length, dict);

			if (num > end - start) {
				
				pw.println(-1);
				//System.out.println(-1);

			} else {
				
				pw.println(map.get(dict[start + num - 1]));
				//System.out.println(map.get(dict[start + num - 1]));

			}

		}

		br.close();
		pw.close();

	}

	public static int binarySearch(String partial, int low, int high, String[] words) {

		while (low < high - 1) {

			int mid = (low + high) / 2;

			// Our word comes before words[mid].
			if (partial.compareTo(words[mid]) < 0)
				high = mid;

			// Equal or later...
			else
				low = mid;
		}

		// Walk the last little bit.
		while (low < words.length && words[low].compareTo(partial) < 0)
			low++;
		return low;

	}

//	public static int binarySearch(int[] dictionary) {
//
//		int lo = 0, hi = dictionary.length;
//		while (lo + 1 < hi) {
//			int mid = (lo + hi - 1) / 2;
//			if (dictionary[mid].first < pref) {
//				lo = mid + 1;
//			} else {
//				hi = mid + 1;
//			}
//		}
//
//	}

}
