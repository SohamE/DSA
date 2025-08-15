// Notes:
// 1. To unset right most bit from 1 to 0, n & (n-1)
// 2. To find ith bit, (num >> i) & i ? 1 : 0


// Approach 1. TC - O(32)

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1)
                count++;
        }
        return count;
    }
}
  
// Approach 2. TC - O(k) - k -> number of set bit.
  
class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n -1);
            count++;
        }
        return count;
    }
}

// Approach 3 - by finding binary counterpart. TC - O(logn)

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1)
                count++;
            n = n / 2;
        }
        return count;
    }
}

// Approach 4 - built in func. TC - O(n)

class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
