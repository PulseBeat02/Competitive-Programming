package year_2015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class badmilk {
	
	
	/*              Algorithm:
	 * ----------------------------------
	 * 
	 *  1) Use BufferedReader to read the inputed file.
	 *  2) Use PrintWriter to print the new file. 
	 *  3) Use StringTokenizer to get the number of friends,
	 *     milk types, and use it to fill a 2D array of the 
	 *     transcript and sick.
	 *  4) Sort th
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("badmilk.in")
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int friends = Integer.parseInt(st.nextToken());
		int milkTypes = Integer.parseInt(st.nextToken());

		int D = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[][] transcript = new int[D][3];
		int[][] sick = new int[S][2];

		for (int i = 0; i < transcript.length; i++) {

			st = new StringTokenizer(br.readLine());
			transcript[i][0] = Integer.parseInt(st.nextToken());
			transcript[i][1] = Integer.parseInt(st.nextToken());
			transcript[i][2] = Integer.parseInt(st.nextToken());

		}

		for (int j = 0; j < sick.length; j++) {

			st = new StringTokenizer(br.readLine());
			sick[j][0] = Integer.parseInt(st.nextToken());
			sick[j][1] = Integer.parseInt(st.nextToken());

		}

		transcript = sortByTime(transcript);
		sick = sortByTime(sick);

		br.close();

		int max = 0;

		int[] badMilks = getBadMilks(transcript, sick);

		for (int i = 0; i < badMilks.length; i++) {

			int currentMax = 0;

			for (int j = 0; j < transcript.length; j++) {

				if (badMilks[i] == transcript[j][1]) {

					currentMax++;

				}

			}

			if (currentMax > max) {

				max = currentMax;

			}

		}

		//pw.println(max);
		
		System.out.println(max);

		pw.close();

	}

	public static int[] getBadMilks(int[][] transcripts, int[][] sick) {

		ArrayList<Integer> badMilks = new ArrayList<Integer>();

		ArrayList<int[]> milks = new ArrayList<int[]>();

		for (int i = 0; i < sick.length; i++) {

			int currentSick = sick[i][0];
			milks.add(getMilks(transcripts, currentSick));

		}

		for (int i = 0; i < milks.size() - 1; i++) {
			
			for (int j = i + 1; j < milks.size(); j++) {
				
				if (getDuplicatesFromArray(milks.get(i), milks.get(j)).length != 0) {
					
					int [] duplicateMilks = getDuplicatesFromArray(milks.get(i), milks.get(j));
					
					for (int c = 0; c < duplicateMilks.length; c++) {
						
						badMilks.add(duplicateMilks[c]);
						
					}
					
				}
				
			}
			
		}
		
		System.out.println(badMilks);

		return toIntArray(badMilks);

	}

	public static int[][] getPersonTranscript(int[][] transcript, int person) {

		ArrayList<int[]> transcripts = new ArrayList<int[]>();

		for (int i = 0; i < transcript.length; i++) {

			if (transcript[i][0] == person) {

				transcripts.add(transcript[i]);

			}

		}

		return to2DArray(transcripts);

	}

	public static int[] getMilks(int[][] transcripts, int person) {

		ArrayList<Integer> milks = new ArrayList<Integer>();

		for (int i = 0; i < transcripts.length; i++) {

			if (transcripts[i][0] == person) {

				milks.add(transcripts[i][1]);

			}

		}

		return removeDuplicates(toIntArray(milks));

	}

	public static int[][] sortByTime(int[][] array) {

		int[] temp;

		for (int i = 0; i < array.length - 1; i++) {

			for (int j = i + 1; j < array.length; j++) {

				if (array[i][1] > array[j][1]) {

					temp = array[i];
					array[i] = array[j];
					array[j] = temp;

				}

			}

		}

		return array;

	}

	public static int[] toIntArray(ArrayList<Integer> arraylist) {

		int[] array = new int[arraylist.size()];

		for (int i = 0; i < array.length; i++) {

			array[i] = arraylist.get(i).intValue();

		}

		return array;

	}

	public static int[][] to2DArray(ArrayList<int[]> arraylist) {

		int[][] array = new int[arraylist.size()][arraylist.get(0).length];

		for (int i = 0; i < array.length; i++) {

			array[i] = arraylist.get(i);

		}

		return array;

	}

	public static int[] removeDuplicates(int[] array) {

		Set<Integer> setString = new LinkedHashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			setString.add(array[i]);
		}

		return array;

	}

	public static int[] getDuplicatesFromArray(int[] array1, int[] array2) {

		List<Integer> array = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		
		for (int ele : array1) {
			
			set.add(ele);
			
		}

		for (int ele : array2) {
			
			if (set.contains(ele)) {
				
				array.add(ele);
			}
			
		}

		int[] arr = new int[array.size()];
		
		for (int i = 0; i < array.size(); i++) {
			
			arr[i] = array.get(i);
			
		}
		
		return arr;

	}

}
