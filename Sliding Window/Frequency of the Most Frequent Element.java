class Solution {
    public int maxFrequency(int[] nums, int k) {
        int l = 0;
        int r = 0;
        long maxFreq = 0;
        long total = 0;
        Arrays.sort(nums);
        while (r < nums.length) {
            total += nums[r];
            // the window checks if all the nums int between l and r can be converted to target, If not reduce the window by moving l forward.
            while (nums[r] * (r - l + 1L) > total + k) {
                total -= nums[l];
                l++;
            }
            maxFreq = Math.max(maxFreq, r - l + 1L);
            r++;
        }
        return (int) maxFreq;
    }
}
