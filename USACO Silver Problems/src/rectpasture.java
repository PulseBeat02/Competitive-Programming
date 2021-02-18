import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class rectpasture {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Cow[] xSort = new Cow[N];
        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xSort[i] = new Cow(x, y);
            cows[i] = new Cow(x, y);
            xSort[i].origIndex = i; 
        }
        Arrays.sort(xSort, Comparator.comparingInt(point -> point.x));
        for (int i = 0; i < xSort.length; i++) {
        	cows[xSort[i].origIndex].index = i;
        }
        Arrays.sort(cows, Comparator.comparingInt(point -> point.y));
        long count = (N * (N + 1)/2) + 1;
        for (int i = 0; i < cows.length; i++) {
        	int xMin = cows[i].x;
        	int xMax = xMin;
        	int minIndx = cows[i].index;
        	int maxIndx = minIndx;
        	for (int length = 1; i + length < N; length++) {
        		if (xMin > cows[i + length].x) {
        			xMin = cows[i + length].x;
        			minIndx = cows[i + length].index;
        		}
        		if (xMax < cows[i + length].x) {
        			xMax = cows[i + length].x;
        			maxIndx = cows[i + length].index;
        		}
        		for (int j = minIndx; j <= maxIndx; j++) {
        			if (xSort[j].y > cows[i + length].y || xSort[j].y < cows[i].y) {
        				count++;
        				break;
        			}
        		}
        	}
        }
        System.out.println(count);
    }

    private static class Cow {
        final int x;
        final int y;
        int index;
        int origIndex;
        public Cow(int x, int y) {
        	this.x = x;
        	this.y = y;
        }
    }

}