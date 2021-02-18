import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javafx.util.Pair;

public class perimeter {

	public static int[][] grid;
	public static HashSet<Pair<Integer, Integer>> group; // area is size of group
	public static HashSet<Pair<Integer, Integer>> current;
	public static int perimeter;

	public static void main(String[] args) throws IOException {

		// -1 -> Looped
		// 0 -> No
		// 1 -> Yes

		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));

		int N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		group = new HashSet<>();
		current = new HashSet<>();

		for (int i = 0; i < grid.length; i++) {

			String line = br.readLine();

			for (int j = 0; j < grid[i].length; j++) {

				if (line.charAt(j) == '#') {
					
					grid[i][j] = 1;
					current.add(new Pair<Integer, Integer>(i, j));
					
				} else {
					
					grid[i][j] = 0;
					
				}

			}

		}

		br.close();

		int maxArea = 0;
		int maxPerimeter = 0;

		while (true) {

			Pair<Integer, Integer> coords = getCoordinate();

			if (coords.getKey() == -1 && coords.getValue() == -1) {
				break;
			}

			recurse(coords);
			if (group.size() > maxArea) {
				maxArea = group.size();
				maxPerimeter = perimeter;
			} else if (group.size() == maxArea) {
				maxPerimeter = Math.min(maxPerimeter, perimeter);
			}

			group.clear();
			perimeter = 0;

		}

		PrintWriter pw = new PrintWriter(new File("perimeter.out"));
		pw.println(maxArea + " " + maxPerimeter);
		pw.close();

	}

	public static Pair<Integer, Integer> getCoordinate() {
		if (current.isEmpty()) {
			return new Pair<Integer, Integer>(-1, -1);
		} else {
			Pair<Integer, Integer> pair = null;
			for (Pair<Integer, Integer> p : current) {
				pair = p;
				break;
			}
			current.remove(pair);
			return pair;
		}
	}

	public static void recurse(Pair<Integer, Integer> pair) {

		int x = pair.getKey();
		int y = pair.getValue();
		
		grid[x][y] = -1;
		if (group.contains(pair)) {
			return;
		}
		perimeter += incrementPerimeter(x, y);
		group.add(pair);
		current.remove(pair);

		if (inBounds(x + 1, y) && grid[x + 1][y] == 1) {
			recurse(new Pair<Integer, Integer>(x + 1, y));
		}
		if (inBounds(x - 1, y) && grid[x - 1][y] == 1) {
			recurse(new Pair<Integer, Integer>(x - 1, y));
		}
		if (inBounds(x, y + 1) && grid[x][y + 1] == 1) {
			recurse(new Pair<Integer, Integer>(x, y + 1));
		}
		if (inBounds(x, y - 1) && grid[x][y - 1] == 1) {
			recurse(new Pair<Integer, Integer>(x, y - 1));
		}

	}

	public static boolean inBounds(int x, int y) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
	}

	public static int incrementPerimeter(int x, int y) {
		int count = 0;
		if (inBounds(x + 1, y) && grid[x + 1][y] == 0 || !inBounds(x + 1, y)) {
			count++;
		}
		if (inBounds(x - 1, y) && grid[x - 1][y] == 0 || !inBounds(x - 1, y)) {
			count++;
		}
		if (inBounds(x, y + 1) && grid[x][y + 1] == 0 || !inBounds(x, y + 1)) {
			count++;
		}
		if (inBounds(x, y - 1) && grid[x][y - 1] == 0 || !inBounds(x, y - 1)) {
			count++;
		}

		return count;
	}

}
