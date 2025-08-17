class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            int count = charCount.containsKey(c) ? charCount.get(c) + 1 : 1;
            charCount.put(c, count);
            max = Math.max(max, count);
            int segmentLength = j - i + 1;
            int diff = segmentLength - max;
            if (diff > k) {
                // @TODO: while reducing char count why we are not reducing max ? 
                charCount.put(s.charAt(i), charCount.get(s.charAt(i)) - 1);
                i++;
            } else {
                result = Math.max(result, segmentLength);
            }
            j++;
        }
        return result;
    }
}
