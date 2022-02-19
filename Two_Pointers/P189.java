package leetCode2022.Two_Pointers;

public class P189 {
  public void rotate(int[] nums, int k) {
    /*
     * 189. Rotate Array
     * 
     * Given an array, rotate the array to the right by k steps, where k is
     * non-negative.
     */
    int count = k % nums.length;  // to reduce value of k
    
    /*
    suppose list {1,2,3,...,n-k,...,n-1,n}
    we need to make process so that the result would be
    {n-k+1, n-k+2,....,n,1,2,3,...., n-k}
    // Space : O(N)
    // Time  : O(N)
    */

    int[] tmp = new int[count];   // to store {n-k+1,n-k+2,...n}
    for(int i = 0; i < count; i++){
      tmp[count-1-i] = nums[nums.length-1-i];
    }

    for(int i = 0; i < nums.length-count; i++){   // to move {1,2,3...,n-k} to the tail
      nums[nums.length-1-i] = nums[nums.length-1-count-i];
    }

    // to put the {n-k+1, n-k+2, ... n} to the head
    for(int i = 0; i < tmp.length ; i++){
      nums[i] = tmp[i];
    }

  }

  public void rotate_optium(int[] nums, int k){
    // Space : O(1)
    // Time  : O(N)
    k = k%nums.length;
    this.swap(nums, 0, nums.length-1);  //reverse whole array
    this.swap(nums, 0, k-1);              //reverse the sub-array from 1th to kth
    this.swap(nums, k, nums.length-1);//revesre the remaining sub-array
  }

  public void swap(int[] nums, int left, int right){
    while(left<right){
        int swap = nums[left];
        nums[left] = nums[right];
        nums[right] = swap;
        left++;
        right--;
    }
  }

  public static void main(String[] args) {
    P189 t= new P189();
    int[] nums = new int[]{-1};
    int k = 2;
    t.rotate_optium(nums, k);
    System.out.println();
  }
}
