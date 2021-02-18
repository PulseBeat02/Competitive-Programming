import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class breedflip {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));

		br.readLine();

		char[] wanted = br.readLine().toCharArray();
		char[] current = br.readLine().toCharArray();

		int count = 0;
		
		br.close();

		for (;;) {
			
			if (new String(wanted).equals(new String(current))) break;
			
			char[][] arr = trim(wanted, current);
			current = arr[0];
			wanted = arr[1];

			for (int i = 0; i < current.length; i++) {

				if (current[i] == 'G') {
					
					current[i] = 'H';
					
				} else {

					current[i] = 'G';

				}

			}

			count++;

		}
		
		PrintWriter pw = new PrintWriter(new File("breedflip.out"));
		pw.print(count);
		pw.close();

	}

	public static char[][] trim(char[] wanted, char[] current) {

		String c = new String(current);
		String w = new String(wanted);
		
		int begin = 0;

		for (int i = 0; i < current.length; i++) {

			if (current[i] == wanted[i]) {

				begin++;

			} else {
				
				break;
				
			}

		}
		
		int end = current.length;

		for (int i = current.length - 1; i > 1; i--) {

			if (current[i] == wanted[i]) {

				end--;

			} else {
				
				break;
				
			}

		}
		
		c = c.substring(begin, end);
		w = w.substring(begin, end);

		return new char[][] { c.toCharArray(), w.toCharArray() };

	}

}
