package year_2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cowroute2 {

	public static void main(String[] args) throws IOException {

		// Do Separate for One Way and Two Way

		BufferedReader br = new BufferedReader(new FileReader("cowroute.in")); // new FileReader("cowroute.in")

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		Route[] routes = new Route[N];

		for (int i = 0; i < routes.length; i++) {

			st = new StringTokenizer(br.readLine());

			int cost = Integer.parseInt(st.nextToken());
			int cityNumber = Integer.parseInt(st.nextToken());

			int[] cities = new int[cityNumber];

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < cityNumber; j++) {

				cities[j] = Integer.parseInt(st.nextToken());

			}

			routes[i] = new Route(cost, cities, cityNumber);

		}
		
		br.close();

		int min = 1001;

		for (int i = 0; i < routes.length; i++) {

			// if the route[i] has A

			if (hasElement(routes[i].cities, A)) {

				if (canReach(routes[i].cities, A, B)) {

					if (routes[i].cost < min) {

						min = routes[i].cost;

					}

				} else {

					int indexA = -1;

					for (int j = 0; j < routes[i].cities.length; j++) {

						if (routes[i].cities[j] == A) {

							indexA = j;
							break;

						}

					}

					for (int z = indexA + 1; z < routes[i].cities.length; z++) {

						for (int c = 0; c < routes.length; c++) {

							if (c != i) {

								if (canReach(routes[c].cities, routes[i].cities[z], B)) {

									int cost = routes[i].cost + routes[c].cost;

									if (cost < min) {

										min = cost;

									}

								}

							}

						}

					}

				}

			}

		}

		int answer;

		if (min == 1001) {
			
			answer = -1;
			
		} else {

			answer = min;

		}

		PrintWriter pw = new PrintWriter(new File("cowroute.out"));
		pw.println(answer);
		pw.close();

	}

//	public static int reachTwo(Route[] routes, Route current, int city, int targetCity) {
//
//		// 1 -> 2, 4, 7, 3
//
//		ArrayList<Route> possibleRoutes = new ArrayList<Route>();
//		ArrayList<Integer> index = new ArrayList<Integer>();
//
//		for (int i = 0; i < routes.length; i++) {
//
//			if (hasElement(routes[i].cities, city) && !routes[i].equals(current)) {
//
//				possibleRoutes.add(routes[i]);
//
//				for (int j = 0; j < routes[i].cities.length; j++) {
//
//					if (routes[i].cities[j] == city) {
//
//						index.add(j);
//
//					}
//
//				}
//
//			}
//
//		}
//
//		int min = 1001;
//
//		for (int i = 0; i < possibleRoutes.size(); i++) {
//
//			for (int j = index.get(i); j < possibleRoutes.get(i).cityNumber; j++) {
//
//				if (possibleRoutes.get(i).cities[j] == targetCity) {
//
//					if (possibleRoutes.get(i).cost < min) {
//
//						min = possibleRoutes.get(i).cost;
//
//					}
//
//				}
//
//			}
//
//		}
//
//		if (min == 1001)
//			return -1;
//
//		return min;
//
//	}

	public static boolean hasElement(int[] cities, int city) {

		for (int i = 0; i < cities.length; i++) {

			if (cities[i] == city) {

				return true;

			}

		}

		return false;

	}

	public static boolean canReach(int[] cities, int A, int B) {

		int indexA = -1;
		int indexB = -1;

		for (int i = 0; i < cities.length; i++) {

			if (cities[i] == A)
				indexA = i;
			if (cities[i] == B)
				indexB = i;

		}

		if (indexA == -1 || indexB == -1)
			return false;

		return indexB > indexA;

	}

}

class Route {

	int cost;
	int[] cities;
	int cityNumber;

	public Route(int cost, int[] cities, int cityNumber) {

		this.cost = cost;
		this.cities = cities;
		this.cityNumber = cityNumber;

	}

}
