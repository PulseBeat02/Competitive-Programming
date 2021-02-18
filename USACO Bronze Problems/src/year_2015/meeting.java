package year_2015;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class meeting {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("meeting.in")
		StringTokenizer st = new StringTokenizer(br.readLine());

		int target = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Node> paths = new ArrayList<>();

		Node parent = null;

		ArrayList<Integer> totalB = new ArrayList<Integer>();
		ArrayList<Integer> totalE = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());

			int field = Integer.parseInt(st.nextToken());
			int path = Integer.parseInt(st.nextToken());
			int elsie = Integer.parseInt(st.nextToken());
			int bessie = Integer.parseInt(st.nextToken());
			
			Node pa = checkNode(paths, field);
			Node ch; // = checkNode(paths, path);
			
			if (pa == null) {

				pa = new Node(field, new int[] { 0, 0 }, null);
				
				paths.add(pa);
			}
			
			ch = new Node(path, new int[] { bessie, elsie }, null);
			paths.add(ch);
			pa.children.add(ch);
			
			// find the children that are already in, and the time is 0;
			for (int a = 0; a < paths.size(); a++) {
				
				if ((paths.get(a).field == path) && (paths.get(a).time[0] == 0)) {
					
					pa.children.add(paths.get(a));			
					paths.get(a).time[0] = bessie;
					paths.get(a).time[1] = elsie;
					
				}
			}
			


//			} else {
//				
//				
//				Node ch = new Node(path, new int[] { bessie, elsie }, null);
//				boolean added = false;
//				
//				for (int a = 0; a < paths.size(); a++) {
//					
//					if (paths.get(a).field == field) {
//						
//						
//						
//						paths.get(a).children.add(ch);
//						if (!added) {
//							paths.add(ch);
//							added = true;
//						}
//					}
//					
//				}
//
//			}

		}
		
		br.close();

		for (int i = 0; i < paths.size(); i++) {
			
			if (paths.get(i).field == 1) {
				
				getPass(paths.get(i), 0, 0, target, totalB, totalE);
				break;
				
			}
			
		}
		
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < totalB.size(); i++) {

			for (int j = 0; j < totalE.size(); j++) {

				if (totalB.get(i) == totalE.get(j)) {

					if (totalB.get(i) < min) {

						min = totalB.get(i);

					}

				}

			}

		}

		PrintWriter pw = new PrintWriter(new File("meeting.out"));

		if (min == Integer.MAX_VALUE) {

			//pw.println("IMPOSSIBLE");
			System.out.println("IMPOSSIBLE");

		}

		else {

			//pw.println(min);
			System.out.println(min);
			
		}

		pw.close();

	}
	
	public static Node checkNode(ArrayList<Node> nodes, int field) {
		
		for (int i = 0; i < nodes.size(); i++) {
			
			if (nodes.get(i).field == field) {
				
				return nodes.get(i);
				
			}
			
		}
		
		return null;
		
	}

	public static int getPass(Node c, int bTime, int eTime, int target, ArrayList<Integer> bTimes,
			ArrayList<Integer> eTimes) {

		if (c.field == target) {

			bTimes.add(bTime);
			eTimes.add(eTime);

			return 0;

		} else {

			for (Node n : c.children) {

				getPass(n, bTime + n.time[0], eTime + n.time[1], target, bTimes, eTimes);

			}

		}

		return -1;

	}

}

class Node {

	int field;
	int[] time; // {bessie, elsie}

	List<Node> children = new ArrayList<Node>();

	Node parent;

	public Node(int field, int[] time, Node parent) {

		this.field = field;
		this.time = time;
		this.parent = parent;

	}

}
