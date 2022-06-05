package Contest294;

import java.util.Arrays;

public class P2_20220605 {
  public static int partitionArray(int[] nums, int k) {
      Arrays.sort(nums);
      int l = 0;
      int r = 0;
      int result = 0;
      while(r<nums.length){
        if(nums[r]-nums[l]>k){
          l=r;
          result++;
        }
        r++;
      }
      return result+1;
  }


  public static void main(String[] args){
    System.out.println("sadfsad");
    partitionArray(new int[]{1,2,3}, 1);
    //partitionArray(new int[]{16}, 0);
  }
}
