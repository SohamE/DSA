class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int i=0;i<nums.length;i++)
            Arrays.fill(dp[i], -1);
        return findLength(0, -1, nums, dp);
    }

    // Memoization
    public int findLength(int k, int prevIndex, int[] nums, int[][] dp) {
        if (k > nums.length - 1)
            return 0;
        if (dp[k][prevIndex + 1] != -1) {
            return dp[k][prevIndex + 1];
        }
        int dontPick = findLength(k+1, prevIndex, nums, dp);
        int pick = Integer.MIN_VALUE;
        if (prevIndex == -1 || nums[prevIndex] < nums[k]) {
            pick = 1 + findLength(k+1, k, nums, dp);
        }
        int ans = Math.max(pick, dontPick);
        dp[k][prevIndex + 1] = ans;
        return ans;
    }
    
    public int tabFindLength(int[] nums, int[][] dp) {
        int n = nums.length;
        // reverse the indexes
        for (int k=n-1;k>=0;k--) {
            for (int prevIndex=k-1;prevIndex>=-1;prevIndex--) {
                // copy the recursion from memoization
                // change recursion with dp array and do index shifting based on dp store.
                int dontPick = dp[k+1][prevIndex + 1];
                int pick = Integer.MIN_VALUE;
                if (prevIndex == -1 || nums[prevIndex] < nums[k]) {
                    pick = 1 + dp[k+1][k + 1];
                }
                dp[k][prevIndex + 1] = Math.max(pick, dontPick);
            }
        }
        return dp[0][0];
    }

    // Space optmized O(n)
    public int spaceOpt(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int k=0;k<n;k++) {
            for (int prev=0;prev<k;prev++){
                if (nums[prev] < nums[k]) {
                    dp[k] = Math.max(dp[k], 1 + dp[prev]);
                }
            }
            ans = Math.max(ans, dp[k]);
        }
        return ans;
    }
    

    
}
