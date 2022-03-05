public class P198_213 {
  /*
   * 198. House Robber
   * You are a professional robber planning to rob houses along a street. Each
   * house has a certain amount of money stashed, the only constraint stopping you
   * from robbing each of them is that adjacent houses have security systems
   * connected and it will automatically contact the police if two adjacent houses
   * were broken into on the same night.
   * 
   * Given an integer array nums representing the amount of money of each house,
   * return the maximum amount of money you can rob tonight without alerting the
   * police.
   * 
   * 
   * 
   * Example 1:
   * 
   * Input: nums = [1,2,3,1]
   * Output: 4
   * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
   * Total amount you can rob = 1 + 3 = 4.
   * Example 2:
   * 
   * Input: nums = [2,7,9,3,1]
   * Output: 12
   * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
   * (money = 1).
   * Total amount you can rob = 2 + 9 + 1 = 12.
   */
  public static int robP198(int[] nums) {
    int[] maxResult = new int[nums.length + 1];
    if (nums.length == 1) {
      return nums[0];
    } else if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    } else {
      maxResult[nums.length] = nums[nums.length - 1];
      maxResult[nums.length - 1] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
      for (int i = nums.length - 3; i >= 0; i--) {
        maxResult[i + 1] = Math.max(maxResult[i + 3] + nums[i], maxResult[i + 2]);
      }
      return maxResult[1];
    }
  }

  /*
   * 213. House Robber II
   * You are a professional robber planning to rob houses along a street. Each
   * house has a certain amount of money stashed. All houses at this place are
   * arranged in a circle. That means the first house is the neighbor of the last
   * one. Meanwhile, adjacent houses have a security system connected, and it will
   * automatically contact the police if two adjacent houses were broken into on
   * the same night.
   * 
   * Given an integer array nums representing the amount of money of each house,
   * return the maximum amount of money you can rob tonight without alerting the
   * police.
   * Example 1:
   * 
   * Input: nums = [2,3,2]
   * Output: 3
   * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money =
   * 2), because they are adjacent houses.
   * Example 2:
   * 
   * Input: nums = [1,2,3,1]
   * Output: 4
   * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
   * Total amount you can rob = 1 + 3 = 4.
   * Example 3:
   * 
   * Input: nums = [1,2,3]
   * Output: 3
   */
  public static int robP213(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int[] result1 = new int[nums.length - 1];   // 1st, 2nd, 3rd, ..., n-1th house
    int[] result2 = new int[nums.length - 1];   // 2nd, 3rd, 4th, ..., nth house
    for (int i = 0; i < nums.length; i++) {
      if (i < nums.length - 1) {
        result1[i] = nums[i];
      }
      if (i > 0) {
        result2[i - 1] = nums[i];
      }
    }
    return Math.max(robP198(result1), robP198(result2));
  }

  public static void main(String[] args) {
    System.out.println(robP198(new int[] { 1, 2, 3, 1 }));
  }
}
