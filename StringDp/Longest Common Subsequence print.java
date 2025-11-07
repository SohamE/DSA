class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int n = text1.length();
        int m = text2.length();
        for (int i = 0; i < text1.length(); i++)
            Arrays.fill(dp[i], -1);
        int ans = longestCommonSubsequence(text1, text2, 0, 0, dp);
        String lcs = "";
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (text1.charAt(i) == text2.charAt(j)) {
                lcs += text1.charAt(i);
                i++;
                j++;
            } else {
                int up = (i < n - 1) ? dp[i + 1][j] : 0;
                int left = (j < m - 1) ? dp[i][j + 1] : 0;
                if (up >= left) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return lcs;

    }

    public int longestCommonSubsequence(String a, String b, int i, int j, int[][] dp) {
        if (i > a.length() - 1 || j > b.length() - 1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int res = 0;
        if (a.charAt(i) == b.charAt(j)) {
            res = 1 + longestCommonSubsequence(a, b, i + 1, j + 1, dp);
        } else {
            res = Math.max(longestCommonSubsequence(a, b, i + 1, j, dp), longestCommonSubsequence(a, b, i, j + 1, dp));
        }
        dp[i][j] = res;
        return res;
    }
}
