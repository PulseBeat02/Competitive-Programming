package year_2011;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class moosick {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("moosick.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] notes = new int[N];

		for (int i = 0; i < notes.length; i++) {

			st = new StringTokenizer(br.readLine());
			notes[i] = Integer.parseInt(st.nextToken());

		}
		st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());

		int[] chords = new int[C];

		for (int i = 0; i < chords.length; i++) {

			st = new StringTokenizer(br.readLine());
			chords[i] = Integer.parseInt(st.nextToken());

		}
		
		br.close();

		int count = 0;

		ArrayList<Integer> starts = new ArrayList<Integer>();

		for (int i = 0; i < notes.length - C + 1; i++) {

			int[] cChord = new int[C];
			
			for (int a = 0; a < cChord.length; a++) {
				
				cChord[a] = notes[a + i];
				
			}
			
			if (sortedMatrix(cChord, chords)) {
				
				count++;
				starts.add(i + 1);
				
			}

		}

		PrintWriter pw = new PrintWriter(new File("moosick.out"));
		pw.println(count);
		
		for (int i = 0; i < starts.size(); i++) {
			
			pw.println(starts.get(i));
			
		}
		
		pw.close();

	}
	
	public static boolean sortedMatrix(int[] ruminant, int[] chord) {
		
		int[] first = ruminant;
		int[] second = chord;
		
		Arrays.parallelSort(first);
		Arrays.parallelSort(second);
		
		int one = ruminant[0] - chord[0];
		
		for (int i = 1; i < ruminant.length; i++) {
			
			if (ruminant[i] - chord[i] != one) {
				
				return false;
				
			}
			
		}
		
		return true;

		
	}

//	public static boolean isRuminantAdd(int[] ruminants, int[] chord) {
//		
//		if (Arrays.equals(ruminants, chord)) {
//			
//			System.out.println(Arrays.toString(chord));
//
//			return true;
//
//		}
//		
//		if (isAbove(chord, ruminants)) {
//
//			return false;
//
//		}
//		
//		if (sameSorted(ruminants, chord)) {
//			
//			return true;
//			
//		}
//		
//		chord = addOne(chord);
//
//		return isRuminantAdd(ruminants, chord);
//
//	}
//
//	public static boolean isRuminantSubtract(int[] ruminants, int[] chord) {
//		
//		if (Arrays.equals(ruminants, chord)) {
//			System.out.println(Arrays.toString(chord));
//			return true;
//
//		}
//		
//		if (isBelow(chord, ruminants)) {
//
//			return false;
//
//		}
//		
//		if (sameSorted(ruminants, chord)) {
//			
//			return true;
//			
//		}
//
//		chord = subtractOne(chord);
//
//		return isRuminantAdd(ruminants, chord);
//
//	}
//
//	public static boolean isBelow(int[] chord, int[] ruminants) {
//
//		return chord[0] < ruminants[0] || chord[1] < ruminants[1] || chord[2] < ruminants[2];
//
//	}
//
//	public static boolean isAbove(int[] chord, int[] ruminants) {
//
//		return chord[0] > ruminants[0] || chord[1] > ruminants[1] || chord[2] > ruminants[2];
//
//	}
//
//	public static int[] addOne(int[] chord) {
//
//		chord[0]++;
//		chord[1]++;
//		chord[2]++;
//
//		return chord;
//
//	}
//
//	public static int[] subtractOne(int[] chord) {
//
//		chord[0]++;
//		chord[1]++;
//		chord[2]++;
//
//		return chord;
//
//	}

}
