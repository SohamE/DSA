class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return printLIS(nums);
    }
     public List<Integer> printLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] back = new int[n];
        int lastIndex = 0;
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int k = 0; k < n; k++) {
            back[k] = k;
            for (int prev = 0; prev < k; prev++) {
                if (nums[k] % nums[prev] == 0) {
                    if (1 + dp[prev] > dp[k]) {
                        dp[k] = 1 + dp[prev];
                        back[k] = prev;
                    }
                }
            }
            if (dp[k] > ans) {
                ans = dp[k];
                lastIndex = k;
            }
        }
        List<Integer> store = new ArrayList<>();
        for (int i = ans -1;i>=0;i--) {
            store.add(nums[lastIndex]);
            lastIndex = back[lastIndex];
        }
        return store;
    }
}
