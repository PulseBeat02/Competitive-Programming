package usopen2019.redo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class factory {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] routes = new int[N - 1][2]; // Make array

		for (int i = 0; i < N - 1; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < routes[0].length; j++) {

				routes[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		
		int[] stations = getAllStations(routes);
		
		ArrayList<Integer> reached = new ArrayList<>();
		
		int min = 100;
		
		for (int i = 0; i < stations.length; i++) {
			
			for (int j = 0; j < routes.length; j++) {
				
				if (routes[j][0] == stations[i]) {
					
					reached.add(routes[j][1]);
					
				}
				
			}
			
			if (didReach(stations, reached)) {
				
				if (stations[i] < min) {
					
					min = stations[i];
					
				}
				
			}
			
		}
		
		if (min == 100) min = -1;
		
		System.out.println(min);

	}
	
	public static boolean didReach(int[] stations, ArrayList<Integer> routes) {
		
		if (stations.length != routes.size()) return false;
		
		Arrays.parallelSort(stations);
		Collections.sort(routes);
		
		for (int i = 0; i < stations.length; i++) {
			
			if (stations[i] != routes.get(i)) return false;
			
		}
		
		return true;
		
	}

	public static int[] getAllStations(int[][] routes) {

		Set<Integer> values = new HashSet<>();

		for (int i = 0; i < routes.length; i++) {

			for (int j = 0; j < routes[i].length; j++) {

				values.add(routes[i][j]);

			}

		}

		return values.stream().mapToInt(Integer::intValue).toArray();

	}

}
