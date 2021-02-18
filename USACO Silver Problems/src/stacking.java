import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class stacking {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("stacking.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> bales = new HashMap<Integer, Integer>();
		int[][] instructions = new int[K][2];

		for (int i = 1; i <= N; i++) {

			bales.put(i, 0);

		}

		for (int i = 0; i < instructions.length; i++) {

			st = new StringTokenizer(br.readLine());
			instructions[i][0] = Integer.parseInt(st.nextToken());
			instructions[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		for (int i = 0; i < instructions.length; i++) {

			bales = place(bales, instructions[i][0], instructions[i][1]);

		}
		
		System.out.println(median(bales));

	}

	public static int median(HashMap<Integer, Integer> bales) {

		int[] vals = bales.values().stream().mapToInt(Integer::intValue).toArray();

		Arrays.parallelSort(vals);

		return vals[vals.length / 2];

	}

	public static HashMap<Integer, Integer> place(HashMap<Integer, Integer> bales, int start, int end) {

		for (int i = start; i <= end; i++) {

			bales.put(i, bales.get(i) + 1);

		}
		
		return bales;

	}

}
