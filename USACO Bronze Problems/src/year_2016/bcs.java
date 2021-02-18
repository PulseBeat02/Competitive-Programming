package year_2016;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bcs {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("bcs.in")

		String[] first = br.readLine().split(" ");

		int N = Integer.parseInt(first[0]);
		int K = Integer.parseInt(first[1]);

		PuzzlePiece[] pieces = new PuzzlePiece[K];

		for (int i = 0; i < pieces.length; i++) {

			String[] lines = new String[N];

			for (int j = 0; j < lines.length; j++) {

				lines[j] = br.readLine();

			}

			pieces[i] = new PuzzlePiece(lines);

		}

		br.close();

	}

}

class PuzzlePiece {

	int length;
	ArrayList<boolean[]> lines = new ArrayList<boolean[]>();

	public PuzzlePiece(String[] characters) {

		this.length = characters.length;

		for (int i = 0; i < characters.length; i++) {

			boolean[] current = new boolean[this.length];

			for (int j = 0; j < current.length; j++) {

				if (characters[i].charAt(j) == '#') {

					current[j] = true;

				}
			}
			
			lines.add(current);

		}

	}

//	public boolean shiftOne() {
//
//		for (int i = 0; i < this.length; i++) {
//
//			for (int j = 0; j < this.lines.get(i).length; j++) {
//
//				
//
//			}
//
//		}
//
//	}

}
