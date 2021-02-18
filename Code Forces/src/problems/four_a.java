package problems;

import java.io.IOException;
import java.util.Scanner;

public class four_a {
	
public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);  
		
		int number = sc.nextInt();
		
		if (number % 2 == 0 && number != 2) {
			
			System.out.println("YES");
			
		}
		
		else {
			
			System.out.println("NO");
			
		}
		
		sc.close();

	}

}
