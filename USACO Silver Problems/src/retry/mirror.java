package retry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class mirror {

	public static char[][] grid;
	public static Set<String> pairs;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("mirror.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		grid = new char[N][M];
		pairs = new HashSet<>();
		
		for (int i = 0; i < grid.length; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		br.close();
		
		System.out.println(generateRecursions());
		
	}
	
	public static int generateRecursions() {
		int max = -1;
		for (int j = 0; j < grid[0].length; j++) { // TOP ROW
			recurse(0, j, MoveDirection.DOWN);
			if (pairs.size() > max) {
				max = pairs.size();
			}
			pairs.clear();
		}
		for (int j = 0; j < grid[0].length; j++) { // BOTTOM ROW
			recurse(grid.length - 1, j, MoveDirection.UP);
			if (pairs.size() > max) {
				max = pairs.size();
			}
			pairs.clear();
		}
		for (int i = 0; i < grid.length; i++) { // LEFT ROW
			recurse(0, i, MoveDirection.RIGHT);
			if (pairs.size() > max) {
				max = pairs.size();
			}
			pairs.clear();
		}
		for (int i = 0; i < grid.length; i++) { // RIGHT ROW
			recurse(grid.length - 1, i, MoveDirection.LEFT);
			if (pairs.size() > max) {
				max = pairs.size();
			}
			pairs.clear();
		}
		return max;
	}
	
	/*
	 * @param x -> current x value
	 * @param y -> current y value
	 * @param dir -> move direction
	 */
	public static void recurse(int x, int y, MoveDirection dir) {
		String key = formKey(x, y);
		if (pairs.contains(key)) {
			return;
		}
		pairs.add(key);
		if (grid[x][y] == '/') {
			switch (dir) {
			  case DOWN:
				  if (inBounds(x - 1, y)) {
					  recurse(x - 1, y, MoveDirection.LEFT);
				  }
				  break;
			  case UP:
				  if (inBounds(x + 1, y)) {
					  recurse(x + 1, y, MoveDirection.RIGHT);
				  }
				  break;
			  case LEFT:
				  if (inBounds(x, y - 1)) {
					  recurse(x, y - 1, MoveDirection.UP);
				  }
				  break;
			  case RIGHT:
				  if (inBounds(x, y + 1)) {
					  recurse(x, y + 1, MoveDirection.DOWN);
				  }
				  break;
			}
		} else if (grid[x][y] == '\\') {
			switch (dir) {
			  case DOWN:
				  if (inBounds(x - 1, y)) {
					  recurse(x - 1, y, MoveDirection.RIGHT);
				  }
				  break;
			  case UP:
				  if (inBounds(x + 1, y)) {
					  recurse(x + 1, y, MoveDirection.LEFT);
				  }
				  break;
			  case LEFT:
				  if (inBounds(x, y - 1)) {
					  recurse(x, y - 1, MoveDirection.DOWN);
				  }
				  break;
			  case RIGHT:
				  if (inBounds(x, y + 1)) {
					  recurse(x, y + 1, MoveDirection.UP);
				  }
				  break;
			}
		}
	}
	
	private enum MoveDirection {
		UP, DOWN, LEFT, RIGHT;
	}
	
	public static boolean inBounds(int x, int y) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
	}
	
	public static String formKey(int x, int y) {
		return x + "_" + y;
	}
	

}
