package retry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class milkvisits {

	static int N;
	static int M;
	static Farm[] farm;
	static Road[] friends;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		farm = new Farm[100001];
		friends = new Road[100001];
		ans = new int[100001];
		String next = br.readLine();
	    for (int i = 0; i < N; i++) {
	        farm[i] = new Farm(next.charAt(i));
	    }
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			farm[x - 1].road.add(y - 1);
			farm[y - 1].road.add(x - 1);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			friends[i].a = start - 1;
			friends[i].b = end - 1;
		}
		int current_label = 0;
		for (int i = 0; i < N; i++) {
			if (farm[i].label < 0) {
				build(farm[i].breed, i, current_label);
				current_label++;
			}
		}
		for (int fr = 0; fr < M; fr++) {
			if (farm[friends[fr].a].breed == friends[fr].breed || farm[friends[fr].b].breed == friends[fr].breed) {
				ans[fr] = 1;
			} else {
				if (farm[friends[fr].a].label == farm[friends[fr].b].label) {
					ans[fr] = 0;
				} else {
					ans[fr] = 1;
				}
			}
			System.out.println(ans[fr]);
		}
		br.close();

	}

	static boolean build(char breed, int curr, int label) {
		if (farm[curr].breed == breed) {
			farm[curr].label = label; // only visit once per orig
			for (int j = 0; j < farm[curr].road.size(); j++) {
				if (farm[j].label != label) {
					build(breed, farm[curr].road.get(j), label);
				}
			}
		}
		return false;
	}

	static class Farm {
		char breed;
		int label;
		List<Integer> road;

		public Farm(char breed) {
			this.breed = breed;
			this.label = -1;
			this.road = new ArrayList<>();
		}
	}

	static class Road {
		int a;
		int b;
		char breed;

		public Road(char breed, int a, int b) {
			this.a = a;
			this.b = b;
			this.breed = breed;
		}
	}

}
