class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++)
            Arrays.fill(dp[i], -1);
        return dfs(0, 0, s, p, dp);
    }

    public boolean dfs(int i, int j, String s, String p, int[][] dp) {
        if (i >= s.length() && j >= p.length())
            return true;
        if (j >= p.length())
            return false;
        if (p.charAt(j) != '*' && i >= s.length())
            return false;
// Focus on this condition
        if (i >= s.length()) {

            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if (dp[i][j] != -1)
            return dp[i][j] == 1 ? true : false;
        boolean a = false;
        if (p.charAt(j) == '*') {
            a = dfs(i + 1, j + 1, s, p, dp) || dfs(i + 1, j, s, p, dp) || dfs(i, j + 1, s, p, dp);
        } else if (p.charAt(j) == '?') {
            a = dfs(i + 1, j + 1, s, p, dp);
        } else {
            if (s.charAt(i) == p.charAt(j))
                a = dfs(i + 1, j + 1, s, p, dp);
        }
        dp[i][j] = a == true ? 1 : 0;
        return a;
    }
}
