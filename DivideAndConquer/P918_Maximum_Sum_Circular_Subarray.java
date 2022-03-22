public class P918_Maximum_Sum_Circular_Subarray{
/*
 * Given a circular integer array nums of length n, return the maximum possible
 * sum of a non-empty subarray of nums.
 * 
 * A circular array means the end of the array connects to the beginning of the
 * array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the
 * previous element of nums[i] is nums[(i - 1 + n) % n].
 * 
 * A subarray may only include each element of the fixed buffer nums at most
 * once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does
 * not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3.
 * Example 2:
 * 
 * Input: nums = [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
 * Example 3:
 * 
 * Input: nums = [-3,-2,-3]
 * Output: -2
 * Explanation: Subarray [-2] has maximum sum -2.
 * 
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 3 * 10000
 * -3 * 10000 <= nums[i] <= 3 * 10000
 */

    public static int maxSubarraySumCircular(int[]nums){
          //exception case
          if(nums.length==1){
            return nums[0];
          }


          int[] max_dp  = new int[nums.length];
          int[] min_dp  = new int[nums.length];
          int max_subArray = Integer.MIN_VALUE;
          int min_subArray = Integer.MAX_VALUE;
          int totalSum = 0;
          boolean isAllNegative = true;
          int minElement = 0;
          for(int i = 0 ; i < nums.length; i++){
            if(i==0){
              max_dp[i] = nums[i];
              min_dp[i] = nums[i];
              max_subArray = nums[i];
              min_subArray = nums[i];
              minElement = nums[i];
            }else{
              max_dp[i] = (max_dp[i-1] > 0) ? max_dp[i-1] + nums[i] : nums[i];
              min_dp[i] = (min_dp[i-1] < 0) ? min_dp[i-1] + nums[i] : nums[i];
              max_subArray = Math.max(max_dp[i], max_subArray);
              min_subArray = Math.min(min_dp[i], min_subArray);
            }

            if(nums[i]>0){
              isAllNegative = false;
            }

            totalSum += nums[i];
            minElement = Math.min(minElement, nums[i]);
          }

          return Math.max(max_subArray, (isAllNegative) ? minElement : totalSum-min_subArray);
    }

    public static void main(String[] args){
      System.out.println(maxSubarraySumCircular(new int[]{9,-4,-7,9}));
    }
}
