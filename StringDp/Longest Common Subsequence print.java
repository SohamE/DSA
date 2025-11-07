class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int n = text1.length();
        int m = text2.length();
        for (int i = 0; i < text1.length(); i++)
            Arrays.fill(dp[i], -1);
        String lcs = "";
        int i = n - 1;
        int j = m - 1;
        while (i >= 0 && j >= 0) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    lcs += text1.charAt(i);
                    i--;
                    j--;
                } else {
                    if (i < 1 || j < 1)
                        break;
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        j--;
                    } else {
                        i--;
                    }
                }
        }
      return lcs;
    }

    public int dfs(String a, String b, int i, int j, int[][] dp) {
        if (i > a.length() - 1 || j > b.length() - 1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int res = 0;
        if (a.charAt(i) == b.charAt(j)) {
            res = 1 + dfs(a, b, i + 1, j + 1, dp);
        } else {
            res = Math.max(dfs(a, b, i + 1, j, dp), dfs(a, b, i, j + 1, dp));
        }
        dp[i][j] = res;
        return res;
    }
}
