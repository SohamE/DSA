class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0;
        int maxWeight = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int weight : weights) {
            totalWeight += weight;
            maxWeight = Math.max(maxWeight, weight);

        }
      // if we take lower bound as weight less than max weight we can never load all cargo.
        int l = maxWeight;
        int r = totalWeight;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            int sum = 0;
            int d = 0;
            for (int weight : weights) {
                if (sum + weight > mid) {
                    d++;
                    sum = 0;
                }
                sum += weight;
            }
            d++;
            if (d <= days) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
