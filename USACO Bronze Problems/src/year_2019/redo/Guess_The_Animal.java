package year_2019.redo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.List;

public class Guess_The_Animal {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("guess.in"));
		PrintWriter pw = new PrintWriter(new File("guess.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int animals = Integer.parseInt(st.nextToken());

		ArrayList<String[]> characteristics = new ArrayList<String[]>(animals);

		for (int i = 0; i < animals; i++) {

			st = new StringTokenizer(br.readLine());

			int count = Integer.parseInt(st.nextToken());

			for (int j = 0; j < count; j++) {

				characteristics.get(i)[j] = st.nextToken();

			}

		}
		
		br.close();
		
		int max = 0;

		for (int i = 0; i < 100; i++) {
			
			for (int j = 0; j < characteristics.size(); i++) {
				
				String currentWord = getCharacteristicMax(characteristics);
				
			}

		}

	}

	public static String getCharacteristicMax(ArrayList<String[]> animals) {

		ArrayList<String> characteristics = new ArrayList<>();

		for (int i = 0; i < animals.size(); i++) {

			for (int j = 0; j < animals.get(i).length; j++) {

				characteristics.add(animals.get(i)[j]);

			}

		}
		
		return mode(characteristics.toArray(new String[0]));

	}

	public static String mode(String[] data) {
		
		List<String> list = new ArrayList<>();
		Collections.addAll(list, data);

		return list.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting())).entrySet().stream()
				.max(Comparator.comparing(Entry::getValue)).get().getKey();

	}

}
