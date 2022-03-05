public class P746 {
  /*
   * You are given an integer array cost where cost[i] is the cost of ith step on
   * a staircase. Once you pay the cost, you can either climb one or two steps.
   * 
   * You can either start from the step with index 0, or the step with index 1.
   * 
   * Return the minimum cost to reach the top of the floor.
   * Example 1:
   * 
   * Input: cost = [10,15,20]
   * Output: 15
   * Explanation: You will start at index 1.
   * - Pay 15 and climb two steps to reach the top.
   * The total cost is 15.
   * Example 2:
   * 
   * Input: cost = [1,100,1,1,1,100,1,1,100,1]
   * Output: 6
   * Explanation: You will start at index 0.
   * - Pay 1 and climb two steps to reach index 2.
   * - Pay 1 and climb two steps to reach index 4.
   * - Pay 1 and climb two steps to reach index 6.
   * - Pay 1 and climb one step to reach index 7.
   * - Pay 1 and climb two steps to reach index 9.
   * - Pay 1 and climb one step to reach the top.
   * The total cost is 6.
   * 
   * 2 <= cost.length <= 1000
      0 <= cost[i] <= 999
   */

  public static int minCostClimbingStairs(int[] cost) {
        int size = cost.length;
        int[] minCost = new int[size+1];
        minCost[size] = 0;    // take 1 step to the top, no cost
        minCost[size-1] = 0;    // take 2 step to the top, no cost
        for(int i = size-2; i>=0; i--){
          minCost[i] = Math.min(minCost[i+1]+cost[i], minCost[i+2]+cost[i+1]);
        }
        return minCost[0];
  }

  public static void main(String[] args){
      int[] cost = new int[]{1,100};
      System.out.println(minCostClimbingStairs(cost));
  }
}
