import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class cowcode {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
		String[] s = br.readLine().split(" ");
		
		String str = s[0];
		long N = Long.parseLong(s[1])-1;
		
		br.close();
		
		PrintWriter pw = new PrintWriter(new File("cowcode.out"));
		pw.println(parse(str, N));
		pw.close();

	}
	
	public static char parse(String s, long index) {
		if(index < s.length()) {
			return s.charAt((int)index);
		}
		long length = s.length();
		while(2*length <= index) {
			length *= 2;
		}
		if(length == index) {
			return parse(s, length-1);
		}
		return parse(s, index - length - 1);
	}

}
