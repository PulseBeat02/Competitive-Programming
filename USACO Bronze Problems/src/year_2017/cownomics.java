package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class cownomics {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] spotty = new String[N];
		String[] plain = new String[N];

		for (int i = 0; i < spotty.length; i++) {

			st = new StringTokenizer(br.readLine());
			spotty[i] = st.nextToken();

		}

		for (int i = 0; i < plain.length; i++) {

			st = new StringTokenizer(br.readLine());
			plain[i] = st.nextToken();

		}
		
		br.close();

		int count = 0;

		for (int j = 0; j < M; j++) {

			Set<Character> spots = new HashSet<Character>();

			for (int s = 0; s < N; s++) {

				spots.add(spotty[s].charAt(j));

			}

			Set<Character> normal = new HashSet<Character>();

			for (int s = 0; s < N; s++) {

				normal.add(plain[s].charAt(j));

			}

			if (notEqual(spots, normal)) {

				count++;

			}

		}

		System.out.println(count);
		
		PrintWriter pw = new PrintWriter(new File("cownomics.out"));
		pw.println(count);
		pw.close();

	}

	public static boolean notEqual(Set<Character> a, Set<Character> b) {

		List<Character> sortedLista = new ArrayList<>(a);
		List<Character> sortedListb = new ArrayList<>(b);

		for (int i = 0; i < sortedLista.size(); i++) {

			if (sortedListb.contains(sortedLista.get(i))) {

				return false;

			}

		}

		return true;

	}

}
