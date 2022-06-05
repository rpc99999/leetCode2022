package Contest294;

import java.util.HashMap;
import java.util.Map;

public class P3_20220605 {
  public int[] arrayChange(int[] nums, int[][] operations) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for(int i = 0 ; i< nums.length; i++){
        map.put(nums[i], i);
      }
      for(int i = 0 ; i < operations.length ; i++){
        int pos = map.get(operations[i][0]);
        map.remove(operations[i][0]);
        map.put(operations[i][1], pos);
        nums[pos] = operations[i][1];
      }
      return nums;
  }
}
