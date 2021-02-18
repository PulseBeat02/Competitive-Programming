import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class reststops {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("reststops.in")) ;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int distance = Integer.parseInt(st.nextToken());
		int stopNumber = Integer.parseInt(st.nextToken());
		int fjSpeed = Integer.parseInt(st.nextToken());
		int bSpeed = Integer.parseInt(st.nextToken());
		
		RestStop[] stops = new RestStop[stopNumber];
		
		for (int i = 0; i < stops.length; i++) {
			
			st = new StringTokenizer(br.readLine());
			int xi = Integer.parseInt(st.nextToken());
			int ci = Integer.parseInt(st.nextToken());
			
			stops[i] = new RestStop(xi, ci);
			
		}
		
		br.close();
		
		int FJDist = 0;
		int BDist = 0;
		
		int answer = 0;
		
		for (int i = 0; i < stops.length; i++) {
			
			// If Farmer John isn't at Bessie
			// Get as much grass as possible
			// until Farmer John either catches
			// up with Bessie or Bessie runs out
			// of grass to eat.
			
			for (int j = 0; j < stops[i].xi; j++) {
				
				if (FJDist + fjSpeed < BDist) {
					
					answer += stops[i].ci;
					
				} else {
					
					break;
					
				}
				
			}
			
			
			
		}
		
		
	}
	
}

class RestStop {
	
	public int xi;
	public int ci;
	
	public RestStop(int length, int tastiness) {
		
		this.xi = length;
		this.ci = tastiness;
		
	}
	
}
