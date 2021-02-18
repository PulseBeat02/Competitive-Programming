package year_2015;
//package year_2015;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.StringTokenizer;
//
//public class MooCryptionN {
//	
//	public static void main(String [] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new FileReader("moocrypt.in"));
//		PrintWriter pw = new PrintWriter(new File("moocrypt.out"));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int rows = Integer.parseInt(st.nextToken());
//		int columns = Integer.parseInt(st.nextToken());
//		
//		char [][] grid = new char[rows][columns];
//		
//		for (int i = 0; i < rows; i++) {
//			
//			st = new StringTokenizer(br.readLine());
//			
//			for (int j = 0; j < columns; j++) {
//				
//				grid[i][j] = st.nextToken().charAt(0);
//				
//			}
//			
//		}
//		
//		
//		
//	}
//	
//	public static int maxMatchVertical(char [][] grid) {
//		
//		int max = 0;
//		
//		for (int i = 0; i < grid.length; i++) {
//			
//			int currentMax = 0;
//			
//			for (int j = 0; j < grid[0].length - 1; j++) {
//				
//				if (grid[i][j] == grid[i][j+1]) {
//					
//					currentMax++;
//					
//				}
//				
//			}
//			
//			
//			
//		}
//		
//	}
//	
//	public static int maxMatchHorizantal(int [][] grid) {
//		
//	}
//	
//	public static int maxMatchDiagonally(int [][] grid) {
//		
//		
//		
//	}
//	
//	
//
//}
