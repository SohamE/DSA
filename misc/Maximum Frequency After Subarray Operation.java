class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums)
            count += num == k ? 1 : 0;
        for (int i = 1; i <= 50; i++) {
            if (i == k)
                continue;
            int currMax = Integer.MIN_VALUE;
            int sum = 0;
            for (int num : nums) {
              // count number of time i present in nums, reduce 1 if current num = k because, if we take num == i as 1 to count the freq of the num, if we take the num we cannot take the num that is equal to k
                sum += (num == i) ? 1 : (num == k) ? -1 : 0;
                sum = Math.max(sum, 0);
                currMax = Math.max(currMax, sum);
            }
            max = Math.max(currMax, max);
        }
        return count + max;
    }
}

// [2,3,7,1,7]
// 1 to 50
//   i = 2
//   [1,0,-1,0,-1]
