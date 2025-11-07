class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++)
            Arrays.fill(dp[i], -1);
        return dfs(1, 0, prices, fee, dp);
    }

    public int dfs(int canBuy, int index, int[] prices, int fee, int[][] dp) {
        if (index == prices.length)
            return 0;
        if (dp[index][canBuy] != -1)
            return dp[index][canBuy];
        int profit = Integer.MIN_VALUE;
        if (canBuy == 1) {
            int buy = (-1 * prices[index]) + dfs(0, index + 1, prices, fee, dp);
            int hold = dfs(1, index + 1, prices,fee, dp);
            profit = Math.max(buy, hold);
        } else {
            int sell = prices[index] + dfs(1, index + 1, prices,fee, dp) -fee;
            int hold = dfs(0, index + 1, prices,fee, dp);
            profit = Math.max(sell, hold);
        }
        dp[index][canBuy] = profit;
        return profit;
    }
}
