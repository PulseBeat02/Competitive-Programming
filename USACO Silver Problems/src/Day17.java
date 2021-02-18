import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day17 {
	static final int[][] directions3D = new int[26][];

	static {
		int x = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				for (int k = -1; k <= 1; k++) {
					if (i == 0 && j == 0 && k == 0) {
						continue;
					}
					directions3D[x] = new int[] { i, j, k };
					x++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("conwaycubes.txt"));
		List<String> lines = new ArrayList<>();
		String line = br.readLine();
		while (line != null) {
			lines.add(line);
			line = br.readLine();
		}
		br.close();
		System.out.println("Part One: " + part1(lines, 6));
	}
	
	static int part1(List<String> lines, int iteration) {
		char[][][] cube = createInitialCube3D(lines, iteration);
		for (int i = 0; i < iteration; i++) {
			cube = conway3D(cube);
		}
		return countActive3D(cube);
	}

	private static char[][][] createInitialCube3D(List<String> lines, int iteration) {
		int n = lines.size() + iteration * 2;
		char[][][] cube = new char[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					cube[i][j][k] = '.';
				}
			}
		}
		int i = iteration;
		for (String line : lines) {
			int j = iteration;
			for (char c : line.toCharArray()) {
				cube[n / 2 + 1][i][j] = c;
				j++;
			}
			i++;
		}
		return cube;
	}

	private static char[][][] conway3D(char[][][] cube) {
		int n = cube.length;
		char[][][] newCube = new char[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					int activeNeighbours = countActiveNeighbours3D(cube, i, j, k);
					if (cube[i][j][k] == '#' && (activeNeighbours < 2 || activeNeighbours > 3)) {
						newCube[i][j][k] = '.';
						continue;
					} else if (cube[i][j][k] == '.' && activeNeighbours == 3) {
						newCube[i][j][k] = '#';
						continue;
					}
					newCube[i][j][k] = cube[i][j][k];
				}
			}
		}
		return newCube;
	}
	private static int countActiveNeighbours3D(char[][][] cube, int x, int y, int z) {
		int count = 0;
		int n = cube.length;
		for (int[] direction : directions3D) {
			int newX = x + direction[0];
			int newY = y + direction[1];
			int newZ = z + direction[2];
			if (inBounds(newX, 0, n - 1) && inBounds(newY, 0, n - 1) && inBounds(newZ, 0, n - 1)) {
				if (cube[newX][newY][newZ] == '#') {
					count++;
				}
			}
		}
		return count;
	}

	public static boolean inBounds(int query, int min, int max) {
		return query >= min && query <= max;
	}

	private static int countActive3D(char[][][] cube) {
		int n = cube.length;
		int count = 0;
		for (char[][] chars : cube) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (chars[j][k] == '#') {
						count++;
					}
				}
			}
		}
		return count;
	}

}