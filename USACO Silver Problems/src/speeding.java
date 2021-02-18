import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class speeding {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		TreeSet<Integer> points = new TreeSet<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] limit = new int[N][2];
		int[][] bessie = new int[M][2];
		
		int ltotal = 0;
		for (int i = 0; i < limit.length ; i++) {
			
			st = new StringTokenizer(br.readLine());
			limit[i][0] = Integer.parseInt(st.nextToken());
			limit[i][1] = Integer.parseInt(st.nextToken());
			points.add(ltotal + limit[i][0]);
			ltotal += limit[i][0];
			
		}
		
		int btotal = 0;
		for (int i = 0; i < bessie.length ; i++) {
			
			st = new StringTokenizer(br.readLine());
			bessie[i][0] = Integer.parseInt(st.nextToken());
			bessie[i][1] = Integer.parseInt(st.nextToken());
			points.add(btotal + bessie[i][0]);
			btotal += bessie[i][0];
			
		}
		
		br.close();
		
		int difference = Integer.MAX_VALUE;
		
		for (int distance : points) { // Critical Point
			
			int bSpeed = 0;
			for (int i = 0; i < bessie.length - 1; i++) {
				if (bessie[i][0] <= distance && distance < bessie[i + 1][0]) {
					bSpeed = bessie[i][1];
				}
			}
			
			int lSpeed = 0;
			for (int i = 0; i < limit.length - 1; i++) {
				if (limit[i][0] <= distance && distance < limit[i + 1][0]) {
					lSpeed = limit[i][1];
				}
			}
			
			if (bSpeed > lSpeed) {
				if (bSpeed - lSpeed > difference) {
					difference = bSpeed - lSpeed;
				}
			}
			
		}
		
		System.out.println(difference);
		
		
	}

}
