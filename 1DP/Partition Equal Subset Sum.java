class Solution {
    public boolean canPartition(int[] nums) {
        int t = 0;
        for (int num : nums)
            t += num;
        if (t % 2 != 0)
            return false;
        boolean[][] dp = new boolean[nums.length + 1][t / 2 + 1];
        for (int i = 0; i < nums.length; i++)
            Arrays.fill(dp[i], true);
        return findPart(nums, t / 2, 0, dp);
    }

    public boolean findPart(int[] nums, int t, int i, boolean[][] dp) {
        if (t == 0)
            return true;
        if (t < 0 || i >= nums.length)
            return false;
        if (dp[i][t] != true)
            return dp[i][t];
        dp[i][t] = findPart(nums, t - nums[i], i + 1, dp) || findPart(nums, t, i + 1, dp);
        return dp[i][t];
    }
}
