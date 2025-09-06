class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return check(s, p, 0, 0, dp);
    }

    public boolean check(String s, String p, int a, int b, Boolean[][] dp) {
        if (dp[a][b] != null)
            return dp[a][b];

        if (a >= s.length() && b >= p.length())
            return true;

        if (b >= p.length())
            return false;

        if (a >= s.length()) {
            for (int i = b; i < p.length(); i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        boolean ret = false;
        if (p.charAt(b) == '*') {
            ret = check(s, p, a + 1, b, dp) || check(s, p, a, b + 1, dp);
        } else if (p.charAt(b) == '?' || s.charAt(a) == p.charAt(b)) {
            ret = check(s, p, a + 1, b + 1, dp);
        }
        dp[a][b] = ret;
        return ret;
    }
}
