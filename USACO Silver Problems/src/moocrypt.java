import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class moocrypt {

	public static char[][] grid;

	public static int count = 0;

	public static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	public static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("moocrypt.in"));

		String[] a = br.readLine().split(" ");

		int N = Integer.parseInt(a[0]);
		int M = Integer.parseInt(a[1]);

		grid = new char[N][M];

		for (int i = 0; i < grid.length; i++) {

			grid[i] = br.readLine().toCharArray();

		}

		br.close();

		// The word MOO only has two character. M and O. So we can just make two loops

		int ans = -1;
		for (char i = 'A'; i <= 'Z'; i++) { // First Character:

			if (i == 'M')
				continue;

			for (char j = 'A'; j <= 'Z'; j++) { // Second Character

				if (j == 'O')
					continue;

				if (i != j) {

					ans = Math.max(ans, find(i, j));

				}

			}

		}
		
		PrintWriter pw = new PrintWriter(new File("moocrypt.out"));
		pw.println(ans);
		pw.close();
	}

	private static int find(char m, char o) {

		int count = 0;
		
		for (int i = 0; i < grid.length; i++) { // Loop Through Whole Grid
			for (int j = 0; j < grid[i].length; j++) {

				if (grid[i][j] == m) { // Check if it equals to the first character

					for (int k = 0; k < 8; k++) { 
						
						// 8 Possible Directions

						int nx = i + dx[k];
						int ny = j + dy[k];

						int fx = i + (2 * dx[k]);
						int fy = j + (2 * dy[k]);

						if (isInBounds(nx, ny) && isInBounds(fx, fy)) { // Check if in bounds

							if (grid[nx][ny] == o && grid[fx][fy] == o) {
								count++; // Add to count
							}

						}

					}

				}

			}
		}

		return count;
	}

	private static boolean isInBounds(int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
	}

}
