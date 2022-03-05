public class P70 {
  /*
   * You are climbing a staircase. It takes n steps to reach the top.
   * 
   * Each time you can either climb 1 or 2 steps. In how many distinct ways can
   * you climb to the top?
   * 1 <= n <= 45
   * 
   */

  public int climbStairs(int n) {
        if(n==1){
          return 1;
        }else if(n==2){
          return 2;
        }else{
          int[] noOfWay = new int[n+1];
          noOfWay[1] = 1;
          noOfWay[2] = 2;
          return climbStairs(n, noOfWay);
        }
  }

  public int climbStairs(int n, int[] noOfWay){
    if(n<=2||noOfWay[n]!=0){
      return noOfWay[n];
    }else{
      noOfWay[n] = climbStairs(n-1, noOfWay) + climbStairs(n-2, noOfWay);   // F(n) = F(n-1) + F(n-2)
      return noOfWay[n];
    }
  }

  public static void main(String[] args){
    P70 t= new P70();
    System.out.println(t.climbStairs(4));
  }
}
