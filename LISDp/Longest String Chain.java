class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        return spaceOpt(words);
    }

    public int spaceOpt(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int k = 0; k < n; k++) {
            for (int prev = 0; prev < k; prev++) {
                if (compareString(words[prev], words[k])) {
                    dp[k] = Math.max(dp[k], 1 + dp[prev]);
                }
            }
            ans = Math.max(ans, dp[k]);
        }
        return ans;
    }

    public boolean compareString(String s2, String s1) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }
}
