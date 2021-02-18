import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javafx.util.Pair;

public class assign {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("assign.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Map<Integer, HashSet<Integer>> same = new TreeMap<>();
		Map<Integer, HashSet<Integer>> different = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().toCharArray()[0] == 'S' ? true : false) {
				int key = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(value);
				same.put(key, set);
			} else {
				int key = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(value);
				different.put(key, set);
			}
		}

		for (int key : same.keySet()) {

			for (int compare : same.keySet()) {

				if (key != compare && !same.get(compare).contains(key)) {

					same.get(compare).add(key);
					same.remove(key);

				}

			}

		}

//		List<Pair<Integer, Integer>> same = new ArrayList<>();
//		List<Pair<Integer, Integer>> different = new ArrayList<>();
//
//		for (int i = 0; i < K; i++) {
//
//			st = new StringTokenizer(br.readLine());
//			if (st.nextToken().toCharArray()[0] == 'S' ? true : false) {
//
//				same.add(new Pair<Integer, Integer>(Integer.parseInt(st.nextToken()) - 1,
//						Integer.parseInt(st.nextToken()) - 1));
//			} else {
//
//				different.add(new Pair<Integer, Integer>(Integer.parseInt(st.nextToken()) - 1,
//						Integer.parseInt(st.nextToken()) - 1));
//			}
//
//		}
//
//		br.close();
//
//		int[] input = new int[] { 0, 1, 2 }; // 0 -> Holsteins, 1 -> Jerseys, 2 -> Guernseys
//		List<int[]> list = new ArrayList<>();
//
//		int numArrays = (int) Math.pow(input.length, N);
//
//		for (int i = 0; i < numArrays; i++) {
//			list.add(new int[N]);
//		}
//
//		for (int j = 0; j < N; j++) {
//			int period = (int) Math.pow(input.length, N - j - 1);
//			for (int i = 0; i < numArrays; i++) {
//				int[] current = list.get(i);
//				int index = i / period % input.length;
//				current[j] = input[index];
//			}
//		}
//
//		int counter = 0;
//		for (int[] array : list) {
//
//			if (check(array, same, different)) {
//				counter++;
//			}
//
//		}

		PrintWriter pw = new PrintWriter(new File("assign.out"));
		// pw.println(counter);
		pw.close();

	}

//	public static boolean check(int[] array, List<Pair<Integer, Integer>> same,
//			List<Pair<Integer, Integer>> different) {
//		for (int i = 0; i < same.size(); i++) {
//			if (array[same.get(i).getKey()] != array[same.get(i).getValue()]) {
//				return false;
//			}
//		}
//		for (int i = 0; i < different.size(); i++) {
//			if (array[different.get(i).getKey()] == array[different.get(i).getValue()]) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	public static int[] getSubset(int[] input, int[] subset) {
//		int[] result = new int[subset.length];
//		for (int i = 0; i < subset.length; i++)
//			result[i] = input[subset[i]];
//		return result;
//	}

}
