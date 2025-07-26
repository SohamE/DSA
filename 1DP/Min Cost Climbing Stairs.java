// ------------------ Memorize ------------------
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return Math.min(minCost(0, cost, dp), minCost(1, cost, dp));
    }

    public int minCost(int k, int[] cost, int[] dp) {
        if (k >= cost.length)
            return 0;
        if (dp[k] != -1) return dp[k];
        dp[k] = cost[k] + Math.min(minCost(k + 1, cost, dp), minCost(k + 2, cost, dp));
        return dp[k];
    }
}

// ------------------ Tabulation ------------------
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+2];
        Arrays.fill(dp, -1);
        dp[n] = 0;
        dp[n-1] = cost[n-1];
        for (int i = n-2;i>=0;i--){
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}
