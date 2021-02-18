import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
//import java.util.TreeSet;

public class lifeguard {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] lg = new int[N][2];

		for (int i = 0; i < lg.length; i++) {

			st = new StringTokenizer(br.readLine());
			lg[i][0] = Integer.parseInt(st.nextToken());
			lg[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		Arrays.sort(lg, new Comparator<int[]>() {

			@Override
			// Compare values according to columns
			public int compare(final int[] entry1, final int[] entry2) {

				// To sort in descending order revert
				// the '>' Operator
				if (entry1[0] > entry2[0])
					return 1;
				else
					return -1;
			}
		}); // End of function call sort().

//		TreeSet<Integer> set = new TreeSet<Integer>();
//
//		int actualCover = 0;
//		int[] alone = new int[N];
//		int last = 0;
//		
//		for (int[] arr : lg) {
//			if (set.size() == 1) {
//				alone[set.first()] += (arr[1] - arr[0] - last);
//			}
//			if (!set.isEmpty()) {
//				actualCover += (arr[1] - arr[0] - last);
//			}
//			if (set.contains(out.index)) {
//				set.remove(out.index);
//			} else {
//				set.add(out.index);
//			}
//			last = out.time;
//		}
//		int ret = 0;
//		for (int out : alone) {
//			ret = Math.max(ret, actualCover - out);
//		}
//		pw.println(ret);
//		pw.close();

//		int max = 0;
//		int maxTime = getMaxTime(lg);
//
//		for (int i = 0; i < lg.length; i++) { // person not counted
//
//			int count = 0;
//
//			for (int t = 1; t < maxTime; t++) {
//
//				for (int j = 0; j < lg.length; j++) {
//
//					if (j != i) {
//
//						if (lg[j][0] >= t && t <= lg[j][1]) {
//
//							count++;
//
//						}
//
//					}
//
//				}
//
//			}
//
//			max = Math.max(max, count);
//
//		}

		// System.out.println(max);

	}

//	private static int getMaxTime(int[][] lg) {
//		int max = 0;
//		for (int i = 0; i < lg.length; i++) {
//			if (lg[i][1] > 0) {
//
//				max = lg[i][1];
//
//			}
//
//		}
//
//		return max;
//	}

}

/*
 * 
 * Analysis:
 * 
 * 3 5 9 1 4 3 7
 * 
 * 1 - - - 4 3 - - - 7 5 - - - 9
 * 
 * 
 * 
 * 
 * 
 */
