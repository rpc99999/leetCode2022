public class P1137 {
  /*
   * The Tribonacci sequence Tn is defined as follows:
   * 
   * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
   * 
   * Given n, return the value of Tn.
   */
  public int tribonacci(int n) {
      int[] resultArray = new int[n+1];
      switch(n){
        case 0:
                return 0;
        case 1:
                return 1;
        case 2:
                return 1;
        default:
              resultArray[0] = 0;
              resultArray[1] = 1;
              resultArray[2] = 1;
              return tribonacci(n, resultArray);
      }      
  }

  public int tribonacci(int n, int[] resultArray){
    if(n<=2||resultArray[n]!=0){
      return resultArray[n];
    }else{
      resultArray[n] = tribonacci(n-1, resultArray) + tribonacci(n-2, resultArray) + tribonacci(n-3, resultArray);
      return resultArray[n];
    }
  }

}
