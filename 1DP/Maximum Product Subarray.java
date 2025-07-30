// TC - n
class Solution {
    public int maxProduct(int[] nums) {
     int minp = nums[0];   
     int maxp = nums[0];
     int maxProduct = nums[0];   
     for (int i=1;i<nums.length;i++) {
        int num = nums[i];
        int temp = maxp;
        maxp = Math.max(Math.max(num, num * maxp), num * minp);
        minp = Math.min(Math.min(num, num * temp), num * minp);
        maxProduct = Math.max(maxProduct, maxp);
     }
     return maxProduct;
    }
}
