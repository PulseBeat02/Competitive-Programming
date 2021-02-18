import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class lightson {

	public static HashMap<Room, Room> rooms;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		rooms = new HashMap<>(M);

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			rooms.put(new Room(x, y), new Room(a, b));

		}
		
		br.close();

	}

	static class Room {

		public int x;
		public int y;

		public Room(int x, int y) {

			this.x = x;
			this.y = y;

		}

	}

}
