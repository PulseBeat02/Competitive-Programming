import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day16 {

	private ArrayList<String> fields;
	private String myTicket;
	private ArrayList<String> nearbyTickets;

	public static void main(String[] args) {
	  new Day16();
  }

	public Day16() {
		Scanner reader = null;
		try {
			reader = new Scanner(new File("tickettranslation.txt"));
		} catch (Exception e) {
			System.out.println("File not found");
		}
		fields = new ArrayList<String>();
		myTicket = "";
		nearbyTickets = new ArrayList<String>();

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			if (!line.equals("")) {
				if (line.equals("your ticket:"))
					myTicket = reader.nextLine();
				else if (line.equals("nearby tickets:")) {
					while (reader.hasNext())
						nearbyTickets.add(reader.nextLine());
				} else {
					fields.add(line);
				}

			}
		}
		
		part1();
		part2();
		
	}

	public void part1() {
		int sumOfInvalid = 0;

		for (int i = 0; i < nearbyTickets.size(); i++) {
			String ticket = nearbyTickets.get(i);
			sumOfInvalid += getInvalids(ticket, fields);
		}

		System.out.println("Sum of invalid fields: " + sumOfInvalid);

	}

	public void part2() {
		
		removeInvalidTickets(nearbyTickets, fields);
		
		String[] fieldLocs = identifyFields(nearbyTickets, fields);
		applyLogic(fieldLocs);

		String[] mine = myTicket.split(",");
		long prod = 1;
		for (int i = 0; i < fieldLocs.length; i++) {
			if (fieldLocs[i].startsWith("departure")) {
				prod *= Integer.parseInt(mine[i]);
			}
		}

		System.out.println("Product of 6 \"departure\" fields: " + prod);

	}

	private static void applyLogic(String[] fieldLocs) {

		ArrayList<String> fieldsFound = new ArrayList<String>();

		while (fieldsFound.size() < fieldLocs.length) {
			for (int i = 0; i < fieldLocs.length; i++) {
				String[] fields = fieldLocs[i].split("/");
				if (fields.length == 1) {
					if (!fieldsFound.contains(fields[0])) {
						fieldsFound.add(fields[0]);
					}
				} else {
					String rep = "";
					for (String f : fields) {
						if (!fieldsFound.contains(f)) {
							rep += f + "/";
						}
					}
					fieldLocs[i] = rep.substring(0, rep.length() - 1);
				}
			}
		}

	}

	private static String[] identifyFields(ArrayList<String> t, ArrayList<String> f) {
		String[] locs = new String[f.size()]; // array will store ALL fields that match ALL ticket data at corresponding
												// index

		for (int i = 0; i < f.size(); i++) {
			int[] corresNums = new int[t.size()]; // all numbers from index i on each ticket
			for (int j = 0; j < corresNums.length; j++) {
				corresNums[j] = Integer.parseInt(t.get(j).split(",")[i]);
			}

			locs[i] = getFieldsThatMatch(corresNums, f);

		}

		return locs;
	}

	private static String getFieldsThatMatch(int[] nums, ArrayList<String> f) {
		String ret = "";

		for (int i = 0; i < f.size(); i++) {
			String line = f.get(i);
			String field = line.substring(0, line.indexOf(":"));
			int min1 = Integer.parseInt(line.substring(line.indexOf(":") + 2, line.indexOf("-")));
			int max1 = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(" or ")));
			int min2 = Integer.parseInt(line.substring(line.indexOf(" or ") + 4, line.lastIndexOf("-")));
			int max2 = Integer.parseInt(line.substring(line.lastIndexOf("-") + 1));

			boolean couldBe = true;
			for (int j = 0; j < nums.length; j++) {
				int num = nums[j];
				if (!((min1 <= num && num <= max1) || (min2 <= num && num <= max2))) {
					couldBe = false;
					break;
				}
			}

			if (couldBe) {
				ret += field + "/";
			}

		}

		return ret.substring(0, ret.length() - 1);
	}

	private static void removeInvalidTickets(ArrayList<String> t, ArrayList<String> f) {

		ArrayList<String> ranges = new ArrayList<String>();
		for (int i = 0; i < f.size(); i++) {
			String field = f.get(i);
			ranges.add(field.substring(field.indexOf(":") + 2, field.indexOf(" or ")));
			ranges.add(field.substring(field.indexOf(" or ") + 4));
		}

		for (int z = 0; z < t.size(); z++) {
			String[] ticketNums = t.get(z).split(",");
			for (int i = 0; i < ticketNums.length; i++) {
				int num = Integer.parseInt(ticketNums[i]);
				boolean isValid = false;
				for (int j = 0; j < ranges.size(); j++) {
					String[] split = ranges.get(j).split("-");
					int min = Integer.parseInt(split[0]);
					int max = Integer.parseInt(split[1]);
					if (num >= min && num <= max) {
						isValid = true;
						break;
					}
				}
				if (!isValid) {
					t.remove(z);
					z--;
				}
			}
		}

	}

	private static int getInvalids(String t, ArrayList<String> f) {
		int sum = 0;

		String[] ticketNums = t.split(",");
		ArrayList<String> ranges = new ArrayList<String>();
		for (int i = 0; i < f.size(); i++) {
			String field = f.get(i);
			ranges.add(field.substring(field.indexOf(":") + 2, field.indexOf(" or ")));
			ranges.add(field.substring(field.indexOf(" or ") + 4));
		}

		for (int i = 0; i < ticketNums.length; i++) {
			int num = Integer.parseInt(ticketNums[i]);
			boolean isValid = false;
			for (int j = 0; j < ranges.size(); j++) {
				String[] split = ranges.get(j).split("-");
				int min = Integer.parseInt(split[0]);
				int max = Integer.parseInt(split[1]);
				if (num >= min && num <= max) {
					isValid = true;
					break;
				}
			}
			if (!isValid) {
				sum += num;
			}
		}

		return sum;
	}
}
// 28882, 1429779530273