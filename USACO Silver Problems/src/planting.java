import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class planting {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("planting.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] degrees = new int[N];

		for (int i = 1; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			degrees[Integer.parseInt(st.nextToken()) - 1]++;
			degrees[Integer.parseInt(st.nextToken()) - 1]++;

		}
		
		br.close();
		
		int D = Arrays.stream(degrees).max().getAsInt();
		
		PrintWriter pw = new PrintWriter(new File("planting.out"));
		pw.println(D + 1);
		pw.close();

	}

}
