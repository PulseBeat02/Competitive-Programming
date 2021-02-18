import java.io.*;
import java.util.*;

public class NumeralTriangles {
	
    public static void main(String[] args) throws IOException {
        int s = 184;
        int d = 231;
        int r = 35;
        int result = Result.sumOfLastRow(s, d, r);
        System.out.println(result);
    }
    
}

class Result {

    /*
     * Complete the 'sumOfLastRow' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER d
     *  3. INTEGER r
     */

    // s -> start
    // d -> increment
    // r -> rows
    public static int sumOfLastRow(int s, int d, int r) {
        int max = r*(r + 1)/2;
        List<Integer> list = new ArrayList<>();
        int sum = getDigitSum(s);
        for (int i = 0; i < max; i++) {
            list.add(sum);
            sum += d;
            sum = getDigitSum(sum);
        }
        return list.subList(list.size() - r, list.size()).stream().mapToInt(x -> x).sum();
    }
    
    public static int getDigitSum(int num) {
        int inner = 0;
        for (char c : String.valueOf(num).toCharArray()) {
            inner += Character.getNumericValue(c);
        }
        if (String.valueOf(inner).length() > 1) {
            inner = getDigitSum(inner);
        }
        return inner;
    }
    
    

}
