class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int i = 0;
        int len = Integer.MAX_VALUE;
        int total = 0;
        while (j < nums.length) {
            if (total < target) {
                total += nums[j++];
            } else if (total >= target) {
                len = Math.min(len, j - i + 1);
                total -=  nums[i++];
            }
        }
        while (total >= target) {
                len = Math.min(len, j - i + 1);
                total -=  nums[i++];
        }
        return len == Integer.MAX_VALUE ? 0 : len- 1 ;
    }
}
