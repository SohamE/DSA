class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        int rightMax = 0;
        int trappedWater = 0;
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        for (int i = n - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            trappedWater += Math.min(rightMax, leftMax[i]) - height[i];
        }
        return trappedWater;
    }
}
