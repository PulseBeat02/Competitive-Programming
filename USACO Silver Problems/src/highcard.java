import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class highcard {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));

		int N = Integer.parseInt(br.readLine());

		int[] elsie = new int[N];

		ArrayList<Integer> b = new ArrayList<>();

		for (int i = 0; i < elsie.length; i++) {

			elsie[i] = Integer.parseInt(br.readLine());

		}

		br.close();

		for (int i = 0; i < 2 * N; i++) {

			if (!contains(elsie, i + 1)) {

				b.add(i + 1);

			}

		}

		int[] bessie = b.stream().mapToInt(i -> i).toArray();

		Arrays.parallelSort(elsie);
		Arrays.parallelSort(bessie);

		int bIndex = 0;
		int count = 0;

		for (int i = 0; i < elsie.length; i++) {

			int beatme = elsie[i];

			try {

				while (bessie[bIndex] < beatme) {

					bIndex++;

				}

			} catch (ArrayIndexOutOfBoundsException e) {
				
				break;
				
			}
			
			count++;

		}
		
		PrintWriter pw = new PrintWriter(new File("highcard.out"));
		pw.println(count);
		pw.close();

	}

	public static boolean contains(int[] array, int value) {

		for (int i = 0; i < array.length; i++) {

			if (array[i] == value) {

				return true;

			}

		}

		return false;

	}

}
