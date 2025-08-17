class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            // If the whole segment is sorted, apply simple binary tree
            if (nums[l] < nums[r]) {
                if (target > nums[m])
                    l = m + 1;
                if (target < nums[m])
                    r = m - 1;
            } else {
                // if left segment is sorted
                if (nums[m] >= nums[l]) {
                    // if the target falls in the left segment, make l & r to that.
                    if (target < nums[m] && target >= nums[l]) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                // right segment is sorted.
                } else {
                    // if the target falls in right segment, make l & r to that.
                    if (target > nums[m] && target <= nums[r]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
            }
        }

        return -1;
    }
}
