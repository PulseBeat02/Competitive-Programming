import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class bteams {

	static List<List<Integer>> groups = new ArrayList<List<Integer>>();
	
	static int cows[][] = new int[12][2];
	static int s = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("bteams.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("bteams.out"));
		
		for (int i = 0; i < 4; i++) {
			groups.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < 12; i++) {
			cows[i][0] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		recurse();
		pw.println(s);
		
		pw.close();
	}

	public static void recurse() {
		
		int i = 0;
		for (; i < 12; i++) {
			if (cows[i][1] == 0) {
				break;
			}
		}
		
		
		if (i >= 12) {
			
			s = Math.min(s, getDiff());

		}
		

		for (int j = 0; j < 4; j++) {
			
			if (groups.get(j).size() < 3) {
				
				groups.get(j).add(cows[i][0]);
				cows[i][1] = 1;
				
				recurse();
				
				cows[i][1] = 0;
				groups.get(j).remove(new Integer(cows[i][0]));
				
			}
			
		}
		
	}

	public static int getDiff() {

		int S = -1;
		for (int i = 0; i < 4; i++) {
			S = Math.max(S, sum(i));
		}
		
		int s = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			s = Math.min(s, sum(i));
		}
		
		return S - s;

	}

	public static int sum(int index) {
		return groups.get(index).get(0) + groups.get(index).get(1) + groups.get(index).get(2);
	}

}
