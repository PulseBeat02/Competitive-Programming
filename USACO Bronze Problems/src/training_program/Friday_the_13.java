package training_program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.StringTokenizer;

class Friday_the_13 {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		// TODO Auto-generated method stub
		
		// Algorithm:
		// BufferedReader / String Tokenizer
		// Store Years
		// Make For Loop run on years (for(int i = 0; i <= 1900 + N - 1; i++))
		// Make variables, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday.
		// Make variables, day, month
		// Check if year is a leap year. This is if it is divisible by four or by 400 when a century year. (Boolean isLeap)
		// February has 29 days on leap, else-wise, it has 28. September, April, June, and November have 30 days. All the other months have 31 days.
		// pw.println(Monday + " " + Tuesday...);
		// br.close();
		// pw.close();
		
		BufferedReader br = new BufferedReader(new FileReader("input.in")); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\input.in
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.out"))); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\output.out
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int years = Integer.parseInt(st.nextToken());
		
		boolean isLeap = false;
		
		int sunday = 0;
		int monday = 0;
		int tuesday = 0;
		int wednesday = 0;
		int thursday = 0;
		int friday = 0;
		int saturday = 0;
		
		int [] days_of_the_week = {sunday, monday, tuesday, wednesday, thursday, friday, saturday};
		
		int month = 1; // Starts at January
		int day = 1; // Starts at January 1st
		int year = 1900; // Starts at 1900
		
		for (int i = 0; i < 1900 + years - 1; i++) {
			
			if (((i % 4 == 0) && (i % 100 != 0)) || ((i % 100 == 0) && (i % 400 == 0))) {
				
				isLeap = true;
				
			}
			
			
			if (isLeap == false) { // Checks if it is not a leap year.
				
				day++;
				
				if (month % 2 == 1) { // Covers all cases when the month has 31 days
					
					month++;
					day = 1;
					
				}
				
				else if (month == 2) { // Checks February
					
					if (day == 28) {
						
						month++;
						day = 1;
						
					}
					
				}
				
				else { // Covers all cases when the month has 30 days
					
					month++;
					day = 1;
					
				}
				
				if (day == 13) {
					
					//days_of_the_week[];
					
				}
				
			}
			
			
			else if (isLeap == true) { // Checks if it is a leap year.
				
				day++;
				
				if (month % 2 == 1) { // Covers all cases when the month has 31 days
					
					month++;
					day = 1;
					
				}
				
				else if (month == 2) { // Checks February
					
					if (day == 29) {
						
						month++;
						day = 1;
						
					}
					
				}
				
				else { // Covers all cases when the month has 30 days
					
					month++;
					day = 1;
					
				}
				
			}
			
			if (month == 13) {
				
				month = 1;
				day = 1;
				year++;
				
			}
	
			
		}
		
		
		pw.println("Something Here");
		br.close();
		pw.close();

	}

}


