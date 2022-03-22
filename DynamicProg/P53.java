public class P53 {

  /*
   * 53. Maximum Subarray
   * Given an integer array nums, find the contiguous subarray (containing at
   * least one number) which has the largest sum and return its sum.
   * A subarray is a contiguous part of an array.
   * Example 1:
   * 
   * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
   * Output: 6
   * Explanation: [4,-1,2,1] has the largest sum = 6.
   * Example 2:
   * 
   * Input: nums = [1]
   * Output: 1
   * Example 3:
   * 
   * Input: nums = [5,4,-1,7,8]
   * Output: 23
   * 
   * Constraints:
   * 
   * 1 <= nums.length <= 100000
   * -10000 <= nums[i] <= 10000
   */

  public int maxSubArray(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    } else {
      int[] dp = new int[nums.length];
      dp[0] = nums[0]; // dp[i] = the maximum sum of array
                       // with ith element as the last element of the array
      int maxSub = dp[0];
      for (int i = 1; i < nums.length; i++) {
        dp[i] = ((dp[i - 1] > 0) ? dp[i - 1] : 0) + nums[i];
        maxSub = Math.max(maxSub, dp[i]);
      }
      return maxSub;
    }
  }

  /*
   * the format of the sub problem into something like: maxSubArray(int A[], int
   * i), which means the maxSubArray for A[0:i ] which must has A[i] as the end
   * element. Note that now the sub problem's format is less flexible and less
   * powerful than the previous one because there's a limitation that A[i] should
   * be contained in that sequence and we have to keep track of each solution of
   * the sub problem to update the global optimal value. However, now the connect
   * between the sub problem & the original one becomes clearer:
   * 
   * maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 +
   * A[i];
   */
}
