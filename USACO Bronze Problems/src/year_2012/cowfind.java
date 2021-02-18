package year_2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class cowfind {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("cowfind.in"));

		String ridges = br.readLine();

		br.close();

		char[] hide = ridges.toCharArray();

		int ans = 0;
		int backCount = 0;

		for (int i = 1; i < hide.length; i++) {
			if (hide[i - 1] == ')' && hide[i] == ')')
				ans += backCount;
			else if (hide[i - 1] == '(' && hide[i] == '(')
				backCount++;
		}

		PrintWriter pw = new PrintWriter(new File("cowfind.out"));
		pw.println(ans);
		pw.close();

	}

}
