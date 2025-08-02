// Memoization
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++)
            Arrays.fill(dp[i], -1);
        return dfs(amount, coins, 0, dp);
    }

    public int dfs(int amount, int[] coins, int k, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (dp[k][amount] != -1)
            return dp[k][amount];
        int res = 0;
        for (int i = k; i < coins.length; i++) {
            int coin = coins[i];
            int newAmount = amount - coin;
            if (newAmount >= 0) {
                res += dfs(newAmount, coins, i, dp);
            }
        }
        dp[k][amount] = res;
        return res;
    }
}
// Tabulation
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;  // One way to make amount 0 (take no coins)

        for (int coin : coins) {
            for (int a = coin; a <= amount; a++) {
                dp[a] += dp[a - coin];
            }
        }

        return dp[amount];
    }
}
