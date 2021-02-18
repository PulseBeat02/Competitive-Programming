package year_2017;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Bovine_Shuffle {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("shuffle.in")
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int cows = Integer.parseInt(st.nextToken());

		int[] shuffles = new int[cows];

		int[] cowIds = new int[cows];

		for (int i = 0; i < shuffles.length; i++) {

			shuffles[i] = Integer.parseInt(st1.nextToken());

		}

		for (int i = 0; i < cows; i++) {

			cowIds[i] = Integer.parseInt(st2.nextToken());

		}

		br.close();

		System.out.println(Arrays.toString(cowIds));

		for (int i = 0; i <= 2; i++) {

			for (int z = 0; z < shuffles.length; z++) {

				swap(z, shuffles[z] - 1, shuffles);

			}

		}
		
		System.out.println(Arrays.toString(shuffles));

	}

	public static int[] swap(int firstIndex, int secondIndex, int[] array) {

		int temp = array[secondIndex];

		array[secondIndex] = array[firstIndex];
		array[firstIndex] = temp;

		System.out.println(Arrays.toString(array));

		return array;

	}

}
