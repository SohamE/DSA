class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for(int i=0;i<=prices.length;i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return dfs(0, prices, "SELL", dp);
    }

    public int dfs(int i, int[] prices, String action, int[][] dp) {
        if (i >= prices.length)
            return 0;
        int j = action == "BUY" ? 1 : 0;
        if (dp[i][j] != -1) return dp[i][j];
        int res = 0;
        int a = 0;
        int b = 0;
        if (action == "BUY") {
            if (i == prices.length - 1)
                return prices[i];
            // sell the stock and add cooldown
            a = prices[i] + dfs(i+2, prices, "SELL", dp);
            // cooldown
            b = dfs(i+1, prices, "BUY", dp);
        }
        if (action == "SELL") {
            if (i == prices.length - 1)
                return 0;
            // buy stock
            a = (-1 * prices[i]) + dfs(i+1, prices, "BUY", dp);
            // cooldown
            b = dfs(i+1, prices, "SELL", dp);
        }
        dp[i][j] = Math.max(a, b);
        return dp[i][j];
    }
}
