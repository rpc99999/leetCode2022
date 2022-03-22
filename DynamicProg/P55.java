public class P55 {
  /*
   * 55. Jump Game
   * You are given an integer array nums. You are initially positioned at the
   * array's first index, and each element in the array represents your maximum
   * jump length at that position.
   * 
   * Return true if you can reach the last index, or false otherwise.
   * Example 1:
   * 
   * Input: nums = [2,3,1,1,4]
   * Output: true
   * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
   * Example 2:
   * 
   * Input: nums = [3,2,1,0,4]
   * Output: false
   * Explanation: You will always arrive at index 3 no matter what. Its maximum
   * jump length is 0, which makes it impossible to reach the last index.
   * 
   * 
   * Constraints:
   * 
   * 1 <= nums.length <= 10^4
   * 0 <= nums[i] <= 10^5
   */

  public boolean canJump(int[] nums) {    // Time Complexity : O(n^2), DP used
      if(nums.length==1){
        return true;
      }
      boolean [] canJump = new boolean [nums.length];
      canJump[nums.length-1] = true;
      for(int i = nums.length-2; i>=0;i--){
        int step = nums[i];
        for(int j = 1; j <= step; j++){
          if(i+j>=nums.length){
            break;
          }else if(canJump[i+j]){
            canJump[i] = true;
            break;
          }
        }
      }
      return canJump[0];
  }

  public boolean canJump2(int[] nums){   // Time Complexity : O(n), No DP were used
    if(nums.length==1){
      return true;
    }
    int smallestIndex = nums.length-1;
    for(int i = nums.length-2; i>=0;i--){
      if(i+nums[i]>=smallestIndex){   // save the smallest index that can reach last index
        smallestIndex = i;            // check whether the current index can reach the smallest index
      }                               // update the smallest index as current index if 'yes'
    }
    return (smallestIndex==0);
  }
}
