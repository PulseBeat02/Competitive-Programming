import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
//import java.util.HashSet;
import java.util.StringTokenizer;

public class fairphoto {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("fairphoto.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Cow[] cows = new Cow[N];
		int[] photo = new int[N];

		for (int i = 0; i < cows.length; i++) {

			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			String b = st.nextToken();
			
			photo[i] = b.equals("G") ? 1 : -1;

			Cow c = new Cow(num, b);
			cows[i] = c;

		}
		
		br.close();
		
		Arrays.parallelPrefix(photo, ((x, y) -> x + y));
		
//		int max = 0;
//		
//		HashSet<Integer> s_i = new HashSet<>();
//		
//		for (int i = 1; i < cows.length; i++) {
//			
//			Cow right = cows[i];
//			
//			//int sum = photo[right.x] - 
//			
//			
//		}
		

	}

	static class Cow implements Comparable<Cow> {

		char breed;
		int x; // index

		Cow(int x, String breed) {
			this.x = x;
			this.breed = breed.charAt(0);
		}

		public int compareTo(Cow other) {
			return this.x - other.x;
		}
	}

}
