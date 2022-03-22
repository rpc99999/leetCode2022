import java.math.BigInteger;

public class P1567_MaximumLengthofSubarrayWithPositiveProduct {
  /*
   * Given an array of integers nums, find the maximum length of a subarray where
   * the product of all its elements is positive.
   * 
   * A subarray of an array is a consecutive sequence of zero or more values taken
   * out of that array.
   * 
   * Return the maximum length of a subarray with positive product.
   * 
   * Example 1:
   * 
   * Input: nums = [1,-2,-3,4]
   * Output: 4
   * Explanation: The array nums already has a positive product of 24.
   * Example 2:
   * 
   * Input: nums = [0,1,-2,-3,-4]
   * Output: 3
   * Explanation: The longest subarray with positive product is [1,-2,-3] which
   * has a product of 6.
   * Notice that we cannot include 0 in the subarray since that'll make the
   * product 0 which is not positive.
   * Example 3:
   * 
   * Input: nums = [-1,-2,-3,0,1]
   * Output: 2
   * Explanation: The longest subarray with positive product is [-1,-2] or
   * [-2,-3].
   * 
   * 
   * Constraints:
   * 
   * 1 <= nums.length <= 10^5
   * -10^9 <= nums[i] <= 10^9
   */

  public static int getMaxLen1(int[] nums) { // Brute force
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      boolean isPositive = true;
      for (int j = i; j < nums.length; j++) {
        if (nums[j] == 0) {
          break;
        } else {
          count++;
          if (nums[j] < 0) {
            isPositive = !isPositive;
          }
          if (isPositive) {
            res = Math.max(count, res);
          }
        }
      }
    }
    return res;
  }

  public static int getMaxLen2(int[] nums) {  // O(N) time, O(1) Space
    int res = 0;
    boolean l_isPositive = true;
    int l_cnt = 0;
    boolean r_isPositive = true;
    int r_cnt = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        l_cnt = 0;
        l_isPositive = true;
      } else {
        l_cnt++;
        if (nums[i] < 0) {
          l_isPositive = !l_isPositive;
        }

        if (l_isPositive) {
          res = Math.max(res, l_cnt);
        }
      }

      if (nums[nums.length - 1 - i] == 0) {
        r_cnt = 0;
        r_isPositive = true;
      } else {
        r_cnt++;
        if (nums[nums.length - 1 - i] < 0) {
          r_isPositive = !r_isPositive;
        }

        if (r_isPositive) {
          res = Math.max(res, r_cnt);
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(getMaxLen(new int[] { -1, 2 }));
  }
}
