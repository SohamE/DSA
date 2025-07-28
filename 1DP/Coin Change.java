class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int result = minChange(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int minChange(int[] coins, int amount, int[] dp) {
        if (amount == 0)
            return 0;
        if (dp[amount] != -1) return dp[amount];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int newAmount = amount - coins[i];
            if (newAmount >= 0) {
              // we cannot add 1 to minChange() as if minChange() returns Integer.MAX_VALUE and 1 is added to it, the result becomes Integer.MIN_VALUE which hinders with the Math.min function.
                int res = Math.min(min,minChange(coins, newAmount, dp));
                if (res != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + res);
                }
            }
        }
        dp[amount] = min;
        return min;
    }
}
