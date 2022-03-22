public class P152_Maximum_Product_Subarray {

  public static int maxProduct1(int[] nums) {
        // Brute force solution
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            int tmp = nums[i];
            maxProduct = Math.max(maxProduct, tmp);
          for(int j = i+1; j<nums.length; j++){
            tmp *= nums[j];
            maxProduct = Math.max(maxProduct, tmp);
          }
        }
        return maxProduct;
  }

  public static int maxProduct2(int[] nums){      //Kadane's theory , O(N) time, O(N) space
        int[] maxProductSubarray = new int[nums.length];
        int[] minProductSubarray = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i==0){
              maxProductSubarray[0] = nums[i];
              minProductSubarray[0] = nums[i];
            }else{
              if(minProductSubarray[i-1]==0){
                maxProductSubarray[i] = nums[i];
                minProductSubarray[i] = nums[i];
              }else{
              maxProductSubarray[i] = Math.max(Math.max(minProductSubarray[i-1]*nums[i], maxProductSubarray[i-1]*nums[i]), nums[i]);
              minProductSubarray[i] = Math.min(Math.min(minProductSubarray[i-1]*nums[i], maxProductSubarray[i-1]*nums[i]), nums[i]);
              }
            }
        }
        
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0 ; i< nums.length; i++){
            maxProduct = Math.max(maxProduct, maxProductSubarray[i]);
        }
        return maxProduct;
  }

  public static int maxProduct(int[] nums){    // More smart way and better solution, O(N) Time, O(1) Space
    int result = nums[0];
    int leftProduct = 0;
    int rightProduct = 0;
    for(int i = 0 ; i < nums.length ; i++){
      leftProduct = (leftProduct==0 ? 1 : leftProduct) * nums[i];
      rightProduct = (rightProduct==0 ? 1 : rightProduct) * nums[nums.length-1-i];
      result = Math.max(result, Math.max(leftProduct, rightProduct));
    }
    return result;
  }

  public static void main(String[] args){
    System.out.println(maxProduct(new int[]{3,-1,4}));
  }
}
