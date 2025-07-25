class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        List<Character> store = new ArrayList<>();
        Map<Character, String> ph = new HashMap<>();
        if (digits.length() == 0)
            return result;

        ph.put('2', "abc");
        ph.put('3', "def");
        ph.put('4', "ghi");
        ph.put('5', "jkl");
        ph.put('6', "mno");
        ph.put('7', "pqrs");
        ph.put('8', "tuv");
        ph.put('9', "wxyz");
        findComb(0, digits, result, store, ph);
        return result;

    }

    public void findComb(int k, String digits, List<String> result, List<Character> store, Map<Character, String> ph) {
        if (k == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c : store) {
                sb.append(c);
            }
            String res = sb.toString();
            result.add(res);
            return;
        }
        String curr = ph.get(digits.charAt(k));
        for (int i = 0; i < curr.length(); i++) {
            store.add(curr.charAt(i));
            findComb(k + 1, digits, result, store, ph);
            store.remove(store.size() - 1);
        }
        return;
    }
}
