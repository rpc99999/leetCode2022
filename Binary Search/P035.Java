class P035 {

  /*
    Given a sorted array of distinct integers and a target value, 
    return the index if the target is found. 
    If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.
  */
  public int searchInsert(int[] nums, int target) {
      return this.searchInsert(nums, target, 0, nums.length-1);
  }

  public int searchInsert(int[] nums, int target, int left, int right){
    if(left>right){
      if(left>nums.length-1){
        return nums.length;
      }

      if(right<0){
        return 0;
      }

      return left;
    }

    int tmp = (left+right)/2;
    if(nums[tmp]==target){
      return tmp;
    }else if(nums[tmp] > target){
      return this.searchInsert(nums, target, left, tmp-1);
    }else{
      return this.searchInsert(nums, target, tmp+1, right);
    }
  }
}