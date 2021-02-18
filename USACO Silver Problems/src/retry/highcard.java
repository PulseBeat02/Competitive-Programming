package retry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class highcard {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		br.close();
		
		int points = 0;
		for (int i = 1; i <= 2*N; i++) {
			Iterator<Integer> itr = set.iterator();
			while (itr.hasNext()) {
				int num = itr.next();
				if (i > num) {
					set.remove(num);
					points++;
					break;
				} else {
					break;
				}
			}
		}

		System.out.println(points);
		

	}

}
