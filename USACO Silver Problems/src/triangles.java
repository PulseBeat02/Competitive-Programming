import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class triangles {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] posts = new int[N][2];
//		boolean[] pb = new boolean[N];

		HashMap<Integer, ArrayList<Integer>> countX = new HashMap<>(); // x --> y count
		HashMap<Integer, ArrayList<Integer>> countY = new HashMap<>(); // y --> x count

		for (int i = 0; i < posts.length; i++) {

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			posts[i][0] = x;
			posts[i][1] = y;
		}
		
		for (int i = 0; i < posts.length; i++) {
	
			if (!countX.containsKey(posts[i][0])) {
				
				ArrayList<Integer> a = new ArrayList<>();
				a.add(posts[i][1]);
				
				countX.put(posts[i][0], a);

			} else {
				
				countX.get(posts[i][0]).add(posts[i][1]);
				//countX.put(posts[i][0], countX.get(posts[i][0]));

			}

			if (!countY.containsKey(posts[i][1])) {
				
				ArrayList<Integer> b = new ArrayList<>();
				b.add(posts[i][0]);
				
				countY.put(posts[i][1], b);

			} else {
				
				countY.get(posts[i][1]).add(posts[i][0]);
				//countY.put(posts[i][1], countY.get(posts[i][1]));

			}

		}

		br.close();
		
		int area = 0;
		
		for (int key : countX.keySet()) {
			
			if (countX.get(key).size() > 1) {
				
				ArrayList<Integer> Y = countX.get(key);
				
 				for (int i = 0; i < Y.size() - 1; i++) {
					
					for (int j = i + 1; j < Y.size(); j++) {
						
						int y1 = Y.get(i);
						int y2 = Y.get(j);
						int x = 0;
						
						for (int z = 0; z < countY.get(y1).size(); z++) {
							x += Math.abs(countY.get(y1).get(z) - key);
						}
						
						for (int z = 0; z < countY.get(y2).size(); z++) {
							x += Math.abs(countY.get(y2).get(z) - key);
						}
						
						area += Math.abs(x * (y1 - y2));

//						for (int z = 0; z < countY.get(y1).size(); z++) {
//							
//							if (countY.get(y1).get(z) != key) {
//								
//								int x = countY.get(y1).get(z);
//								
//								area += Math.abs((key - x) * (y1 - y2));
//								
//							}
//							
//						}
//						
//						for (int z = 0; z < countY.get(y2).size(); z++) {
//							
//							if (countY.get(y2).get(z) != key) {
//								
//								int x = countY.get(y2).get(z);
//								
//								area += Math.abs((key - x) * (y1 - y2));
//								
//							}
//							
//						}

					}
					
				}
				
			}
			
		}
		
//		for (int key : countY.keySet()) {
//			
//			if (countY.get(key).size() > 1) {
//				
//				ArrayList<Integer> X = countY.get(key);
//				
// 				for (int i = 0; i < X.size() - 1; i++) {
//					
//					for (int j = i + 1; j < X.size(); j++) {
//						
//						int x1 = X.get(i);
//						int x2 = X.get(j);
//
//						for (int z = 0; z < countX.get(x1).size(); z++) {
//							
//							if (countX.get(x1).get(z) != key) {
//								
//								int y = countX.get(x2).get(z);
//								
//								area += Math.abs((key - y) * (x1 - x2));
//								
//							}
//							
//						}
//						
//						for (int z = 0; z < countX.get(x2).size(); z++) {
//							
//							if (countX.get(x2).get(z) != key) {
//								
//								int y = countX.get(x2).get(z);
//								
//								area += Math.abs((key - y) * (x1 - x2));
//								
//							}
//							
//						}
//
//					}
//					
//				}
//				
//			}
//			
//		}

		// remove those don't have same X or same Y
//		for (int i = 0; i < posts.length; i++) {
//			if ((countX.get(posts[i][0]) < 2) && (countY.get(posts[i][1]) < 2)) {
//				pb[i] = true;
//			}
//		}
//		for (int c1 = 0; (c1 < posts.length) && !pb[c1]; c1++) {
//
//			for (int c2 = 0; c2 < posts.length && !pb[c2]; c2++) {
//
//				// if (posts[c1][0] == posts[c2][0] || posts[c1][1] == posts[c2][1]) {
//
//				for (int c3 = 0; c3 < posts.length && !pb[c3]; c3++) {
//
//					if (c1 != c2 && c2 != c3 && c1 != c3) {
//
//						int area = 0;
//
//						if (posts[c1][1] == posts[c2][1] && posts[c1][0] == posts[c3][0]) {
//
//							area = Math.abs((posts[c1][0] - posts[c2][0]) * (posts[c1][1] - posts[c3][1]));
//
//						}
//
//						else if (posts[c1][1] == posts[c2][1] && posts[c2][0] == posts[c3][0]) {
//
//							area = Math.abs((posts[c1][0] - posts[c2][0]) * (posts[c2][1] - posts[c3][1]));
//
//						}
//
//						else if (posts[c1][0] == posts[c2][0] && posts[c1][1] == posts[c3][1]) {
//
//							area = Math.abs((posts[c1][1] - posts[c2][1]) * (posts[c1][0] - posts[c3][0]));
//
//						}
//
//						else if (posts[c1][0] == posts[c2][0] && posts[c2][1] == posts[c3][1]) {
//
//							area = Math.abs((posts[c1][1] - posts[c2][1]) * (posts[c2][0] - posts[c3][0]));
//
//						}
//
//						sum += area;
//
//					}
//
//				}
//
//			}
//
//			// }
//
//		}

		PrintWriter pw = new PrintWriter(new File("triangles.out"));
		pw.println(area % 1000000007);
		pw.close();

	}

}
