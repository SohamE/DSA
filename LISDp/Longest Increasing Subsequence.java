class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int i=0;i<nums.length;i++)
            Arrays.fill(dp[i], -1);
        return findLength(0, -1, nums, dp);
    }

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
}
