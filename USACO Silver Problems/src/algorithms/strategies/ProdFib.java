package algorithms.strategies;

/*
Determines whether a number can be represented as the sum of consecutive fibonnaci numbers
Takes in a long prod and returns [F(n), F(n + 1), 1 or 0 depending on whether the prod can be represented as a product of consecutive fibs]
*/

public class ProdFib {

	public static long[] productFib(long prod) {

    long product = 0;
    long fn = 0, fn1 = 1, fnprev = 0, temp;

    for(int n = 0; true; n++){
      if(n == 1) fn = 1;
      else if (n != 0){
        temp = fn;
        fn = fn + fnprev;
        fn1 = fn + temp;
        fnprev = temp;
      }

      product = fn * fn1;
      if(product > prod) return new long[]{fn, fn1, 0};
      else if(product == prod) return new long[]{fn, fn1, 1};
    }
  }
}