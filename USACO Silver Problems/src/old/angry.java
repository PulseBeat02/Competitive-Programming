package old;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class angry {

	static int K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] pos = new int[N];
		for (int i = 0; i < pos.length; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		Arrays.parallelSort(pos);

		int low = 0; // WE AREN'T SURE IF THIS WORKS
		int high = 50000; // WE KNOW THIS WORKS

		while (low < high) {
			int mid = (low + high) / 2;
			if (blastCow(pos, mid)) {
				high = mid;
			} else {
				low = mid - 1;
			}
		}

		int result = low;

		PrintWriter pw = new PrintWriter(new File("angry.out"));
		System.out.println(result);
		pw.println(result);
		pw.close();

	}

	public static boolean blastCow(int[] pos, int pow) {
		int count = 0;
		for (int i = 0; i < pos.length; i += (count - 1)) {
			count = 0;
			int first = pos[i]; // 0 (lets say pow is 2)
			int second = first + pow; // 0 + 2 = 2
			for (int j = i; j < pos.length && pos[j] <= second; j++) {
				count++;
			}
			if (count <= 1 && count < pos.length) {
				return false;
			}
		}
		return true;
	}

}
