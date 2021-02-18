package year_2018; // Work On Problem

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Team_Tic_Tac_Toe {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		// Input:
		// COW
		// XXO
		// ABC
		//		
		// Output:
		// 0
		// 2
		//
		// Algorithm:
		// String Tokenizer / Buffered Reader
		// Retrieve String, split into Char Array
		// Check Each Column, Row, and Diagonal to see if it is the same letter. (indivwin)
		// If so, indivwin++.
		// Then, check if each Column, Row, and Diagonal if it has two letters.
		// If so, then the two letters can team up and teamwin++. (teamwin)
		// Output File
		
		final int allline = 3;
		
		BufferedReader br = new BufferedReader(new FileReader("tttt.in")); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\tttt.in
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out"))); // C:\\Computer Science Learning\\USACO Bronze Problems\\src\\year_2016\\tttt.out
    	   
	    StringTokenizer st; // = new StringTokenizer(br.readLine());
		//StringTokenizer st1 = new StringTokenizer(br.readLine());
		//StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int indivwin = 0;
		int teamwin = 0;
		
		// String top = st.nextToken();
		// String middle = st1.nextToken();
		// String lower = st2.nextToken();
		
		String [] allrows = new String[allline];
		char [][] allrowsch = new char[allline][allline];
		
		for (int i = 0; i < allline; i++) {
			
			st = new StringTokenizer(br.readLine());
			allrows[i] = st.nextToken();
			allrowsch[i] = allrows[i].toCharArray();
			
		}
		
		for (int i = 0; i < allline; i++) {
			
			if ((allrowsch[i][0] == allrowsch[i][1]) && (allrowsch[i][0] == allrowsch[i][2])) { // Covers all rows for Individual Wins
				
				indivwin++;
				
				
			}
			
			else if (((allrowsch[i][0] == allrowsch[i][1]) && (allrowsch[i][0] != allrowsch[i][2]))
					|| ((allrowsch[i][0] == allrowsch[i][2]) && (allrowsch[i][0] != allrowsch[i][1])) 
					|| (allrowsch[i][0] != allrowsch[i][2]) && (allrowsch[i][1] == allrowsch[i][2])) { // Covers all rows for Team Wins
				
				teamwin++;
				
			}
			
		}

		for (int i = 0; i < allline; i++) {
			
			if ((allrowsch[0][i] == allrowsch[1][i]) && (allrowsch[0][i] == allrowsch[2][i])) { // Covers all columns for Individual Wins
				
				indivwin++;
				
				
			}
			
			else if (((allrowsch[0][i] == allrowsch[1][i]) && (allrowsch[0][i] != allrowsch[2][i])) 
					|| ((allrowsch[0][i] == allrowsch[2][i]) && (allrowsch[0][i] != allrowsch[1][i])
					|| (allrowsch[0][i] != allrowsch[2][i]) && (allrowsch[1][i] == allrowsch[2][i]))) { // Covers all columns for Team Wins
				
				teamwin++;
				
			}
			
		}
		
		if ((allrowsch[0][0] == allrowsch[1][1]) && (allrowsch[1][1] == allrowsch[2][2])) { // Covers Diagonal Win for Individual (Left - Right)
			
			indivwin++;
			
		}	

		else if ((allrowsch[0][0] == allrowsch[1][1]) && (allrowsch[0][0] != allrowsch[2][2])
				|| (allrowsch[0][0] == allrowsch[2][2]) && (allrowsch[1][1] != allrowsch[2][2])
				|| (allrowsch[0][0] != allrowsch[2][2]) && (allrowsch[1][1] == allrowsch[2][2])) { // Covers Diagonal Win for Team (Left - Right)
			
			teamwin++;
			
		}
		
		if ((allrowsch[0][2] == allrowsch[1][1]) && (allrowsch[1][1] == allrowsch[2][0])) { // Covers Diagonal Win for Individual (Right - Left)
			
			indivwin++;
			
		}	

		else if ((allrowsch[0][2] == allrowsch[1][1]) && (allrowsch[1][1] != allrowsch[2][0])
				|| (allrowsch[0][2] == allrowsch[2][0]) && (allrowsch[1][1] != allrowsch[0][2]) 
				|| (allrowsch[0][2] != allrowsch[2][0]) && (allrowsch[1][1] == allrowsch[2][0])) { // Covers Diagonal Win for Team (Right - Left)
			
			teamwin++;
			
		}
		
			
//		Brute Force Method:
//
//		char[] topRow = top.toCharArray(); // topRow[0] = 'C', topRow[1] = 'O', topRow[2] = 'W'
//		char[] middleRow = middle.toCharArray(); // middleRow[0] = 'X', middleRow[1] = 'X', middleRow[2] = 'O'
//		char[] lowerRow = lower.toCharArray(); // lowerRow[0] = 'A', lowerRow[1] = 'B', lowerRow[2] = 'C'
//		
//		for (int i = 0; i <= 8; i++) {
//			
//			// One Cow Win
//			
//			if ((topRow[0] == topRow[1] && topRow[1] == topRow[2])
//					|| (middleRow[0] == middleRow[1] && middleRow[1] == middleRow[2]) // Check all Rows
//					|| (lowerRow[0] == lowerRow[1] && lowerRow[1] == lowerRow[2])) {
//				
//				indivwin++;
//				
//				
//			}
//			
//			else if ((topRow[0] == middleRow[0] && middleRow[0] == lowerRow[0]) // Check all Columns
//					|| (topRow[1] == middleRow[1] && middleRow[1] == lowerRow[1]) 
//					|| (topRow[2] == middleRow[2] && middleRow[2] == lowerRow[2])) {
//				
//				indivwin++;
//				
//			}
//			
//			else if ((topRow[0] == middleRow[1] && middleRow[1] == lowerRow[2]) // Check all Diagonals
//					|| (topRow[2] == middleRow[1] && middleRow[1] == lowerRow[0])) {
//				
//				indivwin++;
//				
//			}
//			
//			// Two Cows Win
//			
//			// Row Win
//			
//			if ((topRow[0] == topRow[1]) && (topRow[2] == topRow[1] || topRow[2] == topRow[1]) 
//					|| (topRow[0] == topRow[2]) && (topRow[1] == topRow[2] || topRow[1] == topRow[0]) 
//					
//					// || (topRow[1] == topRow[0]) && (topRow[2] == topRow[0] || topRow[2] == topRow[1]) 
//					
//					|| (topRow[1] == topRow[2]) && (topRow[0] == topRow[1] || topRow[0] == topRow[2]) // Row #1
//					
//					// || (topRow[2] == topRow[0]) && (topRow[1] == topRow[2] || topRow[1] == topRow[0]) 
//					
//					/* || (topRow[2] == topRow[1]) && (topRow[0] == topRow[1] || topRow[0] == topRow[2]) */ ) {
//				
//				teamwin++;
//				
//			}
//			
//			else if ((middleRow[0] == middleRow[1]) && (middleRow[2] == middleRow[1] || middleRow[2] == middleRow[1]) 
//					|| (middleRow[0] == middleRow[2]) && (middleRow[1] == middleRow[2] || middleRow[1] == middleRow[0]) 
//					
//					// || (middleRow[1] == middleRow[0]) && (middleRow[2] == middleRow[0] || middleRow[2] == middleRow[1]) 
//					
//					// || (middleRow[1] == middleRow[2]) && (middleRow[0] == middleRow[1] || middleRow[0] == middleRow[2]) // Row #2
//					
//					// || (middleRow[2] == middleRow[0]) && (middleRow[1] == middleRow[2] || middleRow[1] == middleRow[0]) 
//					
//					|| (middleRow[2] == middleRow[1]) && (middleRow[0] == middleRow[1] || middleRow[0] == middleRow[2])) {
//				
//				teamwin++;
//				
//			}
//			
//			else if ((lowerRow[0] == lowerRow[1]) && (lowerRow[2] == lowerRow[1] || lowerRow[2] == lowerRow[1]) 
//					|| (lowerRow[0] == lowerRow[2]) && (lowerRow[1] == lowerRow[2] || lowerRow[1] == lowerRow[0]) 
//					
//					// || (lowerRow[1] == lowerRow[0]) && (lowerRow[2] == lowerRow[0] || lowerRow[2] == lowerRow[1])
//					
//					|| (lowerRow[1] == lowerRow[2]) && (lowerRow[0] == lowerRow[1] || lowerRow[0] == lowerRow[2]) // Row #3
//					
//					// || (lowerRow[2] == lowerRow[0]) && (lowerRow[1] == lowerRow[2] || lowerRow[1] == lowerRow[0]) 
//					
//					/* || (lowerRow[2] == lowerRow[1]) && (lowerRow[0] == lowerRow[1] || lowerRow[0] == lowerRow[2]) */ ) {
//				
//				teamwin++;
//				
//			}
//			
//			// Column Win
//			
//			if ((topRow[0] == middleRow[0]) && (lowerRow[0] == topRow[0] || middleRow[0] == topRow[0]) // Work On
//					|| (topRow[0] == lowerRow[0]) && (middleRow[0] == topRow[0] || middleRow[0] == lowerRow[0]) 
//					
//					// || (middleRow[0] == topRow[0]) && (lowerRow[0] == topRow[0] || lowerRow[0] == middleRow[0]) 
//					
//					// || (middleRow[0] == lowerRow[0]) && (topRow[0] == lowerRow[0] || topRow[0] == middleRow[0]) // Row #1
//					
//					// || (lowerRow[0] == topRow[0]) && (middleRow[0] == topRow[0] || middleRow[0] == lowerRow[0]) 
//					
//					|| (lowerRow[0] == middleRow[0]) && (topRow[0] == middleRow[0] || topRow[0] == lowerRow[0])) {
//				
//				teamwin++;
//				
//			}
//			
//			else if ((topRow[1] == middleRow[1]) && (lowerRow[1] == middleRow[1] || lowerRow[1] == topRow[1]) 
//					|| (topRow[1] == lowerRow[1]) && (middleRow[1] == lowerRow[1] || middleRow[1] == topRow[1]) 
//					
//					// || (middleRow[1] == topRow[1]) && (lowerRow[1] == middleRow[1] || lowerRow[1] == topRow[1]) 
//					
//					|| (middleRow[1] == lowerRow[1]) && (topRow[1] == middleRow[1] || topRow[1] == lowerRow[1]) // Row #2
//					
//					// || (lowerRow[1] == middleRow[1]) && (topRow[1] == middleRow[1] || topRow[1] == lowerRow[1]) 
//					
//					/* || (lowerRow[1] == topRow[1]) && (middleRow[1] == topRow[1] || middleRow[1] == lowerRow[1]) */ ) {
//				
//				teamwin++;
//				
//			}
//			
//			else if ((topRow[2] == lowerRow[2]) && (middleRow[2] == lowerRow[2] || middleRow[2] == topRow[2]) 
//					|| (topRow[2] == middleRow[2]) && (lowerRow[2] == middleRow[2] || lowerRow[2] == topRow[2]) 
//					|| (middleRow[2] == lowerRow[2]) && (topRow[2] == lowerRow[2] || topRow[2] == middleRow[2]) 
//					
//					// || (middleRow[2] == topRow[2]) && (lowerRow[2] == middleRow[2] || lowerRow[2] == topRow[2]) // Row #3
//					
//					// || (lowerRow[2] == topRow[2]) && (middleRow[2] == lowerRow[2] || middleRow[2] == topRow[2]) 
//					
//					/* || (lowerRow[2] == middleRow[2]) && (topRow[2] == lowerRow[2] || topRow[2] == middleRow[2]) */ ) {
//				
//				teamwin++;
//				
//			}
//			
//			// Diagonal Win
//			
//			else if ((topRow[0] == middleRow[1]) && (lowerRow[2] == middleRow[1] || lowerRow[2] == topRow[0]) 
//					|| (topRow[0] == lowerRow[2]) && (middleRow[1] == topRow[0] || middleRow[1] == lowerRow[2])
//					|| (lowerRow[2] == middleRow[1]) && (topRow[0] == lowerRow[2] || topRow[0] == middleRow[2])) { // Diagonal #1 (Left - Right)
//				
//				teamwin++;
//				
//			}
//			
//			else  { // Diagonal #2 (Right - Left)
//				
//				teamwin++;
//				
//			}
//			
//		}
//
		
		pw.println(indivwin);
		pw.println(teamwin);
		
		br.close();
		pw.close();
		

	}

}
