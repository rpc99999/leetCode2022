package leetCode2022.Two_Pointers;

public class P977 {
  /*
   * 977. Squares of a Sorted Array
   * Given an integer array nums sorted in non-decreasing order, return an array
   * of the squares of each number sorted in non-decreasing order.
   */
  public int[] sortedSquares(int[] nums) {
    int left_ptr = 0;
    int right_ptr = nums.length-1;
    int[] result = new int[nums.length];
    int tmp = nums.length-1;
    while(left_ptr<=right_ptr){
      if(Math.multiplyExact(nums[left_ptr], nums[left_ptr]) > Math.multiplyExact(nums[right_ptr], nums[right_ptr])){
        result[tmp] = Math.multiplyExact(nums[left_ptr], nums[left_ptr]);
        left_ptr++;
      }else{
        result[tmp] = Math.multiplyExact(nums[right_ptr], nums[right_ptr]);
        right_ptr--;
      }
      tmp--;
    }
    return result;
  }
}
