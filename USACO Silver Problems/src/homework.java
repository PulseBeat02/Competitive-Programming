import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class homework {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("homework.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] hw = new int[N];
		
		for (int i = 0; i < hw.length; i++) {
			
			hw[i] = Integer.parseInt(st.nextToken());
			
		}
		
		br.close();
		
		int ans = 0;
		int curAverage = 0;
		
		for (int k = 1; k < N - 2; k++) { // 100,000
			
			int[] arr = Arrays.copyOfRange(hw, k, hw.length);
			Arrays.parallelSort(arr);
			
			int sum = 0;
			
			for (int i = 1; i < arr.length; i++) {
				
				sum += arr[i];
				
			}
			
			if (sum/(arr.length - 1) > curAverage) {
				
				curAverage = Math.max(ans, sum/(arr.length - 1));
				ans = k;
				
			}
			
			
		}
		
		

	}

}
