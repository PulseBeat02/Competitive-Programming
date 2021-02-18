import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class cowart {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cowart.in"));

		int N = Integer.parseInt(br.readLine());

		boolean[][] visited = new boolean[N][N];
		char[][] human = new char[N][N];
		char[][] cow = new char[N][N];

		for (int i = 0; i < N; i++) {

			char[] arr = br.readLine().toCharArray();
			
			for (int j = 0; j < arr.length; j++) {
				
				if (arr[j] == 'R' || arr[j] == 'G') {
					
					cow[i][j] = 'C';
					
				} else {
					
					cow[i][j] = 'B';
					
				}
				
				human[i][j] = arr[j];
				
			}

		}

		br.close();

		int cows = solve(visited, cow);
		int humans = solve(visited, human);
		
		PrintWriter pw = new PrintWriter(new File("cowart.out"));
		pw.println(humans + " " + cows);
		pw.close();
		
		// System.out.println(humans + " " + cows);

	}

	public static int solve(boolean[][] b, char[][] array) {

		int count = 0;
		
		for (boolean[] row : b) {
			Arrays.fill(row, false);
		}

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				if (!b[i][j]) {
					count++;
					check(i, j, b, array);
				}
			}

		}

		return count;

	}

	public static void check(int x, int y, boolean[][] c, char[][] g) { // x,y, boolean[][], grid

		if (c[x][y]) {
			return;
		}
		c[x][y] = true;

		if ((x + 1) < c.length && !c[x + 1][y] && g[x][y] == g[x + 1][y]) {
			check(x + 1, y, c, g);
		}
		if ((x - 1) >= 0 && !c[x - 1][y] && g[x][y] == g[x - 1][y]) {
			check(x - 1, y, c, g);
		}
		if ((y + 1) < c[0].length && !c[x][y + 1] && g[x][y] == g[x][y + 1]) {
			check(x, y + 1, c, g);
 		}
		if ((y - 1) >= 0 && !c[x][y - 1] && g[x][y] == g[x][y - 1]) {
			check(x, y - 1, c, g);
		}

	}

}
