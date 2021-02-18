package retry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class lightson {
	
	public static int N;
	public static int M;
	public static boolean[][] visited;
	public static boolean[][] lights;
	public static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][N];
		lights = new boolean[N][N];
		Map<Pair, List<Pair>> rooms = new HashMap<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Pair key = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Pair value = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if (rooms.containsKey(key)) {
				rooms.get(key).add(value);
			} else {
				List<Pair> list = new ArrayList<>();
				list.add(value);
				rooms.put(key, list);
			}

		}
		br.close();
		
		Pair start = new Pair(1, 1);
		lights[1][1] = true;
		recurse(rooms, start);
		System.out.println(count);

	}
	
	public static void recurse(Map<Pair, List<Pair>> rooms, Pair p) {
		if (visited[p.x][p.y] || !lights[p.x][p.y]) {
			return;
		}
		count++;
		visited[p.x][p.y] = true;
		if (rooms.containsKey(p)) {
			List<Pair> next = rooms.get(p);
			for (Pair pair : next) {
				lights[pair.x][pair.y] = true;
			}
		}
		
		if (inBounds(new Pair(p.x + 1, p.y))) {
			recurse(rooms, new Pair(p.x + 1, p.y));
		}
		if (inBounds(new Pair(p.x - 1, p.y))) {
			recurse(rooms, new Pair(p.x - 1, p.y));
		}
		if (inBounds(new Pair(p.x, p.y + 1))) {
			recurse(rooms, new Pair(p.x, p.y + 1));
		}
		if (inBounds(new Pair(p.x, p.y - 1))) {
			recurse(rooms, new Pair(p.x, p.y - 1));
		}
		
	}
	
	public static boolean inBounds(Pair p) {
		return p.x >= 0 && p.x < N && p.y >= 0 && p.y < N;
	}
	
}

class Pair {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

