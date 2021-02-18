package algorithms.strategies;

/*
Determines whether a number n can be represented as n = m^k.
Takes in n, returns [m, k].
*/

public class PerfectPower {

public static int[] isPerfectPower(int n) {
  if(n == 0 || n == 1) return null;

  int possibleN;
  int sqrt = (int) Math.sqrt(n);

  for(int m = 2; m <= sqrt; m++){
    if(n % m == 0){
      for(int k = 2; true; k++){
        possibleN = (int) Math.pow(m, k); //Cannot simply be multiplication due to integer's inability to handle it
        if(n == possibleN) return new int[]{m, k};
        else if(possibleN > n) break;
      }
    }
  }

  return null;
}
}