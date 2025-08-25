class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> store = new HashSet<>();
        while (n != 1) {
            if (store.contains(n))
                return false;
            store.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
        }
        return true;
    }
}
