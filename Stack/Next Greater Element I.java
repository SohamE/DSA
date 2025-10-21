class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> store = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!store.isEmpty() && store.peek() < num) {
                map.put(store.pop(), num);
            }
            store.add(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            if (map.containsKey(num)) {
                nums1[i] = map.get(num);
            } else {
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}
