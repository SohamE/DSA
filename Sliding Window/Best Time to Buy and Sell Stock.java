class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;

        for (int price: prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;

    }
}
