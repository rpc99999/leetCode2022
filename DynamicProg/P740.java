import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P740 {
  /*
  740. Delete and Earn
      1 <= nums.length <= 2 * 10000
      1 <= nums[i] <= 10000
   * You are given an integer array nums. You want to maximize the number of
   * points you get by performing the following operation any number of times:
   * 
   * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must
   * delete every element equal to nums[i] - 1 and every element equal to nums[i]
   * + 1.
   * Return the maximum number of points you can earn by applying the above
   * operation some number of times.
   * 
   * 
   * 
   * Example 1:
   * 
   * Input: nums = [3,4,2]
   * Output: 6
   * Explanation: You can perform the following operations:
   * - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
   * - Delete 2 to earn 2 points. nums = [].
   * You earn a total of 6 points.
   * Example 2:
   * 
   * Input: nums = [2,2,3,3,3,4]
   * Output: 9
   * Explanation: You can perform the following operations:
   * - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums =
   * [3,3].
   * - Delete a 3 again to earn 3 points. nums = [3].
   * - Delete a 3 once more to earn 3 points. nums = [].
   * You earn a total of 9 points.
   */
  public static int deleteAndEarn(int[] nums) {
      if(nums.length==1){
        return nums[0];
      } 
      
      int[] totalPoint = new int[10000+1];   // as '1 <= nums[i] <= 10000'
      int[] earnedPoint = new int[10000+1];
      int maxNum = 0;
      for(int i = 0 ; i < nums.length; i++){
          maxNum = Math.max(maxNum, nums[i]);
          totalPoint[nums[i]] += nums[i];
      }

      // Use P198_213.java to solve this question
      // For example 1 [3, 4, 2]
      //num:       1 2 3 4 5
      //sumPoint : 0 2 3 4 0
      
      //F(1) = 0
      //F(2) = 2
      //F(3) = F(1) + num[3] or F(2)
      //F(4) = F(2) + num[4] or F(3)
      for(int i = 1; i <=maxNum; i++){
        if(i==1){
          earnedPoint[i] = totalPoint[i];
        }else if(i==2){
          earnedPoint[i] = Math.max(totalPoint[i], totalPoint[i-1]);
        }else {
          earnedPoint[i] = Math.max(earnedPoint[i-1], earnedPoint[i-2] + totalPoint[i]);
        }
      }

      return earnedPoint[maxNum];
  }

  public static void main(String[] args){
    System.out.println(deleteAndEarn(new int[] {3,4,2}));
  }
}
