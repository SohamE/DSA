class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0;
        HashMap<Integer, Integer> store = new HashMap<>();
        int count = 0;
        store.put(0, 1);
        for (int num : nums) {
            prefixSum += num;
            if (store.containsKey(prefixSum - k)) {
                count = count + store.get(prefixSum - k);
            }
            store.put(prefixSum, store.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
