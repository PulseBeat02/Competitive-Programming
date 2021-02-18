package year_2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Guess_The_Animal {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("guess.in"));
		PrintWriter pw = new PrintWriter(new File("guess.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int animalCount = Integer.parseInt(st.nextToken());

		ArrayList<String[]> animals = new ArrayList<>();

		for (int i = 0; i < animalCount; i++) {

			st = new StringTokenizer(br.readLine());
			st.nextToken();

			int characteristicsCount = Integer.parseInt(st.nextToken());
			String[] characteristics = new String[characteristicsCount];

			for (int j = 0; j < characteristics.length; j++) {

				characteristics[j] = st.nextToken();

			}

			animals.add(characteristics);

		}
		
		br.close();

		int max = 0;

		String[] allCharacteristics = getCharacteristics(animals);

		for (int z = 0; z < allCharacteristics.length; z++) {
			
			int currentMax = 0;

			for (int i = 0; i < animals.size(); i++) {

				for (int j = 0; j < animals.get(i).length; j++) {
					
					if (allCharacteristics[z].equals(animals.get(i)[j])) {
						
						currentMax++;
						
					}

				}

			}
			
			if (currentMax > max) {
				
				max = currentMax;
				
			}

		}
		
		pw.println(max);
		pw.close();

	}

	public static String[] getCharacteristics(ArrayList<String[]> animals) {

		ArrayList<String> characteristics = new ArrayList<>();

		for (int i = 0; i < animals.size(); i++) {

			for (int j = 0; j < animals.get(i).length; j++) {

				characteristics.add(animals.get(i)[j]);

			}

		}

		return removeDuplicates(characteristics.toArray(new String[0]));

	}

	public static String[] removeDuplicates(String[] array) {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(array));
		return linkedHashSet.toArray(new String[0]);
	}

}
