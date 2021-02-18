package year_2016.silver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class HoofPaperScissors {

	// Only Switches Once!

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter(new File("hps.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int games = Integer.parseInt(st.nextToken());

		char[] moves = new char[games];

		for (int i = 0; i < moves.length; i++) {

			st = new StringTokenizer(br.readLine());
			moves[i] = st.nextToken().charAt(0);

		}

	}

	/*
	 * public static int maxCharOccurances(char[] array, boolean second) {
	 * 
	 * int max = 0;
	 * 
	 * for (int i = 0; i < array.length; i++) {
	 * 
	 * }
	 * 
	 * }
	 * 
	 * public static char[] getCharactersNoDuplicate(char[] array) {
	 * 
	 * Character[] newArr = new Character[array.length]; for (int i = 0; i <
	 * array.length; i++) {
	 * 
	 * newArr[i] = array[i];
	 * 
	 * }
	 * 
	 * HashSet<Character> setOfAccounts = new
	 * HashSet<Character>(Arrays.asList(newArr)); return
	 * setOfAccounts.toArray((Character) setOfAccounts[i]);
	 * 
	 * }
	 */

}
