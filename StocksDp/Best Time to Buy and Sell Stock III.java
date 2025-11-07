class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }
        return dfs(1, 0, prices,2, dp);

    }

    public int dfs(int canBuy, int index, int[] prices, int cap, int[][][] dp) {
        if (index == prices.length || cap == 0)
            return 0;
        if (dp[index][canBuy][cap] != -1)
            return dp[index][canBuy][cap];
        int profit = Integer.MIN_VALUE;
        if (canBuy == 1) {
            int buy = (-1 * prices[index]) + dfs(0, index + 1, prices, cap, dp);
            int hold = dfs(1, index + 1, prices, cap, dp);
            profit = Math.max(buy, hold);
        } else {
            int sell = prices[index] + dfs(1, index + 1, prices, cap - 1, dp);
            int hold = dfs(0, index + 1, prices, cap, dp);
            profit = Math.max(sell, hold);
        }
        dp[index][canBuy][cap] = profit;
        return profit;
    }
}
