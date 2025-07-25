class Solution {
    public List<List<String>> partition(String s) {
        List<String> subset = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        findPalindrome(0, s, subset, result);
        return result;
    }

    public void findPalindrome (int start, String s, List<String> subset, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(subset));
        }
        for (int partition=start;partition<s.length();partition++) {
            String partitionedString = s.substring(start, partition+1);
            if (isPalindrome(partitionedString)) {
                subset.add(partitionedString);
                findPalindrome(partition+1, s, subset, result);
                subset.remove(subset.size() - 1);
            }
        }
        return;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i<j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
