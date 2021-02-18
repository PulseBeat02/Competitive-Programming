package old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class test {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sleepSort(5, 6, 1, 3, 4)));
		randomSort(Arrays.asList(5, 2, 6, 4, 1, 6, 7, 5, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
				9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
				9, 9, 9, 9, 9).stream().mapToInt(i -> i).toArray());
	}

	public static int[] sleepSort(int... args) {
		final int[] sorted = new int[args.length];
		final AtomicInteger index = new AtomicInteger(0);
		List<Thread> threads = new ArrayList<Thread>(0);
		for (int i = 0; i < args.length; i++) {
			final int x = i;
			Thread sorter = new Thread(() -> {
				try {
					Thread.sleep(args[x]);
				} catch (InterruptedException ex) {
					// shrug
				}
				sorted[index.getAndIncrement()] = args[x];
			});
			sorter.setDaemon(true);
			sorter.start();
			threads.add(sorter);
		}
		try {
			for (Thread t : threads) {
				t.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return sorted;
	}

	public static void randomSort(int[] i) {
		int counter = 0;
		System.out.println("I'll sort " + i.length + " elements...");
		while (!isSorted(i)) {
			shuffle(i);
			counter++;
		}
		System.out.println("Solution found! (shuffled " + counter + " times)");
		print(i);
	}

	private static void print(int[] i) {
		for (int x : i) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}

	private static void shuffle(int[] i) {
		for (int x = 0; x < i.length; ++x) {
			int index1 = (int) (Math.random() * i.length), index2 = (int) (Math.random() * i.length);
			int a = i[index1];
			i[index1] = i[index2];
			i[index2] = a;
		}
	}

	private static boolean isSorted(int[] i) {
		for (int x = 0; x < i.length - 1; ++x) {
			if (i[x] > i[x + 1]) {
				return false;
			}
		}
		return true;
	}

}
