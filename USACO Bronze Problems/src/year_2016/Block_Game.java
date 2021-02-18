package year_2016;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Block_Game {

	/*
	 * Algorithm: ------------------------------------
	 * 
	 * 1) BufferedReader 2) PrintWriter 3) StringTokenizer 4) Get number of words 5)
	 * Loop through words and populate array 6) Loop through each row in the 2d
	 * String array. 7) Make a variables called wordOneChar, wordTwoChar, and
	 * charMax. 8) First, make a method called "charOccurance". This will return the
	 * number of character occurrences in a following String, given the String and
	 * the character. 9) Apply charOccurance method to each String. For example, in
	 * the given example, you would apply this method to fox and box, then dog and
	 * cat, etc. 10) Then, you find the max of these two char occurrences. Add these
	 * char occurrences to the integer array that contains all 26 characters/ 11)
	 * Finally, print the final array.
	 * 
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
		PrintWriter pw = new PrintWriter(new File("blocks.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int words = Integer.parseInt(st.nextToken());

		String[][] allWords = new String[words][2];

		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		for (int i = 0; i < words; i++) {

			st = new StringTokenizer(br.readLine());
			allWords[i][0] = st.nextToken();
			allWords[i][1] = st.nextToken();

		}

		br.close();

		int[] letterCount = new int[alphabet.length];

		for (int i = 0; i < allWords.length; i++) {

			for (int j = 0; j < alphabet.length; j++) {

				String firstWord = allWords[i][0];
				String secondWord = allWords[i][1];

				int wordOneChar = 0;
				int wordTwoChar = 0;
				int charMax = 0;

				wordOneChar = charOccurance(firstWord, alphabet[j]);

				wordTwoChar = charOccurance(secondWord, alphabet[j]);

				charMax = Math.max(wordOneChar, wordTwoChar);

				letterCount[j] += charMax;

			}

		}

		for (int i = 0; i < letterCount.length; i++) {

			pw.println(letterCount[i]);

		}

		pw.close();

	}

	public static int charOccurance(String word, char c) {

		int counter = 0;

		for (int i = 0; i < word.length(); i++) {

			if (word.charAt(i) == c) {

				counter++;

			}

		}

		return counter;

	}

}
