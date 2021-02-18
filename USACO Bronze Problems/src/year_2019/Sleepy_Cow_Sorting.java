package year_2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sleepy_Cow_Sorting {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int cows = Integer.parseInt(st.nextToken());

		int[] unsorted = new int[cows];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < unsorted.length; i++) {

			unsorted[i] = Integer.parseInt(st.nextToken());

		}
		
		br.close();

		int count = 0;

		for (int i = 0; i < unsorted.length; i++) {

			if (unsorted[0] > unsorted[unsorted.length - 1]) {
				moveToBack(unsorted);
				System.out.println(Arrays.toString(unsorted));
				count++;
				
				if (isSorted(unsorted)) break;
				
			}

			if (unsorted[0] < unsorted[unsorted.length - 1]) {
				moveToFront(unsorted);
				System.out.println(Arrays.toString(unsorted));
				count++;
				
				if (isSorted(unsorted)) break;
			}

		}

		PrintWriter pw = new PrintWriter(new File("sleepy.out"));
		pw.println(count);
		pw.close();

	}

	public static int[] moveToFront(int[] array) {

		int temp = array[0];

		for (int i = 0; i < array.length - 2; i++) {

			array[i] = array[i + 1];

		}

		array[array.length - 2] = temp;

		return array;

	}

	public static int[] moveToBack(int[] array) {

		int temp = array[0];

		for (int i = 0; i < array.length - 1; i++) {

			array[i] = array[i + 1];

		}

		array[array.length - 1] = temp;

		return array;

	}

	public static boolean isSorted(int[] array) {
		int prev = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < prev) {
				return false;
	        }
			prev = array[i];
		}
	    return true;
	}

}