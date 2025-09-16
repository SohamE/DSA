class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)
            Arrays.fill(dp[i], -1);
        return dfs(s, t, 0, 0, dp);
    }

    public int dfs(String s, String t, int i, int j, int[][] dp) {
        if (j >= t.length())
            return 1;
        if (j <= t.length() && i >= s.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int res = 0;
        if (s.charAt(i) == t.charAt(j))
            res += dfs(s, t, i + 1, j + 1, dp);
        res += dfs(s, t, i + 1, j, dp);
        return dp[i][j] = res;
    }
}
