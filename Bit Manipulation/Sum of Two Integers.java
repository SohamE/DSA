class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = a ^ b;
            b = (temp & b) << 1;
        }
        return a;
    }
}

// b!=0 should be the condition instead of b > 0, as b can be negative and we have to loop till carry is 0;
