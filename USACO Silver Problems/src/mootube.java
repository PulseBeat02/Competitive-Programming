import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class mootube {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		@SuppressWarnings("unchecked")
		LinkedList<Connection>[] connections = new LinkedList[N];
		int[][] query = new int[Q][2];

		for (int i = 0; i < N; i++) {
			connections[i] = new LinkedList<Connection>(); // Initialize the LinkedList
		}

		for (int i = 1; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1; // Index in LinkedList Array is that Node
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			connections[a].add(new Connection(b, w)); // Both nodes share the common relevance
			connections[b].add(new Connection(a, w));

		}

		for (int i = 0; i < query.length; i++) { // Read Query

			st = new StringTokenizer(br.readLine());
			query[i][0] = Integer.parseInt(st.nextToken());
			query[i][1] = Integer.parseInt(st.nextToken()) - 1;

		}

		br.close();
		
		PrintWriter pw = new PrintWriter(new File("mootube.out"));
		
		for (int i = 0; i < query.length; i++) {
			
			int count = 0;

			LinkedList<Integer> queue = new LinkedList<Integer>(); // LinkedList (Each element leads to the next)
			queue.add(query[i][1]); // Add the first element (the starting element of the search)

			boolean[] visited = new boolean[N]; // check if every single node is visited
			visited[query[i][1]] = true;

			while (!queue.isEmpty()) {

				int first = queue.getFirst(); // Get next element after the first one is deleted
				queue.remove(); // Remove the leading element (being used in the search)

				for (Connection out : connections[first]) { // For each corresponding connection in the LinkedList

					if (!visited[out.d] && out.w >= query[i][0]) {

						/*
						 * Check if the node wasn't visited and the relevance is greater or equal to K.
						 * (Because we can completely eliminate branches with a relevance lower than K)
						 * 
						 */
						
						// Set the node to be visited
						visited[out.d] = true;
						
						queue.add(out.d);
						
						/*
						 * Here, we add the new node to the existing Tree to be searched further.
						 * That's why we have the queue, because it helps search through all
						 * possible values on the map.
						 * 
						 */
						
						count++;

					}
				}

			}
			
			pw.println(count);

		}
		
		pw.close();
		
	}

	static class Connection {

		public int d;
		public int w;

		public Connection(int d1, int w1) {

			d = d1;
			w = w1;

		}

	}

}
