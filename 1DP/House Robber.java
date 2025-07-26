// ------------------ Memorize ------------------
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return dave(nums, 0, dp);
    }

    public int dave(int[] nums, int k, int[] dp) {
        if (k >= nums.length)
            return 0;
        if (dp[k] != -1)
            return dp[k];
        dp[k] = Math.max(nums[k] + dave(nums, k + 2, dp), dave(nums, k + 1, dp));
        return dp[k];
    }
}

// ------------------ Tabulation ------------------
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n <= 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n - 1] = nums[n - 1];
        dp[n] = 0;
        for (int k = n - 2; k >= 0; k--) {
            dp[k] = Math.max(nums[k] + dp[k + 2], dp[k + 1]);
        }
        return dp[0];
    }
}
