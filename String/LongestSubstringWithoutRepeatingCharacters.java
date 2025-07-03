class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> store = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = Integer.MIN_VALUE;
        if (s.length() == 0)
            return 0;
        while (j < s.length()) {
            if (store.containsKey(s.charAt(j))) {
                i = Math.max(i, store.get(s.charAt(j)) + 1);
            }
            store.put(s.charAt(j), j);
            j++;
            maxLength = Math.max(maxLength, j - i);
        }

        return maxLength;
    }
}
