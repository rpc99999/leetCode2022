public class P509 {
  /*
   * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
   * Fibonacci sequence, such that each number is the sum of the two preceding
   * ones, starting from 0 and 1. That is,
   * 
   * F(0) = 0, F(1) = 1
   * F(n) = F(n - 1) + F(n - 2), for n > 1.
   * Given n, calculate F(n).
   */

  public int fib(int n) {
        int[] fibArray = new int[n+1];
        
        if(n==0){
          return 0;
        }else if(n==1){
          return 1;
        }

        fibArray[0] = 0;  //F(0) = 0
        fibArray[1] = 1; // F(1) = 1
        return fib(n, fibArray);
  }

  public int fib(int n, int[] fibArray){
      if(n==0||n==1||fibArray[n]!=0){
        return fibArray[n];
      }else{
        fibArray[n] = fib(n-1, fibArray) + fib(n-2, fibArray);
        return fibArray[n];
      }
  }
}
