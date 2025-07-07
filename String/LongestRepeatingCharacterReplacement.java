class Solution {
    public int characterReplacement(String s, int k) {
        int result = Integer.MIN_VALUE;
        Map<Character, Integer> store = new HashMap<>();
        int i = 0;
        int j = 0;
        int windowMax = Integer.MIN_VALUE;
        while (j < s.length()) {
            int charCount = 1;
            int windowLength = j - i + 1;
            if (store.containsKey(s.charAt(j))) {
                charCount = store.get(s.charAt(j)) + 1;
            }
            windowMax = Math.max(windowMax, charCount);
                store.put(s.charAt(j), charCount);
            if (windowLength - windowMax <= k) {
                result = Math.max(result, windowLength);
            } else {
                store.put(s.charAt(i), store.get(s.charAt(i)) - 1);
                i++;
            }
            j++;
        }

        return result;
    }
}
