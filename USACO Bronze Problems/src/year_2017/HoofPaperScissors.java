package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HoofPaperScissors {

	/*
	 * Algorithm: --------------------------------------- 1) Use BufferedReader to
	 * get input file. 2) Use PrintWriter to print answer to file. 3) Use
	 * StringTokenizer to get values 4) Get number of games by using StringTokenizer
	 * (var-name: games) 5) Make a 2D array with length games and width 2 6) Make a
	 * for loop that loops until moves.length. Use StringTokenizer to define each of
	 * the values in the 2D array. 7) Hoof beats Scissors, Scissors beats Paper, and
	 * Paper beats Hoof 8) There are a total of 6 possibilities that the Hoof, Paper
	 * or Scissor can be:
	 * 
	 * - Hoof => 1, Paper => 2, Scissor => 3 - Hoof => 1, Paper => 3, Scissor => 2 -
	 * Hoof => 2, Paper => 1, Scissor => 3 - Hoof => 2, Paper => 3, Scissor => 1 -
	 * Hoof => 3, Paper => 2, Scissor => 1 - Hoof => 3, Paper => 1, Scissor => 2
	 * 
	 * 9) Use brute force by assigning each move with each number. 10) Use a for
	 * loop to loop through each of the moves, get the moves used, then an if
	 * statement to check if the move beats the other move. 11) If the inside
	 * variable beats the max, then max = currentMax. 12) Use PrintWriter to print
	 * out the max.
	 * 
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int games = Integer.parseInt(st.nextToken());

		int[][] moves = new int[games][2];

		for (int i = 0; i < moves.length; i++) {

			st = new StringTokenizer(br.readLine());
			moves[i][0] = Integer.parseInt(st.nextToken());
			moves[i][1] = Integer.parseInt(st.nextToken());

		}

		br.close();

		String[] moveNames = { "HOOF", "PAPER", "SCISSORS" };
		String[][] combinations = getCombinations(moveNames);
		
		int max = 0;

		for (int i = 0; i < combinations.length; i++) {
			
			int currentMax = 0;

			String[] currentCombinations = combinations[i];

			for (int j = 0; j < moves.length; j++) {

				String[] actualMoves = toActualMoves(moves[j], currentCombinations);
				
				if (actualMoves[0] == "HOOF" && actualMoves[1] == "SCISSORS") currentMax++;
				if (actualMoves[0] == "SCISSORS" && actualMoves[1] == "PAPER") currentMax++;
				if (actualMoves[0] == "PAPER" && actualMoves[1] == "HOOF") currentMax++;

			}
			
			if (currentMax > max) {
				
				max = currentMax;
				
			}

		}
		
		PrintWriter pw = new PrintWriter(new File("hps.out"));
		pw.println(max);
		pw.close();
		
	}

	public static String[] toActualMoves(int[] moves, String[] moveNames) {

		String[] array = { moveNames[moves[0] - 1], moveNames[moves[1] - 1] };

		return array;

	}

	public static String[][] getCombinations(String[] names) {

		String[][] combinations = new String[6][3];

		for (int i = 0; i < combinations.length; i++) {

			int index = 0;

			for (int j = 0; j < names.length; j++) {

				combinations[i][index] = names[j];
				index++;

			}

		}

		return combinations;

	}

}
