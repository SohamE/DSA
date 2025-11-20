class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] newCuts = new int[len + 2];
        int[][] dp = new int[len+2][len+2];
        for (int i=0;i<len+2;i++)
            Arrays.fill(dp[i], -1);
        newCuts[0] = 0;
        newCuts[len + 1] = n;
        for (int i = 1; i <= len; i++)
            newCuts[i] = cuts[i - 1];
        Arrays.sort(newCuts);
        return dfs(1, len, newCuts, dp);
    }

    public int dfs(int i, int j, int[] cuts, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int minCostSub = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1] + dfs(i, k - 1, cuts, dp) + dfs(k + 1, j, cuts, dp);
            minCostSub = Math.min(minCostSub, cost);
        }
        dp[i][j] = minCostSub;
        return minCostSub;
    }
}
