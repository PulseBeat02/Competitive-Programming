import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mooyomooyo {

	public static int[][] grid;

	public static ArrayList<int[]> indexes = new ArrayList<>();
	public static int K = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		grid = new int[N][10];

		for (int i = 0; i < grid.length; i++) {

			String current = br.readLine();

			for (int j = 0; j < current.length(); j++) {

				grid[i][j] = current.charAt(j) - '0';

			}

		}

		br.close();

		boolean changed = false;

		for (;;) {

			for (int i = 0; i < grid.length; i++) {

				for (int j = 0; j < grid[i].length; j++) {

					if (grid[i][j] != 0) {

						int target = grid[i][j];

						recurse(i, j, target);

						if (indexes.size() >= K) {

							changed = true;

						} else {

							for (int in = 0; in < indexes.size(); in++) {

								grid[indexes.get(in)[0]][indexes.get(in)[1]] = target;

							}

						}

						// printGrid(target);

						indexes.clear();

					}
				}
			}

			if (changed) {

				grid = updateGrid();
				changed = false;

			} else {

				break;

			}

		}
		
		PrintWriter pw = new PrintWriter(new File("mooyomooyo.out"));
		
		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[i].length; j++) {

				pw.print(grid[i][j]);

			}

			pw.println();

		}
		
		pw.close();

	}

	public static void printGrid(int targetCell) {

		System.out.println("==============================");
		System.out.println("Parent Cell Index: " + Arrays.toString(indexes.get(0)));
		System.out.println("Target Cell Value: " + targetCell);

		for (int i = 0; i < grid.length; i++) {

			System.out.println(Arrays.toString(grid[i]));

		}

	}

	public static void recurse(int x, int y, int target) {

		grid[x][y] = 0; // Place Holder

		indexes.add(new int[] { x, y });

		if (inRange(x + 1, y) && grid[x + 1][y] == target) {

			recurse(x + 1, y, target);

		}
		if (inRange(x - 1, y) && grid[x - 1][y] == target) {

			recurse(x - 1, y, target);

		}
		if (inRange(x, y + 1) && grid[x][y + 1] == target) {

			recurse(x, y + 1, target);

		}
		if (inRange(x, y - 1) && grid[x][y - 1] == target) {

			recurse(x, y - 1, target);

		}

	}

	public static boolean inRange(int x, int y) {

		return x < grid.length && x >= 0 && y < grid[0].length && y >= 0;

	}

	public static int[] updateColumn(int[] col) {

		int[] arr = new int[col.length];
		int index = arr.length - 1;

		for (int i = col.length - 1; i >= 0; i--) {

			if (col[i] != 0) {

				arr[index] = col[i];
				index--;

			}

		}

		return arr;

	}

	public static int[][] updateGrid() {

		int[][] newGrid = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid[0].length; i++) {

			int index = grid.length - 1;

			for (int j = grid.length - 1; j >= 0; j--) {

				if (grid[j][i] != 0) {

					newGrid[index][i] = grid[j][i];
					index--;

				}

			}

		}
		
		return newGrid;

		/*
		 * while (!isFilled(grid[grid.length - 1])) { // Start With Last Row
		 * 
		 * for (int i = 0; i < grid[0].length; i++) { // Start With First Column, Then
		 * Go Right
		 * 
		 * if (grid[grid.length - 1][i] == 0) { // If the current cell is 0
		 * 
		 * 
		 * for (int j = grid.length - 1; j > 0; j--) { // Loop Through Column and Set
		 * Each Value Down (By Index)
		 * 
		 * grid[j][i] = grid[j - 1][i];
		 * 
		 * }
		 * 
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 */

	}

	public static boolean isFilled(int[] row) {

		for (int i = 0; i < row.length; i++) {

			if (row[i] == 0) {

				return false;

			}

		}

		return true;

	}

}
