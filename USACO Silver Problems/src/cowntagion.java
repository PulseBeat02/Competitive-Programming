import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class cowntagion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Farm[] farms = new Farm[N];
        for (int i = 0; i < farms.length; i++) {
        	farms[i] = new Farm(i);
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            farms[from].to.add(to);
            farms[to].to.add(from);
        }
        System.out.println(calculateSum(farms, 0, 1));
    }
    
    private static int calculateSum(Farm[] tree, int index, int diff) {
    	int size = 0;
    	for (int i = 1; i < tree[index].to.size() + diff; i *= 2) {
    		size++;
    	}
    	tree[index].visited = true;
    	for (int f : tree[index].to) {
    		if (!tree[f].visited) {
    			size += calculateSum(tree, f, 0) + 1;
    		}
    	}
    	return size;
    }

    public static class Farm {
    	private final Set<Integer> to;
        private boolean visited;
        public Farm(int id) {
        	this.to = new HashSet<>();
            this.visited = false;
        }
    }


}
