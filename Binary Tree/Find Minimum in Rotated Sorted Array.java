class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[r];
        while (l <= r) {
          // This means the whole segment is sorted.
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }

            int m = (l + r) / 2;
            min = Math.min(nums[m], min);
          // As the segment is not sorted, if m >= l that means the left portion is sorted with higher values.
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return min;
    }
}
