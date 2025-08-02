class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++)
            Arrays.fill(dp[i], -1);
        return dfs(word1, word2, 0, 0, dp);
    }

    public int dfs(String word1, String word2, int i, int j, int[][] dp) {
        if (i >= word1.length() && j >= word2.length()) {
            return 0;
        }
        if (i >= word1.length())
            return word2.length() - j; // Insert all remaining chars
        if (j >= word2.length())
            return word1.length() - i; // Delete all remaining chars
        if (dp[i][j] != -1)
            return dp[i][j];
        int ret = 0;
        if (word1.charAt(i) == word2.charAt(j)) {
            ret = dfs(word1, word2, i + 1, j + 1, dp);
        } else {
            ret = 1 + Math.min(Math.min(dfs(word1, word2, i + 1, j + 1, dp), dfs(word1, word2, i + 1, j, dp)),
                    dfs(word1, word2, i, j + 1, dp));
        }
        dp[i][j] = ret;
        return ret;
    }
}
