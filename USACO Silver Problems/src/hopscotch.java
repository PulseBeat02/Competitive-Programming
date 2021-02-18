import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class hopscotch {

	public static int count = 0;
	public static char[][] grid;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("hopscotch.in"));
		String[] a = br.readLine().split(" ");

		int R = Integer.parseInt(a[0]);
		int C = Integer.parseInt(a[1]);

		grid = new char[R][C];

		for (int i = 0; i < grid.length; i++) {

			grid[i] = br.readLine().toCharArray();

		}

		br.close();
		recurse(0, 0, grid[0][0]);

		PrintWriter pw = new PrintWriter(new File("hopscotch.out"));
		pw.println(count);
		pw.close();

	}

	public static void recurse(int r, int c, char current) {

		if (r == grid.length - 1 && c == grid[0].length - 1) {

			count++;
			return;

		}

		for (int i = r + 1; i < grid.length; i++) {

			for (int j = c + 1; j < grid[i].length; j++) {

				switch (current) {

				case 'R':

					switch (grid[i][j]) {

					case 'R':
						break;

					case 'B':
						recurse(i, j, 'B');
						break;

					}
					break;

				case 'B':

					switch (grid[i][j]) {

					case 'R':
						recurse(i, j, 'R');
						break;

					case 'B':
						break;

					}
					break;

				}

			}

		}
		return;

	}
}
