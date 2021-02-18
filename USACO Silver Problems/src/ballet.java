import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ballet {

	static int[] FLpre = { 0, 1 };
	static int[] FRpre = { 1, 1 };
	static int[] RLpre = { 0, 0 };
	static int[] RRpre = { 1, 0 };

	public static int[][] feet = { FLpre, FRpre, RLpre, RRpre };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("ballet.in"));

		int N = Integer.parseInt(br.readLine());

		Instruction[] instructions = new Instruction[N];

		for (int i = 0; i < instructions.length; i++) {

			instructions[i] = new Instruction(br.readLine());

		}
		br.close();

		int answer = 0;
		for (int i = 0; i < instructions.length; i++) {

			Instruction in = instructions[i];

			switch (in.m) {

			case 'F':
				feet[in.index][1]++;
				break;

			case 'B':
				feet[in.index][1]--;
				break;

			case 'R':
				feet[in.index][0]++;
				break;

			case 'L':
				feet[in.index][0]--;
				break;

			case 'P':
				pivot();
				break;

			}

			if (trip()) {

				answer = -1;
				break;

			}

		}

		if (answer != -1) {

			int[] FL = feet[0];
			int[] FR = feet[1];
			int[] RL = feet[2];
			int[] RR = feet[3];

			int[] topRight = topLeft(FL, FR, RL, RR);
			int[] bottomLeft = bottomRight(FL, FR, RL, RR);

//			int width = Math.max(Math.abs(feet[0][1] - feet[2][1]), Math.abs(feet[1][1] - feet[1][3]));
//			int length = Math.max(Math.abs(feet[1][0] - feet[0][1]), Math.abs(feet[3][0] - feet[2][0]));

			answer = Math.abs(topRight[0] - bottomLeft[0]) * Math.abs(topRight[1] - bottomLeft[1]);

		}

		System.out.println(answer);

	}

	public static int[] topLeft(int[]... a) {

		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {

			if (i != 1) {

				maxX = Math.max(maxX, a[i][0]);
				maxY = Math.max(maxY, a[i][1]);
				
			}

		}

		return new int[] { maxX, maxY };

	}

	public static int[] bottomRight(int[]... a) {

		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;

		for (int i = 0; i < a.length; i++) {

			minX = Math.min(minX, a[i][0]);
			minY = Math.min(minY, a[i][1]);

		}

		return new int[] { minX, minY };

	}

	public static void pivot() {

		for (int i = 0; i < feet.length; i++) {

			// Switch Around X and Y to Rotate 90 Degrees
			int x = feet[i][1] - feet[1][1];
			int y = feet[i][0] - feet[1][0];

			feet[i][0] = feet[1][0] + x;
			feet[i][1] = feet[1][1] + y;

		}

	}

	public static boolean trip() {

		for (int i = 0; i < feet.length; i++) {

			for (int j = i + 1; j < feet.length; j++) {

				if (feet[i][0] == feet[j][0] && feet[i][1] == feet[j][1]) {

					return true;

				}

			}

		}

		return false;

	}

	static class Instruction {

		int index;
		char m;

		public Instruction(String s) {

			switch (s.substring(0, 2)) {

			case "FL":
				this.index = 0;
				break;

			case "FR":
				this.index = 1;
				break;

			case "RL":
				this.index = 2;
				break;

			case "RR":
				this.index = 3;
				break;

			}

			this.m = s.charAt(2);

		}

	}

}
