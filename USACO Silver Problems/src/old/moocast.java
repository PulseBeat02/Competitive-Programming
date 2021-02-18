package old;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class moocast {
	
	public static Cow[] cows;
	
	public static boolean[] flood;

	public static int count = 0;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		cows = new Cow[N];
		
		for (int i = 0; i < cows.length; i++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			cows[i] = new Cow(x, y, p, i);
			
		}
		
		br.close();
		
		flood = new boolean[N];
		
		for (int i = 0; i < cows.length; i++) {
			
			for (int j = i + 1; j < cows.length; j++) {
				
				if (canTransmit(cows[i], cows[j])) {
					
					cows[i].canTransmit.add(cows[j]);
					
				}
				
			}
			
		}
		
		int max = 0;
		
		for (int i = 0; i < cows.length; i++) {
			
			floodfill(cows[i]);
			
			max = Math.max(max, count + 1);
			count = 0;
			
			Arrays.fill(flood, false);
			
		}
		
		PrintWriter pw = new PrintWriter(new File("moocast.out"));
		pw.println(max);
		pw.close();
		
	}
	
	public static void floodfill(Cow current) {
		
		if (flood[current.index]) return;
		flood[current.index] = true;
		
		count++;
		
		for (int i = 0; i < current.canTransmit.size(); i++) {
			
			floodfill(current.canTransmit.get(i));
			
		}
		
		
	}
	
	public static boolean canTransmit(Cow c1, Cow c2) {
		
		return (Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y)) <= c1.p;
		
	}
	
	static class Cow {
		
		public int x;
		public int y;
		public int p;
		public int index;
		
		public ArrayList<Cow> canTransmit; // This cow can transmit to the cows in this arraylist
		
		public Cow(int x_, int y_, int p_, int index_) {
			
			this.x = x_;
			this.y = y_;
			this.p = p_;
			this.index = index_;
			
			canTransmit = new ArrayList<>();
			
		}
		
	}

}
