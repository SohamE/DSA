class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, m, n, dp);
    }

    public int dfs(int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (i >= m || j >= n || i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        dp[i][j] = dfs(i + 1, j, m, n, dp) + dfs(i, j + 1, m, n, dp);
        return dp[i][j];
    }
}
