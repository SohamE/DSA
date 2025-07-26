// ------------------ Memorize ------------------
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(dave(nums, 1, dp1, n), nums[0] + dave(nums, 2, dp2, n - 1));
    }

    public int dave(int[] nums, int k, int[] dp, int len) {
        if (k >= len)
            return 0;
        if (dp[k] != -1)
            return dp[k];
        dp[k] = Math.max(nums[k] + dave(nums, k + 2, dp, len), dave(nums, k + 1, dp, len));
        return dp[k];
    }
}
