package year_2017;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Milk_Measurement {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("measurement.in")
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int measurements = Integer.parseInt(st.nextToken());
		int displayChanges = 0;

		String[][] notes = new String[measurements][3];

		for (int i = 0; i < notes.length; i++) {
			notes[i] = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);
		}

		notes = sort(notes);

		// Found a problem, Notes Could be 4, but the number of cows could be 3, meaning
		// one cow has two notes

		HashMap<String, Integer> allCowMilkTotal = new HashMap<String, Integer>();

		for (int i = 0; i < notes.length; i++) {

			for (int j = i + 1; j < notes.length; j++) {

				if (!notes[i][1].equals(notes[j][1])) {

					allCowMilkTotal.put(notes[i][1], 7);

				}

				else if (!duplicate(notes, notes[i][1])) {

					allCowMilkTotal.put(notes[i][1], 7);

				}

			}

		}

		br.close();

		for (int z = 0; z < notes.length; z++) {

			if (notes[z][0].equals((String) allCowMilkTotal.keySet().toArray()[z])) {

				allCowMilkTotal.put((String) allCowMilkTotal.keySet().toArray()[z],
						allCowMilkTotal.get(allCowMilkTotal.keySet().toArray()[z]) + getNumber(notes[z][2]));

			}

			if (maxValue(allCowMilkTotal) <= allCowMilkTotal.get(allCowMilkTotal.keySet().toArray()[z])) {

				displayChanges++;

			}

			System.out.println(allCowMilkTotal.toString());

		}

		System.out.println(displayChanges);
		pw.close();

	}

	public static String[][] sort(String[][] array) {

		String[] temp;

		for (int i = 0; i < array.length - 1; i++) {

			for (int j = i + 1; j < array.length; j++) {

				if (Integer.parseInt(array[i][0]) > Integer.parseInt(array[j][0])) {

					temp = array[i];
					array[i] = array[j];
					array[j] = temp;

				}

			}

		}

		System.out.println(Arrays.deepToString(array));

		return array;

	}

	public static int getNumber(String s) {

		if (s.contains("+")) {

			return Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));

		}

		else {

			return (-1) * Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));

		}

	}

	public static int maxValue(HashMap<String, Integer> map) {
		return Collections.max(map.values());
	}

	public static boolean duplicate(String[][] arr, String targetValue) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0].equals(targetValue))
				return true;
		}
		return false;
	}

}
