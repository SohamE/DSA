// ------------------ Memorize ------------------
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return maxSteps(0, n, dp);
    }

    public int maxSteps(int k, int n, int[] dp) {
        if (k == n)
            return 1;
        if (k >= n)
            return 0;
        if (dp[k] != -1)
            return dp[k];
        dp[k] = maxSteps(k + 1, n, dp) + maxSteps(k + 2, n, dp);
        return dp[k];
    }
}

// ------------------ Tabulation ------------------
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        Arrays.fill(dp, -1);
        dp[n] = 1;
        dp[n+1] = 0;
        for (int i=n-1;i>=0;i--) {
            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];
    }
}
