public class P45 {
  /*
   * 45. Jump Game II
   * Given an array of non-negative integers nums, you are initially positioned at
   * the first index of the array.
   * 
   * Each element in the array represents your maximum jump length at that
   * position.
   * 
   * Your goal is to reach the last index in the minimum number of jumps.
   * 
   * You can assume that you can always reach the last index.
   * 
   * 
   * 
   * Example 1:
   * 
   * Input: nums = [2,3,1,1,4]
   * Output: 2
   * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
   * step from index 0 to 1, then 3 steps to the last index.
   * Example 2:
   * 
   * Input: nums = [2,3,0,1,4]
   * Output: 2
   * 
   * 
   * Constraints:
   * 
   * 1 <= nums.length <= 10^4
   * 0 <= nums[i] <= 1000
   */

  public int jump(int[] nums) { // Solved by DP, Time Complexity : O(n^2)
    if (nums.length == 1) {
      return 0;
    } else {
      int[] miniJump = new int[nums.length - 1];
      for (int i = nums.length - 2; i >= 0; i--) {
        int jump = nums[i];
        if (i + jump >= nums.length - 1) {
          miniJump[i] = 1;
          continue;
        } else {
          miniJump[i] = 10001; // maximun constant
          for (int j = 1; j <= jump; j++) {
            miniJump[i] = Math.min(miniJump[i + j], miniJump[i]);
          }
          if (miniJump[i] < 10001) {
            miniJump[i] += 1;
          }
        }
      }
      return miniJump[0];
    }
  }

  public static int jumpByGreedy(int[] nums) { // Greedy algo, O(N)
    /*
     * Greedy O(n). There are redundancy in the above approaches. From a position,
     * the number of steps to jump is the one that can go furthest after the jump.
     * Because it covers all the options of the other choices.
     */
    if (nums.length == 1) {
      return 0;
    }

    int maxJump = 0;
    int currIndex = 0;
    int index = 0;
    int result = 1;
    while (nums[currIndex] + currIndex < nums.length - 1) {
      int steps = nums[currIndex];
      for (int i = 1; i <= steps; i++) {
        int jump = currIndex + i + nums[currIndex + i];
        if (jump > maxJump) {
          maxJump = jump;
          index = currIndex + i;
        }
      }
      maxJump = 0;
      currIndex = index;
      index = 0;
      result++;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(jumpByGreedy(new int[] { 1, 1, 1, 1 }));
  }
}
