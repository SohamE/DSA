class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i=0;i<32;i++) {
            if (((n >> i) & 1) == 1) {
                int index = 31 - i;
                // Shifting 1 to that specific index and then doing the or
                //ans : 1000, index: 1
                // ans = 1000 | (0010) (1 moved left by 1 index); 
                ans |= 1 << index;
            }
        }
        return ans;
    }
}
