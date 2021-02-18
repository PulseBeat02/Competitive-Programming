import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class diasychains {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] flowers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < flowers.length; i++) {
			flowers[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for (int i = 0; i < flowers.length; i++) {
			outer: for (int j = i; j < flowers.length; j++) {
				int sum = 0;
				for (int index = i; index <= j; index++) {
					sum += flowers[index];
				}
				double average = (double)sum/(j - i + 1);
				for (int index = i; index <= j; index++) {
					if (flowers[index] == average) {
						count++;
						continue outer;
					}
				}
			}
		}
		System.out.println(count);
	}

}
