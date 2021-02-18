package retry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class socdist {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] intervals = new int[M][2];
		for (int i = 0; i < intervals.length; i++) {
			st = new StringTokenizer(br.readLine());
			intervals[i][0] = Integer.parseInt(st.nextToken());
			intervals[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
		    public int compare(int[] a, int[] b) {
		        return Integer.compare(a[0], b[0]);
		    }
		});
		
		int min = 0; // We know this NEVER WORKS
		int max = 100000; // We know this WORKS
		
		while (max > min) {
			int m = (max + min)/2;
			if (trial(intervals, N, m)) {
				max = m;
			} else {
				min = m;
			}
		}
		
		PrintWriter pw = new PrintWriter(new File("socdist.out"));
		pw.println(max);
		pw.close();
		
	}
	
	public static boolean trial(int[][] arr, int N, int m) {
		int loc = arr[0][0];
		int index = 0;
		while (true) {
			if (!exists(arr, loc)) {
				return false;
			}
			if (index > N) {
				break;
			}
			loc += m;
			index++;
		}
		
		return true;
	}
	
	public static boolean exists(int[][] arr, int loc) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] <= loc && arr[i][1] >= loc) {
				return true;
			}
		}
		return false;
	}

}
