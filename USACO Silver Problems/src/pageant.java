// Welcome back to CS91! Please SHARE WEBCAMS and open VM software!

// http://www.usaco.org/index.php?page=viewproblem2&cpid=87
// Cow Beauty Pageeant

import java.util.*;
import java.io.*;

public class pageant {
	static char[][] grid;
	static int n, m;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("pageant.in"));
		n = in.nextInt();
		m = in.nextInt();
		grid = new char[n][];

		for (int r = 0; r < n; r++) {
			grid[r] = in.next().toCharArray();
		}
		in.close();

		List<Cell> spot1 = null;
		for (int r = 0; r < n && spot1 == null; r++) {
			for (int c = 0; c < m && spot1 == null; c++) {
				if (grid[r][c] == 'X') {
					spot1 = floodX(r, c);
				}
			}
		}

		int result = floodAtoX(spot1) - 1;

		PrintWriter out = new PrintWriter(new File("pageant.out"));
		System.out.println(result);
		out.println(result);
		out.close();
	}

	static int floodAtoX(List<Cell> start) {

		Deque<Cell> queue = new ArrayDeque<>(start);

		int min = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[n][n];

		for (int i = 0; i < start.size(); i++) {

			Cell c = start.get(i);
			queue.add(c);

			while (queue.size() > 0) {

				Cell cl = queue.remove();
				
				if (cl.c == c.c || cl.r == c.r) {

					queue.add(new Cell(cl.r + 1, cl.c, cl.steps + 1));
					queue.add(new Cell(cl.r - 1, cl.c, cl.steps + 1));
					queue.add(new Cell(cl.r, cl.c + 1, cl.steps + 1));
					queue.add(new Cell(cl.r, cl.c - 1, cl.steps + 1));

				} else {

					if (cl.r < 0 || cl.r >= n || cl.c < 0 || cl.c >= m)
						continue;
					if (visited[cl.r][cl.c] || grid[cl.r][cl.c] == 'A')
						continue;

					if (grid[cl.r][cl.c] == 'X') {

						min = Math.min(min, cl.steps);
						continue;
					}
					visited[cl.r][cl.c] = true;

				//	if(cl.r+1 )
					queue.add(new Cell(cl.r + 1, cl.c, cl.steps + 1));
					queue.add(new Cell(cl.r - 1, cl.c, cl.steps + 1));
					queue.add(new Cell(cl.r, cl.c + 1, cl.steps + 1));
					queue.add(new Cell(cl.r, cl.c - 1, cl.steps + 1));

				}

			}

		}

		// TODO: decide whether to use a visited boolean[][] or to just change
		// the grid itself as you go to mark which cells have been visited

		// TODO: go through floodfill process using this queue, adding 1 to
		// steps taken every time you flood,
		// TODO: return the step count when you hit an X

		return min; // should never happen
	}

	// floods all Xs around starting r,c, adding all to list with steps=0
	static List<Cell> floodX(int r, int c) {
		List<Cell> result = new ArrayList<>();

		boolean[][] visited = new boolean[n][m];
		Deque<Cell> queue = new ArrayDeque<>();
		// Deques have .add and .remove methods which remove things from "a line"
		// in the order they got into line (from the front of line)
		// queues lead to BFS ordering
		// (stacks using .push and .pop to interact with the Deque will lead
		// to depth-first ordering)

		queue.add(new Cell(r, c, 0));

		// keep visiting Cells as long as there are still any in line
		while (queue.size() > 0) {
			Cell cl = queue.remove(); // next Cell in line

			// continue = skip to next cell (if we're out of bounds or bad grid spot)
			if (cl.r < 0 || cl.r >= n || cl.c < 0 || cl.c >= m)
				continue;
			if (visited[cl.r][cl.c] || grid[cl.r][cl.c] != 'X')
				continue;

			visited[cl.r][cl.c] = true;
			grid[cl.r][cl.c] = 'A';
			// this notation could've also served double-duty for "visited"

			result.add(cl);

			queue.add(new Cell(r + 1, c, 0)); // flood to other cells in this spot
			queue.add(new Cell(r - 1, c, 0)); // all of which are 0 steps from
			queue.add(new Cell(r, c + 1, 0)); // the starting spot
			queue.add(new Cell(r, c - 1, 0));
		}

		return result;
	}

	static class Cell {
		int r, c;
		int steps; // cells in 1st spot have steps=0, later cells have more

		Cell(int rr, int cc, int s) {
			r = rr;
			c = cc;
			steps = s;
		}
	}
}

/*
 * ANALYSIS
 * 
 * 6 16 ................ ..XXXX....XXX... ...XXXX....XX... .XXXX......XXX..
 * ........XXXXX... .........XXX....
 * 
 * 321111234....... 21AAAA1234XXX... 211AAAA1234XX... 1AAAA11234.XXX..
 * 21111223$XXXX... 32222334.XXX....
 * 
 * $ - marks where a 4 went on top of X - in 4 steps we went all the way from A
 * to X, therefore in 4-1=3 steps, we would have connected A to X
 * 
 * BFS - Breadth-First Search (or Breadth-first Flood Fill) means you expand all
 * the way around starting spots before going further in any direction
 * 
 * overall estimate: 50*50 = 2500 = O(n*m) = O(n^2)
 * 
 */
