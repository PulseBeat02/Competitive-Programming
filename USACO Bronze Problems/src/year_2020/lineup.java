package year_2020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lineup {

	static Object[][] all = new Object[40320][8];
	static int index = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("lineup.in")); //  new InputStreamReader(System.in)
		
		// new FileReader("lineup.in")
		
		int N = Integer.parseInt(br.readLine());

		String[][] beside = new String[N][2];

		for (int i = 0; i < beside.length; i++) {

			String[] besides = br.readLine().split(" ");

			beside[i] = new String[] { besides[0], besides[5] };

		}
		
		br.close();

		String[] cows = { "Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue" };

		int[][] constraints = convert(beside);

		permute(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7), 0);

		int[][] allPerm = convert(all);

		//int[][] allPerm = { new int[] { 0, 7, 1, 3, 4, 5, 2, 6 }, new int[] {0, 1, 5, 7, 3, 4, 2, 6}};

		ArrayList<Integer> ans = new ArrayList<Integer>();
		//int [] myans = new int [40320];
		//int myansidx = 0;
		
		for (int i = 0; i < allPerm.length; i++) {

			// int[] current = new int[N];
			boolean notmeet = false;

			for (int j = 0; j < constraints.length; j++) {

				int first = constraints[j][0];
				int second = constraints[j][1];

				int index1 = getIndex(allPerm[i], first);
				int index2 = getIndex(allPerm[i], second);

				// if (Math.abs(index1 - index2) > 1) {
				if ((index1 != (index2 + 1)) && (index2 != (index1 + 1))) {
					notmeet = true;
					break;
				}

			}

			if (!notmeet) {

				ans.add(i);
				//myans[myansidx++] = i;
				
//				for (int a = 0; a < allPerm[i].length; a++) {
//					
//					System.out.println(cows[allPerm[i][a]]);
//					
//				}
//				
//				break;

			}

		}
		
		int smallest = ans.get(0);

		for (int i = 0; i < ans.size(); i++) {

			for (int j = 0; j < allPerm[ans.get(i)].length; j++) {

				if (allPerm[ans.get(i)][j] < allPerm[smallest][j]) {
				
				//if (isGreater(allPerm[ans.get(i)], allPerm[smallest])) {

					smallest = ans.get(i);
					break;

				} else if (allPerm[ans.get(i)][j] > allPerm[smallest][j]) {
					
					break;
					
				}

			}

		}
		
		PrintWriter pw = new PrintWriter(new File("lineup.out"));
		
		for (int a = 0; a < allPerm[smallest].length; a++) {

			pw.println(cows[allPerm[smallest][a]]);

		}
		
		pw.close();

	}
	
	public static boolean isGreater(int[] a, int[] b) {
		
		for (int i = 0; i < a.length; i++) {
			
			if (a[i] < b[i]) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}

	public static int getIndex(int[] a, int elem) {

		for (int i = 0; i < a.length; i++) {

			if (a[i] == elem) {

				return i;

			}

		}

		return -1;

	}

	public static int[][] convert(Object[][] o) {

		int[][] a = new int[o.length][o[0].length];

		for (int i = 0; i < o.length; i++) {

			for (int j = 0; j < o[i].length; j++) {

				a[i][j] = (int) o[i][j];

			}

		}

		return a;

	}

	static void permute(List<Integer> arr, int k) {
		for (int i = k; i < arr.size(); i++) {
			java.util.Collections.swap(arr, i, k);
			permute(arr, k + 1);
			java.util.Collections.swap(arr, k, i);
		}
		if (k == arr.size() - 1) {
			// System.out.println(java.util.Arrays.toString(arr.toArray()));
			all[index] = arr.toArray();
			index++;

		}
	}

	public static int[][] convert(String[][] c) {

		String[] cows = { "Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue" };

		int[][] indexes = new int[c.length][c[0].length];

		for (int a = 0; a < cows.length; a++) {

			for (int i = 0; i < c.length; i++) {

				for (int j = 0; j < c[i].length; j++) {

					if (c[i][j].equals(cows[a])) {

						indexes[i][j] = a;

					}

				}

			}

		}

		return indexes;

	}

}

