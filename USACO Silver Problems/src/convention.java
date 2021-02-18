import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class convention {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] times = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < times.length; i++) {
			
			times[i] = Integer.parseInt(st.nextToken());
			
		}
		
		br.close();
		
		Arrays.parallelSort(times);
		
		int maxTime = 0;
		
		for (int i = 0; i < times.length; i += 2) {
			
			
			
		}

	}

}