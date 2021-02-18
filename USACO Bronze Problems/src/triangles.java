import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class triangles {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] posts = new int[N][2];

		for (int i = 0; i < posts.length; i++) {

			st = new StringTokenizer(br.readLine());
			posts[i][0] = Integer.parseInt(st.nextToken());
			posts[i][1] = Integer.parseInt(st.nextToken());

		}
		
		br.close();

		int maxArea = 0;

		for (int c1 = 0; c1 < posts.length; c1++) {

			for (int c2 = 0; c2 < posts.length; c2++) {

				for (int c3 = 0; c3 < posts.length; c3++) {

					if (c1 != c2 && c2 != c3 && c1 != c3) {

						if (posts[c1][1] == posts[c2][1] && posts[c1][0] == posts[c3][0]) {

							int area = Math.abs((posts[c1][0] - posts[c2][0]) * (posts[c1][1] - posts[c3][1]));

							if (area > maxArea)
								maxArea = area;

						}
						
						else if (posts[c1][1] == posts[c2][1] && posts[c2][0] == posts[c3][0]) {

							int area = Math.abs((posts[c1][0] - posts[c2][0]) * (posts[c2][1] - posts[c3][1]));

							if (area > maxArea)
								maxArea = area;

						}

						else if (posts[c1][0] == posts[c2][0] && posts[c1][1] == posts[c3][1]) {

							int area = Math.abs((posts[c1][1] - posts[c2][1]) * (posts[c1][0] - posts[c3][0]));

							if (area > maxArea)
								maxArea = area;

						}

						else if (posts[c1][0] == posts[c2][0] && posts[c2][1] == posts[c3][1]) {

							int area = Math.abs((posts[c1][1] - posts[c2][1]) * (posts[c2][0] - posts[c3][0]));

							if (area > maxArea)
								maxArea = area;

						}

					}

				}

			}

		}

		PrintWriter pw = new PrintWriter(new File("triangles.out"));
		pw.println(maxArea);
		pw.close();

	}

}
