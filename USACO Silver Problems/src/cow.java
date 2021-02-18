import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class cow {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cow.in"));
		br.readLine();
		String str = br.readLine();

		char[] chars = str.toCharArray();

		br.close();

		long[] C = new long[chars.length];
		long[] O = new long[chars.length];
		long[] W = new long[chars.length];

		for (int i = 0; i < chars.length; i++) {

			if (chars[i] == 'C')
				C[i]++;
			else if (chars[i] == 'O')
				O[i] = previousSum(C, i);
			else if (chars[i] == 'W')
				W[i] = previousSum(O, i);

		}
		
	    PrintWriter out = new PrintWriter(new File("cow.out"));
	    // System.out.println(previousSum(W, W.length - 1));
	    out.println(previousSum(W, W.length - 1));
	    out.close();

	}

	public static long previousSum(long[] array, int index) {

		long sum = 0;

		for (int i = 0; i <= index; i++) {

			sum += array[i];

		}

		return sum;

	}

}
