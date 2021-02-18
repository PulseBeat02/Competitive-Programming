package year_2011.moosickold;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class moosick2 {

	/*
	 * Algorithm: ---------------------------- 
	 * 1) BufferedReader 
	 * 2) String Tokenizer
	 * 3) Make an array of notes in song 
	 * 4) Make an array of ruminent seventh chords
	 * 5) Loop through each three elements in the array of notes 
	 * 6) Make another loop with the ruminent seventh chords and check to make sure numbers don't
	 * pass 10 
	 * 7) If ruminent chord is found, count++; 8) Put in ArrayList the
	 * ruminent chord
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("moosick.in")
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = 0;
		int C = 0;
		
		int[] notes = {};
		int[] ruminent = {};
		
		int[] copy = ruminent;

		read(br, st, N, notes, C, ruminent);
		
		int count = 0;
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for (int i = 0; i < notes.length - 3; i+=3) {
			
			for (int j = 0; j < ruminent.length; j++) {
				
				int[] transposed = transpose(copy, j);
				
				if (isOver(transposed)) {
					
					copy = ruminent;
					break;
					
				}
				
				else {
					
					int[] current = {notes[i], notes[i+1], notes[i+2]};
					
					if (isChanged(current, transposed)) {
						
						count++;
						index.add(i + 1);
						
					}
					
				}
				
				copy = ruminent;
				
			}
			
		}
		
		PrintWriter pw = new PrintWriter(new File("moosick.out"));
		
		System.out.println(count);
		
		//pw.println(count);
		
		for (int i = 0; i < index.size(); i++) {
			
			//pw.println(index.get(i));
			
			System.out.println(index.get(i));
			
		}
		
		pw.close();

	}

	public static void read(BufferedReader br, StringTokenizer st, int N, int[] notes, int C, int[] ruminent)
			throws IOException {

		N = Integer.parseInt(st.nextToken());

		notes = new int[N];

		for (int i = 0; i < notes.length; i++) {

			st = new StringTokenizer(br.readLine());
			notes[i] = Integer.parseInt(st.nextToken());

		}
		
		st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		
		ruminent = new int[C];
		
		for (int i = 0; i < ruminent.length; i++) {
			
			st = new StringTokenizer(br.readLine());
			ruminent[i] = Integer.parseInt(st.nextToken());
			
		}

	}
	
	public static boolean isOver(int [] array) {
		
		return array[0] > 10 || array[1] > 10 || array[2] > 10;
		
	}
	
	public static int[] transpose(int [] array, int change) {
		
		int [] newArray = {array[0] + change, array[1] + change, array[2] + change};
		return newArray;
		
	}
	
	public static boolean isChanged(int[] array1, int[] array2) {
		
		Arrays.parallelSort(array1);
		Arrays.parallelSort(array2);
		
		return Arrays.equals(array1, array2);
		
	}

}




