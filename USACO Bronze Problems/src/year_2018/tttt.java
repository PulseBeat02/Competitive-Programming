package year_2018;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class tttt {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("tttt.in")); // 

		char[][] grid = new char[3][3];

		grid[0] = br.readLine().toCharArray();
		grid[1] = br.readLine().toCharArray();
		grid[2] = br.readLine().toCharArray();

		br.close();

		ArrayList<char[]> sWins = new ArrayList<char[]>();
		ArrayList<char[]> tWins = new ArrayList<char[]>();

		boolean[] choicesS = new boolean[26];
		HashMap<String, Boolean> choicesT = new HashMap<String, Boolean>();

		// Do Rows

		for (int i = 0; i < 3; i++) {

			Set<Character> tWin = teamWin(grid[i]);

			if (singleWin(grid[i])) {

				if (!choicesS[grid[i][0] - 'A']) {

					choicesS[grid[i][0] - 'A'] = true;
					sWins.add(grid[i]);

				}

			}
			if (tWin.size() == 2) {

				if (!choicesT.containsKey(new String(grid[i]))) {

					choicesT.put(new String(toCharArray(tWin)), true);
					tWins.add(grid[i]);

				}

			}

		}

		// Do Columns

		for (int i = 0; i < 3; i++) {

			char[] current = { grid[0][i], grid[1][i], grid[2][i] };

			Set<Character> tWin = teamWin(current);

			if (singleWin(current)) {
				if (!choicesS[current[0] - 'A']) {

					choicesS[current[0] - 'A'] = true;
					sWins.add(current);

				}
			}
			if (tWin.size() == 2) {

				if (!choicesT.containsKey(new String(current))) {

					choicesT.put(new String(toCharArray(tWin)), true);
					tWins.add(current);

				}

			}

		}

		// Do Diagonals

		char[] leftDiagonal = { grid[0][0], grid[1][1], grid[2][2] };

		if (singleWin(leftDiagonal)) {

			if (!choicesS[leftDiagonal[0] - 'A']) {

				choicesS[leftDiagonal[0] - 'A'] = true;
				sWins.add(leftDiagonal);

			}

		}

		Set<Character> tWin1 = teamWin(leftDiagonal);

		if (tWin1.size() == 2) {

			if (!choicesT.containsKey(new String(toCharArray(tWin1)))) {

				choicesT.put(new String(toCharArray(tWin1)), true);
				tWins.add(leftDiagonal);

			}

		}

		char[] rightDiagonal = { grid[0][2], grid[1][1], grid[2][0] };

		if (singleWin(rightDiagonal)) {
			if (!choicesS[rightDiagonal[0] - 'A']) {

				choicesS[rightDiagonal[0] - 'A'] = true;
				sWins.add(rightDiagonal);

			}
		}

		Set<Character> tWin2 = teamWin(rightDiagonal);

		if (tWin2.size() == 2) {

			if (!choicesT.containsKey(new String(toCharArray(tWin2)))) {

				choicesT.put(new String(toCharArray(tWin2)), true);
				tWins.add(rightDiagonal);

			}

		}

		PrintWriter pw = new PrintWriter(new File("tttt.out"));
		pw.println(sWins.size());
		pw.println(tWins.size());
		
		pw.close();

	}

	public static char[] toCharArray(Set<Character> set) {

		char[] arr = new char[2];

		int index = 0;

		for (char c : set) {

			arr[index] = c;
			index++;

		}

		return arr;

	}

	public static boolean singleWin(char[] grid) {

		return grid[0] == grid[1] && grid[1] == grid[2] && grid[0] == grid[2];

	}

	public static Set<Character> teamWin(char[] grid) {

		Set<Character> set = new HashSet<Character>();

		for (int i = 0; i < grid.length; i++) {

			set.add(grid[i]);

		}

		return set; // That means there are only two letters, meaning there is a win

	}

}
