package old;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class perimeter {

	public static boolean[][] visited;
	public static boolean[][] used;

	public static int perimeter;

	public static boolean inBounds(int x, int y, int N) {
		return x >= 0 && x <= N + 1 && y >= 0 && y <= N + 1;
	}

	public static void flood(int x, int y, int N) {

		if (used[x][y]) {
			perimeter++;
			return;
		}

		if (visited[x][y]) {
			return;
		}

		visited[x][y] = true;

		if (inBounds(x - 1, y, N)) {
			flood(x - 1, y, N);
		}
		
		if (inBounds(x + 1, y, N)) {
			flood(x + 1, y, N);
		}
		
		if (inBounds(x, y - 1, N)) {
			flood(x, y - 1, N);
		}
		
		if (inBounds(x, y + 1, N)) {
			flood(x, y + 1, N);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));

		int N = Integer.parseInt(br.readLine());

		visited = new boolean[N + 2][N + 2];
		used = new boolean[N + 2][N + 2];

		for (int i = 0; i < N; i++) {

			String[] str = br.readLine().split(" ");
			used[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = true;

		}
		br.close();

		flood(0, 0, N);
		
		PrintWriter pw = new PrintWriter(new File("perimeter.out"));
		pw.println(perimeter);
		pw.close();

	}

}
