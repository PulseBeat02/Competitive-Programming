package year_2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class geteven {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("geteven.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String[] characters = { "B", "E", "S", "I", "G", "O", "M" };

		int N = Integer.parseInt(st.nextToken());

		HashMap<String, ArrayList<Integer>> values = new HashMap<>(N);
		values.put("B", new ArrayList<Integer>());
		values.put("E", new ArrayList<Integer>());
		values.put("S", new ArrayList<Integer>());
		values.put("I", new ArrayList<Integer>());
		values.put("G", new ArrayList<Integer>());
		values.put("O", new ArrayList<Integer>());
		values.put("M", new ArrayList<Integer>());

		for (int i = 0; i < values.size(); i++) {

			st = new StringTokenizer(br.readLine());
			values.get(st.nextToken()).add(Integer.parseInt(st.nextToken()));

		}
		
		br.close();
		
		int count = 0;
		
		HashMap<String, Integer> bruteForce = new HashMap<>();

		for (int z = 0; z < Math.pow(20, values.size()); z++) {

			for (int i = 0; i < characters.length; i++) {

				for (int j = 0; j < values.get(characters[i]).size(); i++) {
					
					bruteForce.put(characters[i], values.get(characters[i]).get(j));

				}

			}
			
			if (isEven(bruteForce)) count++;

		}
		
		PrintWriter pw = new PrintWriter(new File("geteven.out"));
		pw.println(count);
		pw.close();

	}
	
	static boolean isEven(HashMap<String, Integer> hashMap) {
		
		int B = hashMap.get("B");
		int E = hashMap.get("E");
		int S = hashMap.get("S");
		int I = hashMap.get("I");
		int G = hashMap.get("G");
		int O = hashMap.get("O");
		int M = hashMap.get("M");
		
		return (B + E + S + S + I + E) * (G + O + E + S) * (M + O + O) % 2 == 0;
		
	}

}






