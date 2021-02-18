package Cs001;

import java.io.IOException;

public class KappaSubString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(reader.readLine());
		String str = "kappaKaPaaKAPPa"; //st.nextToken();
		
		System.out.println("Enter Values");
		
		int count = 0;

		for (int i = 0; i <= str.length() - 5; ) {
			
			System.out.println(str.substring(i, i+5));
			
		    if (str.substring(i, i+5).equals("kappa")) {
		        
		        count++;
		        
		        i += 5; 
		        
		    }
		    
		    else {
		        
		        i++;
		        
		    }
		    
		}
		
		System.out.println("\n");
		System.out.println("Output");
		System.out.println(count);
		


	}

}
