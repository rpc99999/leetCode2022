package SegmentTree;

public class P307RangeSumQueryMutable {
  /*
   * Given an integer array nums, handle multiple queries of the following types:
   * 
   * 1. Update the value of an element in nums.
   * 2. Calculate the sum of the elements of nums between indices left and right
  *     inclusive where left <= right.
   */
  // Segment Tree
  // Update : O(LOG(N))
  // GetSum : O(LOG(N))

  // Normal Array
  // Update : O(1)
  // GetSum : O(N)

  // SubSumArray
  // Update : O(N)
  // GetSum : O(1)
  class NumArray {

    int[] nums;
    int[] segmentTree;

    public NumArray(int[] nums) {
      this.nums = nums;
      int height = (int) Math.ceil(Math.log(nums.length) / Math.log(2));
      int sgTreeSize = 2 * (int) (Math.pow(2, height) - 1);
      segmentTree = new int[sgTreeSize];

      this.build(segmentTree, nums, 0, nums.length - 1, 0);
    }

    public int build(int[] segmentTree, int[] nums, int fr, int to, int stIdx) {
      if (fr == to) {
        segmentTree[stIdx] = nums[fr];
        return segmentTree[stIdx];
      }

      int mid = (fr + to) / 2;

      segmentTree[stIdx] = this.build(segmentTree, nums, fr, mid, stIdx * 2 + 1)
          + this.build(segmentTree, nums, mid + 1, to, stIdx * 2 + 2);

      return segmentTree[stIdx];
    }

    public void update(int index, int val) {
      this.updateRecr(index, val, 0, nums.length - 1, 0);
    }

    public void updateRecr(int index, int val, int fr, int to, int stIdx) {
      if (index < fr || index > to) {
        return;
      }

      if (fr == to && index == fr) {
        nums[index] = val;
        segmentTree[stIdx] = val;
        return;
      }

      segmentTree[stIdx] -= nums[index];
      segmentTree[stIdx] += val;
      int mid = (fr + to) / 2;
      if (index <= mid) {
        this.updateRecr(index, val, fr, mid, stIdx * 2 + 1);
      } else {
        this.updateRecr(index, val, mid + 1, to, stIdx * 2 + 2);
      }
    }

    public int sumRange(int left, int right) {
      if (left == right) {
        return nums[left];
      }
      return this.sumRangeRecur(left, right, 0, nums.length - 1, 0);
    }

    public int sumRangeRecur(int left, int right, int fr, int to, int stIdx) {
      if (left <= fr && right >= to) {
        return segmentTree[stIdx];
      }

      if (right < fr || left > to) {
        return 0;
      }

      int mid = (fr + to) / 2;
      return this.sumRangeRecur(left, right, fr, mid, stIdx * 2 + 1)
          + this.sumRangeRecur(left, right, mid + 1, to, stIdx * 2 + 2);
    }
  }

  public static void main(String[] args) {
    P307RangeSumQueryMutable s = new P307RangeSumQueryMutable();
    NumArray numArray = s.new NumArray(new int[] { 0, 9, 5, 7, 3 });
    numArray.update(4, 5); // nums = [1, 2, 5]
    numArray.update(1, 7); // nums = [1, 2, 5]
    numArray.update(0, 8); // nums = [1, 2, 5]
    System.out.println(numArray.sumRange(1, 2));
  }
}
