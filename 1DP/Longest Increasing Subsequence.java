// TC - n^2
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int result = 0;
        Arrays.fill(dp, -1);
        result = findLength(0, nums, dp) ;
        for(int i=0;i<=nums.length;i++) {
            System.out.print(dp[i] + " ");
            result = Math.max(result, findLength(i, nums, dp));
        }
        return result;
    }

    public int findLength(int k, int[] nums, int[] dp) {
        if (dp[k] != -1)return dp[k];
        int max = 1;
        for (int i=k+1; i<nums.length;i++) {
            if (nums[i] > nums[k] ) {
                int res = findLength(i, nums, dp);
                if (res != Integer.MIN_VALUE) {
                    max = Math.max(max, res + 1);
                }
            }
        }
        dp[k] = max;
        return max;
    }
}
