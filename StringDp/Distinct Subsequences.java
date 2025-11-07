class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int i=0;i<s.length();i++)
            Arrays.fill(dp[i], -1);
        return dfs(0, 0, s, t, dp);
    }

    public int dfs(int i, int j, String s, String t, int[][] dp) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int a = dfs(i+1, j, s, t, dp);
        int b = 0;
        if (s.charAt(i) == t.charAt(j))
            b = dfs(i+1, j+1, s, t, dp);
        dp[i][j] = a + b;
        return a + b;
    }
}
