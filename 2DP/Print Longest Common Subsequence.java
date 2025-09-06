public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
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

        int i = 0;
        int j = 0;
        String s = "";
        while (i < n && j < m) {
            if (i < n && j < m && s1.charAt(i) == s2.charAt(j)) {
                s += s1.charAt(i);
                i++;
                j++;
            } else {
                if (dp[i + 1][j] > dp[i][j + 1])
                    i++;
                else
                    j++;
            }
        }
        return s;
    }
}
