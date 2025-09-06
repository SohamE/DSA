class Solution {
    public int longestPalindromeSubseq(String s1) {
        String s2 = "";
        for (int i=s1.length()-1;i>=0;i--)
            s2 += s1.charAt(i);
        // Longest common subsequence.
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

// Note: longest common subsequence between a string and it's reverse is longest palindromic subsequence.
