package year_2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class hoofball {

	static ArrayList<Boolean> flag = new ArrayList<Boolean>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // new FileReader("hoofball.in")
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		ArrayList<Integer> positions = new ArrayList<Integer>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			positions.add(Integer.parseInt(st.nextToken()));
			flag.add(false);

		}

		br.close();

		int count = 0;

		for (int i = 0; i < positions.size(); i++) {

			if (!canPass(i, positions, flag)) {

				count++;
				remove(positions, flag);

				if (positions.size() == 0) {

					break;

				}

			}

		}

		System.out.println(count);

	}

	public static void remove(ArrayList<Integer> cows, ArrayList<Boolean> flag) {

		for (int i = cows.size() - 1; i >= 0; i--) {

			if (flag.get(i)) {

				cows.remove(i);

				Collections.fill(flag, Boolean.FALSE);

			}

		}

	}

	public static boolean canPass(int cowIndex, ArrayList<Integer> cows, ArrayList<Boolean> flags) {

		flags.set(cowIndex, true);

		// find the target

		Integer cowToPass;
		int cowToPassIndex = 0; 

		int smallestLD = 1000;
		int smallestRD = 1001;

		int smallestCowL = 0;
		int smallestCowR = 0;
		
		int indexL = 0;
		int indexR = 0;
		
		int index = 0;
		
		for (int cCow : cows) {

			if (cCow < cows.get(cowIndex)) {

				if (cows.get(cowIndex) - cCow < smallestLD) {

					smallestLD = cows.get(cowIndex) - cCow;
					smallestCowL = cCow;
					indexL = index;
					

				}

			} else if (cCow > cows.get(cowIndex)) {

				if (cCow - cows.get(cowIndex) < smallestRD) {

					smallestRD = cCow - cows.get(cowIndex);
					smallestCowR = cCow;
					indexR = index;

				}

			}
			
			index++;

		}

		if (smallestLD <= smallestRD) {

			cowToPass = smallestCowL;
			
			cowToPassIndex = indexL;

		}

		else {

			cowToPass = smallestCowR;
			cowToPassIndex = indexR;

		}

		if (!flags.get(cowToPassIndex)) {

			flags.set(cowToPassIndex, true);
			return canPass(cowToPassIndex, cows, flags);

		} else {

			return false;

		}

	}

}
