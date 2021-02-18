import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class leftout {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("leftout.in"));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] g = new char[N][N];
		
		for (int i = 0; i < g.length; i++) {
			
			g[i] = br.readLine().toCharArray();
			
		}
		
		br.close();
		
		
		
	}

}
