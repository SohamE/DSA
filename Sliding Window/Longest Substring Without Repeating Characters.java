class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charList = new HashSet<>();
        int result = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (charList.contains(s.charAt(j))) {
                while (s.charAt(i) != s.charAt(j)) {
                    charList.remove(s.charAt(i));
                    i++;
                }
                i++;
            } else {
                charList.add(s.charAt(j));
                result = Math.max(result, charList.size());
            }
            j++;
        }
        return result;
    }
}
