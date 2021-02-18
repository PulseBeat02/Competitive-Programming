package year_2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class measurement {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// new FileReader("measurement.in")

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		LogEntry[] arr = new LogEntry[N];

		for (int i = 0; i < arr.length; i++) {

			st = new StringTokenizer(br.readLine());

			int d = Integer.parseInt(st.nextToken());

			String c = st.nextToken();
			int cow = -1;

			if (c.contentEquals("Bessie")) {

				cow = 0;

			} else if (c.contentEquals("Elsie")) {

				cow = 1;

			} else {

				cow = 2;

			}

			int change = Integer.parseInt(st.nextToken());

			arr[i] = new LogEntry(d, cow, change);

		}

		br.close();

		LogEntry temp;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j].day < arr[j - 1].day) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}

		int bMilk = 0;
		int eMilk = 0;
		int mMilk = 0;

		int lastBMilk = 7;
		int lastEMilk = 7;
		int lastMMilk = 7;

		boolean b = false;
		boolean e = false;
		boolean m = false;

		int answer = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i].cow == 0) {

				lastBMilk += arr[i].change;
				bMilk += lastBMilk;

			} else if (arr[i].cow == 1) {

				lastEMilk += arr[i].change;
				eMilk += lastEMilk;

			} else {

				lastMMilk += arr[i].change;
				mMilk += lastMMilk;

			}

			int max = Math.max(bMilk, Math.max(eMilk, mMilk));

			boolean bessieOnNext = bMilk == max;
			boolean elsieOnNext = eMilk == max;
			boolean mildredOnNext = mMilk == max;
			if (b != bessieOnNext || e != elsieOnNext || m != mildredOnNext) {
				answer++;
			}
			b = bessieOnNext;
			e = elsieOnNext;
			m = mildredOnNext;

		}

		PrintWriter pw = new PrintWriter(new File("measurement.out"));
		// pw.println(answer - 1);
		pw.close();

		System.out.println(answer);

	}

}

class LogEntry {

	int day;
	int cow; // 0 Bessie, 1 Elsie, 2 Mildred
	int change;

	public LogEntry(int d, int c, int ch) {

		this.day = d;
		this.cow = c;
		this.change = ch;

	}

}
