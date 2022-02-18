package leetCode2022;

class P704 {

  /*
   * Binary Search
   * Given an array of integers nums which is sorted in ascending order, and an
   * integer target, write a function to search target in nums. If target exists,
   * then return its index. Otherwise, return -1.
   * 
   * You must write an algorithm with O(log n) runtime complexity.
   */

  public int search(int[] nums, int target) {
      if(nums.length==0){
        return -1;
      }else if(nums.length==1){
        return (nums[0] ==  target ? 0 : -1);
      }else{
        return this.search(nums, target, 0, nums.length-1);
      }
  }

  public int search(int[] nums, int target, int left, int right){
      if(left>right){
        return -1;
      }else{
        int idx = (left + right)/2;
        boolean isFound = nums[idx] == target ;
        if(isFound){
          return idx;
        }else{
          if (nums[idx] > target){
            return this.search(nums, target, left, idx-1);
          }else{
            return this.search(nums, target, idx+1, right);
          }
        }
      }
  }
}