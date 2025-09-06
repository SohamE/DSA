class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return dfs(0, 0, text1, text2, dp);
    }

    public int dfs(int i, int j, String text1, String text2, int[][] dp) {
        int ret = 0;
        if (i >= text1.length() || j >= text2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            ret = 1 + dfs(i + 1, j + 1, text1, text2, dp);
        } else {
            ret = Math.max(dfs(i + 1, j, text1, text2, dp), dfs(i, j + 1, text1, text2, dp));
        }
        dp[i][j] = ret;
        return ret;
    }
}


// Tabulation
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[n][m] = 0;
        dp[n - 1][m] = 0;
        dp[n][m - 1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
