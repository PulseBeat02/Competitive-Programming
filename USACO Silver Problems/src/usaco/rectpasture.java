package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class rectpasture {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Cow[] cows = new Cow[N];
        long[] prefixSum = new long[100000];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            prefixSum[x] = 1;
            cows[i] = new Cow(i, x, y);
        }
        Arrays.parallelPrefix(prefixSum, (x, y) -> x + y);
        List<List<Cow>> allPossibilities = generatePossibilities(cows);
        int count = 1;
        for (int i = 0; i < allPossibilities.size(); i++) {
        	int minX = 0;
        	int minXIndex = 0;
        	int minY = 0;
        	int maxX = 0;
        	int maxXIndex = 0;
        	int maxY = 0;
        	for (Cow c : allPossibilities.get(i)) {
        		if (c.x < minX) {
        			minXIndex = c.index;
        			minX = c.x;
        		}
        		if (c.x > maxX) {
        			maxXIndex = c.index;
        			maxX = c.x;
        		}
        		minY = Math.min(c.y, minY);
        		maxY = Math.max(c.y, maxY);
        	}
        	if (prefixSum[maxXIndex] - prefixSum[minXIndex] - 1 > 0) {
        		count++;
        	}
        }
        System.out.println(count);
    }
    
    private static List<List<Cow>> generatePossibilities(Cow[] cows) {
    	List<List<Cow>> subsets = new ArrayList<>();
    	for (int i = 0; i < (1 << cows.length); i++) {
    		List<Cow> set = new ArrayList<>();
    		for (int j = 0; j < cows.length; j++) {
    			if ((i & (1 << j)) > 0) {
    				set.add(cows[j]);
    			}
    		}
    		subsets.add(set);
    	}
    	return subsets;
    }

    private static class Cow {
    	final int index;
        final int x;
        final int y;
        public Cow(int index, int x, int y) {
        	this.index = index;
        	this.x = x;
        	this.y = y;
        }
    }

}
