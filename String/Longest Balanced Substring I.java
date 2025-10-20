class Solution {

    public boolean equalDist(HashMap<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (char k : map.keySet()) {
            min = Math.min(min, map.get(k));
            max = Math.max(max, map.get(k));
        }
        return min == max;
    }

    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (equalDist(map)) {
                    ans = Math.max(j - i + 1, ans);
                }
            }
        }
        return ans;
    }

}©leetcode
