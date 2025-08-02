class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int high = 0;
        for (int num : nums) {
            high += num;
        }
        int[][] dp = new int[nums.length + 1][2 * high + 1];
        for (int i = 0; i < nums.length; i++)
            Arrays.fill(dp[i], -1);
        return dfs(0, 0, nums, target, dp, high);
    }

    public int dfs(int i, int sum, int[] nums, int target, int[][] dp, int high) {
        int j = sum + high;
        if (i == nums.length) {
            if (sum == target)
                return 1;
            else
                return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        dp[i][j] = dfs(i + 1, sum - nums[i], nums, target, dp, high)
                + dfs(i + 1, sum + nums[i], nums, target, dp, high);
        return dp[i][j];
    }
}
