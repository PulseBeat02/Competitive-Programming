package year_2013;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class nocow {

	// Given the cows he doen't have, calculate the cows he does have

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("nocow.in")
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// Make a list of all of the possible combinations and then remove the ones he
		// doesn't have

		int adjectives = 0;

		ArrayList<TreeSet<String>> allAdjectivesPre = new ArrayList<TreeSet<String>>();

		Cow[] noHave = new Cow[N];

		for (int i = 0; i < noHave.length; i++) {

			String line = br.readLine();
			adjectives = adjectives(line);
			st = new StringTokenizer(line);
			st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();

			ArrayList<String> tCharacteristics = new ArrayList<String>();

			for (int a = 0; a < adjectives; a++) {

				if (i == 0 && a == 0) {

					for (int c = 0; c < adjectives; c++) {

						allAdjectivesPre.add(new TreeSet<String>());

					}

				}

				String token = st.nextToken();

				tCharacteristics.add(token);

				allAdjectivesPre.get(a).add(token);

			}

			noHave[i] = new Cow(tCharacteristics.toArray(new String[0]));

		}

		br.close();

		ArrayList<List<String>> allCharacteristics = sort(allAdjectivesPre);

		ArrayList<Cow> allCows = new ArrayList<Cow>();

		long[] div = new long[allCharacteristics.size()];
		long total = 1;
		for (int i = allCharacteristics.size() - 1; i >= 0; i--) {
			div[i] = total;
			if ((total *= allCharacteristics.get(i).size()) <= 0)
				throw new IllegalStateException("Overflow or empty sublist");
		}

		for (long combo = 0; combo < total; combo++) {

			String str = "";

			for (int i = 0; i < allCharacteristics.size(); i++) {

				int digit = (int) (combo / div[i] % allCharacteristics.get(i).size());

				if (i != 0)
					str += ' ';
				str += allCharacteristics.get(i).get(digit);

			}

			allCows.add(new Cow(str.split(" ")));

		}

		for (int i = 0; i < noHave.length; i++) {

			delete(noHave[i], allCows);

		}

		PrintWriter pw = new PrintWriter(new File("nocow.out"));

		System.out.println(allCows.get(K -1));
		

		pw.close();

	}

	public static int adjectives(String str) throws IOException {

		String[] array = str.split(" ");

		int count = 0;

		int indexNo = array.length;

		for (int i = 0; i < array.length; i++) {

			if (array[i].equals("no")) {

				indexNo = i;

			}

			if (i > indexNo && i < (array.length - 1)) {

				count++;

			}

		}

		return count;

	}

	public static ArrayList<List<String>> sort(ArrayList<TreeSet<String>> adjectives) {

		ArrayList<List<String>> NewAdjectives = new ArrayList<List<String>>();

		for (int i = 0; i < adjectives.size(); i++) {

			List<String> newA = new ArrayList<String>(adjectives.get(i));
			NewAdjectives.add(newA);

		}

		for (int i = 0; i < NewAdjectives.size(); i++) {

			Collections.sort(NewAdjectives.get(i));

		}

		return NewAdjectives;

	}
	
	public static void delete(Cow cow, ArrayList<Cow> allCows) {
		
		for (int j = 0; j < allCows.size(); j++) {
			
			boolean flag = false;

			for (int b = 0; b < allCows.get(j).characteristics.size(); b++) {
				
				if (!(allCows.get(j).characteristics.get(b).equals(cow.characteristics.get(b)))) {
					
					flag = true;
					
				}
				
			}
			
			if (!flag) {
				
				allCows.remove(allCows.get(j));
				return;
				
			}

		}

	}

}

class Cow {

	ArrayList<String> characteristics = new ArrayList<String>();

	Cow(String[] characteristics) {

		for (int i = 0; i < characteristics.length; i++) {

			this.characteristics.add(characteristics[i]);

		}

	}

	@Override
	public String toString() {

		String str = "";

		for (int i = 0; i < this.characteristics.size(); i++) {

			if (i == this.characteristics.size() - 1) {

				str += this.characteristics.get(i);
				break;

			}

			str += (this.characteristics.get(i) + " ");

		}

		return str;

	}

}






